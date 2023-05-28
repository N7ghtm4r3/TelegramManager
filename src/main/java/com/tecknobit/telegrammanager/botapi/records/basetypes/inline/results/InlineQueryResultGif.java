package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.InlineQueryResultGif.ThumbnailMimeType.IMAGE_JPEG;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.gif;

public class InlineQueryResultGif<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    public enum ThumbnailMimeType {

        IMAGE_JPEG("image/jpeg"),

        IMAGE_GIF("image/gif"),

        VIDEO_MP4("video/mp4");

        private final String type;

        ThumbnailMimeType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }

    private final String url;

    private final double width;

    private final double height;

    private final int duration;

    private final String thumbnailUrl;

    private final ThumbnailMimeType thumbnailMimeType;

    public InlineQueryResultGif(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                String caption, ArrayList<MessageEntity> captionEntities, String parseMode, String url,
                                double width, double height, int duration, String thumbnailUrl,
                                ThumbnailMimeType thumbnailMimeType) {
        super(gif, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.url = url;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailMimeType = thumbnailMimeType;
    }

    public InlineQueryResultGif(JSONObject jInlineQueryResultGif) {
        super(jInlineQueryResultGif);
        url = hTelegram.getString("gif_url", hTelegram.getString("mpeg4_url"));
        width = hTelegram.getDouble("gif_width", hTelegram.getDouble("mpeg4_width", 0));
        height = hTelegram.getDouble("gif_height", hTelegram.getDouble("mpeg4_height", 0));
        duration = hTelegram.getInt("gif_duration", hTelegram.getInt("mpeg4_duration", 0));
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        thumbnailMimeType = ThumbnailMimeType.valueOf(hTelegram.getString("thumbnail_mime_type", IMAGE_JPEG.getType()));
    }

    public String getUrl() {
        return url;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getDuration() {
        return duration;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public ThumbnailMimeType getThumbnailMimeType() {
        return thumbnailMimeType;
    }

    public static <T extends InputMessageContentType> InlineQueryResultGif<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultGif<>(jItem);
    }

}
