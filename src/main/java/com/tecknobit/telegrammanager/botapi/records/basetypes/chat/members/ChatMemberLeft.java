package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members.ChatMember.ChatMemberStatus.left;

/**
 * The {@code ChatMemberLeft} class is useful to format a {@code Telegram}'s chat member left
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatmemberleft">
 * ChatMemberLeft</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ChatMember
 */
public class ChatMemberLeft extends ChatMember {

    /**
     * Constructor to init a {@link ChatMemberLeft} object
     *
     * @param user: information about the user
     */
    public ChatMemberLeft(User user) {
        super(left, user);
    }

    /**
     * Constructor to init a {@link ChatMemberLeft} object
     *
     * @param jChatMember: chat member left details as {@link JSONObject}
     */
    public ChatMemberLeft(JSONObject jChatMember) {
        super(jChatMember);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatMemberLeft}
     */
    public static ChatMemberLeft getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatMemberLeft(jItem);
    }

}
