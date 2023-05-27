package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members.ChatMember.ChatMemberStatus.administrator;

/**
 * The {@code ChatMemberAdministrator} class is useful to format a {@code Telegram}'s chat member administrator
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatmemberadministrator">
 * ChatMemberAdministrator</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ChatMember
 * @see ChatMemberOwner
 */
public class ChatMemberAdministrator extends ChatMemberOwner {

    /**
     * {@code canBeEdited} if the bot is allowed to edit administrator privileges of that user
     */
    private final boolean canBeEdited;

    /**
     * {@code canManageChat} if the administrator can access the chat event log, chat statistics, message statistics
     * in channels, see channel members, see anonymous administrators in supergroups and ignore slow mode.
     * Implied by any other administrator privilege
     */
    private final boolean canManageChat;

    /**
     * {@code canDeleteMessages} if the administrator can delete messages of other users
     */
    private final boolean canDeleteMessages;

    /**
     * {@code canManageVideoChats} if the administrator can manage video chats
     */
    private final boolean canManageVideoChats;

    /**
     * {@code canRestrictMembers} if the administrator can restrict, ban or unban chat members
     */
    private final boolean canRestrictMembers;

    /**
     * {@code canPromoteMembers} if the administrator can add new administrators with a subset of their own privileges or
     * demote administrators that they have promoted, directly or indirectly (promoted by administrators that were
     * appointed by the user)
     */
    private final boolean canPromoteMembers;

    /**
     * {@code canChangeInfo} if the user is allowed to change the chat title, photo and other settings
     */
    private final boolean canChangeInfo;

    /**
     * {@code canInviteUsers} if the user is allowed to invite new users to the chat
     */
    private final boolean canInviteUsers;

    /**
     * {@code canPostMessages} if the administrator can post in the channel; channels only
     */
    private final boolean canPostMessages;

    /**
     * {@code canEditMessages} if the administrator can edit messages of other users and can pin messages; channels only
     */
    private final boolean canEditMessages;

    /**
     * {@code canPinMessages} if the user is allowed to pin messages; groups and supergroups only
     */
    private final boolean canPinMessages;

    /**
     * {@code canManageTopics} if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     */
    private final boolean canManageTopics;

    /**
     * Constructor to init a {@link ChatMemberAdministrator} object
     *
     * @param user:                information about the user
     * @param isAnonymous:         if the user's presence in the chat is hidden
     * @param customTitle:         custom title for this user
     * @param canBeEdited:         if the bot is allowed to edit administrator privileges of that user
     * @param canManageChat:       if the administrator can access the chat event log, chat statistics, message statistics in
     *                             channels, see channel members, see anonymous administrators in supergroups and ignore slow mode. Implied by any
     *                             other administrator privilege
     * @param canDeleteMessages:   if the administrator can delete messages of other users
     * @param canManageVideoChats: if the administrator can manage video chats
     * @param canRestrictMembers:  if the administrator can restrict, ban or unban chat members
     * @param canPromoteMembers:   if the administrator can add new administrators with a subset of their own privileges or
     *                             demote administrators that they have promoted, directly or indirectly (promoted by administrators that were
     *                             appointed by the user)
     * @param canChangeInfo:       if the user is allowed to change the chat title, photo and other settings
     * @param canInviteUsers:      if the administrator can post in the channel; channels only
     * @param canPostMessages:     if the administrator can post in the channel; channels only
     * @param canEditMessages:     if the administrator can edit messages of other users and can pin messages; channels only
     * @param canPinMessages:      if the user is allowed to pin messages; groups and supergroups only
     * @param canManageTopics:     if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     */
    public ChatMemberAdministrator(User user, boolean isAnonymous, String customTitle, boolean canBeEdited,
                                   boolean canManageChat, boolean canDeleteMessages, boolean canManageVideoChats,
                                   boolean canRestrictMembers, boolean canPromoteMembers, boolean canChangeInfo,
                                   boolean canInviteUsers, boolean canPostMessages, boolean canEditMessages,
                                   boolean canPinMessages, boolean canManageTopics) {
        super(administrator, user, isAnonymous, customTitle);
        this.canBeEdited = canBeEdited;
        this.canManageChat = canManageChat;
        this.canDeleteMessages = canDeleteMessages;
        this.canManageVideoChats = canManageVideoChats;
        this.canRestrictMembers = canRestrictMembers;
        this.canPromoteMembers = canPromoteMembers;
        this.canChangeInfo = canChangeInfo;
        this.canInviteUsers = canInviteUsers;
        this.canPostMessages = canPostMessages;
        this.canEditMessages = canEditMessages;
        this.canPinMessages = canPinMessages;
        this.canManageTopics = canManageTopics;
    }

