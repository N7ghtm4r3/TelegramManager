package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultThumbnailed;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.document;

public class InlineQueryResultDocument<T extends InputMessageContentType> extends InlineQueryResultThumbnailed<T> {

    public enum DocumentMimeType {

        APPLICATION_PDF("pdf"),

        APPLICATION_ZIP("zip");

        private final String type;

        DocumentMimeType(String type) {
            this.type = "application/" + type;
        }

        public String getType() {
            return type;
        }

    }

    private final String documentUrl;

    private final DocumentMimeType mimeType;

    public InlineQueryResultDocument(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                     String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                     String documentUrl, DocumentMimeType mimeType, String thumbnailUrl,
                                     double thumbnailWidth, double thumbnailHeight, String documentUrl1,
                                     DocumentMimeType mimeType1) {
        super(document, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode, documentUrl,
                mimeType, thumbnailUrl, thumbnailWidth, thumbnailHeight);
        this.documentUrl = documentUrl1;
        this.mimeType = mimeType1;
    }

    public InlineQueryResultDocument(JSONObject jInlineQueryResultDocument) {
        super(jInlineQueryResultDocument);
        documentUrl = hTelegram.getString("document_url");
        mimeType = DocumentMimeType.valueOf(hTelegram.getString("mime_type"));
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public DocumentMimeType getMimeType() {
        return mimeType;
    }

    public static <T extends InputMessageContentType> InlineQueryResultDocument<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultDocument<>(jItem);
    }

}
