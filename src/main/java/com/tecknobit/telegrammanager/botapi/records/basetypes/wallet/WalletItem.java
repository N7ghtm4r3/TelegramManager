package com.tecknobit.telegrammanager.botapi.records.basetypes.wallet;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

@Structure
public abstract class WalletItem extends TelegramType {

    protected final String currency;

    protected final int totalAmount;

    public WalletItem(String currency, int totalAmount) {
        super(null);
        this.currency = currency;
        this.totalAmount = totalAmount;
    }

    public WalletItem(JSONObject jWalletItem) {
        super(jWalletItem);
        currency = hTelegram.getString("currency");
        totalAmount = hTelegram.getInt("total_amount");
    }

    public String getCurrency() {
        return currency;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

}
