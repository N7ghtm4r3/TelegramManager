package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

@Structure
public abstract class InlineQueryResult extends TelegramType {

    public enum InlineQueryResultType {

        article,

        photo,

        gif,

        mpeg4_gif,

        video,

        audio,

        voice,

        document,

        location,

        venue,

        contact,

        game,

        sticker

    }

    protected final InlineQueryResultType type;

    protected final String id;

    public InlineQueryResult(InlineQueryResultType type, String id) {
        super(null);
        this.type = type;
        this.id = id;
    }

    public InlineQueryResult(JSONObject jInlineQueryResult) {
        super(jInlineQueryResult);
        type = InlineQueryResultType.valueOf(hTelegram.getString("type"));
        id = hTelegram.getString("id");
    }

    public InlineQueryResultType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

}
