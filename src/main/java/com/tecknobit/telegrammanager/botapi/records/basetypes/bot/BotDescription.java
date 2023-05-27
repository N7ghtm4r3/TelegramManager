package com.tecknobit.telegrammanager.botapi.records.basetypes.bot;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code BotDescription} class is useful to format a {@code Telegram}'s bot description
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#botdescription">
 * BotDescription</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class BotDescription extends TelegramType {

    /**
     * Constructor to init a {@link BotDescription} object <br>
     * No-any params required
     */
    public BotDescription() {
        super(null);
    }

    /**
     * Constructor to init a {@link BotDescription} object
     *
     * @param jBotDescription: bot description details as {@link JSONObject}
     */
    public BotDescription(JSONObject jBotDescription) {
        super(jBotDescription);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotDescription}
     */
    public static BotDescription getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotDescription(jItem);
    }

}
