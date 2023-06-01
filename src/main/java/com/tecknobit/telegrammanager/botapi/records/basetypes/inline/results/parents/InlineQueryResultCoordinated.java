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
 * The {@code InlineQueryResultCoordinated} class is useful to format a {@code Telegram}'s inline query result coordinated
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
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
 * @see InlineQueryResultThumbnailed
 */
@Structure
public abstract class InlineQueryResultCoordinated<T extends InputMessageContentType> extends InlineQueryResultThumbnailed<T> {

    /**
     * {@code latitude} of the coordinates
     */
    protected final double latitude;

    /**
     * {@code longitude} of the coordinates
     */
    protected final double longitude;

    /**
     * Constructor to init a {@link InlineQueryResultCoordinated} object
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
     * @param latitude:            latitude of the coordinates
     * @param longitude:           longitude of the coordinates
     */
    public InlineQueryResultCoordinated(InlineQueryResultType type, String id, T inputMessageContent,
                                        InlineKeyboardMarkup replyMarkup, String title, String caption,
                                        ArrayList<MessageEntity> captionEntities, String parseMode, String thumbnailUrl,
                                        double thumbnailWidth, double thumbnailHeight, double latitude, double longitude) {
        super(type, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode, thumbnailUrl,
                thumbnailWidth, thumbnailHeight);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Constructor to init a {@link InlineQueryResultCoordinated} object
     *
     * @param jInlineQueryResultCoordinated: inline query result coordinated details as {@link JSONObject}
     */
    public InlineQueryResultCoordinated(JSONObject jInlineQueryResultCoordinated) {
        super(jInlineQueryResultCoordinated);
        latitude = hTelegram.getDouble("latitude");
        longitude = hTelegram.getDouble("longitude");
    }

    /**
     * Method to get {@link #latitude} instance <br>
     * No-any params required
     *
     * @return {@link #latitude} instance as double
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Method to get {@link #latitude} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #latitude} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getLatitude(int decimals) {
        return roundValue(latitude, decimals);
    }

    /**
     * Method to get {@link #longitude} instance <br>
     * No-any params required
     *
     * @return {@link #longitude} instance as double
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Method to get {@link #longitude} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #longitude} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getLongitude(int decimals) {
        return roundValue(longitude, decimals);
    }

}
