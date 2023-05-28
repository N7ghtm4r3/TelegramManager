package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

@Structure
public abstract class InlineQueryResultCaptioned<T extends InputMessageContentType> extends InlineQueryResultTitled<T> {

    protected final String caption;

    protected final ArrayList<MessageEntity> captionEntities;

    protected final String parseMode;

    public InlineQueryResultCaptioned(InlineQueryResultType type, String id, T inputMessageContent,
                                      InlineKeyboardMarkup replyMarkup, String title, String caption,
                                      ArrayList<MessageEntity> captionEntities, String parseMode) {
        super(type, id, inputMessageContent, replyMarkup, title);
        this.caption = caption;
        this.captionEntities = captionEntities;
        this.parseMode = parseMode;
    }

    public InlineQueryResultCaptioned(JSONObject jInlineQueryResultCaptioned) {
        super(jInlineQueryResultCaptioned);
        caption = hTelegram.getString("caption");
        captionEntities = MessageEntity.returnMessageEntities(hTelegram.getJSONArray("caption_entities"));
        parseMode = hTelegram.getString("parse_mode");
    }

    public String getCaption() {
        return caption;
    }

    public ArrayList<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    public String getParseMode() {
        return parseMode;
    }

}
