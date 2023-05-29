package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.unspecified;

/**
 * The {@code PassportElementErrorUnspecified} class is useful to format a {@code Telegram}'s passport element error unspecified
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportelementerrorunspecified">
 * PassportElementErrorUnspecified</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 * @see PassportSingleElementError
 */
public class PassportElementErrorUnspecified extends PassportSingleElementError {

    /**
     * Constructor to init a {@link PassportElementErrorUnspecified} object
     *
     * @param type:     type of element of the user's Telegram Passport which has the issue
     * @param message:  error message
     * @param fileHash: base64-encoded value of the hash
     */
    public PassportElementErrorUnspecified(PassportElementType type, String message, String fileHash) {
        super(unspecified, type, message, fileHash);
    }

    /**
     * Constructor to init a {@link PassportElementErrorUnspecified} object
     *
     * @param jPassportElementErrorUnspecified: element error unspecified details as {@link JSONObject}
     */
    public PassportElementErrorUnspecified(JSONObject jPassportElementErrorUnspecified) {
        super(jPassportElementErrorUnspecified);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportElementErrorUnspecified}
     */
    public static PassportElementErrorUnspecified getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorUnspecified(jItem);
    }

}
