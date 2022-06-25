package personalfinance.settings;

import java.util.HashMap;

public final class Text {

    public static final HashMap<String, String> data = new HashMap<>();

    public static String PROGRAM_NAME;

    public static String MENU_FILE;
    public static String MENU_EDIT;
    public static String MENU_VIEW;
    public static String MENU_HELP;

    public static String ERROR_TITLE_EMPTY;
    public static String ERROR_IS_EXISTS;
    public static String ERROR_DATE_FORMAT;
    public static String ERROR_CODE_EMPTY;
    public static String ERROR_CURRENCY_EMPTY;
    public static String ERROR_ARTICLE_EMPTY;
    public static String ERROR_ACCOUNT_EMPTY;
    public static String ERROR_RATE_INCORRECT;
    public static String ERROR_AMOUNT_FORMAT;
    public static String ERROR_NO_BASE_CURRENCY;

    public static String YES;
    public static String NO;

    public static String get(String key) {
        if (data.containsKey(key)) return data.get(key);
        System.out.println("Такога ключа ў Text ня йснуе!");
        return "";
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
        if (Settings.getLocale().equals("be")) {
            PROGRAM_NAME = "Хатняя бухгальтэрыя";
            MENU_FILE = "Файл";
            MENU_EDIT = "Праўка";
            MENU_VIEW = "Выгляд";
            MENU_HELP = "Даведка";

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

            ERROR_TITLE_EMPTY = "Вы не ўвялі назву!";
            ERROR_IS_EXISTS = "Такі запіс ужо йснуе!";
            ERROR_DATE_FORMAT = "Некарэктны фармат даты!";
            ERROR_CODE_EMPTY = "Вы не ўказалі код!";
            ERROR_CURRENCY_EMPTY = "Вы ня выбралі валюту!";
            ERROR_ARTICLE_EMPTY = "ВЫ ня выбралі артыкул!";
            ERROR_ACCOUNT_EMPTY = "Вы ня выбралі рахунак!";
            ERROR_RATE_INCORRECT = "Некарэктнае значэньне курсу!";
            ERROR_AMOUNT_FORMAT = "Некарэктны фармат сумы!";
            ERROR_NO_BASE_CURRENCY = "Неабходная базавая валюта!" +
                    " Устанавіце спачатку гэты парамэтр у іншай валюце, " +
                    "потым ён здымецца аўтаматычна ў гэтай валюце.";

            YES = "Так";
            NO = "Не";
        } else if (Settings.getLocale().equals("ru")) {
            PROGRAM_NAME = "Домашняя бухгалтерия";

            data.put("JAN", "Январь");
            data.put("FEB", "Февраль");
            data.put("MAR", "Март");
            data.put("APR", "Апрель");
            data.put("MAY", "Май");
            data.put("JUN", "Июнь");
            data.put("JUL", "Июль");
            data.put("AUG", "Август");
            data.put("SEP", "Сентябрь");
            data.put("OCT", "Октябрь");
            data.put("NOV", "Ноябрь");
            data.put("DEC", "Декабрь");

            ERROR_TITLE_EMPTY = "Вы не ввели название!";
            ERROR_IS_EXISTS = "Такая запись уже существует!";
            ERROR_DATE_FORMAT = "Некорректный формат даты!";
            ERROR_CODE_EMPTY = "Вы не указали код!";
            ERROR_CURRENCY_EMPTY = "Вы не выбрали валюту!";
            ERROR_ARTICLE_EMPTY = "Вы не выбрали статью!";
            ERROR_ACCOUNT_EMPTY = "Вы не выбрали счёт!";
            ERROR_RATE_INCORRECT = "Некорректное значение курса!";
            ERROR_AMOUNT_FORMAT = "Некорректный формат суммы!";
            ERROR_NO_BASE_CURRENCY = "Необходима базовая валюта!" +
                    " Установите сначала этот параметр в другой валюте, " +
                    "потом он снимется автоматически.";

            YES = "Да";
            NO = "Нет";

            MENU_FILE = "Файл";
            MENU_EDIT = "Правка";
            MENU_VIEW = "Вид";
            MENU_HELP = "Помощь";
        } else if (Settings.getLocale().equals("uk")) {
            PROGRAM_NAME = "Домашня бугалтерія";

            data.put("JAN", "Січень");
            data.put("FEB", "Лютий");
            data.put("MAR", "Березень");
            data.put("APR", "Квітень");
            data.put("MAY", "Травень");
            data.put("JUN", "Червень");
            data.put("JUL", "Липень");
            data.put("AUG", "Серпень");
            data.put("SEP", "Вересень");
            data.put("OCT", "Жовтень");
            data.put("NOV", "Листопад");
            data.put("DEC", "Грудень");

            ERROR_TITLE_EMPTY = "Вы не запровадили назву!";
            ERROR_IS_EXISTS = "Такий запис уже існує!";
            ERROR_DATE_FORMAT = "Неправильний формат дати!";
            ERROR_CODE_EMPTY = "Вы не вказали код!";
            ERROR_CURRENCY_EMPTY = "Вы не вибрали валюту!";
            ERROR_ARTICLE_EMPTY = "Вы не обрали статтю!";
            ERROR_ACCOUNT_EMPTY = "Вы не обрали рахунок!";
            ERROR_RATE_INCORRECT = "Некоректне значения курсу!";
            ERROR_AMOUNT_FORMAT = "Некоректний формат суми!";
            ERROR_NO_BASE_CURRENCY = "Необхідна базова валюта!" +
                    " Спочатку встановіть цей параметр в іншій валюті, " +
                    "потім він буде автоматично видалений у цій валюті.";

            YES = "Да";
            NO = "Нет";

            MENU_FILE = "Файл";
            MENU_EDIT = "Правка";
            MENU_VIEW = "Вид";
            MENU_HELP = "Помощь";
        } else if (Settings.getLocale().equals("fr")) {
            PROGRAM_NAME = "Finances personnelles";

            ERROR_TITLE_EMPTY = "Vous n'avez pas saisi de nom !";
            ERROR_IS_EXISTS = "Cette entrée existe déjà !";
            ERROR_DATE_FORMAT = "Format de date invalide !";
            ERROR_CODE_EMPTY = "Vous n'avez pas spécifié le code !";
            ERROR_CURRENCY_EMPTY = "Vous n'avez pas sélectionné de devise !";
            ERROR_ARTICLE_EMPTY = "Vous n'avez pas spécifié l'article !";
            ERROR_ACCOUNT_EMPTY = "Vous n'avez pas sélectionné de compte !";
            ERROR_RATE_INCORRECT = "Valeur incorrecte du taux de change !";
            ERROR_AMOUNT_FORMAT = "Format invalide de la somme !";
            ERROR_NO_BASE_CURRENCY = "Une devise de base est nécessaire !" +
                    " Définissez d'abord ce paramètre dans une autre devise, " +
                    "puis il sera automatiquement supprimé dans celle-ci.";

            YES = "Oui";
            NO = "Non";

            MENU_FILE = "Fichier";
            MENU_EDIT = "Édition";
            MENU_VIEW = "Affichage";
            MENU_HELP = "Aide";
        } else {
            PROGRAM_NAME = "Personal Finance";

            ERROR_TITLE_EMPTY = "You have not entered a name!";
            ERROR_IS_EXISTS = "This entry already exists!";
            ERROR_DATE_FORMAT = "Invalid date format!";
            ERROR_CODE_EMPTY = "You did not specify the code!";
            ERROR_CURRENCY_EMPTY = "You did not specify the currency!";
            ERROR_ARTICLE_EMPTY = "You did not specify the article!";
            ERROR_ACCOUNT_EMPTY = "You did not specify the account!";
            ERROR_RATE_INCORRECT = "Invalid rate value!";
            ERROR_AMOUNT_FORMAT = "Invalid amount format!";
            ERROR_NO_BASE_CURRENCY = "Base currency required!" +
                    " First set this parameter in another currency, " +
                    "then it will be removed in this automatically.";

            YES = "Yes";
            NO = "No";

            MENU_FILE = "File";
            MENU_EDIT = "Edit";
            MENU_VIEW = "View";
            MENU_HELP = "Help";
        }
    }
}
