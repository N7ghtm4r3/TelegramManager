package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.games;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code CallbackGame} class is useful to format a {@code Telegram}'s callback game
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#callbackgame">
 * CallbackGame</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class CallbackGame extends TelegramType {

    /**
     * Constructor to init a {@link CallbackGame} object
     *
     * @param jCallbackGame: callback game details as {@link JSONObject}
     */
    public CallbackGame(JSONObject jCallbackGame) {
        super(jCallbackGame);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link CallbackGame}
     */
    public static CallbackGame getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new CallbackGame(jItem);
    }

}
