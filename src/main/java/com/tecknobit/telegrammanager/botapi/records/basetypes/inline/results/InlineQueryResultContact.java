package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.contact;

/**
 * The {@code InlineQueryResultContact} class is useful to format a {@code Telegram}'s inline query result contact
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultcontact">
 * InlineQueryResultContact</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 */
public class InlineQueryResultContact<T extends InputMessageContentType> extends InlineQueryResult<T> {

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
     * {@code thumbnailUrl} url of the thumbnail for the result
     */
    private final String thumbnailUrl;

    /**
     * {@code thumbnailWidth} thumbnail width
     */
    private final double thumbnailWidth;

    /**
     * {@code thumbnailHeight} thumbnail height
     */
    private final double thumbnailHeight;

    /**
     * Constructor to init a {@link InlineQueryResultContact} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param phoneNumber:         contact's phone number
     * @param firstName:           contact's first name
     * @param lastName:            contact's last name
     * @param vCard:               additional data about the contact in the form of a vCard, 0-2048 bytes
     * @param thumbnailUrl:        url of the thumbnail for the result
     * @param thumbnailWidth:      thumbnail width
     * @param thumbnailHeight:     thumbnail height
     */
    public InlineQueryResultContact(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String phoneNumber,
                                    String firstName, String lastName, String vCard, String thumbnailUrl,
                                    double thumbnailWidth, double thumbnailHeight) {
        super(contact, id, inputMessageContent, replyMarkup);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vCard = vCard;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    /**
     * Constructor to init a {@link InlineQueryResultContact} object
     *
     * @param jInlineQueryResultContact: inline query result contact details as {@link JSONObject}
     */
    public InlineQueryResultContact(JSONObject jInlineQueryResultContact) {
        super(jInlineQueryResultContact);
        phoneNumber = hTelegram.getString("phone_number");
        firstName = hTelegram.getString("first_name");
        lastName = hTelegram.getString("last_name");
        vCard = hTelegram.getString("vcard");
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        thumbnailWidth = hTelegram.getDouble("thumbnail_width", 0);
        thumbnailHeight = hTelegram.getDouble("thumbnail_height", 0);
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
     * Method to get {@link #thumbnailUrl} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailUrl} instance as {@link String}
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Method to get {@link #thumbnailWidth} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailWidth} instance as double
     */
    public double getThumbnailWidth() {
        return thumbnailWidth;
    }

    /**
     * Method to get {@link #thumbnailWidth} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #thumbnailWidth} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getThumbnailWidth(int decimals) {
        return roundValue(thumbnailWidth, decimals);
    }

    /**
     * Method to get {@link #thumbnailHeight} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailHeight} instance as double
     */
    public double getThumbnailHeight() {
        return thumbnailHeight;
    }

    /**
     * Method to get {@link #thumbnailHeight} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #thumbnailHeight} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getThumbnailHeight(int decimals) {
        return roundValue(thumbnailHeight, decimals);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultContact<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultContact<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultContact<>(jItem);
    }

}
