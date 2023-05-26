package com.tecknobit.telegrammanager.botapi.records.basetypes.chat;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code MessageAutoDeleteTimerChanged} class is useful to format a {@code Telegram}'s message auto delete timer changed
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#messageautodeletetimerchanged">
 * MessageAutoDeleteTimerChanged</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class MessageAutoDeleteTimerChanged extends TelegramType {

    /**
     * {@code messageAutoDeleteTime} new auto-delete time for messages in the chat; in seconds
     */
    private final int messageAutoDeleteTime;

    /**
     * Constructor to init a {@link MessageAutoDeleteTimerChanged} object
     *
     * @param messageAutoDeleteTime: new auto-delete time for messages in the chat; in seconds
     */
    public MessageAutoDeleteTimerChanged(int messageAutoDeleteTime) {
        super(null);
        this.messageAutoDeleteTime = messageAutoDeleteTime;
    }

    /**
     * Constructor to init a {@link MessageAutoDeleteTimerChanged} object
     *
     * @param jMessageAutoDeleteTimerChanged: message auto delete timer changed as {@link JSONObject}
     */
    public MessageAutoDeleteTimerChanged(JSONObject jMessageAutoDeleteTimerChanged) {
        super(jMessageAutoDeleteTimerChanged);
        messageAutoDeleteTime = hTelegram.getInt("message_auto_delete_time");
    }

    /**
     * Method to get {@link #messageAutoDeleteTime} instance <br>
     * No-any params required
     *
     * @return {@link #messageAutoDeleteTime} instance as long
     */
    public int getMessageAutoDeleteTime() {
        return messageAutoDeleteTime;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link MessageAutoDeleteTimerChanged}
     */
    public static MessageAutoDeleteTimerChanged getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new MessageAutoDeleteTimerChanged(jItem);
    }

}
