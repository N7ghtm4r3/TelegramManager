package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.selfie;

public class PassportElementErrorSelfie extends PassportSingleElementError {

    public PassportElementErrorSelfie(PassportElementType type, String message, String fileHash) {
        super(selfie, type, message, fileHash);
    }

    public PassportElementErrorSelfie(JSONObject jPassportElementErrorSelfie) {
        super(jPassportElementErrorSelfie);
    }

    public static PassportElementErrorSelfie getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorSelfie(jItem);
    }

}
