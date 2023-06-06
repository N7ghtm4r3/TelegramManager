package com.tecknobit.telegrammanager.botapi.managers.identifiers.forum.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ForumTopicClosed} class is useful to format a {@code Telegram}'s forum topic closed
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forumtopicclosed">
 * ForumTopicClosed</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ForumTopicClosed extends TelegramType {

    /**
     * Constructor to init a {@link ForumTopicClosed} object
     *
     * @param jForumTopicClosed: forum topic closed details as {@link JSONObject}
     */
    public ForumTopicClosed(JSONObject jForumTopicClosed) {
        super(jForumTopicClosed);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ForumTopicClosed}
     */
    public static ForumTopicClosed getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopicClosed(jItem);
    }

}
