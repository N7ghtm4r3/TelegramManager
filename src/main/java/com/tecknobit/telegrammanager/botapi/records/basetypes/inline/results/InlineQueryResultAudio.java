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

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.audio;

/**
 * The {@code InlineQueryResultAudio} class is useful to format a {@code Telegram}'s inline query result audio
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultaudio">
 * InlineQueryResultAudio</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultAudio<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code audioUrl} a valid URL for the audio file
     */
    private final String audioUrl;

    /**
     * {@code performer} value
     */
    private final String performer;

    /**
     * {@code audioDuration} audio duration in seconds
     */
    private final int audioDuration;

    /**
     * Constructor to init a {@link InlineQueryResultAudio} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param audioUrl:            a valid URL for the audio file
     * @param performer:           performer value
     * @param audioDuration:       audio duration in seconds
     */
    public InlineQueryResultAudio(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup, String title,
                                  String caption, ArrayList<MessageEntity> captionEntities, String parseMode,
                                  String audioUrl, String performer, int audioDuration) {
        super(audio, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.audioUrl = audioUrl;
        this.performer = performer;
        this.audioDuration = audioDuration;
    }

    /**
     * Constructor to init a {@link InlineQueryResultAudio} object
     *
     * @param jInlineQueryResultAudio: inline query result audio details as {@link JSONObject}
     */
    public InlineQueryResultAudio(JSONObject jInlineQueryResultAudio) {
        super(jInlineQueryResultAudio);
        audioUrl = hTelegram.getString("audio_url");
        performer = hTelegram.getString("performer");
        audioDuration = hTelegram.getInt("audio_duration", 0);
    }

    /**
     * Method to get {@link #audioUrl} instance <br>
     * No-any params required
     *
     * @return {@link #audioUrl} instance as {@link String}
     */
    public String getAudioUrl() {
        return audioUrl;
    }

    /**
     * Method to get {@link #performer} instance <br>
     * No-any params required
     *
     * @return {@link #performer} instance as {@link String}
     */
    public String getPerformer() {
        return performer;
    }

    /**
     * Method to get {@link #audioDuration} instance <br>
     * No-any params required
     *
     * @return {@link #audioDuration} instance as int
     */
    public int getAudioDuration() {
        return audioDuration;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultAudio<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultAudio<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultAudio<>(jItem);
    }

}
