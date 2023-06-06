package com.tecknobit.telegrammanager.botapi.managers;

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

}
