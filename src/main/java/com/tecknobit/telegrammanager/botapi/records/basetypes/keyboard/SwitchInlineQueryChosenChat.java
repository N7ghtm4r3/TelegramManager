package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code SwitchInlineQueryChosenChat} class is useful to format a {@code Telegram}'s switch inline query chosen chat
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#switchinlinequerychosenchat">
 * SwitchInlineQueryChosenChat</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class SwitchInlineQueryChosenChat extends TelegramType {

    /**
     * {@code query} the default inline query to be inserted in the input field. If left empty, only the bot's username
     * will be inserted
     */
    private final String query;

    /**
     * {@code allowUserChats} if private chats with users can be chosen
     */
    private final boolean allowUserChats;

    /**
     * {@code allowBotChats} if private chats with bots can be chosen
     */
    private final boolean allowBotChats;

    /**
     * {@code allowGroupChats} if group and supergroup chats can be chosen
     */
    private final boolean allowGroupChats;

    /**
     * {@code allowChannelChats} if channel chats can be chosen
     */
    private final boolean allowChannelChats;

    /**
     * Constructor to init a {@link SwitchInlineQueryChosenChat} object
     *
     * @param query:             the default inline query to be inserted in the input field. If left empty, only the bot's username
     *                           will be inserted
     * @param allowUserChats:    if private chats with users can be chosen
     * @param allowBotChats:     if private chats with bots can be chosen
     * @param allowGroupChats:   if group and supergroup chats can be chosen
     * @param allowChannelChats: if channel chats can be chosen
     */
    public SwitchInlineQueryChosenChat(String query, boolean allowUserChats, boolean allowBotChats,
                                       boolean allowGroupChats, boolean allowChannelChats) {
        super(null);
        this.query = query;
        this.allowUserChats = allowUserChats;
        this.allowBotChats = allowBotChats;
        this.allowGroupChats = allowGroupChats;
        this.allowChannelChats = allowChannelChats;
    }

    /**
     * Constructor to init a {@link SwitchInlineQueryChosenChat} object
     *
     * @param jSwitchInlineQueryChosenChat: switch inline query chosen chat details as {@link JSONObject}
     */
    public SwitchInlineQueryChosenChat(JSONObject jSwitchInlineQueryChosenChat) {
        super(jSwitchInlineQueryChosenChat);
        query = hTelegram.getString("query");
        allowUserChats = hTelegram.getBoolean("allow_user_chats");
        allowBotChats = hTelegram.getBoolean("allow_bot_chats");
        allowGroupChats = hTelegram.getBoolean("allow_group_chats");
        allowChannelChats = hTelegram.getBoolean("allow_channel_chats");
    }

    /**
     * Method to get {@link #query} instance <br>
     * No-any params required
     *
     * @return {@link #query} instance as {@link String}
     */
    public String getQuery() {
        return query;
    }

    /**
     * Method to get {@link #allowUserChats} instance <br>
     * No-any params required
     *
     * @return {@link #allowUserChats} instance as boolean
     */
    public boolean isAllowedUserChats() {
        return allowUserChats;
    }

    /**
     * Method to get {@link #allowBotChats} instance <br>
     * No-any params required
     *
     * @return {@link #allowBotChats} instance as boolean
     */
    public boolean isAllowedBotChats() {
        return allowBotChats;
    }

    /**
     * Method to get {@link #allowGroupChats} instance <br>
     * No-any params required
     *
     * @return {@link #allowGroupChats} instance as boolean
     */
    public boolean isAllowedGroupChats() {
        return allowGroupChats;
    }

    /**
     * Method to get {@link #allowChannelChats} instance <br>
     * No-any params required
     *
     * @return {@link #allowChannelChats} instance as boolean
     */
    public boolean isAllowedChannelChats() {
        return allowChannelChats;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link SwitchInlineQueryChosenChat}
     */
    public static SwitchInlineQueryChosenChat getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new SwitchInlineQueryChosenChat(jItem);
    }

}
