package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import com.tecknobit.telegrammanager.botapi.records.structures.QueryStructure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code CallbackQuery} class is useful to format a {@code Telegram}'s callback query
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#callbackquery">
 * CallbackQuery</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see QueryStructure
 */
public class CallbackQuery extends QueryStructure {

    /**
     * {@code message} with the callback button that originated the query. Note that message content and message
     * date will not be available if the message is too old
     */
    private final Message message;

    /**
     * {@code inlineMessageId} identifier of the message sent via the bot in inline mode, that originated the query
     */
    private final String inlineMessageId;

    /**
     * {@code chatInstance} global identifier, uniquely corresponding to the chat to which the message with the callback
     * button was sent. Useful for high scores in games
     */
    private final String chatInstance;

    /**
     * {@code data} associated with the callback button. Be aware that the message originated the query
     * can contain no callback buttons with this data
     */
    private final String data;

    /**
     * {@code gameShortName} short name of a Game to be returned, serves as the unique identifier for the game
     */
    private final String gameShortName;

    /**
     * Constructor to init a {@link CallbackQuery} object
     *
     * @param id:              unique identifier for this query
     * @param from:            sender
     * @param message:         message with the callback button that originated the query. Note that message content and message
     *                         date will not be available if the message is too old
     * @param inlineMessageId: identifier of the message sent via the bot in inline mode, that originated the query
     * @param chatInstance:    global identifier, uniquely corresponding to the chat to which the message with the callback
     *                         button was sent. Useful for high scores in games
     * @param data:            associated with the callback button. Be aware that the message originated the query
     *                         can contain no callback buttons with this data
     * @param gameShortName:   short name of a Game to be returned, serves as the unique identifier for the game
     */
    public CallbackQuery(String id, User from, Message message, String inlineMessageId, String chatInstance, String data,
                         String gameShortName) {
        super(id, from);
        this.message = message;
        this.inlineMessageId = inlineMessageId;
        this.chatInstance = chatInstance;
        this.data = data;
        this.gameShortName = gameShortName;
    }

    /**
     * Constructor to init a {@link CallbackQuery} object
     *
     * @param jCallbackQuery: callback query details as {@link JSONObject}
     */
    public CallbackQuery(JSONObject jCallbackQuery) {
        super(jCallbackQuery);
        message = Message.getInstance(hTelegram.getJSONObject("message"));
        inlineMessageId = hTelegram.getString("inline_message_id");
        chatInstance = hTelegram.getString("chat_instance");
        data = hTelegram.getString("data");
        gameShortName = hTelegram.getString("game_short_name");
    }

    /**
     * Method to get {@link #message} instance <br>
     * No-any params required
     *
     * @return {@link #message} instance as {@link Message}
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Method to get {@link #inlineMessageId} instance <br>
     * No-any params required
     *
     * @return {@link #inlineMessageId} instance as {@link String}
     */
    public String getInlineMessageId() {
        return inlineMessageId;
    }

    /**
     * Method to get {@link #chatInstance} instance <br>
     * No-any params required
     *
     * @return {@link #chatInstance} instance as {@link String}
     */
    public String getChatInstance() {
        return chatInstance;
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
     * Method to get {@link #gameShortName} instance <br>
     * No-any params required
     *
     * @return {@link #gameShortName} instance as {@link String}
     */
    public String getGameShortName() {
        return gameShortName;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link CallbackQuery}
     */
    public static CallbackQuery getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new CallbackQuery(jItem);
    }

}
