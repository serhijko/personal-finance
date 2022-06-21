package personalfinance.model;

import personalfinance.saveload.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {

    public static double getBalanceByCurrency(Currency currency) {
        SaveData saveData = SaveData.getInstance();
        double amount = 0;
        for (Account account : saveData.getAccounts())
            if (currency.equals(account.getCurrency())) amount += account.getAmount();
        return amount;
    }

    public static double getTotalBalance(Currency currency) {
        SaveData saveData = SaveData.getInstance();
        double amount = 0;
        for (Account account : saveData.getAccounts())
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        return amount;
    }

    public static HashMap<String, Double> getDataForChartOnIncomeArticles() {
        return getDataForChartOnArticles(true);
    }

    public static HashMap<String, Double> getDataForChartOnExpArticles() {
        return getDataForChartOnArticles(false);
    }

    private static HashMap<String, Double> getDataForChartOnArticles(boolean income) {
        List<Transaction> transactions = SaveData.getInstance().getTransactions();
        HashMap<String, Double> data = new HashMap<>();
        for (Transaction transaction : transactions) {
            if ((income && transaction.getAmount() > 0) || (!income && transaction.getAmount() < 0)) {
                String key = transaction.getArticle().getTitle();
                double sum = 0;
                double amount = transaction.getAmount();
                if (!income) amount *= -1;
                if (data.containsKey(key)) sum = data.get(key);
                sum += amount * transaction.getAccount().getCurrency().getRateByCurrency(
                        SaveData.getInstance().getBaseCurrency()
                );
                data.put(key, round(sum));
            }
        }
        return data;
    }

    private static double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}
