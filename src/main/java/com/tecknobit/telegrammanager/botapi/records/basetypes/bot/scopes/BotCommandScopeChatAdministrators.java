package com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes.BotCommandScopeDefault.BotCommandScopeType.chat_administrators;

/**
 * The {@code BotCommandScopeChatAdministrators} class is useful to format a {@code Telegram}'s bot command scope chat administrators
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#botcommandscopechatadministrators">
 * BotCommandScopeChatAdministrators</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see BotCommandScopeDefault
 * @see BotCommandScopeChat
 */
public class BotCommandScopeChatAdministrators extends BotCommandScopeChat {

    /**
     * Constructor to init a {@link BotCommandScopeChatAdministrators} object
     *
     * @param chatId: unique identifier for the target chat or username of the target supergroup
     */
    public BotCommandScopeChatAdministrators(String chatId) {
        super(chat_administrators, chatId);
    }

    /**
     * Constructor to init a {@link BotCommandScopeChatAdministrators} object
     *
     * @param jBotCommandScopeChatAdministrators: bot command scope chat administrators details as {@link JSONObject}
     */
    public BotCommandScopeChatAdministrators(JSONObject jBotCommandScopeChatAdministrators) {
        super(jBotCommandScopeChatAdministrators);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotCommandScopeChatAdministrators}
     */
    public static BotCommandScopeChatAdministrators getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotCommandScopeChatAdministrators(jItem);
    }

}
