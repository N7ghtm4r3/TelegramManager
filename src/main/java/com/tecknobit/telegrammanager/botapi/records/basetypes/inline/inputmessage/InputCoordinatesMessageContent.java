package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

@Structure
public abstract class InputCoordinatesMessageContent extends TelegramType {

    protected final double latitude;

    protected final double longitude;

    public InputCoordinatesMessageContent(double latitude, double longitude) {
        super(null);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public InputCoordinatesMessageContent(JSONObject jInputCoordinatesMessageContent) {
        super(jInputCoordinatesMessageContent);
        latitude = hTelegram.getDouble("latitude");
        longitude = hTelegram.getDouble("longitude");
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
