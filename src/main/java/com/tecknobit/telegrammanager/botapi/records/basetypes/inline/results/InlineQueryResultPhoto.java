package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.InlineQuery;
import org.json.JSONObject;

public class InlineQueryResultPhoto {

    public static InlineQuery getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQuery(jItem);
    }

}
