package com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia;

import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia.InputMediaType.audio;

/**
 * The {@code InputMediaAudio} class is useful to format a {@code Telegram}'s input media audio
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputmediaaudio">
 * InputMediaAudio</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputMedia
 */
public class InputMediaAudio extends InputMedia {

    /**
     * {@code thumbnail} of the file sent
     */
    private final String thumbnail;

    /**
     * {@code duration} of the audio in seconds
     */
    private final int duration;

    /**
     * {@code performer} of the audio
     */
    private final String performer;

    /**
     * {@code title} of the audio
     */
    private final String title;

    /**
     * Constructor to init a {@link InputMediaAudio} object
     *
     * @param media:           file to send
     * @param caption:         caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode:       mode for parsing entities in the photo caption
     * @param captionEntities: list of special entities that appear in the caption, which can be specified instead of
     *                         {@link #parseMode}
     * @param thumbnail:       thumbnail of the file sent
     * @param duration:        duration of the audio in seconds
     * @param performer:       performer of the audio
     * @param title:           title of the audio
     */
    public InputMediaAudio(String media, String caption, String parseMode, ArrayList<MessageEntity> captionEntities,
                           String thumbnail, int duration, String performer, String title) {
        super(audio, media, caption, parseMode, captionEntities);
        this.thumbnail = thumbnail;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
    }

    /**
     * Constructor to init a {@link InputMediaAudio} object
     *
     * @param jInputMediaAudio: input media audio details as {@link JSONObject}
     */
    public InputMediaAudio(JSONObject jInputMediaAudio) {
        super(jInputMediaAudio);
        thumbnail = hTelegram.getString("thumbnail");
        duration = hTelegram.getInt("duration");
        performer = hTelegram.getString("performer");
        title = hTelegram.getString("title");
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
     * @return instance as {@link InputMediaAudio}
     */
    public static InputMediaAudio getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputMediaAudio(jItem);
    }

}
