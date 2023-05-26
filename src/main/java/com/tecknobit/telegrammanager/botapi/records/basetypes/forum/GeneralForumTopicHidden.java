package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class GeneralForumTopicHidden extends TelegramType {

    public GeneralForumTopicHidden(JSONObject jGeneralForumTopicHidden) {
        super(jGeneralForumTopicHidden);
    }

    public static GeneralForumTopicHidden getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new GeneralForumTopicHidden(jItem);
    }

}
