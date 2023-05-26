package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ForumTopicCreated} class is useful to format a {@code Telegram}'s forum topic created
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forumtopiccreated">
 * ForumTopicCreated</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ForumTopicEdited
 */
public class ForumTopicCreated extends ForumTopicEdited {

    /**
     * {@code iconColor} color of the topic icon in RGB format
     */
    private final int iconColor;

    /**
     * Constructor to init a {@link ForumTopicCreated} object
     *
     * @param name:              color of the topic icon in RGB format
     * @param iconCustomEmojiId: new identifier of the custom emoji shown as the topic icon, if it was edited; an empty
     *                           string if the icon was removed
     * @param iconColor:         {@code iconColor} of the
     */
    public ForumTopicCreated(String name, String iconCustomEmojiId, int iconColor) {
        super(name, iconCustomEmojiId);
        this.iconColor = iconColor;
    }

    /**
     * Constructor to init a {@link ForumTopicCreated} object
     *
     * @param jForumTopicCreated: forum topic created details as {@link JSONObject}
     */
    public ForumTopicCreated(JSONObject jForumTopicCreated) {
        super(jForumTopicCreated);
        iconColor = hTelegram.getInt("icon_color");
    }

    /**
     * Method to get {@link #iconColor} instance <br>
     * No-any params required
     *
     * @return {@link #iconColor} instance as int
     */
    public int getIconColor() {
        return iconColor;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ForumTopicCreated}
     */
    public static ForumTopicCreated getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopicCreated(jItem);
    }

}
