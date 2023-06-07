package com.tecknobit.telegrammanager.botapi.managers.games;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.managers.games.records.GameHighScore;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.TelegramIdentifierManager;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.Chat;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.basetypes.ForceReply;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardRemove;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message.returnMessage;

/**
 * The {@code GamesManager} class is useful to create a {@code Telegram}'s bot games manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#games">
 * Games</a>
 * @see TelegramManager
 * @see TelegramIdentifierManager
 */
public class GamesManager extends TelegramManager {

    /**
     * {@code SEND_GAME_ENDPOINT} is constant for SEND_GAME_ENDPOINT's endpoint
     */
    public static final String SEND_GAME_ENDPOINT = "sendGame";

    /**
     * {@code SET_GAME_SCORE_ENDPOINT} is constant for SET_GAME_SCORE_ENDPOINT's endpoint
     */
    public static final String SET_GAME_SCORE_ENDPOINT = "setGameScore";

    /**
     * {@code GET_GAME_HIGH_SCORES_ENDPOINT} is constant for GET_GAME_HIGH_SCORES_ENDPOINT's endpoint
     */
    public static final String GET_GAME_HIGH_SCORES_ENDPOINT = "getGameHighScores";

    /**
     * Constructor to init {@link GamesManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public GamesManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link GamesManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public GamesManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link GamesManager}
     *
     * @param token : the bot unique authentication token
     */
    public GamesManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link GamesManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public GamesManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link GamesManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link GamesManager}'s manager without re-insert
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
    public GamesManager() throws Exception {
        super();
    }

    /**
     * Request to send a game
     *
     * @param chat:          the target chat
     * @param gameShortName: short name of the game, serves as the unique identifier for the game. Set up your games via
     *                       <a href="https://t.me/botfather">@BotFather</a>
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
     * sendGame</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "sendGame")
    public Message sendGame(Chat chat, String gameShortName) throws IOException {
        return sendGame(chat.getId(), gameShortName, LIBRARY_OBJECT);
    }

    /**
     * Request to send a game
     *
     * @param chat:          the target chat
     * @param gameShortName: short name of the game, serves as the unique identifier for the game. Set up your games via
     *                       <a href="https://t.me/botfather">@BotFather</a>
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
     * sendGame</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "sendGame")
    public <T> T sendGame(Chat chat, String gameShortName, ReturnFormat format) throws IOException {
        return sendGame(chat.getId(), gameShortName, format);
    }

    /**
     * Request to send a game
     *
     * @param chatId:        unique identifier for the target chat
     * @param gameShortName: short name of the game, serves as the unique identifier for the game. Set up your games via
     *                       <a href="https://t.me/botfather">@BotFather</a>
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
     * sendGame</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendGame")
    public Message sendGame(long chatId, String gameShortName) throws IOException {
        return sendGame(chatId, gameShortName, LIBRARY_OBJECT);
    }

    /**
     * Request to send a game
     *
     * @param chatId:        unique identifier for the target chat
     * @param gameShortName: short name of the game, serves as the unique identifier for the game. Set up your games via
     *                       <a href="https://t.me/botfather">@BotFather</a>
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
     * sendGame</a>
     */
    @RequestPath(method = POST, path = "sendGame")
    public <T> T sendGame(long chatId, String gameShortName, ReturnFormat format) throws IOException {
        return sendGame(chatId, gameShortName, null, format);
    }

    /**
     * Request to send a game
     *
     * @param chat:          the target chat
     * @param gameShortName: short name of the game, serves as the unique identifier for the game. Set up your games via
     *                       <a href="https://t.me/botfather">@BotFather</a>
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                  (topic) of the forum; for forum supergroups only - [Integer]
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
     * sendGame</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "sendGame")
    public Message sendGame(Chat chat, String gameShortName, Params parameters) throws IOException {
        return sendGame(chat.getId(), gameShortName, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send a game
     *
     * @param chat:          the target chat
     * @param gameShortName: short name of the game, serves as the unique identifier for the game. Set up your games via
     *                       <a href="https://t.me/botfather">@BotFather</a>
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                  (topic) of the forum; for forum supergroups only - [Integer]
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
     * sendGame</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "sendGame")
    public <T> T sendGame(Chat chat, String gameShortName, Params parameters, ReturnFormat format) throws IOException {
        return sendGame(chat.getId(), gameShortName, parameters, format);
    }

    /**
     * Request to send a game
     *
     * @param chatId:        unique identifier for the target chat
     * @param gameShortName: short name of the game, serves as the unique identifier for the game. Set up your games via
     *                       <a href="https://t.me/botfather">@BotFather</a>
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                  (topic) of the forum; for forum supergroups only - [Integer]
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
     * sendGame</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendGame")
    public Message sendGame(long chatId, String gameShortName, Params parameters) throws IOException {
        return sendGame(chatId, gameShortName, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send a game
     *
     * @param chatId:        unique identifier for the target chat
     * @param gameShortName: short name of the game, serves as the unique identifier for the game. Set up your games via
     *                       <a href="https://t.me/botfather">@BotFather</a>
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                  (topic) of the forum; for forum supergroups only - [Integer]
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
     * sendGame</a>
     */
    @RequestPath(method = POST, path = "sendGame")
    public <T> T sendGame(long chatId, String gameShortName, Params parameters, ReturnFormat format) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("chat_id", chatId);
        parameters.addParam("game_short_name", gameShortName);
        return returnMessage(sendPostRequest(SEND_GAME_ENDPOINT, parameters), format);
    }

    /**
     * Request to set the score of the specified user in a game message
     *
     * @param user:       the user to set the score
     * @param score:      new score, must be non-negative
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "force"} -> pass true if the high score is allowed to decrease. This can be
     *                               useful when fixing mistakes or banning cheaters - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_edit_message"} -> pass true if the game message should not be
     *                               automatically edited to include the current scoreboard - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setgamescore">
     * setGameScore</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "setGameScore")
    public <T> T setGameScore(User user, int score, Params parameters) throws IOException {
        return setGameScore(user.getId(), score, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to set the score of the specified user in a game message
     *
     * @param user:       the user to set the score
     * @param score:      new score, must be non-negative
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "force"} -> pass true if the high score is allowed to decrease. This can be
     *                               useful when fixing mistakes or banning cheaters - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_edit_message"} -> pass true if the game message should not be
     *                               automatically edited to include the current scoreboard - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setgamescore">
     * setGameScore</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setGameScore")
    public <T> T setGameScore(User user, int score, Params parameters, ReturnFormat format) throws IOException {
        return setGameScore(user.getId(), score, parameters, format);
    }

    /**
     * Request to set the score of the specified user in a game message
     *
     * @param userId:     user identifier
     * @param score:      new score, must be non-negative
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "force"} -> pass true if the high score is allowed to decrease. This can be
     *                               useful when fixing mistakes or banning cheaters - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_edit_message"} -> pass true if the game message should not be
     *                               automatically edited to include the current scoreboard - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setgamescore">
     * setGameScore</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setGameScore")
    public <T> T setGameScore(long userId, int score, Params parameters) throws IOException {
        return setGameScore(userId, score, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to set the score of the specified user in a game message
     *
     * @param userId:     user identifier
     * @param score:      new score, must be non-negative
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "force"} -> pass true if the high score is allowed to decrease. This can be
     *                               useful when fixing mistakes or banning cheaters - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_edit_message"} -> pass true if the game message should not be
     *                               automatically edited to include the current scoreboard - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setgamescore">
     * setGameScore</a>
     */
    @RequestPath(method = POST, path = "setGameScore")
    public <T> T setGameScore(long userId, int score, Params parameters, ReturnFormat format) throws IOException {
        parameters.addParam("user_id", userId);
        parameters.addParam("score", score);
        return getMessageOrBooleanResponse(sendPostRequest(SET_GAME_SCORE_ENDPOINT, parameters), format);
    }

    /**
     * Request to get data for high score tables. Will return the score of the specified user and several of their
     * neighbors in a game <br>
     *
     * @param user:       the user from fetch the high scores
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                    </ul>
     * @return game high scores list as {@link ArrayList} of {@link GameHighScore} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getgamehighscores">
     * getGameHighScores</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = GET, path = "getGameHighScores")
    public ArrayList<GameHighScore> getGameHighScores(User user, Params parameters) throws IOException {
        return getGameHighScores(user.getId(), parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to get data for high score tables. Will return the score of the specified user and several of their
     * neighbors in a game <br>
     *
     * @param user:       the user from fetch the high scores
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return game high scores list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getgamehighscores">
     * getGameHighScores</a>
     */
    @WrappedRequest
    @RequestPath(method = GET, path = "getGameHighScores")
    public <T> T getGameHighScores(User user, Params parameters, ReturnFormat format) throws IOException {
        return getGameHighScores(user.getId(), parameters, format);
    }

    /**
     * Request to get data for high score tables. Will return the score of the specified user and several of their
     * neighbors in a game <br>
     *
     * @param userId:     user identifier
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                    </ul>
     * @return game high scores list as {@link ArrayList} of {@link GameHighScore} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getgamehighscores">
     * getGameHighScores</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getGameHighScores")
    public ArrayList<GameHighScore> getGameHighScores(long userId, Params parameters) throws IOException {
        return getGameHighScores(userId, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to get data for high score tables. Will return the score of the specified user and several of their
     * neighbors in a game <br>
     *
     * @param userId:     user identifier
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return game high scores list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getgamehighscores">
     * getGameHighScores</a>
     */
    @RequestPath(method = GET, path = "getGameHighScores")
    public <T> T getGameHighScores(long userId, Params parameters, ReturnFormat format) throws IOException {
        parameters.addParam("user_id", userId);
        JSONArray result = getResultFromList(sendGetRequest(GET_GAME_HIGH_SCORES_ENDPOINT, parameters));
        return switch (format) {
            case JSON -> (T) result;
            case LIBRARY_OBJECT -> {
                ArrayList<GameHighScore> highScores = new ArrayList<>();
                for (int j = 0; j < result.length(); j++)
                    highScores.add(new GameHighScore(result.getJSONObject(j)));
                yield (T) highScores;
            }
            default -> (T) result.toString();
        };
    }

}
