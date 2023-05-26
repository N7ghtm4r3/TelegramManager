package com.tecknobit.telegrammanager.botapi.records.basetypes.chat;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class MessageAutoDeleteTimerChanged extends TelegramType {

    private final long messageAutoDeleteTime;

    public MessageAutoDeleteTimerChanged(long messageAutoDeleteTime) {
        super(null);
        this.messageAutoDeleteTime = messageAutoDeleteTime;
    }

    public MessageAutoDeleteTimerChanged(JSONObject jMessageAutoDeleteTimerChanged) {
        super(jMessageAutoDeleteTimerChanged);
        messageAutoDeleteTime = hTelegram.getLong("message_auto_delete_time");
    }

    public long getMessageAutoDeleteTime() {
        return messageAutoDeleteTime;
    }

    public static MessageAutoDeleteTimerChanged getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new MessageAutoDeleteTimerChanged(jItem);
    }

}
