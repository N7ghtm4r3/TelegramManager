package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class ShippingAddress extends TelegramType {

    private final String countryCode;

    private final String state;

    private final String city;

    private final String streetLine1;

    private final String streetLine2;

    private final String postCode;

    public ShippingAddress(String countryCode, String state, String city, String streetLine1, String streetLine2,
                           String postCode) {
        super(null);
        this.countryCode = countryCode;
        this.state = state;
        this.city = city;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.postCode = postCode;
    }

    public ShippingAddress(JSONObject jShippingAddress) {
        super(jShippingAddress);
        countryCode = hTelegram.getString("country_code");
        state = hTelegram.getString("state");
        city = hTelegram.getString("city");
        streetLine1 = hTelegram.getString("street_line1");
        streetLine2 = hTelegram.getString("street_line2");
        postCode = hTelegram.getString("post_code");
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public String getPostCode() {
        return postCode;
    }

    public static ShippingAddress getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ShippingAddress(jItem);
    }

}
