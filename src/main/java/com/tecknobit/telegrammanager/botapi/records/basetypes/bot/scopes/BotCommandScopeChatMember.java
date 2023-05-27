package com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes.BotCommandScopeDefault.BotCommandScopeType.chat_member;

/**
 * The {@code BotCommandScopeChatMember} class is useful to format a {@code Telegram}'s bot command scope chat member
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#botcommandscopechatmember">
 * BotCommandScopeChatMember</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see BotCommandScopeDefault
 * @see BotCommandScopeChat
 */
public class BotCommandScopeChatMember extends BotCommandScopeChat {

    /**
     * {@code userId}
     */
    private final long userId;

    /**
     * Constructor to init a {@link BotCommandScopeChatMember} object
     *
     * @param chatId: unique identifier for the target chat or username of the target supergroup
     * @param userId: unique identifier of the target user
     */
    public BotCommandScopeChatMember(String chatId, long userId) {
        super(chat_member, chatId);
        this.userId = userId;
    }

    /**
     * Constructor to init a {@link BotCommandScopeChatMember} object
     *
     * @param jBotCommandScopeChatMember: bot command scope chat member details as {@link JSONObject}
     */
    public BotCommandScopeChatMember(JSONObject jBotCommandScopeChatMember) {
        super(jBotCommandScopeChatMember);
        userId = hTelegram.getLong("user_id");
    }

    /**
     * Method to get {@link #userId} instance <br>
     * No-any params required
     *
     * @return {@link #userId} instance as long
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotCommandScopeChatMember}
     */
    public static BotCommandScopeChatMember getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotCommandScopeChatMember(jItem);
    }

}
