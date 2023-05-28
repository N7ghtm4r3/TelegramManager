package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.voice;

public class InlineQueryResultVoice<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    private final String voiceUrl;

    private final int voiceDuration;

    public InlineQueryResultVoice(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                  String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                  String voiceUrl, int voiceDuration) {
        super(voice, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.voiceUrl = voiceUrl;
        this.voiceDuration = voiceDuration;
    }

    public InlineQueryResultVoice(JSONObject jInlineQueryResultVoice) {
        super(jInlineQueryResultVoice);
        voiceUrl = hTelegram.getString("voice_url");
        voiceDuration = hTelegram.getInt("voice_duration", 0);
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public int getVoiceDuration() {
        return voiceDuration;
    }

    public static <T extends InputMessageContentType> InlineQueryResultVoice<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultVoice<>(jItem);
    }

}
