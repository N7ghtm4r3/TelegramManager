package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members.actions;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.ChatInviteLink;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.Date;

/**
 * The {@code ChatAction} class is useful to format a {@code Telegram}'s chat action
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chatmemberupdated">
 *             ChatMemberUpdated</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chatjoinrequest">
 *             ChatJoinRequest</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
@Structure
public abstract class ChatAction extends TelegramType {

    /**
     * {@code chat} of the action
     */
    protected final Chat chat;

    /**
     * {@code from} user the request the action
     */
    protected final User from;

    /**
     * {@code date} of the action
     */
    protected final long date;

    /**
     * {@code inviteLink} invite link of the action
     */
    protected final ChatInviteLink inviteLink;

    /**
     * Constructor to init a {@link ChatAction} object
     *
     * @param chat:       chat of the action
     * @param from:       user the request the action
     * @param date:       date of the action
     * @param inviteLink: invite link of the action
     */
    public ChatAction(Chat chat, User from, long date, ChatInviteLink inviteLink) {
        super(null);
        this.chat = chat;
        this.from = from;
        this.date = date;
        this.inviteLink = inviteLink;
    }

    /**
     * Constructor to init a {@link ChatAction} object
     *
     * @param jChatAction: chat action details as {@link JSONObject}
     */
    public ChatAction(JSONObject jChatAction) {
        super(jChatAction);
        chat = new Chat(hTelegram.getJSONObject("chat"));
        from = new User(hTelegram.getJSONObject("from"));
        date = hTelegram.getLong("date");
        inviteLink = ChatInviteLink.getInstance(hTelegram.getJSONObject("invite_link"));
    }

    /**
     * Method to get {@link #chat} instance <br>
     * No-any params required
     *
     * @return {@link #chat} instance as {@link Chat}
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * Method to get {@link #from} instance <br>
     * No-any params required
     *
     * @return {@link #from} instance as {@link User}
     */
    public User getFrom() {
        return from;
    }

    /**
     * Method to get {@link #date} instance <br>
     * No-any params required
     *
     * @return {@link #date} instance as long
     */
    public long getDateTimestamp() {
        return date;
    }

    /**
     * Method to get {@link #date} instance <br>
     * No-any params required
     *
     * @return {@link #date} instance as {@link Date}
     */
    public Date getDate() {
        return new Date(date);
    }

    /**
     * Method to get {@link #inviteLink} instance <br>
     * No-any params required
     *
     * @return {@link #inviteLink} instance as {@link ChatInviteLink}
     */
    public ChatInviteLink getInviteLink() {
        return inviteLink;
    }

}
