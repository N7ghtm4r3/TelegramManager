package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code InlineQueryResultThumbnailed} class is useful to format a {@code Telegram}'s inline query result thumbnailed
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultdocument">
 *             InlineQueryResultDocument</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultlocation">
 *             InlineQueryResultLocation</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultvenue">
 *             InlineQueryResultVenue</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
@Structure
public abstract class InlineQueryResultThumbnailed<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code thumbnailUrl} URL of the thumbnail
     */
    protected final String thumbnailUrl;

    /**
     * {@code thumbnailWidth} thumbnail width
     */
    protected final double thumbnailWidth;

    /**
     * {@code thumbnailHeight} thumbnail height
     */
    protected final double thumbnailHeight;

    /**
     * Constructor to init a {@link InlineQueryResultThumbnailed} object
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
     * @param thumbnailUrl:        URL of the thumbnail
     * @param thumbnailWidth:      thumbnail width
     * @param thumbnailHeight:     thumbnail height
     */
    public InlineQueryResultThumbnailed(InlineQueryResultType type, String id, T inputMessageContent,
                                        InlineKeyboardMarkup replyMarkup, String title, String caption,
                                        ArrayList<MessageEntity> captionEntities, String parseMode, String thumbnailUrl,
                                        double thumbnailWidth, double thumbnailHeight) {
        super(type, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    /**
     * Constructor to init a {@link InlineQueryResultThumbnailed} object
     *
     * @param jInlineQueryResultThumbnailed: inline query result thumbnailed details as {@link JSONObject}
     */
    public InlineQueryResultThumbnailed(JSONObject jInlineQueryResultThumbnailed) {
        super(jInlineQueryResultThumbnailed);
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        thumbnailWidth = hTelegram.getDouble("thumbnail_width", 0);
        thumbnailHeight = hTelegram.getDouble("thumbnail_height", 0);
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
     * Method to get {@link #thumbnailWidth} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailWidth} instance as double
     */
    public double getThumbnailWidth() {
        return thumbnailWidth;
    }

    /**
     * Method to get {@link #thumbnailWidth} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #thumbnailWidth} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getThumbnailWidth(int decimals) {
        return roundValue(thumbnailWidth, decimals);
    }

    /**
     * Method to get {@link #thumbnailHeight} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailHeight} instance as double
     */
    public double getThumbnailHeight() {
        return thumbnailHeight;
    }

    /**
     * Method to get {@link #thumbnailHeight} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #thumbnailHeight} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getThumbnailHeight(int decimals) {
        return roundValue(thumbnailHeight, decimals);
    }

}
