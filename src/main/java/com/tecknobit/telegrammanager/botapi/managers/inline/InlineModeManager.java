package com.tecknobit.telegrammanager.botapi.managers.inline;

import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.InlineQuery;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.SentWebAppMessage;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResult;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code InlineModeManager} class is useful to create a {@code Telegram}'s bot inline mode manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inline-mode">
 * Inline mode</a>
 * @see TelegramManager
 */
public class InlineModeManager extends TelegramManager {

    /**
     * {@code ANSWER_INLINE_QUERY_ENDPOINT} is constant for ANSWER_INLINE_QUERY_ENDPOINT's endpoint
     */
    public static final String ANSWER_INLINE_QUERY_ENDPOINT = "answerInlineQuery";

    /**
     * {@code ANSWER_WEBAPP_QUERY_ENDPOINT} is constant for ANSWER_WEBAPP_QUERY_ENDPOINT's endpoint
     */
    public static final String ANSWER_WEBAPP_QUERY_ENDPOINT = "answerWebAppQuery";

    /**
     * Constructor to init {@link InlineModeManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public InlineModeManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link InlineModeManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public InlineModeManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link InlineModeManager}
     *
     * @param token : the bot unique authentication token
     */
    public InlineModeManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link InlineModeManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public InlineModeManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link InlineModeManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link InlineModeManager}'s manager without re-insert
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
    public InlineModeManager() throws Exception {
        super();
    }

    @SafeVarargs
    public final <T extends InputMessageContentType> boolean answerInlineQuery(InlineQuery inlineQuery,
                                                                               InlineQueryResult<T>... results) throws IOException {
        return answerInlineQuery(inlineQuery.getId(), results);
    }

    @SafeVarargs
    public final <T extends InputMessageContentType> boolean answerInlineQuery(String inlineQueryId,
                                                                               InlineQueryResult<T>... results) throws IOException {
        return answerInlineQuery(inlineQueryId, null, results);
    }

    @SafeVarargs
    public final <T extends InputMessageContentType> boolean answerInlineQuery(InlineQuery inlineQuery,
                                                                               Params parameters,
                                                                               InlineQueryResult<T>... results) throws IOException {
        return answerInlineQuery(inlineQuery.getId(), parameters, results);
    }

    @SafeVarargs
    public final <T extends InputMessageContentType> boolean answerInlineQuery(String inlineQueryId,
                                                                               Params parameters,
                                                                               InlineQueryResult<T>... results) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("inline_query_id", inlineQueryId);
        parameters.addParam("results", new JSONArray(results));
        return getBooleanResponse(sendPostRequest(ANSWER_INLINE_QUERY_ENDPOINT, parameters));
    }

    public <T extends InputMessageContentType> SentWebAppMessage answerWebAppQuery(String webAppQueryId,
                                                                                   InlineQueryResult<T> result) throws IOException {
        return answerWebAppQuery(webAppQueryId, result, LIBRARY_OBJECT);
    }

    public <T extends InputMessageContentType, L> L answerWebAppQuery(String webAppQueryId, InlineQueryResult<T> result,
                                                                      ReturnFormat format) throws IOException {
        Params payload = new Params();
        payload.addParam("web_app_query_id", webAppQueryId);
        payload.addParam("result", result);
        String queryResponse = sendPostRequest(ANSWER_WEBAPP_QUERY_ENDPOINT, payload);
        return switch (format) {
            case JSON -> (L) new JSONObject(queryResponse);
            case LIBRARY_OBJECT -> (L) new SentWebAppMessage(new JSONObject(queryResponse));
            default -> (L) queryResponse;
        };
    }

}
