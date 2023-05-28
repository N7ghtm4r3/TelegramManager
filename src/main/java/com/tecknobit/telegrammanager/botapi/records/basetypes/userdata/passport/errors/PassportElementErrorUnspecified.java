package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.unspecified;

public class PassportElementErrorUnspecified extends PassportSingleElementError {

    public PassportElementErrorUnspecified(PassportElementType type, String message, String fileHash) {
        super(unspecified, type, message, fileHash);
    }

    public PassportElementErrorUnspecified(JSONObject jPassportElementErrorUnspecified) {
        super(jPassportElementErrorUnspecified);
    }

    public static PassportElementErrorUnspecified getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorUnspecified(jItem);
    }

}
