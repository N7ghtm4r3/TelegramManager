package com.tecknobit.telegrammanager.botapi.records.basetypes.media;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code Voice} class is useful to format a {@code Telegram}'s voice
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#voice">
 * Voice</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MediaStructure
 */
public class Voice extends MediaStructure {

    /**
     * {@code duration} duration of the audio in seconds as defined by sender
     */
    private final int duration;

    /**
     * {@code mimeType} MIME type of the file as defined by sender
     */
    private final String mimeType;

    /**
     * Constructor to init a {@link Voice} object
     *
     * @param fileId:       identifier for this file
     * @param fileUniqueId: unique identifier for this file
     * @param fileSize:     file size in bytes
     * @param duration:     duration of the audio in seconds as defined by sender
     * @param mimeType:     MIME type of the file as defined by sender
     */
    public Voice(String fileId, String fileUniqueId, int fileSize, int duration, String mimeType) {
        super(fileId, fileUniqueId, fileSize);
        this.duration = duration;
        this.mimeType = mimeType;
    }

    /**
     * Constructor to init a {@link Voice} object
     *
     * @param jVoice: voice details as {@link JSONObject}
     */
    public Voice(JSONObject jVoice) {
        super(jVoice);
        duration = hTelegram.getInt("duration");
        mimeType = hTelegram.getString("mime_type");
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
     * Method to get {@link #mimeType} instance <br>
     * No-any params required
     *
     * @return {@link #mimeType} instance as {@link String}
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Voice}
     */
    public static Voice getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Voice(jItem);
    }

}
