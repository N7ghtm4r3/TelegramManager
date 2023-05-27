package com.tecknobit.telegrammanager.botapi.records.basetypes.payments;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code SuccessfulPayment} class is useful to format a {@code Telegram}'s successful payment
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#successfulpayment">
 * SuccessfulPayment</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PaymentItem
 */
public class SuccessfulPayment extends PaymentItem {

    /**
     * {@code invoicePayload} bot specified invoice payload
     */
    private final String invoicePayload;

    /**
     * {@code shippingOptionId} identifier of the shipping option chosen by the user
     */
    private final String shippingOptionId;

    /**
     * {@code orderInfo} order information provided by the user
     */
    private final OrderInfo orderInfo;

    /**
     * {@code telegramPaymentChargeId} Telegram payment identifier
     */
    private final String telegramPaymentChargeId;

    /**
     * {@code providerPaymentChargeId} provider payment identifier
     */
    private final String providerPaymentChargeId;

    /**
     * Constructor to init a {@link SuccessfulPayment} object
     *
     * @param currency:                three-letter ISO 4217 currency code
     * @param totalAmount:             total price in the smallest units of the currency (integer, not float/double)
     * @param invoicePayload:          bot specified invoice payload
     * @param shippingOptionId:        identifier of the shipping option chosen by the user
     * @param orderInfo:               order information provided by the user
     * @param telegramPaymentChargeId: Telegram payment identifier
     * @param providerPaymentChargeId: provider payment identifier
     */
    public SuccessfulPayment(String currency, int totalAmount, String invoicePayload, String shippingOptionId,
                             OrderInfo orderInfo, String telegramPaymentChargeId, String providerPaymentChargeId) {
        super(currency, totalAmount);
        this.invoicePayload = invoicePayload;
        this.shippingOptionId = shippingOptionId;
        this.orderInfo = orderInfo;
        this.telegramPaymentChargeId = telegramPaymentChargeId;
        this.providerPaymentChargeId = providerPaymentChargeId;
    }

    /**
     * Constructor to init a {@link SuccessfulPayment} object
     *
     * @param jSuccessfulPayment: successful payment details as {@link JSONObject}
     */
    public SuccessfulPayment(JSONObject jSuccessfulPayment) {
        super(jSuccessfulPayment);
        invoicePayload = hTelegram.getString("invoice_payload");
        shippingOptionId = hTelegram.getString("shipping_option_id");
        orderInfo = OrderInfo.getInstance(hTelegram.getJSONObject("order_info"));
        telegramPaymentChargeId = hTelegram.getString("telegram_payment_charge_id");
        providerPaymentChargeId = hTelegram.getString("provider_payment_charge_id");
    }

    /**
     * Method to get {@link #invoicePayload} instance <br>
     * No-any params required
     *
     * @return {@link #invoicePayload} instance as {@link String}
     */
    public String getInvoicePayload() {
        return invoicePayload;
    }

    /**
     * Method to get {@link #shippingOptionId} instance <br>
     * No-any params required
     *
     * @return {@link #shippingOptionId} instance as {@link String}
     */
    public String getShippingOptionId() {
        return shippingOptionId;
    }

    /**
     * Method to get {@link #orderInfo} instance <br>
     * No-any params required
     *
     * @return {@link #orderInfo} instance as {@link OrderInfo}
     */
    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    /**
     * Method to get {@link #telegramPaymentChargeId} instance <br>
     * No-any params required
     *
     * @return {@link #telegramPaymentChargeId} instance as {@link String}
     */
    public String getTelegramPaymentChargeId() {
        return telegramPaymentChargeId;
    }

    /**
     * Method to get {@link #providerPaymentChargeId} instance <br>
     * No-any params required
     *
     * @return {@link #providerPaymentChargeId} instance as {@link String}
     */
    public String getProviderPaymentChargeId() {
        return providerPaymentChargeId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link SuccessfulPayment}
     */
    public static SuccessfulPayment getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new SuccessfulPayment(jItem);
    }

}
