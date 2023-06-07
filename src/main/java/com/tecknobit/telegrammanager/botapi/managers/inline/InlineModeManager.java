package com.tecknobit.telegrammanager.botapi.managers.inline;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.InlineQuery;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.InlineQueryResultsButton;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.SentWebAppMessage;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResult;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
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

    /**
     * Method to send answers to an inline query
     *
     * @param inlineQuery: the answered query
     * @param results:     array of results for the inline query
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerinlinequery">
     * answerInlineQuery</a>
     */
    @SafeVarargs
    @WrappedRequest
    @RequestPath(method = POST, path = "answerInlineQuery")
    public final <T extends InputMessageContentType> boolean answerInlineQuery(InlineQuery inlineQuery,
                                                                               InlineQueryResult<T>... results) throws IOException {
        return answerInlineQuery(inlineQuery.getId(), results);
    }

    /**
     * Method to send answers to an inline query
     *
     * @param inlineQueryId: unique identifier for the answered query
     * @param results:       array of results for the inline query
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerinlinequery">
     * answerInlineQuery</a>
     */
    @SafeVarargs
    @RequestPath(method = POST, path = "answerInlineQuery")
    public final <T extends InputMessageContentType> boolean answerInlineQuery(String inlineQueryId,
                                                                               InlineQueryResult<T>... results) throws IOException {
        return answerInlineQuery(inlineQueryId, null, results);
    }

    /**
     * Method to send answers to an inline query
     *
     * @param inlineQuery: the answered query
     * @param parameters:  additional params of the request, keys accepted are:
     *                     <ul>
     *                           <li>
     *                                {@code "cache_time"} -> the maximum amount of time in seconds that the result of the
     *                                inline query may be cached on the server - [Integer, default 300]
     *                           </li>
     *                           <li>
     *                                {@code "is_personal"} -> pass True if results may be cached on the server side only
     *                                for the user that sent the query. By default, results may be returned to any user
     *                                who sends the same query - [Boolean]
     *                           </li>
     *                           <li>
     *                                {@code "next_offset"} -> pass the offset that a client should send in the next query
     *                                with the same text to receive more results. Pass an empty string if there are no more
     *                                results or if you don't support pagination. Offset length can't exceed
     *                                64 bytes - [Boolean]
     *                           </li>
     *                           <li>
     *                                {@code "button"} -> object describing a button to be shown above inline query
     *                                results - [{@link InlineQueryResultsButton}]
     *                           </li>
     *                     </ul>
     * @param results:     array of results for the inline query
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerinlinequery">
     * answerInlineQuery</a>
     */
    @SafeVarargs
    @WrappedRequest
    @RequestPath(method = POST, path = "answerInlineQuery")
    public final <T extends InputMessageContentType> boolean answerInlineQuery(InlineQuery inlineQuery,
                                                                               Params parameters,
                                                                               InlineQueryResult<T>... results) throws IOException {
        return answerInlineQuery(inlineQuery.getId(), parameters, results);
    }

    /**
     * Method to send answers to an inline query
     *
     * @param inlineQueryId: unique identifier for the answered query
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "cache_time"} -> the maximum amount of time in seconds that the result of the
     *                                  inline query may be cached on the server - [Integer, default 300]
     *                             </li>
     *                             <li>
     *                                  {@code "is_personal"} -> pass True if results may be cached on the server side only
     *                                  for the user that sent the query. By default, results may be returned to any user
     *                                  who sends the same query - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "next_offset"} -> pass the offset that a client should send in the next query
     *                                  with the same text to receive more results. Pass an empty string if there are no more
     *                                  results or if you don't support pagination. Offset length can't exceed
     *                                  64 bytes - [Boolean]
     *                             </li>
     *                             <li>
     *                                  {@code "button"} -> object describing a button to be shown above inline query
     *                                  results - [{@link InlineQueryResultsButton}]
     *                             </li>
     *                       </ul>
     * @param results:       array of results for the inline query
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerinlinequery">
     * answerInlineQuery</a>
     */
    @SafeVarargs
    @RequestPath(method = POST, path = "answerInlineQuery")
    public final <T extends InputMessageContentType> boolean answerInlineQuery(String inlineQueryId,
                                                                               Params parameters,
                                                                               InlineQueryResult<T>... results) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("inline_query_id", inlineQueryId);
        parameters.addParam("results", new JSONArray(results));
        return getBooleanResponse(sendPostRequest(ANSWER_INLINE_QUERY_ENDPOINT, parameters));
    }

    /**
     * Method to set the result of an interaction with a Web App and send a corresponding message on behalf of the user
     * to the chat from which the query originated
     *
     * @param webAppQueryId: unique identifier for the query to be answered
     * @param result:        object describing the message to be sent
     * @return sent webapp message as {@link SentWebAppMessage} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerwebappquery">
     * answerWebAppQuery</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "answerWebAppQuery")
    public <T extends InputMessageContentType> SentWebAppMessage answerWebAppQuery(String webAppQueryId,
                                                                                   InlineQueryResult<T> result) throws IOException {
        return answerWebAppQuery(webAppQueryId, result, LIBRARY_OBJECT);
    }

    /**
     * Method to set the result of an interaction with a Web App and send a corresponding message on behalf of the user
     * to the chat from which the query originated
     *
     * @param webAppQueryId: unique identifier for the query to be answered
     * @param result:        object describing the message to be sent
     * @param format         :       return type formatter -> {@link ReturnFormat}
     * @return sent webapp message as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answerwebappquery">
     * answerWebAppQuery</a>
     */
    @Returner
    @RequestPath(method = POST, path = "answerWebAppQuery")
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
