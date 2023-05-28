package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

public class InlineQueryResultCachedGif<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    private final String fileId;

    public InlineQueryResultCachedGif(InlineQueryResultType type, String id, T inputMessageContent,
                                      InlineKeyboardMarkup replyMarkup, String title, String caption,
                                      ArrayList<MessageEntity> captionEntities, String parseMode, String fileId) {
        super(type, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.fileId = fileId;
    }

    public InlineQueryResultCachedGif(JSONObject jInlineQueryResultCachedGif) {
        super(jInlineQueryResultCachedGif);
        fileId = hTelegram.getString("gif_file_id", hTelegram.getString("mpeg4_file_id"));
    }

    public String getPhotoFileId() {
        return fileId;
    }

    public static <T extends InputMessageContentType> InlineQueryResultCachedGif<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedGif<>(jItem);
    }

}
