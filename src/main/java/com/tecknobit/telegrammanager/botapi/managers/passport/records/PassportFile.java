package com.tecknobit.telegrammanager.botapi.managers.passport.records;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.MediaStructure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * The {@code PassportFile} class is useful to format a {@code Telegram}'s passport file
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportfile">
 * PassportFile</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MediaStructure
 */
public class PassportFile extends MediaStructure {

    /**
     * {@code fileDate} unix time when the file was uploaded
     */
    private final long fileDate;

    /**
     * Constructor to init a {@link PassportFile} object
     *
     * @param fileId       :       identifier for this file
     * @param fileUniqueId : unique identifier for this file
     * @param fileSize     :     file size in bytes
     * @param fileDate:    unix time when the file was uploaded
     */
    public PassportFile(String fileId, String fileUniqueId, int fileSize, long fileDate) {
        super(fileId, fileUniqueId, fileSize);
        this.fileDate = fileDate;
    }

    /**
     * Constructor to init a {@link PassportFile} object
     *
     * @param jPassportFile : passport file as {@link JSONObject}
     */
    public PassportFile(JSONObject jPassportFile) {
        super(jPassportFile);
        fileDate = hTelegram.getLong("file_date");
    }

    /**
     * Method to get {@link #fileDate} instance <br>
     * No-any params required
     *
     * @return {@link #fileDate} instance as long
     */
    public long getFileDateTimestamp() {
        return fileDate;
    }

    /**
     * Method to get {@link #fileDate} instance <br>
     * No-any params required
     *
     * @return {@link #fileDate} instance as {@link Date}
     */
    public Date getFileDate() {
        return new Date(fileDate);
    }

    /**
     * Method to return a {@link PassportFile} list
     *
     * @param jPassportFiles : JSON source from fetch the list
     * @return passport files list as {@link ArrayList} of {@link PassportFile}
     */
    @Returner
    public static ArrayList<PassportFile> returnPassportFiles(JSONArray jPassportFiles) {
        ArrayList<PassportFile> passportFiles = new ArrayList<>();
        if (jPassportFiles != null)
            for (int j = 0; j < jPassportFiles.length(); j++)
                passportFiles.add(new PassportFile(jPassportFiles.getJSONObject(j)));
        return passportFiles;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportFile}
     */
    public static PassportFile getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportFile(jItem);
    }

}
