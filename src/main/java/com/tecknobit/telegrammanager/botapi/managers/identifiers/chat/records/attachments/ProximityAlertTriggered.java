package com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.attachments;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ProximityAlertTriggered} class is useful to format a {@code Telegram}'s proximity alert triggered
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#proximityalerttriggered">
 * ProximityAlertTriggered</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ProximityAlertTriggered extends TelegramType {

    /**
     * {@code traveler} user that triggered the alert
     */
    private final User traveler;

    /**
     * {@code watcher} user that set the alert
     */
    private final User watcher;

    /**
     * {@code distance} the distance between the users
     */
    private final int distance;

    /**
     * Constructor to init a {@link ProximityAlertTriggered} object
     *
     * @param traveler: user that triggered the alert
     * @param watcher:  user that set the alert
     * @param distance: the distance between the users
     */
    public ProximityAlertTriggered(User traveler, User watcher, int distance) {
        super(null);
        this.traveler = traveler;
        this.watcher = watcher;
        this.distance = distance;
    }

    /**
     * Constructor to init a {@link ProximityAlertTriggered} object
     *
     * @param jProximityAlertTriggered: proximity alert triggered details as {@link JSONObject}
     */
    public ProximityAlertTriggered(JSONObject jProximityAlertTriggered) {
        super(jProximityAlertTriggered);
        traveler = User.getInstance(hTelegram.getJSONObject("traveler"));
        watcher = User.getInstance(hTelegram.getJSONObject("watcher"));
        distance = hTelegram.getInt("distance");
    }

    /**
     * Method to get {@link #traveler} instance <br>
     * No-any params required
     *
     * @return {@link #traveler} instance as {@link User}
     */
    public User getTraveler() {
        return traveler;
    }

    /**
     * Method to get {@link #watcher} instance <br>
     * No-any params required
     *
     * @return {@link #watcher} instance as {@link User}
     */
    public User getWatcher() {
        return watcher;
    }

    /**
     * Method to get {@link #distance} instance <br>
     * No-any params required
     *
     * @return {@link #distance} instance as int
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ProximityAlertTriggered}
     */
    public static ProximityAlertTriggered getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ProximityAlertTriggered(jItem);
    }

}
