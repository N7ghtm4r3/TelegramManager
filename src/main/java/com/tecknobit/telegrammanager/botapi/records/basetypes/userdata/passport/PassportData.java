package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.EncryptedPassportElement.returnEncryptedPassportElements;

/**
 * The {@code PassportData} class is useful to format a {@code Telegram}'s passport data
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#passportdata">
 * PassportData</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class PassportData extends TelegramType {

    /**
     * {@code data} array with information about documents and other Telegram Passport elements that was shared with the bot
     */
    private final ArrayList<EncryptedPassportElement> data;

    /**
     * {@code credentials} encrypted credentials required to decrypt the data
     */
    private final EncryptedCredentials credentials;

    /**
     * Constructor to init a {@link PassportData} object
     *
     * @param data:        array with information about documents and other Telegram Passport elements that was shared with the bot
     * @param credentials: encrypted credentials required to decrypt the data
     */
    public PassportData(ArrayList<EncryptedPassportElement> data, EncryptedCredentials credentials) {
        super(null);
        this.data = data;
        this.credentials = credentials;
    }

    /**
     * Constructor to init a {@link PassportData} object
     *
     * @param jPassportData: passport data details as {@link JSONObject}
     */
    public PassportData(JSONObject jPassportData) {
        super(jPassportData);
        data = returnEncryptedPassportElements(hTelegram.getJSONArray("data"));
        credentials = EncryptedCredentials.getInstance(hTelegram.getJSONObject("credentials"));
    }

    /**
     * Method to get {@link #data} instance <br>
     * No-any params required
     *
     * @return {@link #data} instance as {@link ArrayList} of {@link EncryptedPassportElement}
     */
    public ArrayList<EncryptedPassportElement> getData() {
        return data;
    }

    /**
     * Method to get {@link #credentials} instance <br>
     * No-any params required
     *
     * @return {@link #credentials} instance as {@link EncryptedCredentials}
     */
    public EncryptedCredentials getCredentials() {
        return credentials;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PassportData}
     */
    public static PassportData getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PassportData(jItem);
    }

}
