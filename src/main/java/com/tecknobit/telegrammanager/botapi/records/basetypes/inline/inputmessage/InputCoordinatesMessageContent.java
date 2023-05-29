package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code InputCoordinatesMessageContent} class is useful to format a {@code Telegram}'s input coordinates message content
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *          <a href="https://core.telegram.org/bots/api#inputlocationmessagecontent">
 *              InputLocationMessageContent</a>
 *     </li>
 *     <li>
 *          <a href="https://core.telegram.org/bots/api#inputvenuemessagecontent">
 *              InputVenueMessageContent</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputMessageContentType
 */
@Structure
public abstract class InputCoordinatesMessageContent extends TelegramType implements InputMessageContentType {

    /**
     * {@code latitude} of the location in degrees
     */
    protected final double latitude;

    /**
     * {@code longitude} of the location in degrees
     */
    protected final double longitude;

    /**
     * Constructor to init a {@link InputCoordinatesMessageContent} object
     *
     * @param latitude:  latitude of the coordinates in degrees
     * @param longitude: longitude of the coordinates in degrees
     */
    public InputCoordinatesMessageContent(double latitude, double longitude) {
        super(null);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Constructor to init a {@link InputCoordinatesMessageContent} object
     *
     * @param jInputCoordinatesMessageContent: input coordinates message content details as {@link JSONObject}
     */
    public InputCoordinatesMessageContent(JSONObject jInputCoordinatesMessageContent) {
        super(jInputCoordinatesMessageContent);
        latitude = hTelegram.getDouble("latitude");
        longitude = hTelegram.getDouble("longitude");
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
     **/
    public double getLatitude(int decimals) {
        return roundValue(latitude, decimals);
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
     **/
    public double getLongitude(int decimals) {
        return roundValue(longitude, decimals);
    }

}
