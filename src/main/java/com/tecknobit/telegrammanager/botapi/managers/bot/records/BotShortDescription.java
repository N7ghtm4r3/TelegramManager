package com.tecknobit.telegrammanager.botapi.managers.bot.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code BotShortDescription} class is useful to format a {@code Telegram}'s bot short description
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#botshortdescription">
 * BotShortDescription</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class BotShortDescription extends TelegramType {

    /**
     * {@code shortDescription} the bot's short description
     */
    private final String shortDescription;

    /**
     * Constructor to init a {@link BotShortDescription} object
     *
     * @param shortDescription: the bot's short description
     */
    public BotShortDescription(String shortDescription) {
        super(null);
        this.shortDescription = shortDescription;
    }

    /**
     * Constructor to init a {@link BotShortDescription} object
     *
     * @param jBotShortDescription: bot short description details as {@link JSONObject}
     */
    public BotShortDescription(JSONObject jBotShortDescription) {
        super(jBotShortDescription);
        shortDescription = hTelegram.getString("short_description");
    }

    /**
     * Method to get {@link #shortDescription} instance <br>
     * No-any params required
     *
     * @return {@link #shortDescription} instance as {@link String}
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotShortDescription}
     */
    public static BotShortDescription getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotShortDescription(jItem);
    }

}
