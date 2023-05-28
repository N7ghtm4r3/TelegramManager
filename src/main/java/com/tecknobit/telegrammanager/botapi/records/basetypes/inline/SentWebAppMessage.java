package com.tecknobit.telegrammanager.botapi.records.basetypes.inline;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class SentWebAppMessage extends TelegramType {

    public static SentWebAppMessage getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new SentWebAppMessage(jItem);
    }

}
