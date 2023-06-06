package com.tecknobit.telegrammanager.botapi.managers.passport.records;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code EncryptedPassportElement} class is useful to format a {@code Telegram}'s encrypted passport element
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#encryptedpassportelement">
 * EncryptedPassportElement</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class EncryptedPassportElement extends TelegramType {

    /**
     * {@code PassportElementType} list of available passport element types
     */
    public enum PassportElementType {

        /**
         * {@code personal_details} passport element type
         */
        personal_details,

        /**
         * {@code passport} passport element type
         */
        passport,

        /**
         * {@code driver_license} passport element type
         */
        driver_license,

        /**
         * {@code identity_card} passport element type
         */
        identity_card,

        /**
         * {@code internal_passport} passport element type
         */
        internal_passport,

        /**
         * {@code address} passport element type
         */
        address,

        /**
         * {@code utility_bill} passport element type
         */
        utility_bill,

        /**
         * {@code bank_statement} passport element type
         */
        bank_statement,

        /**
         * {@code rental_agreement} passport element type
         */
        rental_agreement,

        /**
         * {@code passport_registration} passport element type
         */
        passport_registration,

        /**
         * {@code temporary_registration} passport element type
         */
        temporary_registration,

        /**
         * {@code phone_number} passport element type
         */
        phone_number,

        /**
         * {@code email} passport element type
         */
        email

    }

    /**
     * {@code type} of the element
     */
    private final PassportElementType type;

    /**
     * {@code data} base64-encoded encrypted Telegram Passport element data provided by the user
     */
    private final String data;

    /**
     * {@code phoneNumber} user's verified phone number
     */
    private final String phoneNumber;

    /**
     * {@code email} user's verified email address
     */
    private final String email;

    /**
     * {@code files} array of encrypted files with documents provided by the user
     */
    private final ArrayList<PassportFile> files;

    /**
     * {@code frontSize} encrypted file with the front side of the document, provided by the user
     */
    private final PassportFile frontSize;

    /**
     * {@code reverseSide} encrypted file with the reverse side of the document, provided by the user
     */
    private final PassportFile reverseSide;

    /**
     * {@code selfie} encrypted file with the selfie of the user holding a document, provided by the user
     */
    private final PassportFile selfie;

    /**
     * {@code translation} array of encrypted files with translated versions of documents provided by the user
     */
    private final ArrayList<PassportFile> translation;

    /**
     * {@code hash} base64-encoded element hash
     */
    private final String hash;

    /**
     * Constructor to init a {@link EncryptedPassportElement} object
     *
     * @param type:        element type
     * @param data:        base64-encoded encrypted Telegram Passport element data provided by the user
     * @param phoneNumber: user's verified phone number
     * @param email:       user's verified email address
     * @param files:       array of encrypted files with documents provided by the user
     * @param frontSize:   encrypted file with the front side of the document, provided by the user
     * @param reverseSide: encrypted file with the reverse side of the document, provided by the user
     * @param selfie:      encrypted file with the selfie of the user holding a document, provided by the user
     * @param translation: array of encrypted files with translated versions of documents provided by the user
     * @param hash:        base64-encoded element hash
     */
    public EncryptedPassportElement(PassportElementType type, String data, String phoneNumber, String email,
                                    ArrayList<PassportFile> files, PassportFile frontSize, PassportFile reverseSide,
                                    PassportFile selfie, ArrayList<PassportFile> translation, String hash) {
        super(null);
        this.type = type;
        this.data = data;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.files = files;
        this.frontSize = frontSize;
        this.reverseSide = reverseSide;
        this.selfie = selfie;
        this.translation = translation;
        this.hash = hash;
    }

    /**
     * Constructor to init a {@link EncryptedPassportElement} object
     *
     * @param jEncryptedPassportElement: encrypted passport element details as {@link JSONObject}
     */
    public EncryptedPassportElement(JSONObject jEncryptedPassportElement) {
        super(jEncryptedPassportElement);
        type = PassportElementType.valueOf(hTelegram.getString("type"));
        data = hTelegram.getString("data");
        phoneNumber = hTelegram.getString("phone_number");
        email = hTelegram.getString("email");
        files = PassportFile.returnPassportFiles(hTelegram.getJSONArray("files"));
        frontSize = PassportFile.getInstance(hTelegram.getJSONObject("front_side"));
        reverseSide = PassportFile.getInstance(hTelegram.getJSONObject("reverse_side"));
        selfie = PassportFile.getInstance(hTelegram.getJSONObject("selfie"));
        translation = PassportFile.returnPassportFiles(hTelegram.getJSONArray("translation"));
        hash = hTelegram.getString("hash");
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
     * Method to get {@link #data} instance <br>
     * No-any params required
     *
     * @return {@link #data} instance as {@link String}
     */
    public String getData() {
        return data;
    }

    /**
     * Method to get {@link #phoneNumber} instance <br>
     * No-any params required
     *
     * @return {@link #phoneNumber} instance as {@link String}
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to get {@link #email} instance <br>
     * No-any params required
     *
     * @return {@link #email} instance as {@link String}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to get {@link #files} instance <br>
     * No-any params required
     *
     * @return {@link #files} instance as {@link ArrayList} of {@link PassportFile}
     */
    public ArrayList<PassportFile> getFiles() {
        return files;
    }

    /**
     * Method to get {@link #frontSize} instance <br>
     * No-any params required
     *
     * @return {@link #frontSize} instance as {@link PassportFile}
     */
    public PassportFile getFrontSize() {
        return frontSize;
    }

    /**
     * Method to get {@link #reverseSide} instance <br>
     * No-any params required
     *
     * @return {@link #reverseSide} instance as {@link PassportFile}
     */
    public PassportFile getReverseSide() {
        return reverseSide;
    }

    /**
     * Method to get {@link #selfie} instance <br>
     * No-any params required
     *
     * @return {@link #selfie} instance as {@link PassportFile}
     */
    public PassportFile getSelfie() {
        return selfie;
    }

    /**
     * Method to get {@link #translation} instance <br>
     * No-any params required
     *
     * @return {@link #translation} instance as {@link ArrayList} of {@link PassportFile}
     */
    public ArrayList<PassportFile> getTranslation() {
        return translation;
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
     * Method to return a {@link EncryptedPassportElement} list
     *
     * @param jElements : JSON source from fetch the list
     * @return encrypted passport elements list as {@link ArrayList} of {@link EncryptedPassportElement}
     */
    @Returner
    public static ArrayList<EncryptedPassportElement> returnEncryptedPassportElements(JSONArray jElements) {
        ArrayList<EncryptedPassportElement> passportElements = new ArrayList<>();
        if (jElements != null)
            for (int j = 0; j < jElements.length(); j++)
                passportElements.add(new EncryptedPassportElement(jElements.getJSONObject(j)));
        return passportElements;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link EncryptedPassportElement}
     */
    public static EncryptedPassportElement getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new EncryptedPassportElement(jItem);
    }

}
