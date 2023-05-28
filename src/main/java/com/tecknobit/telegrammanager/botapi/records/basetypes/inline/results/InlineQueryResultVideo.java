package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.video;

public class InlineQueryResultVideo<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    public enum VideoMimeType {

        TEXT_HTML("text/html"),

        VIDEO_MP4("video/mp4");

        private final String type;

        VideoMimeType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }

    private final String videoUrl;

    private final VideoMimeType mimeType;

    private final String thumbnailUrl;

    private final double videoWidth;

    private final double videoHeight;

    private final int videoDuration;

    public InlineQueryResultVideo(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                  String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                  String videoUrl, VideoMimeType mimeType, String thumbnailUrl, double videoWidth,
                                  double videoHeight, int videoDuration) {
        super(video, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.videoUrl = videoUrl;
        this.mimeType = mimeType;
        this.thumbnailUrl = thumbnailUrl;
        this.videoWidth = videoWidth;
        this.videoHeight = videoHeight;
        this.videoDuration = videoDuration;
    }

    public InlineQueryResultVideo(JSONObject jInlineQueryResultVideo) {
        super(jInlineQueryResultVideo);
        videoUrl = hTelegram.getString("video_url");
        mimeType = VideoMimeType.valueOf(hTelegram.getString("mime_type"));
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        videoWidth = hTelegram.getDouble("video_width", 0);
        videoHeight = hTelegram.getDouble("video_height", 0);
        videoDuration = hTelegram.getInt("video_duration", 0);
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public VideoMimeType getMimeType() {
        return mimeType;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public double getVideoWidth() {
        return videoWidth;
    }

    public double getVideoHeight() {
        return videoHeight;
    }

    public int getVideoDuration() {
        return videoDuration;
    }

    public static <T extends InputMessageContentType> InlineQueryResultVideo<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultVideo<>(jItem);
    }

}
