package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class Contact extends TelegramType {

    private final String phoneNumber;

    private final String firstName;

    private final String lastName;

    private final long userId;

    private final String vCard;

    public Contact(String phoneNumber, String firstName, String lastName, long userId, String vCard) {
        super(null);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.vCard = vCard;
    }

    public Contact(JSONObject jContact) {
        super(jContact);
        phoneNumber = hTelegram.getString("phone_number");
        firstName = hTelegram.getString("first_name");
        lastName = hTelegram.getString("last_name");
        userId = hTelegram.getLong("user_id");
        vCard = hTelegram.getString("vcard");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getUserId() {
        return userId;
    }

    public String getvCard() {
        return vCard;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Contact}
     */
    public static Contact getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Contact(jItem);
    }

}
