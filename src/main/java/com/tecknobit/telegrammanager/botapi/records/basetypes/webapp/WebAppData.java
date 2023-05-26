package com.tecknobit.telegrammanager.botapi.records.basetypes.webapp;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class WebAppData extends TelegramType {

    private final String data;

    private final String buttonText;

    public WebAppData(String data, String buttonText) {
        super(null);
        this.data = data;
        this.buttonText = buttonText;
    }

    public WebAppData(JSONObject jWebAppData) {
        super(jWebAppData);
        data = hTelegram.getString("data");
        buttonText = hTelegram.getString("button_text");
    }

    public String getData() {
        return data;
    }

    public String getButtonText() {
        return buttonText;
    }

    public static WebAppData getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new WebAppData(jItem);
    }

}
