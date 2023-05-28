package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.document;

public class InlineQueryResultCachedDocument<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    private final String documentFileId;

    public InlineQueryResultCachedDocument(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                           String title, String caption, ArrayList<MessageEntity> captionEntities,
                                           String parseMode, String documentFileId) {
        super(document, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.documentFileId = documentFileId;
    }

    public InlineQueryResultCachedDocument(JSONObject jInlineQueryResultCachedDocument) {
        super(jInlineQueryResultCachedDocument);
        documentFileId = hTelegram.getString("document_file_id");
    }

    public String getDocumentFileId() {
        return documentFileId;
    }

    public static <T extends InputMessageContentType> InlineQueryResultCachedDocument<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedDocument<>(jItem);
    }

}
