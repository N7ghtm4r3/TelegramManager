package com.tecknobit.telegrammanager.botapi.records.structures;

import com.tecknobit.apimanager.annotations.Structure;
import org.json.JSONObject;

/**
 * The {@code TelegramType} class is useful to format a {@code Telegram}'s type
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#available-types">
 * Available types</a>
 * @see TelegramTypeStructure
 */
@Structure
public abstract class TelegramType extends TelegramTypeStructure {

    /**
     * {@code ok} whether the response has been successful
     */
    protected final boolean ok;

    /**
     * {@code errorCode} error code of the response
     */
    protected final int errorCode;

    /**
     * {@code description} of the response
     */
    protected final String description;

    /**
     * {@code parameters} of the response
     */
    protected final ResponseParameters parameters;

    /**
     * Constructor to init a {@link TelegramType} object
     *
     * @param jTelegramType: {@code jTelegramType} of the
     */
    public TelegramType(JSONObject jTelegramType) {
        super(jTelegramType);
        ok = hTelegram.getBoolean("ok");
        errorCode = hTelegram.getInt("error_code", -1);
        description = hTelegram.getString("description");
        JSONObject jParameters = hTelegram.getJSONObject("parameters");
        if (jParameters != null)
            parameters = new ResponseParameters(jParameters);
        else
            parameters = null;
        if (ok)
            hTelegram.setJSONObjectSource(jTelegramType.getJSONObject("result"));
    }

    /**
     * Method to get {@link #ok} instance <br>
     * No-any params required
     *
     * @return {@link #ok} instance as boolean
     */
    public boolean isOk() {
        return ok;
    }

    /**
     * Method to get {@link #errorCode} instance <br>
     * No-any params required
     *
     * @return {@link #errorCode} instance as int
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Method to get {@link #description} instance <br>
     * No-any params required
     *
     * @return {@link #description} instance as {@link String}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to get {@link #parameters} instance <br>
     * No-any params required
     *
     * @return {@link #parameters} instance as {@link ResponseParameters}
     */
    public ResponseParameters getParameters() {
        return parameters;
    }

    /**
     * The {@code ResponseParameters} class is useful to format a {@code Telegram}'s response parameters
     *
     * @author N7ghtm4r3 - Tecknobit
     * @see TelegramTypeStructure
     */
    public static class ResponseParameters extends TelegramTypeStructure {

        /**
         * {@code migrateToChatId} the group has been migrated to a supergroup with the specified identifier
         */
        private final long migrateToChatId;

        /**
         * {@code retryAfter} in case of exceeding flood control, the number of seconds left to wait before the request can be repeated
         */
        private final long retryAfter;

        /**
         * Constructor to init a {@link ResponseParameters} object
         *
         * @param migrateToChatId: the group has been migrated to a supergroup with the specified identifier
         * @param retryAfter:      in case of exceeding flood control, the number of seconds left to wait before the request can be repeated
         */
        public ResponseParameters(long migrateToChatId, long retryAfter) {
            super(null);
            this.migrateToChatId = migrateToChatId;
            this.retryAfter = retryAfter;
        }

        /**
         * Constructor to init a {@link ResponseParameters} object
         *
         * @param jResponseParameters: {@code jResponseParameters} of the
         */
        public ResponseParameters(JSONObject jResponseParameters) {
            super(jResponseParameters);
            migrateToChatId = hTelegram.getLong("migrate_to_chat_id", -1);
            retryAfter = hTelegram.getLong("retry_after", -1);
        }

        /**
         * Method to get {@link #migrateToChatId} instance <br>
         * No-any params required
         *
         * @return {@link #migrateToChatId} instance as long
         */
        public long getMigrateToChatId() {
            return migrateToChatId;
        }

        /**
         * Method to get {@link #retryAfter} instance <br>
         * No-any params required
         *
         * @return {@link #retryAfter} instance as long
         */
        public long getRetryAfter() {
            return retryAfter;
        }

    }

}
