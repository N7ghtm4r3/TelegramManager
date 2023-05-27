package com.tecknobit.telegrammanager.botapi.records.basetypes.payments;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code ShippingOption} class is useful to format a {@code Telegram}'s shipping option
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#shippingoption">
 * ShippingOption</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ShippingOption extends TelegramType {

    /**
     * {@code id} shipping option identifier
     */
    private final String id;

    /**
     * {@code title} option title
     */
    private final String title;

    /**
     * {@code prices} list of price portions
     */
    private final ArrayList<LabeledPrice> prices;

    /**
     * Constructor to init a {@link ShippingOption} object
     *
     * @param id:     shipping option identifier
     * @param title:  option title
     * @param prices: list of price portions
     */
    public ShippingOption(String id, String title, ArrayList<LabeledPrice> prices) {
        super(null);
        this.id = id;
        this.title = title;
        this.prices = prices;
    }

    /**
     * Constructor to init a {@link ShippingOption} object
     *
     * @param jShippingOption: shipping option details as {@link JSONObject}
     */
    public ShippingOption(JSONObject jShippingOption) {
        super(jShippingOption);
        id = hTelegram.getString("id");
        title = hTelegram.getString("title");
        prices = LabeledPrice.returnLabeledPrices(hTelegram.getJSONArray("prices"));
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     */
    public String getId() {
        return id;
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
     * Method to get {@link #prices} instance <br>
     * No-any params required
     *
     * @return {@link #prices} instance as {@link ArrayList} of {@link LabeledPrice}
     */
    public ArrayList<LabeledPrice> getPrices() {
        return prices;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ShippingOption}
     */
    public static ShippingOption getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ShippingOption(jItem);
    }

}
