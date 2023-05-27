package com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia;

import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia.InputMediaType.document;

/**
 * The {@code InputMediaDocument} class is useful to format a {@code Telegram}'s input media document
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputmediadocument">
 * InputMediaDocument</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputMedia
 */
public class InputMediaDocument extends InputMedia {

    /**
     * {@code thumbnail} of the file sent
     */
    private final String thumbnail;

    /**
     * {@code disableContentTypeDetection} disables automatic server-side content type detection for files uploaded
     * using multipart/form-data
     */
    private final boolean disableContentTypeDetection;

    /**
     * Constructor to init a {@link InputMediaDocument} object
     *
     * @param media:                       file to send
     * @param caption:                     caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode:                   mode for parsing entities in the photo caption
     * @param captionEntities:             list of special entities that appear in the caption, which can be specified instead of
     *                                     {@link #parseMode}
     * @param thumbnail:                   thumbnail of the file sent
     * @param disableContentTypeDetection: disables automatic server-side content type detection for files uploaded
     *                                     using multipart/form-data
     */
    public InputMediaDocument(String media, String caption, String parseMode, ArrayList<MessageEntity> captionEntities,
                              String thumbnail, boolean disableContentTypeDetection) {
        super(document, media, caption, parseMode, captionEntities);
        this.thumbnail = thumbnail;
        this.disableContentTypeDetection = disableContentTypeDetection;
    }

    /**
     * Constructor to init a {@link InputMediaDocument} object
     *
     * @param jInputMediaDocument: input media document details as {@link JSONObject}
     */
    public InputMediaDocument(JSONObject jInputMediaDocument) {
        super(jInputMediaDocument);
        thumbnail = hTelegram.getString("thumbnail");
        disableContentTypeDetection = hTelegram.getBoolean("disable_content_type_detection");
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
     * Method to get {@link #disableContentTypeDetection} instance <br>
     * No-any params required
     *
     * @return {@link #disableContentTypeDetection} instance as boolean
     */
    public boolean disableContentTypeDetection() {
        return disableContentTypeDetection;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InputMediaDocument}
     */
    public static InputMediaDocument getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputMediaDocument(jItem);
    }

}
