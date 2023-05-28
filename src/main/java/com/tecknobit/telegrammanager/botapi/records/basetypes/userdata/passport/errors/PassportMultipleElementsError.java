package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.errors;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.PassportElementType;
import org.json.JSONObject;

import java.util.ArrayList;

@Structure
public abstract class PassportMultipleElementsError extends PassportElementError {

    protected final ArrayList<String> fileHashes;

    public PassportMultipleElementsError(ErrorSource source, PassportElementType type, String message,
                                         ArrayList<String> fileHashes) {
        super(source, type, message);
        this.fileHashes = fileHashes;
    }

    public PassportMultipleElementsError(JSONObject jPassportMultipleElementsError) {
        super(jPassportMultipleElementsError);
        fileHashes = fetchStringsList(hTelegram.getJSONArray("file_hashes"));
    }

    public ArrayList<String> getFileHashes() {
        return fileHashes;
    }

}
