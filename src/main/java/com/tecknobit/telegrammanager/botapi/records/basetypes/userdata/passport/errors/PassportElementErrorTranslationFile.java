package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.translation_file;

public class PassportElementErrorTranslationFile extends PassportSingleElementError {

    public PassportElementErrorTranslationFile(PassportElementType type, String message, String fileHash) {
        super(translation_file, type, message, fileHash);
    }

    public PassportElementErrorTranslationFile(JSONObject jPassportElementErrorTranslationFile) {
        super(jPassportElementErrorTranslationFile);
    }

    public static PassportElementErrorTranslationFile getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorTranslationFile(jItem);
    }

}
