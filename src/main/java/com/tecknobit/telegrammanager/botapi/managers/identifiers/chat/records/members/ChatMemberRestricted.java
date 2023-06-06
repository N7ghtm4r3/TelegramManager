package com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.members;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.Date;

import static com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.members.ChatMember.ChatMemberStatus.restricted;

/**
 * The {@code ChatMemberRestricted} class is useful to format a {@code Telegram}'s chat member restricted
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatmemberrestricted">
 * ChatMemberRestricted</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ChatMember
 */
public class ChatMemberRestricted extends ChatMember {

    /**
     * {@code isMember} if the user is a member of the chat at the moment of the request
     */
    private final boolean isMember;

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
     * {@code canAddWebPagePreviews} if the user is allowed to add web page previews to their messages
     */
    private final boolean canAddWebPagePreviews;

    /**
     * {@code canChangeInfo} if the user is allowed to change the chat title, photo and other settings
     */
    private final boolean canChangeInfo;

    /**
     * {@code canInviteUsers} if the user is allowed to invite new users to the chat
     */
    private final boolean canInviteUsers;

    /**
     * {@code canPinMessages} if the user is allowed to pin messages
     */
    private final boolean canPinMessages;

    /**
     * {@code canManageTopics} if the user is allowed to create forum topics
     */
    private final boolean canManageTopics;

    /**
     * {@code untilDate} date when restrictions will be lifted for this user; unix time. If 0, then the user is restricted forever
     */
    private final long untilDate;

    /**
     * Constructor to init a {@link ChatMemberRestricted} object
     *
     * @param user:                  information about the user
     * @param canSendMessages:       if the user is allowed to send text messages, contacts, invoices, locations and venues
     * @param canSendAudios:         if the user is allowed to send audios
     * @param canSendDocuments:      if the user is allowed to send documents
     * @param canSendPhotos:         if the user is allowed to send photos
     * @param canSendVideos:         if the user is allowed to send videos
     * @param canSendVideoNotes:     if the user is allowed to send video notes
     * @param canSendVoiceNotes:     if the user is allowed to send voice notes
     * @param canSendPolls:          if the user is allowed to send polls
     * @param canSendOtherMessages:  if the user is allowed to send animations, games, stickers and use inline bots
     * @param canAddWebPagePreviews: if the user is allowed to add web page previews to their messages
     * @param canChangeInfo:         if the user is allowed to change the chat title, photo and other settings
     * @param canInviteUsers:        if the user is allowed to invite new users to the chat
     * @param canPinMessages:        if the user is allowed to pin messages
     * @param canManageTopics:       if the user is allowed to create forum topics
     * @param untilDate:             date when restrictions will be lifted for this user; unix time. If 0, then the user is restricted forever
     */
    public ChatMemberRestricted(User user, boolean isMember, boolean canSendMessages, boolean canSendAudios,
                                boolean canSendDocuments, boolean canSendPhotos, boolean canSendVideos,
                                boolean canSendVideoNotes, boolean canSendVoiceNotes, boolean canSendPolls,
                                boolean canSendOtherMessages, boolean canAddWebPagePreviews, boolean canChangeInfo,
                                boolean canInviteUsers, boolean canPinMessages, boolean canManageTopics, long untilDate) {
        super(restricted, user);
        this.isMember = isMember;
        this.canSendMessages = canSendMessages;
        this.canSendAudios = canSendAudios;
        this.canSendDocuments = canSendDocuments;
        this.canSendPhotos = canSendPhotos;
        this.canSendVideos = canSendVideos;
        this.canSendVideoNotes = canSendVideoNotes;
        this.canSendVoiceNotes = canSendVoiceNotes;
        this.canSendPolls = canSendPolls;
        this.canSendOtherMessages = canSendOtherMessages;
        this.canAddWebPagePreviews = canAddWebPagePreviews;
        this.canChangeInfo = canChangeInfo;
        this.canInviteUsers = canInviteUsers;
        this.canPinMessages = canPinMessages;
        this.canManageTopics = canManageTopics;
        this.untilDate = untilDate;
    }

    /**
     * Constructor to init a {@link ChatMemberRestricted} object
     *
     * @param jChatMemberRestricted: chat member restricted details as {@link JSONObject}
     */
    public ChatMemberRestricted(JSONObject jChatMemberRestricted) {
        super(jChatMemberRestricted);
        isMember = hTelegram.getBoolean("is_member");
        canSendMessages = hTelegram.getBoolean("can_send_messages");
        canSendAudios = hTelegram.getBoolean("can_send_audios");
        canSendDocuments = hTelegram.getBoolean("can_send_documents");
        canSendPhotos = hTelegram.getBoolean("can_send_photos");
        canSendVideos = hTelegram.getBoolean("can_send_videos");
        canSendVideoNotes = hTelegram.getBoolean("can_send_video_notes");
        canSendVoiceNotes = hTelegram.getBoolean("can_send_voice_notes");
        canSendPolls = hTelegram.getBoolean("can_send_polls");
        canSendOtherMessages = hTelegram.getBoolean("can_send_other_messages");
        canAddWebPagePreviews = hTelegram.getBoolean("can_add_web_page_previews");
        canChangeInfo = hTelegram.getBoolean("can_change_info");
        canInviteUsers = hTelegram.getBoolean("can_invite_users");
        canPinMessages = hTelegram.getBoolean("can_pin_messages");
        canManageTopics = hTelegram.getBoolean("can_manage_topics");
        untilDate = hTelegram.getLong("until_date");
    }

    /**
     * Method to get {@link #isMember} instance <br>
     * No-any params required
     *
     * @return {@link #isMember} instance as boolean
     */
    public boolean isMember() {
        return isMember;
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
     * Method to get {@link #canAddWebPagePreviews} instance <br>
     * No-any params required
     *
     * @return {@link #canAddWebPagePreviews} instance as boolean
     */
    public boolean canAddWebPagePreviews() {
        return canAddWebPagePreviews;
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
     * Method to get {@link #untilDate} instance <br>
     * No-any params required
     *
     * @return {@link #untilDate} instance as long
     */
    public long getUntilDateTimestamp() {
        return untilDate;
    }

    /**
     * Method to get {@link #untilDate} instance <br>
     * No-any params required
     *
     * @return {@link #untilDate} instance as {@link Date}
     */
    public Date getUntilDate() {
        return getDateValue(untilDate);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatMemberRestricted}
     */
    public static ChatMemberRestricted getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatMemberRestricted(jItem);
    }

}
