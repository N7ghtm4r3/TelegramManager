package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import org.json.JSONObject;

public class InputLocationMessageContent extends InputCoordinatesMessageContent {

    private final double horizontalAccuracy;

    private final int livePeriod;

    private final int heading;

    private final int proximityAlertRadius;

    public InputLocationMessageContent(double latitude, double longitude, double horizontalAccuracy, int livePeriod,
                                       int heading, int proximityAlertRadius) {
        super(latitude, longitude);
        this.horizontalAccuracy = horizontalAccuracy;
        this.livePeriod = livePeriod;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
    }

    public InputLocationMessageContent(JSONObject jInputLocationMessageContent) {
        super(jInputLocationMessageContent);
        horizontalAccuracy = hTelegram.getDouble("horizontal_accuracy");
        livePeriod = hTelegram.getInt("live_period");
        heading = hTelegram.getInt("heading");
        proximityAlertRadius = hTelegram.getInt("proximity_alert_radius");
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

    public static InputLocationMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputLocationMessageContent(jItem);
    }

}
