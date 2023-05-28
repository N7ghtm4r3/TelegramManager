package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import org.json.JSONObject;

public class InputVenueMessageContent extends InputCoordinatesMessageContent {

    private final String title;

    private final String address;

    private final String foursquareId;

    private final String foursquareType;

    private final String googlePlaceId;

    private final String googlePlaceType;

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

    public InputVenueMessageContent(JSONObject jInputVenueMessageContent) {
        super(jInputVenueMessageContent);
        title = hTelegram.getString("title");
        address = hTelegram.getString("address");
        foursquareId = hTelegram.getString("foursquare_id");
        foursquareType = hTelegram.getString("foursquare_type");
        googlePlaceId = hTelegram.getString("google_place_id");
        googlePlaceType = hTelegram.getString("google_place_type");
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public String getFoursquareType() {
        return foursquareType;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public String getGooglePlaceType() {
        return googlePlaceType;
    }

    public static InputVenueMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputVenueMessageContent(jItem);
    }

}
