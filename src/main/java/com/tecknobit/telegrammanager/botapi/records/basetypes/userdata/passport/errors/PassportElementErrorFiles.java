package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.files;

/**
 * The {@code PassportElementErrorFiles} class is useful to format a {@code Telegram}'s passport element error files
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportelementerrorfiles">
 * PassportElementErrorFiles</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 * @see PassportMultipleElementsError
 */
public class PassportElementErrorFiles extends PassportMultipleElementsError {

    /**
     * Constructor to init a {@link PassportElementErrorFiles} object
     *
     * @param type:       type of element of the user's Telegram Passport which has the issue
     * @param message:    error message
     * @param fileHashes: list of base64-encoded file hashes
     */
    public PassportElementErrorFiles(PassportElementType type, String message, ArrayList<String> fileHashes) {
        super(files, type, message, fileHashes);
    }

    /**
     * Constructor to init a {@link PassportElementErrorFiles} object
     *
     * @param jPassportElementErrorFiles: passport element error files details as {@link JSONObject}
     */
    public PassportElementErrorFiles(JSONObject jPassportElementErrorFiles) {
        super(jPassportElementErrorFiles);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportElementErrorFiles}
     */
    public static PassportElementErrorFiles getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorFiles(jItem);
    }

}
