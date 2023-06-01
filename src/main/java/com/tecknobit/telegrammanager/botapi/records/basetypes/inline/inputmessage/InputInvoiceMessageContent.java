package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import com.tecknobit.telegrammanager.botapi.records.basetypes.payments.LabeledPrice;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.apimanager.trading.TradingTools.roundValue;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.payments.LabeledPrice.returnLabeledPrices;

/**
 * The {@code InputInvoiceMessageContent} class is useful to format a {@code Telegram}'s input invoice message content
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputinvoicemessagecontent">
 * InputInvoiceMessageContent</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputMessageContentType
 */
public class InputInvoiceMessageContent extends TelegramType implements InputMessageContentType {

    /**
     * {@code title} product name, 1-32 characters
     */
    private final String title;

    /**
     * {@code payload} bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     * internal processes
     */
    private final String payload;

    /**
     * {@code providerToken} payment provider token, obtained via @BotFather
     */
    private final String providerToken;

    /**
     * {@code currency} three-letter ISO 4217 currency code, see more on currencies
     */
    private final String currency;

    /**
     * {@code prices} price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     * cost, delivery tax, bonus, etc.)
     */
    private final ArrayList<LabeledPrice> prices;

    /**
     * {@code maxTipAmount} the maximum accepted amount for tips in the smallest units of the currency (integer, not float/double)
     */
    private final int maxTipAmount;

    /**
     * {@code suggestedTipAmounts} amounts of tip in the smallest units of the currency (integer, not float/double)
     */
    private final ArrayList<Integer> suggestedTipAmounts;

    /**
     * {@code providerData} object for data about the invoice
     */
    private final String providerData;

    /**
     * {@code photoUrl} URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a
     * service
     */
    private final String photoUrl;

    /**
     * {@code photoSize} photo size in bytes
     */
    private final int photoSize;

    /**
     * {@code photoWidth} photo width
     */
    private final double photoWidth;

    /**
     * {@code photoHeight} photo height
     */
    private final double photoHeight;

    /**
     * {@code needName} if you require the user's full name to complete the order
     */
    private final boolean needName;

    /**
     * {@code needPhoneNumber} if you require the user's phone number to complete the order
     */
    private final boolean needPhoneNumber;

    /**
     * {@code needEmail} if you require the user's email address to complete the order
     */
    private final boolean needEmail;

    /**
     * {@code needShippingAddress} if you require the user's shipping address to complete the order
     */
    private final boolean needShippingAddress;

    /**
     * {@code sendPhoneNumberToProvider} if the user's phone number should be sent to provider
     */
    private final boolean sendPhoneNumberToProvider;

    /**
     * {@code sendEmailToProvider} if the user's email address should be sent to provider
     */
    private final boolean sendEmailToProvider;

    /**
     * {@code isFlexible} if the final price depends on the shipping method
     */
    private final boolean isFlexible;

    /**
     * Constructor to init a {@link InputInvoiceMessageContent} object
     * @param title: product name, 1-32 characters
     @param payload: bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     internal processes
     @param providerToken: payment provider token, obtained via @BotFather
     @param currency: three-letter ISO 4217 currency code, see more on currencies
     @param prices: price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     cost, delivery tax, bonus, etc.)
     @param maxTipAmount: the maximum accepted amount for tips in the smallest units of the currency (integer, not float/double)
     @param suggestedTipAmounts: amounts of tip in the smallest units of the currency (integer, not float/double)
     @param providerData: object for data about the invoice
     @param photoUrl: URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a
     service
     @param photoSize: photo size in bytes
     @param photoWidth: photo width
     @param photoHeight: photo height
     @param needName: if you require the user's full name to complete the order
     @param needPhoneNumber: if you require the user's phone number to complete the order
     @param needEmail: if you require the user's email address to complete the order
     @param needShippingAddress: if you require the user's shipping address to complete the order
     @param sendPhoneNumberToProvider: if the user's phone number should be sent to provider
     @param sendEmailToProvider: if the user's email address should be sent to provider
     @param isFlexible: if the final price depends on the shipping method

     */
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

    /**
     * Constructor to init a {@link InputInvoiceMessageContent} object
     *
     * @param jInputInvoiceMessageContent: input invoice message content details as {@link JSONObject}
     */
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

    /**
     * Method to get {@link #title} instance <br>
     * No-any params required
     *
     * @return {@link #title} instance as {@link String}
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to get {@link #payload} instance <br>
     * No-any params required
     *
     * @return {@link #payload} instance as {@link String}
     */
    public String getPayload() {
        return payload;
    }

