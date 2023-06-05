package com.tecknobit.telegrammanager.botapi.managers.identifiers;

import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;

import java.io.IOException;

import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message.returnMessage;

/**
 * The {@code UpdatingMessagesManager} class is useful to create a {@code Telegram}'s bot updating messages manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#updating-messages">
 * Updating messages</a>
 * @see TelegramManager
 * @see TelegramIdentifierManager
 */
public class UpdatingMessagesManager extends TelegramIdentifierManager {

    /**
     * {@code EDIT_MESSAGE_TEXT_ENDPOINT} is constant for EDIT_MESSAGE_TEXT_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_TEXT_ENDPOINT = "editMessageText";

    /**
     * {@code EDIT_MESSAGE_CAPTION_ENDPOINT} is constant for EDIT_MESSAGE_CAPTION_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_CAPTION_ENDPOINT = "editMessageCaption";

    /**
     * {@code EDIT_MESSAGE_MEDIA_ENDPOINT} is constant for EDIT_MESSAGE_MEDIA_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_MEDIA_ENDPOINT = "editMessageMedia";

    /**
     * {@code EDIT_MESSAGE_LIVE_LOCATION_ENDPOINT} is constant for EDIT_MESSAGE_LIVE_LOCATION_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_LIVE_LOCATION_ENDPOINT = "editMessageLiveLocation";

    /**
     * {@code STOP_MESSAGE_LIVE_LOCATION_ENDPOINT} is constant for STOP_MESSAGE_LIVE_LOCATION_ENDPOINT's endpoint
     */
    public static final String STOP_MESSAGE_LIVE_LOCATION_ENDPOINT = "stopMessageLiveLocation";

    /**
     * {@code EDIT_MESSAGE_REPLY_MARKUP_ENDPOINT} is constant for EDIT_MESSAGE_REPLY_MARKUP_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_REPLY_MARKUP_ENDPOINT = "editMessageReplyMarkup";

    /**
     * {@code STOP_POLL_ENDPOINT} is constant for STOP_POLL_ENDPOINT's endpoint
     */
    public static final String STOP_POLL_ENDPOINT = "stopPoll";

    /**
     * {@code DELETE_MESSAGE_ENDPOINT} is constant for DELETE_MESSAGE_ENDPOINT's endpoint
     */
    public static final String DELETE_MESSAGE_ENDPOINT = "deleteMessage";

    /**
     * Constructor to init {@link UpdatingMessagesManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public UpdatingMessagesManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link UpdatingMessagesManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public UpdatingMessagesManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link UpdatingMessagesManager}
     *
     * @param token : the bot unique authentication token
     */
    public UpdatingMessagesManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link UpdatingMessagesManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public UpdatingMessagesManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link UpdatingMessagesManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link UpdatingMessagesManager}'s manager without re-insert
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
    public UpdatingMessagesManager() throws Exception {
        super();
    }

    public Message editMessageText(String text, Params parameters) throws IOException {
        return editMessageText(text, parameters, LIBRARY_OBJECT);
    }

    public <T> T editMessageText(String text, Params parameters, ReturnFormat format) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("text", text);
        return returnMessage(sendPostRequest(EDIT_MESSAGE_TEXT_ENDPOINT, parameters), format);
    }

}
