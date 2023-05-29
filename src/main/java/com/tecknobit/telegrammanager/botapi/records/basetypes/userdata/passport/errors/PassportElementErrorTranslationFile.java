package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.translation_file;

/**
 * The {@code PassportElementErrorTranslationFile} class is useful to format a {@code Telegram}'s passport element error translation file
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportelementerrortranslationfile">
 * PassportElementErrorTranslationFile</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 * @see PassportSingleElementError
 */
public class PassportElementErrorTranslationFile extends PassportSingleElementError {

    /**
     * Constructor to init a {@link PassportElementErrorTranslationFile} object
     *
     * @param type:     type of element of the user's Telegram Passport which has the issue
     * @param message:  error message
     * @param fileHash: base64-encoded value of the hash
     */
    public PassportElementErrorTranslationFile(PassportElementType type, String message, String fileHash) {
        super(translation_file, type, message, fileHash);
    }

    /**
     * Constructor to init a {@link PassportElementErrorTranslationFile} object
     *
     * @param jPassportElementErrorTranslationFile: passport element error translation file detains as {@link JSONObject}
     */
    public PassportElementErrorTranslationFile(JSONObject jPassportElementErrorTranslationFile) {
        super(jPassportElementErrorTranslationFile);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportElementErrorTranslationFile}
     */
    public static PassportElementErrorTranslationFile getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorTranslationFile(jItem);
    }

}
