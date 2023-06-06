package com.tecknobit.telegrammanager.botapi.managers.bot.records.scopes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.managers.bot.records.scopes.BotCommandScopeDefault.BotCommandScopeType.all_private_chats;

/**
 * The {@code BotCommandScopeAllPrivateChats} class is useful to format a {@code Telegram}'s bot command scope all private chats
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="">
 * BotCommandScopeAllPrivateChats</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see BotCommandScopeDefault
 */
public class BotCommandScopeAllPrivateChats extends BotCommandScopeDefault {

    /**
     * Constructor to init a {@link BotCommandScopeAllPrivateChats} object<br>
     * No-any params required
     */
    public BotCommandScopeAllPrivateChats() {
        super(all_private_chats);
    }

    /**
     * Constructor to init a {@link BotCommandScopeAllPrivateChats} object
     *
     * @param jBotCommandScopeAllPrivateChats: bot command scope all private chats details as {@link JSONObject}
     */
    public BotCommandScopeAllPrivateChats(JSONObject jBotCommandScopeAllPrivateChats) {
        super(jBotCommandScopeAllPrivateChats);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotCommandScopeAllPrivateChats}
     */
    public static BotCommandScopeAllPrivateChats getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotCommandScopeAllPrivateChats(jItem);
    }

}
