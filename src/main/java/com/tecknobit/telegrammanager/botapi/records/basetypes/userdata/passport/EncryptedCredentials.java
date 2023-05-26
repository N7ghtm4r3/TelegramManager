package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class EncryptedCredentials extends TelegramType {

    private final String data;

    private final String hash;

    private final String secret;

    public EncryptedCredentials(String data, String hash, String secret) {
        super(null);
        this.data = data;
        this.hash = hash;
        this.secret = secret;
    }

    public EncryptedCredentials(JSONObject jEncryptedCredentials) {
        super(jEncryptedCredentials);
        data = hTelegram.getString("data");
        hash = hTelegram.getString("hash");
        secret = hTelegram.getString("secret");
    }

    public String getData() {
        return data;
    }

    public String getHash() {
        return hash;
    }

    public String getSecret() {
        return secret;
    }

    public static EncryptedCredentials getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new EncryptedCredentials(jItem);
    }

}
