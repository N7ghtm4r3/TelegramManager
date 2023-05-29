package com.tecknobit.telegrammanager.botapi.records.basetypes.inline;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code SentWebAppMessage} class is useful to format a {@code Telegram}'s sent WebApp message
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sentwebappmessage">
 * SentWebAppMessage</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class SentWebAppMessage extends TelegramType {

    /**
     * {@code inlineMessageId} identifier of the sent inline message
     */
    private final String inlineMessageId;

    /**
     * Constructor to init a {@link SentWebAppMessage} object
     *
     * @param inlineMessageId: identifier of the sent inline message
     */
    public SentWebAppMessage(String inlineMessageId) {
        super(null);
        this.inlineMessageId = inlineMessageId;
    }

    /**
     * Constructor to init a {@link SentWebAppMessage} object
     *
     * @param jSentWebAppMessage: sent WebApp message details as {@link JSONObject}
     */
    public SentWebAppMessage(JSONObject jSentWebAppMessage) {
        super(jSentWebAppMessage);
        inlineMessageId = hTelegram.getString("inline_message_id");
    }

    /**
     * Method to get {@link #inlineMessageId} instance <br>
     * No-any params required
     *
     * @return {@link #inlineMessageId} instance as {@link String}
     */
    public String getInlineMessageId() {
        return inlineMessageId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link SentWebAppMessage}
     */
    public static SentWebAppMessage getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new SentWebAppMessage(jItem);
    }

}
