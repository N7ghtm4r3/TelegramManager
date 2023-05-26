package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class ForumTopicReopened extends TelegramType {

    public ForumTopicReopened(JSONObject jForumTopicClosed) {
        super(jForumTopicClosed);
    }

    public static ForumTopicReopened getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopicReopened(jItem);
    }

}
