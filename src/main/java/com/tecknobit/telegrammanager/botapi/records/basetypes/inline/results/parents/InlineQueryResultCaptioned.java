package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code InlineQueryResultCaptioned} class is useful to format a {@code Telegram}'s inline query result captioned
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedaudio">
 *             InlineQueryResultCachedAudio</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcacheddocument">
 *             InlineQueryResultCachedDocument</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedgif">
 *             InlineQueryResultCachedGif</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedmpeg4gif">
 *             InlineQueryResultCachedMpeg4Gif</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedphoto">
 *             InlineQueryResultCachedPhoto</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedsticker">
 *             InlineQueryResultCachedSticker</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedvideo">
 *             InlineQueryResultCachedVideo</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedvoice">
 *             InlineQueryResultCachedVoice</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultaudio">
 *             InlineQueryResultAudio</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultdocument">
 *             InlineQueryResultDocument</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultgif">
 *             InlineQueryResultGif</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultlocation">
 *             InlineQueryResultLocation</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultmpeg4gif">
 *             InlineQueryResultMpeg4Gif</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultphoto">
 *             InlineQueryResultPhoto</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultvenue">
 *             InlineQueryResultVenue</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultvideo">
 *             InlineQueryResultVideo</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultvoice">
 *             InlineQueryResultVoice</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 */
@Structure
public abstract class InlineQueryResultCaptioned<T extends InputMessageContentType> extends InlineQueryResultTitled<T> {

    /**
     * {@code caption} of the result to be sent
     */
    protected final String caption;

    /**
     * {@code captionEntities} list of special entities that appear in the caption, which can be specified instead of
     * {@link #parseMode}
     */
    protected final ArrayList<MessageEntity> captionEntities;

    /**
     * {@code parseMode} mode for parsing entities in the result caption
     */
    protected final String parseMode;

    /**
     * Constructor to init a {@link InlineQueryResultCaptioned} object
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
     */
    public InlineQueryResultCaptioned(InlineQueryResultType type, String id, T inputMessageContent,
                                      InlineKeyboardMarkup replyMarkup, String title, String caption,
                                      ArrayList<MessageEntity> captionEntities, String parseMode) {
        super(type, id, inputMessageContent, replyMarkup, title);
        this.caption = caption;
        this.captionEntities = captionEntities;
        this.parseMode = parseMode;
    }

    /**
     * Constructor to init a {@link InlineQueryResultCaptioned} object
     *
     * @param jInlineQueryResultCaptioned: inline query result captioned details as {@link JSONObject}
     */
    public InlineQueryResultCaptioned(JSONObject jInlineQueryResultCaptioned) {
        super(jInlineQueryResultCaptioned);
        caption = hTelegram.getString("caption");
        captionEntities = MessageEntity.returnMessageEntities(hTelegram.getJSONArray("caption_entities"));
        parseMode = hTelegram.getString("parse_mode");
    }

    /**
     * Method to get {@link #caption} instance <br>
     * No-any params required
     *
     * @return {@link #caption} instance as {@link String}
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Method to get {@link #captionEntities} instance <br>
     * No-any params required
     *
     * @return {@link #captionEntities} instance as {@link ArrayList} of {@link MessageEntity}
     */
    public ArrayList<MessageEntity> getCaptionEntities() {
        return captionEntities;
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

}
