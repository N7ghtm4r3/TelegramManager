package com.tecknobit.telegrammanager.botapi.records.basetypes.media.videochatstates;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class VideoChatScheduled extends TelegramType {

    private final long startDate;

    public VideoChatScheduled(long startDate) {
        super(null);
        this.startDate = startDate;
    }

    public VideoChatScheduled(JSONObject jVideoChatScheduled) {
        super(jVideoChatScheduled);
        startDate = hTelegram.getLong("start_date");
    }

    public long getStartDate() {
        return startDate;
    }

    public static VideoChatScheduled getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new VideoChatScheduled(jItem);
    }

}
