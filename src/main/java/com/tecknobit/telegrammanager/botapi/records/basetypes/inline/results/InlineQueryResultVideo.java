package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultTitled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.video;

/**
 * The {@code InlineQueryResultVideo} class is useful to format a {@code Telegram}'s inline query result video
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultvideo">
 * InlineQueryResultVideo</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultVideo<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code VideoMimeType} list of the available video mime types
     */
    public enum VideoMimeType {

        /**
         * {@code TEXT_HTML} video mime type
         */
        TEXT_HTML("text/html"),

        /**
         * {@code VIDEO_MP4} video mime type
         */
        VIDEO_MP4("video/mp4");

        /**
         * {@code type} value
         */
        private final String type;

        /**
         * Constructor to init a {@link VideoMimeType} object
         *
         * @param type: type value
         */
        VideoMimeType(String type) {
            this.type = type;
        }

        /**
         * Method to get {@link #type} instance <br>
         * No-any params required
         *
         * @return {@link #type} instance as {@link String}
         */
        public String getType() {
            return type;
        }

    }

    /**
     * {@code videoUrl} a valid URL for the embedded video player or video file
     */
    private final String videoUrl;

    /**
     * {@code mimeType} MIME type of the content of the video URL
     */
    private final VideoMimeType mimeType;

    /**
     * {@code thumbnailUrl} URL of the thumbnail (JPEG only) for the video
     */
    private final String thumbnailUrl;

    /**
     * {@code videoWidth} width
     */
    private final double videoWidth;

    /**
     * {@code videoHeight} height
     */
    private final double videoHeight;

    /**
     * {@code videoDuration} video duration in seconds
     */
    private final int videoDuration;

    /**
     * Constructor to init a {@link InlineQueryResultVideo} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param videoUrl:            a valid URL for the embedded video player or video file
     * @param mimeType:            MIME type of the content of the video URL
     * @param thumbnailUrl:URL     of the thumbnail (JPEG only) for the video
     * @param videoWidth:          video width
     * @param videoHeight:         video height
     * @param videoDuration:       video duration in seconds
     */
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

    /**
     * Constructor to init a {@link InlineQueryResultVideo} object
     *
     * @param jInlineQueryResultVideo: inline query result video details as {@link JSONObject}
     */
    public InlineQueryResultVideo(JSONObject jInlineQueryResultVideo) {
        super(jInlineQueryResultVideo);
        videoUrl = hTelegram.getString("video_url");
        mimeType = VideoMimeType.valueOf(hTelegram.getString("mime_type"));
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        videoWidth = hTelegram.getDouble("video_width", 0);
        videoHeight = hTelegram.getDouble("video_height", 0);
        videoDuration = hTelegram.getInt("video_duration", 0);
    }

    /**
     * Method to get {@link #videoUrl} instance <br>
     * No-any params required
     *
     * @return {@link #videoUrl} instance as {@link String}
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * Method to get {@link #mimeType} instance <br>
     * No-any params required
     *
     * @return {@link #mimeType} instance as {@link VideoMimeType}
     */
    public VideoMimeType getMimeType() {
        return mimeType;
    }

    /**
     * Method to get {@link #thumbnailUrl} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailUrl} instance as {@link String}
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Method to get {@link #videoWidth} instance <br>
     * No-any params required
     *
     * @return {@link #videoWidth} instance as double
     */
    public double getVideoWidth() {
        return videoWidth;
    }

    /**
     * Method to get {@link #videoWidth} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #videoWidth} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getVideoWidth(int decimals) {
        return roundValue(videoWidth, decimals);
    }

    /**
     * Method to get {@link #videoHeight} instance <br>
     * No-any params required
     *
     * @return {@link #videoHeight} instance as double
     */
    public double getVideoHeight() {
        return videoHeight;
    }

    /**
     * Method to get {@link #videoHeight} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #videoHeight} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getVideoHeight(int decimals) {
        return roundValue(videoHeight, decimals);
    }

    /**
     * Method to get {@link #videoDuration} instance <br>
     * No-any params required
     *
     * @return {@link #videoDuration} instance as int
     */
    public int getVideoDuration() {
        return videoDuration;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultVideo<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultVideo<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultVideo<>(jItem);
    }

}
