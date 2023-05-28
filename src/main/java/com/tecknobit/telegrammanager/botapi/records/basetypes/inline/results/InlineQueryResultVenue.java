package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCoordinated;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.venue;

public class InlineQueryResultVenue<T extends InputMessageContentType> extends InlineQueryResultCoordinated<T> {

    private final String address;

    private final String foursquareId;

    private final String foursquareType;

    private final String googlePlaceId;

    private final String googlePlaceType;

    public InlineQueryResultVenue(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                  String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                  String documentUrl, InlineQueryResultDocument.DocumentMimeType mimeType,
                                  String thumbnailUrl, double thumbnailWidth, double thumbnailHeight, double latitude,
                                  double longitude, String address, String foursquareId, String foursquareType,
                                  String googlePlaceId, String googlePlaceType) {
        super(venue, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode, documentUrl,
                mimeType, thumbnailUrl, thumbnailWidth, thumbnailHeight, latitude, longitude);
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
    }

    public InlineQueryResultVenue(JSONObject jInlineQueryResultVenue) {
        super(jInlineQueryResultVenue);
        address = hTelegram.getString("address");
        foursquareId = hTelegram.getString("foursquare_id");
        foursquareType = hTelegram.getString("foursquare_type");
        googlePlaceId = hTelegram.getString("google_place_id");
        googlePlaceType = hTelegram.getString("google_place_type");
    }

    public String getAddress() {
        return address;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public String getFoursquareType() {
        return foursquareType;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public String getGooglePlaceType() {
        return googlePlaceType;
    }

    public static <T extends InputMessageContentType> InlineQueryResultVenue<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultVenue<>(jItem);
    }

}
