package com.tecknobit.telegrammanager.botapi.records.basetypes.media.videochatstates;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code VideoChatStarted} class is useful to format a {@code Telegram}'s video chat started
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#videochatstarted">
 * VideoChatStarted</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class VideoChatStarted extends TelegramType {

    /**
     * Constructor to init a {@link VideoChatStarted} object
     *
     * @param jVideoChatStarted: video chat started details as {@link JSONObject}
     */
    public VideoChatStarted(JSONObject jVideoChatStarted) {
        super(jVideoChatStarted);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link VideoChatStarted}
     */
    public static VideoChatStarted getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new VideoChatStarted(jItem);
    }

}
