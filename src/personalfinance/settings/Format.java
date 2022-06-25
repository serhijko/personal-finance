package personalfinance.settings;

import personalfinance.model.Currency;
import personalfinance.model.Filter;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Format {

    public static String yesNo(boolean yes) {
        return Text.get(yes ? Text.YES : Text.NO);
    }

    public static double amount(String amount) throws NumberFormatException {
        return Double.parseDouble(amount.replaceAll(",", "."));
    }

    public static String amount(double amount) {
        return String.format(Settings.AMOUNT_FORMAT, amount);
    }

    public static String amount(double amount, Currency currency) {
        return amount(amount) + " " + currency.getCode();
    }

    public static String rate(double amount) {
        return String.format(Settings.RATE_FORMAT, amount);
    }

    public static String rate(double rate, Currency currency) {
        return rate(rate) + " " + currency.getCode();
    }

    public static String getTitleFilter(Filter filter) {
        Date date = filter.getTo();
        switch (filter.getStep()) {
            case Filter.STEP_DAY:
                return fullDate(date);
            case Filter.STEP_MONTH:
                return monthYear(date);
            case Filter.STEP_YEAR:
                return yearOnly(date);
        }
        return null;
    }

    public static String fullDate(Date date) {
        return dateFormat(Settings.FULL_DATE_FORMAT, date);
    }

    public static String monthYear(Date date) {
        return dateFormat(Settings.MONTH_YEAR_FORMAT, date);
    }

    public static String yearOnly(Date date) {
        return dateFormat(Settings.YEAR_ONLY_FORMAT, date);
    }

    private static String dateFormat(String dateFormat, Date date) {
        String locale = Settings.getLocale();
        SimpleDateFormat sdf;
        if (locale.equals("be") || locale.equals("ru") || locale.equals("uk") || locale.equals("fr")) {
            sdf = new SimpleDateFormat(dateFormat, new MainDateFormatSymbols());
        } else {
            sdf = new SimpleDateFormat(dateFormat);
        }
        return sdf.format(date);
    }

    private static class MainDateFormatSymbols extends DateFormatSymbols {

        @Override
        public String[] getMonths() {
            System.out.println(Settings.getLocale());
            if (Settings.getLocale().equals("fr")) {
                String[] months = DateFormatSymbols.getInstance().getMonths();
                for (int i = 0; i <= 11; i++) {
                    months[i] = months[i].substring(0, 1).toUpperCase() + months[i].substring(1);
                }
                return months;
            } else {
                return Text.getMonths();
            }
        }
    }
}
