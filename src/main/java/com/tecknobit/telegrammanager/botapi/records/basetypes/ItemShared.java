package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class ItemShared extends TelegramType {

    private final long requestId;

    private final long itemId;

    public ItemShared(long requestId, long itemId) {
        super(null);
        this.requestId = requestId;
        this.itemId = itemId;
    }

    public ItemShared(JSONObject jItemShared) {
        super(jItemShared);
        requestId = hTelegram.getLong("request_id");
        long tmpId = hTelegram.getLong("user_id", -1);
        if (tmpId == -1)
            tmpId = hTelegram.getLong("chat_id");
        itemId = tmpId;
    }

    public long getRequestId() {
        return requestId;
    }

    public long getItemId() {
        return itemId;
    }

    public static ItemShared getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ItemShared(jItem);
    }

}
