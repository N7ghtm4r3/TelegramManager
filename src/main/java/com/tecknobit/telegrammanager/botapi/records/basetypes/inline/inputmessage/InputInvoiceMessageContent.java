package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import com.tecknobit.telegrammanager.botapi.records.basetypes.payments.LabeledPrice;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.payments.LabeledPrice.returnLabeledPrices;

public class InputInvoiceMessageContent extends TelegramType implements InputMessageContentType {

    private final String title;

    private final String payload;

    private final String providerToken;

    private final String currency;

    private final ArrayList<LabeledPrice> prices;

    private final int maxTipAmount;

    private final ArrayList<Integer> suggestedTipAmounts;

    private final String providerData;

    private final String photoUrl;

    private final int photoSize;

    private final double photoWidth;

    private final double photoHeight;

    private final boolean needName;

    private final boolean needPhoneNumber;

    private final boolean needEmail;

    private final boolean needShippingAddress;

    private final boolean sendPhoneNumberToProvider;

    private final boolean sendEmailToProvider;

    private final boolean isFlexible;

    public InputInvoiceMessageContent(String title, String payload, String providerToken, String currency,
                                      ArrayList<LabeledPrice> prices, int maxTipAmount,
                                      ArrayList<Integer> suggestedTipAmounts, String providerData, String photoUrl,
                                      int photoSize, double photoWidth, double photoHeight, boolean needName,
                                      boolean needPhoneNumber, boolean needEmail, boolean needShippingAddress,
                                      boolean sendPhoneNumberToProvider, boolean sendEmailToProvider, boolean isFlexible) {
        super(null);
        this.title = title;
        this.payload = payload;
        this.providerToken = providerToken;
        this.currency = currency;
        this.prices = prices;
        this.maxTipAmount = maxTipAmount;
        this.suggestedTipAmounts = suggestedTipAmounts;
        this.providerData = providerData;
        this.photoUrl = photoUrl;
        this.photoSize = photoSize;
        this.photoWidth = photoWidth;
        this.photoHeight = photoHeight;
        this.needName = needName;
        this.needPhoneNumber = needPhoneNumber;
        this.needEmail = needEmail;
        this.needShippingAddress = needShippingAddress;
        this.sendPhoneNumberToProvider = sendPhoneNumberToProvider;
        this.sendEmailToProvider = sendEmailToProvider;
        this.isFlexible = isFlexible;
    }

    public InputInvoiceMessageContent(JSONObject jInputInvoiceMessageContent) {
        super(jInputInvoiceMessageContent);
        title = hTelegram.getString("title");
        payload = hTelegram.getString("payload");
        providerToken = hTelegram.getString("provider_token");
        currency = hTelegram.getString("currency");
        prices = returnLabeledPrices(hTelegram.getJSONArray("prices"));
        maxTipAmount = hTelegram.getInt("max_tip_amount");
        suggestedTipAmounts = fetchIntegersList(hTelegram.getJSONArray("suggested_tip_amounts"));
        providerData = hTelegram.getString("provider_data");
        photoUrl = hTelegram.getString("photo_url");
        photoSize = hTelegram.getInt("photo_size");
        photoWidth = hTelegram.getDouble("photo_width");
        photoHeight = hTelegram.getDouble("photo_height");
        needName = hTelegram.getBoolean("need_name");
        needPhoneNumber = hTelegram.getBoolean("need_phone_number");
        needEmail = hTelegram.getBoolean("need_email");
        needShippingAddress = hTelegram.getBoolean("need_shipping_address");
        sendPhoneNumberToProvider = hTelegram.getBoolean("send_phone_number_to_provider");
        sendEmailToProvider = hTelegram.getBoolean("send_email_to_provider");
        isFlexible = hTelegram.getBoolean("is_flexible");
    }

    public String getTitle() {
        return title;
    }

    public String getPayload() {
        return payload;
    }

    public String getProviderToken() {
        return providerToken;
    }

    public String getCurrency() {
        return currency;
    }

    public ArrayList<LabeledPrice> getPrices() {
        return prices;
    }

    public int getMaxTipAmount() {
        return maxTipAmount;
    }

    public ArrayList<Integer> getSuggestedTipAmounts() {
        return suggestedTipAmounts;
    }

    public String getProviderData() {
        return providerData;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public int getPhotoSize() {
        return photoSize;
    }

    public double getPhotoWidth() {
        return photoWidth;
    }

    public double getPhotoHeight() {
        return photoHeight;
    }

    public boolean needName() {
        return needName;
    }

    public boolean needPhoneNumber() {
        return needPhoneNumber;
    }

    public boolean needEmail() {
        return needEmail;
    }

    public boolean needShippingAddress() {
        return needShippingAddress;
    }

    public boolean s1endPhoneNumberToProvider() {
        return sendPhoneNumberToProvider;
    }

    public boolean sendEmailToProvider() {
        return sendEmailToProvider;
    }

    public boolean isFlexible() {
        return isFlexible;
    }

    public static InputInvoiceMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputInvoiceMessageContent(jItem);
    }

}
