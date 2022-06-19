package projectfinance.settings;

import java.util.HashMap;

public class Text {

    public static final HashMap<String, String> data = new HashMap<>();

    public static String get(String key) {
        return data.get(key);
    }

    public static String[] getMonths() {
        String[] months = new String[12];
        months[0] = get("JANUARY");
        months[1] = get("FEBRUARY");
        months[2] = get("MARCH");
        months[3] = get("APRIL");
        months[4] = get("MAY");
        months[5] = get("JUNE");
        months[6] = get("JULY");
        months[7] = get("AUGUST");
        months[8] = get("SEPTEMBER");
        months[9] = get("OCTOBER");
        months[10] = get("NOVEMBER");
        months[11] = get("DECEMBER");
        return months;
    }

    public static void init() {
        data.put("PROGRAM_NAME", "Дамашняя бухгальтэрыя");
        data.put("MENU_FILE", "Файл");
        data.put("MENU_EDIT", "Праўка");
        data.put("MENU_VIEW", "Выгляд");
        data.put("MENU_HELP", "Дапамога");

        data.put("JANUARY", "Студзень");
        data.put("FEBRUARY", "Люты");
        data.put("MARCH", "Сакавік");
        data.put("APRIL", "Красавік");
        data.put("MAY", "Травень");
        data.put("JUNE", "Чэрвень");
        data.put("JULY", "Ліпень");
        data.put("AUGUST", "Жнівень");
        data.put("SEPTEMBER", "Верасень");
        data.put("OCTOBER", "Кастрычнік");
        data.put("NOVEMBER", "Лістапад");
        data.put("DECEMBER", "Сьнежань");
    }
}
