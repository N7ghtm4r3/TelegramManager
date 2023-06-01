package com.tecknobit.telegrammanager.botapi.managers;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.records.basetypes.ForceReply;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat.ChatActionValue;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.Poll.PollType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia.InputMediaType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardRemove;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.Audio;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.TelegramDocument;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageId;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramBotManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message.returnMessage;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message.returnMessages;
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
     */
    public static final String SEND_MESSAGE_ENDPOINT = "sendMessage";

    /**
     * {@code FORWARD_MESSAGE_ENDPOINT} is constant for FORWARD_MESSAGE_ENDPOINT's endpoint
     */
    public static final String FORWARD_MESSAGE_ENDPOINT = "forwardMessage";

    /**
     * {@code COPY_MESSAGE_ENDPOINT} is constant for COPY_MESSAGE_ENDPOINT's endpoint
     */
    public static final String COPY_MESSAGE_ENDPOINT = "copyMessage";

    /**
     * {@code SEND_PHOTO_ENDPOINT} is constant for SEND_PHOTO_ENDPOINT's endpoint
     */
    public static final String SEND_PHOTO_ENDPOINT = "sendPhoto";

    /**
     * {@code SEND_AUDIO_ENDPOINT} is constant for SEND_AUDIO_ENDPOINT's endpoint
     */
    public static final String SEND_AUDIO_ENDPOINT = "sendAudio";

    /**
     * {@code SEND_DOCUMENT_ENDPOINT} is constant for SEND_DOCUMENT_ENDPOINT's endpoint
     */
    public static final String SEND_DOCUMENT_ENDPOINT = "sendDocument";

    /**
     * {@code SEND_VIDEO_ENDPOINT} is constant for SEND_VIDEO_ENDPOINT's endpoint
     */
    public static final String SEND_VIDEO_ENDPOINT = "sendVideo";

    /**
     * {@code SEND_ANIMATION_ENDPOINT} is constant for SEND_ANIMATION_ENDPOINT's endpoint
     */
    public static final String SEND_ANIMATION_ENDPOINT = "sendAnimation";

    /**
     * {@code SEND_VOICE_ENDPOINT} is constant for SEND_VOICE_ENDPOINT's endpoint
     */
    public static final String SEND_VOICE_ENDPOINT = "sendVoice";

    /**
     * {@code SEND_VIDEO_NOTE_ENDPOINT} is constant for SEND_VIDEO_NOTE_ENDPOINT's endpoint
     */
    public static final String SEND_VIDEO_NOTE_ENDPOINT = "sendVideoNote";

    /**
     * {@code SEND_MEDIA_GROUP_ENDPOINT} is constant for SEND_MEDIA_GROUP_ENDPOINT's endpoint
     */
    public static final String SEND_MEDIA_GROUP_ENDPOINT = "sendMediaGroup";

    /**
     * {@code SEND_LOCATION_ENDPOINT} is constant for SEND_LOCATION_ENDPOINT's endpoint
     */
    public static final String SEND_LOCATION_ENDPOINT = "sendLocation";

    /**
     * {@code SEND_VENUE_ENDPOINT} is constant for SEND_VENUE_ENDPOINT's endpoint
     */
    public static final String SEND_VENUE_ENDPOINT = "sendVenue";

    /**
     * {@code SEND_CONTACT_ENDPOINT} is constant for SEND_CONTACT_ENDPOINT's endpoint
     */
    public static final String SEND_CONTACT_ENDPOINT = "sendContact";

    /**
     * {@code SEND_POLL_ENDPOINT} is constant for SEND_POLL_ENDPOINT's endpoint
     */
    public static final String SEND_POLL_ENDPOINT = "sendPoll";

    /**
     * {@code SEND_DICE_ENDPOINT} is constant for SEND_DICE_ENDPOINT's endpoint
     */
    public static final String SEND_DICE_ENDPOINT = "sendDice";

    /**
     * {@code SEND_CHAT_ACTION_ENDPOINT} is constant for SEND_CHAT_ACTION_ENDPOINT's endpoint
     */
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

    /**
     * Request to send text messages
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param text:   text of the message to be sent, 1-4096 characters after entities parsing
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendmessage">
     * sendMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendMessage")
    public <T> Message sendMessage(T chatId, String text) throws IOException {
        return (Message) sendMessage(chatId, text, LIBRARY_OBJECT);
    }

    /**
     * Request to send text messages
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param text:   text of the message to be sent, 1-4096 characters after entities parsing
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendmessage">
     * sendMessage</a>
     */
    @RequestPath(method = POST, path = "sendMessage")
    public <T> T sendMessage(T chatId, String text, ReturnFormat format) throws IOException {
        return sendMessage(chatId, text, null, LIBRARY_OBJECT);
    }

    /**
     * Request to send text messages
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param text:       text of the message to be sent, 1-4096 characters after entities parsing
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "disable_web_page_preview"} -> disables link previews for links in this
     *                               message - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendmessage">
     * sendMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendMessage")
    public <T> Message sendMessage(T chatId, String text, Params parameters) throws IOException {
        return (Message) sendMessage(chatId, text, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send text messages
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param text:       text of the message to be sent, 1-4096 characters after entities parsing
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "disable_web_page_preview"} -> disables link previews for links in this
     *                               message - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendmessage">
     * sendMessage</a>
     */
    @RequestPath(method = POST, path = "sendMessage")
    public <T> T sendMessage(T chatId, String text, Params parameters, ReturnFormat format) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("chat_id", getChatId(chatId));
        parameters.addParam("text", text);
        return returnMessage(sendPostRequest(SEND_MESSAGE_ENDPOINT, parameters), format);
    }

    /**
     * Request to forward messages of any kind. Service messages can't be forwarded
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param message:    the message to forward
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forwardMessage">
     * forwardMessage</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "forwardMessage")
    public <T> Message forwardMessage(T chatId, T fromChatId, Message message) throws IOException {
        return (Message) forwardMessage(chatId, fromChatId, message.getMessageId(), LIBRARY_OBJECT);
    }

    /**
     * Request to forward messages of any kind. Service messages can't be forwarded
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param message:    the message to forward
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forwardMessage">
     * forwardMessage</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "forwardMessage")
    public <T> T forwardMessage(T chatId, T fromChatId, Message message, ReturnFormat format) throws IOException {
        return forwardMessage(chatId, fromChatId, message.getMessageId(), format);
    }

    /**
     * Request to forward messages of any kind. Service messages can't be forwarded
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param messageId:  message identifier in the chat specified in fromChatId
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forwardMessage">
     * forwardMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "forwardMessage")
    public <T> Message forwardMessage(T chatId, T fromChatId, long messageId) throws IOException {
        return (Message) forwardMessage(chatId, fromChatId, messageId, LIBRARY_OBJECT);
    }

    /**
     * Request to forward messages of any kind. Service messages can't be forwarded
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param messageId:  message identifier in the chat specified in fromChatId
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forwardMessage">
     * forwardMessage</a>
     */
    @RequestPath(method = POST, path = "forwardMessage")
    public <T> T forwardMessage(T chatId, T fromChatId, long messageId, ReturnFormat format) throws IOException {
        return forwardMessage(chatId, fromChatId, messageId, null, format);
    }

    /**
     * Request to forward messages of any kind. Service messages can't be forwarded
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param message:    the message to forward
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forwardMessage">
     * forwardMessage</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "forwardMessage")
    public <T> Message forwardMessage(T chatId, T fromChatId, Message message, Params parameters) throws IOException {
        return (Message) forwardMessage(chatId, fromChatId, message.getMessageId(), parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to forward messages of any kind. Service messages can't be forwarded
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param message:    the message to forward
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forwardMessage">
     * forwardMessage</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "forwardMessage")
    public <T> T forwardMessage(T chatId, T fromChatId, Message message, Params parameters,
                                ReturnFormat format) throws IOException {
        return forwardMessage(chatId, fromChatId, message.getMessageId(), parameters, format);
    }

    /**
     * Request to forward messages of any kind. Service messages can't be forwarded
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param messageId:  message identifier in the chat specified in fromChatId
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forwardMessage">
     * forwardMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "forwardMessage")
    public <T> Message forwardMessage(T chatId, T fromChatId, long messageId, Params parameters) throws IOException {
        return (Message) forwardMessage(chatId, fromChatId, messageId, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to forward messages of any kind. Service messages can't be forwarded
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param messageId:  message identifier in the chat specified in fromChatId
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forwardMessage">
     * forwardMessage</a>
     */
    @RequestPath(method = POST, path = "forwardMessage")
    public <T> T forwardMessage(T chatId, T fromChatId, long messageId, Params parameters,
                                ReturnFormat format) throws IOException {
        return returnMessage(sendPostRequest(FORWARD_MESSAGE_ENDPOINT, createMessagePayload(chatId, fromChatId, messageId,
                parameters)), format);
    }

    /**
     * Request to copy messages of any kind. Service messages and invoice messages can't be copied. A quiz poll can be
     * copied only if the value of the field correct_option_id is known to the bot. The method is analogous to
     * the method forwardMessage, but the copied message doesn't have a link to the original message
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param message:    the message to copy
     * @return message identifier as {@link MessageId} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#copyMessage">
     * copyMessage</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "copyMessage")
    public <T> MessageId copyMessage(T chatId, T fromChatId, Message message) throws IOException {
        return (MessageId) copyMessage(chatId, fromChatId, message.getMessageId(), LIBRARY_OBJECT);
    }

    /**
     * Request to copy messages of any kind. Service messages and invoice messages can't be copied. A quiz poll can be
     * copied only if the value of the field correct_option_id is known to the bot. The method is analogous to
     * the method forwardMessage, but the copied message doesn't have a link to the original message
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param message:    the message to copy
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message id as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#copyMessage">
     * copyMessage</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "copyMessage")
    public <T> T copyMessage(T chatId, T fromChatId, Message message, ReturnFormat format) throws IOException {
        return copyMessage(chatId, fromChatId, message.getMessageId(), format);
    }

    /**
     * Request to copy messages of any kind. Service messages and invoice messages can't be copied. A quiz poll can be
     * copied only if the value of the field correct_option_id is known to the bot. The method is analogous to
     * the method forwardMessage, but the copied message doesn't have a link to the original message
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param messageId:  message identifier in the chat specified in fromChatId
     * @return message identifier as {@link MessageId} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#copyMessage">
     * copyMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "copyMessage")
    public <T> MessageId copyMessage(T chatId, T fromChatId, long messageId) throws IOException {
        return (MessageId) copyMessage(chatId, fromChatId, messageId, LIBRARY_OBJECT);
    }

    /**
     * Request to copy messages of any kind. Service messages and invoice messages can't be copied. A quiz poll can be
     * copied only if the value of the field correct_option_id is known to the bot. The method is analogous to
     * the method forwardMessage, but the copied message doesn't have a link to the original message
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param messageId:  message identifier in the chat specified in fromChatId
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message id as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#copyMessage">
     * copyMessage</a>
     */
    @RequestPath(method = POST, path = "copyMessage")
    public <T> T copyMessage(T chatId, T fromChatId, long messageId, ReturnFormat format) throws IOException {
        return copyMessage(chatId, fromChatId, messageId, null, format);
    }

    /**
     * Request to copy messages of any kind. Service messages and invoice messages can't be copied. A quiz poll can be
     * copied only if the value of the field correct_option_id is known to the bot. The method is analogous to
     * the method forwardMessage, but the copied message doesn't have a link to the original message
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param message:    the message to copy
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message identifier as {@link MessageId} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#copyMessage">
     * copyMessage</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "copyMessage")
    public <T> MessageId copyMessage(T chatId, T fromChatId, Message message, Params parameters) throws IOException {
        return (MessageId) copyMessage(chatId, fromChatId, message.getMessageId(), parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to copy messages of any kind. Service messages and invoice messages can't be copied. A quiz poll can be
     * copied only if the value of the field correct_option_id is known to the bot. The method is analogous to
     * the method forwardMessage, but the copied message doesn't have a link to the original message
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param message:    the message to copy
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message id as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#copyMessage">
     * copyMessage</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "copyMessage")
    public <T> T copyMessage(T chatId, T fromChatId, Message message, Params parameters,
                             ReturnFormat format) throws IOException {
        return copyMessage(chatId, fromChatId, message.getMessageId(), parameters, format);
    }

    /**
     * Request to copy messages of any kind. Service messages and invoice messages can't be copied. A quiz poll can be
     * copied only if the value of the field correct_option_id is known to the bot. The method is analogous to
     * the method forwardMessage, but the copied message doesn't have a link to the original message
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param messageId:  message identifier in the chat specified in fromChatId
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message identifier as {@link MessageId} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#copyMessage">
     * copyMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "copyMessage")
    public <T> MessageId copyMessage(T chatId, T fromChatId, long messageId, Params parameters) throws IOException {
        return (MessageId) copyMessage(chatId, fromChatId, messageId, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to copy messages of any kind. Service messages and invoice messages can't be copied. A quiz poll can be
     * copied only if the value of the field correct_option_id is known to the bot. The method is analogous to
     * the method forwardMessage, but the copied message doesn't have a link to the original message
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param messageId:  message identifier in the chat specified in fromChatId
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message id as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#copyMessage">
     * copyMessage</a>
     */
    @RequestPath(method = POST, path = "copyMessage")
    public <T> T copyMessage(T chatId, T fromChatId, long messageId, Params parameters,
                             ReturnFormat format) throws IOException {
        return returnMessageId(sendPostRequest(COPY_MESSAGE_ENDPOINT, createMessagePayload(chatId, fromChatId,
                messageId, parameters)), format);
    }

    /**
     * Method to create a message payload
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param fromChatId: unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @param messageId:  message identifier in the chat specified in fromChatId
     * @param parameters: other request parameters
     * @return payload as {@link Params}
     */
    private <T> Params createMessagePayload(T chatId, T fromChatId, long messageId, Params parameters) {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("chat_id", getChatId(chatId));
        parameters.addParam("from_chat_id", getChatId(fromChatId));
        parameters.addParam("message_id", messageId);
        return parameters;
    }

    /**
     * Request to send photos
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param photo:  photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers
     *                (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet,
     *                or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size.
     *                The photo's width and height must not exceed 10000 in total. Width and height ratio must be
     *                at most 20. <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendPhoto">
     * sendPhoto</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendPhoto")
    public <T> Message sendPhoto(T chatId, String photo) throws IOException {
        return (Message) sendPhoto(chatId, photo, LIBRARY_OBJECT);
    }

    /**
     * Request to send photos
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param photo:  photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers
     *                (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet,
     *                or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size.
     *                The photo's width and height must not exceed 10000 in total. Width and height ratio must be
     *                at most 20. <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendPhoto">
     * sendPhoto</a>
     */
    @RequestPath(method = POST, path = "sendPhoto")
    public <T> T sendPhoto(T chatId, String photo, ReturnFormat format) throws IOException {
        return sendPhoto(chatId, photo, null, format);
    }

    /**
     * Request to send photos
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param photo:      photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet,
     *                    or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size.
     *                    The photo's width and height must not exceed 10000 in total. Width and height ratio must be
     *                    at most 20. <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "has_spoiler"} -> if the photo needs to be covered with a spoiler animation
     *                               - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendPhoto">
     * sendPhoto</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendPhoto")
    public <T> Message sendPhoto(T chatId, String photo, Params parameters) throws IOException {
        return (Message) sendPhoto(chatId, photo, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send photos
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param photo:      photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet,
     *                    or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size.
     *                    The photo's width and height must not exceed 10000 in total. Width and height ratio must be
     *                    at most 20. <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "has_spoiler"} -> if the photo needs to be covered with a spoiler animation
     *                               - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendPhoto">
     * sendPhoto</a>
     */
    @RequestPath(method = POST, path = "sendPhoto")
    public <T> T sendPhoto(T chatId, String photo, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_PHOTO_ENDPOINT, chatId, InputMediaType.photo, photo, parameters),
                format);
    }

    /**
     * Request to send audio files, if you want Telegram clients to display them in the music player. Your audio must be
     * in the .MP3 or .M4A format
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param audio:  audio to send. Pass a file_id as String to send a photo that exists on the Telegram servers
     *                (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet,
     *                or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size.
     *                The photo's width and height must not exceed 10000 in total. Width and height ratio must be
     *                at most 20. <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendAudio">
     * sendAudio</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendAudio")
    public <T> Message sendAudio(T chatId, String audio) throws IOException {
        return (Message) sendAudio(chatId, audio, LIBRARY_OBJECT);
    }

    /**
     * Request to send audio files, if you want Telegram clients to display them in the music player. Your audio must be
     * in the .MP3 or .M4A format
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param audio:  audio to send. Pass a file_id as String to send a photo that exists on the Telegram servers
     *                (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet,
     *                or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size.
     *                The photo's width and height must not exceed 10000 in total. Width and height ratio must be
     *                at most 20. <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendAudio">
     * sendAudio</a>
     */
    @RequestPath(method = POST, path = "sendAudio")
    public <T> T sendAudio(T chatId, String audio, ReturnFormat format) throws IOException {
        return sendAudio(chatId, audio, null, format);
    }

    /**
     * Request to send audio files, if you want Telegram clients to display them in the music player. Your audio must be
     * in the .MP3 or .M4A format
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param audio:      audio to send. Pass a file_id as String to send a photo that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet,
     *                    or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size.
     *                    The photo's width and height must not exceed 10000 in total. Width and height ratio must be
     *                    at most 20. <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "duration"} -> duration of the audio in seconds - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "performer"} -> performer - [String]
     *                          </li>
     *                          <li>
     *                               {@code "title"} -> track name - [String]
     *                          </li>
     *                          <li>
     *                               {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                               generation for the file is supported server-side. The thumbnail should be in JPEG
     *                               format and less than 200 kB in size. A thumbnail's width and height should not
     *                               exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                               Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                               can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                               multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendAudio">
     * sendAudio</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendAudio")
    public <T> Message sendAudio(T chatId, String audio, Params parameters) throws IOException {
        return (Message) sendAudio(chatId, audio, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send audio files, if you want Telegram clients to display them in the music player. Your audio must be
     * in the .MP3 or .M4A format
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param audio:      audio to send. Pass a file_id as String to send a photo that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet,
     *                    or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size.
     *                    The photo's width and height must not exceed 10000 in total. Width and height ratio must be
     *                    at most 20. <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "duration"} -> duration of the audio in seconds - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "performer"} -> performer - [String]
     *                          </li>
     *                          <li>
     *                               {@code "title"} -> track name - [String]
     *                          </li>
     *                          <li>
     *                               {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                               generation for the file is supported server-side. The thumbnail should be in JPEG
     *                               format and less than 200 kB in size. A thumbnail's width and height should not
     *                               exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                               Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                               can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                               multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendAudio">
     * sendAudio</a>
     */
    @RequestPath(method = POST, path = "sendAudio")
    public <T> T sendAudio(T chatId, String audio, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_AUDIO_ENDPOINT, chatId, InputMediaType.audio, audio, parameters),
                format);
    }

    /**
     * Request to send general files. <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:   unique identifier for the target chat or username of the target channel
     * @param document: file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended),
     *                  pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                  using multipart/form-data.
     *                  <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendDocument">
     * sendDocument</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendDocument")
    public <T> Message sendDocument(T chatId, String document) throws IOException {
        return (Message) sendDocument(chatId, document, LIBRARY_OBJECT);
    }

    /**
     * Request to send general files. <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:   unique identifier for the target chat or username of the target channel
     * @param document: file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended),
     *                  pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                  using multipart/form-data.
     *                  <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param format    :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendDocument">
     * sendDocument</a>
     */
    @RequestPath(method = POST, path = "sendDocument")
    public <T> T sendDocument(T chatId, String document, ReturnFormat format) throws IOException {
        return sendDocument(chatId, document, null, format);
    }

    /**
     * Request to send general files. <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param document:   file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended),
     *                    pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                    using multipart/form-data.
     *                    <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                               generation for the file is supported server-side. The thumbnail should be in JPEG
     *                               format and less than 200 kB in size. A thumbnail's width and height should not
     *                               exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                               Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                               can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                               multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_content_type_detection"} -> disables automatic server-side content
     *                               type detection for files uploaded using multipart/form-data - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendDocument">
     * sendDocument</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendDocument")
    public <T> Message sendDocument(T chatId, String document, Params parameters) throws IOException {
        return (Message) sendDocument(chatId, document, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send general files. <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param document:   file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended),
     *                    pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                    using multipart/form-data.
     *                    <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                               generation for the file is supported server-side. The thumbnail should be in JPEG
     *                               format and less than 200 kB in size. A thumbnail's width and height should not
     *                               exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                               Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                               can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                               multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_content_type_detection"} -> disables automatic server-side content
     *                               type detection for files uploaded using multipart/form-data - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendDocument">
     * sendDocument</a>
     */
    @RequestPath(method = POST, path = "sendDocument")
    public <T> T sendDocument(T chatId, String document, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_DOCUMENT_ENDPOINT, chatId, InputMediaType.document, document,
                parameters), format);
    }

    /**
     * Request to send video files, Telegram clients support MPEG4 videos (other formats may be sent as Document) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param video:  video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended),
     *                pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                using multipart/form-data.
     *                <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVideo">
     * sendVideo</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendVideo")
    public <T> Message sendVideo(T chatId, String video) throws IOException {
        return (Message) sendVideo(chatId, video, LIBRARY_OBJECT);
    }

    /**
     * Request to send video files, Telegram clients support MPEG4 videos (other formats may be sent as Document) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param video:  video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended),
     *                pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                using multipart/form-data.
     *                <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVideo">
     * sendVideo</a>
     */
    @RequestPath(method = POST, path = "sendVideo")
    public <T> T sendVideo(T chatId, String video, ReturnFormat format) throws IOException {
        return sendVideo(chatId, video, null, format);
    }

    /**
     * Request to send video files, Telegram clients support MPEG4 videos (other formats may be sent as Document) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param video:      video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended),
     *                    pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                    using multipart/form-data.
     *                    <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "has_spoiler"} -> if the video needs to be covered with a spoiler animation
     *                               - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "supports_streaming"} -> if the uploaded video is suitable for streaming
     *                               - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "duration"} -> duration of the video in seconds - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "width"} -> video width - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "height"} -> video height - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                               generation for the file is supported server-side. The thumbnail should be in JPEG
     *                               format and less than 200 kB in size. A thumbnail's width and height should not
     *                               exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                               Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                               can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                               multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_content_type_detection"} -> disables automatic server-side content
     *                               type detection for files uploaded using multipart/form-data - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVideo">
     * sendVideo</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendVideo")
    public <T> Message sendVideo(T chatId, String video, Params parameters) throws IOException {
        return (Message) sendVideo(chatId, video, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send video files, Telegram clients support MPEG4 videos (other formats may be sent as Document) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param video:      video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended),
     *                    pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                    using multipart/form-data.
     *                    <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "has_spoiler"} -> if the video needs to be covered with a spoiler animation
     *                               - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "supports_streaming"} -> if the uploaded video is suitable for streaming
     *                               - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "duration"} -> duration of the video in seconds - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "width"} -> video width - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "height"} -> video height - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                               generation for the file is supported server-side. The thumbnail should be in JPEG
     *                               format and less than 200 kB in size. A thumbnail's width and height should not
     *                               exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                               Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                               can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                               multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_content_type_detection"} -> disables automatic server-side content
     *                               type detection for files uploaded using multipart/form-data - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVideo">
     * sendVideo</a>
     */
    @RequestPath(method = POST, path = "sendVideo")
    public <T> T sendVideo(T chatId, String video, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_VIDEO_ENDPOINT, chatId, InputMediaType.video, video,
                parameters), format);
    }

    /**
     * Request to send animation files (GIF or H.264/MPEG-4 AVC video without sound) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param animation: animation to send. Pass a file_id as String to send an animation that exists on the Telegram
     *                   servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet,
     *                   or upload a new one using multipart/form-data.
     *                   <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendAnimation">
     * sendAnimation</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendAnimation")
    public <T> Message sendAnimation(T chatId, String animation) throws IOException {
        return (Message) sendAnimation(chatId, animation, LIBRARY_OBJECT);
    }

    /**
     * Request to send animation files (GIF or H.264/MPEG-4 AVC video without sound) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param animation: animation to send. Pass a file_id as String to send an animation that exists on the Telegram
     *                   servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet,
     *                   or upload a new one using multipart/form-data.
     *                   <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param format     :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendAnimation">
     * sendAnimation</a>
     */
    @RequestPath(method = POST, path = "sendAnimation")
    public <T> T sendAnimation(T chatId, String animation, ReturnFormat format) throws IOException {
        return sendAnimation(chatId, animation, null, format);
    }

    /**
     * Request to send animation files (GIF or H.264/MPEG-4 AVC video without sound) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param animation:  animation to send. Pass a file_id as String to send an animation that exists on the Telegram
     *                    servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet,
     *                    or upload a new one using multipart/form-data.
     *                    <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "has_spoiler"} -> if the animation needs to be covered with a spoiler animation
     *                               - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "duration"} -> duration of the animation in seconds - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "width"} -> animation width - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "height"} -> animation height - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                               generation for the file is supported server-side. The thumbnail should be in JPEG
     *                               format and less than 200 kB in size. A thumbnail's width and height should not
     *                               exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                               Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                               can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                               multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendAnimation">
     * sendAnimation</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendAnimation")
    public <T> Message sendAnimation(T chatId, String animation, Params parameters) throws IOException {
        return (Message) sendAnimation(chatId, animation, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send animation files (GIF or H.264/MPEG-4 AVC video without sound) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param animation:  animation to send. Pass a file_id as String to send an animation that exists on the Telegram
     *                    servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet,
     *                    or upload a new one using multipart/form-data.
     *                    <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "has_spoiler"} -> if the animation needs to be covered with a spoiler animation
     *                               - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "duration"} -> duration of the animation in seconds - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "width"} -> animation width - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "height"} -> animation height - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                               generation for the file is supported server-side. The thumbnail should be in JPEG
     *                               format and less than 200 kB in size. A thumbnail's width and height should not
     *                               exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                               Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                               can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                               multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendAnimation">
     * sendAnimation</a>
     */
    @RequestPath(method = POST, path = "sendAnimation")
    public <T> T sendAnimation(T chatId, String animation, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_ANIMATION_ENDPOINT, chatId, InputMediaType.animation, animation,
                parameters), format);
    }

    /**
     * Request to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as {@link Audio}
     * or {@link TelegramDocument}) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param voice:  audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload
     *                a new one using multipart/form-data.
     *                <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVoice">
     * sendVoice</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendVoice")
    public <T> Message sendVoice(T chatId, String voice) throws IOException {
        return (Message) sendVoice(chatId, voice, LIBRARY_OBJECT);
    }

    /**
     * Request to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as {@link Audio}
     * or {@link TelegramDocument}) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param voice:  audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload
     *                a new one using multipart/form-data.
     *                <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVoice">
     * sendVoice</a>
     */
    @RequestPath(method = POST, path = "sendVoice")
    public <T> T sendVoice(T chatId, String voice, ReturnFormat format) throws IOException {
        return sendVoice(chatId, voice, null, format);
    }

    /**
     * Request to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as {@link Audio}
     * or {@link TelegramDocument}) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param voice:      audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload
     *                    a new one using multipart/form-data.
     *                    <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "duration"} -> duration of the voice message in seconds - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVoice">
     * sendVoice</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendVoice")
    public <T> Message sendVoice(T chatId, String voice, Params parameters) throws IOException {
        return (Message) sendVoice(chatId, voice, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as {@link Audio}
     * or {@link TelegramDocument}) <br>
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param voice:      audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload
     *                    a new one using multipart/form-data.
     *                    <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "caption_entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                               If not specified, the original caption is kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                               See formatting options for more details - [String]
     *                          </li>
     *                          <li>
     *                               {@code "duration"} -> duration of the voice message in seconds - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVoice">
     * sendVoice</a>
     */
    @RequestPath(method = POST, path = "sendVoice")
    public <T> T sendVoice(T chatId, String voice, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_VOICE_ENDPOINT, chatId, "voice", voice,
                parameters), format);
    }

    /**
     * Request to send video messages
     *
     * @param chatId:         unique identifier for the target chat or username of the target channel
     * @param videoNote:video note to send. Pass a file_id as String to send a video note that exists on the Telegram
     *                        servers (recommended) or upload a new video using multipart/form-data.
     *                        <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVideoNote">
     * sendVideoNote</a>
     * @implNote sending video notes by a URL is currently unsupported
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendVideoNote")
    public <T> Message sendVideoNote(T chatId, String videoNote) throws IOException {
        return (Message) sendVideoNote(chatId, videoNote, LIBRARY_OBJECT);
    }

    /**
     * Request to send video messages
     *
     * @param chatId:         unique identifier for the target chat or username of the target channel
     * @param videoNote:video note to send. Pass a file_id as String to send a video note that exists on the Telegram
     *                        servers (recommended) or upload a new video using multipart/form-data.
     *                        <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param format          :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVideoNote">
     * sendVideoNote</a>
     * @implNote sending video notes by a URL is currently unsupported
     */
    @RequestPath(method = POST, path = "sendVideoNote")
    public <T> T sendVideoNote(T chatId, String videoNote, ReturnFormat format) throws IOException {
        return sendVideoNote(chatId, videoNote, null, format);
    }

    /**
     * Request to send video messages
     *
     * @param chatId:         unique identifier for the target chat or username of the target channel
     * @param videoNote:video note to send. Pass a file_id as String to send a video note that exists on the Telegram
     *                        servers (recommended) or upload a new video using multipart/form-data.
     *                        <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters:     additional params of the request, keys accepted are:
     *                        <ul>
     *                              <li>
     *                                   {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                   (topic) of the forum; for forum supergroups only - [Integer]
     *                              </li>
     *                              <li>
     *                                   {@code "caption_entities"} -> list of special entities that appear in message text,
     *                                   which can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                              </li>
     *                              <li>
     *                                   {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                                   If not specified, the original caption is kept - [String]
     *                              </li>
     *                              <li>
     *                                   {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                                   See formatting options for more details - [String]
     *                              </li>
     *                              <li>
     *                                   {@code "duration"} -> duration of sent video in seconds - [Integer]
     *                              </li>
     *                              <li>
     *                                   {@code "length"} -> video width and height, i.e. diameter of the video
     *                                   message - [Integer]
     *                              </li>
     *                              <li>
     *                                   {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                                   generation for the file is supported server-side. The thumbnail should be in JPEG
     *                                   format and less than 200 kB in size. A thumbnail's width and height should not
     *                                   exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                                   Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                                   can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                                   multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                              </li>
     *                              <li>
     *                                   {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                                   notification with no sound - [Boolean]
     *                              </li>
     *                              <li>
     *                                   {@code "protect_content"} -> protects the contents of the sent message from
     *                                   forwarding and saving - [Boolean]
     *                              </li>
     *                              <li>
     *                                   {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                                   message - [Integer]
     *                              </li>
     *                              <li>
     *                                   {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                                   specified replied-to message is not found - [Boolean]
     *                              </li>
     *                              <li>
     *                                   {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                                   {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                              </li>
     *                        </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVideoNote">
     * sendVideoNote</a>
     * @implNote sending video notes by a URL is currently unsupported
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendVideoNote")
    public <T> Message sendVideoNote(T chatId, String videoNote, Params parameters) throws IOException {
        return (Message) sendVideoNote(chatId, videoNote, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send video messages
     *
     * @param chatId:         unique identifier for the target chat or username of the target channel
     * @param videoNote:video note to send. Pass a file_id as String to send a video note that exists on the Telegram
     *                        servers (recommended) or upload a new video using multipart/form-data.
     *                        <a href="https://core.telegram.org/bots/api#sending-files">More information on Sending Files</a>
     * @param parameters:     additional params of the request, keys accepted are:
     *                        <ul>
     *                              <li>
     *                                   {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                   (topic) of the forum; for forum supergroups only - [Integer]
     *                              </li>
     *                              <li>
     *                                   {@code "caption_entities"} -> list of special entities that appear in message text,
     *                                   which can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                              </li>
     *                              <li>
     *                                   {@code "caption"} -> new caption for media, 0-1024 characters after entities parsing.
     *                                   If not specified, the original caption is kept - [String]
     *                              </li>
     *                              <li>
     *                                   {@code "parse_mode"} -> mode for parsing entities in the message text.
     *                                   See formatting options for more details - [String]
     *                              </li>
     *                              <li>
     *                                   {@code "duration"} -> duration of sent video in seconds - [Integer]
     *                              </li>
     *                              <li>
     *                                   {@code "length"} -> video width and height, i.e. diameter of the video
     *                                   message - [Integer]
     *                              </li>
     *                              <li>
     *                                   {@code "thumbnail"} -> thumbnail of the file sent; can be ignored if thumbnail
     *                                   generation for the file is supported server-side. The thumbnail should be in JPEG
     *                                   format and less than 200 kB in size. A thumbnail's width and height should not
     *                                   exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     *                                   Thumbnails can't be reused and can be only uploaded as a new file, so you
     *                                   can pass {@code "attach://<file_attach_name>"} if the thumbnail was uploaded using
     *                                   multipart/form-data under {@code "<file_attach_name>"} - [String]
     *                              </li>
     *                              <li>
     *                                   {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                                   notification with no sound - [Boolean]
     *                              </li>
     *                              <li>
     *                                   {@code "protect_content"} -> protects the contents of the sent message from
     *                                   forwarding and saving - [Boolean]
     *                              </li>
     *                              <li>
     *                                   {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                                   message - [Integer]
     *                              </li>
     *                              <li>
     *                                   {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                                   specified replied-to message is not found - [Boolean]
     *                              </li>
     *                              <li>
     *                                   {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                                   {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                              </li>
     *                        </ul>
     * @param format          :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVideoNote">
     * sendVideoNote</a>
     * @implNote sending video notes by a URL is currently unsupported
     */
    @RequestPath(method = POST, path = "sendVideoNote")
    public <T> T sendVideoNote(T chatId, String videoNote, Params parameters, ReturnFormat format) throws IOException {
        return returnMessage(uploadMedia(SEND_VIDEO_NOTE_ENDPOINT, chatId, "video_note", videoNote,
                parameters), format);
    }

    /**
     * Request to send a group of photos, videos, documents or audios as an album. Documents and audio files can be
     * only grouped in an album with messages of the same type
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param media:  group media to send
     * @return messages list as {@link ArrayList} of {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendMediaGroup">
     * sendMediaGroup</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendMediaGroup")
    public <T> ArrayList<Message> sendMediaGroup(T chatId, InputMedia... media) throws IOException {
        return (ArrayList<Message>) sendMediaGroup(chatId, LIBRARY_OBJECT, media);
    }

    /**
     * Request to send a group of photos, videos, documents or audios as an album. Documents and audio files can be
     * only grouped in an album with messages of the same type
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param media:  group media to send
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return messages list as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendMediaGroup">
     * sendMediaGroup</a>
     */
    @RequestPath(method = POST, path = "sendMediaGroup")
    public <T> T sendMediaGroup(T chatId, ReturnFormat format, InputMedia... media) throws IOException {
        return sendMediaGroup(chatId, null, format, media);
    }

    /**
     * Request to send a group of photos, videos, documents or audios as an album. Documents and audio files can be
     * only grouped in an album with messages of the same type
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                    </ul>
     * @param media:      group media to send
     * @return messages list as {@link ArrayList} of {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendMediaGroup">
     * sendMediaGroup</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendMediaGroup")
    public <T> ArrayList<Message> sendMediaGroup(T chatId, Params parameters, InputMedia... media) throws IOException {
        return (ArrayList<Message>) sendMediaGroup(chatId, parameters, LIBRARY_OBJECT, media);
    }

    /**
     * Request to send a group of photos, videos, documents or audios as an album. Documents and audio files can be
     * only grouped in an album with messages of the same type
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                    </ul>
     * @param media:      group media to send
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return messages list as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendMediaGroup">
     * sendMediaGroup</a>
     */
    @RequestPath(method = POST, path = "sendMediaGroup")
    public <T> T sendMediaGroup(T chatId, Params parameters, ReturnFormat format, InputMedia... media) throws IOException {
        return returnMessages(uploadMedia(SEND_MEDIA_GROUP_ENDPOINT, chatId, "media", new JSONArray(media),
                parameters), format);
    }

    /**
     * Method to execute and get response of an upload media request
     *
     * @param methodName: the method where make the request
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param mediaType:  type of the media to send
     * @param mediaValue: the media to send
     * @param payload:    payload of the request
     * @return response of request formatted in JSON as {@link String}
     */
    private <T> String uploadMedia(String methodName, T chatId, T mediaType, T mediaValue, Params payload) throws IOException {
        payload = createChatIdPayload(chatId, payload);
        payload.addParam(mediaType.toString(), mediaValue);
        apiRequest.sendAPIRequest(BASE_BOT_ENDPOINT + token + "/" + methodName + payload.createQueryString(),
                POST, "Content-Type", "multipart/form-data");
        return apiRequest.getResponse();
    }

    /**
     * Request to send point on the map
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param latitude:  latitude of the location
     * @param longitude: longitude of the location
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendLocation">
     * sendLocation</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendLocation")
    public <T> Message sendLocation(T chatId, double latitude, double longitude) throws IOException {
        return (Message) sendLocation(chatId, latitude, longitude, LIBRARY_OBJECT);
    }

    /**
     * Request to send point on the map
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param latitude:  latitude of the location
     * @param longitude: longitude of the location
     * @param format     :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendLocation">
     * sendLocation</a>
     */
    @RequestPath(method = POST, path = "sendLocation")
    public <T> T sendLocation(T chatId, double latitude, double longitude, ReturnFormat format) throws IOException {
        return sendLocation(chatId, latitude, longitude, null, format);
    }

    /**
     * Request to send point on the map
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param latitude:   latitude of the location
     * @param longitude:  longitude of the location
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "horizontal_accuracy"} -> the radius of uncertainty for the location,
     *                               measured in meters; 0-1500 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "live_period"} -> period in seconds for which the location will be updated
     *                               (see Live Locations, should be between 60 and 86400 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "heading"} -> for live locations, a direction in which the user is moving,
     *                               in degrees. Must be between 1 and 360 if specified - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "proximity_alert_radius"} -> for live locations, a maximum distance for
     *                               proximity alerts about approaching another chat member, in meters.
     *                               Must be between 1 and 100000 if specified - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendLocation">
     * sendLocation</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendLocation")
    public <T> Message sendLocation(T chatId, double latitude, double longitude, Params parameters) throws IOException {
        return (Message) sendLocation(chatId, latitude, longitude, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send point on the map
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param latitude:   latitude of the location
     * @param longitude:  longitude of the location
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "horizontal_accuracy"} -> the radius of uncertainty for the location,
     *                               measured in meters; 0-1500 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "live_period"} -> period in seconds for which the location will be updated
     *                               (see Live Locations, should be between 60 and 86400 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "heading"} -> for live locations, a direction in which the user is moving,
     *                               in degrees. Must be between 1 and 360 if specified - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "proximity_alert_radius"} -> for live locations, a maximum distance for
     *                               proximity alerts about approaching another chat member, in meters.
     *                               Must be between 1 and 100000 if specified - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendLocation">
     * sendLocation</a>
     */
    @RequestPath(method = POST, path = "sendLocation")
    public <T> T sendLocation(T chatId, double latitude, double longitude, Params parameters,
                              ReturnFormat format) throws IOException {
        return returnMessage(sendPostRequest(SEND_LOCATION_ENDPOINT, createCoordinatesPayload(chatId, latitude,
                longitude, parameters)), format);
    }

    /**
     * Request to send information about a venue
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param latitude:  latitude of the venue
     * @param longitude: longitude of the venue
     * @param title:     name of the venue
     * @param address:   address of the venue
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVenue">
     * sendVenue</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendVenue")
    public <T> Message sendVenue(T chatId, double latitude, double longitude, String title,
                                 String address) throws IOException {
        return (Message) sendVenue(chatId, latitude, longitude, title, address, LIBRARY_OBJECT);
    }

    /**
     * Request to send information about a venue
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param latitude:  latitude of the venue
     * @param longitude: longitude of the venue
     * @param title:     name of the venue
     * @param address:   address of the venue
     * @param format     :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVenue">
     * sendVenue</a>
     */
    @RequestPath(method = POST, path = "sendVenue")
    public <T> T sendVenue(T chatId, double latitude, double longitude, String title, String address,
                           ReturnFormat format) throws IOException {
        return sendVenue(chatId, latitude, longitude, title, address, null, format);
    }

    /**
     * Request to send information about a venue
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param latitude:   latitude of the venue
     * @param longitude:  longitude of the venue
     * @param title:      name of the venue
     * @param address:    address of the venue
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "foursquare_id"} -> foursquare identifier of the venue - [String]
     *                          </li>
     *                          <li>
     *                               {@code "foursquare_type"} -> foursquare type of the venue - [String]
     *                          </li>
     *                          <li>
     *                               {@code "google_place_id"} -> google Places identifier of the venue - [String]
     *                          </li>
     *                          <li>
     *                               {@code "google_place_type"} -> google Places type of the venue - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVenue">
     * sendVenue</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendVenue")
    public <T> Message sendVenue(T chatId, double latitude, double longitude, String title, String address,
                                 Params parameters) throws IOException {
        return (Message) sendVenue(chatId, latitude, longitude, title, address, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send information about a venue
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param latitude:   latitude of the venue
     * @param longitude:  longitude of the venue
     * @param title:      name of the venue
     * @param address:    address of the venue
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "foursquare_id"} -> foursquare identifier of the venue - [String]
     *                          </li>
     *                          <li>
     *                               {@code "foursquare_type"} -> foursquare type of the venue - [String]
     *                          </li>
     *                          <li>
     *                               {@code "google_place_id"} -> google Places identifier of the venue - [String]
     *                          </li>
     *                          <li>
     *                               {@code "google_place_type"} -> google Places type of the venue - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendVenue">
     * sendVenue</a>
     */
    @RequestPath(method = POST, path = "sendVenue")
    public <T> T sendVenue(T chatId, double latitude, double longitude, String title, String address, Params parameters,
                           ReturnFormat format) throws IOException {
        parameters = createCoordinatesPayload(chatId, latitude, longitude, parameters);
        parameters.addParam("title", title);
        parameters.addParam("address", address);
        return returnMessage(sendPostRequest(SEND_VENUE_ENDPOINT, parameters), format);
    }

    /**
     * Method to create a coordinates payload
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param latitude:   latitude value
     * @param longitude:  longitude value
     * @param parameters: other request parameters
     * @return payload as {@link Params}
     */
    private <T> Params createCoordinatesPayload(T chatId, double latitude, double longitude, Params parameters) {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("latitude", latitude);
        parameters.addParam("longitude", longitude);
        return parameters;
    }

    /**
     * Request to send phone contacts
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param phoneNumber: contact's phone number
     * @param firstName:   contact's first name
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendContact">
     * sendContact</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendContact")
    public <T> Message sendContact(T chatId, String phoneNumber, String firstName) throws IOException {
        return (Message) sendContact(chatId, phoneNumber, firstName, LIBRARY_OBJECT);
    }

    /**
     * Request to send phone contacts
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param phoneNumber: contact's phone number
     * @param firstName:   contact's first name
     * @param format       :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendContact">
     * sendContact</a>
     */
    @RequestPath(method = POST, path = "sendContact")
    public <T> T sendContact(T chatId, String phoneNumber, String firstName, ReturnFormat format) throws IOException {
        return sendContact(chatId, phoneNumber, firstName, null, format);
    }

    /**
     * Request to send phone contacts
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param phoneNumber: contact's phone number
     * @param firstName:   contact's first name
     * @param parameters:  additional params of the request, keys accepted are:
     *                     <ul>
     *                           <li>
     *                                {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                (topic) of the forum; for forum supergroups only - [Integer]
     *                           </li>
     *                           <li>
     *                                {@code "last_name"} -> contact's last name - [String]
     *                           </li>
     *                           <li>
     *                                {@code "vcard"} -> additional data about the contact in the form of a vCard,
     *                                0-2048 bytes - [String]
     *                           </li>
     *                           <li>
     *                                {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                                notification with no sound - [Boolean]
     *                           </li>
     *                           <li>
     *                                {@code "protect_content"} -> protects the contents of the sent message from
     *                                forwarding and saving - [Boolean]
     *                           </li>
     *                           <li>
     *                                {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                                message - [Integer]
     *                           </li>
     *                           <li>
     *                                {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                                specified replied-to message is not found - [Boolean]
     *                           </li>
     *                           <li>
     *                                {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                                {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                           </li>
     *                     </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendContact">
     * sendContact</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendContact")
    public <T> Message sendContact(T chatId, String phoneNumber, String firstName, Params parameters) throws IOException {
        return (Message) sendContact(chatId, phoneNumber, firstName, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send phone contacts
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param phoneNumber: contact's phone number
     * @param firstName:   contact's first name
     * @param parameters:  additional params of the request, keys accepted are:
     *                     <ul>
     *                           <li>
     *                                {@code "message_thread_id"} -> unique identifier for the target message thread
     *                                (topic) of the forum; for forum supergroups only - [Integer]
     *                           </li>
     *                           <li>
     *                                {@code "last_name"} -> contact's last name - [String]
     *                           </li>
     *                           <li>
     *                                {@code "vcard"} -> additional data about the contact in the form of a vCard,
     *                                0-2048 bytes - [String]
     *                           </li>
     *                           <li>
     *                                {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                                notification with no sound - [Boolean]
     *                           </li>
     *                           <li>
     *                                {@code "protect_content"} -> protects the contents of the sent message from
     *                                forwarding and saving - [Boolean]
     *                           </li>
     *                           <li>
     *                                {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                                message - [Integer]
     *                           </li>
     *                           <li>
     *                                {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                                specified replied-to message is not found - [Boolean]
     *                           </li>
     *                           <li>
     *                                {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                                {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                           </li>
     *                     </ul>
     * @param format       :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendContact">
     * sendContact</a>
     */
    @RequestPath(method = POST, path = "sendContact")
    public <T> T sendContact(T chatId, String phoneNumber, String firstName, Params parameters,
                             ReturnFormat format) throws IOException {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("phone_number", phoneNumber);
        parameters.addParam("first_name", firstName);
        return returnMessage(sendPostRequest(SEND_CONTACT_ENDPOINT, parameters), format);
    }

    /**
     * Request to send a native poll
     *
     * @param chatId:   unique identifier for the target chat or username of the target channel
     * @param question: poll question, 1-300 characters
     * @param options:  list of answer options, 2-10 strings 1-100 characters each
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendPoll">
     * sendPoll</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendPoll")
    public <T> Message sendPoll(T chatId, String question, String... options) throws IOException {
        return (Message) sendPoll(chatId, question, LIBRARY_OBJECT, options);
    }

    /**
     * Request to send a native poll
     *
     * @param chatId:   unique identifier for the target chat or username of the target channel
     * @param question: poll question, 1-300 characters
     * @param options:  list of answer options, 2-10 strings 1-100 characters each
     * @param format    :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendPoll">
     * sendPoll</a>
     */
    @RequestPath(method = POST, path = "sendPoll")
    public <T> T sendPoll(T chatId, String question, ReturnFormat format, String... options) throws IOException {
        return sendPoll(chatId, question, null, format, options);
    }

    /**
     * Request to send a native poll
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param question:   poll question, 1-300 characters
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "is_anonymous"} -> if the poll needs to be anonymous - [Boolean, default true]
     *                          </li>
     *                          <li>
     *                               {@code "type"} -> poll type - [{@link PollType}, default {@link PollType#regular}]
     *                          </li>
     *                          <li>
     *                               {@code "allows_multiple_answers"} -> iif the poll allows multiple answers, ignored
     *                               for polls in quiz mode - [Boolean, default false]
     *                          </li>
     *                          <li>
     *                               {@code "correct_option_id"} -> 0-based identifier of the correct answer option,
     *                               required for polls in quiz mode - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "explanation"} -> text that is shown when a user chooses an incorrect answer
     *                               or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line
     *                               feeds after entities parsing - [String]
     *                          </li>
     *                          <li>
     *                               {@code "explanation_parse_mode"} -> list of special entities that appear in the
     *                               poll explanation, which can be specified instead of parse_mode - [String]
     *                          </li>
     *                          <li>
     *                               {@code "explanation_entities"} -> list of special entities that appear in the poll
     *                               explanation, which can be specified instead of parse_mode
     *                               - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "open_period"} -> amount of time in seconds the poll will be active after
     *                               creation, 5-600. Can't be used together with close_date - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "close_date"} -> point in time (Unix timestamp) when the poll will be
     *                               automatically closed. Must be at least 5 and no more than 600 seconds in the future.
     *                               Can't be used together with open_period. - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "is_closed"} -> if the poll needs to be immediately closed. This can be
     *                               useful for poll preview - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param options:    list of answer options, 2-10 strings 1-100 characters each
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendPoll">
     * sendPoll</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendPoll")
    public <T> Message sendPoll(T chatId, String question, Params parameters, String... options) throws IOException {
        return (Message) sendPoll(chatId, question, parameters, LIBRARY_OBJECT, options);
    }

    /**
     * Request to send a native poll
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param question:   poll question, 1-300 characters
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "is_anonymous"} -> if the poll needs to be anonymous - [Boolean, default true]
     *                          </li>
     *                          <li>
     *                               {@code "type"} -> poll type - [{@link PollType}, default {@link PollType#regular}]
     *                          </li>
     *                          <li>
     *                               {@code "allows_multiple_answers"} -> iif the poll allows multiple answers, ignored
     *                               for polls in quiz mode - [Boolean, default false]
     *                          </li>
     *                          <li>
     *                               {@code "correct_option_id"} -> 0-based identifier of the correct answer option,
     *                               required for polls in quiz mode - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "explanation"} -> text that is shown when a user chooses an incorrect answer
     *                               or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line
     *                               feeds after entities parsing - [String]
     *                          </li>
     *                          <li>
     *                               {@code "explanation_parse_mode"} -> list of special entities that appear in the
     *                               poll explanation, which can be specified instead of parse_mode - [String]
     *                          </li>
     *                          <li>
     *                               {@code "explanation_entities"} -> list of special entities that appear in the poll
     *                               explanation, which can be specified instead of parse_mode
     *                               - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "open_period"} -> amount of time in seconds the poll will be active after
     *                               creation, 5-600. Can't be used together with close_date - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "close_date"} -> point in time (Unix timestamp) when the poll will be
     *                               automatically closed. Must be at least 5 and no more than 600 seconds in the future.
     *                               Can't be used together with open_period. - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "is_closed"} -> if the poll needs to be immediately closed. This can be
     *                               useful for poll preview - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param options:    list of answer options, 2-10 strings 1-100 characters each
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendPoll">
     * sendPoll</a>
     */
    @RequestPath(method = POST, path = "sendPoll")
    public <T> T sendPoll(T chatId, String question, Params parameters, ReturnFormat format,
                          String... options) throws IOException {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("question", question);
        parameters.addParam("options", new JSONArray(options));
        return returnMessage(sendPostRequest(SEND_POLL_ENDPOINT, parameters), format);
    }

    /**
     * Request to send an animated emoji that will display a random value
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendDice">
     * sendDice</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendDice")
    public <T> Message sendDice(T chatId) throws IOException {
        return (Message) sendDice(chatId, LIBRARY_OBJECT);
    }

    /**
     * Request to send an animated emoji that will display a random value
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendDice">
     * sendDice</a>
     */
    @RequestPath(method = POST, path = "sendDice")
    public <T> T sendDice(T chatId, ReturnFormat format) throws IOException {
        return sendDice(chatId, null, format);
    }

    /**
     * Request to send an animated emoji that will display a random value
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "emoji"} -> emoji on which the dice throw animation is based - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendDice">
     * sendDice</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendDice")
    public <T> Message sendDice(T chatId, Params parameters) throws IOException {
        return (Message) sendDice(chatId, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send an animated emoji that will display a random value
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "message_thread_id"} -> unique identifier for the target message thread
     *                               (topic) of the forum; for forum supergroups only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "emoji"} -> emoji on which the dice throw animation is based - [String]
     *                          </li>
     *                          <li>
     *                               {@code "disable_notification"} -> sends the message silently. Users will receive a
     *                               notification with no sound - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "protect_content"} -> protects the contents of the sent message from
     *                               forwarding and saving - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_to_message_id"} -> if the message is a reply, ID of the original
     *                               message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "allow_sending_without_reply"} -> if the message should be sent even if the
     *                               specified replied-to message is not found - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendDice">
     * sendDice</a>
     */
    @RequestPath(method = POST, path = "sendDice")
    public <T> T sendDice(T chatId, Params parameters, ReturnFormat format) throws IOException {
        parameters = createChatIdPayload(chatId, parameters);
        return returnMessage(sendPostRequest(SEND_DICE_ENDPOINT, parameters), format);
    }

    /**
     * Method to use when you need to tell the user that something is happening on the bot's side. The status is set for 5
     * seconds or less (when a message arrives from your bot, Telegram clients clear its typing status)
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param action: type of action to broadcast
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} and error printed with {@link #printErrorResponse()} method if not successful
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendChatAction">
     * sendChatAction</a>
     */
    @RequestPath(method = POST, path = "sendChatAction")
    public <T> boolean sendChatAction(T chatId, ChatActionValue action) throws IOException {
        return sendChatAction(chatId, action, -1);
    }

    /**
     * Method to use when you need to tell the user that something is happening on the bot's side. The status is set for 5
     * seconds or less (when a message arrives from your bot, Telegram clients clear its typing status)
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param action:          type of action to broadcast
     * @param messageThreadId: unique identifier for the target message thread; supergroups only
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} and error printed with {@link #printErrorResponse()} method if not successful
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendChatAction">
     * sendChatAction</a>
     */
    @RequestPath(method = POST, path = "sendChatAction")
    public <T> boolean sendChatAction(T chatId, ChatActionValue action, long messageThreadId) throws IOException {
        Params parameters = createChatIdPayload(chatId, null);
        if (messageThreadId != -1)
            parameters.addParam("message_thread_id", messageThreadId);
        parameters.addParam("action", action);
        return Boolean.parseBoolean(sendPostRequest(SEND_CHAT_ACTION_ENDPOINT, parameters));
    }

    /**
     * Method to create a chat identifier payload
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param parameters: other request parameters
     * @return payload as {@link Params}
     */
    private <T> Params createChatIdPayload(T chatId, Params parameters) {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("chat_id", getChatId(chatId));
        return parameters;
    }

    /**
     * Method to fetch from the generic type parameter the chat identifier
     *
     * @param chatId: generic type parameter from fetch the chat identifier
     * @return chat identifier as {@link T}
     */
    private <T> T getChatId(T chatId) {
        if (chatId instanceof Chat)
            return (T) ("" + ((Chat) chatId).getId());
        return chatId;
    }

}
