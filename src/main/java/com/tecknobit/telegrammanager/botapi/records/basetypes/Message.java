package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class Message extends TelegramType {


    public static Message getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Message(jItem);
    }

}
