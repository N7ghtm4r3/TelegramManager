package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class CallbackGame extends TelegramType {

    public CallbackGame(JSONObject jCallbackGame) {
        super(jCallbackGame);
    }

    public static CallbackGame getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new CallbackGame(jItem);
    }

}
