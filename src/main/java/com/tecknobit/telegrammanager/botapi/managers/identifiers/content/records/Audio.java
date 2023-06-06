package com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code Audio} class is useful to format a {@code Telegram}'s audio
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#audio">
 * Audio</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MediaStructure
 * @see TelegramDocument
 */
public class Audio extends TelegramDocument {

    /**
     * {@code duration} duration of the audio in seconds as defined by sender
     */
    private final int duration;

    /**
     * {@code performer} performer of the audio as defined by sender or by audio tags
     */
    private final String performer;

    /**
     * {@code title} title of the audio as defined by sender or by audio tags
     */
    private final String title;

    /**
     * Constructor to init a {@link Audio} object
     *
     * @param fileId:       identifier for this file
     * @param fileUniqueId: unique identifier for this file
     * @param fileSize:     file size in bytes
     * @param fileName:     original filename as defined by sender
     * @param mimeType:     MIME type of the file as defined by sender
     * @param thumbnail:    document thumbnail as defined by sender
     * @param duration:     duration of the audio in seconds as defined by sender
     * @param performer:    performer of the audio as defined by sender or by audio tags
     * @param title:        title of the audio as defined by sender or by audio tags
     */
    public Audio(String fileId, String fileUniqueId, int fileSize, String fileName, String mimeType, int duration,
                 String performer, String title, PhotoSize thumbnail) {
        super(fileId, fileUniqueId, fileSize, fileName, mimeType, thumbnail);
        this.duration = duration;
        this.performer = performer;
        this.title = title;
    }

    /**
     * Constructor to init a {@link Audio} object
     *
     * @param jAudio: audio details as {@link JSONObject}
     */
    public Audio(JSONObject jAudio) {
        super(jAudio);
        duration = hTelegram.getInt("duration", 0);
        performer = hTelegram.getString("performer");
        title = hTelegram.getString("title");
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
     * Method to get {@link #performer} instance <br>
     * No-any params required
     *
     * @return {@link #performer} instance as {@link String}
     */
    public String getPerformer() {
        return performer;
    }

    /**
     * Method to get {@link #title} instance <br>
     * No-any params required
     *
     * @return {@link #title} instance as {@link String}
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Audio}
     */
    public static Audio getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Audio(jItem);
    }

}
