package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.reverse_side;

/**
 * The {@code PassportElementErrorReverseSide} class is useful to format a {@code Telegram}'s passport element error reverse side
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportelementerrorreverseside">
 * PassportElementErrorReverseSide</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 * @see PassportSingleElementError
 */
public class PassportElementErrorReverseSide extends PassportSingleElementError {

    /**
     * Constructor to init a {@link PassportElementErrorReverseSide} object
     *
     * @param type:     type of element of the user's Telegram Passport which has the issue
     * @param message:  error message
     * @param fileHash: base64-encoded value of the hash
     */
    public PassportElementErrorReverseSide(PassportElementType type, String message, String fileHash) {
        super(reverse_side, type, message, fileHash);
    }

    /**
     * Constructor to init a {@link PassportElementErrorReverseSide} object
     *
     * @param jPassportElementErrorReverseSide: passport element error reverse side details as {@link JSONObject}
     */
    public PassportElementErrorReverseSide(JSONObject jPassportElementErrorReverseSide) {
        super(jPassportElementErrorReverseSide);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportElementErrorReverseSide}
     */
    public static PassportElementErrorReverseSide getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorReverseSide(jItem);
    }

}
