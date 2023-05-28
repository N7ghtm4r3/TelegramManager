package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import org.json.JSONObject;

public class InputMessageContent {

    private InputMessageContent() {
    }

    public static <T> T getInputMessageContent(JSONObject jInputMessageContent) {
        if (jInputMessageContent.has("disable_web_page_preview"))
            return (T) new InputTextMessageContent(jInputMessageContent);
        else if (jInputMessageContent.has("proximity_alert_radius"))
            return (T) new InputLocationMessageContent(jInputMessageContent);
        else if (jInputMessageContent.has("address"))
            return (T) new InputVenueMessageContent(jInputMessageContent);
        else if (jInputMessageContent.has("vcard"))
            return (T) new InputContactMessageContent(jInputMessageContent);
        else if (jInputMessageContent.has("suggested_tip_amounts"))
            return (T) new InputInvoiceMessageContent(jInputMessageContent);
        else
            return null;
    }

}
