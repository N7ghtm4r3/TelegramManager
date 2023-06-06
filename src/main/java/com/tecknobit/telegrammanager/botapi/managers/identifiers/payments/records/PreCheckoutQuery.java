package com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code PreCheckoutQuery} class is useful to format a {@code Telegram}'s pre checkout query
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#precheckoutquery">
 * PreCheckoutQuery</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see PaymentItem
 */
public class PreCheckoutQuery extends PaymentItem {

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
     * {@code shippingOptionId} identifier of the shipping option chosen by the user
     */
    private final String shippingOptionId;

    /**
     * {@code orderInfo} order information provided by the user
     */
    private final OrderInfo orderInfo;

    /**
     * Constructor to init a {@link PreCheckoutQuery} object
     *
     * @param currency         :    three-letter ISO 4217 currency code
     * @param totalAmount      : total price in the smallest units of the currency (integer, not float/double)
     * @param id               :  unique query identifier
     * @param from             :    user who sent the query
     * @param invoicePayload   :  bot specified invoice payload
     * @param shippingOptionId :identifier of the shipping option chosen by the user
     * @param orderInfo        : order information provided by the user
     */
    public PreCheckoutQuery(String currency, int totalAmount, String id, User from, String invoicePayload,
                            String shippingOptionId, OrderInfo orderInfo) {
        super(currency, totalAmount);
        this.id = id;
        this.from = from;
        this.invoicePayload = invoicePayload;
        this.shippingOptionId = shippingOptionId;
        this.orderInfo = orderInfo;
    }

    /**
     * Constructor to init a {@link PreCheckoutQuery} object
     *
     * @param jPreCheckoutQuery : pre checkout query item details as {@link JSONObject}
     */
    public PreCheckoutQuery(JSONObject jPreCheckoutQuery) {
        super(jPreCheckoutQuery);
        id = hTelegram.getString("id");
        from = new User(hTelegram.getJSONObject("from"));
        invoicePayload = hTelegram.getString("invoice_payload");
        shippingOptionId = hTelegram.getString("shipping_option_id");
        orderInfo = OrderInfo.getInstance(hTelegram.getJSONObject("order_info"));
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
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link PreCheckoutQuery}
     */
    public static PreCheckoutQuery getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new PreCheckoutQuery(jItem);
    }

}
