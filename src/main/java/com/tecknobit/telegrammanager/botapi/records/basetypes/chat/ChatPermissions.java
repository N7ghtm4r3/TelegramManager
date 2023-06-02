package com.tecknobit.telegrammanager.botapi.records.basetypes.chat;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
    private boolean canSendMessages;

    /**
     * {@code canSendAudios} if the user is allowed to send audios
     */
    private boolean canSendAudios;

    /**
     * {@code canSendDocuments} if the user is allowed to send documents
     */
    private boolean canSendDocuments;

    /**
     * {@code canSendPhotos} if the user is allowed to send photos
     */
    private boolean canSendPhotos;

    /**
     * {@code canSendVideos} if the user is allowed to send videos
     */
    private boolean canSendVideos;

    /**
     * {@code canSendVideoNotes} if the user is allowed to send video notes
     */
    private boolean canSendVideoNotes;

    /**
     * {@code canSendVoiceNotes} if the user is allowed to send voice notes
     */
    private boolean canSendVoiceNotes;

    /**
     * {@code canSendPolls} if the user is allowed to send polls
     */
    private boolean canSendPolls;

    /**
     * {@code canSendOtherMessages} if the user is allowed to send animations, games, stickers and use inline bots
     */
    private boolean canSendOtherMessages;

    /**
     * {@code canAddWebpagePreviews} if the user is allowed to add web page previews to their messages
     */
    private boolean canAddWebpagePreviews;

    /**
     * {@code canChangeInfo} if the user is allowed to change the chat title, photo and other settings. Ignored in public
     * supergroups
     */
    private boolean canChangeInfo;

    /**
     * {@code canInviteUsers} if the user is allowed to invite new users to the chat
     */
    private boolean canInviteUsers;

    /**
     * {@code canPinMessages} if the user is allowed to pin messages. Ignored in public supergroups
     */
    private boolean canPinMessages;

    /**
     * {@code canManageTopics} if the user is allowed to create forum topics. If omitted defaults to the value of
     * {@link #canPinMessages}
     */
    private boolean canManageTopics;

    /**
     * Constructor to init a {@link ChatPermissions} object <br>
     * No-any params required
     *
     * @apiNote this constructor is useful when you need to pass this class as parameter for the requests, all the flags
     * as default are set to {@code "false"}, to enable them you need to call the specific setter methods
     */
    public ChatPermissions() {
        super(null);
    }

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
     * Method to set {@link #canSendMessages} instance <br>
     *
     * @param canSendMessages: if the user is allowed to send text messages, contacts, invoices, locations and venues
     */
    public void setCanSendMessages(boolean canSendMessages) {
        this.canSendMessages = canSendMessages;
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
     * Method to set {@link #canSendAudios} instance <br>
     *
     * @param canSendAudios: if the user is allowed to send audios
     */
    public void setCanSendAudios(boolean canSendAudios) {
        this.canSendAudios = canSendAudios;
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
     * Method to set {@link #canSendDocuments} instance <br>
     *
     * @param canSendDocuments: if the user is allowed to send documents
     */
    public void setCanSendDocuments(boolean canSendDocuments) {
        this.canSendDocuments = canSendDocuments;
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
     * Method to set {@link #canSendPhotos} instance <br>
     *
     * @param canSendPhotos: if the user is allowed to send photos
     */
    public void setCanSendPhotos(boolean canSendPhotos) {
        this.canSendPhotos = canSendPhotos;
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
     * Method to set {@link #canSendVideos} instance <br>
     *
     * @param canSendVideos: if the user is allowed to send videos
     */
    public void setCanSendVideos(boolean canSendVideos) {
        this.canSendVideos = canSendVideos;
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
     * Method to set {@link #canSendVideoNotes} instance <br>
     *
     * @param canSendVideoNotes: if the user is allowed to send video notes
     */
    public void setCanSendVideoNotes(boolean canSendVideoNotes) {
        this.canSendVideoNotes = canSendVideoNotes;
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
     * Method to set {@link #canSendVoiceNotes} instance <br>
     *
     * @param canSendVoiceNotes: if the user is allowed to send voice notes
     */
    public void setCanSendVoiceNotes(boolean canSendVoiceNotes) {
        this.canSendVoiceNotes = canSendVoiceNotes;
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
     * Method to set {@link #canSendPolls} instance <br>
     *
     * @param canSendPolls: if the user is allowed to send polls
     */
    public void setCanSendPolls(boolean canSendPolls) {
        this.canSendPolls = canSendPolls;
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
     * Method to set {@link #canSendOtherMessages} instance <br>
     *
     * @param canSendOtherMessages: if the user is allowed to send animations, games, stickers and use inline bots
     */
    public void setCanSendOtherMessages(boolean canSendOtherMessages) {
        this.canSendOtherMessages = canSendOtherMessages;
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
     * Method to set {@link #canAddWebpagePreviews} instance <br>
     *
     * @param canAddWebpagePreviews: if the user is allowed to add web page previews to their messages
     */
    public void setCanAddWebpagePreviews(boolean canAddWebpagePreviews) {
        this.canAddWebpagePreviews = canAddWebpagePreviews;
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
     * @param canChangeInfo: if the user is allowed to change the chat title, photo and other settings. Ignored in public
     *                       supergroups
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
     * @param canPinMessages: if the user is allowed to pin messages. Ignored in public supergroups
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
     * @param canManageTopics: if the user is allowed to create forum topics. If omitted defaults to the value of
     *                         {@link #canPinMessages}
     */
    public void setCanManageTopics(boolean canManageTopics) {
        this.canManageTopics = canManageTopics;
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

    /**
     * Returns a string representation of the object <br>
     * No-any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        JSONObject permissions = new JSONObject(this);
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("can")) {
                try {
                    Field field = ChatPermissions.class.getDeclaredField(methodName);
                    field.setAccessible(true);
                    for (int j = 3; j < methodName.length(); j++) {
                        char letter = methodName.charAt(j);
                        if (letter >= 'A' && letter <= 'Z')
                            methodName = methodName.replaceFirst("" + letter, ("_" + letter).toLowerCase());
                    }
                    if (methodName.contains("webpage")) {
                        String[] names = methodName.split("web");
                        methodName = names[0] + "web_" + names[1];
                    }
                    permissions.put(methodName, field.get(this));
                } catch (Exception ignored) {
                }
            }
        }
        return permissions.toString();
    }

}
