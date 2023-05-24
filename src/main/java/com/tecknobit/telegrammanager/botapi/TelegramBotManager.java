package com.tecknobit.telegrammanager.botapi;

import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.apimanager.apis.APIRequest;
import com.tecknobit.apimanager.apis.APIRequest.RequestMethod;

import java.io.IOException;
import java.util.Properties;

import static com.tecknobit.apimanager.apis.APIRequest.DEFAULT_ERROR_RESPONSE;
import static com.tecknobit.apimanager.apis.APIRequest.DEFAULT_REQUEST_TIMEOUT;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static java.lang.Integer.parseInt;

/**
 * The {@code TelegramBotManager} class is useful to format a {@code Telegram}'s bot manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api">
 * Telegram Bot API</a>
 */
public class TelegramBotManager {

    /**
     * {@code BASE_BOT_ENDPOINT} of the {@code Telegram}'s Bot API service
     */
    public static final String BASE_BOT_ENDPOINT = "https://api.telegram.org/bot";

    /**
     * {@code properties} is a local instance used to instantiate a new {@link TelegramBotManager}'s manager without
     * re-insert credentials
     */
    protected static final Properties properties = new Properties();

    /**
     * {@code apiRequest} instance to make the request
     */
    protected final APIRequest apiRequest;

    /**
     * {@code token} the bot unique authentication token
     */
    protected final String token;

    /**
     * Constructor to init {@link TelegramBotManager}
     *
     * @param token:               the bot unique authentication token
     * @param defaultErrorMessage: error message to return if is not request error
     */
    public TelegramBotManager(String token, String defaultErrorMessage) {
        this(token, defaultErrorMessage, DEFAULT_REQUEST_TIMEOUT);
    }

    /**
     * Constructor to init {@link TelegramBotManager}
     *
     * @param token:          the bot unique authentication token
     * @param requestTimeout: timeout for the requests
     */
    public TelegramBotManager(String token, int requestTimeout) {
        this(token, DEFAULT_ERROR_RESPONSE, requestTimeout);
    }

    /**
     * Constructor to init {@link TelegramBotManager}
     *
     * @param token: the bot unique authentication token
     */
    public TelegramBotManager(String token) {
        this(token, DEFAULT_ERROR_RESPONSE, DEFAULT_REQUEST_TIMEOUT);
    }

    /**
     * Constructor to init {@link TelegramBotManager}
     *
     * @param token:               the bot unique authentication token
     * @param defaultErrorMessage: error message to return if is not request error
     * @param requestTimeout:      timeout for the requests
     */
    public TelegramBotManager(String token, String defaultErrorMessage, int requestTimeout) {
        this.token = token;
        apiRequest = new APIRequest(defaultErrorMessage, requestTimeout);
        storeProperties(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init a {@link TelegramBotManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link TelegramBotManager}'s manager without re-insert
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
    public TelegramBotManager() throws Exception {
        token = properties.getProperty("token");
        if (token == null)
            throw new Exception("You need to call a parameterized constructor first");
        apiRequest = new APIRequest(properties.getProperty("defaultErrorResponse", DEFAULT_ERROR_RESPONSE),
                parseInt(properties.getProperty("requestTimeout", DEFAULT_REQUEST_TIMEOUT + "")));
    }

    /**
     * Method to store some properties
     *
     * @param token:               the bot unique authentication token
     * @param defaultErrorMessage: error message to return if is not request error
     * @param requestTimeout:      timeout for the requests
     */
    private void storeProperties(String token, String defaultErrorMessage, int requestTimeout) {
        properties.setProperty("token", token);
        properties.setProperty("defaultErrorMessage", defaultErrorMessage);
        properties.setProperty("requestTimeout", requestTimeout + "");
    }

    /**
     * Method to execute and get response of a POST request
     *
     * @param methodName: the method where make the request
     * @return response of request formatted in JSON as {@link String}
     */
    @Wrapper
    public String sendPostRequest(String methodName) throws IOException {
        return sendPostRequest(methodName, null);
    }

    /**
     * Method to execute and get response of a POST request
     *
     * @param methodName: the method where make the request
     * @param payload:    payload of the request
     * @return response of request formatted in JSON as {@link String}
     */
    public String sendPostRequest(String methodName, Params payload) throws IOException {
        if (payload == null)
            payload = new Params();
        return sendRequest(methodName + payload.createQueryString(), POST);
    }

    /**
     * Method to execute and get response of a GET request
     *
     * @param methodName: the method where make the request
     * @return response of request formatted in JSON as {@link String}
     */
    @Wrapper
    public String sendGETRequest(String methodName) throws IOException {
        return sendGETRequest(methodName, null);
    }

    /**
     * Method to execute and get response of a GET request
     *
     * @param methodName: the method where make the request
     * @param query:      query params of the request
     * @return response of request formatted in JSON as {@link String}
     */
    public String sendGETRequest(String methodName, Params query) throws IOException {
        if (query == null)
            query = new Params();
        return sendRequest(methodName + query.createQueryString(), GET);
    }

    /**
     * Method to execute and get response of a request
     *
     * @param methodName: the method where make the request
     * @param method:     method for the request
     * @return response of request formatted in JSON as {@link String}
     */
    private String sendRequest(String methodName, RequestMethod method) throws IOException {
        apiRequest.sendAPIRequest(BASE_BOT_ENDPOINT + token + "/" + methodName, method);
        return apiRequest.getResponse();
    }

    /**
     * Method to get {@link #token} instance <br>
     * No-any params required
     *
     * @return {@link #token} instance as {@link String}
     */
    public String getToken() {
        return token;
    }

    /**
     * Method to get the error response of the request <br>
     * Any params required
     *
     * @return error response of the request formatted as {@link String}
     */
    public String getErrorResponse() {
        return apiRequest.getErrorResponse();
    }

    /**
     * Method to print the error response of the request <br>
     * Any params required
     */
    public void printErrorResponse() {
        apiRequest.printErrorResponse();
    }

    /**
     * Method to get status response code of the request <br>
     * Any params required
     *
     * @return response code of the request as int
     */
    public int getStatusCode() {
        return apiRequest.getResponseStatusCode();
    }

    /**
     * The {@code Params} class is useful to assemble params values for the request
     *
     * @implNote this class can be used to assemble body payload or query request params
     * @implSpec look this library <a href="https://github.com/N7ghtm4r3/APIManager">here</a>
     * @see APIRequest.Params
     */
    public static class Params extends APIRequest.Params {
    }

}