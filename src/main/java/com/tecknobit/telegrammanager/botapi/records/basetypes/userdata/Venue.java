package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class Venue extends TelegramType {

    private final Location location;

    private final String title;

    private final String address;

    private final String foursquareId;

    private final String foursquareType;

    private final String googlePlaceId;

    private final String googlePlaceType;

    public Venue(Location location, String title, String address, String foursquareId, String foursquareType,
                 String googlePlaceId, String googlePlaceType) {
        super(null);
        this.location = location;
        this.title = title;
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
    }

    public Venue(JSONObject jVenue) {
        super(jVenue);
        location = Location.getInstance(hTelegram.getJSONObject("location"));
        title = hTelegram.getString("title");
        address = hTelegram.getString("address");
        foursquareId = hTelegram.getString("foursquare_id");
        foursquareType = hTelegram.getString("foursquare_type");
        googlePlaceId = hTelegram.getString("google_place_id");
        googlePlaceType = hTelegram.getString("google_place_type");
    }

    public Location getLocation() {
        return location;
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

    public static Venue getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Venue(jItem);
    }

}
