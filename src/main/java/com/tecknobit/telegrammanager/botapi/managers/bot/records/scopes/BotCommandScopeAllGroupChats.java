package com.tecknobit.telegrammanager.botapi.managers.bot.records.scopes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.managers.bot.records.scopes.BotCommandScopeDefault.BotCommandScopeType.all_group_chats;

/**
 * The {@code BotCommandScopeAllGroupChats} class is useful to format a {@code Telegram}'s bot command scope all group chats
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#botcommandscopeallgroupchats">
 * BotCommandScopeAllGroupChats</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see BotCommandScopeDefault
 */
public class BotCommandScopeAllGroupChats extends BotCommandScopeDefault {

    /**
     * Constructor to init a {@link BotCommandScopeAllGroupChats} object <br>
     * No-any params required
     */
    public BotCommandScopeAllGroupChats() {
        super(all_group_chats);
    }

    /**
     * Constructor to init a {@link BotCommandScopeAllGroupChats} object
     *
     * @param jBotCommandScopeAllGroupChats: bot command scope all group chats details as {@link JSONObject}
     */
    public BotCommandScopeAllGroupChats(JSONObject jBotCommandScopeAllGroupChats) {
        super(jBotCommandScopeAllGroupChats);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotCommandScopeAllGroupChats}
     */
    public static BotCommandScopeAllGroupChats getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotCommandScopeAllGroupChats(jItem);
    }

}
