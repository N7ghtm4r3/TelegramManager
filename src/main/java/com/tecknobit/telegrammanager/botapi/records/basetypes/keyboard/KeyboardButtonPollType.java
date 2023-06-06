package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.attachments.Poll.PollType;

/**
 * The {@code KeyboardButtonPollType} class is useful to format a {@code Telegram}'s keyboard button poll type
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#keyboardbuttonpolltype">
 * KeyboardButtonPollType</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class KeyboardButtonPollType extends TelegramType {

    /**
     * {@code type} if {@link PollType#quiz} is passed, the user will be allowed to create only polls in the quiz mode.
     * If {@link PollType#regular} is passed, only regular polls will be allowed. Otherwise, the user will be allowed to
     * create a poll of any type
     */
    private final PollType type;

    /**
     * Constructor to init a {@link KeyboardButtonPollType} object
     *
     * @param type: if {@link PollType#quiz} is passed, the user will be allowed to create only polls in the quiz mode.
     *              If {@link PollType#regular} is passed, only regular polls will be allowed. Otherwise, the user will be
     *              allowed to create a poll of any type
     */
    public KeyboardButtonPollType(PollType type) {
        super(null);
        this.type = type;
    }

    /**
     * Constructor to init a {@link KeyboardButtonPollType} object
     *
     * @param jKeyboardButtonPollType: keyboard button poll type details as {@link JSONObject}
     */
    public KeyboardButtonPollType(JSONObject jKeyboardButtonPollType) {
        super(jKeyboardButtonPollType);
        String sType = hTelegram.getString("");
        if (sType != null)
            type = PollType.valueOf(sType);
        else
            type = null;
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link PollType}
     */
    public PollType getType() {
        return type;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link KeyboardButtonPollType}
     */
    public static KeyboardButtonPollType getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new KeyboardButtonPollType(jItem);
    }

}
