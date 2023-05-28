package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.reverse_side;

public class PassportElementErrorReverseSide extends PassportSingleElementError {

    public PassportElementErrorReverseSide(PassportElementType type, String message, String fileHash) {
        super(reverse_side, type, message, fileHash);
    }

    public PassportElementErrorReverseSide(JSONObject jPassportElementErrorReverseSide) {
        super(jPassportElementErrorReverseSide);
    }

    public static PassportElementErrorReverseSide getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorReverseSide(jItem);
    }

}
