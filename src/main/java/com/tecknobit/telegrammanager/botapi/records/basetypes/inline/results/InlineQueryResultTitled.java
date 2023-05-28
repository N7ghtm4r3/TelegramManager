package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.apimanager.annotations.Structure;
import org.json.JSONObject;

@Structure
public abstract class InlineQueryResultTitled extends InlineQueryResult {

    protected final String title;

    public InlineQueryResultTitled(InlineQueryResultType type, String id, String title) {
        super(type, id);
        this.title = title;
    }

    public InlineQueryResultTitled(JSONObject jInlineQueryResultTitled) {
        super(jInlineQueryResultTitled);
        title = hTelegram.getString("title");
    }

    public String getTitle() {
        return title;
    }

}
