package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.InlineQueryResultDocument;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

@Structure
public abstract class InlineQueryResultCoordinated<T extends InputMessageContentType> extends InlineQueryResultThumbnailed<T> {

    protected final double latitude;

    protected final double longitude;

    public InlineQueryResultCoordinated(InlineQueryResultType type, String id, T inputMessageContent,
                                        InlineKeyboardMarkup replyMarkup, String title, String caption,
                                        ArrayList<MessageEntity> captionEntities, String parseMode, String documentUrl,
                                        InlineQueryResultDocument.DocumentMimeType mimeType, String thumbnailUrl,
                                        double thumbnailWidth, double thumbnailHeight, double latitude, double longitude) {
        super(type, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode, documentUrl,
                mimeType, thumbnailUrl, thumbnailWidth, thumbnailHeight);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public InlineQueryResultCoordinated(JSONObject jInlineQueryResultCoordinated) {
        super(jInlineQueryResultCoordinated);
        latitude = hTelegram.getDouble("latitude");
        longitude = hTelegram.getDouble("longitude");
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
