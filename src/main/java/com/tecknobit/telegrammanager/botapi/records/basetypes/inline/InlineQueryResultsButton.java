package com.tecknobit.telegrammanager.botapi.records.basetypes.inline;

import com.tecknobit.telegrammanager.botapi.records.basetypes.webapp.WebAppInfo;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class InlineQueryResultsButton extends TelegramType {

    private final String text;

    private final WebAppInfo webApp;

    private final String startParameter;

    public InlineQueryResultsButton(String text, WebAppInfo webApp, String startParameter) {
        super(null);
        this.text = text;
        this.webApp = webApp;
        this.startParameter = startParameter;
    }

    public InlineQueryResultsButton(JSONObject jInlineQueryResultsButton) {
        super(jInlineQueryResultsButton);
        text = hTelegram.getString("text");
        webApp = WebAppInfo.getInstance(hTelegram.getJSONObject("web_app"));
        startParameter = hTelegram.getString("start_parameter");
    }

    public String getText() {
        return text;
    }

    public WebAppInfo getWebApp() {
        return webApp;
    }

    public String getStartParameter() {
        return startParameter;
    }

    public static InlineQueryResultsButton getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultsButton(jItem);
    }

}
