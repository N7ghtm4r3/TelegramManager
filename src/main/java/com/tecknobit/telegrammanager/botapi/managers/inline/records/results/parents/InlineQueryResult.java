package com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.inputmessage.InputMessageContent;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup.getInstance;

/**
 * The {@code InlineQueryResult} class is useful to format a {@code Telegram}'s inline query result
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
 *         <a href="https://core.telegram.org/bots/api#inlinequeryresultgame">
 *             InlineQueryResultGame</a>
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
 * @see InputMessageContent.InputMessageContentType
 */
@Structure
public abstract class InlineQueryResult<T extends InputMessageContent.InputMessageContentType> extends TelegramType {

    /**
     * {@code InlineQueryResultType} list of available inline query result types
     */
    public enum InlineQueryResultType {

        /**
         * {@code article} inline query result type
         */
        article,

        /**
         * {@code photo} inline query result type
         */
        photo,

        /**
         * {@code gif} inline query result type
         */
        gif,

        /**
         * {@code mpeg4_gif} inline query result type
         */
        mpeg4_gif,

        /**
         * {@code video} inline query result type
         */
        video,

        /**
         * {@code audio} inline query result type
         */
        audio,

        /**
         * {@code voice} inline query result type
         */
        voice,

        /**
         * {@code document} inline query result type
         */
        document,

        /**
         * {@code location} inline query result type
         */
        location,

        /**
         * {@code venue} inline query result type
         */
        venue,

        /**
         * {@code contact} inline query result type
         */
        contact,

        /**
         * {@code game} inline query result type
         */
        game,

        /**
         * {@code sticker} inline query result type
         */
        sticker

    }

    /**
     * {@code type} of the result
     */
    protected final InlineQueryResultType type;

    /**
     * {@code id} unique identifier for this result, 1-64 Bytes
     */
    protected final String id;

    /**
     * {@code inputMessageContent} content of the message to be sent
     */
    protected final T inputMessageContent;

    /**
     * {@code replyMarkup} inline keyboard attached to the message
     */
    protected final InlineKeyboardMarkup replyMarkup;

    /**
     * Constructor to init a {@link InlineQueryResult} object
     *
     * @param type:                type of the result
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     */
    public InlineQueryResult(InlineQueryResultType type, String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup) {
        super(null);
        this.type = type;
        this.id = id;
        this.inputMessageContent = inputMessageContent;
        this.replyMarkup = replyMarkup;
    }

    /**
     * Constructor to init a {@link InlineQueryResult} object
     *
     * @param jInlineQueryResult: inline query result details as {@link JSONObject}
     */
    public InlineQueryResult(JSONObject jInlineQueryResult) {
        super(jInlineQueryResult);
        type = InlineQueryResultType.valueOf(hTelegram.getString("type"));
        id = hTelegram.getString("id");
        inputMessageContent = InputMessageContent.getInputMessageContent(hTelegram.getJSONObject("input_message_content"));
        replyMarkup = getInstance(hTelegram.getJSONObject("reply_markup"));
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link InlineQueryResultType}
     */
    public InlineQueryResultType getType() {
        return type;
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     */
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #inputMessageContent} instance <br>
     * No-any params required
     *
     * @return {@link #inputMessageContent} instance as {@link T}
     */
    public T getInputMessageContent() {
        return inputMessageContent;
    }

    /**
     * Method to get {@link #replyMarkup} instance <br>
     * No-any params required
     *
     * @return {@link #replyMarkup} instance as {@link InlineKeyboardMarkup}
     */
    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

}
