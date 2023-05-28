package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.files;

public class PassportElementErrorFiles extends PassportMultipleElementsError {

    public PassportElementErrorFiles(PassportElementType type, String message, ArrayList<String> fileHashes) {
        super(files, type, message, fileHashes);
    }

    public PassportElementErrorFiles(JSONObject jPassportElementErrorFiles) {
        super(jPassportElementErrorFiles);
    }

    public static PassportElementErrorFiles getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorFiles(jItem);
    }

}
