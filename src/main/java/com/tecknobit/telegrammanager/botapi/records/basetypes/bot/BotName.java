package com.tecknobit.telegrammanager.botapi.records.basetypes.bot;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code BotName} class is useful to format a {@code Telegram}'s bot name
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#botname">
 * BotName</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class BotName extends TelegramType {

    /**
     * {@code name} the bot's name
     */
    private final String name;

    /**
     * Constructor to init a {@link BotName} object
     *
     * @param name: the bot's name
     */
    public BotName(String name) {
        super(null);
        this.name = name;
    }

    /**
     * Constructor to init a {@link BotName} object
     *
     * @param jBotName: bot name details as {@link JSONObject}
     */
    public BotName(JSONObject jBotName) {
        super(jBotName);
        name = hTelegram.getString("name");
    }

    /**
     * Method to get {@link #name} instance <br>
     * No-any params required
     *
     * @return {@link #name} instance as {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotName}
     */
    public static BotName getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotName(jItem);
    }

}
