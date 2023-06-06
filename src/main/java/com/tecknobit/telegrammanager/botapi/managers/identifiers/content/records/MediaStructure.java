package com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code MediaStructure} class is useful to format a {@code Telegram}'s media structure
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#photosize">
 *             PhotoSize</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#audio">
 *             Audio</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#document">
 *             Document</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#video">
 *             Video</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#videonote">
 *             VideoNote</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#voice">
 *             Voice</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#sticker">
 *             Sticker</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
@Structure
public abstract class MediaStructure extends TelegramType {

    /**
     * {@code fileId} identifier for this file
     */
    protected final String fileId;

    /**
     * {@code fileUniqueId} unique identifier for this file
     */
    protected final String fileUniqueId;

    /**
     * {@code fileSize} file size in bytes
     */
    protected final int fileSize;

    /**
     * Constructor to init a {@link MediaStructure} object
     *
     * @param fileId:       identifier for this file
     * @param fileUniqueId: unique identifier for this file
     * @param fileSize:     file size in bytes
     */
    public MediaStructure(String fileId, String fileUniqueId, int fileSize) {
        super(null);
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.fileSize = fileSize;
    }

    /**
     * Constructor to init a {@link MediaStructure} object
     *
     * @param jMediaStructure: media structure details as {@link JSONObject}
     */
    public MediaStructure(JSONObject jMediaStructure) {
        super(jMediaStructure);
        fileId = hTelegram.getString("file_id");
        fileUniqueId = hTelegram.getString("file_unique_id");
        fileSize = hTelegram.getInt("file_size", 0);
    }

    /**
     * Method to get {@link #fileId} instance <br>
     * No-any params required
     *
     * @return {@link #fileId} instance as {@link String}
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * Method to get {@link #fileUniqueId} instance <br>
     * No-any params required
     *
     * @return {@link #fileUniqueId} instance as {@link String}
     */
    public String getFileUniqueId() {
        return fileUniqueId;
    }

    /**
     * Method to get {@link #fileSize} instance <br>
     * No-any params required
     *
     * @return {@link #fileSize} instance as int
     */
    public int getFileSize() {
        return fileSize;
    }

}
