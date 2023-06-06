package com.tecknobit.telegrammanager.botapi.managers.inline.records;

import com.tecknobit.telegrammanager.botapi.records.basetypes.webapp.WebAppInfo;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code InlineQueryResultsButton} class is useful to format a {@code Telegram}'s inline query results button
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultsbutton">
 * InlineQueryResultsButton</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class InlineQueryResultsButton extends TelegramType {

    /**
     * {@code text} label text on the button
     */
    private final String text;

    /**
     * {@code webApp} description of the Web App that will be launched when the user presses the button
     */
    private final WebAppInfo webApp;

    /**
     * {@code startParameter} deep-linking parameter for the /start message sent to the bot when a user presses the button.
     * 1-64 characters, only A-Z, a-z, 0-9, _ and - are allowed
     */
    private final String startParameter;

    /**
     * Constructor to init a {@link InlineQueryResultsButton} object
     *
     * @param text:           label text on the button
     * @param webApp:         description of the Web App that will be launched when the user presses the button
     * @param startParameter: deep-linking parameter for the /start message sent to the bot when a user presses the button.
     *                        1-64 characters, only A-Z, a-z, 0-9, _ and - are allowed
     */
    public InlineQueryResultsButton(String text, WebAppInfo webApp, String startParameter) {
        super(null);
        this.text = text;
        this.webApp = webApp;
        this.startParameter = startParameter;
    }

    /**
     * Constructor to init a {@link InlineQueryResultsButton} object
     *
     * @param jInlineQueryResultsButton: inline query results button details as {@link JSONObject}
     */
    public InlineQueryResultsButton(JSONObject jInlineQueryResultsButton) {
        super(jInlineQueryResultsButton);
        text = hTelegram.getString("text");
        webApp = WebAppInfo.getInstance(hTelegram.getJSONObject("web_app"));
        startParameter = hTelegram.getString("start_parameter");
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
     * Method to get {@link #startParameter} instance <br>
     * No-any params required
     *
     * @return {@link #startParameter} instance as {@link String}
     */
    public String getStartParameter() {
        return startParameter;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultsButton}
     */
    public static InlineQueryResultsButton getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultsButton(jItem);
    }

}
