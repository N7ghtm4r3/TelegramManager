package com.tecknobit.telegrammanager.botapi.managers.profile.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ShippingAddress} class is useful to format a {@code Telegram}'s shipping address
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#shippingaddress">
 * ShippingAddress</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ShippingAddress extends TelegramType {

    /**
     * {@code countryCode} two-letter ISO 3166-1 alpha-2 country code
     */
    private final String countryCode;

    /**
     * {@code state} if applicable
     */
    private final String state;

    /**
     * {@code city} value
     */
    private final String city;

    /**
     * {@code streetLine1} first line for the address
     */
    private final String streetLine1;

    /**
     * {@code streetLine2} second line for the address
     */
    private final String streetLine2;

    /**
     * {@code postCode} address post code
     */
    private final String postCode;

    /**
     * Constructor to init a {@link ShippingAddress} object
     *
     * @param countryCode: two-letter ISO 3166-1 alpha-2 country code
     * @param state:       state, if applicable
     * @param city:        city value
     * @param streetLine1: first line for the address
     * @param streetLine2: second line for the address
     * @param postCode:    address post code
     */
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

    /**
     * Constructor to init a {@link ShippingAddress} object
     *
     * @param jShippingAddress: shipping address details as {@link JSONObject}
     */
    public ShippingAddress(JSONObject jShippingAddress) {
        super(jShippingAddress);
        countryCode = hTelegram.getString("country_code");
        state = hTelegram.getString("state");
        city = hTelegram.getString("city");
        streetLine1 = hTelegram.getString("street_line1");
        streetLine2 = hTelegram.getString("street_line2");
        postCode = hTelegram.getString("post_code");
    }

    /**
     * Method to get {@link #countryCode} instance <br>
     * No-any params required
     *
     * @return {@link #countryCode} instance as {@link String}
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Method to get {@link #state} instance <br>
     * No-any params required
     *
     * @return {@link #state} instance as {@link String}
     */
    public String getState() {
        return state;
    }

    /**
     * Method to get {@link #city} instance <br>
     * No-any params required
     *
     * @return {@link #city} instance as {@link String}
     */
    public String getCity() {
        return city;
    }

    /**
     * Method to get {@link #streetLine1} instance <br>
     * No-any params required
     *
     * @return {@link #streetLine1} instance as {@link String}
     */
    public String getStreetLine1() {
        return streetLine1;
    }

    /**
     * Method to get {@link #streetLine2} instance <br>
     * No-any params required
     *
     * @return {@link #streetLine2} instance as {@link String}
     */
    public String getStreetLine2() {
        return streetLine2;
    }

    /**
     * Method to get {@link #postCode} instance <br>
     * No-any params required
     *
     * @return {@link #postCode} instance as {@link String}
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ShippingAddress}
     */
    public static ShippingAddress getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ShippingAddress(jItem);
    }

}
