package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.Date;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members.ChatMember.ChatMemberStatus.kicked;

/**
 * The {@code ChatMemberBanned} class is useful to format a {@code Telegram}'s chat member banned
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatmemberbanned">
 * ChatMemberBanned</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ChatMember
 */
public class ChatMemberBanned extends ChatMember {

    /**
     * {@code untilDate} date when restrictions will be lifted for this user; unix time. If 0, then the user is banned forever
     */
    private final long untilDate;

    /**
     * Constructor to init a {@link ChatMemberBanned} object
     *
     * @param user:      information about the user
     * @param untilDate: date when restrictions will be lifted for this user; unix time. If 0, then the user is banned forever
     */
    public ChatMemberBanned(User user, long untilDate) {
        super(kicked, user);
        this.untilDate = untilDate;
    }

    /**
     * Constructor to init a {@link ChatMemberBanned} object
     *
     * @param jChatMember: chat member banned details as {@link JSONObject}
     */
    public ChatMemberBanned(JSONObject jChatMember) {
        super(jChatMember);
        untilDate = hTelegram.getLong("until_date");
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
     * @return instance as {@link ChatMemberBanned}
     */
    public static ChatMemberBanned getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatMemberBanned(jItem);
    }

}
