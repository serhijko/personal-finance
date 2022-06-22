package personalfinance.settings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class Style {

    public static final Color NORMAL_BUTTON_BG_COLOR = new Color(240, 240, 240);
    public static final Color HOVER_BUTTON_BG_COLOR = Color.YELLOW;

    public static final Font TOOLBAR_BUTTON_FONT = new Font("Roboto-Light", Font.BOLD, 14);
    public static final Font MAIN_BUTTON_FONT = new Font("Roboto-Light", Font.BOLD, 14);

    public static final EmptyBorder PANEL_BORDER = new EmptyBorder(10, 10, 10, 10);

    public static final ImageIcon MAIN_ICON = new ImageIcon("images/main.png");
    public static final ImageIcon TOOLBAR_OVERVIEW_ICON = new ImageIcon("images/overview.png");
    public static final ImageIcon TOOLBAR_ACCOUNTS_ICON = new ImageIcon("images/accounts.png");
    public static final ImageIcon TOOLBAR_ARTICLES_ICON = new ImageIcon("images/articles.png");
    public static final ImageIcon TOOLBAR_CURRENCIES_ICON = new ImageIcon("images/currencies.png");
    public static final ImageIcon TOOLBAR_TRANSACTIONS_ICON = new ImageIcon("images/transactions.png");
    public static final ImageIcon TOOLBAR_TRANSFERS_ICON = new ImageIcon("images/transfers.png");
    public static final ImageIcon TOOLBAR_STATISTICS_ICON = new ImageIcon("images/statistics.png");
}
