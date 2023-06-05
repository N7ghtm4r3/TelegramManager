package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ChatAdministratorRights} class is useful to format a {@code Telegram}'s chat administrator rights
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatadministratorrights">
 * ChatAdministratorRights</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ChatAdministratorRights extends TelegramType {

    /**
     * {@code isAnonymous} if the user's presence in the chat is hidden
     */
    private boolean isAnonymous;

    /**
     * {@code canManageChat} if the administrator can access the chat event log, chat statistics, message statistics in
     * channels, see channel members, see anonymous administrators in supergroups and ignore slow mode.
     * Implied by any other administrator privilege
     */
    private boolean canManageChat;

    /**
     * {@code canDeleteMessages} if the administrator can delete messages of other users
     */
    private boolean canDeleteMessages;

    /**
     * {@code canManageVideoChats} if the administrator can manage video chats
     */
    private boolean canManageVideoChats;

    /**
     * {@code canRestrictMembers} if the administrator can restrict, ban or unban chat members
     */
    private boolean canRestrictMembers;

    /**
     * {@code canPromoteMembers} if the administrator can add new administrators with a subset of their own privileges
     * or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were
     * appointed by the user)
     */
    private boolean canPromoteMembers;

    /**
     * {@code canChangeInfo} if the user is allowed to change the chat title, photo and other settings
     */
    private boolean canChangeInfo;

    /**
     * {@code canInviteUsers} if the user is allowed to invite new users to the chat
     */
    private boolean canInviteUsers;

    /**
     * {@code canPostMessages} if the administrator can post in the channel; channels only
     */
    private boolean canPostMessages;

    /**
     * {@code canEditMessages} if the administrator can edit messages of other users and can pin messages; channels only
     */
    private boolean canEditMessages;

    /**
     * {@code canPinMessages} if the user is allowed to pin messages; groups and supergroups only
     */
    private boolean canPinMessages;

    /**
     * {@code canManageTopics} if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     */
    private boolean canManageTopics;

    /**
     * Constructor to init a {@link ChatAdministratorRights} object <br>
     * No-any params required
     *
     * @apiNote this constructor is useful when you need to pass this class as parameter for the requests, all the flags
     * as default are set to {@code "false"}, to enable them you need to call the specific setter methods
     */
    public ChatAdministratorRights() {
        super(null);
    }

    /**
     * Constructor to init a {@link ChatAdministratorRights} object
     *
     * @param isAnonymous:         if the user's presence in the chat is hidden
     * @param canManageChat:       if the administrator can access the chat event log, chat statistics, message statistics in
     *                             channels, see channel members, see anonymous administrators in supergroups and ignore slow mode.
     *                             Implied by any other administrator privilege
     * @param canDeleteMessages:   if the administrator can delete messages of other users
     * @param canManageVideoChats: if the administrator can manage video chats
     * @param canRestrictMembers:  if the administrator can restrict, ban or unban chat members
     * @param canPromoteMembers:   if the administrator can add new administrators with a subset of their own privileges
     *                             or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were
     *                             appointed by the user)
     * @param canChangeInfo:       if the user is allowed to change the chat title, photo and other settings
     * @param canInviteUsers:      if the user is allowed to invite new users to the chat
     * @param canPostMessages:     if the administrator can post in the channel; channels only
     * @param canEditMessages:     if the administrator can edit messages of other users and can pin messages; channels only
     * @param canPinMessages:      if the user is allowed to pin messages; groups and supergroups only
     * @param canManageTopics:     if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     */
    public ChatAdministratorRights(boolean isAnonymous, boolean canManageChat, boolean canDeleteMessages,
                                   boolean canManageVideoChats, boolean canRestrictMembers, boolean canPromoteMembers,
                                   boolean canChangeInfo, boolean canInviteUsers, boolean canPostMessages,
                                   boolean canEditMessages, boolean canPinMessages, boolean canManageTopics) {
        super(null);
        this.isAnonymous = isAnonymous;
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
     * Constructor to init a {@link ChatAdministratorRights} object
     *
     * @param jChatAdministratorRights: chat administrator rights details as {@link JSONObject}
     */
    public ChatAdministratorRights(JSONObject jChatAdministratorRights) {
        super(jChatAdministratorRights);
        isAnonymous = hTelegram.getBoolean("is_anonymous");
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
     * Method to get {@link #isAnonymous} instance <br>
     * No-any params required
     *
     * @return {@link #isAnonymous} instance as boolean
     */
    public boolean isAnonymous() {
        return isAnonymous;
    }

    /**
     * Method to set {@link #} instance <br>
     *
     * @param anonymous: if the user's presence in the chat is hidden
     */
    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
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
     * Method to set {@link #canManageChat} instance <br>
     *
     * @param canManageChat: if the administrator can access the chat event log, chat statistics, message statistics in
     *                       channels, see channel members, see anonymous administrators in supergroups and ignore slow mode.
     *                       Implied by any other administrator privilege
     */
    public void setCanManageChat(boolean canManageChat) {
        this.canManageChat = canManageChat;
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
     * Method to set {@link #canDeleteMessages} instance <br>
     *
     * @param canDeleteMessages: if the administrator can delete messages of other users
     */
    public void setCanDeleteMessages(boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
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
     * Method to set {@link #canManageVideoChats} instance <br>
     *
     * @param canManageVideoChats: if the administrator can manage video chats
     */
    public void setCanManageVideoChats(boolean canManageVideoChats) {
        this.canManageVideoChats = canManageVideoChats;
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
     * Method to set {@link #canRestrictMembers} instance <br>
     *
     * @param canRestrictMembers: if the administrator can restrict, ban or unban chat members
     */
    public void setCanRestrictMembers(boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
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
     * Method to set {@link #canPromoteMembers} instance <br>
     *
     * @param canPromoteMembers: if the administrator can add new administrators with a subset of their own privileges
     *                           or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were
     *                           appointed by the user)
     */
    public void setCanPromoteMembers(boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
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
     * Method to set {@link #canChangeInfo} instance <br>
     *
     * @param canChangeInfo: if the user is allowed to change the chat title, photo and other settings
     */
    public void setCanChangeInfo(boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
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
     * Method to set {@link #canInviteUsers} instance <br>
     *
     * @param canInviteUsers: if the user is allowed to invite new users to the chat
     */
    public void setCanInviteUsers(boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
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
     * Method to set {@link #canPostMessages} instance <br>
     *
     * @param canPostMessages: if the administrator can post in the channel; channels only
     */
    public void setCanPostMessages(boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
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
     * Method to set {@link #canEditMessages} instance <br>
     *
     * @param canEditMessages: if the administrator can edit messages of other users and can pin messages; channels only
     */
    public void setCanEditMessages(boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
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
     * Method to set {@link #canPinMessages} instance <br>
     *
     * @param canPinMessages: if the user is allowed to pin messages; groups and supergroups only
     */
    public void setCanPinMessages(boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
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
     * Method to set {@link #canManageTopics} instance <br>
     *
     * @param canManageTopics: if the user is allowed to create, rename, close, and reopen forum topics; supergroups only
     */
    public void setCanManageTopics(boolean canManageTopics) {
        this.canManageTopics = canManageTopics;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatAdministratorRights}
     */
    public static ChatAdministratorRights getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatAdministratorRights(jItem);
    }

}
