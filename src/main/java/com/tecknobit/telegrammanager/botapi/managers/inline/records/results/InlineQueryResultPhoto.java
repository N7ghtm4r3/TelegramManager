package com.tecknobit.telegrammanager.botapi.managers.inline.records.results;

import com.tecknobit.telegrammanager.botapi.managers.inline.records.inputmessage.InputMessageContent;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResultTitled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;
import static com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResult.InlineQueryResultType.photo;

/**
 * The {@code InlineQueryResultPhoto} class is useful to format a {@code Telegram}'s inline query result photo
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultphoto">
 * InlineQueryResultPhoto</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultPhoto<T extends InputMessageContent.InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code photoUrl} a valid URL of the photo. Photo must be in JPEG format. Photo size must not exceed 5MB
     */
    private final String photoUrl;

    /**
     * {@code thumbnailUrl} URL of the thumbnail for the photo
     */
    private final String thumbnailUrl;

    /**
     * {@code photoWidth} of the photo
     */
    private final double photoWidth;

    /**
     * {@code photoHeight} of the photo
     */
    private final double photoHeight;

    /**
     * Constructor to init a {@link InlineQueryResultPhoto} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param photoUrl:            a valid URL of the photo. Photo must be in JPEG format. Photo size must not exceed 5MB
     * @param thumbnailUrl:        URL of the thumbnail for the photo
     * @param photoWidth:          width of the photo
     * @param photoHeight:         height of the photo
     */
    public InlineQueryResultPhoto(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                  String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                  String photoUrl, String thumbnailUrl, double photoWidth, double photoHeight) {
        super(photo, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.photoUrl = photoUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.photoWidth = photoWidth;
        this.photoHeight = photoHeight;
    }

    /**
     * Constructor to init a {@link InlineQueryResultPhoto} object
     *
     * @param jInlineQueryResultPhoto: inline query result photo details as {@link JSONObject}
     */
    public InlineQueryResultPhoto(JSONObject jInlineQueryResultPhoto) {
        super(jInlineQueryResultPhoto);
        photoUrl = hTelegram.getString("photo_url");
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        photoWidth = hTelegram.getDouble("photo_width", 0);
        photoHeight = hTelegram.getDouble("photo_height", 0);
    }

    /**
     * Method to get {@link #photoUrl} instance <br>
     * No-any params required
     *
     * @return {@link #photoUrl} instance as {@link String}
     */
    public String getPhotoUrl() {
        return photoUrl;
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
     * Method to get {@link #photoWidth} instance <br>
     * No-any params required
     *
     * @return {@link #photoWidth} instance as double
     */
    public double getPhotoWidth() {
        return photoWidth;
    }

    /**
     * Method to get {@link #photoWidth} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #photoWidth} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getPhotoWidth(int decimals) {
        return roundValue(photoWidth, decimals);
    }

    /**
     * Method to get {@link #photoHeight} instance <br>
     * No-any params required
     *
     * @return {@link #photoHeight} instance as double
     */
    public double getPhotoHeight() {
        return photoHeight;
    }

    /**
     * Method to get {@link #photoHeight} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #photoHeight} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getPhotoHeight(int decimals) {
        return roundValue(photoHeight, decimals);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultPhoto<T>}
     */
    public static <T extends InputMessageContent.InputMessageContentType> InlineQueryResultPhoto<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultPhoto<>(jItem);
    }

}
