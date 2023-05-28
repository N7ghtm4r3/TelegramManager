package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.audio;

public class InlineQueryResultCachedAudio<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    private final String audioFileId;

    public InlineQueryResultCachedAudio(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                        String title, String caption, ArrayList<MessageEntity> captionEntities,
                                        String parseMode, String audioFileId) {
        super(audio, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.audioFileId = audioFileId;
    }

    public InlineQueryResultCachedAudio(JSONObject jInlineQueryResultCachedAudio) {
        super(jInlineQueryResultCachedAudio);
        audioFileId = hTelegram.getString("audio_file_id");
    }

    public String getAudioFileId() {
        return audioFileId;
    }

    public static <T extends InputMessageContentType> InlineQueryResultCachedAudio<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedAudio<>(jItem);
    }

}
