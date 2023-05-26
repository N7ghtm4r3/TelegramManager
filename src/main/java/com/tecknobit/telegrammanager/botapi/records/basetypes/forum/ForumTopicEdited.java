package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class ForumTopicEdited extends TelegramType {

    protected final String name;

    protected final String iconCustomEmojiId;

    public ForumTopicEdited(String name, String iconCustomEmojiId) {
        super(null);
        this.name = name;
        this.iconCustomEmojiId = iconCustomEmojiId;
    }

    public ForumTopicEdited(JSONObject jForumTopicEdited) {
        super(jForumTopicEdited);
        name = hTelegram.getString("icon_color");
        iconCustomEmojiId = hTelegram.getString("icon_custom_emoji_id");
    }

    public String getName() {
        return name;
    }

    public String getIconCustomEmojiId() {
        return iconCustomEmojiId;
    }

    public static ForumTopicEdited getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopicEdited(jItem);
    }

}
