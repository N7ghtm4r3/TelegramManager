package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.game;


/**
 * The {@code InlineQueryResultGame} class is useful to format a {@code Telegram}'s inline query result game
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultgame">
 * InlineQueryResultGame</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 */
public class InlineQueryResultGame extends InlineQueryResult<InputMessageContentType> {

    /**
     * {@code gameShortName} short name of the game
     */
    private final String gameShortName;

    /**
     * Constructor to init a {@link InlineQueryResultGame} object
     *
     * @param id:            unique identifier for this result, 1-64 Bytes
     * @param replyMarkup:   inline keyboard attached to the message
     * @param gameShortName: short name of the game
     */
    public InlineQueryResultGame(String id, InlineKeyboardMarkup replyMarkup, String gameShortName) {
        super(game, id, null, replyMarkup);
        this.gameShortName = gameShortName;
    }

    /**
     * Constructor to init a {@link InlineQueryResultGame} object
     *
     * @param jInlineQueryResultGame: inline query result game details as {@link JSONObject}
     */
    public InlineQueryResultGame(JSONObject jInlineQueryResultGame) {
        super(jInlineQueryResultGame);
        gameShortName = hTelegram.getString("game_short_name");
    }

    /**
     * Method to get {@link #gameShortName} instance <br>
     * No-any params required
     *
     * @return {@link #gameShortName} instance as {@link String}
     */
    public String getGameShortName() {
        return gameShortName;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultGame}
     */
    public static InlineQueryResultGame getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultGame(jItem);
    }

}
