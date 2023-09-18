package com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code Story} class is useful to format a {@code Telegram}'s story
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#story">
 * Story</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class Story extends TelegramType {

    /**
     * Constructor to init a {@link Story} object
     *
     * @param jStory: story details as {@link JSONObject}
     */
    public Story(JSONObject jStory) {
        super(jStory);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Story}
     */
    public static Story getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Story(jItem);
    }

}
