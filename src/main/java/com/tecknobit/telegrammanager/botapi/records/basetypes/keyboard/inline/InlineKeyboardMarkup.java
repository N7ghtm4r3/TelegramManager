package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline;

import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.KeyboardManager;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardButton.returnInlineKeyboardButtons;

/**
 * The {@code InlineKeyboardMarkup} class is useful to format a {@code Telegram}'s inline keyboard markup
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinekeyboardmarkup">
 * InlineKeyboardMarkup</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see KeyboardManager
 */
public class InlineKeyboardMarkup extends TelegramType implements KeyboardManager<InlineKeyboardButton> {

    /**
     * {@code inlineKeyboard} array of button rows, each represented by an array of {@link InlineKeyboardButton} objects
     */
    private final ArrayList<ArrayList<InlineKeyboardButton>> inlineKeyboard;

    /**
     * Constructor to init a {@link InlineKeyboardMarkup} object <br>
     * No-any params required
     */
    public InlineKeyboardMarkup() {
        this(new ArrayList<>());
    }

    /**
     * Constructor to init a {@link InlineKeyboardMarkup} object
     *
     * @param inlineKeyboard: array of button rows, each represented by an array of {@link InlineKeyboardButton} objects
     * @apiNote this constructor is useful to instantiate a new input object to pass as request parameter, you can set
     * the parameter for the input object invoking the specific methods
     */
    public InlineKeyboardMarkup(ArrayList<ArrayList<InlineKeyboardButton>> inlineKeyboard) {
        super(null);
        this.inlineKeyboard = inlineKeyboard;
    }

    /**
     * Constructor to init a {@link InlineKeyboardMarkup} object
     *
     * @param jInlineKeyboardMarkup: inline keyboard markup details as {@link JSONObject}
     */
    public InlineKeyboardMarkup(JSONObject jInlineKeyboardMarkup) {
        super(jInlineKeyboardMarkup);
        inlineKeyboard = new ArrayList<>();
        inlineKeyboard.add(returnInlineKeyboardButtons(hTelegram.getJSONArray("inline_keyboard")));
    }

    /**
     * Method to get {@link #inlineKeyboard} instance <br>
     * No-any params required
     *
     * @return {@link #inlineKeyboard} instance as {@link ArrayList} of {@link ArrayList} of {@link InlineKeyboardButton}
     */
    public ArrayList<ArrayList<InlineKeyboardButton>> getInlineKeyboard() {
        return inlineKeyboard;
    }

    /**
     * Method to add a row of {@link InlineKeyboardButton} to the current keyboard
     *
     * @param rowItems : row items to add
     */
    @Override
    public void addKeyboardRow(InlineKeyboardButton... rowItems) {
        inlineKeyboard.add(new ArrayList<>(List.of(rowItems)));
    }

    /**
     * Method to remove a row of {@link InlineKeyboardButton} from the current keyboard
     *
     * @param rowToRemove : row of {@link InlineKeyboardButton} to remove
     */
    @Override
    public void removeKeyboardRow(List<InlineKeyboardButton> rowToRemove) {
        inlineKeyboard.remove(new ArrayList<>(rowToRemove));
    }

    /**
     * Method to remove a row of {@link InlineKeyboardButton} from the current keyboard
     *
     * @param indexRowToRemove : index of the row of {@link InlineKeyboardButton} to remove
     */
    @Override
    public void removeKeyboardRow(int indexRowToRemove) {
        inlineKeyboard.remove(indexRowToRemove);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineKeyboardMarkup}
     */
    public static InlineKeyboardMarkup getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineKeyboardMarkup(jItem);
    }

}
