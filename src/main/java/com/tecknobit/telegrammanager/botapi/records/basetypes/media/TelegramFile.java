package com.tecknobit.telegrammanager.botapi.records.basetypes.media;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code TelegramFile} class is useful to format a {@code Telegram}'s file
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#file">
 * https://core.telegram.org/bots/api#file</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class TelegramFile extends MediaStructure {

    /**
     * {@code filePath} file path
     *
     * @apiNote use {@code "https://api.telegram.org/file/bot<token>/<file_path>"} to get the file
     */
    private final String filePath;

    /**
     * Constructor to init a {@link TelegramFile} object
     *
     * @param fileId:       identifier for this file
     * @param fileUniqueId: unique identifier for this file
     * @param fileSize:     file size in bytes
     * @param filePath:     file path
     */
    public TelegramFile(String fileId, String fileUniqueId, int fileSize, String filePath) {
        super(fileId, fileUniqueId, fileSize);
        this.filePath = filePath;
    }

    /**
     * Constructor to init a {@link TelegramFile} object
     *
     * @param jTelegramFile: file details as {@link JSONObject}
     */
    public TelegramFile(JSONObject jTelegramFile) {
        super(jTelegramFile);
        filePath = hTelegram.getString("file_path");
    }

    /**
     * Method to get {@link #filePath} instance <br>
     * No-any params required
     *
     * @return {@link #filePath} instance as {@link String}
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Method to create a file
     *
     * @param fileResponse : obtained from Telegram's response
     * @param format       :       return type formatter -> {@link ReturnFormat}
     * @return file as {@code "format"} defines
     */
    @Returner
    public static <T> T returnFile(String fileResponse, ReturnFormat format) {
        return switch (format) {
            case JSON -> (T) new JSONObject(fileResponse);
            case LIBRARY_OBJECT -> (T) new TelegramFile(new JSONObject(fileResponse));
            default -> (T) fileResponse;
        };
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link TelegramFile}
     */
    public static TelegramFile getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new TelegramFile(jItem);
    }

}
