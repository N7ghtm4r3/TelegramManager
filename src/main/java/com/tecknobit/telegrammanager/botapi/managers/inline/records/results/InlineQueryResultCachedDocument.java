package com.tecknobit.telegrammanager.botapi.managers.inline.records.results;

import com.tecknobit.telegrammanager.botapi.managers.inline.records.inputmessage.InputMessageContent;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResultTitled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResult.InlineQueryResultType.document;

/**
 * The {@code InlineQueryResultCachedDocument} class is useful to format a {@code Telegram}'s inline query result cached document
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultcacheddocument">
 * InlineQueryResultCachedDocument</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultCachedDocument<T extends InputMessageContent.InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code documentFileId} a valid file identifier for the file
     */
    private final String documentFileId;

    /**
     * Constructor to init a {@link InlineQueryResultCachedDocument} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param documentFileId:      a valid file identifier for the file
     */
    public InlineQueryResultCachedDocument(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                           String title, String caption, ArrayList<MessageEntity> captionEntities,
                                           String parseMode, String documentFileId) {
        super(document, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.documentFileId = documentFileId;
    }

    /**
     * Constructor to init a {@link InlineQueryResultCachedDocument} object
     *
     * @param jInlineQueryResultCachedDocument: inline query result cached document details as {@link JSONObject}
     */
    public InlineQueryResultCachedDocument(JSONObject jInlineQueryResultCachedDocument) {
        super(jInlineQueryResultCachedDocument);
        documentFileId = hTelegram.getString("document_file_id");
    }

    /**
     * Method to get {@link #documentFileId} instance <br>
     * No-any params required
     *
     * @return {@link #documentFileId} instance as {@link String}
     */
    public String getDocumentFileId() {
        return documentFileId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultCachedDocument<T>}
     */
    public static <T extends InputMessageContent.InputMessageContentType> InlineQueryResultCachedDocument<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedDocument<>(jItem);
    }

}
