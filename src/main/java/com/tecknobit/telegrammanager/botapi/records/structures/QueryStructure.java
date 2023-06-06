package com.tecknobit.telegrammanager.botapi.records.structures;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import org.json.JSONObject;

/**
 * The {@code QueryStructure} class is useful to format a {@code Telegram}'s query structure
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#callbackquery">
 *             CallbackQuery</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequery">
 *             InlineQuery</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
@Structure
public abstract class QueryStructure extends TelegramType {

    /**
     * {@code id} unique identifier for this query
     */
    protected final String id;

    /**
     * {@code from} sender
     */
    protected final User from;

    /**
     * Constructor to init a {@link QueryStructure} object
     *
     * @param id:   unique identifier for this query
     * @param from: sender
     */
    public QueryStructure(String id, User from) {
        super(null);
        this.id = id;
        this.from = from;
    }

    /**
     * Constructor to init a {@link QueryStructure} object
     *
     * @param jQueryStructure: query structure details as {@link JSONObject}
     */
    public QueryStructure(JSONObject jQueryStructure) {
        super(jQueryStructure);
        id = hTelegram.getString("id");
        from = new User(hTelegram.getJSONObject("from"));
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     */
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #from} instance <br>
     * No-any params required
     *
     * @return {@link #from} instance as {@link User}
     */
    public User getFrom() {
        return from;
    }

}
