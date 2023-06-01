package com.tecknobit.telegrammanager.botapi.records.basetypes.chat;

import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import com.tecknobit.telegrammanager.botapi.records.basetypes.parents.ProfileStructure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code Chat} class is useful to format a {@code Telegram}'s chat
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chat">Chat</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ProfileStructure
 */
public class Chat extends ProfileStructure {

    /**
     * {@code ChatType} list of available chat types
     */
    public enum ChatType {

        /**
         * {@code tPrivate} chat type
         */
        tPrivate("private"),

        /**
         * {@code group} chat type
         */
        group("group"),

        /**
         * {@code supergroup} chat type
         */
        supergroup("supergroup"),

        /**
         * {@code channel} chat type
         */
        channel("channel");

        /**
         * {@code type} of the chat
         */
        private final String type;

        /**
         * Constructor to init a {@link ChatType} object
         *
         * @param type: type of the chat
         */
        ChatType(String type) {
            this.type = type;
        }

        /**
         * Method to get an instance of this enum
         *
         * @param type: type to fetch
         * @return instance as {@link ChatType}
         */
        public static ChatType getInstance(String type) {
            try {
                return ChatType.valueOf(type);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        /**
         * Method to get {@link #type} instance <br>
         * No-any params required
         *
         * @return {@link #type} instance as {@link String}
         */
        public String getType() {
            return type;
        }

    }

    /**
     * {@code ChatActionValue} list of available chat actions
     */
    public enum ChatActionValue {

        /**
         * {@code typing} chat action
         */
        typing,

        /**
         * {@code upload_photo} chat action
         */
        upload_photo,

        /**
         * {@code record_video} chat action
         */
        record_video,

        /**
         * {@code upload_video} chat action
         */
        upload_video,

        /**
         * {@code record_voice} chat action
         */
        record_voice,

        /**
         * {@code upload_voice} chat action
         */
        upload_voice,

        /**
         * {@code upload_document} chat action
         */
        upload_document,

        /**
         * {@code choose_sticker} chat action
         */
        choose_sticker,

        /**
         * {@code find_location} chat action
         */
        find_location,

        /**
         * {@code record_video_note} chat action
         */
        record_video_note,

        /**
         * {@code upload_video_note} chat action
         */
        upload_video_note

    }

    /**
     * {@code type} of the chat
     */
    private final ChatType type;

    /**
     * {@code title} supergroups, channels and group chats
     */
    private final String title;

    /**
     * {@code isForum} if the supergroup chat is a forum (has topics enabled)
     */
    private final boolean isForum;

    /**
     * {@code photo} chat photo
     */
    private final ChatPhoto photo;

    /**
     * {@code activeUsernames} if non-empty, the list of all active chat usernames; for private chats,
     * supergroups and channels
     */
    private final ArrayList<String> activeUsernames;

    /**
     * {@code emojiStatusCustomEmojiId} custom emoji identifier of emoji status of the other party in a private chat
     */
    private final String emojiStatusCustomEmojiId;

    /**
     * {@code bio} of the other party in a private chat
     */
    private final String bio;

    /**
     * {@code hasPrivateForwards} if privacy settings of the other party in the private chat allows to use
     * {@code "tg://user?id=<user_id>"} links only in chats with the user
     */
    private final boolean hasPrivateForwards;

    /**
     * {@code hasRestrictedVoiceAndVideoMessages} if the privacy settings of the other party restrict sending voice and
     * video note messages in the private chat
     */
    private final boolean hasRestrictedVoiceAndVideoMessages;

    /**
     * {@code joinToSendMessages} if users need to join the supergroup before they can send messages
     */
    private final boolean joinToSendMessages;

    /**
     * {@code joinByRequest} if all users directly joining the supergroup need to be approved by supergroup administrators
     */
    private final boolean joinByRequest;

    /**
     * {@code inviteLink} primary invite link, for groups, supergroups and channel chats
     */
    private final String inviteLink;

    /**
     * {@code pinnedMessage} the most recent pinned message (by sending date)
     */
    private final Message pinnedMessage;

    /**
     * {@code permissions} default chat member permissions, for groups and supergroups
     */
    private final ChatPermissions permissions;

    /**
     * {@code slowModeDelay} for supergroups, the minimum allowed delay between consecutive messages sent by each
     * unprivileged user; in seconds
     */
    private final long slowModeDelay;

    /**
     * {@code messageAutoDeleteTime} the time after which all messages sent to the chat will be automatically deleted;
     * in seconds
     */
    private final long messageAutoDeleteTime;

    /**
     * {@code hasAggressiveAntiSpamEnabled} if aggressive anti-spam checks are enabled in the supergroup. The field is
     * only available to chat administrators
     */
    private final boolean hasAggressiveAntiSpamEnabled;

    /**
     * {@code hasHiddenMembers} if non-administrators can only get the list of bots and administrators in the chat
     */
    private final boolean hasHiddenMembers;

    /**
     * {@code hasProtectedContent} if messages from the chat can't be forwarded to other chats
     */
    private final boolean hasProtectedContent;

    /**
     * {@code stickerSetName} for supergroups, name of group sticker set
     */
    private final String stickerSetName;

    /**
     * {@code canSetStickerSet} if the bot can change the group sticker set
     */
    private final boolean canSetStickerSet;

    /**
     * {@code linkedChatId} unique identifier for the linked chat
     */
    private final long linkedChatId;

    /**
     * {@code location} for supergroups, the location to which the supergroup is connected
     */
    private final ChatLocation location;

    /**
     * Constructor to init a {@link Chat} object
     *
     * @param id:                                 unique identifier for this chat
     * @param firstName:                          first name of the other party in a private chat
     * @param lastName:                           last name of the other party in a private chat
     * @param username:                           username, for private chats, supergroups and channels if available
     * @param type:                               type of chat
     * @param title:                              title, for supergroups, channels and group chats
     * @param isForum:                            if the supergroup chat is a forum (has topics enabled)
     * @param photo:                              chat photo
     * @param activeUsernames:                    if non-empty, the list of all active chat usernames; for private chats, supergroups and
     *                                            channels
     * @param emojiStatusCustomEmojiId:           custom emoji identifier of emoji status of the other party in a private chat
     * @param bio:                                bio of the other party in a private chat
     * @param hasPrivateForwards:                 if privacy settings of the other party in the private chat allows to use
     *                                            {@code "tg://user?id=<user_id>"} links only in chats with the user
     * @param hasRestrictedVoiceAndVideoMessages: if the privacy settings of the other party restrict sending voice and
     *                                            video note messages in the private chat
     * @param joinToSendMessages:                 if users need to join the supergroup before they can send messages
     * @param joinByRequest:                      if all users directly joining the supergroup need to be approved by supergroup administrators
     * @param description:                        description, for groups, supergroups and channel chats
     * @param inviteLink:                         primary invite link, for groups, supergroups and channel chats
     * @param pinnedMessage:                      the most recent pinned message (by sending date)
     * @param permissions:                        default chat member permissions, for groups and supergroups
     * @param slowModeDelay:                      for supergroups, the minimum allowed delay between consecutive messages sent by each
     *                                            unprivileged user; in seconds
     * @param messageAutoDeleteTime:              the time after which all messages sent to the chat will be automatically deleted;
     *                                            in seconds
     * @param hasAggressiveAntiSpamEnabled:       if aggressive anti-spam checks are enabled in the supergroup. The field
     *                                            is only available to chat administrators
     * @param hasHiddenMembers:                   if non-administrators can only get the list of bots and administrators in the chat
     * @param hasProtectedContent:                if messages from the chat can't be forwarded to other chats
     * @param stickerSetName:                     for supergroups, name of group sticker set
     * @param canSetStickerSet:                   if the bot can change the group sticker set
     * @param linkedChatId:                       unique identifier for the linked chat
     * @param location:                           for supergroups, the location to which the supergroup is connected
     */
    public Chat(long id, String firstName, String lastName, String username, ChatType type, String title, boolean isForum,
                ChatPhoto photo, ArrayList<String> activeUsernames, String emojiStatusCustomEmojiId, String bio,
                boolean hasPrivateForwards, boolean hasRestrictedVoiceAndVideoMessages, boolean joinToSendMessages,
                boolean joinByRequest, String description, String inviteLink, Message pinnedMessage,
                ChatPermissions permissions, long slowModeDelay, long messageAutoDeleteTime,
                boolean hasAggressiveAntiSpamEnabled, boolean hasHiddenMembers, boolean hasProtectedContent,
                String stickerSetName, boolean canSetStickerSet, long linkedChatId, ChatLocation location) {
        super(id, firstName, lastName, username);
        this.type = type;
        this.title = title;
        this.isForum = isForum;
        this.photo = photo;
        this.activeUsernames = activeUsernames;
        this.emojiStatusCustomEmojiId = emojiStatusCustomEmojiId;
        this.bio = bio;
        this.hasPrivateForwards = hasPrivateForwards;
        this.hasRestrictedVoiceAndVideoMessages = hasRestrictedVoiceAndVideoMessages;
        this.joinToSendMessages = joinToSendMessages;
        this.joinByRequest = joinByRequest;
        this.inviteLink = inviteLink;
        this.pinnedMessage = pinnedMessage;
        this.permissions = permissions;
        this.slowModeDelay = slowModeDelay;
        this.messageAutoDeleteTime = messageAutoDeleteTime;
        this.hasAggressiveAntiSpamEnabled = hasAggressiveAntiSpamEnabled;
        this.hasHiddenMembers = hasHiddenMembers;
        this.hasProtectedContent = hasProtectedContent;
        this.stickerSetName = stickerSetName;
        this.canSetStickerSet = canSetStickerSet;
        this.linkedChatId = linkedChatId;
        this.location = location;
    }

    /**
     * Constructor to init a {@link Chat} object
     *
     * @param jChat: chat details as {@link JSONObject}
     */
    public Chat(JSONObject jChat) {
        super(jChat);
        type = ChatType.valueOf(hTelegram.getString("type"));
        title = hTelegram.getString("title");
        isForum = hTelegram.getBoolean("is_forum");
        photo = ChatPhoto.getInstance(hTelegram.getJSONObject("photo"));
        activeUsernames = fetchStringsList(hTelegram.getJSONArray("active_usernames"));
        emojiStatusCustomEmojiId = hTelegram.getString("emoji_status_custom_emoji_id");
        bio = hTelegram.getString("bio");
        hasPrivateForwards = hTelegram.getBoolean("has_private_forwards");
        hasRestrictedVoiceAndVideoMessages = hTelegram.getBoolean("has_restricted_voice_and_video_messages");
        joinToSendMessages = hTelegram.getBoolean("join_to_send_messages");
        joinByRequest = hTelegram.getBoolean("join_by_request");
        inviteLink = hTelegram.getString("invite_link");
        pinnedMessage = Message.getInstance(hTelegram.getJSONObject("pinned_message"));
        permissions = ChatPermissions.getInstance(hTelegram.getJSONObject("permissions"));
        slowModeDelay = hTelegram.getLong("slow_mode_delay", -1);
        messageAutoDeleteTime = hTelegram.getLong("message_auto_delete_time", -1);
        hasAggressiveAntiSpamEnabled = hTelegram.getBoolean("has_aggressive_anti_spam_enabled");
        hasHiddenMembers = hTelegram.getBoolean("has_hidden_members");
        hasProtectedContent = hTelegram.getBoolean("has_protected_content");
        stickerSetName = hTelegram.getString("sticker_set_name");
        canSetStickerSet = hTelegram.getBoolean("can_set_sticker_set");
        linkedChatId = hTelegram.getLong("linked_chat_id", -1);
        location = ChatLocation.getInstance(hTelegram.getJSONObject("location"));
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link ChatType}
     */
    public ChatType getType() {
        return type;
    }

    /**
     * Method to get {@link #title} instance <br>
     * No-any params required
     *
     * @return {@link #title} instance as {@link String}
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to get {@link #isForum} instance <br>
     * No-any params required
     *
     * @return {@link #isForum} instance as boolean
     */
    public boolean isForum() {
        return isForum;
    }

    /**
     * Method to get {@link #photo} instance <br>
     * No-any params required
     *
     * @return {@link #photo} instance as {@link ChatPhoto}
     */
    public ChatPhoto getPhoto() {
        return photo;
    }

    /**
     * Method to get {@link #activeUsernames} instance <br>
     * No-any params required
     *
     * @return {@link #activeUsernames} instance as {@link ArrayList} of {@link String}
     */
    public ArrayList<String> getActiveUsernames() {
        return activeUsernames;
    }

    /**
     * Method to get {@link #emojiStatusCustomEmojiId} instance <br>
     * No-any params required
     *
     * @return {@link #emojiStatusCustomEmojiId} instance as {@link String}
     */
    public String getEmojiStatusCustomEmojiId() {
        return emojiStatusCustomEmojiId;
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
     * Method to get {@link #hasPrivateForwards} instance <br>
     * No-any params required
     *
     * @return {@link #hasPrivateForwards} instance as boolean
     */
    public boolean isHasPrivateForwards() {
        return hasPrivateForwards;
    }

    /**
     * Method to get {@link #hasRestrictedVoiceAndVideoMessages} instance <br>
     * No-any params required
     *
     * @return {@link #hasRestrictedVoiceAndVideoMessages} instance as boolean
     */
    public boolean isHasRestrictedVoiceAndVideoMessages() {
        return hasRestrictedVoiceAndVideoMessages;
    }

    /**
     * Method to get {@link #joinToSendMessages} instance <br>
     * No-any params required
     *
     * @return {@link #joinToSendMessages} instance as boolean
     */
    public boolean isJoinToSendMessages() {
        return joinToSendMessages;
    }

    /**
     * Method to get {@link #joinByRequest} instance <br>
     * No-any params required
     *
     * @return {@link #joinByRequest} instance as boolean
     */
    public boolean isJoinByRequest() {
        return joinByRequest;
    }

    /**
     * Method to get {@link #inviteLink} instance <br>
     * No-any params required
     *
     * @return {@link #inviteLink} instance as {@link String}
     */
    public String getInviteLink() {
        return inviteLink;
    }

    /**
     * Method to get {@link #pinnedMessage} instance <br>
     * No-any params required
     *
     * @return {@link #pinnedMessage} instance as {@link Message}
     */
    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    /**
     * Method to get {@link #permissions} instance <br>
     * No-any params required
     *
     * @return {@link #permissions} instance as {@link ChatPermissions}
     */
    public ChatPermissions getPermissions() {
        return permissions;
    }

    /**
     * Method to get {@link #slowModeDelay} instance <br>
     * No-any params required
     *
     * @return {@link #slowModeDelay} instance as long
     */
    public long getSlowModeDelay() {
        return slowModeDelay;
    }

    /**
     * Method to get {@link #messageAutoDeleteTime} instance <br>
     * No-any params required
     *
     * @return {@link #messageAutoDeleteTime} instance as long
     */
    public long getMessageAutoDeleteTime() {
        return messageAutoDeleteTime;
    }

    /**
     * Method to get {@link #hasAggressiveAntiSpamEnabled} instance <br>
     * No-any params required
     *
     * @return {@link #hasAggressiveAntiSpamEnabled} instance as boolean
     */
    public boolean hasAggressiveAntiSpamEnabled() {
        return hasAggressiveAntiSpamEnabled;
    }

    /**
     * Method to get {@link #hasHiddenMembers} instance <br>
     * No-any params required
     *
     * @return {@link #hasHiddenMembers} instance as boolean
     */
    public boolean hasHiddenMembers() {
        return hasHiddenMembers;
    }

    /**
     * Method to get {@link #hasProtectedContent} instance <br>
     * No-any params required
     *
     * @return {@link #hasProtectedContent} instance as boolean
     */
    public boolean hasProtectedContent() {
        return hasProtectedContent;
    }

    /**
     * Method to get {@link #stickerSetName} instance <br>
     * No-any params required
     *
     * @return {@link #stickerSetName} instance as {@link String}
     */
    public String getStickerSetName() {
        return stickerSetName;
    }

    /**
     * Method to get {@link #canSetStickerSet} instance <br>
     * No-any params required
     *
     * @return {@link #canSetStickerSet} instance as boolean
     */
    public boolean canSetStickerSet() {
        return canSetStickerSet;
    }

    /**
     * Method to get {@link #linkedChatId} instance <br>
     * No-any params required
     *
     * @return {@link #linkedChatId} instance as long
     */
    public long getLinkedChatId() {
        return linkedChatId;
    }

    /**
     * Method to get {@link #location} instance <br>
     * No-any params required
     *
     * @return {@link #location} instance as {@link ChatLocation}
     */
    public ChatLocation getLocation() {
        return location;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Chat}
     */
    public static Chat getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Chat(jItem);
    }

}
