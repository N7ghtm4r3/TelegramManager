package com.tecknobit.telegrammanager.botapi.managers.profile.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code Contact} class is useful to format a {@code Telegram}'s contact
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#contact">
 * Contact</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class Contact extends TelegramType {

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
     * {@code userId} contact's user identifier in Telegram. This number may have more than 32 significant bits and some
     * programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits,
     * so a 64-bit integer or double-precision float type are safe for storing this identifier
     */
    private final long userId;

    /**
     * {@code vCard} additional data about the contact in the form of a vCard
     */
    private final String vCard;

    /**
     * Constructor to init a {@link Contact} object
     *
     * @param phoneNumber: contact's phone number
     * @param firstName:   contact's first name
     * @param lastName:    contact's last name
     * @param userId:      contact's user identifier in Telegram. This number may have more than 32 significant bits and some
     *                     programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits,
     *                     so a 64-bit integer or double-precision float type are safe for storing this identifier
     * @param vCard:       additional data about the contact in the form of a vCard
     */
    public Contact(String phoneNumber, String firstName, String lastName, long userId, String vCard) {
        super(null);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.vCard = vCard;
    }

    /**
     * Constructor to init a {@link Contact} object
     *
     * @param jContact: contact details as {@link JSONObject}
     */
    public Contact(JSONObject jContact) {
        super(jContact);
        phoneNumber = hTelegram.getString("phone_number");
        firstName = hTelegram.getString("first_name");
        lastName = hTelegram.getString("last_name");
        userId = hTelegram.getLong("user_id");
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
     * Method to get {@link #userId} instance <br>
     * No-any params required
     *
     * @return {@link #userId} instance as long
     */
    public long getUserId() {
        return userId;
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
     * @return instance as {@link Contact}
     */
    public static Contact getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Contact(jItem);
    }

}
