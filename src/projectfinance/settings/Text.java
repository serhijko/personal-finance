package projectfinance.settings;

import java.util.HashMap;

public class Text {

    public static final HashMap<String, String> data = new HashMap<>();

    public static final String PROGRAM_NAME = "PROGRAM_NAME";

    public static final String MENU_FILE = "MENU_FILE";
    public static final String MENU_EDIT = "MENU_EDIT";
    public static final String MENU_VIEW = "MENU_VIEW";
    public static final String MENU_HELP = "MENU_HELP";

    public static final String ERROR_TITLE_EMPTY = "ERROR_TITLE_EMPTY";
    public static final String ERROR_IS_EXISTS = "ERROR_IS_EXISTS";
    public static final String ERROR_DATE_FORMAT = "ERROR_DATE_FORMAT";
    public static final String ERROR_CODE_EMPTY = "ERROR_CODE_EMPTY";
    public static final String ERROR_CURRENCY_EMPTY = "ERROR_CURRENCY_EMPTY";
    public static final String ERROR_ARTICLE_EMPTY = "ERROR_ARTICLE_EMPTY";
    public static final String ERROR_ACCOUNT_EMPTY = "ERROR_ACCOUNT_EMPTY";
    public static final String ERROR_RATE_INCORRECT = "ERROR_RATE_INCORRECT";
    public static final String ERROR_AMOUNT_FORMAT = "ERROR_AMOUNT_FORMAT";
    public static final String ERROR_NO_BASE_CURRENCY = "ERROR_NO_BASE_CURRENCY";

    public static String get(String key) {
        return data.get(key);
    }

    public static String[] getMonths() {
        String[] months = new String[12];
        months[0] = get("JAN");
        months[1] = get("FEB");
        months[2] = get("MAR");
        months[3] = get("APR");
        months[4] = get("MAY");
        months[5] = get("JUN");
        months[6] = get("JUL");
        months[7] = get("AUG");
        months[8] = get("SEP");
        months[9] = get("OCT");
        months[10] = get("NOV");
        months[11] = get("DEC");
        return months;
    }

    public static void init() {
        data.put(PROGRAM_NAME, "Дамашняя бухгальтэрыя");
        data.put(MENU_FILE, "Файл");
        data.put(MENU_EDIT, "Праўка");
        data.put(MENU_VIEW, "Выгляд");
        data.put(MENU_HELP, "Дапамога");

        data.put("JAN", "Студзень");
        data.put("FEB", "Люты");
        data.put("MAR", "Сакавік");
        data.put("APR", "Красавік");
        data.put("MAY", "Травень");
        data.put("JUN", "Чэрвень");
        data.put("JUL", "Ліпень");
        data.put("AUG", "Жнівень");
        data.put("SEP", "Верасень");
        data.put("OCT", "Кастрычнік");
        data.put("NOV", "Лістапад");
        data.put("DEC", "Сьнежань");

        data.put(ERROR_TITLE_EMPTY, "Вы не ўвялі назву!");
        data.put(ERROR_IS_EXISTS, "Такі запіс ня йснуе!");
        data.put(ERROR_DATE_FORMAT, "Некарэктны фармат даты!");
        data.put(ERROR_CODE_EMPTY, "Вы не ўказалі код!");
        data.put(ERROR_CURRENCY_EMPTY, "Вы ня выбралі валюту!");
        data.put(ERROR_ARTICLE_EMPTY, "ВЫ ня выбралі артыкул!");
        data.put(ERROR_ACCOUNT_EMPTY, "Вы ня выбралі рахунак!");
        data.put(ERROR_RATE_INCORRECT, "Некарэктнае значэньне курсу!");
        data.put(ERROR_AMOUNT_FORMAT, "Некарэктны фармат сумы!");
        data.put(ERROR_NO_BASE_CURRENCY, "Неабходная базавая валюта!" +
                " Устанавіце спачатку гэты парамэтр у іншай валюце, " +
                "потым ён здымецца аўтаматычна.");
    }
}
