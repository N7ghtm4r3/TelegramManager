package com.tecknobit.telegrammanager.botapi.managers.identifiers.payments;

import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.TelegramIdentifierManager;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records.LabeledPrice;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records.PreCheckoutQuery;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records.ShippingQuery;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;

import java.io.IOException;
import java.util.Arrays;

import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message.returnMessage;

/**
 * The {@code PaymentsManager} class is useful to create a {@code Telegram}'s bot payments manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#payments">
 * Payments</a>
 * @see TelegramManager
 * @see TelegramIdentifierManager
 */
public class PaymentsManager extends TelegramIdentifierManager {

    /**
     * {@code SEND_INVOICE_ENDPOINT} is constant for SEND_INVOICE_ENDPOINT's endpoint
     */
    public static final String SEND_INVOICE_ENDPOINT = "sendInvoice";

    /**
     * {@code CREATE_INVOICE_LINK_ENDPOINT} is constant for CREATE_INVOICE_LINK_ENDPOINT's endpoint
     */
    public static final String CREATE_INVOICE_LINK_ENDPOINT = "createInvoiceLink";

    /**
     * {@code ANSWER_SHIPPING_QUERY_ENDPOINT} is constant for ANSWER_SHIPPING_QUERY_ENDPOINT's endpoint
     */
    public static final String ANSWER_SHIPPING_QUERY_ENDPOINT = "answerShippingQuery";

    /**
     * {@code ANSWER_PRE_CHECKOUT_QUERY_ENDPOINT} is constant for ANSWER_PRE_CHECKOUT_QUERY_ENDPOINT's endpoint
     */
    public static final String ANSWER_PRE_CHECKOUT_QUERY_ENDPOINT = "answerPreCheckoutQuery";

