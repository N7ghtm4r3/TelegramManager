package com.tecknobit.telegrammanager.botapi.managers.inline.records.inputmessage;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code InputLocationMessageContent} class is useful to format a {@code Telegram}'s input location message content
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputlocationmessagecontent">
 * InputLocationMessageContent</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputCoordinatesMessageContent
 */
public class InputLocationMessageContent extends InputCoordinatesMessageContent {

    /**
     * {@code horizontalAccuracy} the radius of uncertainty for the location, measured in meters; 0-1500
     */
    private final double horizontalAccuracy;

    /**
     * {@code livePeriod} period in seconds for which the location can be updated, should be between 60 and 86400
     */
    private final int livePeriod;

    /**
     * {@code heading} for live locations, a direction in which the user is moving, in degrees. Must be between 1 and
     * 360 if specified
     */
    private final int heading;

    /**
     * {@code proximityAlertRadius} for live locations, a maximum distance for proximity alerts about approaching another
     * chat member, in meters. Must be between 1 and 100000 if specified
     */
    private final int proximityAlertRadius;

    /**
     * Constructor to init a {@link InputLocationMessageContent} object
     *
     * @param latitude:             latitude of the location in degrees
     * @param longitude:            longitude of the location in degrees
     * @param horizontalAccuracy:   the radius of uncertainty for the location, measured in meters; 0-1500
     * @param livePeriod:           period in seconds for which the location can be updated, should be between 60 and 86400
     * @param heading:              for live locations, a direction in which the user is moving, in degrees. Must be between 1 and
     *                              360 if specified
     * @param proximityAlertRadius: for live locations, a maximum distance for proximity alerts about approaching another
     *                              chat member, in meters. Must be between 1 and 100000 if specified
     */
    public InputLocationMessageContent(double latitude, double longitude, double horizontalAccuracy, int livePeriod,
                                       int heading, int proximityAlertRadius) {
        super(latitude, longitude);
        this.horizontalAccuracy = horizontalAccuracy;
        this.livePeriod = livePeriod;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
    }

    /**
     * Constructor to init a {@link InputLocationMessageContent} object
     *
     * @param jInputLocationMessageContent: input location message content details as {@link JSONObject}
     */
    public InputLocationMessageContent(JSONObject jInputLocationMessageContent) {
        super(jInputLocationMessageContent);
        horizontalAccuracy = hTelegram.getDouble("horizontal_accuracy", 0);
        livePeriod = hTelegram.getInt("live_period", 60);
        heading = hTelegram.getInt("heading", 1);
        proximityAlertRadius = hTelegram.getInt("proximity_alert_radius", 1);
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
     * @return {@link #livePeriod} instance as int
     */
    public int getLivePeriod() {
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
     * @return {@link #proximityAlertRadius} instance as int
     */
    public int getProximityAlertRadius() {
        return proximityAlertRadius;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InputLocationMessageContent}
     */
    public static InputLocationMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputLocationMessageContent(jItem);
    }

}
