package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.MediaStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PassportFile extends MediaStructure {

    private final long fileDate;

    /**
     * Constructor to init a {@link MediaStructure} object
     *
     * @param fileId       :       identifier for this file
     * @param fileUniqueId : unique identifier for this file
     * @param fileSize     :     file size in bytes
     */
    public PassportFile(String fileId, String fileUniqueId, int fileSize, long fileDate) {
        super(fileId, fileUniqueId, fileSize);
        this.fileDate = fileDate;
    }

    /**
     * Constructor to init a {@link MediaStructure} object
     *
     * @param jMediaStructure : media structure details as {@link JSONObject}
     */
    public PassportFile(JSONObject jMediaStructure) {
        super(jMediaStructure);
        fileDate = hTelegram.getLong("file_date");
    }

    public long getFileDate() {
        return fileDate;
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

    public static PassportFile getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportFile(jItem);
    }

}
