package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class WriteAccessAllowed extends TelegramType {

    private final String webAppName;

    public WriteAccessAllowed(String webAppName) {
        super(null);
        this.webAppName = webAppName;
    }

    public WriteAccessAllowed(JSONObject jWriteAccessAllowed) {
        super(jWriteAccessAllowed);
        webAppName = hTelegram.getString("web_app_name");
    }

    public String getWebAppName() {
        return webAppName;
    }

    public static WriteAccessAllowed getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new WriteAccessAllowed(jItem);
    }

}
