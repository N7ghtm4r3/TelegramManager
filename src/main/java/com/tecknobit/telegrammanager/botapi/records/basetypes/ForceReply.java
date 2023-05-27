package com.tecknobit.telegrammanager.botapi.records.basetypes;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ForceReply} class is useful to format a {@code Telegram}'s force reply
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forcereply">
 * ForceReply</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ForceReply extends TelegramType {

    /**
     * {@code forceReply} shows reply interface to the user, as if they manually selected the bot's message and tapped
     * 'Reply'
     */
    private final boolean forceReply;

    /**
     * {@code inputFieldPlaceholder} the placeholder to be shown in the input field when the reply is active; 1-64 characters
     */
    private final String inputFieldPlaceholder;

    /**
     * {@code selective} use this parameter if you want to force reply from specific users only, targets:
     * <ul>
     *     <li>
     *          users that are @mentioned in the text of the Message object
     *     </li>
     *     <li>
     *          if the bot's message is a reply (has reply_to_message_id), sender of the original message
     *     </li>
     * </ul>
     */
    private final boolean selective;

    /**
     * Constructor to init a {@link ForceReply} object
     *
     * @param forceReply:            shows reply interface to the user, as if they manually selected the bot's message and tapped
     *                               'Reply'
     * @param inputFieldPlaceholder: the placeholder to be shown in the input field when the reply is active; 1-64 characters
     * @param selective:             use this parameter if you want to force reply from specific users only
     */
    public ForceReply(boolean forceReply, String inputFieldPlaceholder, boolean selective) {
        super(null);
        this.forceReply = forceReply;
        this.inputFieldPlaceholder = inputFieldPlaceholder;
        this.selective = selective;
    }

    /**
     * Constructor to init a {@link ForceReply} object
     *
     * @param jForceReply: force reply details as {@link JSONObject}
     */
    public ForceReply(JSONObject jForceReply) {
        super(jForceReply);
        forceReply = hTelegram.getBoolean("force_reply");
        inputFieldPlaceholder = hTelegram.getString("input_field_placeholder");
        selective = hTelegram.getBoolean("selective");
    }

    /**
     * Method to get {@link #forceReply} instance <br>
     * No-any params required
     *
     * @return {@link #forceReply} instance as boolean
     */
    public boolean forceReply() {
        return forceReply;
    }

    /**
     * Method to get {@link #inputFieldPlaceholder} instance <br>
     * No-any params required
     *
     * @return {@link #inputFieldPlaceholder} instance as {@link String}
     */
    public String getInputFieldPlaceholder() {
        return inputFieldPlaceholder;
    }

    /**
     * Method to get {@link #selective} instance <br>
     * No-any params required
     *
     * @return {@link #selective} instance as boolean
     */
    public boolean isSelective() {
        return selective;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ForceReply}
     */
    public static ForceReply getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForceReply(jItem);
    }

}
