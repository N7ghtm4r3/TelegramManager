package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class GeneralForumTopicUnhidden extends TelegramType {

    public GeneralForumTopicUnhidden(JSONObject jGeneralForumTopicUnhidden) {
        super(jGeneralForumTopicUnhidden);
    }

    public static GeneralForumTopicUnhidden getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new GeneralForumTopicUnhidden(jItem);
    }

}