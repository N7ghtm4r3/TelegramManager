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
import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.InlineQueryResultGif.ThumbnailMimeType.IMAGE_JPEG;

/**
 * The {@code InlineQueryResultGif} class is useful to format a {@code Telegram}'s inline query result gif
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultgif">
 *             InlineQueryResultGif</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultmpeg4gif">
 *             InlineQueryResultMpeg4Gif</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultGif<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code ThumbnailMimeType} list of available thumbnail mime types
     */
    public enum ThumbnailMimeType {

        /**
         * {@code IMAGE_JPEG} thumbnail mime type
         */
        IMAGE_JPEG("image/jpeg"),

        /**
         * {@code IMAGE_GIF} thumbnail mime type
         */
        IMAGE_GIF("image/gif"),

        /**
         * {@code VIDEO_MP4} thumbnail mime type
         */
        VIDEO_MP4("video/mp4");

        /**
         * {@code type} value
         */
        private final String type;

        /**
         * Constructor to init a {@link ThumbnailMimeType} object
         *
         * @param type: {@code type}
         */
        ThumbnailMimeType(String type) {
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
     * {@code url} a valid URL for the file
     */
    private final String url;

    /**
     * {@code width} of the GIF
     */
    private final double width;

    /**
     * {@code height} of the GIF
     */
    private final double height;

    /**
     * {@code duration} of the GIF in seconds
     */
    private final int duration;

    /**
     * {@code thumbnailUrl} URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
     */
    private final String thumbnailUrl;

    /**
     * {@code thumbnailMimeType} MIME type of the thumbnail
     */
    private final ThumbnailMimeType thumbnailMimeType;

    /**
     * Constructor to init a {@link InlineQueryResultGif} object
     *
     * @param type:                type of the result
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param url:                 a valid URL for the file
     * @param width:               width of the GIF
     * @param height:              height of the GIF
     * @param duration:            duration of the GIF in seconds
     * @param thumbnailUrl:        URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
     * @param thumbnailMimeType:   MIME type of the thumbnail
     */
    public InlineQueryResultGif(InlineQueryResultType type, String id, T inputMessageContent,
                                InlineKeyboardMarkup replyMarkup, String title, String caption,
                                ArrayList<MessageEntity> captionEntities, String parseMode, String url, double width,
                                double height, int duration, String thumbnailUrl, ThumbnailMimeType thumbnailMimeType) {
        super(type, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.url = url;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailMimeType = thumbnailMimeType;
    }

    /**
     * Constructor to init a {@link InlineQueryResultGif} object
     *
     * @param jInlineQueryResultGif: inline query result gif details as {@link JSONObject}
     */
    public InlineQueryResultGif(JSONObject jInlineQueryResultGif) {
        super(jInlineQueryResultGif);
        url = hTelegram.getString("gif_url", hTelegram.getString("mpeg4_url"));
        width = hTelegram.getDouble("gif_width", hTelegram.getDouble("mpeg4_width", 0));
        height = hTelegram.getDouble("gif_height", hTelegram.getDouble("mpeg4_height", 0));
        duration = hTelegram.getInt("gif_duration", hTelegram.getInt("mpeg4_duration", 0));
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        thumbnailMimeType = ThumbnailMimeType.valueOf(hTelegram.getString("thumbnail_mime_type", IMAGE_JPEG.getType()));
    }

    /**
     * Method to get {@link #url} instance <br>
     * No-any params required
     *
     * @return {@link #url} instance as {@link String}
     */
    public String getUrl() {
        return url;
    }

    /**
     * Method to get {@link #width} instance <br>
     * No-any params required
     *
     * @return {@link #width} instance as double
     */
    public double getWidth() {
        return width;
    }

    /**
     * Method to get {@link #width} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #width} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getWidth(int decimals) {
        return roundValue(width, decimals);
    }

    /**
     * Method to get {@link #height} instance <br>
     * No-any params required
     *
     * @return {@link #height} instance as double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Method to get {@link #height} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #height} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getHeight(int decimals) {
        return roundValue(height, decimals);
    }

    /**
     * Method to get {@link #duration} instance <br>
     * No-any params required
     *
     * @return {@link #duration} instance as int
     */
    public int getDuration() {
        return duration;
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
     * Method to get {@link #thumbnailMimeType} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailMimeType} instance as {@link ThumbnailMimeType}
     */
    public ThumbnailMimeType getThumbnailMimeType() {
        return thumbnailMimeType;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultGif<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultGif<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultGif<>(jItem);
    }

}
