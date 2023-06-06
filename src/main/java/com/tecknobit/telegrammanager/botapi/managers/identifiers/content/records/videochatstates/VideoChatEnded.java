package com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.videochatstates;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code VideoChatEnded} class is useful to format a {@code Telegram}'s video chat ended
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#videochatended">
 * VideoChatEnded</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class VideoChatEnded extends TelegramType {

    /**
     * {@code duration} video chat duration in seconds
     */
    private final int duration;

    /**
     * Constructor to init a {@link VideoChatEnded} object
     *
     * @param duration: video chat duration in seconds
     */
    public VideoChatEnded(int duration) {
        super(null);
        this.duration = duration;
    }

    /**
     * Constructor to init a {@link VideoChatEnded} object
     *
     * @param jVideoChatEnded: video chat ended details as {@link JSONObject}
     */
    public VideoChatEnded(JSONObject jVideoChatEnded) {
        super(jVideoChatEnded);
        duration = hTelegram.getInt("duration");
    }

    /**
     * Method to get {@link #duration} instance <br>
     * No-any params required
     *
     * @return {@link #duration} instance as int
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link VideoChatEnded}
     */
    public static VideoChatEnded getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new VideoChatEnded(jItem);
    }

}
