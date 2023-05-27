package com.tecknobit.telegrammanager.botapi.records.basetypes.bot;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code BotCommand} class is useful to format a {@code Telegram}'s bot command
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#botcommand">
 * BotCommand</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class BotCommand extends TelegramType {

    /**
     * {@code command} text of the command; 1-32 characters. Can contain only lowercase English letters,
     * digits and underscores
     */
    private final String command;

    /**
     * Constructor to init a {@link BotCommand} object
     *
     * @param command: text of the command; 1-32 characters. Can contain only lowercase English letters, digits and underscores
     */
    public BotCommand(String command) {
        super(null);
        this.command = command;
    }

    /**
     * Constructor to init a {@link BotCommand} object
     *
     * @param jBotCommand: bot command details as {@link JSONObject}
     */
    public BotCommand(JSONObject jBotCommand) {
        super(jBotCommand);
        command = hTelegram.getString("command");
    }

    /**
     * Method to get {@link #command} instance <br>
     * No-any params required
     *
     * @return {@link #command} instance as {@link String}
     */
    public String getCommand() {
        return command;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link BotCommand}
     */
    public static BotCommand getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new BotCommand(jItem);
    }

}
