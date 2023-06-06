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

import static com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResult.InlineQueryResultType.photo;

/**
 * The {@code InlineQueryResultCachedPhoto} class is useful to format a {@code Telegram}'s inline query result cached photo
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedphoto">
 * InlineQueryResultCachedPhoto</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultCachedPhoto<T extends InputMessageContent.InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code photoFileId} a valid file identifier for the file
     */
    private final String photoFileId;

    /**
     * Constructor to init a {@link InlineQueryResultCachedPhoto} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param photoFileId:         a valid file identifier for the file
     */
    public InlineQueryResultCachedPhoto(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                        String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                        String photoFileId) {
        super(photo, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.photoFileId = photoFileId;
    }

    /**
     * Constructor to init a {@link InlineQueryResultCachedPhoto} object
     *
     * @param jInlineQueryResultCachedPhoto: inline query result cached photo details as {@link JSONObject}
     */
    public InlineQueryResultCachedPhoto(JSONObject jInlineQueryResultCachedPhoto) {
        super(jInlineQueryResultCachedPhoto);
        photoFileId = hTelegram.getString("photo_file_id");
    }

    /**
     * Method to get {@link #photoFileId} instance <br>
     * No-any params required
     *
     * @return {@link #photoFileId} instance as {@link String}
     */
    public String getPhotoFileId() {
        return photoFileId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultCachedPhoto<T>}
     */
    public static <T extends InputMessageContent.InputMessageContentType> InlineQueryResultCachedPhoto<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedPhoto<>(jItem);
    }

}
