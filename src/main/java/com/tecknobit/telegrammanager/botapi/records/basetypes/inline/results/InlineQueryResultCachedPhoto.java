package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.photo;

public class InlineQueryResultCachedPhoto<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    private final String photoFileId;

    public InlineQueryResultCachedPhoto(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                        String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                        String photoFileId) {
        super(photo, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.photoFileId = photoFileId;
    }

    public InlineQueryResultCachedPhoto(JSONObject jInlineQueryResultCachedPhoto) {
        super(jInlineQueryResultCachedPhoto);
        photoFileId = hTelegram.getString("photo_file_id");
    }

    public String getPhotoFileId() {
        return photoFileId;
    }

    public static <T extends InputMessageContentType> InlineQueryResultCachedPhoto<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedPhoto<>(jItem);
    }

}
