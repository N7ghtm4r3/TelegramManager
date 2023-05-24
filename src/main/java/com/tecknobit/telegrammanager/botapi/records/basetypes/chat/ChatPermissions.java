package com.tecknobit.telegrammanager.botapi.records.basetypes.chat;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ChatPermissions} class is useful to format a {@code Telegram}'s chat permissions
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatpermissions">
 * ChatPermissions</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ChatPermissions extends TelegramType {

    /**
     * {@code canSendMessages} if the user is allowed to send text messages, contacts, invoices, locations and venues
     */
    private final boolean canSendMessages;

    /**
     * {@code canSendAudios} if the user is allowed to send audios
     */
    private final boolean canSendAudios;

    /**
     * {@code canSendDocuments} if the user is allowed to send documents
     */
    private final boolean canSendDocuments;

    /**
     * {@code canSendPhotos} if the user is allowed to send photos
     */
    private final boolean canSendPhotos;

    /**
     * {@code canSendVideos} if the user is allowed to send videos
     */
    private final boolean canSendVideos;

    /**
     * {@code canSendVideoNotes} if the user is allowed to send video notes
     */
    private final boolean canSendVideoNotes;

    /**
     * {@code canSendVoiceNotes} if the user is allowed to send voice notes
     */
    private final boolean canSendVoiceNotes;

    /**
     * {@code canSendPolls} if the user is allowed to send polls
     */
    private final boolean canSendPolls;

    /**
     * {@code canSendOtherMessages} if the user is allowed to send animations, games, stickers and use inline bots
     */
    private final boolean canSendOtherMessages;

    /**
     * {@code canAddWebpagePreviews} if the user is allowed to add web page previews to their messages
     */
    private final boolean canAddWebpagePreviews;

    /**
     * {@code canChangeInfo} if the user is allowed to change the chat title, photo and other settings. Ignored in public
     * supergroups
     */
    private final boolean canChangeInfo;

    /**
     * {@code canInviteUsers} if the user is allowed to invite new users to the chat
     */
    private final boolean canInviteUsers;

    /**
     * {@code canPinMessages} if the user is allowed to pin messages. Ignored in public supergroups
     */
    private final boolean canPinMessages;

    /**
     * {@code canManageTopics} if the user is allowed to create forum topics. If omitted defaults to the value of
     * {@link #canPinMessages}
     */
    private final boolean canManageTopics;

    /**
     * Constructor to init a {@link ChatPermissions} object
     *
     * @param canSendMessages:       if the user is allowed to send text messages, contacts, invoices, locations and venues
     * @param canSendAudios:         if the user is allowed to send audios
     * @param canSendDocuments:      if the user is allowed to send documents
     * @param canSendPhotos:         if the user is allowed to send photos
     * @param canSendVideos:         if the user is allowed to send videos
     * @param canSendVideoNotes:     if the user is allowed to send video notes
     * @param canSendVoiceNotes:     if the user is allowed to send voice notes
     * @param canSendPolls:          if the user is allowed to send polls
     * @param canSendOtherMessages:  if the user is allowed to send animations, games, stickers and use inline bots
     * @param canAddWebpagePreviews: if the user is allowed to add web page previews to their messages
     * @param canChangeInfo:         if the user is allowed to change the chat title, photo and other settings. Ignored in public
     *                               supergroups
     * @param canInviteUsers:        if the user is allowed to invite new users to the chat
     * @param canPinMessages:        if the user is allowed to pin messages. Ignored in public supergroups
     * @param canManageTopics:       if the user is allowed to create forum topics. If omitted defaults to the value of
     *                               {@link #canPinMessages}
     */
    public ChatPermissions(boolean canSendMessages, boolean canSendAudios, boolean canSendDocuments, boolean canSendPhotos,
                           boolean canSendVideos, boolean canSendVideoNotes, boolean canSendVoiceNotes, boolean canSendPolls,
                           boolean canSendOtherMessages, boolean canAddWebpagePreviews, boolean canChangeInfo,
                           boolean canInviteUsers, boolean canPinMessages, boolean canManageTopics) {
        super(null);
        this.canSendMessages = canSendMessages;
        this.canSendAudios = canSendAudios;
        this.canSendDocuments = canSendDocuments;
        this.canSendPhotos = canSendPhotos;
        this.canSendVideos = canSendVideos;
        this.canSendVideoNotes = canSendVideoNotes;
        this.canSendVoiceNotes = canSendVoiceNotes;
        this.canSendPolls = canSendPolls;
        this.canSendOtherMessages = canSendOtherMessages;
        this.canAddWebpagePreviews = canAddWebpagePreviews;
        this.canChangeInfo = canChangeInfo;
        this.canInviteUsers = canInviteUsers;
        this.canPinMessages = canPinMessages;
        this.canManageTopics = canManageTopics;
    }

    /**
     * Constructor to init a {@link ChatPermissions} object
     *
     * @param jChatPermissions: chat permissions details as {@link JSONObject}
     */
    public ChatPermissions(JSONObject jChatPermissions) {
        super(jChatPermissions);
        canSendMessages = hTelegram.getBoolean("can_send_messages");
        canSendAudios = hTelegram.getBoolean("can_send_audios");
        canSendDocuments = hTelegram.getBoolean("can_send_documents");
        canSendPhotos = hTelegram.getBoolean("can_send_photos");
        canSendVideos = hTelegram.getBoolean("can_send_videos");
        canSendVideoNotes = hTelegram.getBoolean("can_send_video_notes");
        canSendVoiceNotes = hTelegram.getBoolean("can_send_voice_notes");
        canSendPolls = hTelegram.getBoolean("can_send_polls");
        canSendOtherMessages = hTelegram.getBoolean("can_send_other_messages");
        canAddWebpagePreviews = hTelegram.getBoolean("can_add_web_page_previews");
        canChangeInfo = hTelegram.getBoolean("can_change_info");
        canInviteUsers = hTelegram.getBoolean("can_invite_users");
        canPinMessages = hTelegram.getBoolean("can_pin_messages");
        canManageTopics = hTelegram.getBoolean("can_manage_topics");
    }

    /**
     * Method to get {@link #canSendMessages} instance <br>
     * No-any params required
     *
     * @return {@link #canSendMessages} instance as boolean
     */
    public boolean canSendMessages() {
        return canSendMessages;
    }

    /**
     * Method to get {@link #canSendAudios} instance <br>
     * No-any params required
     *
     * @return {@link #canSendAudios} instance as boolean
     */
    public boolean canSendAudios() {
        return canSendAudios;
    }

    /**
     * Method to get {@link #canSendDocuments} instance <br>
     * No-any params required
     *
     * @return {@link #canSendDocuments} instance as boolean
     */
    public boolean canSendDocuments() {
        return canSendDocuments;
    }

    /**
     * Method to get {@link #canSendPhotos} instance <br>
     * No-any params required
     *
     * @return {@link #canSendPhotos} instance as boolean
     */
    public boolean canSendPhotos() {
        return canSendPhotos;
    }

    /**
     * Method to get {@link #canSendVideos} instance <br>
     * No-any params required
     *
     * @return {@link #canSendVideos} instance as boolean
     */
    public boolean canSendVideos() {
        return canSendVideos;
    }

    /**
     * Method to get {@link #canSendVideoNotes} instance <br>
     * No-any params required
     *
     * @return {@link #canSendVideoNotes} instance as boolean
     */
    public boolean canSendVideoNotes() {
        return canSendVideoNotes;
    }

    /**
     * Method to get {@link #canSendVoiceNotes} instance <br>
     * No-any params required
     *
     * @return {@link #canSendVoiceNotes} instance as boolean
     */
    public boolean canSendVoiceNotes() {
        return canSendVoiceNotes;
    }

    /**
     * Method to get {@link #canSendPolls} instance <br>
     * No-any params required
     *
     * @return {@link #canSendPolls} instance as boolean
     */
    public boolean canSendPolls() {
        return canSendPolls;
    }

    /**
     * Method to get {@link #canSendOtherMessages} instance <br>
     * No-any params required
     *
     * @return {@link #canSendOtherMessages} instance as boolean
     */
    public boolean canSendOtherMessages() {
        return canSendOtherMessages;
    }

    /**
     * Method to get {@link #canAddWebpagePreviews} instance <br>
     * No-any params required
     *
     * @return {@link #canAddWebpagePreviews} instance as boolean
     */
    public boolean canAddWebpagePreviews() {
        return canAddWebpagePreviews;
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
     * @return instance as {@link ChatPermissions}
     */
    public static ChatPermissions getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatPermissions(jItem);
    }

}
