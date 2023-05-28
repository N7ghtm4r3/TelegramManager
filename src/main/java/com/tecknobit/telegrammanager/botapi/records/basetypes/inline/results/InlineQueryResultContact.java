package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.contact;

public class InlineQueryResultContact<T extends InputMessageContentType> extends InlineQueryResult<T> {

    private final String phoneNumber;

    private final String firstName;

    private final String lastName;

    private final String vCard;

    private final String thumbnailUrl;

    private final double thumbnailWidth;

    private final double thumbnailHeight;

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

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public double getThumbnailWidth() {
        return thumbnailWidth;
    }

    public double getThumbnailHeight() {
        return thumbnailHeight;
    }

    public static <T extends InputMessageContentType> InlineQueryResultContact<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultContact<>(jItem);
    }

}
