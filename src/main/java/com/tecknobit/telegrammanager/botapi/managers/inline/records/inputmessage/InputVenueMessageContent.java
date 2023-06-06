package com.tecknobit.telegrammanager.botapi.managers.inline.records.inputmessage;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code InputVenueMessageContent} class is useful to format a {@code Telegram}'s input venue message content
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputvenuemessagecontent">
 * InputVenueMessageContent</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputCoordinatesMessageContent
 */
public class InputVenueMessageContent extends InputCoordinatesMessageContent {

    /**
     * {@code title} name of the venue
     */
    private final String title;

    /**
     * {@code address} address of the venue
     */
    private final String address;

    /**
     * {@code foursquareId} foursquare identifier of the venue, if known
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
     * Constructor to init a {@link InputVenueMessageContent} object
     *
     * @param latitude:        latitude of the venue in degrees
     * @param longitude:       longitude of the venue in degrees
     * @param title:           name of the venue
     * @param address:         address of the venue
     * @param foursquareId:    foursquare identifier of the venue, if known
     * @param foursquareType:  foursquare type of the venue
     * @param googlePlaceId:   google places identifier of the venue
     * @param googlePlaceType: google places type of the venue
     */
    public InputVenueMessageContent(double latitude, double longitude, String title, String address, String foursquareId,
                                    String foursquareType, String googlePlaceId, String googlePlaceType) {
        super(latitude, longitude);
        this.title = title;
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
    }

    /**
     * Constructor to init a {@link InputVenueMessageContent} object
     *
     * @param jInputVenueMessageContent: input venue message content details as {@link JSONObject}
     */
    public InputVenueMessageContent(JSONObject jInputVenueMessageContent) {
        super(jInputVenueMessageContent);
        title = hTelegram.getString("title");
        address = hTelegram.getString("address");
        foursquareId = hTelegram.getString("foursquare_id");
        foursquareType = hTelegram.getString("foursquare_type");
        googlePlaceId = hTelegram.getString("google_place_id");
        googlePlaceType = hTelegram.getString("google_place_type");
    }

    /**
     * Method to get {@link #title} instance <br>
     * No-any params required
     *
     * @return {@link #title} instance as {@link String}
     */
    public String getTitle() {
        return title;
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
     * @return instance as {@link InputVenueMessageContent}
     */
    public static InputVenueMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputVenueMessageContent(jItem);
    }

}
