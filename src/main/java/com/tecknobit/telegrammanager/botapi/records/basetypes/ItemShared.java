package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ItemShared} class is useful to format a {@code Telegram}'s item shared
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#usershared">
 *             UserShared</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chatshared">
 *             ChatShared</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ItemShared extends TelegramType {

    /**
     * {@code requestId}
     */
    private final long requestId;

    /**
     * {@code itemId}
     */
    private final long itemId;

    /**
     * Constructor to init a {@link ItemShared} object
     *
     * @param requestId: identifier of the request
     * @param itemId:    identifier of the shared item
     */
    public ItemShared(long requestId, long itemId) {
        super(null);
        this.requestId = requestId;
        this.itemId = itemId;
    }

    /**
     * Constructor to init a {@link ItemShared} object
     *
     * @param jItemShared: item shared details as {@link JSONObject}
     */
    public ItemShared(JSONObject jItemShared) {
        super(jItemShared);
        requestId = hTelegram.getLong("request_id");
        long tmpId = hTelegram.getLong("user_id", -1);
        if (tmpId == -1)
            tmpId = hTelegram.getLong("chat_id");
        itemId = tmpId;
    }

    /**
     * Method to get {@link #requestId} instance <br>
     * No-any params required
     *
     * @return {@link #requestId} instance as long
     */
    public long getRequestId() {
        return requestId;
    }

    /**
     * Method to get {@link #itemId} instance <br>
     * No-any params required
     *
     * @return {@link #itemId} instance as long
     */
    public long getItemId() {
        return itemId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ItemShared}
     */
    public static ItemShared getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ItemShared(jItem);
    }

}
