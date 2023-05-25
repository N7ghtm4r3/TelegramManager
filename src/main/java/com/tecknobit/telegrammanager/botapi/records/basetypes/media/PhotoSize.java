package com.tecknobit.telegrammanager.botapi.records.basetypes.media;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;

/**
 * The {@code PhotoSize} class is useful to format a {@code Telegram}'s photo size
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#photosize">
 * PhotoSize</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MediaStructure
 */
public class PhotoSize extends MediaStructure {

    /**
     * {@code width} photo width
     */
    private final double width;

    /**
     * {@code height} photo height
     */
    private final double height;

    /**
     * Constructor to init a {@link PhotoSize} object
     *
     * @param fileId       : identifier for this file
     * @param fileUniqueId : unique identifier for this file
     * @param fileSize     : file size in bytes
     * @param width        : photo width
     * @param height       :  photo height
     */
    public PhotoSize(String fileId, String fileUniqueId, int fileSize, double width, double height) {
        super(fileId, fileUniqueId, fileSize);
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to init a {@link PhotoSize} object
     *
     * @param jPhotoSize: photo size details as {@link JSONObject}
     */
    public PhotoSize(JSONObject jPhotoSize) {
        super(jPhotoSize);
        width = hTelegram.getDouble("width");
        height = hTelegram.getDouble("height");
    }

    /**
     * Method to get {@link #width} instance <br>
     * No-any params required
     *
     * @return {@link #width} instance as double
     */
    public double getWidth() {
        return width;
    }

    /**
     * Method to get {@link #width} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #width} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getWidth(int decimals) {
        return roundValue(width, decimals);
    }

    /**
     * Method to get {@link #height} instance <br>
     * No-any params required
     *
     * @return {@link #height} instance as double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Method to get {@link #height} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #height} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     **/
    public double getHeight(int decimals) {
        return roundValue(height, decimals);
    }

    /**
     * Method to return a {@link PhotoSize} list
     *
     * @param jPhotoSizes: JSON source from fetch the list
     * @return photo sizes list as {@link ArrayList} of {@link PhotoSize}
     */
    @Returner
    public static ArrayList<PhotoSize> returnPhotoSizes(JSONArray jPhotoSizes) {
        ArrayList<PhotoSize> photoSizes = new ArrayList<>();
        if (jPhotoSizes != null)
            for (int j = 0; j < jPhotoSizes.length(); j++)
                photoSizes.add(new PhotoSize(jPhotoSizes.getJSONObject(j)));
        return photoSizes;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PhotoSize}
     */
    public static PhotoSize getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PhotoSize(jItem);
    }

}
