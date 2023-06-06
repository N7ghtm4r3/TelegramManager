package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.members.ChatAdministratorRights;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code KeyboardButtonRequestChat} class is useful to format a {@code Telegram}'s keyboard button request chat
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestchat">
 * KeyboardButtonRequestChat</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class KeyboardButtonRequestChat extends TelegramType {

    /**
     * {@code requestId} signed 32-bit identifier of the request, which will be received back in the ChatShared object.
     * Must be unique within the message
     */
    private final long requestId;

    /**
     * {@code chatIsChannel} True to request a channel chat, pass False to request a group or a supergroup chat
     */
    private final boolean chatIsChannel;

    /**
     * {@code chatIsForum} pass True to request a forum supergroup, pass False to request a non-forum chat. If not
     * specified, no additional restrictions are applied
     */
    private final boolean chatIsForum;

    /**
     * {@code chatHasUsername} pass True to request a supergroup or a channel with a username, pass False to request a
     * chat without a username. If not specified, no additional restrictions are applied
     */
    private final boolean chatHasUsername;

    /**
     * {@code chatIsCreated} pass True to request a chat owned by the user. Otherwise, no additional restrictions are applied
     */
    private final boolean chatIsCreated;

    /**
     * {@code userAdministratorRights} listing the required administrator rights of the user in the chat. The rights must
     * be a superset of {@link #botAdministratorRights}. If not specified, no additional restrictions are applied
     */
    private final ChatAdministratorRights userAdministratorRights;

    /**
     * {@code botAdministratorRights} listing the required administrator rights of the bot in the chat. The rights must
     * be a subset of {@link #userAdministratorRights}. If not specified, no additional restrictions are applied
     */
    private final ChatAdministratorRights botAdministratorRights;

    /**
     * {@code botIsMember} pass True to request a chat with the bot as a member. Otherwise, no additional restrictions
     * are applied
     */
    private final boolean botIsMember;

    /**
     * Constructor to init a {@link KeyboardButtonRequestChat} object
     *
     * @param requestId:               signed 32-bit identifier of the request, which will be received back in the ChatShared object.
     *                                 Must be unique within the message
     * @param chatIsChannel:           True to request a channel chat, pass False to request a group or a supergroup chat
     * @param chatIsForum:             pass True to request a forum supergroup, pass False to request a non-forum chat. If not
     *                                 specified, no additional restrictions are applied
     * @param chatHasUsername:         pass True to request a supergroup or a channel with a username, pass False to request a
     *                                 chat without a username. If not specified, no additional restrictions are applied
     * @param chatIsCreated:           pass True to request a chat owned by the user. Otherwise, no additional restrictions are applied
     * @param userAdministratorRights: listing the required administrator rights of the user in the chat. The rights must
     *                                 be a superset of {@link #botAdministratorRights}. If not specified, no additional restrictions are applied
     * @param botAdministratorRights:  listing the required administrator rights of the bot in the chat. The rights must
     *                                 be a subset of {@link #userAdministratorRights}. If not specified, no additional restrictions are applied
     * @param botIsMember:             pass True to request a chat with the bot as a member. Otherwise, no additional restrictions
     *                                 are applied
     */
    public KeyboardButtonRequestChat(long requestId, boolean chatIsChannel, boolean chatIsForum, boolean chatHasUsername,
                                     boolean chatIsCreated, ChatAdministratorRights userAdministratorRights,
                                     ChatAdministratorRights botAdministratorRights, boolean botIsMember) {
        super(null);
        this.requestId = requestId;
        this.chatIsChannel = chatIsChannel;
        this.chatIsForum = chatIsForum;
        this.chatHasUsername = chatHasUsername;
        this.chatIsCreated = chatIsCreated;
        this.userAdministratorRights = userAdministratorRights;
        this.botAdministratorRights = botAdministratorRights;
        this.botIsMember = botIsMember;
    }

    /**
     * Constructor to init a {@link KeyboardButtonRequestChat} object
     *
     * @param jKeyboardButtonRequestChat: keyboard button request chat details as {@link JSONObject}
     */
    public KeyboardButtonRequestChat(JSONObject jKeyboardButtonRequestChat) {
        super(jKeyboardButtonRequestChat);
        requestId = hTelegram.getLong("request_id");
        chatIsChannel = hTelegram.getBoolean("chat_is_channel");
        chatIsForum = hTelegram.getBoolean("chat_is_forum");
        chatHasUsername = hTelegram.getBoolean("chat_has_username");
        chatIsCreated = hTelegram.getBoolean("chat_is_created");
        userAdministratorRights = ChatAdministratorRights
                .getInstance(hTelegram.getJSONObject("user_administrator_rights"));
        botAdministratorRights = ChatAdministratorRights
                .getInstance(hTelegram.getJSONObject("bot_administrator_rights"));
        botIsMember = hTelegram.getBoolean("bot_is_member");
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
     * Method to get {@link #chatIsChannel} instance <br>
     * No-any params required
     *
     * @return {@link #chatIsChannel} instance as boolean
     */
    public boolean chatIsChannel() {
        return chatIsChannel;
    }

    /**
     * Method to get {@link #chatIsForum} instance <br>
     * No-any params required
     *
     * @return {@link #chatIsForum} instance as boolean
     */
    public boolean chatIsForum() {
        return chatIsForum;
    }

    /**
     * Method to get {@link #chatHasUsername} instance <br>
     * No-any params required
     *
     * @return {@link #chatHasUsername} instance as boolean
     */
    public boolean chatHasUsername() {
        return chatHasUsername;
    }

    /**
     * Method to get {@link #chatIsCreated} instance <br>
     * No-any params required
     *
     * @return {@link #chatIsCreated} instance as boolean
     */
    public boolean chatIsCreated() {
        return chatIsCreated;
    }

    /**
     * Method to get {@link #userAdministratorRights} instance <br>
     * No-any params required
     *
     * @return {@link #userAdministratorRights} instance as {@link ChatAdministratorRights}
     */
    public ChatAdministratorRights getUserAdministratorRights() {
        return userAdministratorRights;
    }

    /**
     * Method to get {@link #botAdministratorRights} instance <br>
     * No-any params required
     *
     * @return {@link #botAdministratorRights} instance as {@link ChatAdministratorRights}
     */
    public ChatAdministratorRights getBotAdministratorRights() {
        return botAdministratorRights;
    }

    /**
     * Method to get {@link #botIsMember} instance <br>
     * No-any params required
     *
     * @return {@link #botIsMember} instance as boolean
     */
    public boolean isBotMember() {
        return botIsMember;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link KeyboardButtonRequestChat}
     */
    public static KeyboardButtonRequestChat getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new KeyboardButtonRequestChat(jItem);
    }

}
