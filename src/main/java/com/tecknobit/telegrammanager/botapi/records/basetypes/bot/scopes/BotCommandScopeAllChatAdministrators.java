package com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes;

import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes.BotCommandScopeDefault.BotCommandScopeType.all_chat_administrators;

public class BotCommandScopeAllChatAdministrators extends BotCommandScopeDefault {

    public BotCommandScopeAllChatAdministrators() {
        super(all_chat_administrators);
    }

    public BotCommandScopeAllChatAdministrators(JSONObject jBotCommandScopeAllChatAdministrators) {
        super(jBotCommandScopeAllChatAdministrators);
    }

    public static BotCommandScopeAllChatAdministrators getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotCommandScopeAllChatAdministrators(jItem);
    }

}
