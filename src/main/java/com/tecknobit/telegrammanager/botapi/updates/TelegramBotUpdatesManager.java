package com.tecknobit.telegrammanager.botapi.updates;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.TelegramBotManager;
import com.tecknobit.telegrammanager.botapi.updates.records.Update;
import com.tecknobit.telegrammanager.botapi.updates.records.WebhookInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.TelegramBotManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code TelegramBotUpdatesManager} class is useful to format a {@code Telegram}'s updates manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getting-updates">
 * Getting updates</a>
 * @see TelegramBotManager
 */
public class TelegramBotUpdatesManager extends TelegramBotManager {

    /**
     * {@code GET_UPDATES_ENDPOINT} is constant for GET_UPDATES_ENDPOINT's endpoint
     **/
    public static final String GET_UPDATES_ENDPOINT = "getUpdates";

    /**
     * {@code SET_WEBHOOK_ENDPOINT} is constant for SET_WEBHOOK_ENDPOINT's endpoint
     **/
    public static final String SET_WEBHOOK_ENDPOINT = "setWebhook";

    /**
     * {@code DELETE_WEBHOOK_ENDPOINT} is constant for DELETE_WEBHOOK_ENDPOINT's endpoint
     **/
    public static final String DELETE_WEBHOOK_ENDPOINT = "deleteWebhook";

    /**
     * {@code GET_WEBHOOK_INFO_ENDPOINT} is constant for GET_WEBHOOK_INFO_ENDPOINT's endpoint
     **/
    public static final String GET_WEBHOOK_INFO_ENDPOINT = "getWebhookInfo";

