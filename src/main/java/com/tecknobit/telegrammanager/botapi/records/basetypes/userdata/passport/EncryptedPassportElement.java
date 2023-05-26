package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class EncryptedPassportElement extends TelegramType {

    public enum PassportElementType {

        personal_details,

        passport,

        driver_license,

        identity_card,

        internal_passport,

        address,

        utility_bill,

        bank_statement,

        rental_agreement,

        passport_registration,

        temporary_registration,

        phone_number,

        email

    }

    private final PassportElementType type;

    private final String data;

    private final String phoneNumber;

    private final String email;

    private final ArrayList<PassportFile> files;

    private final PassportFile frontSize;

    private final PassportFile reverseSide;

    private final PassportFile selfie;

    private final ArrayList<PassportFile> translation;

    private final String hash;

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

    public PassportElementType getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<PassportFile> getFiles() {
        return files;
    }

    public PassportFile getFrontSize() {
        return frontSize;
    }

    public PassportFile getReverseSide() {
        return reverseSide;
    }

    public PassportFile getSelfie() {
        return selfie;
    }

    public ArrayList<PassportFile> getTranslation() {
        return translation;
    }

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

    public static EncryptedPassportElement getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new EncryptedPassportElement(jItem);
    }

}
