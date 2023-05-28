package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class InputContactMessageContent extends TelegramType {

    private final String phoneNumber;

    private final String firstName;

    private final String lastName;

    private final String vCard;

    public InputContactMessageContent(String phoneNumber, String firstName, String lastName, String vCard) {
        super(null);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vCard = vCard;
    }

    public InputContactMessageContent(JSONObject jInputContactMessageContent) {
        super(jInputContactMessageContent);
        phoneNumber = hTelegram.getString("phone_number");
        firstName = hTelegram.getString("first_name");
        lastName = hTelegram.getString("last_name");
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

    public String getvCard() {
        return vCard;
    }

    public static InputContactMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputContactMessageContent(jItem);
    }

}
