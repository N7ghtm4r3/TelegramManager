package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup.getInstance;

@Structure
public abstract class InlineQueryResult<T extends InputMessageContentType> extends TelegramType {

    public enum InlineQueryResultType {

        article,

        photo,

        gif,

        mpeg4_gif,

        video,

        audio,

        voice,

        document,

        location,

        venue,

        contact,

        game,

        sticker

    }

    protected final InlineQueryResultType type;

    protected final String id;

    protected final T inputMessageContent;

    protected final InlineKeyboardMarkup replyMarkup;

    public InlineQueryResult(InlineQueryResultType type, String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup) {
        super(null);
        this.type = type;
        this.id = id;
        this.inputMessageContent = inputMessageContent;
        this.replyMarkup = replyMarkup;
    }

    public InlineQueryResult(JSONObject jInlineQueryResult) {
        super(jInlineQueryResult);
        type = InlineQueryResultType.valueOf(hTelegram.getString("type"));
        id = hTelegram.getString("id");
        inputMessageContent = InputMessageContent.getInputMessageContent(hTelegram.getJSONObject("input_message_content"));
        replyMarkup = getInstance(hTelegram.getJSONObject("reply_markup"));
    }

    public InlineQueryResultType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public T getInputMessageContent() {
        return inputMessageContent;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

}
