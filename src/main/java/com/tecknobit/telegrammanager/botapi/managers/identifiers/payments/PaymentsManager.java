package com.tecknobit.telegrammanager.botapi.managers.identifiers.payments;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.TelegramIdentifierManager;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records.LabeledPrice;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records.PreCheckoutQuery;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.payments.records.ShippingQuery;
import com.tecknobit.telegrammanager.botapi.records.basetypes.ForceReply;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardRemove;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;

import java.io.IOException;
import java.util.Arrays;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
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

    /**
     * Request to send invoices
     *
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendgame">
     * sendInvoice</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendInvoice")
    public <T> Message sendInvoice(String title, String description, String payload, String providerToken, String currency,
                                   LabeledPrice... prices) throws IOException {
        return sendInvoice(mChatId, title, description, payload, providerToken, currency, LIBRARY_OBJECT, prices);
    }

    /**
     * Request to send invoices
     *
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @param format         :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendgame">
     * sendInvoice</a>
     */
    @RequestPath(method = POST, path = "sendInvoice")
    public <T, L> T sendInvoice(String title, String description, String payload, String providerToken, String currency,
                                ReturnFormat format, LabeledPrice... prices) throws IOException {
        return sendInvoice(mChatId, title, description, payload, providerToken, currency, format, prices);
    }

    /**
     * Request to send invoices
     *
     * @param chatId:        unique identifier for the target chat or username of the target channel
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendgame">
     * sendInvoice</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendInvoice")
    public <T> Message sendInvoice(T chatId, String title, String description, String payload, String providerToken,
                                   String currency, LabeledPrice... prices) throws IOException {
        return sendInvoice(chatId, title, description, payload, providerToken, currency, LIBRARY_OBJECT, prices);
    }

    /**
     * Request to send invoices
     *
     * @param chatId:        unique identifier for the target chat or username of the target channel
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @param format         :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendgame">
     * sendInvoice</a>
     */
    @RequestPath(method = POST, path = "sendInvoice")
    public <T, L> T sendInvoice(L chatId, String title, String description, String payload, String providerToken,
                                String currency, ReturnFormat format, LabeledPrice... prices) throws IOException {
        return sendInvoice(chatId, title, description, payload, providerToken, currency, null, format, prices);
    }

    /**
     * Request to send invoices
     *
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                  (topic) of the forum; for forum supergroups only - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "max_tip_amount"} -> the maximum accepted amount for tips in the smallest
     *                                  units of the currency (integer, not float/double). For example, for a maximum tip
     *                                  of US$ 1.45 pass max_tip_amount = 145. See the exp parameter in currencies.json,
     *                                  it shows the number of digits past the decimal point for each currency (2 for the
     *                                  majority of currencies) - [Integer, default 0]
     *                             </li>
     *                             <li>
     *                                  {@code "suggested_tip_amounts"} -> a JSON-serialized array of suggested amounts of
     *                                  tips in the smallest units of the currency (integer, not float/double). At most 4
     *                                  suggested tip amounts can be specified. The suggested tip amounts must be positive,
     *                                  passed in a strictly increased order and must not exceed
     *                                  max_tip_amount - [Array of Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "start_parameter"} -> unique deep-linking parameter. If left empty, forwarded
     *                                  copies of the sent message will have a Pay button, allowing multiple users to pay
     *                                  directly from the forwarded message, using the same invoice. If non-empty, forwarded
     *                                  copies of the sent message will have a URL button with a deep link to the bot
     *                                  (instead of a Pay button), with the value used as the start parameter - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "provider_data"} -> JSON-serialized data about the invoice, which will be
     *                                  shared with the payment provider. A detailed description of required fields should
     *                                  be provided by the payment provider - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_url"} -> URL of the product photo for the invoice. Can be a photo of
     *                                  the goods or a marketing image for a service. People like it better when they see
     *                                  what they are paying for - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_size"} -> photo size in bytes - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_width"} -> photo width - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_height"} -> photo height - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "need_name"} -> pass True if you require the user's full name to complete
     *                                  the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_phone_number"} -> pass True if you require the user's phone number to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_email"} -> pass True if you require the user's email address to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_shipping_address"} -> pass True if you require the user's shipping
     *                                  address to complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_phone_number_to_provider"} -> pass True if the user's phone number
     *                                  should be sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_email_to_provider"} -> pass True if the user's email address should be
     *                                  sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "is_flexible"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                                  notification with no sound - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "protect_content"} -> protects the contents of the sent message from
     *                                  forwarding and saving - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                                  message - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                                  {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                             </li>
     *                       </ul>
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendgame">
     * sendInvoice</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendInvoice")
    public <T> Message sendInvoice(String title, String description, String payload, String providerToken,
                                   String currency, Params parameters, LabeledPrice... prices) throws IOException {
        return sendInvoice(mChatId, title, description, payload, providerToken, currency, parameters, LIBRARY_OBJECT,
                prices);
    }

    /**
     * Request to send invoices
     *
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                  (topic) of the forum; for forum supergroups only - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "max_tip_amount"} -> the maximum accepted amount for tips in the smallest
     *                                  units of the currency (integer, not float/double). For example, for a maximum tip
     *                                  of US$ 1.45 pass max_tip_amount = 145. See the exp parameter in currencies.json,
     *                                  it shows the number of digits past the decimal point for each currency (2 for the
     *                                  majority of currencies) - [Integer, default 0]
     *                             </li>
     *                             <li>
     *                                  {@code "suggested_tip_amounts"} -> a JSON-serialized array of suggested amounts of
     *                                  tips in the smallest units of the currency (integer, not float/double). At most 4
     *                                  suggested tip amounts can be specified. The suggested tip amounts must be positive,
     *                                  passed in a strictly increased order and must not exceed
     *                                  max_tip_amount - [Array of Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "start_parameter"} -> unique deep-linking parameter. If left empty, forwarded
     *                                  copies of the sent message will have a Pay button, allowing multiple users to pay
     *                                  directly from the forwarded message, using the same invoice. If non-empty, forwarded
     *                                  copies of the sent message will have a URL button with a deep link to the bot
     *                                  (instead of a Pay button), with the value used as the start parameter - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "provider_data"} -> JSON-serialized data about the invoice, which will be
     *                                  shared with the payment provider. A detailed description of required fields should
     *                                  be provided by the payment provider - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_url"} -> URL of the product photo for the invoice. Can be a photo of
     *                                  the goods or a marketing image for a service. People like it better when they see
     *                                  what they are paying for - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_size"} -> photo size in bytes - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_width"} -> photo width - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_height"} -> photo height - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "need_name"} -> pass True if you require the user's full name to complete
     *                                  the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_phone_number"} -> pass True if you require the user's phone number to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_email"} -> pass True if you require the user's email address to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_shipping_address"} -> pass True if you require the user's shipping
     *                                  address to complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_phone_number_to_provider"} -> pass True if the user's phone number
     *                                  should be sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_email_to_provider"} -> pass True if the user's email address should be
     *                                  sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "is_flexible"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                                  notification with no sound - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "protect_content"} -> protects the contents of the sent message from
     *                                  forwarding and saving - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                                  message - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                                  {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                             </li>
     *                       </ul>
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @param format         :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendgame">
     * sendInvoice</a>
     */
    @RequestPath(method = POST, path = "sendInvoice")
    public <T, L> T sendInvoice(String title, String description, String payload, String providerToken, String currency,
                                Params parameters, ReturnFormat format, LabeledPrice... prices) throws IOException {
        return sendInvoice(mChatId, title, description, payload, providerToken, currency, parameters, format,
                prices);
    }

    /**
     * Request to send invoices
     *
     * @param chatId:        unique identifier for the target chat or username of the target channel
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                  (topic) of the forum; for forum supergroups only - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "max_tip_amount"} -> the maximum accepted amount for tips in the smallest
     *                                  units of the currency (integer, not float/double). For example, for a maximum tip
     *                                  of US$ 1.45 pass max_tip_amount = 145. See the exp parameter in currencies.json,
     *                                  it shows the number of digits past the decimal point for each currency (2 for the
     *                                  majority of currencies) - [Integer, default 0]
     *                             </li>
     *                             <li>
     *                                  {@code "suggested_tip_amounts"} -> a JSON-serialized array of suggested amounts of
     *                                  tips in the smallest units of the currency (integer, not float/double). At most 4
     *                                  suggested tip amounts can be specified. The suggested tip amounts must be positive,
     *                                  passed in a strictly increased order and must not exceed
     *                                  max_tip_amount - [Array of Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "start_parameter"} -> unique deep-linking parameter. If left empty, forwarded
     *                                  copies of the sent message will have a Pay button, allowing multiple users to pay
     *                                  directly from the forwarded message, using the same invoice. If non-empty, forwarded
     *                                  copies of the sent message will have a URL button with a deep link to the bot
     *                                  (instead of a Pay button), with the value used as the start parameter - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "provider_data"} -> JSON-serialized data about the invoice, which will be
     *                                  shared with the payment provider. A detailed description of required fields should
     *                                  be provided by the payment provider - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_url"} -> URL of the product photo for the invoice. Can be a photo of
     *                                  the goods or a marketing image for a service. People like it better when they see
     *                                  what they are paying for - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_size"} -> photo size in bytes - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_width"} -> photo width - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_height"} -> photo height - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "need_name"} -> pass True if you require the user's full name to complete
     *                                  the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_phone_number"} -> pass True if you require the user's phone number to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_email"} -> pass True if you require the user's email address to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_shipping_address"} -> pass True if you require the user's shipping
     *                                  address to complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_phone_number_to_provider"} -> pass True if the user's phone number
     *                                  should be sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_email_to_provider"} -> pass True if the user's email address should be
     *                                  sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "is_flexible"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                                  notification with no sound - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "protect_content"} -> protects the contents of the sent message from
     *                                  forwarding and saving - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                                  message - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                                  {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                             </li>
     *                       </ul>
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendgame">
     * sendInvoice</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendInvoice")
    public <T> Message sendInvoice(T chatId, String title, String description, String payload, String providerToken,
                                   String currency, Params parameters, LabeledPrice... prices) throws IOException {
        return sendInvoice(chatId, title, description, payload, providerToken, currency, parameters, LIBRARY_OBJECT,
                prices);
    }

    /**
     * Request to send invoices
     *
     * @param chatId:        unique identifier for the target chat or username of the target channel
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                  (topic) of the forum; for forum supergroups only - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "max_tip_amount"} -> the maximum accepted amount for tips in the smallest
     *                                  units of the currency (integer, not float/double). For example, for a maximum tip
     *                                  of US$ 1.45 pass max_tip_amount = 145. See the exp parameter in currencies.json,
     *                                  it shows the number of digits past the decimal point for each currency (2 for the
     *                                  majority of currencies) - [Integer, default 0]
     *                             </li>
     *                             <li>
     *                                  {@code "suggested_tip_amounts"} -> a JSON-serialized array of suggested amounts of
     *                                  tips in the smallest units of the currency (integer, not float/double). At most 4
     *                                  suggested tip amounts can be specified. The suggested tip amounts must be positive,
     *                                  passed in a strictly increased order and must not exceed
     *                                  max_tip_amount - [Array of Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "start_parameter"} -> unique deep-linking parameter. If left empty, forwarded
     *                                  copies of the sent message will have a Pay button, allowing multiple users to pay
     *                                  directly from the forwarded message, using the same invoice. If non-empty, forwarded
     *                                  copies of the sent message will have a URL button with a deep link to the bot
     *                                  (instead of a Pay button), with the value used as the start parameter - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "provider_data"} -> JSON-serialized data about the invoice, which will be
     *                                  shared with the payment provider. A detailed description of required fields should
     *                                  be provided by the payment provider - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_url"} -> URL of the product photo for the invoice. Can be a photo of
     *                                  the goods or a marketing image for a service. People like it better when they see
     *                                  what they are paying for - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_size"} -> photo size in bytes - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_width"} -> photo width - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_height"} -> photo height - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "need_name"} -> pass True if you require the user's full name to complete
     *                                  the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_phone_number"} -> pass True if you require the user's phone number to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_email"} -> pass True if you require the user's email address to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_shipping_address"} -> pass True if you require the user's shipping
     *                                  address to complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_phone_number_to_provider"} -> pass True if the user's phone number
     *                                  should be sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_email_to_provider"} -> pass True if the user's email address should be
     *                                  sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "is_flexible"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                                  notification with no sound - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "protect_content"} -> protects the contents of the sent message from
     *                                  forwarding and saving - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                                  message - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                                  {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                             </li>
     *                       </ul>
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @param format         :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendgame">
     * sendInvoice</a>
     */
    @RequestPath(method = POST, path = "sendInvoice")
    public <T, L> T sendInvoice(L chatId, String title, String description, String payload, String providerToken,
                                String currency, Params parameters, ReturnFormat format,
                                LabeledPrice... prices) throws IOException {
        return returnMessage(sendPostRequest(SEND_INVOICE_ENDPOINT, createPaymentPayload(chatId, title, description,
                payload, providerToken, currency, parameters, prices)), format);
    }

    /**
     * Request to create a link for an invoice
     *
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @return link for an invoice as {@link String}
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createinvoicelink">
     * createInvoiceLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "createInvoiceLink")
    public String createInvoiceLink(String title, String description, String payload, String providerToken,
                                    String currency, LabeledPrice... prices) throws IOException {
        return createInvoiceLink(title, description, payload, providerToken, currency, null, prices);
    }

    /**
     * Request to create a link for an invoice
     *
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                  (topic) of the forum; for forum supergroups only - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "max_tip_amount"} -> the maximum accepted amount for tips in the smallest
     *                                  units of the currency (integer, not float/double). For example, for a maximum tip
     *                                  of US$ 1.45 pass max_tip_amount = 145. See the exp parameter in currencies.json,
     *                                  it shows the number of digits past the decimal point for each currency (2 for the
     *                                  majority of currencies) - [Integer, default 0]
     *                             </li>
     *                             <li>
     *                                  {@code "suggested_tip_amounts"} -> a JSON-serialized array of suggested amounts of
     *                                  tips in the smallest units of the currency (integer, not float/double). At most 4
     *                                  suggested tip amounts can be specified. The suggested tip amounts must be positive,
     *                                  passed in a strictly increased order and must not exceed
     *                                  max_tip_amount - [Array of Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "start_parameter"} -> unique deep-linking parameter. If left empty, forwarded
     *                                  copies of the sent message will have a Pay button, allowing multiple users to pay
     *                                  directly from the forwarded message, using the same invoice. If non-empty, forwarded
     *                                  copies of the sent message will have a URL button with a deep link to the bot
     *                                  (instead of a Pay button), with the value used as the start parameter - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "provider_data"} -> JSON-serialized data about the invoice, which will be
     *                                  shared with the payment provider. A detailed description of required fields should
     *                                  be provided by the payment provider - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_url"} -> URL of the product photo for the invoice. Can be a photo of
     *                                  the goods or a marketing image for a service. People like it better when they see
     *                                  what they are paying for - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_size"} -> photo size in bytes - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_width"} -> photo width - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "photo_height"} -> photo height - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "need_name"} -> pass True if you require the user's full name to complete
     *                                  the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_phone_number"} -> pass True if you require the user's phone number to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_email"} -> pass True if you require the user's email address to
     *                                  complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "need_shipping_address"} -> pass True if you require the user's shipping
     *                                  address to complete the order - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_phone_number_to_provider"} -> pass True if the user's phone number
     *                                  should be sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "send_email_to_provider"} -> pass True if the user's email address should be
     *                                  sent to provider - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "is_flexible"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                                  notification with no sound - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "protect_content"} -> protects the contents of the sent message from
     *                                  forwarding and saving - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                                  message - [Integer]
     *                             </li>
     *                             <li>
     *                                  {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                                  specified replied-to message is not found - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                                  {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                             </li>
     *                       </ul>
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @return link for an invoice as {@link String}
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createinvoicelink">
     * createInvoiceLink</a>
     */
    @RequestPath(method = POST, path = "createInvoiceLink")
    public String createInvoiceLink(String title, String description, String payload, String providerToken,
                                    String currency, Params parameters, LabeledPrice... prices) throws IOException {
        return sendPostRequest(CREATE_INVOICE_LINK_ENDPOINT, createPaymentPayload(null, title, description,
                payload, providerToken, currency, parameters, prices));
    }

    /**
     * Request to create a payment payload
     *
     * @param chatId:        unique identifier for the target chat or username of the target channel
     * @param title:         product name, 1-32 characters
     * @param description:   product description, 1-255 characters
     * @param payload:       bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your
     *                       internal processes
     * @param providerToken: payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
     * @param currency:      three-letter ISO 4217 currency code
     * @param parameters:    optional parameters of the request
     * @param prices:        price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery
     *                       cost, delivery tax, bonus, etc.)
     * @return payment payload as {@link Params}
     */
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

    /**
     * Method to send an invoice requesting a shipping address and the parameter is_flexible was specified, the Bot API
     * will send an Update with a shipping_query field to the bot. Use this method to reply to shipping queries
     *
     * @param shippingQuery: the query to be answered
     * @param ok:            pass True if delivery to the specified address is possible and False if there are any problems
     *                       (for example, if delivery to the specified address is not possible)
     * @param okItem:        <ul>
     *                                        <li>
     *                                            {@code "shipping_options"} -> required if ok is True. A JSON-serialized array of available shipping options
     *                                        </li>
     *                                        <li>
     *                                            {@code "error_message"} -> required if ok is False. Error message in human readable form
     *                                            that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your
     *                                            desired address is unavailable'). Telegram will display this message to the user
     *                                        </li>
     *                                    </ul>
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answershippingquery">
     * answerShippingQuery</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "answerShippingQuery")
    public <T> boolean answerShippingQuery(ShippingQuery shippingQuery, boolean ok, T okItem) throws IOException {
        return answerShippingQuery(shippingQuery.getId(), ok, okItem);
    }

    /**
     * Method to send an invoice requesting a shipping address and the parameter is_flexible was specified, the Bot API
     * will send an Update with a shipping_query field to the bot. Use this method to reply to shipping queries
     *
     * @param shippingQueryId: unique identifier for the query to be answered
     * @param ok:              pass True if delivery to the specified address is possible and False if there are any problems
     *                         (for example, if delivery to the specified address is not possible)
     * @param okItem:          <ul>
     *                                          <li>
     *                                              {@code "shipping_options"} -> required if ok is True. A JSON-serialized array of available shipping options
     *                                          </li>
     *                                          <li>
     *                                              {@code "error_message"} -> required if ok is False. Error message in human readable form
     *                                              that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your
     *                                              desired address is unavailable'). Telegram will display this message to the user
     *                                          </li>
     *                                      </ul>
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answershippingquery">
     * answerShippingQuery</a>
     */
    @RequestPath(method = POST, path = "answerShippingQuery")
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

    /**
     * Method to respond to such pre-checkout queries <br>
     * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the
     * form of an Update with the field pre_checkout_query
     *
     * @param preCheckoutQuery: the query to be answered
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerprecheckoutquery">
     * answerPreCheckoutQuery</a>
     * @apiNote the Bot API must receive an answer within 10 seconds after the pre-checkout query was sent
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "answerPreCheckoutQuery")
    public <T> boolean answerPreCheckoutQuery(PreCheckoutQuery preCheckoutQuery) throws IOException {
        return answerPreCheckoutQuery(preCheckoutQuery.getId());
    }

    /**
     * Method to respond to such pre-checkout queries <br>
     * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the
     * form of an Update with the field pre_checkout_query
     *
     * @param preCheckoutQueryId: unique identifier for the query to be answered
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerprecheckoutquery">
     * answerPreCheckoutQuery</a>
     * @apiNote the Bot API must receive an answer within 10 seconds after the pre-checkout query was sent
     */
    @RequestPath(method = POST, path = "answerPreCheckoutQuery")
    public <T> boolean answerPreCheckoutQuery(String preCheckoutQueryId) throws IOException {
        return answerPreCheckoutQuery(preCheckoutQueryId, null);
    }

    /**
     * Method to respond to such pre-checkout queries <br>
     * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the
     * form of an Update with the field pre_checkout_query
     *
     * @param preCheckoutQuery: the query to be answered
     * @param errorMessage:     error message in human-readable form that explains the reason for failure to proceed with
     *                          the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while
     *                          you were busy filling out your payment details. Please choose a different color or garment!").
     *                          Telegram will display this message to the user
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerprecheckoutquery">
     * answerPreCheckoutQuery</a>
     * @apiNote the Bot API must receive an answer within 10 seconds after the pre-checkout query was sent
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "answerPreCheckoutQuery")
    public <T> boolean answerPreCheckoutQuery(PreCheckoutQuery preCheckoutQuery, String errorMessage) throws IOException {
        return answerPreCheckoutQuery(preCheckoutQuery.getId(), errorMessage);
    }

    /**
     * Method to respond to such pre-checkout queries <br>
     * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the
     * form of an Update with the field pre_checkout_query
     *
     * @param preCheckoutQueryId: unique identifier for the query to be answered
     * @param errorMessage:       error message in human-readable form that explains the reason for failure to proceed with
     *                            the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while
     *                            you were busy filling out your payment details. Please choose a different color or garment!").
     *                            Telegram will display this message to the user
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerprecheckoutquery">
     * answerPreCheckoutQuery</a>
     * @apiNote the Bot API must receive an answer within 10 seconds after the pre-checkout query was sent
     */
    @RequestPath(method = POST, path = "answerPreCheckoutQuery")
    public <T> boolean answerPreCheckoutQuery(String preCheckoutQueryId, String errorMessage) throws IOException {
        Params payload = new Params();
        payload.addParam("pre_checkout_query_id", preCheckoutQueryId);
        payload.addParam("ok", errorMessage == null);
        payload.addParam("error_message", errorMessage);
        return getBooleanResponse(sendPostRequest(ANSWER_PRE_CHECKOUT_QUERY_ENDPOINT, payload));
    }

}