    /**
     * Method to get {@link #providerToken} instance <br>
     * No-any params required
     *
     * @return {@link #providerToken} instance as {@link String}
     */
    public String getProviderToken() {
        return providerToken;
    }

    /**
     * Method to get {@link #currency} instance <br>
     * No-any params required
     *
     * @return {@link #currency} instance as {@link String}
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Method to get {@link #prices} instance <br>
     * No-any params required
     *
     * @return {@link #prices} instance as {@link ArrayList} of {@link LabeledPrice}
     */
    public ArrayList<LabeledPrice> getPrices() {
        return prices;
    }

    /**
     * Method to get {@link #maxTipAmount} instance <br>
     * No-any params required
     *
     * @return {@link #maxTipAmount} instance as int
     */
    public int getMaxTipAmount() {
        return maxTipAmount;
    }

    /**
     * Method to get {@link #suggestedTipAmounts} instance <br>
     * No-any params required
     *
     * @return {@link #suggestedTipAmounts} instance as {@link ArrayList} of {@link Integer}
     */
    public ArrayList<Integer> getSuggestedTipAmounts() {
        return suggestedTipAmounts;
    }

    /**
     * Method to get {@link #providerData} instance <br>
     * No-any params required
     *
     * @return {@link #providerData} instance as {@link String}
     */
    public String getProviderData() {
        return providerData;
    }

    /**
     * Method to get {@link #photoUrl} instance <br>
     * No-any params required
     *
     * @return {@link #photoUrl} instance as {@link String}
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * Method to get {@link #photoSize} instance <br>
     * No-any params required
     *
     * @return {@link #photoSize} instance as int
     */
    public int getPhotoSize() {
        return photoSize;
    }

    /**
     * Method to get {@link #photoWidth} instance <br>
     * No-any params required
     *
     * @return {@link #photoWidth} instance as double
     */
    public double getPhotoWidth() {
        return photoWidth;
    }

    /**
     * Method to get {@link #photoWidth} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #photoWidth} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getPhotoWidth(int decimals) {
        return roundValue(photoWidth, decimals);
    }

    /**
     * Method to get {@link #photoHeight} instance <br>
     * No-any params required
     *
     * @return {@link #photoHeight} instance as double
     */
    public double getPhotoHeight() {
        return photoHeight;
    }

    /**
     * Method to get {@link #photoHeight} instance
     *
     * @param decimals: number of digits to round final value
     * @return {@link #photoHeight} instance rounded with decimal digits inserted
     * @throws IllegalArgumentException if decimalDigits is negative
     */
    public double getPhotoHeight(int decimals) {
        return roundValue(photoHeight, decimals);
    }

    /**
     * Method to get {@link #needName} instance <br>
     * No-any params required
     *
     * @return {@link #needName} instance as boolean
     */
    public boolean needName() {
        return needName;
    }

    /**
     * Method to get {@link #needPhoneNumber} instance <br>
     * No-any params required
     *
     * @return {@link #needPhoneNumber} instance as boolean
     */
    public boolean needPhoneNumber() {
        return needPhoneNumber;
    }

    /**
     * Method to get {@link #needEmail} instance <br>
     * No-any params required
     *
     * @return {@link #needEmail} instance as boolean
     */
    public boolean needEmail() {
        return needEmail;
    }

    /**
     * Method to get {@link #needShippingAddress} instance <br>
     * No-any params required
     *
     * @return {@link #needShippingAddress} instance as boolean
     */
    public boolean needShippingAddress() {
        return needShippingAddress;
    }

    /**
     * Method to get {@link #sendPhoneNumberToProvider} instance <br>
     * No-any params required
     *
     * @return {@link #sendPhoneNumberToProvider} instance as boolean
     */
    public boolean sendPhoneNumberToProvider() {
        return sendPhoneNumberToProvider;
    }

    /**
     * Method to get {@link #sendEmailToProvider} instance <br>
     * No-any params required
     *
     * @return {@link #sendEmailToProvider} instance as boolean
     */
    public boolean sendEmailToProvider() {
        return sendEmailToProvider;
    }

    /**
     * Method to get {@link #isFlexible} instance <br>
     * No-any params required
     *
     * @return {@link #isFlexible} instance as boolean
     */
    public boolean isFlexible() {
        return isFlexible;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InputInvoiceMessageContent}
     */
    public static InputInvoiceMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputInvoiceMessageContent(jItem);
    }

}
