package com.tecknobit.telegrammanager.botapi.managers.identifiers.forum.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code GeneralForumTopicHidden} class is useful to format a {@code Telegram}'s general forum topic hidden
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#generalforumtopichidden">
 * GeneralForumTopicHidden</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class GeneralForumTopicHidden extends TelegramType {

    /**
     * Constructor to init a {@link GeneralForumTopicHidden} object
     *
     * @param jGeneralForumTopicHidden: general forum topic hidden details as {@link JSONObject}
     */
    public GeneralForumTopicHidden(JSONObject jGeneralForumTopicHidden) {
        super(jGeneralForumTopicHidden);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link GeneralForumTopicHidden}
     */
    public static GeneralForumTopicHidden getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new GeneralForumTopicHidden(jItem);
    }

}
