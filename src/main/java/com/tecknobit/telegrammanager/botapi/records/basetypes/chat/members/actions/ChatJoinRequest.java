package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members.actions;

import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.ChatInviteLink;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ChatJoinRequest} class is useful to format a {@code Telegram}'s chat join request
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatjoinrequest">
 * ChatJoinRequest</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ChatAction
 */
public class ChatJoinRequest extends ChatAction {

    /**
     * {@code userChatId} identifier of a private chat with the user who sent the join request. This number may have
     * more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it.
     * But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing
     * this identifier. The bot can use this identifier for 24 hours to send messages until the join request is processed,
     * assuming no other administrator contacted the user
     */
    private final long userChatId;

    /**
     * {@code bio} of the user
     */
    private final String bio;

    /**
     * Constructor to init a {@link ChatJoinRequest} object
     *
     * @param chat:       chat to which the request was sent
     * @param from:       user that sent the join request
     * @param date:       date the request was sent in Unix time
     * @param inviteLink: chat invite link that was used by the user to send the join request
     * @param userChatId: identifier of a private chat with the user who sent the join request. This number may have
     *                    more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it.
     *                    But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing
     *                    this identifier. The bot can use this identifier for 24 hours to send messages until the join request is processed,
     *                    assuming no other administrator contacted the user
     * @param bio:        bio of the user
     */
    public ChatJoinRequest(Chat chat, User from, long date, ChatInviteLink inviteLink, long userChatId, String bio) {
        super(chat, from, date, inviteLink);
        this.userChatId = userChatId;
        this.bio = bio;
    }

    /**
     * Constructor to init a {@link ChatJoinRequest} object
     *
     * @param jChatJoinRequest: chat join request details as {@link JSONObject}
     */
    public ChatJoinRequest(JSONObject jChatJoinRequest) {
        super(null);
        userChatId = hTelegram.getLong("user_chat_id");
        bio = hTelegram.getString("bio");
    }

    /**
     * Method to get {@link #userChatId} instance <br>
     * No-any params required
     *
     * @return {@link #userChatId} instance as long
     */
    public long getUserChatId() {
        return userChatId;
    }

    /**
     * Method to get {@link #bio} instance <br>
     * No-any params required
     *
     * @return {@link #bio} instance as {@link String}
     */
    public String getBio() {
        return bio;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatJoinRequest}
     */
    public static ChatJoinRequest getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatJoinRequest(jItem);
    }

}
