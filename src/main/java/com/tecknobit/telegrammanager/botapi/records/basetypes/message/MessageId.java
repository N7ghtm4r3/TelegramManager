package com.tecknobit.telegrammanager.botapi.records.basetypes.message;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code MessageId} class is useful to format a {@code Telegram}'s message id
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#messageid">
 * MessageId</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class MessageId extends TelegramType {

    /**
     * {@code messageId} unique message identifier
     */
    private final long messageId;

    /**
     * Constructor to init a {@link MessageId} object
     *
     * @param messageId: unique message identifier
     */
    public MessageId(long messageId) {
        super(null);
        this.messageId = messageId;
    }

    /**
     * Constructor to init a {@link MessageId} object
     *
     * @param jMessageId: message id details as {@link JSONObject}
     */
    public MessageId(JSONObject jMessageId) {
        super(jMessageId);
        messageId = hTelegram.getLong("message_id");
    }

    /**
     * Method to get {@link #messageId} instance <br>
     * No-any params required
     *
     * @return {@link #messageId} instance as long
     */
    public long getMessageId() {
        return messageId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link MessageId}
     */
    public static MessageId getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new MessageId(jItem);
    }

}
