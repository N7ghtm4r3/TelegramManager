package com.tecknobit.telegrammanager.botapi.records.basetypes.inline;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class SentWebAppMessage extends TelegramType {

    private final String inlineMessageId;

    public SentWebAppMessage(String inlineMessageId) {
        super(null);
        this.inlineMessageId = inlineMessageId;
    }

    public SentWebAppMessage(JSONObject jSentWebAppMessage) {
        super(jSentWebAppMessage);
        inlineMessageId = hTelegram.getString("inline_message_id");
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public static SentWebAppMessage getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new SentWebAppMessage(jItem);
    }

}
