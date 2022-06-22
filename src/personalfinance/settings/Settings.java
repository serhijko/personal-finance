package personalfinance.settings;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.prefs.Preferences;

public final class Settings {

    public static final File ROBOTO_LIGHT_FONT = new File("fonts/Roboto-Light.ttf");
    public static final File SAVE_DIR = new File("saves/");
    public static final String SAVE_FILE_EXT = "save";

    public static final String AMOUNT_FORMAT = "%.2f";
    public static final String RATE_FORMAT = "%.4f";
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final String DATE_MONTH_FORMAT = "MMMM yyyy";
    public static final String YEAR_FORMAT = "yyyy";

    public static final int OVERVIEW_ROWS_COUNT = 10;

    public static final String[] CURRENCIES_CODES = new String[]{"BYN", "EUR", "RUR", "USD", "UAH"};

    public static final File SETTINGS_FILE = new File("saves/settings.ini");

    public static File SAVE_FILE = new File("saves/default.save");

    public static void init() {
        try {
            if (!SETTINGS_FILE.exists()) SETTINGS_FILE.createNewFile();
            Ini ini = new Ini(SETTINGS_FILE);
            Preferences prefs = new IniPreferences(ini);
            String saveFileSettings = prefs.node("Settings").get("SAVE_FILE", null);
            if (saveFileSettings != null) SAVE_FILE = new File(saveFileSettings);
            setLocale();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setLocale() {
        Locale.setDefault(new Locale("by"));
    }

    public static File getSaveFile() {
        return SAVE_FILE;
    }

    public static void setSaveFile(File saveFile) {
        SAVE_FILE = saveFile;
        save();
    }

    private static void save() {
        try {
            Wini ini = new Wini(SETTINGS_FILE);
            ini.put("Settings", "SAVE_FILE", SAVE_FILE.getAbsolutePath().replace("\\", "\\\\"));
            ini.store();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
