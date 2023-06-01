package com.tecknobit.telegrammanager.botapi.managers;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;

import java.io.IOException;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramBotManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User.returnUser;

/**
 * The {@code TelegramBotManager} class is useful to create a {@code Telegram}'s bot profile manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#available-methods">
 * Available methods</a>
 */
public class ProfileManager extends TelegramBotManager {

    /**
     * {@code GET_ME_ENDPOINT} is constant for GET_ME_ENDPOINT's endpoint
     */
    public static final String GET_ME_ENDPOINT = "getMe";

    /**
     * {@code LOG_OUT_ENDPOINT} is constant for LOG_OUT_ENDPOINT's endpoint
     */
    public static final String LOG_OUT_ENDPOINT = "logOut";

    /**
     * {@code CLOSE_ENDPOINT} is constant for CLOSE_ENDPOINT's endpoint
     */
    public static final String CLOSE_ENDPOINT = "close";

    /**
     * Constructor to init {@link ProfileManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public ProfileManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link ProfileManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public ProfileManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link ProfileManager}
     *
     * @param token : the bot unique authentication token
     */
    public ProfileManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link ProfileManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public ProfileManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init a {@link ProfileManager} object <br>
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
    public ProfileManager() throws Exception {
        super();
    }

    /**
     * Request to testing your bot's authentication token <br>
     * No-any params required
     *
     * @return user as {@link User} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getme">
     * getMe</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getMe")
    public User getMe() throws IOException {
        return getMe(LIBRARY_OBJECT);
    }

    /**
     * Request to testing your bot's authentication token
     *
     * @param format: return type formatter -> {@link ReturnFormat}
     * @return user as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getme">
     * getMe</a>
     */
    @RequestPath(method = GET, path = "getMe")
    public <T> T getMe(ReturnFormat format) throws IOException {
        return returnUser(sendGETRequest(GET_ME_ENDPOINT), format);
    }

    /**
     * Method to log out from the cloud Bot API server before launching the bot locally. You must log out the bot
     * before running it locally, otherwise there is no guarantee that the bot will receive updates. After a successful
     * call, you can immediately log in on a local server, but will not be able to log in back to the cloud Bot API
     * server for 10 minutes <br>
     * No-any params required
     *
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} and error printed with {@link #printErrorResponse()} method if not successful
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#logout">
     * logOut</a>
     */
    @RequestPath(method = POST, path = "logOut")
    public boolean logOut() {
        try {
            sendPostRequest(LOG_OUT_ENDPOINT);
            return true;
        } catch (IOException e) {
            printErrorResponse();
            return false;
        }
    }

    /**
     * Method to cclose the bot instance before moving it from one local server to another. You need to delete the
     * webhook before calling this method to ensure that the bot isn't launched again after server restart. The method
     * will return error 429 in the first 10 minutes after the bot is launched <br>
     * No-any params required
     *
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} and error printed with {@link #printErrorResponse()} method if not successful
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#close">
     * close</a>
     */
    @RequestPath(method = POST, path = "close")
    public boolean close() {
        try {
            sendPostRequest(CLOSE_ENDPOINT);
            return true;
        } catch (IOException e) {
            printErrorResponse();
            return false;
        }
    }

}
