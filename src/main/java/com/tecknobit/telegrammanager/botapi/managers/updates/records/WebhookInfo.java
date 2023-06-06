package com.tecknobit.telegrammanager.botapi.managers.updates.records;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * The {@code WebhookInfo} class is useful to format a {@code Telegram}'s webhook info
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#webhookinfo">
 * WebhookInfo</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class WebhookInfo extends TelegramType {

    /**
     * {@code url} webhook URL, may be empty if webhook is not set up
     */
    private final String url;

    /**
     * {@code hasCustomCertificate} if a custom certificate was provided for webhook certificate checks
     */
    private final boolean hasCustomCertificate;

    /**
     * {@code pendingUpdateCount} number of updates awaiting delivery
     */
    private final int pendingUpdateCount;

    /**
     * {@code ipAddress} currently used webhook IP address
     */
    private final String ipAddress;

    /**
     * {@code lastErrorDate} unix time for the most recent error that happened when trying to deliver an update via webhook
     */
    private final long lastErrorDate;

    /**
     * {@code lastErrorMessage} error message in human-readable format for the most recent error that happened when
     * trying to deliver an update via webhook
     */
    private final String lastErrorMessage;

    /**
     * {@code lastSynchronizationErrorDate} unix time of the most recent error that happened when trying to synchronize
     * available updates with Telegram datacenters
     */
    private final long lastSynchronizationErrorDate;

    /**
     * {@code maxConnections} the maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
     */
    private final int maxConnections;

    /**
     * {@code allowedOptions} a list of update types the bot is subscribed to
     */
    private final ArrayList<String> allowedOptions;

    /**
     * Constructor to init a {@link WebhookInfo} object
     *
     * @param url:                          webhook URL, may be empty if webhook is not set up
     * @param hasCustomCertificate:         if a custom certificate was provided for webhook certificate checks
     * @param pendingUpdateCount:           number of updates awaiting delivery
     * @param ipAddress:                    currently used webhook IP address
     * @param lastErrorDate:                unix time for the most recent error that happened when trying to deliver an update via webhook
     * @param lastErrorMessage:             error message in human-readable format for the most recent error that happened when
     *                                      trying to deliver an update via webhook
     * @param lastSynchronizationErrorDate: unix time of the most recent error that happened when trying to synchronize
     *                                      available updates with Telegram datacenters
     * @param maxConnections:               the maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
     * @param allowedOptions:               a list of update types the bot is subscribed to
     */
    public WebhookInfo(String url, boolean hasCustomCertificate, int pendingUpdateCount, String ipAddress,
                       long lastErrorDate, String lastErrorMessage, long lastSynchronizationErrorDate, int maxConnections,
                       ArrayList<String> allowedOptions) {
        super(null);
        this.url = url;
        this.hasCustomCertificate = hasCustomCertificate;
        this.pendingUpdateCount = pendingUpdateCount;
        this.ipAddress = ipAddress;
        this.lastErrorDate = lastErrorDate;
        this.lastErrorMessage = lastErrorMessage;
        this.lastSynchronizationErrorDate = lastSynchronizationErrorDate;
        this.maxConnections = maxConnections;
        this.allowedOptions = allowedOptions;
    }

    /**
     * Constructor to init a {@link WebhookInfo} object
     *
     * @param jWebhookInfo: webhook details as {@link JSONObject}
     */
    public WebhookInfo(JSONObject jWebhookInfo) {
        super(jWebhookInfo);
        url = hTelegram.getString("url");
        hasCustomCertificate = hTelegram.getBoolean("has_custom_certificate");
        pendingUpdateCount = hTelegram.getInt("pending_update_count");
        ipAddress = hTelegram.getString("ip_address");
        lastErrorDate = hTelegram.getLong("last_error_date", 0);
        lastErrorMessage = hTelegram.getString("last_error_message");
        lastSynchronizationErrorDate = hTelegram.getLong("last_synchronization_error_date", 0);
        maxConnections = hTelegram.getInt("max_connections", 0);
        allowedOptions = fetchStringsList(hTelegram.getJSONArray("allowed_updates"));
    }

    /**
     * Method to get {@link #url} instance <br>
     * No-any params required
     *
     * @return {@link #url} instance as {@link String}
     */
    public String getUrl() {
        return url;
    }

    /**
     * Method to get {@link #hasCustomCertificate} instance <br>
     * No-any params required
     *
     * @return {@link #hasCustomCertificate} instance as boolean
     */
    public boolean hasCustomCertificate() {
        return hasCustomCertificate;
    }

    /**
     * Method to get {@link #pendingUpdateCount} instance <br>
     * No-any params required
     *
     * @return {@link #pendingUpdateCount} instance as int
     */
    public int getPendingUpdateCount() {
        return pendingUpdateCount;
    }

    /**
     * Method to get {@link #ipAddress} instance <br>
     * No-any params required
     *
     * @return {@link #ipAddress} instance as {@link String}
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Method to get {@link #lastErrorDate} instance <br>
     * No-any params required
     *
     * @return {@link #lastErrorDate} instance as long
     */
    public long getLastErrorDateTimestamp() {
        return lastErrorDate;
    }

    /**
     * Method to get {@link #lastErrorDate} instance <br>
     * No-any params required
     *
     * @return {@link #lastErrorDate} instance as {@link Date}
     */
    public Date getLastErrorDate() {
        return getDateValue(lastErrorDate);
    }

    /**
     * Method to get {@link #lastErrorMessage} instance <br>
     * No-any params required
     *
     * @return {@link #lastErrorMessage} instance as {@link String}
     */
    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    /**
     * Method to get {@link #lastSynchronizationErrorDate} instance <br>
     * No-any params required
     *
     * @return {@link #lastSynchronizationErrorDate} instance as long
     */
    public long getLastSynchronizationErrorDateTimestamp() {
        return lastSynchronizationErrorDate;
    }

    /**
     * Method to get {@link #lastSynchronizationErrorDate} instance <br>
     * No-any params required
     *
     * @return {@link #lastSynchronizationErrorDate} instance as {@link Date}
     */
    public Date getLastSynchronizationErrorDate() {
        return getDateValue(lastSynchronizationErrorDate);
    }

    /**
     * Method to get {@link #maxConnections} instance <br>
     * No-any params required
     *
     * @return {@link #maxConnections} instance as int
     */
    public int getMaxConnections() {
        return maxConnections;
    }

    /**
     * Method to get {@link #allowedOptions} instance <br>
     * No-any params required
     *
     * @return {@link #allowedOptions} instance as {@link ArrayList} of {@link String}
     */
    public ArrayList<String> getAllowedOptions() {
        return allowedOptions;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link WebhookInfo}
     */
    public static WebhookInfo getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new WebhookInfo(jItem);
    }

}
