package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

@Structure
public abstract class PassportElementError extends TelegramType {

    public enum ErrorSource {

        data,

        front_side,

        reverse_side,

        selfie,

        file,

        files,

        translation_file,

        translation_files,

        unspecified

    }

    protected final ErrorSource source;

    protected final PassportElementType type;

    protected final String message;

    public PassportElementError(ErrorSource source, PassportElementType type, String message) {
        super(null);
        this.source = source;
        this.type = type;
        this.message = message;
    }

    public PassportElementError(JSONObject jPassportElementError) {
        super(jPassportElementError);
        source = ErrorSource.valueOf(hTelegram.getString("source"));
        type = PassportElementType.valueOf(hTelegram.getString("type"));
        message = hTelegram.getString("message");
    }

    public ErrorSource getSource() {
        return source;
    }

    public PassportElementType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

}
