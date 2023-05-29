package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.sticker;

/**
 * The {@code InlineQueryResultCachedSticker} class is useful to format a {@code Telegram}'s inline query result cached sticker
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedsticker">
 * InlineQueryResultCachedSticker</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 */
public class InlineQueryResultCachedSticker<T extends InputMessageContentType> extends InlineQueryResult<T> {

    /**
     * {@code stickerFileId} a valid file identifier of the sticker
     */
    private final String stickerFileId;

    /**
     * Constructor to init a {@link InlineQueryResultCachedSticker} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param stickerFileId:       a valid file identifier of the sticker
     */
    public InlineQueryResultCachedSticker(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                          String stickerFileId) {
        super(sticker, id, inputMessageContent, replyMarkup);
        this.stickerFileId = stickerFileId;
    }

    /**
     * Constructor to init a {@link InlineQueryResultCachedSticker} object
     *
     * @param jInlineQueryResultCachedSticker: inline query result cached sticker details as {@link JSONObject}
     */
    public InlineQueryResultCachedSticker(JSONObject jInlineQueryResultCachedSticker) {
        super(jInlineQueryResultCachedSticker);
        stickerFileId = hTelegram.getString("sticker_file_id");
    }

    /**
     * Method to get {@link #stickerFileId} instance <br>
     * No-any params required
     *
     * @return {@link #stickerFileId} instance as {@link String}
     */
    public String getStickerFileId() {
        return stickerFileId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultCachedSticker<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultCachedSticker<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedSticker<>(jItem);
    }

}
