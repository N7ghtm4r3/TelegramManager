package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.front_side;

/**
 * The {@code PassportElementErrorFrontSide} class is useful to format a {@code Telegram}'s passport element error front side
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportelementerrorfrontside">
 * PassportElementErrorFrontSide</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 * @see PassportSingleElementError
 */
public class PassportElementErrorFrontSide extends PassportSingleElementError {

    /**
     * Constructor to init a {@link PassportElementErrorFrontSide} object
     *
     * @param type:     type of element of the user's Telegram Passport which has the issue
     * @param message:  error message
     * @param fileHash: base64-encoded value of the hash
     */
    public PassportElementErrorFrontSide(PassportElementType type, String message, String fileHash) {
        super(front_side, type, message, fileHash);
    }

    /**
     * Constructor to init a {@link PassportElementErrorFrontSide} object
     *
     * @param jPassportElementErrorFrontSide: passport element error front side details as {@link JSONObject}
     */
    public PassportElementErrorFrontSide(JSONObject jPassportElementErrorFrontSide) {
        super(jPassportElementErrorFrontSide);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportElementErrorFrontSide}
     */
    public static PassportElementErrorFrontSide getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorFrontSide(jItem);
    }

}
