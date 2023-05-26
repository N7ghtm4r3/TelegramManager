package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import org.json.JSONObject;

public class ForumTopicCreated extends ForumTopicEdited {

    private final int iconColor;

    public ForumTopicCreated(String name, String iconCustomEmojiId, int iconColor) {
        super(name, iconCustomEmojiId);
        this.iconColor = iconColor;
    }

    public ForumTopicCreated(JSONObject jForumTopicCreated) {
        super(jForumTopicCreated);
        iconColor = hTelegram.getInt("icon_color");
    }

    public int getIconColor() {
        return iconColor;
    }

    public static ForumTopicCreated getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopicCreated(jItem);
    }

}
