package com.tecknobit.telegrammanager.botapi.records.basetypes.media.videochatstates;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class VideoChatEnded extends TelegramType {

    private final int duration;

    public VideoChatEnded(int duration) {
        super(null);
        this.duration = duration;
    }

    public VideoChatEnded(JSONObject jVideoChatEnded) {
        super(jVideoChatEnded);
        duration = hTelegram.getInt("duration");
    }

    public int getDuration() {
        return duration;
    }

    public static VideoChatEnded getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new VideoChatEnded(jItem);
    }

}
