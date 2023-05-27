package com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes.BotCommandScopeDefault.BotCommandScopeType.vDefault;

/**
 * The {@code BotCommandScopeDefault} class is useful to format a {@code Telegram}'s bot command scope default
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#botcommandscopedefault">
 * BotCommandScopeDefault</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class BotCommandScopeDefault extends TelegramType {

    /**
     * {@code BotCommandScopeType} list of available bot command scopes
     */
    public enum BotCommandScopeType {

        /**
         * {@code vDefault} bot command scope
         */
        vDefault("default"),

        /**
         * {@code all_private_chats} bot command scope
         */
        all_private_chats("all_private_chats"),

        /**
         * {@code all_group_chats} v
         */
        all_group_chats("all_group_chats"),

        /**
         * {@code all_chat_administrators} bot command scope
         */
        all_chat_administrators("all_chat_administrators"),

        /**
         * {@code chat}
         */
        chat("chat"),

        /**
         * {@code chat_administrators} bot command scope
         */
        chat_administrators("chat_administrators"),

        /**
         * {@code chat_member} bot command scope
         */
        chat_member("chat_member");

        /**
         * {@code scope} value
         */
        private final String scope;

        /**
         * Constructor to init a {@link BotCommandScopeType} object
         *
         * @param scope: scope value
         */
        BotCommandScopeType(String scope) {
            this.scope = scope;
        }

        /**
         * Method to get {@link #scope} instance <br>
         * No-any params required
         *
         * @return {@link #scope} instance as {@link String}
         */
        public String getScope() {
            return scope;
        }

    }

    /**
     * {@code type} of the scope
     */
    protected final BotCommandScopeType type;

    /**
     * Constructor to init a {@link BotCommandScopeDefault} object <br>
     * No-any params required
     */
    public BotCommandScopeDefault() {
        this(vDefault);
    }

    /**
     * Constructor to init a {@link BotCommandScopeDefault} object
     *
     * @param type: scope type
     */
    public BotCommandScopeDefault(BotCommandScopeType type) {
        super(null);
        this.type = type;
    }

    /**
     * Constructor to init a {@link BotCommandScopeDefault} object
     *
     * @param jBotCommandScopeDefault: bot command scope default details as {@link JSONObject}
     */
    public BotCommandScopeDefault(JSONObject jBotCommandScopeDefault) {
        super(jBotCommandScopeDefault);
        type = BotCommandScopeType.valueOf(hTelegram.getString("type"));
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotCommandScopeDefault}
     */
    public static BotCommandScopeDefault getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotCommandScopeDefault(jItem);
    }

}
