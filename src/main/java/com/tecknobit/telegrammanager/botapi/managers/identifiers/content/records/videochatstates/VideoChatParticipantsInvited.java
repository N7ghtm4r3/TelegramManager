package com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.videochatstates;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code VideoChatParticipantsInvited} class is useful to format a {@code Telegram}'s video chat participants invited
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#videochatparticipantsinvited">
 * VideoChatParticipantsInvited</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class VideoChatParticipantsInvited extends TelegramType {

    /**
     * {@code users} new members that were invited to the video chat
     */
    private final ArrayList<User> users;

    /**
     * Constructor to init a {@link VideoChatParticipantsInvited} object
     *
     * @param users: new members that were invited to the video chat
     */
    public VideoChatParticipantsInvited(ArrayList<User> users) {
        super(null);
        this.users = users;
    }

    /**
     * Constructor to init a {@link VideoChatParticipantsInvited} object
     *
     * @param jVideoChatParticipantsInvited: video chat participants invited details as {@link JSONObject}
     */
    public VideoChatParticipantsInvited(JSONObject jVideoChatParticipantsInvited) {
        super(jVideoChatParticipantsInvited);
        users = User.returnUsers(hTelegram.getJSONArray("users"));
    }

    /**
     * Method to get {@link #users} instance <br>
     * No-any params required
     *
     * @return {@link #users} instance as {@link ArrayList} of {@link User}
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link VideoChatParticipantsInvited}
     */
    public static VideoChatParticipantsInvited getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new VideoChatParticipantsInvited(jItem);
    }

}
