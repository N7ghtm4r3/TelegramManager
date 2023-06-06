package com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.videochatstates;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.Date;

/**
 * The {@code VideoChatScheduled} class is useful to format a {@code Telegram}'s video chat scheduled
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#videochatscheduled">
 * VideoChatScheduled</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class VideoChatScheduled extends TelegramType {

    /**
     * {@code startDate} point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator
     */
    private final long startDate;

    /**
     * Constructor to init a {@link VideoChatScheduled} object
     *
     * @param startDate: point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator
     */
    public VideoChatScheduled(long startDate) {
        super(null);
        this.startDate = startDate;
    }

    /**
     * Constructor to init a {@link VideoChatScheduled} object
     *
     * @param jVideoChatScheduled: video chat scheduled details as {@link JSONObject}
     */
    public VideoChatScheduled(JSONObject jVideoChatScheduled) {
        super(jVideoChatScheduled);
        startDate = hTelegram.getLong("start_date");
    }

    /**
     * Method to get {@link #startDate} instance <br>
     * No-any params required
     *
     * @return {@link #startDate} instance as long
     */
    public long getStartDateTimestamp() {
        return startDate;
    }

    /**
     * Method to get {@link #startDate} instance <br>
     * No-any params required
     *
     * @return {@link #startDate} instance as {@link Date}
     */
    public Date getStartDate() {
        return getDateValue(startDate);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link VideoChatScheduled}
     */
    public static VideoChatScheduled getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new VideoChatScheduled(jItem);
    }

}
