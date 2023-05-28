package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.game;

public class InlineQueryResultGame extends InlineQueryResult<InputMessageContentType> {

    private final String gameShortName;

    public InlineQueryResultGame(String id, InlineKeyboardMarkup replyMarkup, String gameShortName) {
        super(game, id, null, replyMarkup);
        this.gameShortName = gameShortName;
    }

    public InlineQueryResultGame(JSONObject jInlineQueryResultGame) {
        super(jInlineQueryResultGame);
        gameShortName = hTelegram.getString("game_short_name");
    }

    public String getGameShortName() {
        return gameShortName;
    }

    public static InlineQueryResultGame getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultGame(jItem);
    }

}
