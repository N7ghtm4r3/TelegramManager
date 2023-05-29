package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;


/**
 * The {@code InlineQueryResultTitled} class is useful to format a {@code Telegram}'s inline query result titled
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
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultarticle">
 *             InlineQueryResultArticle</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultaudio">
 *             InlineQueryResultAudio</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultcontact">
 *             InlineQueryResultContact</a>
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
 */
@Structure
public abstract class InlineQueryResultTitled<T extends InputMessageContentType> extends InlineQueryResult<T> {

    /**
     * {@code title} of the result
     */
    protected final String title;

    /**
     * Constructor to init a {@link InlineQueryResultTitled} object
     *
     * @param type:                type of the result
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     */
    public InlineQueryResultTitled(InlineQueryResultType type, String id, T inputMessageContent,
                                   InlineKeyboardMarkup replyMarkup, String title) {
        super(type, id, inputMessageContent, replyMarkup);
        this.title = title;
    }

    /**
     * Constructor to init a {@link InlineQueryResultTitled} object
     *
     * @param jInlineQueryResultTitled: inline query result titled details as {@link JSONObject}
     */
    public InlineQueryResultTitled(JSONObject jInlineQueryResultTitled) {
        super(jInlineQueryResultTitled);
        title = hTelegram.getString("title");
    }

    /**
     * Method to get {@link #title} instance <br>
     * No-any params required
     *
     * @return {@link #title} instance as {@link String}
     */
    public String getTitle() {
        return title;
    }

}
