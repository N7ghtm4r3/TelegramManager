package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.*;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.venue;

/**
 * The {@code InlineQueryResultVenue} class is useful to format a {@code Telegram}'s inline query result venue
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultvenue">
 * InlineQueryResultVenue</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 * @see InlineQueryResultThumbnailed
 * @see InlineQueryResultCoordinated
 */
public class InlineQueryResultVenue<T extends InputMessageContentType> extends InlineQueryResultCoordinated<T> {

    /**
     * {@code address} of the venue
     */
    private final String address;

    /**
     * {@code foursquareId} foursquare identifier of the venue if known
     */
    private final String foursquareId;

    /**
     * {@code foursquareType} foursquare type of the venue
     */
    private final String foursquareType;

    /**
     * {@code googlePlaceId} google places identifier of the venue
     */
    private final String googlePlaceId;

    /**
     * {@code googlePlaceType} google places type of the venue
     */
    private final String googlePlaceType;

    /**
     * Constructor to init a {@link InlineQueryResultVenue} object
     *
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
     * @param latitude:            latitude of the venue
     * @param longitude:           longitude of the venue
     * @param address:             address of the venue
     * @param foursquareId:        foursquare identifier of the venue if known
     * @param foursquareType:      foursquare type of the venue
     * @param googlePlaceId:       google places identifier of the venue
     * @param googlePlaceType:     google places type of the venue
     */
    public InlineQueryResultVenue(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                  String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                  String thumbnailUrl, double thumbnailWidth, double thumbnailHeight, double latitude,
                                  double longitude, String address, String foursquareId, String foursquareType,
                                  String googlePlaceId, String googlePlaceType) {
        super(venue, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode, thumbnailUrl,
                thumbnailWidth, thumbnailHeight, latitude, longitude);
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
    }

    /**
     * Constructor to init a {@link InlineQueryResultVenue} object
     *
     * @param jInlineQueryResultVenue: inline query result venue details as {@link JSONObject}
     */
    public InlineQueryResultVenue(JSONObject jInlineQueryResultVenue) {
        super(jInlineQueryResultVenue);
        address = hTelegram.getString("address");
        foursquareId = hTelegram.getString("foursquare_id");
        foursquareType = hTelegram.getString("foursquare_type");
        googlePlaceId = hTelegram.getString("google_place_id");
        googlePlaceType = hTelegram.getString("google_place_type");
    }

    /**
     * Method to get {@link #address} instance <br>
     * No-any params required
     *
     * @return {@link #address} instance as {@link String}
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to get {@link #foursquareId} instance <br>
     * No-any params required
     *
     * @return {@link #foursquareId} instance as {@link String}
     */
    public String getFoursquareId() {
        return foursquareId;
    }

    /**
     * Method to get {@link #foursquareType} instance <br>
     * No-any params required
     *
     * @return {@link #foursquareType} instance as {@link String}
     */
    public String getFoursquareType() {
        return foursquareType;
    }

    /**
     * Method to get {@link #googlePlaceId} instance <br>
     * No-any params required
     *
     * @return {@link #googlePlaceId} instance as {@link String}
     */
    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    /**
     * Method to get {@link #googlePlaceType} instance <br>
     * No-any params required
     *
     * @return {@link #googlePlaceType} instance as {@link String}
     */
    public String getGooglePlaceType() {
        return googlePlaceType;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultVenue<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultVenue<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultVenue<>(jItem);
    }

}
