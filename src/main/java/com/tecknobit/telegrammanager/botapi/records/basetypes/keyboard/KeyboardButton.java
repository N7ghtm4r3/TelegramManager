package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.basetypes.webapp.WebAppInfo;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code KeyboardButton} class is useful to format a {@code Telegram}'s keyboard button
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#keyboardbutton">
 * KeyboardButton</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class KeyboardButton extends TelegramType {

    /**
     * {@code text} of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
     */
    private final String text;

    /**
     * {@code requestUser} if specified, pressing the button will open a list of suitable users. Tapping on any user
     * will send their identifier to the bot in a “user_shared” service message. Available in private chats only
     */
    private final KeyboardButtonRequestUser requestUser;

    /**
     * {@code requestChat} if specified, pressing the button will open a list of suitable chats. Tapping on a chat will
     * send its identifier to the bot in a “chat_shared” service message. Available in private chats only
     */
    private final KeyboardButtonRequestChat requestChat;

    /**
     * {@code requestContact} if the user's phone number will be sent as a contact when the button is pressed. Available
     * in private chats only
     */
    private final boolean requestContact;

    /**
     * {@code requestLocation} if the user's current location will be sent when the button is pressed. Available in
     * private chats only
     */
    private final boolean requestLocation;

    /**
     * {@code requestPoll} if specified, the user will be asked to create a poll and send it to the bot when the
     * button is pressed. Available in private chats only
     */
    private final KeyboardButtonPollType requestPoll;

    /**
     * {@code webApp} if specified, the described Web App will be launched when the button is pressed. The Web App will
     * be able to send a “web_app_data” service message. Available in private chats only
     */
    private final WebAppInfo webApp;

    /**
     * Constructor to init a {@link KeyboardButton} object
     *
     * @param text:            text of the button. If none of the optional fields are used, it will be sent as a message when the
     *                         button is pressed
     * @param requestUser:     if specified, pressing the button will open a list of suitable users. Tapping on any user
     *                         will send their identifier to the bot in a “user_shared” service message. Available in private chats only
     * @param requestChat:     if specified, pressing the button will open a list of suitable chats. Tapping on a chat will
     *                         send its identifier to the bot in a “chat_shared” service message. Available in private chats only
     * @param requestContact:  if the user's phone number will be sent as a contact when the button is pressed. Available
     *                         in private chats only
     * @param requestLocation: if the user's current location will be sent when the button is pressed. Available in
     *                         private chats only
     * @param requestPoll:     if specified, the user will be asked to create a poll and send it to the bot when the
     *                         button is pressed. Available in private chats only
     * @param webApp:          if specified, the described Web App will be launched when the button is pressed. The Web App will
     *                         be able to send a “web_app_data” service message. Available in private chats only
     */
    public KeyboardButton(String text, KeyboardButtonRequestUser requestUser, KeyboardButtonRequestChat requestChat,
                          boolean requestContact, boolean requestLocation, KeyboardButtonPollType requestPoll,
                          WebAppInfo webApp) {
        super(null);
        this.text = text;
        this.requestUser = requestUser;
        this.requestChat = requestChat;
        this.requestContact = requestContact;
        this.requestLocation = requestLocation;
        this.requestPoll = requestPoll;
        this.webApp = webApp;
    }

    /**
     * Constructor to init a {@link KeyboardButton} object
     *
     * @param jKeyboardButton: keyboard button details as {@link JSONObject}
     */
    public KeyboardButton(JSONObject jKeyboardButton) {
        super(jKeyboardButton);
        text = hTelegram.getString("text");
        requestUser = KeyboardButtonRequestUser.getInstance(hTelegram.getJSONObject("request_user"));
        requestChat = KeyboardButtonRequestChat.getInstance(hTelegram.getJSONObject("request_chat"));
        requestContact = hTelegram.getBoolean("request_contact");
        requestLocation = hTelegram.getBoolean("request_location");
        requestPoll = KeyboardButtonPollType.getInstance(hTelegram.getJSONObject("request_poll"));
        webApp = WebAppInfo.getInstance(hTelegram.getJSONObject("web_app"));
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
     * Method to get {@link #requestUser} instance <br>
     * No-any params required
     *
     * @return {@link #requestUser} instance as {@link KeyboardButtonRequestUser}
     */
    public KeyboardButtonRequestUser getRequestUser() {
        return requestUser;
    }

    /**
     * Method to get {@link #requestChat} instance <br>
     * No-any params required
     *
     * @return {@link #requestChat} instance as {@link KeyboardButtonRequestChat}
     */
    public KeyboardButtonRequestChat getRequestChat() {
        return requestChat;
    }

    /**
     * Method to get {@link #requestContact} instance <br>
     * No-any params required
     *
     * @return {@link #requestContact} instance as boolean
     */
    public boolean isRequestContact() {
        return requestContact;
    }

    /**
     * Method to get {@link #requestLocation} instance <br>
     * No-any params required
     *
     * @return {@link #requestLocation} instance as boolean
     */
    public boolean isRequestLocation() {
        return requestLocation;
    }

    /**
     * Method to get {@link #requestPoll} instance <br>
     * No-any params required
     *
     * @return {@link #requestPoll} instance as {@link KeyboardButtonPollType}
     */
    public KeyboardButtonPollType getRequestPoll() {
        return requestPoll;
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
     * Method to return a {@link KeyboardButton} list
     *
     * @param jKeyboardButtons : JSON source from fetch the list
     * @return keyboard buttons list as {@link ArrayList} of {@link KeyboardButton}
     */
    @Returner
    public static ArrayList<KeyboardButton> returnKeyboardButtons(JSONArray jKeyboardButtons) {
        ArrayList<KeyboardButton> keyboardButtons = new ArrayList<>();
        if (jKeyboardButtons != null)
            for (int j = 0; j < jKeyboardButtons.length(); j++)
                keyboardButtons.add(new KeyboardButton(jKeyboardButtons.getJSONObject(j)));
        return keyboardButtons;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link KeyboardButton}
     */
    public static KeyboardButton getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new KeyboardButton(jItem);
    }

}
