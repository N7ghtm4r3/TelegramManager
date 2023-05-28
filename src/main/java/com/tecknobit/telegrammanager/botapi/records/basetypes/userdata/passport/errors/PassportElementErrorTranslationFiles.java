package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.translation_files;

public class PassportElementErrorTranslationFiles extends PassportMultipleElementsError {

    public PassportElementErrorTranslationFiles(PassportElementType type, String message, ArrayList<String> fileHashes) {
        super(translation_files, type, message, fileHashes);
    }

    public PassportElementErrorTranslationFiles(JSONObject jPassportElementErrorTranslationFiles) {
        super(jPassportElementErrorTranslationFiles);
    }

    public static PassportElementErrorTranslationFiles getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorTranslationFiles(jItem);
    }

}
