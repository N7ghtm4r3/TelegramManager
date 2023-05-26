package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code WriteAccessAllowed} class is useful to format a {@code Telegram}'s write access allowed
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#writeaccessallowed">
 * WriteAccessAllowed</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class WriteAccessAllowed extends TelegramType {

    /**
     * {@code webAppName} name of the Web App which was launched from a link
     */
    private final String webAppName;

    /**
     * Constructor to init a {@link WriteAccessAllowed} object
     *
     * @param webAppName: name of the Web App which was launched from a link
     */
    public WriteAccessAllowed(String webAppName) {
        super(null);
        this.webAppName = webAppName;
    }

    /**
     * Constructor to init a {@link WriteAccessAllowed} object
     *
     * @param jWriteAccessAllowed: write access allowed details as {@link JSONObject}
     */
    public WriteAccessAllowed(JSONObject jWriteAccessAllowed) {
        super(jWriteAccessAllowed);
        webAppName = hTelegram.getString("web_app_name");
    }

    /**
     * Method to get {@link #webAppName} instance <br>
     * No-any params required
     *
     * @return {@link #webAppName} instance as {@link String}
     */
    public String getWebAppName() {
        return webAppName;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link WriteAccessAllowed}
     */
    public static WriteAccessAllowed getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new WriteAccessAllowed(jItem);
    }

}
