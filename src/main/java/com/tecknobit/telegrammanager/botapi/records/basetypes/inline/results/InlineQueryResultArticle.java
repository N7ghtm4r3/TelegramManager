package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultTitled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.article;

public class InlineQueryResultArticle<T extends InputMessageContentType> extends InlineQueryResultTitled<T> {

    private final String url;

    private final String hideUrl;

    private final String thumbnailUrl;

    private final double thumbnailWidth;

    private final double thumbnailHeight;

    public InlineQueryResultArticle(String id, String title, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                    String url, String hideUrl, String thumbnailUrl, double thumbnailWidth,
                                    double thumbnailHeight) {
        super(article, id, inputMessageContent, replyMarkup, title);
        this.url = url;
        this.hideUrl = hideUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public InlineQueryResultArticle(JSONObject jInlineQueryResultArticle) {
        super(jInlineQueryResultArticle);
        url = hTelegram.getString("url");
        hideUrl = hTelegram.getString("hide_url");
        thumbnailUrl = hTelegram.getString("thumbnail_url");
        thumbnailWidth = hTelegram.getDouble("thumbnail_width", 0);
        thumbnailHeight = hTelegram.getDouble("thumbnail_height", 0);
    }

    public String getUrl() {
        return url;
    }

    public String getHideUrl() {
        return hideUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public double getThumbnailWidth() {
        return thumbnailWidth;
    }

    public double getThumbnailHeight() {
        return thumbnailHeight;
    }

    public static <T extends InputMessageContentType> InlineQueryResultArticle<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultArticle<>(jItem);
    }

}
