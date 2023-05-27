package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class ChatAdministratorRights extends TelegramType {

    private final boolean isAnonymous;

    private final boolean canManageChat;

    private final boolean canDeleteMessages;

    private final boolean canManageVideoChats;

    private final boolean canRestrictMembers;

    private final boolean canPromoteMembers;

    private final boolean canChangeInfo;

    private final boolean canInviteUsers;

    private final boolean canPostMessages;

    private final boolean canEditMessages;

    private final boolean canPinMessages;

    private final boolean canManageTopics;

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

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public boolean canManageChat() {
        return canManageChat;
    }

    public boolean canDeleteMessages() {
        return canDeleteMessages;
    }

    public boolean canManageVideoChats() {
        return canManageVideoChats;
    }

    public boolean canRestrictMembers() {
        return canRestrictMembers;
    }

    public boolean canPromoteMembers() {
        return canPromoteMembers;
    }

    public boolean canChangeInfo() {
        return canChangeInfo;
    }

    public boolean canInviteUsers() {
        return canInviteUsers;
    }

    public boolean canPostMessages() {
        return canPostMessages;
    }

    public boolean canEditMessages() {
        return canEditMessages;
    }

    public boolean canPinMessages() {
        return canPinMessages;
    }

    public boolean canManageTopics() {
        return canManageTopics;
    }

    public static ChatAdministratorRights getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatAdministratorRights(jItem);
    }

}
