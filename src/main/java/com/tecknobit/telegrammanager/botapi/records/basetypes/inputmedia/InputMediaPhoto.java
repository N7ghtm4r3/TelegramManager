package com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia;

import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia.InputMediaType.photo;

/**
 * The {@code InputMediaPhoto} class is useful to format a {@code Telegram}'s input media photo
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputmediaphoto">
 * InputMediaPhoto</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputMedia
 */
public class InputMediaPhoto extends InputMedia {

    /**
     * {@code hasSpoiler} if the photo needs to be covered with a spoiler animation
     */
    protected final boolean hasSpoiler;

    /**
     * Constructor to init a {@link InputMediaPhoto} object
     *
     * @param media:           file to send
     * @param caption:         caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode:       mode for parsing entities in the photo caption
     * @param captionEntities: list of special entities that appear in the caption, which can be specified instead of
     *                         {@link #parseMode}
     * @param hasSpoiler:      if the photo needs to be covered with a spoiler animation
     */
    public InputMediaPhoto(String media, String caption, String parseMode, ArrayList<MessageEntity> captionEntities,
                           boolean hasSpoiler) {
        this(photo, media, parseMode, caption, captionEntities, hasSpoiler);
    }

    /**
     * Constructor to init a {@link InputMediaPhoto} object
     *
     * @param type:            type of the result
     * @param media:           file to send
     * @param caption:         caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode:       mode for parsing entities in the photo caption
     * @param captionEntities: list of special entities that appear in the caption, which can be specified instead of
     *                         {@link #parseMode}
     * @param hasSpoiler:      {@code hasSpoiler}
     */
    public InputMediaPhoto(InputMediaType type, String media, String caption, String parseMode,
                           ArrayList<MessageEntity> captionEntities, boolean hasSpoiler) {
        super(type, media, caption, parseMode, captionEntities);
        this.hasSpoiler = hasSpoiler;
    }

    /**
     * Constructor to init a {@link InputMediaPhoto} object
     *
     * @param jInputMediaPhoto: input media photo details as {@link JSONObject}
     */
    public InputMediaPhoto(JSONObject jInputMediaPhoto) {
        super(jInputMediaPhoto);
        hasSpoiler = hTelegram.getBoolean("has_spoiler");
    }

    /**
     * Method to get {@link #hasSpoiler} instance <br>
     * No-any params required
     *
     * @return {@link #hasSpoiler} instance as boolean
     */
    public boolean hasSpoiler() {
        return hasSpoiler;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InputMediaPhoto}
     */
    public static InputMediaPhoto getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputMediaPhoto(jItem);
    }

}
