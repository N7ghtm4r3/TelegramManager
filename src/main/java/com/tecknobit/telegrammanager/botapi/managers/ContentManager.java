package com.tecknobit.telegrammanager.botapi.managers;

import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia.InputMediaType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageId;

import java.io.IOException;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramBotManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message.returnMessage;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageId.returnMessageId;

/**
 * The {@code ContentManager} class is useful to create a {@code Telegram}'s bot content manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#available-methods">
 * Available methods</a>
 */
public class ContentManager extends TelegramBotManager {

    /**
     * {@code SEND_MESSAGE_ENDPOINT} is constant for SEND_MESSAGE_ENDPOINT's endpoint
     **/
    public static final String SEND_MESSAGE_ENDPOINT = "sendMessage";

    /**
     * {@code FORWARD_MESSAGE_ENDPOINT} is constant for FORWARD_MESSAGE_ENDPOINT's endpoint
     **/
    public static final String FORWARD_MESSAGE_ENDPOINT = "forwardMessage";

    /**
     * {@code COPY_MESSAGE_ENDPOINT} is constant for COPY_MESSAGE_ENDPOINT's endpoint
     **/
    public static final String COPY_MESSAGE_ENDPOINT = "copyMessage";

    /**
     * {@code SEND_PHOTO_ENDPOINT} is constant for SEND_PHOTO_ENDPOINT's endpoint
     **/
    public static final String SEND_PHOTO_ENDPOINT = "sendPhoto";

    /**
     * {@code SEND_AUDIO_ENDPOINT} is constant for SEND_AUDIO_ENDPOINT's endpoint
     **/
    public static final String SEND_AUDIO_ENDPOINT = "sendAudio";

    /**
     * {@code SEND_DOCUMENT_ENDPOINT} is constant for SEND_DOCUMENT_ENDPOINT's endpoint
     **/
    public static final String SEND_DOCUMENT_ENDPOINT = "sendDocument";

    /**
     * {@code SEND_VIDEO_ENDPOINT} is constant for SEND_VIDEO_ENDPOINT's endpoint
     **/
    public static final String SEND_VIDEO_ENDPOINT = "sendVideo";

    /**
     * {@code SEND_ANIMATION_ENDPOINT} is constant for SEND_ANIMATION_ENDPOINT's endpoint
     **/
    public static final String SEND_ANIMATION_ENDPOINT = "sendAnimation";

    /**
     * {@code SEND_VOICE_ENDPOINT} is constant for SEND_VOICE_ENDPOINT's endpoint
     **/
    public static final String SEND_VOICE_ENDPOINT = "sendVoice";

    /**
     * {@code SEND_VIDEO_NOTE_ENDPOINT} is constant for SEND_VIDEO_NOTE_ENDPOINT's endpoint
     **/
    public static final String SEND_VIDEO_NOTE_ENDPOINT = "sendVideoNote";

    /**
     * {@code SEND_MEDIA_GROUP_ENDPOINT} is constant for SEND_MEDIA_GROUP_ENDPOINT's endpoint
     **/
    public static final String SEND_MEDIA_GROUP_ENDPOINT = "sendMediaGroup";

    /**
     * {@code SEND_LOCATION_ENDPOINT} is constant for SEND_LOCATION_ENDPOINT's endpoint
     **/
    public static final String SEND_LOCATION_ENDPOINT = "sendLocation";

    /**
     * {@code SEND_VENUE_ENDPOINT} is constant for SEND_VENUE_ENDPOINT's endpoint
     **/
    public static final String SEND_VENUE_ENDPOINT = "sendVenue";

    /**
     * {@code SEND_CONTACT_ENDPOINT} is constant for SEND_CONTACT_ENDPOINT's endpoint
     **/
    public static final String SEND_CONTACT_ENDPOINT = "sendContact";

    /**
     * {@code SEND_POLL_ENDPOINT} is constant for SEND_POLL_ENDPOINT's endpoint
     **/
    public static final String SEND_POLL_ENDPOINT = "sendPoll";

    /**
     * {@code SEND_DICE_ENDPOINT} is constant for SEND_DICE_ENDPOINT's endpoint
     **/
    public static final String SEND_DICE_ENDPOINT = "sendDice";

    /**
     * {@code SEND_CHAT_ACTION_ENDPOINT} is constant for SEND_CHAT_ACTION_ENDPOINT's endpoint
     **/
    public static final String SEND_CHAT_ACTION_ENDPOINT = "sendChatAction";

    /**
     * Constructor to init {@link ContentManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public ContentManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link ContentManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public ContentManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link ContentManager}
     *
     * @param token : the bot unique authentication token
     */
    public ContentManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link ContentManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public ContentManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init a {@link TelegramBotManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link TelegramBotManager}'s manager without re-insert
     * the credentials and is useful in those cases if you need to use different manager at the same time:
     * <pre>
     *     {@code
     *        //You need to insert all credentials requested
     *        TelegramBotManager firstManager = new TelegramBotManager("token", "defaultErrorMessage", timeout);
     *        //You don't need to insert all credentials to make manager work
     *        TelegramBotManager secondManager = new TelegramBotManager(); //same credentials used
     *     }
     * </pre>
     */
    public ContentManager() throws Exception {
        super();
    }

