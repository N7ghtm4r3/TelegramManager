package com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia;

import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia.InputMediaType.video;

/**
 * The {@code InputMediaVideo} class is useful to format a {@code Telegram}'s input media video
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputmediavideo">
 * InputMediaVideo</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputMedia
 * @see InputMediaPhoto
 * @see InputMediaAnimation
 */
public class InputMediaVideo extends InputMediaAnimation {

    /**
     * {@code supportsStreaming} if the uploaded video is suitable for streaming
     */
    private final boolean supportsStreaming;

    /**
     * Constructor to init a {@link InputMediaVideo} object
     *
     * @param media:             file to send
     * @param caption:           caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode:         mode for parsing entities in the photo caption
     * @param captionEntities:   list of special entities that appear in the caption, which can be specified instead of
     *                           {@link #parseMode}
     * @param hasSpoiler:        if the photo needs to be covered with a spoiler video
     * @param thumbnail:         thumbnail of the file sent
     * @param width:             video width
     * @param height:            video height
     * @param duration:          video duration in seconds
     * @param supportsStreaming: if the uploaded video is suitable for streaming
     */
    public InputMediaVideo(String media, String caption, String parseMode, ArrayList<MessageEntity> captionEntities,
                           boolean hasSpoiler, String thumbnail, double width, double height, int duration,
                           boolean supportsStreaming) {
        super(video, media, caption, parseMode, captionEntities, hasSpoiler, thumbnail, width, height, duration);
        this.supportsStreaming = supportsStreaming;
    }

    /**
     * Constructor to init a {@link InputMediaVideo} object
     *
     * @param jInputMediaVideo: input media video details as {@link JSONObject}
     */
    public InputMediaVideo(JSONObject jInputMediaVideo) {
        super(jInputMediaVideo);
        supportsStreaming = hTelegram.getBoolean("supports_streaming");
    }

    /**
     * Method to get {@link #supportsStreaming} instance <br>
     * No-any params required
     *
     * @return {@link #supportsStreaming} instance as boolean
     */
    public boolean supportsStreaming() {
        return supportsStreaming;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InputMediaVideo}
     */
    public static InputMediaVideo getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputMediaVideo(jItem);
    }

}
