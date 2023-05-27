package com.tecknobit.telegrammanager.botapi.records.basetypes.menubuttons;

import com.tecknobit.telegrammanager.botapi.records.basetypes.webapp.WebAppInfo;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.menubuttons.MenuButtonDefault.MenuButtonType.web_app;

/**
 * The {@code MenuButtonWebApp} class is useful to format a {@code Telegram}'s menu button WebApp
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#menubuttonwebapp">
 * MenuButtonWebApp</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MenuButtonDefault
 */
public class MenuButtonWebApp extends MenuButtonDefault {

    /**
     * {@code text} on the button
     */
    private final String text;

    /**
     * {@code webApp} description of the Web App that will be launched when the user presses the button
     */
    private final WebAppInfo webApp;

    /**
     * Constructor to init a {@link MenuButtonWebApp} object
     *
     * @param text:   text on the button
     * @param webApp: description of the Web App that will be launched when the user presses the button
     */
    public MenuButtonWebApp(String text, WebAppInfo webApp) {
        super(web_app);
        this.text = text;
        this.webApp = webApp;
    }

    /**
     * Constructor to init a {@link MenuButtonWebApp} object
     *
     * @param jMenuButtonWebApp: menu button WebApp details as {@link JSONObject}
     */
    public MenuButtonWebApp(JSONObject jMenuButtonWebApp) {
        super(jMenuButtonWebApp);
        text = hTelegram.getString("text");
        webApp = new WebAppInfo(hTelegram.getJSONObject("web_app"));
    }

    /**
     * Method to get {@link #text} instance <br>
     * No-any params required
     *
     * @return {@link #text} instance as {@link String}
     */
    public String getText() {
        return text;
    }

    /**
     * Method to get {@link #webApp} instance <br>
     * No-any params required
     *
     * @return {@link #webApp} instance as {@link WebAppInfo}
     */
    public WebAppInfo getWebApp() {
        return webApp;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link MenuButtonWebApp}
     */
    public static MenuButtonWebApp getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new MenuButtonWebApp(jItem);
    }

}
