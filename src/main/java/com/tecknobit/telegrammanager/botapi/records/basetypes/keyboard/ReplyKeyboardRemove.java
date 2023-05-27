package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ReplyKeyboardRemove} class is useful to format a {@code Telegram}'s reply keyboard remove
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#replykeyboardremove">
 * ReplyKeyboardRemove</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ReplyKeyboardRemove extends TelegramType {

    /**
     * {@code removeKeyboard} requests clients to remove the custom keyboard (user will not be able to summon this keyboard;
     * if you want to hide the keyboard from sight but keep it accessible, use one_time_keyboard in ReplyKeyboardMarkup)
     */
    private final boolean removeKeyboard;

    /**
     * {@code selective} use this parameter if you want to force reply from specific users only, targets:
     * <ul>
     *     <li>
     *          users that are @mentioned in the text of the Message object
     *     </li>
     *     <li>
     *          if the bot's message is a reply (has reply_to_message_id), sender of the original message
     *     </li>
     * </ul>
     */
    private final boolean selective;

    /**
     * Constructor to init a {@link ReplyKeyboardRemove} object
     *
     * @param removeKeyboard: requests clients to remove the custom keyboard (user will not be able to summon this keyboard;
     *                        if you want to hide the keyboard from sight but keep it accessible, use one_time_keyboard in ReplyKeyboardMarkup)
     * @param selective:      use this parameter if you want to force reply from specific users only
     */
    public ReplyKeyboardRemove(boolean removeKeyboard, boolean selective) {
        super(null);
        this.removeKeyboard = removeKeyboard;
        this.selective = selective;
    }

    /**
     * Constructor to init a {@link ReplyKeyboardRemove} object
     *
     * @param jReplyKeyboardRemove: reply keyboard remove details as {@link JSONObject}
     */
    public ReplyKeyboardRemove(JSONObject jReplyKeyboardRemove) {
        super(jReplyKeyboardRemove);
        removeKeyboard = hTelegram.getBoolean("remove_keyboard");
        selective = hTelegram.getBoolean("selective");
    }

    /**
     * Method to get {@link #removeKeyboard} instance <br>
     * No-any params required
     *
     * @return {@link #removeKeyboard} instance as boolean
     */
    public boolean removeKeyboard() {
        return removeKeyboard;
    }

    /**
     * Method to get {@link #selective} instance <br>
     * No-any params required
     *
     * @return {@link #selective} instance as boolean
     */
    public boolean isSelective() {
        return selective;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ReplyKeyboardRemove}
     */
    public static ReplyKeyboardRemove getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ReplyKeyboardRemove(jItem);
    }

}
