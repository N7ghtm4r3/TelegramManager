package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code PassportMultipleElementsError} class is useful to format a {@code Telegram}'s passport multiple elements error
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrorfiles">
 *             PassportElementErrorFiles</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrortranslationfiles">
 *             PassportElementErrorTranslationFiles</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 */
@Structure
public abstract class PassportMultipleElementsError extends PassportElementError {

    /**
     * {@code fileHashes} list of base64-encoded file hashes
     */
    protected final ArrayList<String> fileHashes;

    /**
     * Constructor to init a {@link PassportMultipleElementsError} object
     *
     * @param source:     error source
     * @param type:       type of element of the user's Telegram Passport which has the issue
     * @param message:    error message
     * @param fileHashes: list of base64-encoded file hashes
     */
    public PassportMultipleElementsError(ErrorSource source, PassportElementType type, String message,
                                         ArrayList<String> fileHashes) {
        super(source, type, message);
        this.fileHashes = fileHashes;
    }

    /**
     * Constructor to init a {@link PassportMultipleElementsError} object
     *
     * @param jPassportMultipleElementsError: passport multiple elements error details as {@link JSONObject}
     */
    public PassportMultipleElementsError(JSONObject jPassportMultipleElementsError) {
        super(jPassportMultipleElementsError);
        fileHashes = fetchStringsList(hTelegram.getJSONArray("file_hashes"));
    }

    /**
     * Method to get {@link #fileHashes} instance <br>
     * No-any params required
     *
     * @return {@link #fileHashes} instance as {@link ArrayList} of {@link String}
     */
    public ArrayList<String> getFileHashes() {
        return fileHashes;
    }

}
