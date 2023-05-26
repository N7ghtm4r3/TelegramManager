package com.tecknobit.telegrammanager.botapi.records.basetypes.media.videochatstates;

import com.tecknobit.telegrammanager.botapi.records.basetypes.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

import java.util.ArrayList;

public class VideoChatParticipantsInvited extends TelegramType {

    private final ArrayList<User> users;

    public VideoChatParticipantsInvited(ArrayList<User> users) {
        super(null);
        this.users = users;
    }

    public VideoChatParticipantsInvited(JSONObject jVideoChatParticipantsInvited) {
        super(jVideoChatParticipantsInvited);
        users = User.returnUsers(hTelegram.getJSONArray("users"));
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public static VideoChatParticipantsInvited getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new VideoChatParticipantsInvited(jItem);
    }

}
