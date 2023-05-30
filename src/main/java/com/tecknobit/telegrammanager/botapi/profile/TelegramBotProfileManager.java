package com.tecknobit.telegrammanager.botapi.profile;

import com.tecknobit.telegrammanager.botapi.TelegramBotManager;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;

import java.io.IOException;

import static com.tecknobit.telegrammanager.botapi.TelegramBotManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User.returnUser;

/**
 * The {@code TelegramBotManager} class is useful to create a {@code Telegram}'s bot profile manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#available-methods">
 * Available methods</a>
 */
public class TelegramBotProfileManager extends TelegramBotManager {

    /**
     * {@code GET_ME_ENDPOINT} is constant for GET_ME_ENDPOINT's endpoint
     **/
    public static final String GET_ME_ENDPOINT = "getMe";

    /**
     * {@code LOG_OUT_ENDPOINT} is constant for LOG_OUT_ENDPOINT's endpoint
     **/
    public static final String LOG_OUT_ENDPOINT = "logOut";

    /**
     * {@code CLOSE_ENDPOINT} is constant for CLOSE_ENDPOINT's endpoint
     **/
    public static final String CLOSE_ENDPOINT = "close";

    /**
     * Constructor to init {@link TelegramBotProfileManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public TelegramBotProfileManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link TelegramBotProfileManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public TelegramBotProfileManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link TelegramBotProfileManager}
     *
     * @param token : the bot unique authentication token
     */
    public TelegramBotProfileManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link TelegramBotProfileManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public TelegramBotProfileManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init a {@link TelegramBotProfileManager} object <br>
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
    public TelegramBotProfileManager() throws Exception {
        super();
    }

    public User getMe() throws IOException {
        return getMe(LIBRARY_OBJECT);
    }

    public <T> T getMe(ReturnFormat format) throws IOException {
        return returnUser(sendGETRequest(GET_ME_ENDPOINT), format);
    }

}
