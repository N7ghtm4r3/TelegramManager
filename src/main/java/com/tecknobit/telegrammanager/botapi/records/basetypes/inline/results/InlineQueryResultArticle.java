package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultTitled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.article;

/**
 * The {@code InlineQueryResultArticle} class is useful to format a {@code Telegram}'s inline query result article
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultarticle">
 * InlineQueryResultArticle</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 */
public class InlineQueryResultArticle<T extends InputMessageContentType> extends InlineQueryResultTitled<T> {

    /**
     * {@code url} of the result
     */
    private final String url;

    /**
     * {@code hideUrl} if you don't want the URL to be shown in the message
     */
    private final boolean hideUrl;

    /**
     * {@code thumbnailUrl} url of the thumbnail for the result
     */
    private final String thumbnailUrl;

    /**
     * {@code thumbnailWidth} thumbnail width
     */
    private final double thumbnailWidth;

    /**
     * {@code thumbnailHeight} thumbnail height
     */
    private final double thumbnailHeight;

    /**
     * Constructor to init a {@link InlineQueryResultArticle} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param url:                 URL of the result
     * @param hideUrl:             if you don't want the URL to be shown in the message
     * @param thumbnailUrl:        url of the thumbnail for the result
     * @param thumbnailWidth:      thumbnail width
     * @param thumbnailHeight:     thumbnail height
     */
    public InlineQueryResultArticle(String id, String title, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                    String url, boolean hideUrl, String thumbnailUrl, double thumbnailWidth,
                                    double thumbnailHeight) {
        super(article, id, inputMessageContent, replyMarkup, title);
        this.url = url;
        this.hideUrl = hideUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    /**
     * Constructor to init a {@link InlineQueryResultArticle} object
     *
     * @param jInlineQueryResultArticle: inline query result article details as {@link JSONObject}
     */
    public InlineQueryResultArticle(JSONObject jInlineQueryResultArticle) {
        super(jInlineQueryResultArticle);
        url = hTelegram.getString("url");
        hideUrl = hTelegram.getBoolean("hide_url");
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        thumbnailWidth = hTelegram.getDouble("thumbnail_width", 0);
        thumbnailHeight = hTelegram.getDouble("thumbnail_height", 0);
    }

    /**
     * Method to get {@link #url} instance <br>
     * No-any params required
     *
     * @return {@link #url} instance as {@link String}
     */
    public String getUrl() {
        return url;
    }

    /**
     * Method to get {@link #hideUrl} instance <br>
     * No-any params required
     *
     * @return {@link #hideUrl} instance as boolean
     */
    public boolean getHideUrl() {
        return hideUrl;
    }

    /**
     * Method to get {@link #thumbnailUrl} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailUrl} instance as {@link String}
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Method to get {@link #thumbnailWidth} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailWidth} instance as double
     */
    public double getThumbnailWidth() {
        return thumbnailWidth;
    }

    /**
     * Method to get {@link #thumbnailHeight} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnailHeight} instance as double
     */
    public double getThumbnailHeight() {
        return thumbnailHeight;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultArticle<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultArticle<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultArticle<>(jItem);
    }

}
