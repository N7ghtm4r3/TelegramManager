package com.tecknobit.telegrammanager.botapi.records;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONObject;

@Structure
public abstract class TelegramTypeStructure {

    protected final JsonHelper hTelegram;

    public TelegramTypeStructure(JSONObject jTelegramTypeStructure) {
        if (jTelegramTypeStructure == null)
            hTelegram = null;
        else
            hTelegram = new JsonHelper(jTelegramTypeStructure);
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

}
