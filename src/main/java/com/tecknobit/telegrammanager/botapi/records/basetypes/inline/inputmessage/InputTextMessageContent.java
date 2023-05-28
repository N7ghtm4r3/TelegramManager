package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

import java.util.ArrayList;

public class InputTextMessageContent extends TelegramType implements InputMessageContentType {

    private final String messageText;

    private final String parseMode;

    private final ArrayList<MessageEntity> entities;

    private final boolean disableWebPagePreview;

    public InputTextMessageContent(String messageText, String parseMode, ArrayList<MessageEntity> entities,
                                   boolean disableWebPagePreview) {
        super(null);
        this.messageText = messageText;
        this.parseMode = parseMode;
        this.entities = entities;
        this.disableWebPagePreview = disableWebPagePreview;
    }

    public InputTextMessageContent(JSONObject jInputTextMessageContent) {
        super(jInputTextMessageContent);
        messageText = hTelegram.getString("message_text");
        parseMode = hTelegram.getString("parse_mode");
        entities = MessageEntity.returnMessageEntities(hTelegram.getJSONArray("entities"));
        disableWebPagePreview = hTelegram.getBoolean("disable_web_page_preview");
    }

    public String getMessageText() {
        return messageText;
    }

    public String getParseMode() {
        return parseMode;
    }

    public ArrayList<MessageEntity> getEntities() {
        return entities;
    }

    public boolean disableWebPagePreview() {
        return disableWebPagePreview;
    }

    public static InputTextMessageContent getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputTextMessageContent(jItem);
    }

}
