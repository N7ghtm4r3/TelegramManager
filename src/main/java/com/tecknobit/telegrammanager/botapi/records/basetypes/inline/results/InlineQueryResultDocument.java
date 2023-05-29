package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultThumbnailed;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultTitled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.document;

/**
 * The {@code InlineQueryResultDocument} class is useful to format a {@code Telegram}'s inline query result document
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultdocument">
 * InlineQueryResultDocument</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 * @see InlineQueryResultThumbnailed
 */
public class InlineQueryResultDocument<T extends InputMessageContentType> extends InlineQueryResultThumbnailed<T> {

    /**
     * {@code DocumentMimeType} the list of available document mime types
     */
    public enum DocumentMimeType {

        /**
         * {@code APPLICATION_PDF} document mime type
         */
        APPLICATION_PDF("pdf"),

        /**
         * {@code APPLICATION_ZIP} document mime type
         */
        APPLICATION_ZIP("zip");

        /**
         * {@code type} value
         */
        private final String type;

        /**
         * Constructor to init a {@link DocumentMimeType} object
         *
         * @param type: type value
         */
        DocumentMimeType(String type) {
            this.type = "application/" + type;
        }

        /**
         * Method to get {@link #type} instance <br>
         * No-any params required
         *
         * @return {@link #type} instance as {@link String}
         */
        public String getType() {
            return type;
        }

    }

    /**
     * {@code documentUrl} a valid URL for the file
     */
    private final String documentUrl;

    /**
     * {@code mimeType} MIME type of the content of the file
     */
    private final DocumentMimeType mimeType;

    /**
     * Constructor to init a {@link InlineQueryResultDocument} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param thumbnailUrl:        URL of the thumbnail
     * @param thumbnailWidth:      thumbnail width
     * @param thumbnailHeight:     thumbnail height
     * @param documentUrl:         a valid URL for the file
     * @param mimeType:            MIME type of the content of the file
     */
    public InlineQueryResultDocument(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                     String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                     String thumbnailUrl, double thumbnailWidth, double thumbnailHeight,
                                     String documentUrl, DocumentMimeType mimeType) {
        super(document, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode, thumbnailUrl,
                thumbnailWidth, thumbnailHeight);
        this.documentUrl = documentUrl;
        this.mimeType = mimeType;
    }

    /**
     * Constructor to init a {@link InlineQueryResultDocument} object
     *
     * @param jInlineQueryResultDocument: inline query result document details as {@link JSONObject}
     */
    public InlineQueryResultDocument(JSONObject jInlineQueryResultDocument) {
        super(jInlineQueryResultDocument);
        documentUrl = hTelegram.getString("document_url");
        mimeType = DocumentMimeType.valueOf(hTelegram.getString("mime_type"));
    }

    /**
     * Method to get {@link #documentUrl} instance <br>
     * No-any params required
     *
     * @return {@link #documentUrl} instance as {@link String}
     */
    public String getDocumentUrl() {
        return documentUrl;
    }

    /**
     * Method to get {@link #mimeType} instance <br>
     * No-any params required
     *
     * @return {@link #mimeType} instance as {@link DocumentMimeType}
     */
    public DocumentMimeType getMimeType() {
        return mimeType;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultDocument<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultDocument<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultDocument<>(jItem);
    }

}
