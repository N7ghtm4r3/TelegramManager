package com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code InputMedia} class is useful to format a {@code Telegram}'s input media
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inputmediaphoto">
 *             InputMediaPhoto</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inputmediavideo">
 *             InputMediaVideo</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inputmediaanimation">
 *             InputMediaAnimation</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inputmediaaudio">
 *             InputMediaAudio</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inputmediadocument">
 *             InputMediaDocument</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
@Structure
public abstract class InputMedia extends TelegramType {

    /**
     * {@code InputMediaType} list of available input media types
     */
    public enum InputMediaType {

        /**
         * {@code photo} input media type
         */
        photo,

        /**
         * {@code video} input media type
         */
        video,

        /**
         * {@code animation} input media type
         */
        animation,

        /**
         * {@code audio} input media type
         */
        audio,

        /**
         * {@code document} input media type
         */
        document

    }

    /**
     * {@code type} of the result
     */
    protected final InputMediaType type;

    /**
     * {@code media} file to send
     */
    protected final String media;

    /**
     * {@code caption} of the photo to be sent, 0-1024 characters after entities parsing
     */
    protected final String caption;

    /**
     * {@code parseMode} mode for parsing entities in the photo caption
     */
    protected final String parseMode;

    /**
     * {@code captionEntities} list of special entities that appear in the caption, which can be specified instead of
     * {@link #parseMode}
     */
    protected final ArrayList<MessageEntity> captionEntities;

    /**
     * Constructor to init a {@link InputMedia} object
     *
     * @param type:            type of the result
     * @param media:           file to send
     * @param caption:         caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode:       mode for parsing entities in the photo caption
     * @param captionEntities: list of special entities that appear in the caption, which can be specified instead of
     *                         {@link #parseMode}
     */
    public InputMedia(InputMediaType type, String media, String caption, String parseMode,
                      ArrayList<MessageEntity> captionEntities) {
        super(null);
        this.type = type;
        this.media = media;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
    }

    /**
     * Constructor to init a {@link InputMedia} object
     *
     * @param jInputMedia: input media details as {@link JSONObject}
     */
    public InputMedia(JSONObject jInputMedia) {
        super(jInputMedia);
        type = InputMediaType.valueOf(hTelegram.getString("type"));
        media = hTelegram.getString("media");
        caption = hTelegram.getString("caption");
        parseMode = hTelegram.getString("parse_mode");
        captionEntities = MessageEntity.returnMessageEntities(hTelegram.getJSONArray("caption_entities"));
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link InputMediaType}
     */
    public InputMediaType getType() {
        return type;
    }

    /**
     * Method to get {@link #media} instance <br>
     * No-any params required
     *
     * @return {@link #media} instance as {@link String}
     */
    public String getMedia() {
        return media;
    }

    /**
     * Method to get {@link #caption} instance <br>
     * No-any params required
     *
     * @return {@link #caption} instance as {@link String}
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Method to get {@link #parseMode} instance <br>
     * No-any params required
     *
     * @return {@link #parseMode} instance as {@link String}
     */
    public String getParseMode() {
        return parseMode;
    }

    /**
     * Method to get {@link #captionEntities} instance <br>
     * No-any params required
     *
     * @return {@link #captionEntities} instance as {@link ArrayList} of {@link MessageEntity}
     */
    public ArrayList<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

}
