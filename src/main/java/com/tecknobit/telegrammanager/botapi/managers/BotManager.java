package com.tecknobit.telegrammanager.botapi.managers;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.TelegramIdentifierManager;
import com.tecknobit.telegrammanager.botapi.records.basetypes.CallbackQuery;
import com.tecknobit.telegrammanager.botapi.records.basetypes.bot.BotCommand;
import com.tecknobit.telegrammanager.botapi.records.basetypes.bot.BotDescription;
import com.tecknobit.telegrammanager.botapi.records.basetypes.bot.BotName;
import com.tecknobit.telegrammanager.botapi.records.basetypes.bot.BotShortDescription;
import com.tecknobit.telegrammanager.botapi.records.basetypes.bot.scopes.BotCommandScopeDefault;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members.ChatAdministratorRights;
import com.tecknobit.telegrammanager.botapi.records.basetypes.menubuttons.MenuButtonDefault;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code BotManager} class is useful to create a {@code Telegram}'s bot manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#available-methods">
 * Available methods</a>
 * @see TelegramManager
 */
public class BotManager extends TelegramManager {

    /**
     * {@code ANSWER_CALLBACK_QUERY_ENDPOINT} is constant for ANSWER_CALLBACK_QUERY_ENDPOINT's endpoint
     */
    public static final String ANSWER_CALLBACK_QUERY_ENDPOINT = "answerCallbackQuery";

    /**
     * {@code SET_MY_COMMANDS_ENDPOINT} is constant for SET_MY_COMMANDS_ENDPOINT's endpoint
     */
    public static final String SET_MY_COMMANDS_ENDPOINT = "setMyCommands";

    /**
     * {@code DELETE_MY_COMMANDS_ENDPOINT} is constant for DELETE_MY_COMMANDS_ENDPOINT's endpoint
     */
    public static final String DELETE_MY_COMMANDS_ENDPOINT = "deleteMyCommands";

    /**
     * {@code GET_MY_COMMANDS_ENDPOINT} is constant for GET_MY_COMMANDS_ENDPOINT's endpoint
     */
    public static final String GET_MY_COMMANDS_ENDPOINT = "getMyCommands";

    /**
     * {@code SET_MY_NAME_ENDPOINT} is constant for SET_MY_NAME_ENDPOINT's endpoint
     */
    public static final String SET_MY_NAME_ENDPOINT = "setMyName";

    /**
     * {@code GET_MY_NAME_ENDPOINT} is constant for GET_MY_NAME_ENDPOINT's endpoint
     */
    public static final String GET_MY_NAME_ENDPOINT = "getMyName";

    /**
     * {@code SET_MY_DESCRIPTION_ENDPOINT} is constant for SET_MY_DESCRIPTION_ENDPOINT's endpoint
     */
    public static final String SET_MY_DESCRIPTION_ENDPOINT = "setMyDescription";

    /**
     * {@code GET_MY_DESCRIPTION_ENDPOINT} is constant for GET_MY_DESCRIPTION_ENDPOINT's endpoint
     */
    public static final String GET_MY_DESCRIPTION_ENDPOINT = "getMyDescription";

    /**
     * {@code SET_MY_SHORT_DESCRIPTION_ENDPOINT} is constant for SET_MY_SHORT_DESCRIPTION_ENDPOINT's endpoint
     */
    public static final String SET_MY_SHORT_DESCRIPTION_ENDPOINT = "setMyShortDescription";

    /**
     * {@code GET_MY_SHORT_DESCRIPTION_ENDPOINT} is constant for GET_MY_SHORT_DESCRIPTION_ENDPOINT's endpoint
     */
    public static final String GET_MY_SHORT_DESCRIPTION_ENDPOINT = "getMyShortDescription";

    /**
     * {@code SET_CHAT_MENU_BUTTON_ENDPOINT} is constant for SET_CHAT_MENU_BUTTON_ENDPOINT's endpoint
     */
    public static final String SET_CHAT_MENU_BUTTON_ENDPOINT = "setChatMenuButton";

    /**
     * {@code GET_CHAT_MENU_BUTTON_ENDPOINT} is constant for GET_CHAT_MENU_BUTTON_ENDPOINT's endpoint
     */
    public static final String GET_CHAT_MENU_BUTTON_ENDPOINT = "getChatMenuButton";

