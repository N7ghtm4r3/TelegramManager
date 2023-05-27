package com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code MaskPosition} class is useful to format a {@code Telegram}'s mask position
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#maskposition">
 * MaskPosition</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class MaskPosition extends TelegramType {

    /**
     * {@code MaskPositionPoint} list of available mask position points
     */
    public enum MaskPositionPoint {

        /**
         * {@code forehead} mask position point
         */
        forehead,

        /**
         * {@code eyes} mask position point
         */
        eyes,

        /**
         * {@code mouth} mask position point
         */
        mouth,

        /**
         * {@code chin} mask position point
         */
        chin

    }

    /**
     * {@code point} the part of the face relative to which the mask should be placed
     */
    private final MaskPositionPoint point;

    /**
     * {@code xShift} shift by X-axis measured in widths of the mask scaled to the face size, from left to right
     */
    private final double xShift;

    /**
     * {@code yShift} shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom
     */
    private final double yShift;

    /**
     * {@code scale} mask scaling coefficient
     */
    private final double scale;

    /**
     * Constructor to init a {@link MaskPosition} object
     *
     * @param point:  the part of the face relative to which the mask should be placed
     * @param xShift: shift by X-axis measured in widths of the mask scaled to the face size, from left to right
     * @param yShift: shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom
     * @param scale:  mask scaling coefficient
     */
    public MaskPosition(MaskPositionPoint point, double xShift, double yShift, double scale) {
        super(null);
        this.point = point;
        this.xShift = xShift;
        this.yShift = yShift;
        this.scale = scale;
    }

    /**
     * Constructor to init a {@link MaskPosition} object
     *
     * @param jMaskPosition: mask position details as {@link JSONObject}
     */
    public MaskPosition(JSONObject jMaskPosition) {
        super(jMaskPosition);
        point = MaskPositionPoint.valueOf(hTelegram.getString("point"));
        xShift = hTelegram.getDouble("x_shift");
        yShift = hTelegram.getDouble("y_shift");
        scale = hTelegram.getDouble("scale");
    }

    /**
     * Method to get {@link #point} instance <br>
     * No-any params required
     *
     * @return {@link #point} instance as {@link MaskPositionPoint}
     */
    public MaskPositionPoint getPoint() {
        return point;
    }

    /**
     * Method to get {@link #xShift} instance <br>
     * No-any params required
     *
     * @return {@link #xShift} instance as double
     */
    public double getxShift() {
        return xShift;
    }

    /**
     * Method to get {@link #xShift} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #xShift} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getxShift(int decimals) {
        return xShift;
    }

    /**
     * Method to get {@link #yShift} instance <br>
     * No-any params required
     *
     * @return {@link #yShift} instance as double
     */
    public double getyShift() {
        return yShift;
    }

    /**
     * Method to get {@link #xShift} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #xShift} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getyShift(int decimals) {
        return roundValue(yShift, decimals);
    }

    /**
     * Method to get {@link #scale} instance <br>
     * No-any params required
     *
     * @return {@link #scale} instance as double
     */
    public double getScale() {
        return scale;
    }

    /**
     * Method to get {@link #scale} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #scale} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getScale(int decimals) {
        return roundValue(scale, decimals);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link MaskPosition}
     */
    public static MaskPosition getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new MaskPosition(jItem);
    }

}
