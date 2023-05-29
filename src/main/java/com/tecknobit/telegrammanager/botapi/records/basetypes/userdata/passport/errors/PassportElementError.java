package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;


/**
 * The {@code PassportElementError} class is useful to format a {@code Telegram}'s passport element error
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
 *         <a href="https://core.telegram.org/bots/api#passportelementerrorfiles">
 *             PassportElementErrorFiles</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrortranslationfile">
 *             PassportElementErrorTranslationFile</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrortranslationfiles">
 *             PassportElementErrorTranslationFiles</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#passportelementerrorunspecified">
 *             PassportElementErrorUnspecified</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
@Structure
public abstract class PassportElementError extends TelegramType {

    /**
     * {@code ErrorSource} list of available error sources
     */
    public enum ErrorSource {

        /**
         * {@code data} error source
         */
        data,

        /**
         * {@code front_side} error source
         */
        front_side,

        /**
         * {@code reverse_side} error source
         */
        reverse_side,

        /**
         * {@code selfie} error source
         */
        selfie,

        /**
         * {@code file} error source
         */
        file,

        /**
         * {@code files} error source
         */
        files,

        /**
         * {@code translation_file} error source
         */
        translation_file,

        /**
         * {@code translation_files} error source
         */
        translation_files,

        /**
         * {@code unspecified} error source
         */
        unspecified

    }

    /**
     * {@code source} of the error
     */
    protected final ErrorSource source;

    /**
     * {@code type} of element of the user's Telegram Passport which has the issue
     */
    protected final PassportElementType type;

    /**
     * {@code message} of the error
     */
    protected final String message;

    /**
     * Constructor to init a {@link PassportElementError} object
     *
     * @param source:  error source
     * @param type:    type of element of the user's Telegram Passport which has the issue
     * @param message: error message
     */
    public PassportElementError(ErrorSource source, PassportElementType type, String message) {
        super(null);
        this.source = source;
        this.type = type;
        this.message = message;
    }

    /**
     * Constructor to init a {@link PassportElementError} object
     *
     * @param jPassportElementError: passport element error details as {@link JSONObject}
     */
    public PassportElementError(JSONObject jPassportElementError) {
        super(jPassportElementError);
        source = ErrorSource.valueOf(hTelegram.getString("source"));
        type = PassportElementType.valueOf(hTelegram.getString("type"));
        message = hTelegram.getString("message");
    }

    /**
     * Method to get {@link #source} instance <br>
     * No-any params required
     *
     * @return {@link #source} instance as {@link ErrorSource}
     */
    public ErrorSource getSource() {
        return source;
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link PassportElementType}
     */
    public PassportElementType getType() {
        return type;
    }

    /**
     * Method to get {@link #message} instance <br>
     * No-any params required
     *
     * @return {@link #message} instance as {@link String}
     */
    public String getMessage() {
        return message;
    }

}