    /**
     * {@code SET_MY_DEFAULT_ADMINISTRATOR_RIGHTS_ENDPOINT} is constant for SET_MY_DEFAULT_ADMINISTRATOR_RIGHTS_ENDPOINT's endpoint
     */
    public static final String SET_MY_DEFAULT_ADMINISTRATOR_RIGHTS_ENDPOINT = "setMyDefaultAdministratorRights";

    /**
     * {@code GET_MY_DEFAULT_ADMINISTRATOR_RIGHTS_ENDPOINT} is constant for GET_MY_DEFAULT_ADMINISTRATOR_RIGHTS_ENDPOINT's endpoint
     */
    public static final String GET_MY_DEFAULT_ADMINISTRATOR_RIGHTS_ENDPOINT = "getMyDefaultAdministratorRights";

    /**
     * Constructor to init {@link BotManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public BotManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link BotManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public BotManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link BotManager}
     *
     * @param token : the bot unique authentication token
     */
    public BotManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link BotManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public BotManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link BotManager} object <br>
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
    public BotManager() throws Exception {
        super();
    }

    /**
     * Method to send answers to callback queries sent from inline keyboards. The answer will be displayed to the user
     * as a notification at the top of the chat screen or as an alert
     *
     * @param callbackQuery: query to be answered
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answercallbackquery">
     * answerCallbackQuery</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "answerCallbackQuery")
    public boolean answerCallbackQuery(CallbackQuery callbackQuery) throws IOException {
        return answerCallbackQuery(callbackQuery.getId());
    }

    /**
     * Method to send answers to callback queries sent from inline keyboards. The answer will be displayed to the user
     * as a notification at the top of the chat screen or as an alert
     *
     * @param callbackQueryId: unique identifier for the query to be answered
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answercallbackquery">
     * answerCallbackQuery</a>
     */
    @RequestPath(method = POST, path = "answerCallbackQuery")
    public boolean answerCallbackQuery(String callbackQueryId) throws IOException {
        return answerCallbackQuery(callbackQueryId, null);
    }

    /**
     * Method to send answers to callback queries sent from inline keyboards. The answer will be displayed to the user
     * as a notification at the top of the chat screen or as an alert
     *
     * @param callbackQuery: query to be answered
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "text"} -> text of the notification. If not specified, nothing will be shown
     *                                  to the user, 0-200 characters - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "show_alert"} -> if True, an alert will be shown by the client instead of a
     *                                  notification at the top of the chat screen - [Boolean, default false]
     *                             </li>
     *                             <li>
     *                                  {@code "url"} -> URL that will be opened by the user's client. If you have created
     *                                  a Game and accepted the conditions via @BotFather, specify the URL that opens your
     *                                  game - note that this will only work if the query comes from a callback_game
     *                                  button - [String]
     *                             </li>
     *                             <li>
     *                                  {@code "cache_time"} -> the maximum amount of time in seconds that the result of
     *                                  the callback query may be cached client-side - [Integer, default 0]
     *                             </li>
     *                       </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answercallbackquery">
     * answerCallbackQuery</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "answerCallbackQuery")
    public boolean answerCallbackQuery(CallbackQuery callbackQuery, Params parameters) throws IOException {
        return answerCallbackQuery(callbackQuery.getId(), parameters);
    }

    /**
     * Method to send answers to callback queries sent from inline keyboards. The answer will be displayed to the user
     * as a notification at the top of the chat screen or as an alert
     *
     * @param callbackQueryId: unique identifier for the query to be answered
     * @param parameters:      additional params of the request, keys accepted are:
     *                         <ul>
     *                               <li>
     *                                    {@code "text"} -> text of the notification. If not specified, nothing will be shown
     *                                    to the user, 0-200 characters - [String]
     *                               </li>
     *                               <li>
     *                                    {@code "show_alert"} -> if True, an alert will be shown by the client instead of a
     *                                    notification at the top of the chat screen - [Boolean, default false]
     *                               </li>
     *                               <li>
     *                                    {@code "url"} -> URL that will be opened by the user's client. If you have created
     *                                    a Game and accepted the conditions via @BotFather, specify the URL that opens your
     *                                    game - note that this will only work if the query comes from a callback_game
     *                                    button - [String]
     *                               </li>
     *                               <li>
     *                                    {@code "cache_time"} -> the maximum amount of time in seconds that the result of
     *                                    the callback query may be cached client-side - [Integer, default 0]
     *                               </li>
     *                         </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#answercallbackquery">
     * answerCallbackQuery</a>
     */
    @RequestPath(method = POST, path = "answerCallbackQuery")
    public boolean answerCallbackQuery(String callbackQueryId, Params parameters) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("callback_query_id", callbackQueryId);
        return getBooleanResponse(sendPostRequest(ANSWER_CALLBACK_QUERY_ENDPOINT, parameters));
    }

    /**
     * Method to change the list of the bot's commands
     *
     * @param commands: list of bot commands to be set as the list of the bot's commands. At most 100 commands can be
     *                  specified
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setmycommands">
     * setMyCommands</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setMyCommands")
    public boolean setMyCommands(BotCommand... commands) throws IOException {
        return setMyCommands(null, commands);
    }

    /**
     * Method to change the list of the bot's commands
     *
     * @param commands:   list of bot commands to be set as the list of the bot's commands. At most 100 commands can be
     *                    specified
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "scope"} -> describing scope of users for which the commands are
     *                               relevant - [BotCommandScope, default {@link BotCommandScopeDefault}]
     *                          </li>
     *                          <li>
     *                               {@code "language_code"} -> a two-letter ISO 639-1 language code. If empty, commands
     *                               will be applied to all users from the given scope, for whose language there
     *                               are no dedicated commands - [String]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setmycommands">
     * setMyCommands</a>
     */
    @RequestPath(method = POST, path = "setMyCommands")
    public boolean setMyCommands(Params parameters, BotCommand... commands) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("commands", new JSONArray(commands));
        return getBooleanResponse(sendPostRequest(SET_MY_COMMANDS_ENDPOINT, parameters));
    }

    /**
     * Method to delete the list of the bot's commands for the given scope and user language. After deletion, higher
     * level commands will be shown to affected users <br>
     * No-any params required
     *
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletemycommands">
     * deleteMyCommands</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "deleteMyCommands")
    public boolean deleteMyCommands() throws IOException {
        return deleteMyCommands(null);
    }

    /**
     * Method to delete the list of the bot's commands for the given scope and user language. After deletion, higher
     * level commands will be shown to affected users
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "scope"} -> describing scope of users for which the commands are
     *                               relevant - [BotCommandScope, default {@link BotCommandScopeDefault}]
     *                          </li>
     *                          <li>
     *                               {@code "language_code"} -> a two-letter ISO 639-1 language code. If empty, commands
     *                               will be applied to all users from the given scope, for whose language there
     *                               are no dedicated commands - [String]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletemycommands">
     * deleteMyCommands</a>
     */
    @RequestPath(method = POST, path = "deleteMyCommands")
    public boolean deleteMyCommands(Params parameters) throws IOException {
        return getBooleanResponse(sendPostRequest(DELETE_MY_COMMANDS_ENDPOINT, parameters));
    }

    /**
     * Request to get the current list of the bot's commands for the given scope and user language <br>
     * No-any params required
     *
     * @return bot commands list as {@link ArrayList} of {@link BotCommand} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmycommands">
     * getMyCommands</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMyCommands")
    public ArrayList<BotCommand> getMyCommands() throws IOException {
        return getMyCommands(LIBRARY_OBJECT);
    }

    /**
     * Request to get the current list of the bot's commands for the given scope and user language
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return bot commands list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmycommands">
     * getMyCommands</a>
     */
    @RequestPath(method = GET, path = "getMyCommands")
    public <T> T getMyCommands(ReturnFormat format) throws IOException {
        return getMyCommands(null, format);
    }

    /**
     * Request to get the current list of the bot's commands for the given scope and user language
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "scope"} -> describing scope of users - [BotCommandScope,
     *                               default {@link BotCommandScopeDefault}]
     *                          </li>
     *                          <li>
     *                               {@code "language_code"} -> a two-letter ISO 639-1 language code or an empty
     *                               string - [String]
     *                          </li>
     *                    </ul>
     * @return bot commands list as {@link ArrayList} of {@link BotCommand} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmycommands">
     * getMyCommands</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMyCommands")
    public ArrayList<BotCommand> getMyCommands(Params parameters) throws IOException {
        return getMyCommands(parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to get the current list of the bot's commands for the given scope and user language
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "scope"} -> describing scope of users - [BotCommandScope,
     *                               default {@link BotCommandScopeDefault}]
     *                          </li>
     *                          <li>
     *                               {@code "language_code"} -> a two-letter ISO 639-1 language code or an empty
     *                               string - [String]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return bot commands list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmycommands">
     * getMyCommands</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getMyCommands")
    public <T> T getMyCommands(Params parameters, ReturnFormat format) throws IOException {
        JSONArray result = getResultFromList(sendGetRequest(GET_MY_COMMANDS_ENDPOINT, parameters));
        return switch (format) {
            case JSON -> (T) result;
            case LIBRARY_OBJECT -> {
                ArrayList<BotCommand> commands = new ArrayList<>();
                for (int j = 0; j < result.length(); j++)
                    commands.add(new BotCommand(result.getJSONObject(j)));
                yield (T) commands;
            }
            default -> (T) result.toString();
        };
    }

    /**
     * Method to change the bot's name
     *
     * @param name: new bot name; 0-64 characters. Pass an empty string to remove the dedicated name for the given language
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setmyname">
     * setMyName</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setMyName")
    public boolean setMyName(String name) throws IOException {
        return setMyName(name, null);
    }

    /**
     * Method to change the bot's name
     *
     * @param name:         new bot name; 0-64 characters. Pass an empty string to remove the dedicated name for the given language
     * @param languageCode: a two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose
     *                      language there is no dedicated name
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setmyname">
     * setMyName</a>
     */
    @RequestPath(method = POST, path = "setMyName")
    public boolean setMyName(String name, String languageCode) throws IOException {
        Params payload = new Params();
        payload.addParam("name", name);
        if (languageCode != null)
            payload.addParam("language_code", languageCode);
        return getBooleanResponse((sendPostRequest(SET_MY_NAME_ENDPOINT, payload)));
    }

    /**
     * Request to get the current bot name for the given user language <br>
     * No-any params required
     *
     * @return bot name as of {@link BotName} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmyname">
     * getMyName</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMyName")
    public BotName getMyName() throws IOException {
        return getMyName(LIBRARY_OBJECT);
    }

    /**
     * Request to get the current bot name for the given user language
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return bot name as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmyname">
     * getMyName</a>
     */
    @RequestPath(method = GET, path = "getMyName")
    public <T> T getMyName(ReturnFormat format) throws IOException {
        return getMyName(null, format);
    }

    /**
     * Request to get the current bot name for the given user language
     *
     * @param languageCode: a two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose
     *                      language there is no dedicated name
     * @return bot name as of {@link BotName} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmyname">
     * getMyName</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMyName")
    public BotName getMyName(String languageCode) throws IOException {
        return getMyName(languageCode, LIBRARY_OBJECT);
    }

    /**
     * Request to get the current bot name for the given user language
     *
     * @param languageCode: a two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose
     *                      language there is no dedicated name
     * @param format        :       return type formatter -> {@link ReturnFormat}
     * @return bot name as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmyname">
     * getMyName</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getMyName")
    public <T> T getMyName(String languageCode, ReturnFormat format) throws IOException {
        Params payload = new Params();
        if (languageCode != null)
            payload.addParam("language_code", languageCode);
        String nameResponse = sendGetRequest(GET_MY_NAME_ENDPOINT, payload);
        return switch (format) {
            case JSON -> (T) new JSONObject(nameResponse);
            case LIBRARY_OBJECT -> (T) new BotName(new JSONObject(nameResponse));
            default -> (T) nameResponse;
        };
    }

    /**
     * Method to change the bot's description, which is shown in the chat with the bot if the chat is empty
     *
     * @param description: new bot description; 0-512 characters. Pass an empty string to remove the dedicated
     *                     description for the given language.
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setmydescription">
     * setMyDescription</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setMyDescription")
    public boolean setMyDescription(String description) throws IOException {
        return setMyDescription(description, null);
    }

    /**
     * Method to change the bot's description, which is shown in the chat with the bot if the chat is empty
     *
     * @param description:  new bot description; 0-512 characters. Pass an empty string to remove the dedicated
     *                      description for the given language
     * @param languageCode: a two-letter ISO 639-1 language code. If empty, the description will be applied to all users
     *                      for whose language there is no dedicated description
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setmydescription">
     * setMyDescription</a>
     */
    @RequestPath(method = POST, path = "setMyDescription")
    public boolean setMyDescription(String description, String languageCode) throws IOException {
        Params payload = new Params();
        payload.addParam("description", description);
        if (languageCode != null)
            payload.addParam("language_code", languageCode);
        return getBooleanResponse((sendPostRequest(SET_MY_DESCRIPTION_ENDPOINT, payload)));
    }

    /**
     * Request to get the current bot description for the given user language <br>
     * No-any params required
     *
     * @return bot description as of {@link BotDescription} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmydescription">
     * getMyDescription</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMyDescription")
    public BotDescription getMyDescription() throws IOException {
        return getMyDescription(LIBRARY_OBJECT);
    }

    /**
     * Request to get the current bot description for the given user language
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return bot description as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmydescription">
     * getMyDescription</a>
     */
    @RequestPath(method = GET, path = "getMyDescription")
    public <T> T getMyDescription(ReturnFormat format) throws IOException {
        return getMyDescription(null, format);
    }

    /**
     * Request to get the current bot description for the given user language
     *
     * @param languageCode: a two-letter ISO 639-1 language code. If empty, the description will be applied to all users
     *                      for whose language there is no dedicated description
     * @return bot description as of {@link BotDescription} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmydescription">
     * getMyDescription</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMyDescription")
    public BotDescription getMyDescription(String languageCode) throws IOException {
        return getMyDescription(languageCode, LIBRARY_OBJECT);
    }

    /**
     * Request to get the current bot description for the given user language
     *
     * @param languageCode: a two-letter ISO 639-1 language code. If empty, the description will be applied to all users
     *                      for whose language there is no dedicated description
     * @param format        :       return type formatter -> {@link ReturnFormat}
     * @return bot description as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmydescription">
     * getMyDescription</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getMyDescription")
    public <T> T getMyDescription(String languageCode, ReturnFormat format) throws IOException {
        Params payload = new Params();
        if (languageCode != null)
            payload.addParam("language_code", languageCode);
        String descriptionResponse = sendGetRequest(GET_MY_DESCRIPTION_ENDPOINT, payload);
        return switch (format) {
            case JSON -> (T) new JSONObject(descriptionResponse);
            case LIBRARY_OBJECT -> (T) new BotDescription(new JSONObject(descriptionResponse));
            default -> (T) descriptionResponse;
        };
    }

    /**
     * Method to change the bot's short description, which is shown on the bot's profile page and is sent together with
     * the link when users share the bot
     *
     * @param shortDescription: new short description for the bot; 0-120 characters. Pass an empty string to remove the
     *                          dedicated short description for the given language
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setmyshortdescription">
     * setMyShortDescription</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setMyShortDescription")
    public boolean setMyShortDescription(String shortDescription) throws IOException {
        return setMyShortDescription(shortDescription, null);
    }

    /**
     * Method to change the bot's short description, which is shown on the bot's profile page and is sent together with
     * the link when users share the bot
     *
     * @param shortDescription: new short description for the bot; 0-120 characters. Pass an empty string to remove the
     *                          dedicated short description for the given language
     * @param languageCode:     a two-letter ISO 639-1 language code. If empty, the short description will be applied to all
     *                          users for whose language there is no dedicated short description
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setmyshortdescription">
     * setMyShortDescription</a>
     */
    @RequestPath(method = POST, path = "setMyShortDescription")
    public boolean setMyShortDescription(String shortDescription, String languageCode) throws IOException {
        Params payload = new Params();
        payload.addParam("short_description", shortDescription);
        if (languageCode != null)
            payload.addParam("language_code", languageCode);
        return getBooleanResponse((sendPostRequest(SET_MY_SHORT_DESCRIPTION_ENDPOINT, payload)));
    }

    /**
     * Request to get the current bot short description for the given user language <br>
     * No-any params required
     *
     * @return bot short description as of {@link BotShortDescription} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmyshortdescription">
     * getMyShortDescription</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMyShortDescription")
    public BotShortDescription getMyShortDescription() throws IOException {
        return getMyShortDescription(LIBRARY_OBJECT);
    }

    /**
     * Request to get the current bot short description for the given user language
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return bot short description as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmyshortdescription">
     * getMyShortDescription</a>
     */
    @RequestPath(method = GET, path = "getMyShortDescription")
    public <T> T getMyShortDescription(ReturnFormat format) throws IOException {
        return getMyShortDescription(null, format);
    }

    /**
     * Request to get the current bot short description for the given user language
     *
     * @param languageCode: a two-letter ISO 639-1 language code. If empty, the short description will be applied to all
     *                      users for whose language there is no dedicated short description
     * @return bot short description as of {@link BotShortDescription} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmyshortdescription">
     * getMyShortDescription</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMyShortDescription")
    public BotShortDescription getMyShortDescription(String languageCode) throws IOException {
        return getMyShortDescription(languageCode, LIBRARY_OBJECT);
    }

    /**
     * Request to get the current bot short description for the given user language
     *
     * @param languageCode: a two-letter ISO 639-1 language code. If empty, the short description will be applied to all
     *                      users for whose language there is no dedicated short description
     * @param format        :       return type formatter -> {@link ReturnFormat}
     * @return bot short description as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmyshortdescription">
     * getMyShortDescription</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getMyShortDescription")
    public <T> T getMyShortDescription(String languageCode, ReturnFormat format) throws IOException {
        Params payload = new Params();
        if (languageCode != null)
            payload.addParam("language_code", languageCode);
        String shorDescriptionResponse = sendGetRequest(GET_MY_SHORT_DESCRIPTION_ENDPOINT, payload);
        return switch (format) {
            case JSON -> (T) new JSONObject(shorDescriptionResponse);
            case LIBRARY_OBJECT -> (T) new BotShortDescription(new JSONObject(shorDescriptionResponse));
            default -> (T) shorDescriptionResponse;
        };
    }

    /**
     * Method to change the bot's menu button in a private chat, or the default menu button
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> unique identifier for the target private chat. If not specified,
     *                               default bot's menu button will be changed - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "menu_button"} -> object for the bot's new menu button
     *                               - [MenuButton, default {@link MenuButtonDefault}]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatmenubutton">
     * setChatMenuButton</a>
     */
    @RequestPath(method = POST, path = "setChatMenuButton")
    public boolean setChatMenuButton(Params parameters) throws IOException {
        return getBooleanResponse(sendPostRequest(SET_CHAT_MENU_BUTTON_ENDPOINT, parameters));
    }

    /**
     * Request to get the current value of the bot's menu button in a private chat, or the default menu button <br>
     * No-any params required
     *
     * @return menu button as of {@link MenuButtonDefault} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmenubutton">
     * getChatMenuButton</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChatMenuButton")
    public MenuButtonDefault getChatMenuButton() throws IOException {
        return getChatMenuButton(LIBRARY_OBJECT);
    }

    /**
     * Request to get the current value of the bot's menu button in a private chat, or the default menu button
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return menu button as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmenubutton">
     * getChatMenuButton</a>
     */
    @RequestPath(method = GET, path = "getChatMenuButton")
    public <T> T getChatMenuButton(ReturnFormat format) throws IOException {
        return getChatMenuButton(-1, format);
    }

    /**
     * Request to get the current value of the bot's menu button in a private chat, or the default menu button
     *
     * @param chat: the chat from fetch the menu button
     * @return menu button as of {@link MenuButtonDefault} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmenubutton">
     * getChatMenuButton</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = GET, path = "getChatMenuButton")
    public MenuButtonDefault getChatMenuButton(Chat chat) throws IOException {
        return getChatMenuButton(chat.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to get the current value of the bot's menu button in a private chat, or the default menu button
     *
     * @param chat:  the chat from fetch the menu button
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return menu button as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmenubutton">
     * getChatMenuButton</a>
     */
    @WrappedRequest
    @RequestPath(method = GET, path = "getChatMenuButton")
    public <T> T getChatMenuButton(Chat chat, ReturnFormat format) throws IOException {
        return getChatMenuButton(chat.getId(), format);
    }

    /**
     * Request to get the current value of the bot's menu button in a private chat, or the default menu button
     *
     * @param chatId: unique identifier for the target private chat. If not specified, default bot's menu button will
     *                be returned
     * @return menu button as of {@link MenuButtonDefault} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmenubutton">
     * getChatMenuButton</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChatMenuButton")
    public MenuButtonDefault getChatMenuButton(long chatId) throws IOException {
        return getChatMenuButton(chatId, LIBRARY_OBJECT);
    }

    /**
     * Request to get the current value of the bot's menu button in a private chat, or the default menu button
     *
     * @param chatId: unique identifier for the target private chat. If not specified, default bot's menu button will
     *                be returned
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return menu button as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmenubutton">
     * getChatMenuButton</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getChatMenuButton")
    public <T> T getChatMenuButton(long chatId, ReturnFormat format) throws IOException {
        Params query = new Params();
        if (chatId != -1)
            query.addParam("chat_id", chatId);
        String menuButtonResponse = sendGetRequest(GET_CHAT_MENU_BUTTON_ENDPOINT, query);
        return switch (format) {
            case JSON -> (T) new JSONObject(menuButtonResponse);
            case LIBRARY_OBJECT -> (T) new MenuButtonDefault(new JSONObject(menuButtonResponse));
            default -> (T) menuButtonResponse;
        };
    }

    /**
     * Method to change the default administrator rights requested by the bot when it's added as an administrator to
     * groups or channels. These rights will be suggested to users, but they are free to modify the list before adding
     * the bot
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "rights"} -> object describing new default administrator rights.
     *                               If not specified, the default administrator rights will be
     *                               cleared - [{@link ChatAdministratorRights}]
     *                          </li>
     *                          <li>
     *                               {@code "for_channels"} -> object for the bot's new menu button
     *                               - [Boolean]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setmydefaultadministratorrights">
     * setMyDefaultAdministratorRights</a>
     */
    @RequestPath(method = POST, path = "setMyDefaultAdministratorRights")
    public boolean setMyDefaultAdministratorRights(Params parameters) throws IOException {
        return getBooleanResponse(sendPostRequest(SET_MY_DEFAULT_ADMINISTRATOR_RIGHTS_ENDPOINT, parameters));
    }

    /**
     * Request to get the current default administrator rights of the bot
     *
     * @param forChannels: pass True to get default administrator rights of the bot in channels. Otherwise,
     *                     default administrator rights of the bot for groups and supergroups will be returned
     * @return chat administrator rights as of {@link ChatAdministratorRights} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmydefaultadministratorrights">
     * getMyDefaultAdministratorRights</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMyDefaultAdministratorRights")
    public ChatAdministratorRights getMyDefaultAdministratorRights(boolean forChannels) throws IOException {
        return getMyDefaultAdministratorRights(forChannels, LIBRARY_OBJECT);
    }

    /**
     * Request to get the current default administrator rights of the bot
     *
     * @param forChannels: pass True to get default administrator rights of the bot in channels. Otherwise,
     *                     default administrator rights of the bot for groups and supergroups will be returned
     * @param format       :       return type formatter -> {@link ReturnFormat}
     * @return chat administrator rights as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getmydefaultadministratorrights">
     * getMyDefaultAdministratorRights</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getMyDefaultAdministratorRights")
    public <T> T getMyDefaultAdministratorRights(boolean forChannels, ReturnFormat format) throws IOException {
        Params query = new Params();
        query.addParam("for_channels", forChannels);
        String menuButtonResponse = sendGetRequest(GET_MY_DEFAULT_ADMINISTRATOR_RIGHTS_ENDPOINT, query);
        return switch (format) {
            case JSON -> (T) new JSONObject(menuButtonResponse);
            case LIBRARY_OBJECT -> (T) new ChatAdministratorRights(new JSONObject(menuButtonResponse));
            default -> (T) menuButtonResponse;
        };
    }

}
