package com.tecknobit.telegrammanager.botapi.updates;

import com.tecknobit.telegrammanager.botapi.TelegramBotManager;

/**
 * The {@code TelegramBotUpdatesManager} class is useful to format a {@code Telegram}'s updates manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getting-updates">
 * Getting updates</a>
 * @see TelegramBotManager
 */
public class TelegramBotUpdatesManager extends TelegramBotManager {

    /**
     * Constructor to init {@link TelegramBotUpdatesManager}
     *
     * @param token               : the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public TelegramBotUpdatesManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link TelegramBotUpdatesManager}
     *
     * @param token          : the bot unique authentication token
     * @param requestTimeout :       timeout for the requests
     */
    public TelegramBotUpdatesManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link TelegramBotUpdatesManager}
     *
     * @param token : the bot unique authentication token
     */
    public TelegramBotUpdatesManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link TelegramBotUpdatesManager}
     *
     * @param token               : the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :       timeout for the requests
     */
    public TelegramBotUpdatesManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init a {@link TelegramBotUpdatesManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link TelegramBotUpdatesManager}'s manager without re-insert
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
    public TelegramBotUpdatesManager() throws Exception {
        super();
    }

}
