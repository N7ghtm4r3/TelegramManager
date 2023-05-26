package com.tecknobit.telegrammanager.botapi.records.basetypes.webapp;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code WebAppInfo} class is useful to format a {@code Telegram}'s Web app info
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#webappinfo">
 * WebAppInfo</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class WebAppInfo extends TelegramType {

    /**
     * {@code url} an HTTPS URL of a Web App to be opened with additional data as specified in Initializing Web Apps
     */
    private final String url;

    /**
     * Constructor to init a {@link WebAppInfo} object
     *
     * @param url: an HTTPS URL of a Web App to be opened with additional data as specified in Initializing Web Apps
     */
    public WebAppInfo(String url) {
        super(null);
        this.url = url;
    }

    /**
     * Constructor to init a {@link WebAppInfo} object
     *
     * @param jWebAppInfo: Web app info details as {@link JSONObject}
     */
    public WebAppInfo(JSONObject jWebAppInfo) {
        super(jWebAppInfo);
        url = hTelegram.getString("url");
    }

    /**
     * Method to get {@link #url} instance <br>
     * No-any params required
     *
     * @return {@link #url} instance as {@link String}
     */
    public String getUrl() {
        return url;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link WebAppInfo}
     */
    public static WebAppInfo getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new WebAppInfo(jItem);
    }

}
