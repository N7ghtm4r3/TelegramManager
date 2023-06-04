package com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes.BotCommandScopeDefault.BotCommandScopeType.chat;

/**
 * The {@code BotCommandScopeChat} class is useful to format a {@code Telegram}'s bot command scope chat
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#botcommandscopechat">
 * BotCommandScopeChat</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see BotCommandScopeDefault
 */
public class BotCommandScopeChat extends BotCommandScopeDefault {

    /**
     * {@code mChatId} unique identifier for the target chat or username of the target supergroup
     */
    protected final String chatId;

    /**
     * Constructor to init a {@link BotCommandScopeChat} object
     *
     * @param chatId: unique identifier for the target chat or username of the target supergroup
     */
    public BotCommandScopeChat(String chatId) {
        this(chat, chatId);
    }

    /**
     * Constructor to init a {@link BotCommandScopeChat} object
     *
     * @param type:   scope type
     * @param chatId: unique identifier for the target chat or username of the target supergroup
     */
    public BotCommandScopeChat(BotCommandScopeType type, String chatId) {
        super(type);
        this.chatId = chatId;
    }

    /**
     * Constructor to init a {@link BotCommandScopeChat} object
     *
     * @param jBotCommandScopeChat: bot command scope chat details as {@link JSONObject}
     */
    public BotCommandScopeChat(JSONObject jBotCommandScopeChat) {
        super(jBotCommandScopeChat);
        chatId = hTelegram.getString("chat_id");
    }

    /**
     * Method to get {@link #chatId} instance <br>
     * No-any params required
     *
     * @return {@link #chatId} instance as {@link String}
     */
    public String getChatId() {
        return chatId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotCommandScopeChat}
     */
    public static BotCommandScopeChat getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotCommandScopeChat(jItem);
    }

}
