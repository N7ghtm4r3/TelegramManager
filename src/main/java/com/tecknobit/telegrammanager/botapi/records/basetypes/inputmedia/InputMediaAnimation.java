package com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia;

import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia.InputMediaType.animation;

/**
 * The {@code InputMediaAnimation} class is useful to format a {@code Telegram}'s input media animation
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputmediaanimation">
 * InputMediaAnimation</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputMedia
 * @see InputMediaPhoto
 */
public class InputMediaAnimation extends InputMediaPhoto {

    /**
     * {@code thumbnail} of the file sent
     */
    protected final String thumbnail;

    /**
     * {@code width} animation width
     */
    protected final double width;

    /**
     * {@code height} animation height
     */
    protected final double height;

    /**
     * {@code duration} animation duration in seconds
     */
    protected final int duration;

    /**
     * Constructor to init a {@link InputMediaAnimation} object
     *
     * @param media:           file to send
     * @param caption:         caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode:       mode for parsing entities in the photo caption
     * @param captionEntities: list of special entities that appear in the caption, which can be specified instead of
     *                         {@link #parseMode}
     * @param hasSpoiler:      if the photo needs to be covered with a spoiler animation
     * @param thumbnail:       thumbnail of the file sent
     * @param width:           animation width
     * @param height:          animation height
     * @param duration:        animation duration in seconds
     */
    public InputMediaAnimation(String media, String caption, String parseMode, ArrayList<MessageEntity> captionEntities,
                               boolean hasSpoiler, String thumbnail, double width, double height, int duration) {
        this(animation, media, caption, parseMode, captionEntities, hasSpoiler, thumbnail, width, height, duration);
    }

    /**
     * Constructor to init a {@link InputMediaAnimation} object
     *
     * @param media:           file to send
     * @param caption:         caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode:       mode for parsing entities in the photo caption
     * @param captionEntities: list of special entities that appear in the caption, which can be specified instead of
     *                         {@link #parseMode}
     * @param hasSpoiler:      if the photo needs to be covered with a spoiler animation
     * @param thumbnail:       thumbnail of the file sent
     * @param width:           animation width
     * @param height:          animation height
     * @param duration:        animation duration in seconds
     */
    public InputMediaAnimation(InputMediaType type, String media, String caption, String parseMode,
                               ArrayList<MessageEntity> captionEntities, boolean hasSpoiler, String thumbnail,
                               double width, double height, int duration) {
        super(type, media, caption, parseMode, captionEntities, hasSpoiler);
        this.thumbnail = thumbnail;
        this.width = width;
        this.height = height;
        this.duration = duration;
    }

    /**
     * Constructor to init a {@link InputMediaAnimation} object
     *
     * @param jInputMediaAnimation: input media animation details as {@link JSONObject}
     */
    public InputMediaAnimation(JSONObject jInputMediaAnimation) {
        super(jInputMediaAnimation);
        thumbnail = hTelegram.getString("thumbnail");
        width = hTelegram.getDouble("width");
        height = hTelegram.getDouble("height");
        duration = hTelegram.getInt("duration");
    }

    /**
     * Method to get {@link #thumbnail} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnail} instance as {@link String}
     */
    public String getThumbnail() {
        return thumbnail;
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
     */
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
     */
    public double getHeight(int decimals) {
        return roundValue(height, decimals);
    }

    /**
     * Method to get {@link #duration} instance <br>
     * No-any params required
     *
     * @return {@link #duration} instance as int
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InputMediaAnimation}
     */
    public static InputMediaAnimation getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputMediaAnimation(jItem);
    }

}
