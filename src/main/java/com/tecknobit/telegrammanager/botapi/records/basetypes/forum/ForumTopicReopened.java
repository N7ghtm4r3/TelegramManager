package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ForumTopicReopened} class is useful to format a {@code Telegram}'s forum topic reopened
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forumtopicreopened">
 * ForumTopicReopened </a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ForumTopicReopened extends TelegramType {

    /**
     * Constructor to init a {@link ForumTopicReopened} object
     *
     * @param jForumTopicClosed: forum topic reopened details as {@link JSONObject}
     */
    public ForumTopicReopened(JSONObject jForumTopicClosed) {
        super(jForumTopicClosed);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ForumTopicReopened}
     */
    public static ForumTopicReopened getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopicReopened(jItem);
    }

}
