package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code GeneralForumTopicUnhidden} class is useful to format a {@code Telegram}'s general forum topic unhidden
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#generalforumtopicunhidden">
 * GeneralForumTopicUnhidden</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class GeneralForumTopicUnhidden extends TelegramType {

    /**
     * Constructor to init a {@link GeneralForumTopicUnhidden} object
     *
     * @param jGeneralForumTopicUnhidden: general forum topic unhidden details as {@link JSONObject}
     */
    public GeneralForumTopicUnhidden(JSONObject jGeneralForumTopicUnhidden) {
        super(jGeneralForumTopicUnhidden);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link GeneralForumTopicUnhidden}
     */
    public static GeneralForumTopicUnhidden getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new GeneralForumTopicUnhidden(jItem);
    }

}