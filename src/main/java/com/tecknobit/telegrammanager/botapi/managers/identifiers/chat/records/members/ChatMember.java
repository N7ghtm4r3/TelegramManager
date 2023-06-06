package com.tecknobit.telegrammanager.botapi.managers.identifiers.chat.records.members;

import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ChatMember} class is useful to format a {@code Telegram}'s chat member
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
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chatmembermember">
 *             ChatMember</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chatmemberrestricted">
 *             ChatMemberRestricted</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chatmemberleft">
 *             ChatMemberLeft</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chatmemberbanned">
 *             ChatMemberBanned</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ChatMember extends TelegramType {

    /**
     * {@code ChatMemberStatus} list of available chat member statuses
     */
    public enum ChatMemberStatus {

        /**
         * {@code creator} chat member status
         */
        creator,

        /**
         * {@code administrator} chat member status
         */
        administrator,

        /**
         * {@code member} chat member status
         */
        member,

        /**
         * {@code restricted} chat member status
         */
        restricted,

        /**
         * {@code left} chat member status
         */
        left,

        /**
         * {@code kicked} chat member status
         */
        kicked

    }

    /**
     * {@code status} the member's status in the chat
     */
    protected final ChatMemberStatus status;

    /**
     * {@code user} information about the user
     */
    protected final User user;

    /**
     * Constructor to init a {@link ChatMember} object
     *
     * @param user: information about the user
     */
    public ChatMember(User user) {
        this(ChatMemberStatus.member, user);
    }

    /**
     * Constructor to init a {@link ChatMember} object
     *
     * @param status: the member's status in the chat
     * @param user:   information about the user
     */
    public ChatMember(ChatMemberStatus status, User user) {
        super(null);
        this.status = status;
        this.user = user;
    }

    /**
     * Constructor to init a {@link ChatMember} object
     *
     * @param jChatMember: chat member details as {@link JSONObject}
     */
    public ChatMember(JSONObject jChatMember) {
        super(jChatMember);
        status = ChatMemberStatus.valueOf(hTelegram.getString("status"));
        user = new User(hTelegram.getJSONObject("user"));
    }

    /**
     * Method to get {@link #status} instance <br>
     * No-any params required
     *
     * @return {@link #status} instance as {@link ChatMemberStatus}
     */
    public ChatMemberStatus getStatus() {
        return status;
    }

    /**
     * Method to get {@link #user} instance <br>
     * No-any params required
     *
     * @return {@link #user} instance as {@link User}
     */
    public User getUser() {
        return user;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatMember}
     */
    public static ChatMember getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatMember(jItem);
    }

}