    /**
     * Constructor to init {@link TelegramIdentifierManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public PaymentsManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link TelegramIdentifierManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public PaymentsManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link TelegramIdentifierManager}
     *
     * @param token : the bot unique authentication token
     */
    public PaymentsManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link TelegramIdentifierManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public PaymentsManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link TelegramIdentifierManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link TelegramIdentifierManager}'s manager without re-insert
     * the credentials and is useful in those cases if you need to use different manager at the same time:
     * <pre>
     *     {@code
     *        //You need to insert all credentials requested
     *        TelegramManager firstManager = new TelegramManager("token", "defaultErrorMessage", timeout);
     *        //You don't need to insert all credentials to make manager work
     *        TelegramManager secondManager = new TelegramManager(); //same credentials used
     *     }
     * </pre>
     */
    public PaymentsManager() throws Exception {
        super();
    }

    public <T> Message sendInvoice(String title, String description, String payload, String providerToken, String currency,
                                   LabeledPrice... prices) throws IOException {
        return sendInvoice(mChatId, title, description, payload, providerToken, currency, LIBRARY_OBJECT, prices);
    }

    public <T, L> T sendInvoice(String title, String description, String payload, String providerToken, String currency,
                                ReturnFormat format, LabeledPrice... prices) throws IOException {
        return sendInvoice(mChatId, title, description, payload, providerToken, currency, format, prices);
    }

    public <T> Message sendInvoice(T chatId, String title, String description, String payload, String providerToken,
                                   String currency, LabeledPrice... prices) throws IOException {
        return sendInvoice(chatId, title, description, payload, providerToken, currency, LIBRARY_OBJECT, prices);
    }

    public <T, L> T sendInvoice(L chatId, String title, String description, String payload, String providerToken,
                                String currency, ReturnFormat format, LabeledPrice... prices) throws IOException {
        return sendInvoice(chatId, title, description, payload, providerToken, currency, null, format, prices);
    }

    public <T> Message sendInvoice(String title, String description, String payload, String providerToken,
                                   String currency, Params parameters, LabeledPrice... prices) throws IOException {
        return sendInvoice(mChatId, title, description, payload, providerToken, currency, parameters, LIBRARY_OBJECT,
                prices);
    }

    public <T, L> T sendInvoice(String title, String description, String payload, String providerToken, String currency,
                                Params parameters, ReturnFormat format, LabeledPrice... prices) throws IOException {
        return sendInvoice(mChatId, title, description, payload, providerToken, currency, parameters, format,
                prices);
    }

    public <T> Message sendInvoice(T chatId, String title, String description, String payload, String providerToken,
                                   String currency, Params parameters, LabeledPrice... prices) throws IOException {
        return sendInvoice(chatId, title, description, payload, providerToken, currency, parameters, LIBRARY_OBJECT,
                prices);
    }

    public <T, L> T sendInvoice(L chatId, String title, String description, String payload, String providerToken,
                                String currency, Params parameters, ReturnFormat format,
                                LabeledPrice... prices) throws IOException {
        return returnMessage(sendPostRequest(SEND_INVOICE_ENDPOINT, createPaymentPayload(chatId, title, description,
                payload, providerToken, currency, parameters, prices)), format);
    }

    public String createInvoiceLink(String title, String description, String payload, String providerToken,
                                    String currency, LabeledPrice... prices) throws IOException {
        return createInvoiceLink(title, description, payload, providerToken, currency, null, prices);
    }

    public String createInvoiceLink(String title, String description, String payload, String providerToken,
                                    String currency, Params parameters, LabeledPrice... prices) throws IOException {
        return sendPostRequest(CREATE_INVOICE_LINK_ENDPOINT, createPaymentPayload(null, title, description,
                payload, providerToken, currency, parameters, prices));
    }

    private <T> Params createPaymentPayload(T chatId, String title, String description, String payload,
                                            String providerToken, String currency, Params parameters,
                                            LabeledPrice... prices) {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("title", title);
        parameters.addParam("description", description);
        parameters.addParam("payload", payload);
        parameters.addParam("provider_token", providerToken);
        parameters.addParam("currency", currency);
        parameters.addParam("prices", Arrays.toString(prices));
        return parameters;
    }

    public <T> boolean answerShippingQuery(ShippingQuery shippingQuery, boolean ok, T okItem) throws IOException {
        return answerShippingQuery(shippingQuery.getId(), ok, okItem);
    }

    public <T> boolean answerShippingQuery(String shippingQueryId, boolean ok, T okItem) throws IOException {
        Params payload = new Params();
        payload.addParam("shipping_query_id", shippingQueryId);
        payload.addParam("ok", ok);
        String itemKey = "shipping_options";
        if (!ok)
            itemKey = "error_message";
        payload.addParam(itemKey, okItem);
        return getBooleanResponse(sendPostRequest(ANSWER_SHIPPING_QUERY_ENDPOINT, payload));
    }

    public <T> boolean answerPreCheckoutQuery(PreCheckoutQuery preCheckoutQuery) throws IOException {
        return answerPreCheckoutQuery(preCheckoutQuery.getId());
    }

    public <T> boolean answerPreCheckoutQuery(String preCheckoutQueryId) throws IOException {
        return answerPreCheckoutQuery(preCheckoutQueryId, null);
    }

    public <T> boolean answerPreCheckoutQuery(PreCheckoutQuery preCheckoutQuery, String errorMessage) throws IOException {
        return answerPreCheckoutQuery(preCheckoutQuery.getId(), errorMessage);
    }

    public <T> boolean answerPreCheckoutQuery(String preCheckoutQueryId, String errorMessage) throws IOException {
        Params payload = new Params();
        payload.addParam("pre_checkout_query_id", preCheckoutQueryId);
        payload.addParam("ok", errorMessage == null);
        payload.addParam("error_message", errorMessage);
        return getBooleanResponse(sendPostRequest(ANSWER_PRE_CHECKOUT_QUERY_ENDPOINT, payload));
    }

}