    /**
     * Constructor to init a {@link ChatMemberAdministrator} object
     *
     * @param jChatMemberAdministrator: chat member administrator details as {@link JSONObject}
     */
    public ChatMemberAdministrator(JSONObject jChatMemberAdministrator) {
        super(jChatMemberAdministrator);
        canBeEdited = hTelegram.getBoolean("can_be_edited");
        canManageChat = hTelegram.getBoolean("can_manage_chat");
        canDeleteMessages = hTelegram.getBoolean("can_delete_messages");
        canManageVideoChats = hTelegram.getBoolean("can_manage_video_chats");
        canRestrictMembers = hTelegram.getBoolean("can_restrict_members");
        canPromoteMembers = hTelegram.getBoolean("can_promote_members");
        canChangeInfo = hTelegram.getBoolean("can_change_info");
        canInviteUsers = hTelegram.getBoolean("can_invite_users");
        canPostMessages = hTelegram.getBoolean("can_post_messages");
        canEditMessages = hTelegram.getBoolean("can_edit_messages");
        canPinMessages = hTelegram.getBoolean("can_pin_messages");
        canManageTopics = hTelegram.getBoolean("can_manage_topics");
    }

    /**
     * Method to get {@link #canBeEdited} instance <br>
     * No-any params required
     *
     * @return {@link #canBeEdited} instance as boolean
     */
    public boolean canBeEdited() {
        return canBeEdited;
    }

    /**
     * Method to get {@link #canManageChat} instance <br>
     * No-any params required
     *
     * @return {@link #canManageChat} instance as boolean
     */
    public boolean canManageChat() {
        return canManageChat;
    }

    /**
     * Method to get {@link #canDeleteMessages} instance <br>
     * No-any params required
     *
     * @return {@link #canDeleteMessages} instance as boolean
     */
    public boolean canDeleteMessages() {
        return canDeleteMessages;
    }

    /**
     * Method to get {@link #canManageVideoChats} instance <br>
     * No-any params required
     *
     * @return {@link #canManageVideoChats} instance as boolean
     */
    public boolean canManageVideoChats() {
        return canManageVideoChats;
    }

    /**
     * Method to get {@link #canRestrictMembers} instance <br>
     * No-any params required
     *
     * @return {@link #canRestrictMembers} instance as boolean
     */
    public boolean canRestrictMembers() {
        return canRestrictMembers;
    }

    /**
     * Method to get {@link #canPromoteMembers} instance <br>
     * No-any params required
     *
     * @return {@link #canPromoteMembers} instance as boolean
     */
    public boolean canPromoteMembers() {
        return canPromoteMembers;
    }

    /**
     * Method to get {@link #canChangeInfo} instance <br>
     * No-any params required
     *
     * @return {@link #canChangeInfo} instance as boolean
     */
    public boolean canChangeInfo() {
        return canChangeInfo;
    }

    /**
     * Method to get {@link #canInviteUsers} instance <br>
     * No-any params required
     *
     * @return {@link #canInviteUsers} instance as boolean
     */
    public boolean canInviteUsers() {
        return canInviteUsers;
    }

    /**
     * Method to get {@link #canPostMessages} instance <br>
     * No-any params required
     *
     * @return {@link #canPostMessages} instance as boolean
     */
    public boolean canPostMessages() {
        return canPostMessages;
    }

    /**
     * Method to get {@link #canEditMessages} instance <br>
     * No-any params required
     *
     * @return {@link #canEditMessages} instance as boolean
     */
    public boolean canEditMessages() {
        return canEditMessages;
    }

    /**
     * Method to get {@link #canPinMessages} instance <br>
     * No-any params required
     *
     * @return {@link #canPinMessages} instance as boolean
     */
    public boolean canPinMessages() {
        return canPinMessages;
    }

    /**
     * Method to get {@link #canManageTopics} instance <br>
     * No-any params required
     *
     * @return {@link #canManageTopics} instance as boolean
     */
    public boolean canManageTopics() {
        return canManageTopics;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatMemberAdministrator}
     */
    public static ChatMemberAdministrator getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatMemberAdministrator(jItem);
    }

}
