package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.returnEncryptedPassportElements;

public class PassportData extends TelegramType {

    private final ArrayList<EncryptedPassportElement> data;

    private final EncryptedCredentials credentials;

    public PassportData(ArrayList<EncryptedPassportElement> data, EncryptedCredentials credentials) {
        super(null);
        this.data = data;
        this.credentials = credentials;
    }

    public PassportData(JSONObject jPassportData) {
        super(jPassportData);
        data = returnEncryptedPassportElements(hTelegram.getJSONArray("data"));
        credentials = EncryptedCredentials.getInstance(hTelegram.getJSONObject("credentials"));
    }

    public ArrayList<EncryptedPassportElement> getData() {
        return data;
    }

    public EncryptedCredentials getCredentials() {
        return credentials;
    }

    public static PassportData getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportData(jItem);
    }

}
