package com.tecknobit.telegrammanager.botapi.managers.inline.records;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.Location;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ChosenInlineResult} class is useful to format a {@code Telegram}'s chosen inline result
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#choseninlineresult">
 * ChosenInlineResult</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ChosenInlineResult extends TelegramType {

    /**
     * {@code resultId} the unique identifier for the result that was chosen
     */
    private final String resultId;

    /**
     * {@code from} the user that chose the result
     */
    private final User from;

    /**
     * {@code location} sender location, only for bots that require user location
     */
    private final Location location;

    /**
     * {@code inlineMessageId} identifier of the sent inline message
     */
    private final String inlineMessageId;

    /**
     * {@code query} the query that was used to obtain the result
     */
    private final String query;

    /**
     * Constructor to init a {@link ChosenInlineResult} object
     *
     * @param resultId:        the unique identifier for the result that was chosen
     * @param from:            the user that chose the result
     * @param location:        sender location, only for bots that require user location
     * @param inlineMessageId: identifier of the sent inline message
     * @param query:           the query that was used to obtain the result
     */
    public ChosenInlineResult(String resultId, User from, Location location, String inlineMessageId, String query) {
        super(null);
        this.resultId = resultId;
        this.from = from;
        this.location = location;
        this.inlineMessageId = inlineMessageId;
        this.query = query;
    }

    /**
     * Constructor to init a {@link ChosenInlineResult} object
     *
     * @param jChosenInlineResult: chosen inline result details as {@link JSONObject}
     */
    public ChosenInlineResult(JSONObject jChosenInlineResult) {
        super(jChosenInlineResult);
        resultId = hTelegram.getString("result_id");
        from = new User(hTelegram.getJSONObject("from"));
        location = Location.getInstance(hTelegram.getJSONObject("location"));
        inlineMessageId = hTelegram.getString("inline_message_id");
        query = hTelegram.getString("query");
    }

    /**
     * Method to get {@link #resultId} instance <br>
     * No-any params required
     *
     * @return {@link #resultId} instance as {@link String}
     */
    public String getResultId() {
        return resultId;
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
     * Method to get {@link #inlineMessageId} instance <br>
     * No-any params required
     *
     * @return {@link #inlineMessageId} instance as {@link String}
     */
    public String getInlineMessageId() {
        return inlineMessageId;
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
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChosenInlineResult}
     */
    public static ChosenInlineResult getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChosenInlineResult(jItem);
    }

}
