package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class SwitchInlineQueryChosenChat extends TelegramType {

    private final String query;

    private final boolean allowUserChats;

    private final boolean allowBotChats;

    private final boolean allowGroupChats;

    private final boolean allowChannelChats;

    public SwitchInlineQueryChosenChat(String query, boolean allowUserChats, boolean allowBotChats,
                                       boolean allowGroupChats, boolean allowChannelChats) {
        super(null);
        this.query = query;
        this.allowUserChats = allowUserChats;
        this.allowBotChats = allowBotChats;
        this.allowGroupChats = allowGroupChats;
        this.allowChannelChats = allowChannelChats;
    }

    public SwitchInlineQueryChosenChat(JSONObject jSwitchInlineQueryChosenChat) {
        super(jSwitchInlineQueryChosenChat);
        query = hTelegram.getString("query");
        allowUserChats = hTelegram.getBoolean("allow_user_chats");
        allowBotChats = hTelegram.getBoolean("allow_bot_chats");
        allowGroupChats = hTelegram.getBoolean("allow_group_chats");
        allowChannelChats = hTelegram.getBoolean("allow_channel_chats");
    }

    public String getQuery() {
        return query;
    }

    public boolean isAllowedUserChats() {
        return allowUserChats;
    }

    public boolean isAllowedBotChats() {
        return allowBotChats;
    }

    public boolean isAllowedGroupChats() {
        return allowGroupChats;
    }

    public boolean isAllowedChannelChats() {
        return allowChannelChats;
    }

    public static SwitchInlineQueryChosenChat getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new SwitchInlineQueryChosenChat(jItem);
    }

}
