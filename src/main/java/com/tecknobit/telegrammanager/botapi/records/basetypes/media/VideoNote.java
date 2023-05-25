package com.tecknobit.telegrammanager.botapi.records.basetypes.media;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code VideoNote} class is useful to format a {@code Telegram}'s video note
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#videonote">
 * VideoNote</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MediaStructure
 */
public class VideoNote extends MediaStructure {

    /**
     * {@code length} video width and height (diameter of the video message) as defined by sender
     */
    private final int length;

    /**
     * {@code duration} duration of the video in seconds as defined by sender
     */
    private final int duration;

    /**
     * {@code thumbnail} video thumbnail
     */
    private final PhotoSize thumbnail;

    /**
     * Constructor to init a {@link VideoNote} object
     *
     * @param fileId:       identifier for this file
     * @param fileUniqueId: unique identifier for this file
     * @param fileSize:     file size in bytes
     * @param length:       video width and height (diameter of the video message) as defined by sender
     * @param duration:     duration of the video in seconds as defined by sender
     * @param thumbnail:    video thumbnail
     */
    public VideoNote(String fileId, String fileUniqueId, int fileSize, int length, int duration, PhotoSize thumbnail) {
        super(fileId, fileUniqueId, fileSize);
        this.length = length;
        this.duration = duration;
        this.thumbnail = thumbnail;
    }

    /**
     * Constructor to init a {@link VideoNote} object
     *
     * @param jVideoNote: video note details as {@link JSONObject}
     */
    public VideoNote(JSONObject jVideoNote) {
        super(jVideoNote);
        length = hTelegram.getInt("length");
        duration = hTelegram.getInt("duration");
        thumbnail = PhotoSize.getInstance(hTelegram.getJSONObject("thumbnail"));
    }

    /**
     * Method to get {@link #length} instance <br>
     * No-any params required
     *
     * @return {@link #length} instance as int
     */
    public int getLength() {
        return length;
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
     * Method to get {@link #thumbnail} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnail} instance as {@link PhotoSize}
     */
    public PhotoSize getThumbnail() {
        return thumbnail;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link VideoNote}
     */
    public static VideoNote getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new VideoNote(jItem);
    }

}
