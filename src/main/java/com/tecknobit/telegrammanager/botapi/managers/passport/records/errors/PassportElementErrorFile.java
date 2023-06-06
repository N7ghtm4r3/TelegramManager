package com.tecknobit.telegrammanager.botapi.managers.passport.records.errors;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.managers.passport.records.EncryptedPassportElement.PassportElementType;
import static com.tecknobit.telegrammanager.botapi.managers.passport.records.errors.PassportElementError.ErrorSource.file;

/**
 * The {@code PassportElementErrorFile} class is useful to format a {@code Telegram}'s passport element error file
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportelementerrorfile">
 * PassportElementErrorFile</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 * @see PassportSingleElementError
 */
public class PassportElementErrorFile extends PassportSingleElementError {

    /**
     * Constructor to init a {@link PassportElementErrorFile} object
     *
     * @param type:          type of element of the user's Telegram Passport which has the issue
     * @param message:       error message
     * @param fileHash:value of the hash, not base64-encoded
     */
    public PassportElementErrorFile(PassportElementType type, String message, String fileHash) {
        super(file, type, message, fileHash);
    }

    /**
     * Constructor to init a {@link PassportElementErrorFile} object
     *
     * @param jPassportElementErrorFile: passport element error file details as {@link JSONObject}
     */
    public PassportElementErrorFile(JSONObject jPassportElementErrorFile) {
        super(jPassportElementErrorFile);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportElementErrorSelfie}
     */
    public static PassportElementErrorSelfie getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorSelfie(jItem);
    }

}
