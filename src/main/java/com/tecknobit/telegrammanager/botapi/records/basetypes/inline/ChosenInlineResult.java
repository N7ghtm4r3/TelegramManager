package com.tecknobit.telegrammanager.botapi.records.basetypes.inline;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.Location;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class ChosenInlineResult extends TelegramType {

    private final String resultId;

    private final User from;

    private final Location location;

    private final String inlineMessageId;

    private final String query;

    public ChosenInlineResult(String resultId, User from, Location location, String inlineMessageId, String query) {
        super(null);
        this.resultId = resultId;
        this.from = from;
        this.location = location;
        this.inlineMessageId = inlineMessageId;
        this.query = query;
    }

    public ChosenInlineResult(JSONObject jChosenInlineResult) {
        super(jChosenInlineResult);
        resultId = hTelegram.getString("result_id");
        from = new User(hTelegram.getJSONObject("from"));
        location = Location.getInstance(hTelegram.getJSONObject("location"));
        inlineMessageId = hTelegram.getString("inline_message_id");
        query = hTelegram.getString("query");
    }

    public String getResultId() {
        return resultId;
    }

    public User getFrom() {
        return from;
    }

    public Location getLocation() {
        return location;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public String getQuery() {
        return query;
    }

    public static ChosenInlineResult getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChosenInlineResult(jItem);
    }

}
