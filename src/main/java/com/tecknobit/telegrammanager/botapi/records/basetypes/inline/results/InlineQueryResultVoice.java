package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultTitled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.voice;

/**
 * The {@code InlineQueryResultVoice} class is useful to format a {@code Telegram}'s inline query result voice
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultvoice">
 * InlineQueryResultVoice</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultVoice<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code voiceUrl} a valid URL for the voice recording
     */
    private final String voiceUrl;

    /**
     * {@code voiceDuration} recording duration in seconds
     */
    private final int voiceDuration;

    /**
     * Constructor to init a {@link InlineQueryResultVoice} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param voiceUrl:            a valid URL for the voice recording
     * @param voiceDuration:       recording duration in seconds
     */
    public InlineQueryResultVoice(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                  String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                  String voiceUrl, int voiceDuration) {
        super(voice, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.voiceUrl = voiceUrl;
        this.voiceDuration = voiceDuration;
    }

    /**
     * Constructor to init a {@link InlineQueryResultVoice} object
     *
     * @param jInlineQueryResultVoice: inline query result voice details as {@link JSONObject}
     */
    public InlineQueryResultVoice(JSONObject jInlineQueryResultVoice) {
        super(jInlineQueryResultVoice);
        voiceUrl = hTelegram.getString("voice_url");
        voiceDuration = hTelegram.getInt("voice_duration", 0);
    }

    /**
     * Method to get {@link #voiceUrl} instance <br>
     * No-any params required
     *
     * @return {@link #voiceUrl} instance as {@link String}
     */
    public String getVoiceUrl() {
        return voiceUrl;
    }

    /**
     * Method to get {@link #voiceDuration} instance <br>
     * No-any params required
     *
     * @return {@link #voiceDuration} instance as int
     */
    public int getVoiceDuration() {
        return voiceDuration;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultVoice<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultVoice<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultVoice<>(jItem);
    }

}
