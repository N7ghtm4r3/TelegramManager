package com.tecknobit.telegrammanager.botapi.managers.identifiers;

import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat;

import java.io.IOException;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;

/**
 * The {@code TelegramIdentifierManager} class is useful to create a {@code Telegram}'s identifier bot manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api">
 * Telegram Bot API</a>
 */
public class TelegramIdentifierManager extends TelegramManager {

    /**
     * {@code mChatId} unique identifier for the target chat or username of the target channel
     *
     * @apiNote useful to avoid every time to pass the chat identifier in each method
     */
    protected Object mChatId;

    /**
     * Constructor to init {@link TelegramIdentifierManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public TelegramIdentifierManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link TelegramIdentifierManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public TelegramIdentifierManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link TelegramIdentifierManager}
     *
     * @param token : the bot unique authentication token
     */
    public TelegramIdentifierManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link TelegramIdentifierManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public TelegramIdentifierManager(String token, String defaultErrorMessage, int requestTimeout) {
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
    public TelegramIdentifierManager() throws Exception {
        super();
        mChatId = properties.getProperty("mChatId");
    }

    /**
     * Method to execute and get response of an upload media request
     *
     * @param methodName: the method where make the request
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param mediaType:  type of the media to send
     * @param mediaValue: the media to send
     * @param payload:    payload of the request
     * @return response of request formatted in JSON as {@link String}
     */
    protected <T> String uploadMedia(String methodName, T chatId, T mediaType, T mediaValue,
                                     Params payload) throws IOException {
        payload = createChatIdPayload(chatId, payload);
        payload.addParam(mediaType.toString(), mediaValue);
        apiRequest.sendAPIRequest(BASE_BOT_ENDPOINT + token + "/" + methodName + payload.createQueryString(),
                POST, "Content-Type", "multipart/form-data");
        return apiRequest.getResponse();
    }

    /**
     * Method to create a chat identifier payload
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param parameters: other request parameters
     * @return payload as {@link Params}
     */
    protected <T> Params createChatIdPayload(T chatId, Params parameters) {
        if (parameters == null)
            parameters = new Params();
        if (chatId != null)
            parameters.addParam("chat_id", getChatId(chatId));
        return parameters;
    }

    /**
     * Method to fetch from the generic type parameter the chat identifier
     *
     * @param chatId: generic type parameter from fetch the chat identifier
     * @return chat identifier as {@link T}
     */
    protected <T> T getChatId(T chatId) {
        if (chatId instanceof Chat)
            return (T) ("" + ((Chat) chatId).getId());
        return chatId;
    }

    /**
     * Method to get {@link #mChatId} instance <br>
     * No-any params required
     *
     * @return {@link #mChatId} instance as {@link T}
     */
    public <T> T getChatId() {
        return (T) mChatId;
    }

    /**
     * Method to set {@link #mChatId} instance
     *
     * @param mChatId: chat id value to set
     */
    public <T> void setLocalChatId(T mChatId) {
        this.mChatId = mChatId;
    }

    /**
     * Method to set {@link #mChatId} instance and save as <b>global</b>
     *
     * @param mChatId: chat id value to set and save
     * @apiNote <b>global</b> means that all the other managers will have the same {@link #mChatId} overwritten the past
     * value
     */
    public <T> void setGlobalChatId(T mChatId) {
        this.mChatId = mChatId;
        if (mChatId != null)
            properties.put("mChatId", getChatId(mChatId));
        else
            properties.remove("mChatId");
    }

}
