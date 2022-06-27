package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

import java.util.List;
import java.util.Objects;

public class Account extends Common {

    private String title;
    private Currency currency;
    private double amount;

    public Account(String title, Currency currency, double amount) throws ModelException {
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (currency == null) throw new ModelException(ModelException.CURRENCY_EMPTY);
        this.title = title;
        this.currency = currency;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.amount, amount) == 0 && Objects.equals(title, account.title) && Objects.equals(currency, account.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }

    public void setAmountFromTransactionsAndTransfers(List<Transaction> transactions, List<Transfer> transfers) {
        for (Transaction transaction : transactions) {
            if (transaction.getAccount().equals(this)) {
                amount += transaction.getAmount();
            }
        }
        for (Transfer transfer : transfers) {
            if (transfer.getFromAccount().equals(this)) {
                amount -= transfer.getFromAmount();
            }
            if (transfer.getToAccount().equals(this)) {
                amount += transfer.getToAmount();
            }
        }
    }

    @Override
    public void postAdd(SaveData saveData) {
        setAmountFromTransactionsAndTransfers(saveData.getTransactions(), saveData.getTransfers());
    }

    @Override
    public void postEdit(SaveData saveData) {
        for (Transaction transaction : saveData.getTransactions())
            if (transaction.getAccount().equals(saveData.getOldCommon())) transaction.setAccount(this);
        for (Transfer transfer : saveData.getTransfers()) {
            if (transfer.getFromAccount().equals(saveData.getOldCommon())) transfer.setFromAccount(this);
            if (transfer.getToAccount().equals(saveData.getOldCommon())) transfer.setToAccount(this);
        }
        setAmountFromTransactionsAndTransfers(saveData.getTransactions(), saveData.getTransfers());
    }
}
