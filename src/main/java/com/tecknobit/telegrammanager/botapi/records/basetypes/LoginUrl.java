package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class LoginUrl extends TelegramType {

    private final String url;

    private final String forwardText;

    private final String botUsername;

    private final boolean requestWriteAccess;

    public LoginUrl(String url, String forwardText, String botUsername, boolean requestWriteAccess) {
        super(null);
        this.url = url;
        this.forwardText = forwardText;
        this.botUsername = botUsername;
        this.requestWriteAccess = requestWriteAccess;
    }

    public LoginUrl(JSONObject jLoginUrl) {
        super(jLoginUrl);
        url = hTelegram.getString("url");
        forwardText = hTelegram.getString("forward_text");
        botUsername = hTelegram.getString("bot_username");
        requestWriteAccess = hTelegram.getBoolean("request_write_access");
    }

    public String getUrl() {
        return url;
    }

    public String getForwardText() {
        return forwardText;
    }

    public String getBotUsername() {
        return botUsername;
    }

    public boolean isRequestWriteAccess() {
        return requestWriteAccess;
    }

    public static LoginUrl getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new LoginUrl(jItem);
    }

}
