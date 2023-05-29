package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.selfie;

/**
 * The {@code PassportElementErrorSelfie} class is useful to format a {@code Telegram}'s passport element error selfie
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportelementerrorselfie">
 * PassportElementErrorSelfie</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 * @see PassportSingleElementError
 */
public class PassportElementErrorSelfie extends PassportSingleElementError {

    /**
     * Constructor to init a {@link PassportElementErrorSelfie} object
     *
     * @param type:     type of element of the user's Telegram Passport which has the issue
     * @param message:  error message
     * @param fileHash: base64-encoded value of the hash
     */
    public PassportElementErrorSelfie(PassportElementType type, String message, String fileHash) {
        super(selfie, type, message, fileHash);
    }

    /**
     * Constructor to init a {@link PassportElementErrorSelfie} object
     *
     * @param jPassportElementErrorSelfie: passport element error selfie details as {@link JSONObject}
     */
    public PassportElementErrorSelfie(JSONObject jPassportElementErrorSelfie) {
        super(jPassportElementErrorSelfie);
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
