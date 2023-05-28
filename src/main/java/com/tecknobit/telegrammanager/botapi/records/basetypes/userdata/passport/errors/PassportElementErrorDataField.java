package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors.PassportElementError.ErrorSource.data;

public class PassportElementErrorDataField extends PassportElementError {

    private final String fieldName;

    private final String dataHash;

    public PassportElementErrorDataField(PassportElementType type, String message, String fieldName, String dataHash) {
        super(data, type, message);
        this.fieldName = fieldName;
        this.dataHash = dataHash;
    }

    public PassportElementErrorDataField(JSONObject jPassportElementErrorDataField) {
        super(jPassportElementErrorDataField);
        fieldName = hTelegram.getString("field_name");
        dataHash = hTelegram.getString("data_hash");
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getDataHash() {
        return dataHash;
    }

    public static PassportElementErrorDataField getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportElementErrorDataField(jItem);
    }

}
