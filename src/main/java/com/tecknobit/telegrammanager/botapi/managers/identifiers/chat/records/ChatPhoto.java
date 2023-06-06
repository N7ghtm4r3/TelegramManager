package com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ChatPhoto} class is useful to format a {@code Telegram}'s chat photo
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatphoto">
 * ChatPhoto</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ChatPhoto extends TelegramType {

    /**
     * {@code smallFileId} file identifier of small (160x160) chat photo. This file_id can be used only for photo download
     * and only for as long as the photo is not changed
     */
    private final String smallFileId;

    /**
     * {@code smallFileUniqueId} unique file identifier of small (160x160) chat photo, which is supposed to be the same
     * over time and for different bots. Can't be used to download or reuse the file
     */
    private final String smallFileUniqueId;

    /**
     * {@code bigFileId} file identifier of big (640x640) chat photo. This file_id can be used only for photo download
     * and only for as long as the photo is not changed
     */
    private final String bigFileId;

    /**
     * {@code bigFileUniqueId} unique file identifier of big (640x640) chat photo, which is supposed to be the same over
     * time and for different bots. Can't be used to download or reuse the file
     */
    private final String bigFileUniqueId;

    /**
     * Constructor to init a {@link ChatPhoto} object
     *
     * @param smallFileId:       file identifier of small (160x160) chat photo. This file_id can be used only for photo
     *                           download and only for as long as the photo is not changed
     * @param smallFileUniqueId: unique file identifier of small (160x160) chat photo, which is supposed to be the same
     *                           over time and for different bots. Can't be used to download or reuse the file
     * @param bigFileId:         file identifier of big (640x640) chat photo. This file_id can be used only for photo download
     *                           and only for as long as the photo is not changed
     * @param bigFileUniqueId:   unique file identifier of big (640x640) chat photo, which is supposed to be the same over
     *                           time and for different bots. Can't be used to download or reuse the file
     */
    public ChatPhoto(String smallFileId, String smallFileUniqueId, String bigFileId, String bigFileUniqueId) {
        super(null);
        this.smallFileId = smallFileId;
        this.smallFileUniqueId = smallFileUniqueId;
        this.bigFileId = bigFileId;
        this.bigFileUniqueId = bigFileUniqueId;
    }

    /**
     * Constructor to init a {@link ChatPhoto} object
     *
     * @param jChatPhoto: chat photo details as {@link JSONObject}
     */
    public ChatPhoto(JSONObject jChatPhoto) {
        super(jChatPhoto);
        smallFileId = hTelegram.getString("small_file_id");
        smallFileUniqueId = hTelegram.getString("small_file_unique_id");
        bigFileId = hTelegram.getString("big_file_id");
        bigFileUniqueId = hTelegram.getString("big_file_unique_id");
    }

    /**
     * Method to get {@link #smallFileId} instance <br>
     * No-any params required
     *
     * @return {@link #smallFileId} instance as {@link String}
     */
    public String getSmallFileId() {
        return smallFileId;
    }

    /**
     * Method to get {@link #smallFileUniqueId} instance <br>
     * No-any params required
     *
     * @return {@link #smallFileUniqueId} instance as {@link String}
     */
    public String getSmallFileUniqueId() {
        return smallFileUniqueId;
    }

    /**
     * Method to get {@link #bigFileId} instance <br>
     * No-any params required
     *
     * @return {@link #bigFileId} instance as {@link String}
     */
    public String getBigFileId() {
        return bigFileId;
    }

    /**
     * Method to get {@link #bigFileUniqueId} instance <br>
     * No-any params required
     *
     * @return {@link #bigFileUniqueId} instance as {@link String}
     */
    public String getBigFileUniqueId() {
        return bigFileUniqueId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatPhoto}
     */
    public static ChatPhoto getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatPhoto(jItem);
    }

}
