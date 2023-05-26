package com.tecknobit.telegrammanager.botapi.records.basetypes.wallet;

import org.json.JSONObject;

public class SuccessfulPayment extends WalletItem {

    private final String invoicePayload;

    private final String shippingOptionId;

    private final OrderInfo orderInfo;

    private final String telegramPaymentChargeId;

    private final String providerPaymentChargeId;

    public SuccessfulPayment(String currency, int totalAmount, String invoicePayload, String shippingOptionId,
                             OrderInfo orderInfo, String telegramPaymentChargeId, String providerPaymentChargeId) {
        super(currency, totalAmount);
        this.invoicePayload = invoicePayload;
        this.shippingOptionId = shippingOptionId;
        this.orderInfo = orderInfo;
        this.telegramPaymentChargeId = telegramPaymentChargeId;
        this.providerPaymentChargeId = providerPaymentChargeId;
    }

    public SuccessfulPayment(JSONObject jSuccessfulPayment) {
        super(jSuccessfulPayment);
        invoicePayload = hTelegram.getString("invoice_payload");
        shippingOptionId = hTelegram.getString("shipping_option_id");
        orderInfo = OrderInfo.getInstance(hTelegram.getJSONObject("order_info"));
        telegramPaymentChargeId = hTelegram.getString("telegram_payment_charge_id");
        providerPaymentChargeId = hTelegram.getString("provider_payment_charge_id");
    }

    public String getInvoicePayload() {
        return invoicePayload;
    }

    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public String getTelegramPaymentChargeId() {
        return telegramPaymentChargeId;
    }

    public String getProviderPaymentChargeId() {
        return providerPaymentChargeId;
    }

    public static SuccessfulPayment getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new SuccessfulPayment(jItem);
    }

}
