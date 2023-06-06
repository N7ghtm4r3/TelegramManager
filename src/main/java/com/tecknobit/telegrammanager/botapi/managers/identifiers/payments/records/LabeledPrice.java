package com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code LabeledPrice} class is useful to format a {@code Telegram}'s labeled price
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#labeledprice">
 * LabeledPrice</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class LabeledPrice extends TelegramType {

    /**
     * {@code label} portion label
     */
    private final String label;

    /**
     * {@code amount} price of the product in the smallest units of the currency (integer, not float/double)
     */
    private final int amount;

    /**
     * Constructor to init a {@link LabeledPrice} object
     *
     * @param label:  portion label
     * @param amount: price of the product in the smallest units of the currency (integer, not float/double)
     */
    public LabeledPrice(String label, int amount) {
        super(null);
        this.label = label;
        this.amount = amount;
    }

    /**
     * Constructor to init a {@link LabeledPrice} object
     *
     * @param jLabeledPrice: labeled price details as {@link JSONObject}
     */
    public LabeledPrice(JSONObject jLabeledPrice) {
        super(jLabeledPrice);
        label = hTelegram.getString("label");
        amount = hTelegram.getInt("amount");
    }

    /**
     * Method to get {@link #label} instance <br>
     * No-any params required
     *
     * @return {@link #label} instance as {@link String}
     */
    public String getLabel() {
        return label;
    }

    /**
     * Method to get {@link #amount} instance <br>
     * No-any params required
     *
     * @return {@link #amount} instance as int
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Method to return a {@link LabeledPrice} list
     *
     * @param jLabeledPrices: JSON source from fetch the list
     * @return labeled prices list as {@link ArrayList} of {@link LabeledPrice}
     */
    @Returner
    public static ArrayList<LabeledPrice> returnLabeledPrices(JSONArray jLabeledPrices) {
        ArrayList<LabeledPrice> labeledPrices = new ArrayList<>();
        if (jLabeledPrices != null)
            for (int j = 0; j < jLabeledPrices.length(); j++)
                labeledPrices.add(new LabeledPrice(jLabeledPrices.getJSONObject(j)));
        return labeledPrices;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link LabeledPrice}
     */
    public static LabeledPrice getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new LabeledPrice(jItem);
    }

}
