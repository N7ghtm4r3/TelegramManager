package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;

/**
 * The {@code InputContactMessageContent} class is useful to format a {@code Telegram}'s input contact message content
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputcontactmessagecontent">
 * InputContactMessageContent</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputMessageContentType
 */
public class InputContactMessageContent extends TelegramType implements InputMessageContentType {

    /**
     * {@code phoneNumber} contact's phone number
     */
    private final String phoneNumber;

    /**
     * {@code firstName} contact's first name
     */
    private final String firstName;

    /**
     * {@code lastName} contact's last name
     */
    private final String lastName;

    /**
     * {@code vCard} additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    private final String vCard;

    /**
     * Constructor to init a {@link InputContactMessageContent} object
     *
     * @param phoneNumber: contact's phone number
     * @param firstName:   contact's first name
     * @param lastName:    contact's last name
     * @param vCard:       additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    public InputContactMessageContent(String phoneNumber, String firstName, String lastName, String vCard) {
        super(null);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vCard = vCard;
    }

    /**
     * Constructor to init a {@link InputContactMessageContent} object
     *
     * @param jInputContactMessageContent: input contact message content details as {@link JSONObject}
     */
    public InputContactMessageContent(JSONObject jInputContactMessageContent) {
        super(jInputContactMessageContent);
        phoneNumber = hTelegram.getString("phone_number");
        firstName = hTelegram.getString("first_name");
        lastName = hTelegram.getString("last_name");
        vCard = hTelegram.getString("vcard");
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
     * Method to get {@link #firstName} instance <br>
     * No-any params required
     *
     * @return {@link #firstName} instance as {@link String}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to get {@link #lastName} instance <br>
     * No-any params required
     *
     * @return {@link #lastName} instance as {@link String}
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method to get {@link #vCard} instance <br>
     * No-any params required
     *
     * @return {@link #vCard} instance as {@link String}
     */
    public String getvCard() {
        return vCard;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InputContactMessageContent}
     */
    public static InputContactMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputContactMessageContent(jItem);
    }

}
