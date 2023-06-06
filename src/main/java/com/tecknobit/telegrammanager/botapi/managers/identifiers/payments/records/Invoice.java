package com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code Invoice} class is useful to format a {@code Telegram}'s invoice
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#invoice">
 * Invoice</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PaymentItem
 */
public class Invoice extends PaymentItem {

    /**
     * {@code title} of the
     */
    private final String title;

    /**
     * {@code startParameter} of the
     */
    private final String startParameter;

    /**
     * Constructor to init a {@link Invoice} object
     *
     * @param currency        : three-letter ISO 4217 currency code
     * @param totalAmount     : total price in the smallest units of the currency (integer, not float/double)
     * @param title:          product name
     * @param startParameter: unique bot deep-linking parameter that can be used to generate this invoice
     */
    public Invoice(String currency, int totalAmount, String title, String startParameter) {
        super(currency, totalAmount);
        this.title = title;
        this.startParameter = startParameter;
    }

    /**
     * Constructor to init a {@link Invoice} object
     *
     * @param jInvoice: invoice details as {@link JSONObject}
     */
    public Invoice(JSONObject jInvoice) {
        super(jInvoice);
        title = hTelegram.getString("title");
        startParameter = hTelegram.getString("start_parameter");
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
     * Method to get {@link #startParameter} instance <br>
     * No-any params required
     *
     * @return {@link #startParameter} instance as {@link String}
     */
    public String getStartParameter() {
        return startParameter;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Invoice}
     */
    public static Invoice getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Invoice(jItem);
    }

}
