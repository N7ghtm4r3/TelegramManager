package com.tecknobit.telegrammanager.botapi.managers.games;

import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.managers.games.records.GameHighScore;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.TelegramIdentifierManager;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.Chat;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

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

    public Message sendGame(Chat chat, String gameShortName) throws IOException {
        return sendGame(chat.getId(), gameShortName, LIBRARY_OBJECT);
    }

    public <T> T sendGame(Chat chat, String gameShortName, ReturnFormat format) throws IOException {
        return sendGame(chat.getId(), gameShortName, format);
    }

    public Message sendGame(long chatId, String gameShortName) throws IOException {
        return sendGame(chatId, gameShortName, LIBRARY_OBJECT);
    }

    public <T> T sendGame(long chatId, String gameShortName, ReturnFormat format) throws IOException {
        return sendGame(chatId, gameShortName, null, format);
    }

    public Message sendGame(Chat chat, String gameShortName, Params parameters) throws IOException {
        return sendGame(chat.getId(), gameShortName, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendGame(Chat chat, String gameShortName, Params parameters, ReturnFormat format) throws IOException {
        return sendGame(chat.getId(), gameShortName, parameters, format);
    }

    public Message sendGame(long chatId, String gameShortName, Params parameters) throws IOException {
        return sendGame(chatId, gameShortName, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendGame(long chatId, String gameShortName, Params parameters, ReturnFormat format) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("chat_id", chatId);
        parameters.addParam("game_short_name", gameShortName);
        return returnMessage(sendPostRequest(SEND_GAME_ENDPOINT, parameters), format);
    }

    public <T> T setGameScore(User user, int score, Params parameters) throws IOException {
        return setGameScore(user.getId(), score, parameters, LIBRARY_OBJECT);
    }

    public <T> T setGameScore(User user, int score, Params parameters, ReturnFormat format) throws IOException {
        return setGameScore(user.getId(), score, parameters, format);
    }

    public <T> T setGameScore(long userId, int score, Params parameters) throws IOException {
        return setGameScore(userId, score, parameters, LIBRARY_OBJECT);
    }

    public <T> T setGameScore(long userId, int score, Params parameters, ReturnFormat format) throws IOException {
        parameters.addParam("user_id", userId);
        parameters.addParam("score", score);
        return getMessageOrBooleanResponse(sendPostRequest(SET_GAME_SCORE_ENDPOINT, parameters), format);
    }

    public ArrayList<GameHighScore> getGameHighScores(User user, Params parameters) throws IOException {
        return getGameHighScores(user.getId(), parameters, LIBRARY_OBJECT);
    }

    public <T> T getGameHighScores(User user, Params parameters, ReturnFormat format) throws IOException {
        return getGameHighScores(user.getId(), parameters, format);
    }

    public ArrayList<GameHighScore> getGameHighScores(long userId, Params parameters) throws IOException {
        return getGameHighScores(userId, parameters, LIBRARY_OBJECT);
    }

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
