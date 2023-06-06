package com.tecknobit.telegrammanager.botapi.managers.inline.records.inputmessage;

import org.json.JSONObject;

/**
 * The {@code InputMessageContent} class is useful to format manage all the input message contents
 *
 * @author N7ghtm4r3 - Tecknobit
 */
public class InputMessageContent {

    /**
     * Constructor to init a {@link InputMessageContent} object <br>
     * No-any params required
     */
    private InputMessageContent() {
    }

    /**
     * Method to instantiate and return the correct {@link InputMessageContent}
     *
     * @param jInputMessageContent: source as {@link JSONObject}
     * @return an instance of {@link InputMessageContent} in the correct format
     */
    public static <T> T getInputMessageContent(JSONObject jInputMessageContent) {
        if (jInputMessageContent != null) {
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
        }
        return null;
    }

    /**
     * The {@code InputMessageContentType} interface to mark an {@link InputMessageContent}
     *
     * @author N7ghtm4r3 - Tecknobit
     */
    public interface InputMessageContentType {
    }

}
