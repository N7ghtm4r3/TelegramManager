package com.tecknobit.telegrammanager.botapi.records.basetypes.wallet;

import org.json.JSONObject;

public class Invoice extends WalletItem {

    private final String title;

    private final String startParameter;

    public Invoice(String title, String startParameter, String currency, int totalAmount) {
        super(currency, totalAmount);
        this.title = title;
        this.startParameter = startParameter;
    }

    public Invoice(JSONObject jInvoice) {
        super(jInvoice);
        title = hTelegram.getString("title");
        startParameter = hTelegram.getString("start_parameter");
    }

    public String getTitle() {
        return title;
    }

    public String getStartParameter() {
        return startParameter;
    }

    public static Invoice getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Invoice(jItem);
    }

}
