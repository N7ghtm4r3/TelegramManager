package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments;

import com.tecknobit.telegrammanager.botapi.records.basetypes.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class ProximityAlertTriggered extends TelegramType {

    private final User traveler;

    private final User watcher;

    private final int distance;

    public ProximityAlertTriggered(User traveler, User watcher, int distance) {
        super(null);
        this.traveler = traveler;
        this.watcher = watcher;
        this.distance = distance;
    }

    public ProximityAlertTriggered(JSONObject jProximityAlertTriggered) {
        super(jProximityAlertTriggered);
        traveler = User.getInstance(hTelegram.getJSONObject("traveler"));
        watcher = User.getInstance(hTelegram.getJSONObject("watcher"));
        distance = hTelegram.getInt("distance");
    }

    public User getTraveler() {
        return traveler;
    }

    public User getWatcher() {
        return watcher;
    }

    public int getDistance() {
        return distance;
    }

    public static ProximityAlertTriggered getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ProximityAlertTriggered(jItem);
    }

}
