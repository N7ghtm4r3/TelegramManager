package com.tecknobit.telegrammanager.botapi.records.basetypes.webapp;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code WebAppData} class is useful to format a {@code Telegram}'s WebApp data
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#webappdata">
 * WebAppData</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class WebAppData extends TelegramType {

    /**
     * {@code data} the data. Be aware that a bad client can send arbitrary data in this field
     */
    private final String data;

    /**
     * {@code buttonText} text of the web_app keyboard button from which the Web App was opened. Be aware that a bad
     * client can send arbitrary data in this field
     */
    private final String buttonText;

    /**
     * Constructor to init a {@link WebAppData} object
     *
     * @param data:       the data. Be aware that a bad client can send arbitrary data in this field
     * @param buttonText: text of the web_app keyboard button from which the Web App was opened. Be aware that a bad
     *                    client can send arbitrary data in this field
     */
    public WebAppData(String data, String buttonText) {
        super(null);
        this.data = data;
        this.buttonText = buttonText;
    }

    /**
     * Constructor to init a {@link WebAppData} object
     *
     * @param jWebAppData: WebApp data details as {@link JSONObject}
     */
    public WebAppData(JSONObject jWebAppData) {
        super(jWebAppData);
        data = hTelegram.getString("data");
        buttonText = hTelegram.getString("button_text");
    }

    /**
     * Method to get {@link #data} instance <br>
     * No-any params required
     *
     * @return {@link #data} instance as {@link String}
     */
    public String getData() {
        return data;
    }

    /**
     * Method to get {@link #buttonText} instance <br>
     * No-any params required
     *
     * @return {@link #buttonText} instance as {@link String}
     */
    public String getButtonText() {
        return buttonText;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link WebAppData}
     */
    public static WebAppData getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new WebAppData(jItem);
    }

}
