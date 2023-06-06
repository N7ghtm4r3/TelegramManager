package com.tecknobit.telegrammanager.botapi.managers.inline.records.results;

import com.tecknobit.telegrammanager.botapi.managers.inline.records.inputmessage.InputMessageContent;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResultTitled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.managers.inline.records.results.parents.InlineQueryResult.InlineQueryResultType.audio;

/**
 * The {@code InlineQueryResultCachedAudio} class is useful to format a {@code Telegram}'s inline query result cached audio
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedaudio">
 * InlineQueryResultCachedAudio</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultCachedAudio<T extends InputMessageContent.InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code audioFileId} a valid file identifier for the audio file
     */
    private final String audioFileId;

    /**
     * Constructor to init a {@link InlineQueryResultCachedAudio} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param audioFileId:         a valid file identifier for the audio file
     */
    public InlineQueryResultCachedAudio(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                        String title, String caption, ArrayList<MessageEntity> captionEntities,
                                        String parseMode, String audioFileId) {
        super(audio, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.audioFileId = audioFileId;
    }

    /**
     * Constructor to init a {@link InlineQueryResultCachedAudio} object
     *
     * @param jInlineQueryResultCachedAudio: inline query result cached audio details as {@link JSONObject}
     */
    public InlineQueryResultCachedAudio(JSONObject jInlineQueryResultCachedAudio) {
        super(jInlineQueryResultCachedAudio);
        audioFileId = hTelegram.getString("audio_file_id");
    }

    /**
     * Method to get {@link #audioFileId} instance <br>
     * No-any params required
     *
     * @return {@link #audioFileId} instance as {@link String}
     */
    public String getAudioFileId() {
        return audioFileId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultCachedAudio<T>}
     */
    public static <T extends InputMessageContent.InputMessageContentType> InlineQueryResultCachedAudio<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedAudio<>(jItem);
    }

}
