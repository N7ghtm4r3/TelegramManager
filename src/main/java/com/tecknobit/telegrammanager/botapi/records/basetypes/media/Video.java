package com.tecknobit.telegrammanager.botapi.records.basetypes.media;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code Video} class is useful to format a {@code Telegram}'s video
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#video">
 * Video</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MediaStructure
 * @see TelegramDocument
 */
public class Video extends TelegramDocument {

    /**
     * {@code width} video width as defined by sender
     */
    private final double width;

    /**
     * {@code height} video height as defined by sender
     */
    private final double height;

    /**
     * {@code duration} duration of the video in seconds as defined by sender
     */
    private final int duration;

    /**
     * Constructor to init a {@link Video} object
     *
     * @param fileId:       identifier for this file
     * @param fileUniqueId: unique identifier for this file
     * @param fileSize:     file size in bytes
     * @param fileName:     original filename as defined by sender
     * @param mimeType:     MIME type of the file as defined by sender
     * @param thumbnail:    document thumbnail as defined by sender
     * @param width:video   width as defined by sender
     * @param height:       video height as defined by sender
     * @param duration:     duration of the video in seconds as defined by sender
     */
    public Video(String fileId, String fileUniqueId, int fileSize, String fileName, String mimeType, double width,
                 double height, int duration, PhotoSize thumbnail) {
        super(fileId, fileUniqueId, fileSize, fileName, mimeType, thumbnail);
        this.width = width;
        this.height = height;
        this.duration = duration;
    }

    /**
     * Constructor to init a {@link Video} object
     *
     * @param jAnimation: video details as {@link JSONObject}
     */
    public Video(JSONObject jAnimation) {
        super(jAnimation);
        width = hTelegram.getDouble("width");
        height = hTelegram.getDouble("height");
        duration = hTelegram.getInt("duration");
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
     * Method to get {@link #height} instance <br>
     * No-any params required
     *
     * @return {@link #height} instance as double
     */
    public double getHeight() {
        return height;
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
     * @return instance as {@link Video}
     */
    public static Video getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Video(jItem);
    }

}
