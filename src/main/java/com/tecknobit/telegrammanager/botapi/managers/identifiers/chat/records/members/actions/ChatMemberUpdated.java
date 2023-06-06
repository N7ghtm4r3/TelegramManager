package com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.members.actions;

import com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.Chat;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.ChatInviteLink;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.members.ChatMember;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ChatMemberUpdated} class is useful to format a {@code Telegram}'s chat member updated
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="">
 * </a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ChatAction
 */
public class ChatMemberUpdated extends ChatAction {

    /**
     * {@code oldChatMember} previous information about the chat member
     */
    private final ChatMember oldChatMember;

    /**
     * {@code newChatMember} new information about the chat member
     */
    private final ChatMember newChatMember;

    /**
     * {@code viaChatFolderInviteLink} if the user joined the chat via a chat folder invite link
     */
    private final boolean viaChatFolderInviteLink;

    /**
     * Constructor to init a {@link ChatMemberUpdated} object
     *
     * @param chat:                    chat the user belongs to
     * @param from:                    performer of the action, which resulted in the change
     * @param date:                    date the change was done in Unix time
     * @param inviteLink:              chat invite link, which was used by the user to join the chat; for joining by invite link events
     *                                 only
     * @param oldChatMember:           previous information about the chat member
     * @param newChatMember:           new information about the chat member
     * @param viaChatFolderInviteLink: if the user joined the chat via a chat folder invite link
     */
    public ChatMemberUpdated(Chat chat, User from, long date, ChatInviteLink inviteLink, ChatMember oldChatMember,
                             ChatMember newChatMember, boolean viaChatFolderInviteLink) {
        super(chat, from, date, inviteLink);
        this.oldChatMember = oldChatMember;
        this.newChatMember = newChatMember;
        this.viaChatFolderInviteLink = viaChatFolderInviteLink;
    }

    /**
     * Constructor to init a {@link ChatMemberUpdated} object
     *
     * @param jChatMemberUpdated: chat member updated details as {@link JSONObject}
     */
    public ChatMemberUpdated(JSONObject jChatMemberUpdated) {
        super(jChatMemberUpdated);
        oldChatMember = new ChatMember(hTelegram.getJSONObject("old_chat_member"));
        newChatMember = new ChatMember(hTelegram.getJSONObject("new_chat_member"));
        viaChatFolderInviteLink = hTelegram.getBoolean("via_chat_folder_invite_link");
    }

    /**
     * Method to get {@link #oldChatMember} instance <br>
     * No-any params required
     *
     * @return {@link #oldChatMember} instance as {@link ChatMember}
     */
    public ChatMember getOldChatMember() {
        return oldChatMember;
    }

    /**
     * Method to get {@link #newChatMember} instance <br>
     * No-any params required
     *
     * @return {@link #newChatMember} instance as {@link ChatMember}
     */
    public ChatMember getNewChatMember() {
        return newChatMember;
    }

    /**
     * Method to get {@link #viaChatFolderInviteLink} instance <br>
     * No-any params required
     *
     * @return {@link #viaChatFolderInviteLink} instance as boolean
     */
    public boolean isViaChatFolderInviteLink() {
        return viaChatFolderInviteLink;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatMemberUpdated}
     */
    public static ChatMemberUpdated getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatMemberUpdated(jItem);
    }

}
