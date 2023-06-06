package com.tecknobit.telegrammanager.botapi.managers.passport;

import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.managers.passport.records.errors.PassportElementError;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;

import java.io.IOException;
import java.util.Arrays;

/**
 * The {@code PassportManager} class is useful to create a {@code Telegram}'s bot passport manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#telegram-passport">
 * Telegram Passport</a>
 * @see TelegramManager
 */
public class PassportManager extends TelegramManager {

    /**
     * {@code SET_PASSPORT_DATA_ERRORS_ENDPOINT} is constant for SET_PASSPORT_DATA_ERRORS_ENDPOINT's endpoint
     */
    public static final String SET_PASSPORT_DATA_ERRORS_ENDPOINT = "setPassportDataErrors";

    /**
     * Constructor to init {@link PassportManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public PassportManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link PassportManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public PassportManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link PassportManager}
     *
     * @param token : the bot unique authentication token
     */
    public PassportManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link PassportManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public PassportManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link PassportManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link PassportManager}'s manager without re-insert
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
    public PassportManager() throws Exception {
        super();
    }

    public boolean setPassportDataErrors(User userId, PassportElementError... errors) throws IOException {
        return setPassportDataErrors(userId.getId(), errors);
    }

    public boolean setPassportDataErrors(long userId, PassportElementError... errors) throws IOException {
        Params payload = new Params();
        payload.addParam("user_id", userId);
        payload.addParam("errors", Arrays.toString(errors));
        return getBooleanResponse(sendPostRequest(SET_PASSPORT_DATA_ERRORS_ENDPOINT, payload));
    }

}
