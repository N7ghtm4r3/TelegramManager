package com.tecknobit.telegrammanager.botapi.records.basetypes.inline;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class ChosenInlineResult extends TelegramType {

    public static ChosenInlineResult getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChosenInlineResult(jItem);
    }

}
