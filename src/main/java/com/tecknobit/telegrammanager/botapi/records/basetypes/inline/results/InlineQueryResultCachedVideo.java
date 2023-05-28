package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.video;

public class InlineQueryResultCachedVideo<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    private final String videoFileId;

    public InlineQueryResultCachedVideo(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                        String title, String caption, ArrayList<MessageEntity> captionEntities,
                                        String parseMode, String videoFileId) {
        super(video, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.videoFileId = videoFileId;
    }

    public InlineQueryResultCachedVideo(JSONObject jInlineQueryResultCachedVideo) {
        super(jInlineQueryResultCachedVideo);
        videoFileId = hTelegram.getString("video_file_id");
    }

    public String getVideoFileId() {
        return videoFileId;
    }

    public static <T extends InputMessageContentType> InlineQueryResultCachedVideo<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedVideo<>(jItem);
    }

}
