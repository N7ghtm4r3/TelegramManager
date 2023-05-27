package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code Dice} class is useful to format a {@code Telegram}'s dice
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#dice">
 * Dice</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class Dice extends TelegramType {

    /**
     * {@code emoji} emoji on which the dice throw animation is based
     */
    private final String emoji;

    /**
     * {@code value} of the dice
     */
    private final int value;

    /**
     * Constructor to init a {@link Dice} object
     *
     * @param emoji: emoji on which the dice throw animation is based
     * @param value: value of the dice
     */
    public Dice(String emoji, int value) {
        super(null);
        this.emoji = emoji;
        this.value = value;
    }

    /**
     * Constructor to init a {@link Dice} object
     *
     * @param jDice: dice details as {@link JSONObject}
     */
    public Dice(JSONObject jDice) {
        super(jDice);
        emoji = hTelegram.getString("emoji");
        value = hTelegram.getInt("value");
    }

    /**
     * Method to get {@link #emoji} instance <br>
     * No-any params required
     *
     * @return {@link #emoji} instance as {@link String}
     */
    public String getEmoji() {
        return emoji;
    }

    /**
     * Method to get {@link #value} instance <br>
     * No-any params required
     *
     * @return {@link #value} instance as int
     */
    public int getValue() {
        return value;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Dice}
     */
    public static Dice getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Dice(jItem);
    }

}
