package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.InlineQueryResultDocument;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

@Structure
public abstract class InlineQueryResultThumbnailed<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    protected final String thumbnailUrl;

    protected final double thumbnailWidth;

    protected final double thumbnailHeight;

    public InlineQueryResultThumbnailed(InlineQueryResultType type, String id, T inputMessageContent,
                                        InlineKeyboardMarkup replyMarkup, String title, String caption,
                                        ArrayList<MessageEntity> captionEntities, String parseMode, String documentUrl,
                                        InlineQueryResultDocument.DocumentMimeType mimeType, String thumbnailUrl,
                                        double thumbnailWidth, double thumbnailHeight) {
        super(type, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public InlineQueryResultThumbnailed(JSONObject jInlineQueryResultThumbnailed) {
        super(jInlineQueryResultThumbnailed);
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        thumbnailWidth = hTelegram.getDouble("thumbnail_width", 0);
        thumbnailHeight = hTelegram.getDouble("thumbnail_height", 0);
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public double getThumbnailWidth() {
        return thumbnailWidth;
    }

    public double getThumbnailHeight() {
        return thumbnailHeight;
    }

}
