package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCoordinated;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.location;

public class InlineQueryResultLocation<T extends InputMessageContentType> extends InlineQueryResultCoordinated<T> {

    private final double horizontalAccuracy;

    private final int livePeriod;

    private final int heading;

    private final int proximityAlertRadius;

    public InlineQueryResultLocation(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                     String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                     String documentUrl, InlineQueryResultDocument.DocumentMimeType mimeType,
                                     String thumbnailUrl, double thumbnailWidth, double thumbnailHeight, double latitude,
                                     double longitude, double horizontalAccuracy, int livePeriod, int heading,
                                     int proximityAlertRadius) {
        super(location, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode, documentUrl,
                mimeType, thumbnailUrl, thumbnailWidth, thumbnailHeight, latitude, longitude);
        this.horizontalAccuracy = horizontalAccuracy;
        this.livePeriod = livePeriod;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
    }

    public InlineQueryResultLocation(JSONObject jInlineQueryResultLocation) {
        super(jInlineQueryResultLocation);
        horizontalAccuracy = hTelegram.getDouble("horizontal_accuracy", 0);
        livePeriod = hTelegram.getInt("live_period", 60);
        heading = hTelegram.getInt("heading", 1);
        proximityAlertRadius = hTelegram.getInt("proximity_alert_radius", 0);
    }

    public double getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    public int getLivePeriod() {
        return livePeriod;
    }

    public int getHeading() {
        return heading;
    }

    public int getProximityAlertRadius() {
        return proximityAlertRadius;
    }

    public static <T extends InputMessageContentType> InlineQueryResultLocation<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultLocation<>(jItem);
    }

}
