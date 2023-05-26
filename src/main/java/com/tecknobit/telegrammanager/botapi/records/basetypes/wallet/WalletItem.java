package com.tecknobit.telegrammanager.botapi.records.basetypes.wallet;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code WalletItem} class is useful to format a {@code Telegram}'s wallet item
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *          <a href="https://core.telegram.org/bots/api#invoice">
 *              Invoice</a>
 *     </li>
 *     <li>
 *          <a href="https://core.telegram.org/bots/api#successfulpayment">
 *              SuccessfulPayment</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
@Structure
public abstract class WalletItem extends TelegramType {

    /**
     * {@code currency} three-letter ISO 4217 currency code
     */
    protected final String currency;

    /**
     * {@code totalAmount} total price in the smallest units of the currency (integer, not float/double)
     */
    protected final int totalAmount;

    /**
     * Constructor to init a {@link WalletItem} object
     *
     * @param currency:    three-letter ISO 4217 currency code
     * @param totalAmount: total price in the smallest units of the currency (integer, not float/double)
     */
    public WalletItem(String currency, int totalAmount) {
        super(null);
        this.currency = currency;
        this.totalAmount = totalAmount;
    }

    /**
     * Constructor to init a {@link WalletItem} object
     *
     * @param jWalletItem: wallet item details as {@link JSONObject}
     */
    public WalletItem(JSONObject jWalletItem) {
        super(jWalletItem);
        currency = hTelegram.getString("currency");
        totalAmount = hTelegram.getInt("total_amount");
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
     * Method to get {@link #totalAmount} instance <br>
     * No-any params required
     *
     * @return {@link #totalAmount} instance as int
     */
    public int getTotalAmount() {
        return totalAmount;
    }

}
