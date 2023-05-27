package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code KeyboardButtonRequestUser} class is useful to format a {@code Telegram}'s keyboard button request user
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestuser">
 * KeyboardButtonRequestUser</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class KeyboardButtonRequestUser extends TelegramType {

    /**
     * {@code requestId} signed 32-bit identifier of the request, which will be received back in the UserShared object.
     * Must be unique within the message
     */
    private final long requestId;

    /**
     * {@code userIsBot} pass True to request a bot, pass False to request a regular user. If not specified, no additional
     * restrictions are applied
     */
    private final boolean userIsBot;

    /**
     * {@code userIsPremium} pass True to request a premium user, pass False to request a non-premium user. If not specified,
     * no additional restrictions are applied
     */
    private final boolean userIsPremium;

    /**
     * Constructor to init a {@link KeyboardButtonRequestUser} object
     *
     * @param requestId:     signed 32-bit identifier of the request, which will be received back in the UserShared object.
     *                       Must be unique within the message
     * @param userIsBot:     pass True to request a bot, pass False to request a regular user. If not specified, no additional
     *                       restrictions are applied
     * @param userIsPremium: pass True to request a premium user, pass False to request a non-premium user. If not specified,
     *                       no additional restrictions are applied
     */
    public KeyboardButtonRequestUser(long requestId, boolean userIsBot, boolean userIsPremium) {
        super(null);
        this.requestId = requestId;
        this.userIsBot = userIsBot;
        this.userIsPremium = userIsPremium;
    }

    /**
     * Constructor to init a {@link KeyboardButtonRequestUser} object
     *
     * @param jKeyboardButtonRequestUser: keyboard button request user details as {@link JSONObject}
     */
    public KeyboardButtonRequestUser(JSONObject jKeyboardButtonRequestUser) {
        super(jKeyboardButtonRequestUser);
        requestId = hTelegram.getLong("request_id");
        userIsBot = hTelegram.getBoolean("user_is_bot");
        userIsPremium = hTelegram.getBoolean("user_is_premium");
    }

    /**
     * Method to get {@link #requestId} instance <br>
     * No-any params required
     *
     * @return {@link #requestId} instance as long
     */
    public long getRequestId() {
        return requestId;
    }

    /**
     * Method to get {@link #userIsBot} instance <br>
     * No-any params required
     *
     * @return {@link #userIsBot} instance as boolean
     */
    public boolean isUserBot() {
        return userIsBot;
    }

    /**
     * Method to get {@link #userIsPremium} instance <br>
     * No-any params required
     *
     * @return {@link #userIsPremium} instance as boolean
     */
    public boolean isUserPremium() {
        return userIsPremium;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link KeyboardButtonRequestUser}
     */
    public static KeyboardButtonRequestUser getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new KeyboardButtonRequestUser(jItem);
    }

}
