package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code LoginUrl} class is useful to format a {@code Telegram}'s login url
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="">
 * LoginUrl</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class LoginUrl extends TelegramType {

    /**
     * {@code url} an HTTPS URL to be opened with user authorization data added to the query string when the button
     * is pressed. If the user refuses to provide authorization data, the original URL without information about the
     * user will be opened. The data added is the same as described in Receiving authorization data
     *
     * @apiNote you must always check the hash of the received data to verify the authentication and the integrity of the
     * data as described in Checking authorization.
     */
    private final String url;

    /**
     * {@code forwardText} new text of the button in forwarded messages
     */
    private final String forwardText;

    /**
     * {@code botUsername} username of a bot, which will be used for user authorization. See Setting up a bot for more
     * details. If not specified, the current bot's username will be assumed. The url's domain must be the same as the
     * domain linked with the bot. See Linking your domain to the bot for more details
     */
    private final String botUsername;

    /**
     * {@code requestWriteAccess} to request the permission for your bot to send messages to the user
     */
    private final boolean requestWriteAccess;

    /**
     * Constructor to init a {@link LoginUrl} object
     *
     * @param url:                an HTTPS URL to be opened with user authorization data added to the query string when the button
     *                            is pressed. If the user refuses to provide authorization data, the original URL without information about the
     *                            user will be opened. The data added is the same as described in Receiving authorization data
     * @param forwardText:        new text of the button in forwarded messages
     * @param botUsername:        username of a bot, which will be used for user authorization. See Setting up a bot for more
     *                            details. If not specified, the current bot's username will be assumed. The url's domain must be the same as the
     *                            domain linked with the bot. See Linking your domain to the bot for more details
     * @param requestWriteAccess: to request the permission for your bot to send messages to the user
     */
    public LoginUrl(String url, String forwardText, String botUsername, boolean requestWriteAccess) {
        super(null);
        this.url = url;
        this.forwardText = forwardText;
        this.botUsername = botUsername;
        this.requestWriteAccess = requestWriteAccess;
    }

    /**
     * Constructor to init a {@link LoginUrl} object
     *
     * @param jLoginUrl: login url details as {@link JSONObject}
     */
    public LoginUrl(JSONObject jLoginUrl) {
        super(jLoginUrl);
        url = hTelegram.getString("url");
        forwardText = hTelegram.getString("forward_text");
        botUsername = hTelegram.getString("bot_username");
        requestWriteAccess = hTelegram.getBoolean("request_write_access");
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
     * Method to get {@link #forwardText} instance <br>
     * No-any params required
     *
     * @return {@link #forwardText} instance as {@link String}
     */
    public String getForwardText() {
        return forwardText;
    }

    /**
     * Method to get {@link #botUsername} instance <br>
     * No-any params required
     *
     * @return {@link #botUsername} instance as {@link String}
     */
    public String getBotUsername() {
        return botUsername;
    }

    /**
     * Method to get {@link #requestWriteAccess} instance <br>
     * No-any params required
     *
     * @return {@link #requestWriteAccess} instance as boolean
     */
    public boolean isRequestWriteAccess() {
        return requestWriteAccess;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link LoginUrl}
     */
    public static LoginUrl getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new LoginUrl(jItem);
    }

}
