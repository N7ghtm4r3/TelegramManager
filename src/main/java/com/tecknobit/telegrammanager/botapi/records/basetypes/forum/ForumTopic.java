package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ForumTopic} class is useful to format a {@code Telegram}'s forum topic
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forumtopic">
 * ForumTopic</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ForumTopicEdited
 * @see ForumTopicCreated
 */
public class ForumTopic extends ForumTopicCreated {

    /**
     * {@code messageThreadId} unique identifier of the forum topic
     */
    private final long messageThreadId;

    /**
     * Constructor to init a {@link ForumTopic} object
     *
     * @param name              :              color of the topic icon in RGB format
     * @param iconCustomEmojiId : new identifier of the custom emoji shown as the topic icon, if it was edited; an empty
     *                          string if the icon was removed
     * @param iconColor         :     color of the topic icon in RGB format
     * @param messageThreadId:  unique identifier of the forum topic
     */
    public ForumTopic(String name, String iconCustomEmojiId, int iconColor, long messageThreadId) {
        super(name, iconCustomEmojiId, iconColor);
        this.messageThreadId = messageThreadId;
    }

    /**
     * Constructor to init a {@link ForumTopic} object
     *
     * @param jForumTopic : forum topic details as {@link JSONObject}
     */
    public ForumTopic(JSONObject jForumTopic) {
        super(jForumTopic);
        messageThreadId = hTelegram.getLong("message_thread_id");
    }

    /**
     * Method to get {@link #messageThreadId} instance <br>
     * No-any params required
     *
     * @return {@link #messageThreadId} instance as long
     */
    public long getMessageThreadId() {
        return messageThreadId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ForumTopic}
     */
    public static ForumTopic getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopic(jItem);
    }

}
