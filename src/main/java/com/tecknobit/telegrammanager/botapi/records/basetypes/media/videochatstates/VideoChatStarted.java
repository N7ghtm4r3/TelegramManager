package com.tecknobit.telegrammanager.botapi.records.basetypes.media.videochatstates;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class VideoChatStarted extends TelegramType {

    public VideoChatStarted(JSONObject jVideoChatStarted) {
        super(jVideoChatStarted);
    }

    public static VideoChatStarted getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new VideoChatStarted(jItem);
    }

}
