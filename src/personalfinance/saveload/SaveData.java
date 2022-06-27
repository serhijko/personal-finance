package personalfinance.saveload;

import personalfinance.exception.ModelException;
import personalfinance.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class SaveData {

    private static SaveData instance;
    private List<Account> accounts = new ArrayList<>();
    private List<Article> articles = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();
    
    private final Filter filter;
    private Common oldCommon;
    private boolean saved = true;

    private SaveData() {
        load();
        filter = new Filter();
    }

    public void load() {
        SaveLoad.load(this);
        sort();
    }

    private void sort() {
        accounts.sort((a1, a2) -> a1.getTitle().compareToIgnoreCase(a2.getTitle()));
        articles.sort((a1, a2) -> a1.getTitle().compareToIgnoreCase(a2.getTitle()));
        currencies.sort((c1, c2) -> {
            if (c1.isBase()) return -1;
            if (c2.isBase()) return 1;
            if (c1.isOn() ^ c2.isOn()) {
                if (c2.isOn()) return 1;
                else return -1;
            }
            return c1.getTitle().compareToIgnoreCase(c2.getTitle());
        });
        transactions.sort((t1, t2) -> t2.getDate().compareTo(t1.getDate()));
        transfers.sort((t1, t2) -> t2.getDate().compareTo(t1.getDate()));
    }

    public void save() {
        SaveLoad.save(this);
        saved = true;
    }

    public boolean isSaved() {
        return saved;
    }

    public Filter getFilter() {
        return filter;
    }

    public static SaveData getInstance() {
        if (instance == null) instance = new SaveData();
        return instance;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Currency getBaseCurrency() {
        for (Currency currency : currencies)
            if (currency.isBase()) return currency;
        return new Currency();
    }

    public ArrayList<Currency> getEnabledCurrencies() {
        ArrayList<Currency> enabledCurrencies = new ArrayList<>();
        for (Currency currency : currencies)
            if (currency.isOn()) enabledCurrencies.add(currency);
        return enabledCurrencies;
    }

    public List<Transaction> getFilteredTransactions() {
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions)
            if (filter.check(transaction.getDate())) filteredTransactions.add(transaction);
        return filteredTransactions;
    }

    public List<Transfer> getFilteredTransfers() {
        ArrayList<Transfer> filteredTransfers = new ArrayList<>();
        for (Transfer transfer : transfers)
            if (filter.check(transfer.getDate())) filteredTransfers.add(transfer);
        return filteredTransfers;
    }

    public List<Transaction> getTransactionsOnCount(int count) {
        return new ArrayList<>(transactions.subList(0, Math.min(count, transactions.size())));
    }

    public Common getOldCommon() {
        return oldCommon;
    }

    public void add(Common common) throws ModelException {
        List ref = getRef(common);
        if (ref.contains(common)) throw new ModelException(ModelException.IS_EXISTS);
        ref.add(common);
        common.postAdd(this);
        sort();
        saved = false;
    }

    public void edit(Common oldCommon, Common newCommon) throws ModelException {
        List ref = getRef(oldCommon);
        if (ref.contains(newCommon) && oldCommon != ref.get(ref.indexOf(newCommon))) {
            throw new ModelException(ModelException.IS_EXISTS);
        }
        ref.set(ref.indexOf(oldCommon), newCommon);
        this.oldCommon = oldCommon;
        newCommon.postEdit(this);
        sort();
        saved = false;
    }

    public void remove(Common common) {
        getRef(common).remove(common);
        common.postRemove(this);
        saved = false;
    }

    private List getRef(Common common) {
        if (common instanceof Account) return accounts;
        else if (common instanceof Article) return articles;
        else if (common instanceof Currency) return currencies;
        else if (common instanceof Transaction) return transactions;
        else if (common instanceof Transfer) return transfers;
        else return null;
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "accounts=" + accounts +
                ", articles=" + articles +
                ", currencies=" + currencies +
                ", transactions=" + transactions +
                ", transfers=" + transfers +
                '}';
    }
}
