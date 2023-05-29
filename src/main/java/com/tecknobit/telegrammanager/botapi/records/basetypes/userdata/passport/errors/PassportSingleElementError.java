package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code PassportSingleElementError} class is useful to format a {@code Telegram}'s passport single element error
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrordatafield">
 *             PassportElementErrorDataField</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrorfrontside">
 *             PassportElementErrorFrontSide</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrorreverseside">
 *             PassportElementErrorReverseSide</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrorselfie">
 *             PassportElementErrorSelfie</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrorfile">
 *             PassportElementErrorFile</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrortranslationfile">
 *             PassportElementErrorTranslationFile</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrorunspecified">
 *             PassportElementErrorUnspecified</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 */
@Structure
public abstract class PassportSingleElementError extends PassportElementError {

    /**
     * {@code hash} base64-encoded value of the hash
     */
    protected final String hash;

    /**
     * Constructor to init a {@link PassportSingleElementError} object
     *
     * @param source:  error source
     * @param type:    type of element of the user's Telegram Passport which has the issue
     * @param message: error message
     * @param hash:    base64-encoded value of the hash
     */
    public PassportSingleElementError(ErrorSource source, PassportElementType type, String message, String hash) {
        super(source, type, message);
        this.hash = hash;
    }

    /**
     * Constructor to init a {@link PassportSingleElementError} object
     *
     * @param jPassportSingleElementError: passport single element error details as {@link JSONObject}
     */
    public PassportSingleElementError(JSONObject jPassportSingleElementError) {
        super(jPassportSingleElementError);
        hash = hTelegram.getString("file_hash", hTelegram.getString("element_hash"));
    }

    /**
     * Method to get {@link #hash} instance <br>
     * No-any params required
     *
     * @return {@link #hash} instance as {@link String}
     */
    public String getHash() {
        return hash;
    }

}
