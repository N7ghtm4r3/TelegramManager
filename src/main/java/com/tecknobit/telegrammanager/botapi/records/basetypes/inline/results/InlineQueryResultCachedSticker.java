package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.sticker;

public class InlineQueryResultCachedSticker<T extends InputMessageContentType> extends InlineQueryResult<T> {

    private final String stickerFileId;

    public InlineQueryResultCachedSticker(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                          String stickerFileId) {
        super(sticker, id, inputMessageContent, replyMarkup);
        this.stickerFileId = stickerFileId;
    }

    public InlineQueryResultCachedSticker(JSONObject jInlineQueryResultCachedSticker) {
        super(jInlineQueryResultCachedSticker);
        stickerFileId = hTelegram.getString("sticker_file_id");
    }

    public String getStickerFileId() {
        return stickerFileId;
    }

    public static <T extends InputMessageContentType> InlineQueryResultCachedSticker<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedSticker<>(jItem);
    }

}
