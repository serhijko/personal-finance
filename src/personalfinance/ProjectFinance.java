package personalfinance;

import personalfinance.settings.Settings;
import personalfinance.settings.Text;

import java.awt.*;
import java.io.IOException;
//import java.util.Arrays;

public class ProjectFinance {
    public static void main(String[] args) {
        init();
        //System.out.println(Text.get("PROGRAM_NAME"));
        //System.out.println(Arrays.toString(Text.getMonths()));
    }

    private static void init() {
        try {
            Settings.init();
            Text.init();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.ROBOTO_LIGHT_FONT));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
