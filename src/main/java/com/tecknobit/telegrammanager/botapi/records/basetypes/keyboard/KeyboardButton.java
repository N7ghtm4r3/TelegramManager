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
    private String text;

    /**
     * {@code requestUser} if specified, pressing the button will open a list of suitable users. Tapping on any user
     * will send their identifier to the bot in a "user_shared" service message. Available in private chats only
     */
    private KeyboardButtonRequestUser requestUser;

    /**
     * {@code requestChat} if specified, pressing the button will open a list of suitable chats. Tapping on a chat will
     * send its identifier to the bot in a "chat_shared" service message. Available in private chats only
     */
    private KeyboardButtonRequestChat requestChat;

    /**
     * {@code requestContact} if the user's phone number will be sent as a contact when the button is pressed. Available
     * in private chats only
     */
    private boolean requestContact;

    /**
     * {@code requestLocation} if the user's current location will be sent when the button is pressed. Available in
     * private chats only
     */
    private boolean requestLocation;

    /**
     * {@code requestPoll} if specified, the user will be asked to create a poll and send it to the bot when the
     * button is pressed. Available in private chats only
     */
    private KeyboardButtonPollType requestPoll;

    /**
     * {@code webApp} if specified, the described Web App will be launched when the button is pressed. The Web App will
     * be able to send a "web_app_data" service message. Available in private chats only
     */
    private WebAppInfo webApp;

    /**
     * Constructor to init a {@link KeyboardButton} object
     *
     * @apiNote this constructor is useful to instantiate a new keyboard button to pass as request parameter, you can
     * choose the single parameter (because they are mutually exclusive) to set for the button invoking the specific
     * setter method
     */
    public KeyboardButton() {
        super(null);
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
     * Method to set {@link #text} instance
     *
     * @param text: text of the button. If none of the optional fields are used, it will be sent as a message when the
     *              button is pressed
     */
    public void setText(String text) {
        this.text = text;
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
     * Method to set {@link #requestUser} instance
     *
     * @param requestUser: if specified, pressing the button will open a list of suitable users. Tapping on any user
     *                     will send their identifier to the bot in a "user_shared" service message. Available in private chats only
     */
    public void setRequestUser(KeyboardButtonRequestUser requestUser) {
        this.requestUser = requestUser;
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
     * Method to set {@link #requestChat} instance
     *
     * @param requestChat: if specified, pressing the button will open a list of suitable chats. Tapping on a chat will
     *                     send its identifier to the bot in a "chat_shared" service message. Available in private chats only
     */
    public void setRequestChat(KeyboardButtonRequestChat requestChat) {
        this.requestChat = requestChat;
    }

    /**
     * Method to get {@link #requestContact} instance <br>
     * No-any params required
     *
     * @return {@link #requestContact} instance as boolean
     */
    public boolean requestContact() {
        return requestContact;
    }

    /**
     * Method to set {@link #requestContact} instance
     *
     * @param requestContact: if the user's phone number will be sent as a contact when the button is pressed. Available
     *                        in private chats only
     */
    public void setRequestContact(boolean requestContact) {
        this.requestContact = requestContact;
    }

    /**
     * Method to get {@link #requestLocation} instance <br>
     * No-any params required
     *
     * @return {@link #requestLocation} instance as boolean
     */
    public boolean requestLocation() {
        return requestLocation;
    }

    /**
     * Method to set {@link #requestLocation} instance
     *
     * @param requestLocation: if the user's current location will be sent when the button is pressed. Available in
     *                         private chats only
     */
    public void setRequestLocation(boolean requestLocation) {
        this.requestLocation = requestLocation;
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
     * Method to set {@link #requestPoll} instance
     *
     * @param requestPoll: if specified, the user will be asked to create a poll and send it to the bot when the
     *                     button is pressed. Available in private chats only
     */
    public void setRequestPoll(KeyboardButtonPollType requestPoll) {
        this.requestPoll = requestPoll;
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
     * Method to set {@link #webApp} instance
     *
     * @param webApp: if specified, the described Web App will be launched when the button is pressed. The Web App will
     *                be able to send a "web_app_data" service message. Available in private chats only
     */
    public void setWebApp(WebAppInfo webApp) {
        this.webApp = webApp;
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
        if (jKeyboardButtons != null) {
            for (int j = 0; j < jKeyboardButtons.length(); j++) {
                JSONArray buttonsRow = jKeyboardButtons.getJSONArray(j);
                for (int i = 0; i < buttonsRow.length(); i++)
                    keyboardButtons.add(new KeyboardButton(buttonsRow.getJSONObject(i)));
            }
        }
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String toString = super.toString();
        if (useSnakeNotation) {
            JSONObject button = new JSONObject(super.toString());
            if (!requestLocation)
                button.remove("request_location");
            if (!requestContact)
                button.remove("request_contact");
            return button.toString();
        } else
            return toString;
    }

}
