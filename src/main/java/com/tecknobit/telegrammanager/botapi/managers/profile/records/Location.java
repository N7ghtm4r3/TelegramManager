package com.tecknobit.telegrammanager.botapi.managers.profile.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code Location} class is useful to format a {@code Telegram}'s location
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#location">
 * Location</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class Location extends TelegramType {

    /**
     * {@code longitude} longitude as defined by sender
     */
    private final double longitude;

    /**
     * {@code latitude} latitude as defined by sender
     */
    private final double latitude;

    /**
     * {@code horizontalAccuracy} the radius of uncertainty for the location, measured in meters; 0-1500
     */
    private final double horizontalAccuracy;

    /**
     * {@code livePeriod} time relative to the message sending date, during which the location can be updated; in seconds.
     * For active live locations only
     */
    private final long livePeriod;

    /**
     * {@code heading} the direction in which user is moving, in degrees; 1-360. For active live locations only
     */
    private final int heading;

    /**
     * {@code proximityAlertRadius} the maximum distance for proximity alerts about approaching another chat member,
     * in meters. For sent live locations only
     */
    private final double proximityAlertRadius;

    /**
     * Constructor to init a {@link Location} object
     *
     * @param longitude:            longitude as defined by sender
     * @param latitude:             latitude as defined by sender
     * @param horizontalAccuracy:   the radius of uncertainty for the location, measured in meters; 0-1500
     * @param livePeriod:           time relative to the message sending date, during which the location can be updated; in seconds.
     *                              For active live locations only
     * @param heading:              the direction in which user is moving, in degrees; 1-360. For active live locations only
     * @param proximityAlertRadius: the maximum distance for proximity alerts about approaching another chat member,
     *                              in meters. For sent live locations only
     */
    public Location(double longitude, double latitude, double horizontalAccuracy, long livePeriod, int heading,
                    double proximityAlertRadius) {
        super(null);
        this.longitude = longitude;
        this.latitude = latitude;
        this.horizontalAccuracy = horizontalAccuracy;
        this.livePeriod = livePeriod;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
    }

    /**
     * Constructor to init a {@link Location} object
     *
     * @param jLocation: location details as {@link JSONObject}
     */
    public Location(JSONObject jLocation) {
        super(jLocation);
        longitude = hTelegram.getDouble("longitude", 0);
        latitude = hTelegram.getDouble("latitude", 0);
        horizontalAccuracy = hTelegram.getDouble("horizontal_accuracy", 0);
        livePeriod = hTelegram.getLong("live_period", 0);
        heading = hTelegram.getInt("heading", 1);
        proximityAlertRadius = hTelegram.getDouble("proximity_alert_radius", 0);
    }

    /**
     * Method to get {@link #longitude} instance <br>
     * No-any params required
     *
     * @return {@link #longitude} instance as double
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Method to get {@link #longitude} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #longitude} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getLongitude(int decimals) {
        return roundValue(longitude, decimals);
    }

    /**
     * Method to get {@link #latitude} instance <br>
     * No-any params required
     *
     * @return {@link #latitude} instance as double
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Method to get {@link #latitude} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #latitude} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getLatitude(int decimals) {
        return roundValue(latitude, decimals);
    }

    /**
     * Method to get {@link #horizontalAccuracy} instance <br>
     * No-any params required
     *
     * @return {@link #horizontalAccuracy} instance as double
     */
    public double getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    /**
     * Method to get {@link #horizontalAccuracy} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #horizontalAccuracy} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getHorizontalAccuracy(int decimals) {
        return roundValue(horizontalAccuracy, decimals);
    }

    /**
     * Method to get {@link #livePeriod} instance <br>
     * No-any params required
     *
     * @return {@link #livePeriod} instance as long
     */
    public long getLivePeriod() {
        return livePeriod;
    }

    /**
     * Method to get {@link #heading} instance <br>
     * No-any params required
     *
     * @return {@link #heading} instance as int
     */
    public int getHeading() {
        return heading;
    }

    /**
     * Method to get {@link #proximityAlertRadius} instance <br>
     * No-any params required
     *
     * @return {@link #proximityAlertRadius} instance as double
     */
    public double getProximityAlertRadius() {
        return proximityAlertRadius;
    }

    /**
     * Method to get {@link #horizontalAccuracy} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #horizontalAccuracy} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getProximityAlertRadius(int decimals) {
        return roundValue(proximityAlertRadius, decimals);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Location}
     */
    public static Location getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Location(jItem);
    }

}
