package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.audio;

public class InlineQueryResultAudio<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    private final String audioUrl;

    private final String performer;

    private final int audioDuration;

    public InlineQueryResultAudio(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                  String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                  String audioUrl, String performer, int audioDuration) {
        super(audio, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.audioUrl = audioUrl;
        this.performer = performer;
        this.audioDuration = audioDuration;
    }

    public InlineQueryResultAudio(JSONObject jInlineQueryResultAudio) {
        super(jInlineQueryResultAudio);
        audioUrl = hTelegram.getString("audio_url");
        performer = hTelegram.getString("performer");
        audioDuration = hTelegram.getInt("audio_duration", 0);
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public String getPerformer() {
        return performer;
    }

    public int getAudioDuration() {
        return audioDuration;
    }

    public static <T extends InputMessageContentType> InlineQueryResultAudio<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultAudio<>(jItem);
    }

}
