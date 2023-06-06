package com.tecknobit.telegrammanager.botapi.managers.passport.records.errors;

import com.tecknobit.telegrammanager.botapi.managers.passport.records.EncryptedPassportElement.PassportElementType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.managers.passport.records.errors.PassportElementError.ErrorSource.translation_files;

/**
 * The {@code PassportElementErrorTranslationFiles} class is useful to format a {@code Telegram}'s passport element error translation files
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportelementerrortranslationfiles">
 * PassportElementErrorTranslationFiles</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportMultipleElementsError
 * @see PassportMultipleElementsError
 */
public class PassportElementErrorTranslationFiles extends PassportMultipleElementsError {

    /**
     * Constructor to init a {@link PassportElementErrorTranslationFiles} object
     *
     * @param type:       type of element of the user's Telegram Passport which has the issue
     * @param message:    error message
     * @param fileHashes: list of base64-encoded file hashes
     */
    public PassportElementErrorTranslationFiles(PassportElementType type, String message, ArrayList<String> fileHashes) {
        super(translation_files, type, message, fileHashes);
    }

    /**
     * Constructor to init a {@link PassportElementErrorTranslationFiles} object
     *
     * @param jPassportElementErrorTranslationFiles: passport element error translation files details as {@link JSONObject}
     */
    public PassportElementErrorTranslationFiles(JSONObject jPassportElementErrorTranslationFiles) {
        super(jPassportElementErrorTranslationFiles);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportElementErrorTranslationFiles}
     */
    public static PassportElementErrorTranslationFiles getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorTranslationFiles(jItem);
    }

}
