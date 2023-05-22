package com.tecknobit.telegrammanager.botapi;

import com.tecknobit.apimanager.apis.APIRequest;
import com.tecknobit.apimanager.apis.APIRequest.RequestMethod;

import java.io.IOException;
import java.util.Properties;

import static com.tecknobit.apimanager.apis.APIRequest.DEFAULT_ERROR_RESPONSE;
import static com.tecknobit.apimanager.apis.APIRequest.DEFAULT_REQUEST_TIMEOUT;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static java.lang.Integer.parseInt;

//https://schema.horner.tj/#!/
public class TelegramBotManager {

    //https://core.telegram.org/bots/api
    public static final String BASE_BOT_ENDPOINT = "https://api.telegram.org/bot";
    protected static final Properties properties = new Properties();
    protected final APIRequest apiRequest;
    protected final String token;

    public TelegramBotManager(String token, String defaultErrorMessage) {
        this(token, defaultErrorMessage, DEFAULT_REQUEST_TIMEOUT);
    }

    public TelegramBotManager(String token, int requestTimeout) {
        this(token, DEFAULT_ERROR_RESPONSE, requestTimeout);
    }

    public TelegramBotManager(String token) {
        this(token, DEFAULT_ERROR_RESPONSE, DEFAULT_REQUEST_TIMEOUT);
    }

    public TelegramBotManager(String token, String defaultErrorMessage, int requestTimeout) {
        this.token = token;
        apiRequest = new APIRequest(defaultErrorMessage, requestTimeout);
        storeProperties(token, defaultErrorMessage, requestTimeout);
    }

    public TelegramBotManager() throws Exception {
        token = properties.getProperty("token");
        if (token == null)
            throw new Exception("You need to call a parameterized constructor first");
        apiRequest = new APIRequest(properties.getProperty("defaultErrorResponse", DEFAULT_ERROR_RESPONSE),
                parseInt(properties.getProperty("requestTimeout", DEFAULT_REQUEST_TIMEOUT + "")));
    }

    private void storeProperties(String token, String defaultErrorResponse, int requestTimeout) {
        properties.setProperty("token", token);
        properties.setProperty("defaultErrorResponse", defaultErrorResponse);
        properties.setProperty("requestTimeout", requestTimeout + "");
    }

    public String getToken() {
        return token;
    }

    public String sendPostRequest(String methodName) throws IOException {
        return sendPostRequest(methodName, null);
    }

    public String sendPostRequest(String methodName, Params payload) throws IOException {
        if (payload == null)
            payload = new Params();
        return sendRequest(methodName + payload.createQueryString(), POST);
    }

    public String sendGETRequest(String methodName) throws IOException {
        return sendGETRequest(methodName, null);
    }

    public String sendGETRequest(String methodName, Params query) throws IOException {
        if (query == null)
            query = new Params();
        return sendRequest(methodName + query.createQueryString(), GET);
    }

    private String sendRequest(String methodName, RequestMethod method) throws IOException {
        apiRequest.sendAPIRequest(BASE_BOT_ENDPOINT + token + "/" + methodName, method);
        return apiRequest.getResponse();
    }

    public String getErrorResponse() {
        return apiRequest.getErrorResponse();
    }

    public void printErrorResponse() {
        apiRequest.printErrorResponse();
    }

    public int getStatusCode() {
        return apiRequest.getResponseStatusCode();
    }

    public static class Params extends APIRequest.Params {
    }

}
