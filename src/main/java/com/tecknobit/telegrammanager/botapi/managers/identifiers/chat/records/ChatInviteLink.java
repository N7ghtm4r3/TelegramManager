package com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.Date;

/**
 * The {@code ChatInviteLink} class is useful to format a {@code Telegram}'s chat invite link
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatinvitelink">
 * ChatInviteLink</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ChatInviteLink extends TelegramType {

    /**
     * {@code inviteLink} the invite link. If the link was created by another chat administrator, then the second part of
     * the link will be replaced with "..."
     */
    private final String inviteLink;

    /**
     * {@code creator} of the link
     */
    private final User creator;

    /**
     * {@code createsJoinRequest} if users joining the chat via the link need to be approved by chat administrators
     */
    private final boolean createsJoinRequest;

    /**
     * {@code isPrimary} if the link is primary
     */
    private final boolean isPrimary;

    /**
     * {@code isRevoked} if the link is revoked
     */
    private final boolean isRevoked;

    /**
     * {@code name} invite link name
     */
    private final String name;

    /**
     * {@code expireDate} point in time (Unix timestamp) when the link will expire or has been expired
     */
    private final long expireDate;

    /**
     * {@code memberLimit} the maximum number of users that can be members of the chat simultaneously after joining
     * the chat via this invite link; 1-99999
     */
    private final int memberLimit;

    /**
     * {@code pendingJoinRequestCount} number of pending join requests created using this link
     */
    private final int pendingJoinRequestCount;

    /**
     * Constructor to init a {@link ChatInviteLink} object
     *
     * @param inviteLink:              the invite link. If the link was created by another chat administrator, then the second part of
     *                                 the link will be replaced with "..."
     * @param creator:                 of the link
     * @param createsJoinRequest:      if users joining the chat via the link need to be approved by chat administrators
     * @param isPrimary:               if the link is primary
     * @param isRevoked:               if the link is revoked
     * @param name:                    invite link name
     * @param expireDate:              point in time (Unix timestamp) when the link will expire or has been expired
     * @param memberLimit:             the maximum number of users that can be members of the chat simultaneously after joining
     *                                 the chat via this invite link; 1-99999
     * @param pendingJoinRequestCount: number of pending join requests created using this link
     */
    public ChatInviteLink(String inviteLink, User creator, boolean createsJoinRequest, boolean isPrimary, boolean isRevoked,
                          String name, long expireDate, int memberLimit, int pendingJoinRequestCount) {
        super(null);
        this.inviteLink = inviteLink;
        this.creator = creator;
        this.createsJoinRequest = createsJoinRequest;
        this.isPrimary = isPrimary;
        this.isRevoked = isRevoked;
        this.name = name;
        this.expireDate = expireDate;
        this.memberLimit = memberLimit;
        this.pendingJoinRequestCount = pendingJoinRequestCount;
    }

    /**
     * Constructor to init a {@link ChatInviteLink} object
     *
     * @param jChatPhoto: {@code jChatPhoto} of the
     */
    public ChatInviteLink(JSONObject jChatPhoto) {
        super(jChatPhoto);
        inviteLink = hTelegram.getString("invite_link");
        creator = new User(hTelegram.getJSONObject("creator"));
        createsJoinRequest = hTelegram.getBoolean("creates_join_request");
        isPrimary = hTelegram.getBoolean("is_primary");
        isRevoked = hTelegram.getBoolean("is_revoked");
        name = hTelegram.getString("name");
        expireDate = hTelegram.getLong("expire_date", -1);
        memberLimit = hTelegram.getInt("member_limit", 1);
        pendingJoinRequestCount = hTelegram.getInt("pending_join_request_count", -1);
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
     * Method to get {@link #creator} instance <br>
     * No-any params required
     *
     * @return {@link #creator} instance as {@link User}
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Method to get {@link #createsJoinRequest} instance <br>
     * No-any params required
     *
     * @return {@link #createsJoinRequest} instance as boolean
     */
    public boolean createsJoinRequest() {
        return createsJoinRequest;
    }

    /**
     * Method to get {@link #isPrimary} instance <br>
     * No-any params required
     *
     * @return {@link #isPrimary} instance as boolean
     */
    public boolean isPrimary() {
        return isPrimary;
    }

    /**
     * Method to get {@link #isRevoked} instance <br>
     * No-any params required
     *
     * @return {@link #isRevoked} instance as boolean
     */
    public boolean isRevoked() {
        return isRevoked;
    }

    /**
     * Method to get {@link #name} instance <br>
     * No-any params required
     *
     * @return {@link #name} instance as {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get {@link #expireDate} instance <br>
     * No-any params required
     *
     * @return {@link #expireDate} instance as long
     */
    public long getExpireDateTimestamp() {
        return expireDate;
    }

    /**
     * Method to get {@link #expireDate} instance <br>
     * No-any params required
     *
     * @return {@link #expireDate} instance as {@link Date}
     */
    public Date getExpireDate() {
        return getDateValue(expireDate);
    }

    /**
     * Method to get {@link #memberLimit} instance <br>
     * No-any params required
     *
     * @return {@link #memberLimit} instance as int
     */
    public int getMemberLimit() {
        return memberLimit;
    }

    /**
     * Method to get {@link #pendingJoinRequestCount} instance <br>
     * No-any params required
     *
     * @return {@link #pendingJoinRequestCount} instance as int
     */
    public int getPendingJoinRequestCount() {
        return pendingJoinRequestCount;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatInviteLink}
     */
    public static ChatInviteLink getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatInviteLink(jItem);
    }

}
