package com.tecknobit.telegrammanager.botapi.records.basetypes.media;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code TelegramDocument} class is useful to format a {@code Telegram}'s document
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#document">
 * Document</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MediaStructure
 */
public class TelegramDocument extends MediaStructure {

    /**
     * {@code fileName} original filename as defined by sender
     */
    protected final String fileName;

    /**
     * {@code mimeType} MIME type of the file as defined by sender
     */
    protected final String mimeType;

    /**
     * {@code thumbnail} document thumbnail as defined by sender
     */
    protected final PhotoSize thumbnail;

    /**
     * Constructor to init a {@link TelegramDocument} object
     *
     * @param fileId:       identifier for this file
     * @param fileUniqueId: unique identifier for this file
     * @param fileSize:     file size in bytes
     * @param fileName:     original filename as defined by sender
     * @param mimeType:     MIME type of the file as defined by sender
     * @param thumbnail:    document thumbnail as defined by sender
     */
    public TelegramDocument(String fileId, String fileUniqueId, int fileSize, String fileName, String mimeType,
                            PhotoSize thumbnail) {
        super(fileId, fileUniqueId, fileSize);
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.thumbnail = thumbnail;
    }

    /**
     * Constructor to init a {@link TelegramDocument} object
     *
     * @param jMediaFileStructure: document details as {@link JSONObject}
     */
    public TelegramDocument(JSONObject jMediaFileStructure) {
        super(jMediaFileStructure);
        fileName = hTelegram.getString("file_name");
        mimeType = hTelegram.getString("mime_type");
        thumbnail = PhotoSize.getInstance(hTelegram.getJSONObject("thumbnail"));
    }

    /**
     * Method to get {@link #fileName} instance <br>
     * No-any params required
     *
     * @return {@link #fileName} instance as {@link String}
     */
    public String getFileName() {
        return fileName;
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
     * @return instance as {@link TelegramDocument}
     */
    public static TelegramDocument getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new TelegramDocument(jItem);
    }

}