    public <T> Message sendMessage(T chatId, String text) throws IOException {
        return (Message) sendMessage(chatId, text, LIBRARY_OBJECT);
    }

    public <T> T sendMessage(T chatId, String text, ReturnFormat format) throws IOException {
        return sendMessage(chatId, text, null, LIBRARY_OBJECT);
    }

    public <T> Message sendMessage(T chatId, String text, Params parameters) throws IOException {
        return (Message) sendMessage(chatId, text, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendMessage(T chatId, String text, Params parameters, ReturnFormat format) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("chat_id", getChatId(chatId));
        parameters.addParam("text", text);
        return returnMessage(sendPostRequest(SEND_MESSAGE_ENDPOINT, parameters), format);
    }

    public <T> Message forwardMessage(T chatId, T fromChatId, Message message) throws IOException {
        return (Message) forwardMessage(chatId, fromChatId, message.getMessageId(), LIBRARY_OBJECT);
    }

    public <T> T forwardMessage(T chatId, T fromChatId, Message message, ReturnFormat format) throws IOException {
        return forwardMessage(chatId, fromChatId, message.getMessageId(), format);
    }

    public <T> Message forwardMessage(T chatId, T fromChatId, long messageId) throws IOException {
        return (Message) forwardMessage(chatId, fromChatId, messageId, LIBRARY_OBJECT);
    }

    public <T> T forwardMessage(T chatId, T fromChatId, long messageId, ReturnFormat format) throws IOException {
        return forwardMessage(chatId, fromChatId, messageId, null, format);
    }

    public <T> Message forwardMessage(T chatId, T fromChatId, Message message, Params parameters) throws IOException {
        return (Message) forwardMessage(chatId, fromChatId, message.getMessageId(), parameters, LIBRARY_OBJECT);
    }

    public <T> T forwardMessage(T chatId, T fromChatId, Message message, Params parameters,
                                ReturnFormat format) throws IOException {
        return forwardMessage(chatId, fromChatId, message.getMessageId(), parameters, format);
    }

    public <T> Message forwardMessage(T chatId, T fromChatId, long messageId, Params parameters) throws IOException {
        return (Message) forwardMessage(chatId, fromChatId, messageId, parameters, LIBRARY_OBJECT);
    }

    public <T> T forwardMessage(T chatId, T fromChatId, long messageId, Params parameters,
                                ReturnFormat format) throws IOException {
        return returnMessage(sendPostRequest(FORWARD_MESSAGE_ENDPOINT, createMessagePayload(chatId, fromChatId, messageId,
                parameters)), format);
    }

    public <T> MessageId copyMessage(T chatId, T fromChatId, Message message) throws IOException {
        return (MessageId) copyMessage(chatId, fromChatId, message.getMessageId(), LIBRARY_OBJECT);
    }

    public <T> T copyMessage(T chatId, T fromChatId, Message message, ReturnFormat format) throws IOException {
        return copyMessage(chatId, fromChatId, message.getMessageId(), format);
    }

    public <T> MessageId copyMessage(T chatId, T fromChatId, long messageId) throws IOException {
        return (MessageId) copyMessage(chatId, fromChatId, messageId, LIBRARY_OBJECT);
    }

    public <T> T copyMessage(T chatId, T fromChatId, long messageId, ReturnFormat format) throws IOException {
        return copyMessage(chatId, fromChatId, messageId, null, format);
    }

    public <T> MessageId copyMessage(T chatId, T fromChatId, Message message, Params parameters) throws IOException {
        return (MessageId) copyMessage(chatId, fromChatId, message.getMessageId(), parameters, LIBRARY_OBJECT);
    }

    public <T> T copyMessage(T chatId, T fromChatId, Message message, Params parameters,
                             ReturnFormat format) throws IOException {
        return copyMessage(chatId, fromChatId, message.getMessageId(), parameters, format);
    }

    public <T> MessageId copyMessage(T chatId, T fromChatId, long messageId, Params parameters) throws IOException {
        return (MessageId) copyMessage(chatId, fromChatId, messageId, parameters, LIBRARY_OBJECT);
    }

    public <T> T copyMessage(T chatId, T fromChatId, long messageId, Params parameters,
                             ReturnFormat format) throws IOException {
        return returnMessageId(sendPostRequest(FORWARD_MESSAGE_ENDPOINT, createMessagePayload(chatId, fromChatId,
                messageId, parameters)), format);
    }

    private <T> Params createMessagePayload(T chatId, T fromChatId, long messageId, Params parameters) {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("chat_id", getChatId(chatId));
        parameters.addParam("from_chat_id", getChatId(fromChatId));
        parameters.addParam("message_id", messageId);
        return parameters;
    }

    public <T> Message sendPhoto(T chatId, String photo) throws IOException {
        return (Message) sendPhoto(chatId, photo, LIBRARY_OBJECT);
    }

    public <T> T sendPhoto(T chatId, String photo, ReturnFormat format) throws IOException {
        return sendPhoto(chatId, photo, null, format);
    }

    public <T> Message sendPhoto(T chatId, String photo, Params parameters) throws IOException {
        return (Message) sendPhoto(chatId, photo, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendPhoto(T chatId, String photo, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_PHOTO_ENDPOINT, chatId, InputMediaType.photo, photo, parameters),
                format);
    }

    public <T> Message sendAudio(T chatId, String audio) throws IOException {
        return (Message) sendAudio(chatId, audio, LIBRARY_OBJECT);
    }

    public <T> T sendAudio(T chatId, String audio, ReturnFormat format) throws IOException {
        return sendAudio(chatId, audio, null, format);
    }

    public <T> Message sendAudio(T chatId, String audio, Params parameters) throws IOException {
        return (Message) sendAudio(chatId, audio, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendAudio(T chatId, String audio, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_AUDIO_ENDPOINT, chatId, InputMediaType.audio, audio, parameters),
                format);
    }

    public <T> Message sendDocument(T chatId, String document) throws IOException {
        return (Message) sendDocument(chatId, document, LIBRARY_OBJECT);
    }

    public <T> T sendDocument(T chatId, String document, ReturnFormat format) throws IOException {
        return sendDocument(chatId, document, null, format);
    }

    public <T> Message sendDocument(T chatId, String document, Params parameters) throws IOException {
        return (Message) sendDocument(chatId, document, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendDocument(T chatId, String document, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_DOCUMENT_ENDPOINT, chatId, InputMediaType.document, document,
                parameters), format);
    }

    public <T> Message sendVideo(T chatId, String video) throws IOException {
        return (Message) sendVideo(chatId, video, LIBRARY_OBJECT);
    }

    public <T> T sendVideo(T chatId, String video, ReturnFormat format) throws IOException {
        return sendVideo(chatId, video, null, format);
    }

    public <T> Message sendVideo(T chatId, String video, Params parameters) throws IOException {
        return (Message) sendVideo(chatId, video, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendVideo(T chatId, String video, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_VIDEO_ENDPOINT, chatId, InputMediaType.video, video,
                parameters), format);
    }

    public <T> Message sendAnimation(T chatId, String animation) throws IOException {
        return (Message) sendAnimation(chatId, animation, LIBRARY_OBJECT);
    }

    public <T> T sendAnimation(T chatId, String animation, ReturnFormat format) throws IOException {
        return sendAnimation(chatId, animation, null, format);
    }

    public <T> Message sendAnimation(T chatId, String animation, Params parameters) throws IOException {
        return (Message) sendAnimation(chatId, animation, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendAnimation(T chatId, String animation, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_ANIMATION_ENDPOINT, chatId, InputMediaType.animation, animation,
                parameters), format);
    }

    public <T> Message sendVoice(T chatId, String voice) throws IOException {
        return (Message) sendVoice(chatId, voice, LIBRARY_OBJECT);
    }

    public <T> T sendVoice(T chatId, String voice, ReturnFormat format) throws IOException {
        return sendVoice(chatId, voice, null, format);
    }

    public <T> Message sendVoice(T chatId, String voice, Params parameters) throws IOException {
        return (Message) sendVoice(chatId, voice, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendVoice(T chatId, String voice, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_VOICE_ENDPOINT, chatId, "voice", voice,
                parameters), format);
    }

    public <T> Message sendVideoNote(T chatId, String videoNote) throws IOException {
        return (Message) sendVideoNote(chatId, videoNote, LIBRARY_OBJECT);
    }

    public <T> T sendVideoNote(T chatId, String videoNote, ReturnFormat format) throws IOException {
        return sendVideoNote(chatId, videoNote, null, format);
    }

    public <T> Message sendVideoNote(T chatId, String videoNote, Params parameters) throws IOException {
        return (Message) sendVideoNote(chatId, videoNote, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendVideoNote(T chatId, String videoNote, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_VIDEO_NOTE_ENDPOINT, chatId, "video_note", videoNote,
                parameters), format);
    }

    private <T> String uploadMedia(String methodName, T chatId, T mediaType, String mediaValue,
                                   Params payload) throws IOException {
        if (payload == null)
            payload = new Params();
        payload.addParam(mediaType.toString(), mediaValue);
        payload.addParam("chat_id", getChatId(chatId));
        apiRequest.sendAPIRequest(BASE_BOT_ENDPOINT + token + "/" + methodName + payload.createQueryString(),
                POST, "Content-Type", "multipart/form-data");
        return apiRequest.getResponse();
    }

    private <T> T getChatId(T chatId) {
        if (chatId instanceof Chat)
            return (T) ("" + ((Chat) chatId).getId());
        return chatId;
    }

}
