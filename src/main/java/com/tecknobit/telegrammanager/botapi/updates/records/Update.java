package com.tecknobit.telegrammanager.botapi.updates.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class Update extends TelegramType {

    public static Update getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Update(jItem);
    }

}
