package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ReplyKeyboardMarkup} class is useful to format a {@code Telegram}'s reply keyboard markup
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">
 * ReplyKeyboardMarkup</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see KeyboardManager
 */
public class ReplyKeyboardMarkup extends TelegramType implements KeyboardManager<KeyboardButton> {

    /**
     * {@code keyboard} array of button rows, each represented by an Array of {@link KeyboardButton} objects
     */
    private final ArrayList<ArrayList<KeyboardButton>> keyboard;

    /**
     * {@code isPersistent} requests clients to always show the keyboard when the regular keyboard is hidden.
     * Defaults to false, in which case the custom keyboard can be hidden and opened with a keyboard icon
     */
    private boolean isPersistent;

    /**
     * {@code resizeKeyboard} requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard
     * smaller if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of
     * the same height as the app's standard keyboard
     */
    private boolean resizeKeyboard;

    /**
     * {@code oneTimeKeyboard} requests clients to hide the keyboard as soon as it's been used. The keyboard will still
     * be available, but clients will automatically display the usual letter-keyboard in the chat - the user can press a
     * special button in the input field to see the custom keyboard again. Defaults to false
     */
    private boolean oneTimeKeyboard;

    /**
     * {@code inputFieldPlaceholder} the placeholder to be shown in the input field when the keyboard is active; 1-64
     * characters
     */
    private String inputFieldPlaceholder;

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
    private boolean selective;

    /**
     * Constructor to init a {@link ReplyKeyboardMarkup} object <br>
     * No-any params required
     *
     * @apiNote this constructor is useful to instantiate a new input object to pass as request parameter, you can choose
     * the single parameter to set for the input object invoking the specific setter method
     */
    public ReplyKeyboardMarkup() {
        this(new ArrayList<>());
    }

    /**
     * Constructor to init a {@link ReplyKeyboardMarkup} object
     *
     * @param keyboard: array of button rows, each represented by an Array of {@link KeyboardButton} objects
     * @apiNote this constructor is useful to instantiate a new input object to pass as request parameter, you can choose
     * the single parameter to set for the input object invoking the specific setter method
     */
    public ReplyKeyboardMarkup(ArrayList<ArrayList<KeyboardButton>> keyboard) {
        super(null);
        this.keyboard = keyboard;
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
     * Method to add a row of {@link KeyboardButton} to the current keyboard
     *
     * @param rowItems : row of {@link KeyboardButton} to add
     */
    @Override
    public void addKeyboardRow(KeyboardButton... rowItems) {
        keyboard.add(new ArrayList<>(List.of(rowItems)));
    }

    /**
     * Method to remove a row of {@link KeyboardButton} from the current keyboard
     *
     * @param rowToRemove : row of {@link KeyboardButton} to remove
     */
    @Override
    public void removeKeyboardRow(List<KeyboardButton> rowToRemove) {
        keyboard.remove(new ArrayList<>(rowToRemove));
    }

    /**
     * Method to remove a row of {@link KeyboardButton} from the current keyboard
     *
     * @param indexRowToRemove : index of the row of {@link KeyboardButton} to remove
     */
    @Override
    public void removeKeyboardRow(int indexRowToRemove) {
        keyboard.remove(indexRowToRemove);
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
     * Method to set {@link #} instance
     *
     * @param persistent: requests clients to always show the keyboard when the regular keyboard is hidden.
     *                    Defaults to false, in which case the custom keyboard can be hidden and opened with a keyboard
     *                    icon
     */
    public void setPersistent(boolean persistent) {
        isPersistent = persistent;
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
     * Method to set {@link #resizeKeyboard} instance
     *
     * @param resizeKeyboard: requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard
     *                        smaller if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of
     *                        the same height as the app's standard keyboard
     */
    public void setResizeKeyboard(boolean resizeKeyboard) {
        this.resizeKeyboard = resizeKeyboard;
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
     * Method to set {@link #oneTimeKeyboard} instance
     *
     * @param oneTimeKeyboard: requests clients to hide the keyboard as soon as it's been used. The keyboard will still be
     *                         available, but clients will automatically display the usual letter-keyboard in the chat -
     *                         the user can press a special button in the input field to see the custom keyboard again
     */
    public void setOneTimeKeyboard(boolean oneTimeKeyboard) {
        this.oneTimeKeyboard = oneTimeKeyboard;
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
     * Method to set {@link #inputFieldPlaceholder} instance
     *
     * @param inputFieldPlaceholder: the placeholder to be shown in the input field when the keyboard is active; 1-64 characters
     */
    public void setInputFieldPlaceholder(String inputFieldPlaceholder) {
        this.inputFieldPlaceholder = inputFieldPlaceholder;
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
     * Method to set {@link #selective} instance
     *
     * @param selective: use this parameter if you want to show the keyboard to specific users only, targets:
     *                   <ul>
     *                       <li>
     *                            users that are @mentioned in the text of the Message object
     *                       </li>
     *                       <li>
     *                            if the bot's message is a reply (has reply_to_message_id), sender of the original message
     *                       </li>
     *                   </ul>
     */
    public void setSelective(boolean selective) {
        this.selective = selective;
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
