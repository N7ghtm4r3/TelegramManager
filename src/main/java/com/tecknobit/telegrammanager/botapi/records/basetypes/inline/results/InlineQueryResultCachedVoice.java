package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.voice;

public class InlineQueryResultCachedVoice<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    private final String voiceFileId;

    public InlineQueryResultCachedVoice(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                        String title, String caption, ArrayList<MessageEntity> captionEntities,
                                        String parseMode, String voiceFileId) {
        super(voice, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.voiceFileId = voiceFileId;
    }

    public InlineQueryResultCachedVoice(JSONObject jInlineQueryResultCachedVoice) {
        super(jInlineQueryResultCachedVoice);
        voiceFileId = hTelegram.getString("voice_file_id");
    }

    public String getVoiceFileId() {
        return voiceFileId;
    }

    public static <T extends InputMessageContentType> InlineQueryResultCachedVideo<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedVideo<>(jItem);
    }

}