    /**
     * Constructor to init {@link TelegramBotUpdatesManager}
     *
     * @param token               : the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public TelegramBotUpdatesManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link TelegramBotUpdatesManager}
     *
     * @param token          : the bot unique authentication token
     * @param requestTimeout :       timeout for the requests
     */
    public TelegramBotUpdatesManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link TelegramBotUpdatesManager}
     *
     * @param token : the bot unique authentication token
     */
    public TelegramBotUpdatesManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link TelegramBotUpdatesManager}
     *
     * @param token               : the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :       timeout for the requests
     */
    public TelegramBotUpdatesManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init a {@link TelegramBotUpdatesManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link TelegramBotUpdatesManager}'s manager without re-insert
     * the credentials and is useful in those cases if you need to use different manager at the same time:
     * <pre>
     *     {@code
     *        //You need to insert all credentials requested
     *        TelegramBotManager firstManager = new TelegramBotManager("token", "defaultErrorMessage", timeout);
     *        //You don't need to insert all credentials to make manager work
     *        TelegramBotManager secondManager = new TelegramBotManager(); //same credentials used
     *     }
     * </pre>
     */
    public TelegramBotUpdatesManager() throws Exception {
        super();
    }

    /**
     * Request to receive incoming updates using long polling (wiki) <br>
     * No-any params required
     *
     * @return list of updates as {@link ArrayList} of {@link Update} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getupdates">
     * getUpdates</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "getUpdates")
    public ArrayList<Update> getUpdates() throws IOException {
        return getUpdates(LIBRARY_OBJECT);
    }

    /**
     * Request to receive incoming updates using long polling (wiki)
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return list of updates as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getupdates">
     * getUpdates</a>
     **/
    @RequestPath(method = GET, path = "getUpdates")
    public <T> T getUpdates(ReturnFormat format) throws IOException {
        return getUpdates(null, format);
    }

    /**
     * Request to receive incoming updates using long polling (wiki)
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "offset"} -> identifier of the first update to be returned. Must be greater
     *                               by one than the highest among the identifiers of previously received updates - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "limit"} -> limits the number of updates to be retrieved. Values between
     *                               1-100 are accepted - [Integer, default 100]
     *                          </li>
     *                          <li>
     *                               {@code "timeout"} -> timeout in seconds for long polling. Defaults to 0, i.e. usual
     *                               short polling. Should be positive, short polling should be used for testing
     *                               purposes only - [Integer, default 0]
     *                          </li>
     *                          <li>
     *                               {@code "allowed_updates"} -> list of the update types you want your bot to
     *                               receive - [Array of String]
     *                          </li>
     *                    </ul>
     * @return list of updates as {@link ArrayList} of {@link Update} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getupdates">
     * getUpdates</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "getUpdates")
    public ArrayList<Update> getUpdates(Params parameters) throws IOException {
        return getUpdates(parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to receive incoming updates using long polling (wiki)
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "offset"} -> identifier of the first update to be returned. Must be greater
     *                               by one than the highest among the identifiers of previously received updates - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "limit"} -> limits the number of updates to be retrieved. Values between
     *                               1-100 are accepted - [Integer, default 100]
     *                          </li>
     *                          <li>
     *                               {@code "timeout"} -> timeout in seconds for long polling. Defaults to 0, i.e. usual
     *                               short polling. Should be positive, short polling should be used for testing
     *                               purposes only - [Integer, default 0]
     *                          </li>
     *                          <li>
     *                               {@code "allowed_updates"} -> list of the update types you want your bot to
     *                               receive - [Array of String]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return list of updates as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getupdates">
     * getUpdates</a>
     **/
    @Returner
    @RequestPath(method = GET, path = "getUpdates")
    public <T> T getUpdates(Params parameters, ReturnFormat format) throws IOException {
        JSONArray result = getResultFromList(sendGETRequest(GET_UPDATES_ENDPOINT, parameters));
        switch (format) {
            case JSON -> {
                return (T) result;
            }
            case LIBRARY_OBJECT -> {
                ArrayList<Update> updates = new ArrayList<>();
                for (int j = 0; j < result.length(); j++)
                    updates.add(new Update(result.getJSONObject(j)));
                return (T) updates;
            }
            default -> {
                return (T) result.toString();
            }
        }
    }

    /**
     * Request to specify a URL and receive incoming updates via an outgoing webhook
     *
     * @param url: HTTPS URL to send updates to. Use an empty string to remove webhook integration
     * @return update as {@link Update} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setwebhook">
     * setWebhook</a>
     **/
    @Wrapper
    @RequestPath(method = POST, path = "setWebhook")
    public Update setWebhook(String url) throws IOException {
        return setWebhook(url, LIBRARY_OBJECT);
    }

    /**
     * Request to specify a URL and receive incoming updates via an outgoing webhook
     *
     * @param url:    HTTPS URL to send updates to. Use an empty string to remove webhook integration
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return update as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setwebhook">
     * setWebhook</a>
     **/
    @RequestPath(method = POST, path = "setWebhook")
    public <T> T setWebhook(String url, ReturnFormat format) throws IOException {
        return setWebhook(url, null, format);
    }

    /**
     * Request to specify a URL and receive incoming updates via an outgoing webhook
     *
     * @param url:        HTTPS URL to send updates to. Use an empty string to remove webhook integration
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "certificate"} -> pload your public key certificate so that the root
     *                               certificate in use can be checked - [<a href="https://core.telegram.org/bots/api#inputfile">InputFile</a>]
     *                          </li>
     *                          <li>
     *                               {@code "ip_address"} -> the fixed IP address which will be used to send webhook
     *                               requests instead of the IP address resolved through DNS - [String]
     *                          </li>
     *                          <li>
     *                               {@code "max_connections"} -> the maximum allowed number of simultaneous HTTPS
     *                               connections to the webhook for update delivery, 1-100. Defaults to 40. Use lower
     *                               values to limit the load on your bot's server, and higher values to increase your
     *                               bot's throughput - [Integer, default 40]
     *                          </li>
     *                          <li>
     *                               {@code "allowed_updates"} -> list of the update types you want your bot to
     *                               receive - [Array of String]
     *                          </li>
     *                          <li>
     *                               {@code "drop_pending_updates"} -> pass True to drop all pending updates - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "secret_token"} -> a secret token to be sent in a header
     *                               "X-Telegram-Bot-Api-Secret-Token" in every webhook request, 1-256 characters.
     *                               Only characters A-Z, a-z, 0-9, _ and - are allowed. The header is useful to ensure
     *                               that the request comes from a webhook set by you - [String]
     *                          </li>
     *                    </ul>
     * @return update as {@link Update} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setwebhook">
     * setWebhook</a>
     **/
    @Wrapper
    @RequestPath(method = POST, path = "setWebhook")
    public Update setWebhook(String url, Params parameters) throws IOException {
        return setWebhook(url, LIBRARY_OBJECT);
    }

    /**
     * Request to specify a URL and receive incoming updates via an outgoing webhook
     *
     * @param url:        HTTPS URL to send updates to. Use an empty string to remove webhook integration
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "certificate"} -> pload your public key certificate so that the root
     *                               certificate in use can be checked - [<a href="https://core.telegram.org/bots/api#inputfile">InputFile</a>]
     *                          </li>
     *                          <li>
     *                               {@code "ip_address"} -> the fixed IP address which will be used to send webhook
     *                               requests instead of the IP address resolved through DNS - [String]
     *                          </li>
     *                          <li>
     *                               {@code "max_connections"} -> the maximum allowed number of simultaneous HTTPS
     *                               connections to the webhook for update delivery, 1-100. Defaults to 40. Use lower
     *                               values to limit the load on your bot's server, and higher values to increase your
     *                               bot's throughput - [Integer, default 40]
     *                          </li>
     *                          <li>
     *                               {@code "allowed_updates"} -> list of the update types you want your bot to
     *                               receive - [Array of String]
     *                          </li>
     *                          <li>
     *                               {@code "drop_pending_updates"} -> pass True to drop all pending updates - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "secret_token"} -> a secret token to be sent in a header
     *                               "X-Telegram-Bot-Api-Secret-Token" in every webhook request, 1-256 characters.
     *                               Only characters A-Z, a-z, 0-9, _ and - are allowed. The header is useful to ensure
     *                               that the request comes from a webhook set by you - [String]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return update as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setwebhook">
     * setWebhook</a>
     **/
    @Returner
    @RequestPath(method = POST, path = "setWebhook")
    public <T> T setWebhook(String url, Params parameters, ReturnFormat format) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("url", url);
        String updateResponse = sendPostRequest(SET_WEBHOOK_ENDPOINT, parameters);
        return switch (format) {
            case JSON -> (T) new JSONObject(updateResponse);
            case LIBRARY_OBJECT -> (T) new Update(new JSONObject(updateResponse));
            default -> (T) updateResponse;
        };
    }

    /**
     * Method to remove webhook integration if you decide to switch back to {@link #getUpdates}
     *
     * @param dropPendingUpdates: pass True to drop all pending updates
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} and error printed with {@link #printErrorResponse()} method if not successful
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletewebhook">
     * deleteWebhook</a>
     **/
    @WrappedRequest
    @RequestPath(method = POST, path = "deleteWebhook")

    public boolean deleteWebhook(boolean dropPendingUpdates) {
        try {
            Params payload = new Params();
            payload.addParam("drop_pending_updates", dropPendingUpdates);
            sendPostRequest(DELETE_WEBHOOK_ENDPOINT, payload);
            return true;
        } catch (IOException e) {
            printErrorResponse();
            return false;
        }
    }

    /**
     * Request to get current webhook status <br>
     * No-any params required
     *
     * @return webhook info as {@link WebhookInfo} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getwebhookinfo">
     * getWebhookInfo</a>
     **/
    @Wrapper
    @RequestPath(method = GET, path = "getWebhookInfo")
    public WebhookInfo getWebhookInfo() throws IOException {
        return getWebhookInfo(LIBRARY_OBJECT);
    }

    /**
     * Request to get current webhook status
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return webhook info as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getwebhookinfo">
     * getWebhookInfo</a>
     **/
    @Returner
    @RequestPath(method = GET, path = "getWebhookInfo")
    public <T> T getWebhookInfo(ReturnFormat format) throws IOException {
        String infoResponse = sendGETRequest(GET_WEBHOOK_INFO_ENDPOINT);
        return switch (format) {
            case JSON -> (T) new JSONObject(infoResponse);
            case LIBRARY_OBJECT -> (T) new WebhookInfo(new JSONObject(infoResponse));
            default -> (T) infoResponse;
        };
    }

}
