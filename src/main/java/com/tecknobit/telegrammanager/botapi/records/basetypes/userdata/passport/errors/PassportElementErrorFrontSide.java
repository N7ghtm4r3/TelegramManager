package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.front_side;

public class PassportElementErrorFrontSide extends PassportSingleElementError {

    public PassportElementErrorFrontSide(PassportElementType type, String message, String fileHash) {
        super(front_side, type, message, fileHash);
    }

    public PassportElementErrorFrontSide(JSONObject jPassportElementErrorFrontSide) {
        super(jPassportElementErrorFrontSide);
    }

    public static PassportElementErrorFrontSide getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorFrontSide(jItem);
    }

}
