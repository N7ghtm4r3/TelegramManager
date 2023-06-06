package com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.ShippingAddress;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ShippingQuery} class is useful to format a {@code Telegram}'s shipping query
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#shippingquery">
 * ShippingQuery</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ShippingQuery extends TelegramType {

    /**
     * {@code id} unique query identifier
     */
    private final String id;

    /**
     * {@code from} user who sent the query
     */
    private final User from;

    /**
     * {@code invoicePayload} bot specified invoice payload
     */
    private final String invoicePayload;

    /**
     * {@code shippingAddress} user specified shipping address
     */
    private final ShippingAddress shippingAddress;

    /**
     * Constructor to init a {@link ShippingQuery} object
     *
     * @param id:              unique query identifier
     * @param from:            user who sent the query
     * @param invoicePayload:  bot specified invoice payload
     * @param shippingAddress: user specified shipping address
     */
    public ShippingQuery(String id, User from, String invoicePayload, ShippingAddress shippingAddress) {
        super(null);
        this.id = id;
        this.from = from;
        this.invoicePayload = invoicePayload;
        this.shippingAddress = shippingAddress;
    }

    /**
     * Constructor to init a {@link ShippingQuery} object
     *
     * @param jShippingQuery: shipping query details as {@link JSONObject}
     */
    public ShippingQuery(JSONObject jShippingQuery) {
        super(jShippingQuery);
        id = hTelegram.getString("id");
        from = new User(hTelegram.getJSONObject("from"));
        invoicePayload = hTelegram.getString("invoice_payload");
        shippingAddress = new ShippingAddress(hTelegram.getJSONObject("shipping_address"));
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
     * Method to get {@link #from} instance <br>
     * No-any params required
     *
     * @return {@link #from} instance as {@link User}
     */
    public User getFrom() {
        return from;
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
     * Method to get {@link #shippingAddress} instance <br>
     * No-any params required
     *
     * @return {@link #shippingAddress} instance as {@link ShippingAddress}
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ShippingQuery}
     */
    public static ShippingQuery getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ShippingQuery(jItem);
    }

}
