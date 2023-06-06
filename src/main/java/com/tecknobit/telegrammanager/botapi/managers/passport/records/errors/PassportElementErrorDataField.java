package com.tecknobit.telegrammanager.botapi.managers.passport.records.errors;

import com.tecknobit.telegrammanager.botapi.managers.passport.records.EncryptedPassportElement.PassportElementType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code PassportElementErrorDataField} class is useful to format a {@code Telegram}'s passport element error data field
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportelementerrordatafield">
 * PassportElementErrorDataField</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PassportElementError
 */
public class PassportElementErrorDataField extends PassportElementError {

    /**
     * {@code fieldName} name of the data field which has the error
     */
    private final String fieldName;

    /**
     * {@code dataHash} base64-encoded data hash
     */
    private final String dataHash;

    /**
     * Constructor to init a {@link PassportElementErrorDataField} object
     *
     * @param type:      type of element of the user's Telegram Passport which has the issue
     * @param message:   error message
     * @param fieldName: name of the data field which has the error
     * @param dataHash:  base64-encoded data hash
     */
    public PassportElementErrorDataField(PassportElementType type, String message, String fieldName, String dataHash) {
        super(ErrorSource.data, type, message);
        this.fieldName = fieldName;
        this.dataHash = dataHash;
    }

    /**
     * Constructor to init a {@link PassportElementErrorDataField} object
     *
     * @param jPassportElementErrorDataField: passport element error data field details as {@link JSONObject}
     */
    public PassportElementErrorDataField(JSONObject jPassportElementErrorDataField) {
        super(jPassportElementErrorDataField);
        fieldName = hTelegram.getString("field_name");
        dataHash = hTelegram.getString("data_hash");
    }

    /**
     * Method to get {@link #fieldName} instance <br>
     * No-any params required
     *
     * @return {@link #fieldName} instance as {@link String}
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Method to get {@link #dataHash} instance <br>
     * No-any params required
     *
     * @return {@link #dataHash} instance as {@link String}
     */
    public String getDataHash() {
        return dataHash;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportElementErrorDataField}
     */
    public static PassportElementErrorDataField getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorDataField(jItem);
    }

}
