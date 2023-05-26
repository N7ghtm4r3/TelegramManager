package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class ForumTopicClosed extends TelegramType {

    public ForumTopicClosed(JSONObject jForumTopicClosed) {
        super(jForumTopicClosed);
    }

    public static ForumTopicClosed getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopicClosed(jItem);
    }

}
