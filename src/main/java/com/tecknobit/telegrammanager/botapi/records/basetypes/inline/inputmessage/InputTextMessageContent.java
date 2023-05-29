package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code InputTextMessageContent} class is useful to format a {@code Telegram}'s input text message content
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputtextmessagecontent">
 * InputTextMessageContent</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InputMessageContentType
 */
public class InputTextMessageContent extends TelegramType implements InputMessageContentType {

    /**
     * {@code messageText} text of the message to be sent, 1-4096 characters
     */
    private final String messageText;

    /**
     * {@code parseMode} mode for parsing entities in the message text
     */
    private final String parseMode;

    /**
     * {@code entities} list of special entities that appear in message text, which can be specified instead of
     * {@link #parseMode}
     */
    private final ArrayList<MessageEntity> entities;

    /**
     * {@code disableWebPagePreview} disables link previews for links in the sent message
     */
    private final boolean disableWebPagePreview;

    /**
     * Constructor to init a {@link InputTextMessageContent} object
     *
     * @param messageText:           text of the message to be sent, 1-4096 characters
     * @param parseMode:             mode for parsing entities in the message text
     * @param entities:              list of special entities that appear in message text, which can be specified instead of
     *                               {@link #parseMode}
     * @param disableWebPagePreview: disables link previews for links in the sent message
     */
    public InputTextMessageContent(String messageText, String parseMode, ArrayList<MessageEntity> entities,
                                   boolean disableWebPagePreview) {
        super(null);
        this.messageText = messageText;
        this.parseMode = parseMode;
        this.entities = entities;
        this.disableWebPagePreview = disableWebPagePreview;
    }

    /**
     * Constructor to init a {@link InputTextMessageContent} object
     *
     * @param jInputTextMessageContent: input text message content details as {@link JSONObject}
     */
    public InputTextMessageContent(JSONObject jInputTextMessageContent) {
        super(jInputTextMessageContent);
        messageText = hTelegram.getString("message_text");
        parseMode = hTelegram.getString("parse_mode");
        entities = MessageEntity.returnMessageEntities(hTelegram.getJSONArray("entities"));
        disableWebPagePreview = hTelegram.getBoolean("disable_web_page_preview");
    }

    /**
     * Method to get {@link #messageText} instance <br>
     * No-any params required
     *
     * @return {@link #messageText} instance as {@link String}
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * Method to get {@link #parseMode} instance <br>
     * No-any params required
     *
     * @return {@link #parseMode} instance as {@link String}
     */
    public String getParseMode() {
        return parseMode;
    }

    /**
     * Method to get {@link #entities} instance <br>
     * No-any params required
     *
     * @return {@link #entities} instance as {@link ArrayList} of {@link MessageEntity}
     */
    public ArrayList<MessageEntity> getEntities() {
        return entities;
    }

    public boolean disableWebPagePreview() {
        return disableWebPagePreview;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InputTextMessageContent}
     */
    public static InputTextMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputTextMessageContent(jItem);
    }

}
