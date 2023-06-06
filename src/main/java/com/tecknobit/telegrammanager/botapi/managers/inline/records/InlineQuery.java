package com.tecknobit.telegrammanager.botapi.managers.inline.records;

import com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.Chat.ChatType;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.Location;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.QueryStructure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code InlineQuery} class is useful to format a {@code Telegram}'s inline query
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequery">
 * InlineQuery</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see QueryStructure
 */
public class InlineQuery extends QueryStructure {

    /**
     * {@code query} text of the query (up to 256 characters)
     */
    private final String query;

    /**
     * {@code offset} of the results to be returned, can be controlled by the bot
     */
    private final String offset;

    /**
     * {@code chatType} type of the chat from which the inline query was sent
     */
    private final ChatType chatType;

    /**
     * {@code location} sender location, only for bots that request user location
     */
    private final Location location;

    /**
     * Constructor to init a {@link InlineQuery} object
     * @param id:   unique identifier for this query
     * @param from: sender
     @param query: text of the query (up to 256 characters)
     @param offset: offset of the results to be returned, can be controlled by the bot
     @param chatType: type of the chat from which the inline query was sent
     @param location: sender location, only for bots that request user location

     */
    public InlineQuery(String id, User from, String query, String offset, ChatType chatType, Location location) {
        super(id, from);
        this.query = query;
        this.offset = offset;
        this.chatType = chatType;
        this.location = location;
    }

    /**
     * Constructor to init a {@link InlineQuery} object
     *
     * @param jInlineQuery : inline query details as {@link JSONObject}
     */
    public InlineQuery(JSONObject jInlineQuery) {
        super(jInlineQuery);
        query = hTelegram.getString("query");
        offset = hTelegram.getString("offset");
        chatType = ChatType.getInstance(hTelegram.getString("chat_type"));
        location = Location.getInstance(hTelegram.getJSONObject("location"));
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
     * Method to get {@link #offset} instance <br>
     * No-any params required
     *
     * @return {@link #offset} instance as {@link String}
     */
    public String getOffset() {
        return offset;
    }

    /**
     * Method to get {@link #chatType} instance <br>
     * No-any params required
     *
     * @return {@link #chatType} instance as {@link ChatType}
     */
    public ChatType getChatType() {
        return chatType;
    }

    /**
     * Method to get {@link #location} instance <br>
     * No-any params required
     *
     * @return {@link #location} instance as {@link Location}
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQuery}
     */
    public static InlineQuery getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQuery(jItem);
    }

}
