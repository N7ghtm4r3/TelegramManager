package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code InlineKeyboardMarkup} class is useful to format a {@code Telegram}'s inline keyboard markup
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinekeyboardmarkup">
 * InlineKeyboardMarkup</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class InlineKeyboardMarkup extends TelegramType {

    /**
     * {@code inlineKeyboard} array of button rows, each represented by an Array of InlineKeyboardButton objects
     */
    private final ArrayList<ArrayList<InlineKeyboardButton>> inlineKeyboard;

    /**
     * Constructor to init a {@link InlineKeyboardMarkup} object
     *
     * @param inlineKeyboard: array of button rows, each represented by an Array of InlineKeyboardButton objects
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
        inlineKeyboard.add(InlineKeyboardButton.returnInlineKeyboardButtons(hTelegram.getJSONArray("inline_keyboard")));
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
