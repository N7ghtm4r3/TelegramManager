package com.tecknobit.telegrammanager.botapi.records.basetypes.wallet;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.ShippingAddress;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code OrderInfo} class is useful to format a {@code Telegram}'s order info
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#orderinfo">
 * OrderInfo</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class OrderInfo extends TelegramType {

    /**
     * {@code name} user name
     */
    private final String name;

    /**
     * {@code phoneNumber} user's phone number
     */
    private final String phoneNumber;

    /**
     * {@code email} user email
     */
    private final String email;

    /**
     * {@code shippingAddress} user shipping address
     */
    private final ShippingAddress shippingAddress;

    /**
     * Constructor to init a {@link OrderInfo} object
     *
     * @param name:            user name
     * @param phoneNumber:     user's phone number
     * @param email:           user email
     * @param shippingAddress: user shipping address
     */
    public OrderInfo(String name, String phoneNumber, String email, ShippingAddress shippingAddress) {
        super(null);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shippingAddress = shippingAddress;
    }

    /**
     * Constructor to init a {@link OrderInfo} object
     *
     * @param jOrderInfo: order info details as {@link JSONObject}
     */
    public OrderInfo(JSONObject jOrderInfo) {
        super(jOrderInfo);
        name = hTelegram.getString("name");
        phoneNumber = hTelegram.getString("phone_number");
        email = hTelegram.getString("email");
        shippingAddress = ShippingAddress.getInstance(hTelegram.getJSONObject("shipping_address"));
    }

    /**
     * Method to get {@link #name} instance <br>
     * No-any params required
     *
     * @return {@link #name} instance as {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get {@link #phoneNumber} instance <br>
     * No-any params required
     *
     * @return {@link #phoneNumber} instance as {@link String}
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to get {@link #email} instance <br>
     * No-any params required
     *
     * @return {@link #email} instance as {@link String}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to get {@link #shippingAddress} instance <br>
     * No-any params required
     *
     * @return {@link #shippingAddress} instance as {@link ShippingAddress}
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link OrderInfo}
     */
    public static OrderInfo getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new OrderInfo(jItem);
    }

}
