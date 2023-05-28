package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.photo;

public class InlineQueryResultPhoto<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    private final String photoUrl;

    private final String thumbnailUrl;

    private final double photoWidth;

    private final double photoHeight;

    public InlineQueryResultPhoto(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                  String caption, ArrayList<MessageEntity> captionEntities, String photoUrl,
                                  String thumbnailUrl, double photoWidth, double photoHeight, String parseMode) {
        super(photo, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.photoUrl = photoUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.photoWidth = photoWidth;
        this.photoHeight = photoHeight;
    }

    public InlineQueryResultPhoto(JSONObject jInlineQueryResultPhoto) {
        super(jInlineQueryResultPhoto);
        photoUrl = hTelegram.getString("photo_url");
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        photoWidth = hTelegram.getDouble("photo_width", 0);
        photoHeight = hTelegram.getDouble("photo_height", 0);
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public double getPhotoWidth() {
        return photoWidth;
    }

    public double getPhotoHeight() {
        return photoHeight;
    }

    public static <T extends InputMessageContentType> InlineQueryResultPhoto<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultPhoto<>(jItem);
    }

}
