package com.tecknobit.telegrammanager.botapi.records.basetypes.webapp;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class WebAppInfo extends TelegramType {

    private final String url;

    public WebAppInfo(String url) {
        super(null);
        this.url = url;
    }

    public WebAppInfo(JSONObject jWebAppInfo) {
        super(jWebAppInfo);
        url = hTelegram.getString("url");
    }

    public String getUrl() {
        return url;
    }

    public static WebAppInfo getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new WebAppInfo(jItem);
    }

}
