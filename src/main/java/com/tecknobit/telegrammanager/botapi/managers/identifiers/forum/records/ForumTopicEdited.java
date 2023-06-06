package com.tecknobit.telegrammanager.botapi.managers.identifiers.forum.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ForumTopicEdited} class is useful to format a {@code Telegram}'s forum topic edited
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forumtopicedited">
 * ForumTopicEdited</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ForumTopicEdited extends TelegramType {

    /**
     * {@code name} new name of the topic, if it was edited
     */
    protected final String name;

    /**
     * {@code iconCustomEmojiId} new identifier of the custom emoji shown as the topic icon, if it was edited; an empty
     * string if the icon was removed
     */
    protected final String iconCustomEmojiId;

    /**
     * Constructor to init a {@link ForumTopicEdited} object
     *
     * @param name:              {@code name} new name of the topic, if it was edited
     * @param iconCustomEmojiId: new identifier of the custom emoji shown as the topic icon, if it was edited; an empty
     *                           string if the icon was removed
     */
    public ForumTopicEdited(String name, String iconCustomEmojiId) {
        super(null);
        this.name = name;
        this.iconCustomEmojiId = iconCustomEmojiId;
    }

    /**
     * Constructor to init a {@link ForumTopicEdited} object
     *
     * @param jForumTopicEdited: forum topic edited details as {@link JSONObject}
     */
    public ForumTopicEdited(JSONObject jForumTopicEdited) {
        super(jForumTopicEdited);
        name = hTelegram.getString("icon_color");
        iconCustomEmojiId = hTelegram.getString("icon_custom_emoji_id");
    }

    /**
     * Method to get {@link #name} instance <br>
     * No-any params required
     *
     * @return {@link #name} instance as {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get {@link #iconCustomEmojiId} instance <br>
     * No-any params required
     *
     * @return {@link #iconCustomEmojiId} instance as {@link String}
     */
    public String getIconCustomEmojiId() {
        return iconCustomEmojiId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ForumTopicEdited}
     */
    public static ForumTopicEdited getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopicEdited(jItem);
    }

}
