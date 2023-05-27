package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code ReplyKeyboardMarkup} class is useful to format a {@code Telegram}'s reply keyboard markup
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">
 * ReplyKeyboardMarkup</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ReplyKeyboardMarkup extends TelegramType {

    /**
     * {@code keyboard} array of button rows, each represented by an Array of {@link KeyboardButton} objects
     */
    private final ArrayList<ArrayList<KeyboardButton>> keyboard;

    /**
     * {@code isPersistent} requests clients to always show the keyboard when the regular keyboard is hidden.
     * Defaults to false, in which case the custom keyboard can be hidden and opened with a keyboard icon
     */
    private final boolean isPersistent;

    /**
     * {@code resizeKeyboard} requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard
     * smaller if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of
     * the same height as the app's standard keyboard
     */
    private final boolean resizeKeyboard;

    /**
     * {@code oneTimeKeyboard} requests clients to hide the keyboard as soon as it's been used. The keyboard will still
     * be available, but clients will automatically display the usual letter-keyboard in the chat - the user can press a
     * special button in the input field to see the custom keyboard again. Defaults to false
     */
    private final boolean oneTimeKeyboard;

    /**
     * {@code inputFieldPlaceholder} the placeholder to be shown in the input field when the keyboard is active; 1-64
     * characters
     */
    private final String inputFieldPlaceholder;

    /**
     * {@code selective} use this parameter if you want to show the keyboard to specific users only, targets:
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
     * Constructor to init a {@link ReplyKeyboardMarkup} object
     *
     * @param keyboard:              array of button rows, each represented by an Array of {@link KeyboardButton} objects
     * @param isPersistent:          requests clients to always show the keyboard when the regular keyboard is hidden. Defaults to
     *                               false, in which case the custom keyboard can be hidden and opened with a keyboard icon
     * @param resizeKeyboard:        requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard
     *                               smaller if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of
     *                               the same height as the app's standard keyboard
     * @param oneTimeKeyboard:       requests clients to hide the keyboard as soon as it's been used. The keyboard will still be
     *                               available, but clients will automatically display the usual letter-keyboard in the chat - the user can press a
     *                               special button in the input field to see the custom keyboard again. Defaults to false
     * @param inputFieldPlaceholder: the placeholder to be shown in the input field when the keyboard is active; 1-64 characters
     * @param selective:             use this parameter if you want to show the keyboard to specific users only
     */
    public ReplyKeyboardMarkup(ArrayList<ArrayList<KeyboardButton>> keyboard, boolean isPersistent, boolean resizeKeyboard,
                               boolean oneTimeKeyboard, String inputFieldPlaceholder, boolean selective) {
        super(null);
        this.keyboard = keyboard;
        this.isPersistent = isPersistent;
        this.resizeKeyboard = resizeKeyboard;
        this.oneTimeKeyboard = oneTimeKeyboard;
        this.inputFieldPlaceholder = inputFieldPlaceholder;
        this.selective = selective;
    }

    /**
     * Constructor to init a {@link ReplyKeyboardMarkup} object
     *
     * @param jReplyKeyboardMarkup: reply keyboard markup details as {@link JSONObject}
     */
    public ReplyKeyboardMarkup(JSONObject jReplyKeyboardMarkup) {
        super(jReplyKeyboardMarkup);
        keyboard = new ArrayList<>();
        keyboard.add(KeyboardButton.returnKeyboardButtons(hTelegram.getJSONArray("keyboard")));
        isPersistent = hTelegram.getBoolean("is_persistent");
        resizeKeyboard = hTelegram.getBoolean("resize_keyboard");
        oneTimeKeyboard = hTelegram.getBoolean("one_time_keyboard");
        inputFieldPlaceholder = hTelegram.getString("input_field_placeholder");
        selective = hTelegram.getBoolean("selective");
    }

    /**
     * Method to get {@link #keyboard} instance <br>
     * No-any params required
     *
     * @return {@link #keyboard} instance as {@link ArrayList} of {@link ArrayList} of {@link KeyboardButton}
     */
    public ArrayList<ArrayList<KeyboardButton>> getKeyboard() {
        return keyboard;
    }

    /**
     * Method to get {@link #isPersistent} instance <br>
     * No-any params required
     *
     * @return {@link #isPersistent} instance as boolean
     */
    public boolean isPersistent() {
        return isPersistent;
    }

    /**
     * Method to get {@link #resizeKeyboard} instance <br>
     * No-any params required
     *
     * @return {@link #resizeKeyboard} instance as boolean
     */
    public boolean resizeKeyboard() {
        return resizeKeyboard;
    }

    /**
     * Method to get {@link #oneTimeKeyboard} instance <br>
     * No-any params required
     *
     * @return {@link #oneTimeKeyboard} instance as boolean
     */
    public boolean isOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    /**
     * Method to get {@link #inputFieldPlaceholder} instance <br>
     * No-any params required
     *
     * @return {@link #inputFieldPlaceholder} instance as {@link String}
     */
    public String getInputFieldPlaceholder() {
        return inputFieldPlaceholder;
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
     * @return instance as {@link ReplyKeyboardMarkup}
     */
    public static ReplyKeyboardMarkup getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ReplyKeyboardMarkup(jItem);
    }

}
