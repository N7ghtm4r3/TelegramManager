package com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.members;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ChatMemberOwner} class is useful to format a {@code Telegram}'s chat member owner
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chatmemberowner">
 *             ChatMemberOwner</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chatmemberadministrator">
 *             ChatMemberAdministrator</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ChatMember
 */
public class ChatMemberOwner extends ChatMember {

    /**
     * {@code isAnonymous} if the user's presence in the chat is hidden
     */
    protected final boolean isAnonymous;

    /**
     * {@code customTitle} custom title for this user
     */
    protected final String customTitle;

    /**
     * Constructor to init a {@link ChatMemberOwner} object
     *
     * @param user:        information about the user
     * @param isAnonymous: if the user's presence in the chat is hidden
     * @param customTitle: custom title for this user
     */
    public ChatMemberOwner(User user, boolean isAnonymous, String customTitle) {
        this(ChatMemberStatus.creator, user, isAnonymous, customTitle);
    }

    /**
     * Constructor to init a {@link ChatMemberOwner} object
     *
     * @param status:      the member's status in the chat
     * @param user:        information about the user
     * @param isAnonymous: if the user's presence in the chat is hidden
     * @param customTitle: custom title for this user
     */
    public ChatMemberOwner(ChatMemberStatus status, User user, boolean isAnonymous, String customTitle) {
        super(status, user);
        this.isAnonymous = isAnonymous;
        this.customTitle = customTitle;
    }

    /**
     * Constructor to init a {@link ChatMemberOwner} object
     *
     * @param jChatMemberOwner: chat member owner details as {@link JSONObject}
     */
    public ChatMemberOwner(JSONObject jChatMemberOwner) {
        super(jChatMemberOwner);
        isAnonymous = hTelegram.getBoolean("is_anonymous");
        customTitle = hTelegram.getString("custom_title");
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
     * Method to get {@link #customTitle} instance <br>
     * No-any params required
     *
     * @return {@link #customTitle} instance as {@link String}
     */
    public String getCustomTitle() {
        return customTitle;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatMemberOwner}
     */
    public static ChatMemberOwner getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatMemberOwner(jItem);
    }

}
