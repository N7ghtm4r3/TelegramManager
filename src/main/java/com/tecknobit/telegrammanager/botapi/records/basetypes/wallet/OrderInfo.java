package com.tecknobit.telegrammanager.botapi.records.basetypes.wallet;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.ShippingAddress;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class OrderInfo extends TelegramType {

    private final String name;

    private final String phoneNumber;

    private final String email;

    private final ShippingAddress shippingAddress;

    public OrderInfo(String name, String phoneNumber, String email, ShippingAddress shippingAddress) {
        super(null);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.shippingAddress = shippingAddress;
    }

    public OrderInfo(JSONObject jOrderInfo) {
        super(jOrderInfo);
        name = hTelegram.getString("name");
        phoneNumber = hTelegram.getString("phone_number");
        email = hTelegram.getString("email");
        shippingAddress = ShippingAddress.getInstance(hTelegram.getJSONObject("shipping_address"));
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public static OrderInfo getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new OrderInfo(jItem);
    }

}
