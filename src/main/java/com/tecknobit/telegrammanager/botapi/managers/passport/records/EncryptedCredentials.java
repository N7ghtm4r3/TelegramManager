package com.tecknobit.telegrammanager.botapi.managers.passport.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code EncryptedCredentials} class is useful to format a {@code Telegram}'s encrypted credentials
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#encryptedcredentials">
 * EncryptedCredentials</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class EncryptedCredentials extends TelegramType {

    /**
     * {@code data} base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets
     * required for {@link EncryptedPassportElement} decryption and authentication
     */
    private final String data;

    /**
     * {@code hash} of the
     */
    private final String hash;

    /**
     * {@code secret} of the
     */
    private final String secret;

    /**
     * Constructor to init a {@link EncryptedCredentials} object
     *
     * @param data:   base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets
     *                required for {@link EncryptedPassportElement} decryption and authentication
     * @param hash:   base64-encoded data hash for data authentication
     * @param secret: base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
     */
    public EncryptedCredentials(String data, String hash, String secret) {
        super(null);
        this.data = data;
        this.hash = hash;
        this.secret = secret;
    }

    /**
     * Constructor to init a {@link EncryptedCredentials} object
     *
     * @param jEncryptedCredentials: encrypted credentials details as {@link JSONObject}
     */
    public EncryptedCredentials(JSONObject jEncryptedCredentials) {
        super(jEncryptedCredentials);
        data = hTelegram.getString("data");
        hash = hTelegram.getString("hash");
        secret = hTelegram.getString("secret");
    }

    /**
     * Method to get {@link #data} instance <br>
     * No-any params required
     *
     * @return {@link #data} instance as {@link String}
     */
    public String getData() {
        return data;
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

    /**
     * Method to get {@link #secret} instance <br>
     * No-any params required
     *
     * @return {@link #secret} instance as {@link String}
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link EncryptedCredentials}
     */
    public static EncryptedCredentials getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new EncryptedCredentials(jItem);
    }

}
