package com.tecknobit.telegrammanager.botapi.records.basetypes.inline;

import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat.ChatType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.Location;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.structures.QueryStructure;
import org.json.JSONObject;

public class InlineQuery extends QueryStructure {

    private final String query;

    private final String offset;

    private final ChatType chatType;

    private final Location location;

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

    public String getQuery() {
        return query;
    }

    public String getOffset() {
        return offset;
    }

    public ChatType getChatType() {
        return chatType;
    }

    public Location getLocation() {
        return location;
    }

    public static InlineQuery getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQuery(jItem);
    }

}
