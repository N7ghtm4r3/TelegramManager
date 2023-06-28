package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.managers.games.records.CallbackGame;
import com.tecknobit.telegrammanager.botapi.records.basetypes.LoginUrl;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.KeyboardButton;
import com.tecknobit.telegrammanager.botapi.records.basetypes.webapp.WebAppInfo;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.Executors;

/**
 * The {@code InlineKeyboardButton} class is useful to format a {@code Telegram}'s inline keyboard button
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinekeyboardbutton">
 * InlineKeyboardButton</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class InlineKeyboardButton extends TelegramType {

    /**
     * {@code text} label text on the button
     */
    private final String text;

    /**
     * {@code url} to be opened when the button is pressed
     */
    private String url;

    /**
     * {@code callbackData} data to be sent in a callback query to the bot when button is pressed, 1-64 bytes
     */
    private String callbackData;

    /**
     * {@code webApp} description of the Web App that will be launched when the user presses the button.
     * The Web App will be able to send an arbitrary message on behalf of the user using the method answerWebAppQuery.
     * Available only in private chats between a user and the bot
     */
    private WebAppInfo webApp;

    /**
     * {@code loginUrl} an HTTPS URL used to automatically authorize the user
     */
    private LoginUrl loginUrl;

    /**
     * {@code switchInlineQuery} if set, pressing the button will prompt the user to select one of their chats, open
     * that chat and insert the bot's username and the specified inline query in the input field. May be empty, in which
     * case just the bot's username will be inserted
     *
     * @apiNote this offers an easy way for users to start using your bot in inline mode when they are currently in a
     * private chat with it. Especially useful when combined with switch_pm… actions - in this case the user will be
     * automatically returned to the chat they switched from, skipping the chat selection screen
     */
    private String switchInlineQuery;

    /**
     * {@code switchInlineQueryCurrentChat} if set, pressing the button will insert the bot's username and the specified
     * inline query in the current chat's input field. May be empty, in which case only the bot's username will be inserted
     *
     * @apiNote this offers a quick way for the user to open your bot in inline mode in the same chat - good for
     * selecting something from multiple options
     */
    private String switchInlineQueryCurrentChat;

    /**
     * {@code switchInlineQueryChosenChat} if set, pressing the button will prompt the user to select one of their chats
     * of the specified type, open that chat and insert the bot's username and the specified inline query in the input field
     */
    private SwitchInlineQueryChosenChat switchInlineQueryChosenChat;

    /**
     * {@code callbackGame} description of the game that will be launched when the user presses the button
     *
     * @apiNote this type of button must always be the first button in the first row
     */
    private CallbackGame callbackGame;

    /**
     * {@code pay} specify True, to send a Pay button
     *
     * @apiNote this type of button must always be the first button in the first row and can only be used in invoice messages
     */
    private boolean pay;

    /**
     * Constructor to init a {@link KeyboardButton} object
     *
     * @param text: label text on the button
     * @apiNote this constructor is useful to instantiate a new inline keyboard button to pass as request parameter, you can
     * choose the single parameter (because they are mutually exclusive) to set for the button invoking the specific
     * setter method
     */
    public InlineKeyboardButton(String text) {
        super(null);
        this.text = text;
    }

    /**
     * Constructor to init a {@link InlineKeyboardButton} object
     *
     * @param jInlineKeyboardButton: inline keyboard button details as {@link JSONObject}
     */
    public InlineKeyboardButton(JSONObject jInlineKeyboardButton) {
        super(jInlineKeyboardButton);
        text = hTelegram.getString("text");
        url = hTelegram.getString("url");
        callbackData = hTelegram.getString("callback_data");
        webApp = WebAppInfo.getInstance(hTelegram.getJSONObject("web_app"));
        loginUrl = LoginUrl.getInstance(hTelegram.getJSONObject("login_url"));
        switchInlineQuery = hTelegram.getString("switch_inline_query");
        switchInlineQueryCurrentChat = hTelegram.getString("switch_inline_query_current_chat");
        switchInlineQueryChosenChat = SwitchInlineQueryChosenChat
                .getInstance(hTelegram.getJSONObject("switch_inline_query_chosen_chat"));
        callbackGame = CallbackGame.getInstance(hTelegram.getJSONObject("callback_game"));
        pay = hTelegram.getBoolean("pay");
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
     * Method to get {@link #url} instance <br>
     * No-any params required
     *
     * @return {@link #url} instance as {@link String}
     */
    public String getUrl() {
        return url;
    }

    /**
     * Method to set {@link #url} instance
     *
     * @param url: url to be opened when the button is pressed
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Method to get {@link #callbackData} instance <br>
     * No-any params required
     *
     * @return {@link #callbackData} instance as {@link String}
     */
    public String getCallbackData() {
        return callbackData;
    }

    /**
     * Method to set {@link #callbackData} instance
     *
     * @param callbackData: data to be sent in a callback query to the bot when button is pressed, 1-64 bytes
     */
    @Wrapper
    public void setCallbackData(String callbackData) {
        setCallbackData(callbackData, null);
    }

    /**
     * Method to set {@link #callbackData} instance
     *
     * @param callbackData:   data to be sent in a callback query to the bot when button is pressed, 1-64 bytes
     * @param callbackAction: runnable action to execute when the callback data has been requested, you must manage the
     *                        routine to wait to execute this action
     */
    public void setCallbackData(String callbackData, Runnable callbackAction) {
        this.callbackData = callbackData;
        if (callbackAction != null)
            Executors.newSingleThreadExecutor().execute(callbackAction);
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
     * @param webApp: description of the Web App that will be launched when the user presses the button.
     *                The Web App will be able to send an arbitrary message on behalf of the user using the method answerWebAppQuery.
     *                Available only in private chats between a user and the bot
     */
    public void setWebApp(WebAppInfo webApp) {
        this.webApp = webApp;
    }

    /**
     * Method to get {@link #loginUrl} instance <br>
     * No-any params required
     *
     * @return {@link #loginUrl} instance as {@link LoginUrl}
     */
    public LoginUrl getLoginUrl() {
        return loginUrl;
    }

    /**
     * Method to set {@link #loginUrl} instance
     *
     * @param loginUrl: an HTTPS URL used to automatically authorize the user
     */
    public void setLoginUrl(LoginUrl loginUrl) {
        this.loginUrl = loginUrl;
    }

    /**
     * Method to get {@link #switchInlineQuery} instance <br>
     * No-any params required
     *
     * @return {@link #switchInlineQuery} instance as {@link String}
     */
    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }

    /**
     * Method to set {@link #switchInlineQuery} instance
     *
     * @param switchInlineQuery: if set, pressing the button will prompt the user to select one of their chats, open
     *                           that chat and insert the bot's username and the specified inline query in the input field.
     *                           May be empty, in which case just the bot's username will be inserted
     */
    public void setSwitchInlineQuery(String switchInlineQuery) {
        this.switchInlineQuery = switchInlineQuery;
    }

    /**
     * Method to get {@link #switchInlineQueryCurrentChat} instance <br>
     * No-any params required
     *
     * @return {@link #switchInlineQueryCurrentChat} instance as {@link String}
     */
    public String getSwitchInlineQueryCurrentChat() {
        return switchInlineQueryCurrentChat;
    }

    /**
     * Method to set {@link #switchInlineQueryCurrentChat} instance
     *
     * @param switchInlineQueryCurrentChat: if set, pressing the button will insert the bot's username and the specified
     *                                      inline query in the current chat's input field. May be empty, in which case only
     *                                      the bot's username will be inserted
     */
    public void setSwitchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
    }

    /**
     * Method to get {@link #switchInlineQueryChosenChat} instance <br>
     * No-any params required
     *
     * @return {@link #switchInlineQueryChosenChat} instance as {@link SwitchInlineQueryChosenChat}
     */
    public SwitchInlineQueryChosenChat getSwitchInlineQueryChosenChat() {
        return switchInlineQueryChosenChat;
    }

    /**
     * Method to set {@link #switchInlineQueryChosenChat} instance
     *
     * @param switchInlineQueryChosenChat: if set, pressing the button will prompt the user to select one of their chats
     *                                     of the specified type, open that chat and insert the bot's username and the specified
     *                                     inline query in the input field
     */
    public void setSwitchInlineQueryChosenChat(SwitchInlineQueryChosenChat switchInlineQueryChosenChat) {
        this.switchInlineQueryChosenChat = switchInlineQueryChosenChat;
    }

    /**
     * Method to get {@link #callbackGame} instance <br>
     * No-any params required
     *
     * @return {@link #callbackGame} instance as {@link CallbackGame}
     */
    public CallbackGame getCallbackGame() {
        return callbackGame;
    }

    /**
     * Method to set {@link #callbackGame} instance
     *
     * @param callbackGame: description of the game that will be launched when the user presses the button
     */
    public void setCallbackGame(CallbackGame callbackGame) {
        this.callbackGame = callbackGame;
    }

    /**
     * Method to get {@link #pay} instance <br>
     * No-any params required
     *
     * @return {@link #pay} instance as boolean
     */
    public boolean isPay() {
        return pay;
    }

    /**
     * Method to set {@link #pay} instance
     *
     * @param pay: specify True, to send a Pay button
     */
    public void setPay(boolean pay) {
        this.pay = pay;
    }

    /**
     * Method to return a {@link InlineKeyboardButton} list
     *
     * @param jInlineKeyboardButtons : JSON source from fetch the list
     * @return inline keyboard buttons list as {@link ArrayList} of {@link InlineKeyboardButton}
     */
    @Returner
    public static ArrayList<InlineKeyboardButton> returnInlineKeyboardButtons(JSONArray jInlineKeyboardButtons) {
        ArrayList<InlineKeyboardButton> inlineKeyboardButtons = new ArrayList<>();
        if (jInlineKeyboardButtons != null) {
            for (int j = 0; j < jInlineKeyboardButtons.length(); j++) {
                JSONArray buttonsRow = jInlineKeyboardButtons.getJSONArray(j);
                for (int i = 0; i < buttonsRow.length(); i++)
                    inlineKeyboardButtons.add(new InlineKeyboardButton(buttonsRow.getJSONObject(i)));
            }
        }
        return inlineKeyboardButtons;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineKeyboardButton}
     */
    public static InlineKeyboardButton getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineKeyboardButton(jItem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String toString = super.toString();
        if (useSnakeNotation) {
            JSONObject button = new JSONObject(super.toString());
            if (!pay)
                button.remove("pay");
            return button.toString();
        } else
            return toString;
    }

}
