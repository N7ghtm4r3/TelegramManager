package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import org.json.JSONObject;

@Structure
public abstract class InlineQueryResultTitled<T extends InputMessageContentType> extends InlineQueryResult<T> {

    protected final String title;

    public InlineQueryResultTitled(InlineQueryResultType type, String id, T inputMessageContent,
                                   InlineKeyboardMarkup replyMarkup, String title) {
        super(type, id, inputMessageContent, replyMarkup);
        this.title = title;
    }

    public InlineQueryResultTitled(JSONObject jInlineQueryResultTitled) {
        super(jInlineQueryResultTitled);
        title = hTelegram.getString("title");
    }

    public String getTitle() {
        return title;
    }

}
