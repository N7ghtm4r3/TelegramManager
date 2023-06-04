package com.tecknobit.telegrammanager.botapi.records.basetypes.message;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat;

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
     * Method to create a message id
     *
     * @param messageIdResponse : obtained from Telegram's response
     * @param format            :       return type formatter -> {@link ReturnFormat}
     * @return message id as {@code "format"} defines
     */
    @Returner
    public static <T> T returnMessageId(String messageIdResponse, ReturnFormat format) {
        return switch (format) {
            case JSON -> (T) new JSONObject(messageIdResponse);
            case LIBRARY_OBJECT -> (T) new MessageId(new JSONObject(messageIdResponse));
            default -> (T) messageIdResponse;
        };
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
