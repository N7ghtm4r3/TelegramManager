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

/**
 * The {@code InlineQueryResultCachedGif} class is useful to format a {@code Telegram}'s inline query result cached Gif
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedgif">
 *             InlineQueryResultCachedGif</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedmpeg4gif">
 *             InlineQueryResultCachedMpeg4Gif</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultCachedGif<T extends InputMessageContent.InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code fileId} a valid file identifier for the file
     */
    private final String fileId;

    /**
     * Constructor to init a {@link InlineQueryResultCachedGif} object
     *
     * @param type:                type of the result
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param fileId:              a valid file identifier for the file
     */
    public InlineQueryResultCachedGif(InlineQueryResultType type, String id, T inputMessageContent,
                                      InlineKeyboardMarkup replyMarkup, String title, String caption,
                                      ArrayList<MessageEntity> captionEntities, String parseMode, String fileId) {
        super(type, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.fileId = fileId;
    }

    /**
     * Constructor to init a {@link InlineQueryResultCachedGif} object
     *
     * @param jInlineQueryResultCachedGif: inline query result cached Gif details {@link JSONObject}
     */
    public InlineQueryResultCachedGif(JSONObject jInlineQueryResultCachedGif) {
        super(jInlineQueryResultCachedGif);
        fileId = hTelegram.getString("gif_file_id", hTelegram.getString("mpeg4_file_id"));
    }

    /**
     * Method to get {@link #fileId} instance <br>
     * No-any params required
     *
     * @return {@link #fileId} instance as {@link String}
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultCachedGif<T>}
     */
    public static <T extends InputMessageContent.InputMessageContentType> InlineQueryResultCachedGif<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedGif<>(jItem);
    }

}
