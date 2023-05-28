package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.file;

public class PassportElementErrorFile extends PassportSingleElementError {

    public PassportElementErrorFile(PassportElementType type, String message, String fileHash) {
        super(file, type, message, fileHash);
    }

    public PassportElementErrorFile(JSONObject jPassportElementErrorFile) {
        super(jPassportElementErrorFile);
    }

    public static PassportElementErrorSelfie getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorSelfie(jItem);
    }

}
