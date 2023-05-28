package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import org.json.JSONObject;

@Structure
public abstract class PassportSingleElementError extends PassportElementError {

    protected final String hash;

    public PassportSingleElementError(ErrorSource source, PassportElementType type, String message, String hash) {
        super(source, type, message);
        this.hash = hash;
    }

    public PassportSingleElementError(JSONObject jPassportSingleElementError) {
        super(jPassportSingleElementError);
        hash = hTelegram.getString("file_hash", hTelegram.getString("element_hash"));
    }

    public String getHash() {
        return hash;
    }

}
