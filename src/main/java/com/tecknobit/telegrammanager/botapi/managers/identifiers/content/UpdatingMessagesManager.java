package com.tecknobit.telegrammanager.botapi.managers.identifiers.content;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.TelegramIdentifierManager;
import com.tecknobit.telegrammanager.botapi.records.basetypes.ForceReply;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardRemove;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;

import java.io.IOException;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code UpdatingMessagesManager} class is useful to create a {@code Telegram}'s bot updating messages manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#updating-messages">
 * Updating messages</a>
 * @see TelegramManager
 * @see TelegramIdentifierManager
 */
public class UpdatingMessagesManager extends TelegramIdentifierManager {

    /**
     * {@code EDIT_MESSAGE_TEXT_ENDPOINT} is constant for EDIT_MESSAGE_TEXT_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_TEXT_ENDPOINT = "editMessageText";

    /**
     * {@code EDIT_MESSAGE_CAPTION_ENDPOINT} is constant for EDIT_MESSAGE_CAPTION_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_CAPTION_ENDPOINT = "editMessageCaption";

    /**
     * {@code EDIT_MESSAGE_MEDIA_ENDPOINT} is constant for EDIT_MESSAGE_MEDIA_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_MEDIA_ENDPOINT = "editMessageMedia";

    /**
     * {@code EDIT_MESSAGE_LIVE_LOCATION_ENDPOINT} is constant for EDIT_MESSAGE_LIVE_LOCATION_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_LIVE_LOCATION_ENDPOINT = "editMessageLiveLocation";

    /**
     * {@code STOP_MESSAGE_LIVE_LOCATION_ENDPOINT} is constant for STOP_MESSAGE_LIVE_LOCATION_ENDPOINT's endpoint
     */
    public static final String STOP_MESSAGE_LIVE_LOCATION_ENDPOINT = "stopMessageLiveLocation";

    /**
     * {@code EDIT_MESSAGE_REPLY_MARKUP_ENDPOINT} is constant for EDIT_MESSAGE_REPLY_MARKUP_ENDPOINT's endpoint
     */
    public static final String EDIT_MESSAGE_REPLY_MARKUP_ENDPOINT = "editMessageReplyMarkup";

    /**
     * {@code STOP_POLL_ENDPOINT} is constant for STOP_POLL_ENDPOINT's endpoint
     */
    public static final String STOP_POLL_ENDPOINT = "stopPoll";

    /**
     * {@code DELETE_MESSAGE_ENDPOINT} is constant for DELETE_MESSAGE_ENDPOINT's endpoint
     */
    public static final String DELETE_MESSAGE_ENDPOINT = "deleteMessage";

    /**
     * Constructor to init {@link UpdatingMessagesManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public UpdatingMessagesManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link UpdatingMessagesManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public UpdatingMessagesManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link UpdatingMessagesManager}
     *
     * @param token : the bot unique authentication token
     */
    public UpdatingMessagesManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link UpdatingMessagesManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public UpdatingMessagesManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link UpdatingMessagesManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link UpdatingMessagesManager}'s manager without re-insert
     * the credentials and is useful in those cases if you need to use different manager at the same time:
     * <pre>
     *     {@code
     *        //You need to insert all credentials requested
     *        TelegramManager firstManager = new TelegramManager("token", "defaultErrorMessage", timeout);
     *        //You don't need to insert all credentials to make manager work
     *        TelegramManager secondManager = new TelegramManager(); //same credentials used
     *     }
     * </pre>
     */
    public UpdatingMessagesManager() throws Exception {
        super();
    }

    /**
     * Request to edit text and game messages.
     *
     * @param text:       new text of the message, 1-4096 characters after entities parsing
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
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
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagetext">
     * editMessageText</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "editMessageText")
    public <T> T editMessageText(String text, Params parameters) throws IOException {
        return editMessageText(text, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to edit text and game messages.
     *
     * @param text:       new text of the message, 1-4096 characters after entities parsing
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
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
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagetext">
     * editMessageText</a>
     */
    @RequestPath(method = POST, path = "editMessageText")
    public <T> T editMessageText(String text, Params parameters, ReturnFormat format) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("text", text);
        return getMessageOrBooleanResponse(sendPostRequest(EDIT_MESSAGE_TEXT_ENDPOINT, parameters), format);
    }

    /**
     * Request to edit captions of messages.
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
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
     *                               {@code "entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagecaption">
     * editMessageCaption</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "editMessageCaption")
    public <T> T editMessageCaption(Params parameters) throws IOException {
        return editMessageCaption(parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to edit captions of messages.
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
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
     *                               {@code "entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagecaption">
     * editMessageCaption</a>
     */
    @RequestPath(method = POST, path = "editMessageCaption")
    public <T> T editMessageCaption(Params parameters, ReturnFormat format) throws IOException {
        return getMessageOrBooleanResponse(sendPostRequest(EDIT_MESSAGE_CAPTION_ENDPOINT, parameters), format);
    }

    /**
     * Request to edit animation, audio, document, photo, or video messages. If a message is part of a message album,
     * then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo
     * or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded
     * file via its file_id or specify a URL
     *
     * @param media:      object for a new media content of the message
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
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
     *                               {@code "entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagemedia">
     * editMessageMedia</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "editMessageMedia")
    public <T> T editMessageMedia(InputMedia media, Params parameters) throws IOException {
        return editMessageMedia(media, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to edit animation, audio, document, photo, or video messages. If a message is part of a message album,
     * then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo
     * or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded
     * file via its file_id or specify a URL
     *
     * @param media:      object for a new media content of the message
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
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
     *                               {@code "entities"} -> list of special entities that appear in message text, which
     *                               can be specified instead of parse_mode - [Array of {@link MessageEntity}]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagemedia">
     * editMessageMedia</a>
     */
    @RequestPath(method = POST, path = "editMessageMedia")
    public <T> T editMessageMedia(InputMedia media, Params parameters, ReturnFormat format) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("media", media);
        return getMessageOrBooleanResponse(sendPostRequest(EDIT_MESSAGE_MEDIA_ENDPOINT, parameters), format);
    }

    /**
     * Request to edit live location messages. A location can be edited until its live_period expires or editing is
     * explicitly disabled by a call to stopMessageLiveLocation
     *
     * @param latitude:   latitude of the new location
     * @param longitude:  longitude of the new location
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
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
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagelivelocation">
     * editMessageLiveLocation</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "editMessageLiveLocation")
    public <T> T editMessageLiveLocation(double latitude, double longitude, Params parameters) throws IOException {
        return editMessageLiveLocation(latitude, longitude, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to edit live location messages. A location can be edited until its live_period expires or editing is
     * explicitly disabled by a call to stopMessageLiveLocation
     *
     * @param latitude:   latitude of the new location
     * @param longitude:  longitude of the new location
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
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
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagelivelocation">
     * editMessageLiveLocation</a>
     */
    @RequestPath(method = POST, path = "editMessageLiveLocation")
    public <T> T editMessageLiveLocation(double latitude, double longitude, Params parameters,
                                         ReturnFormat format) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("latitude", latitude);
        parameters.addParam("longitude", longitude);
        return getMessageOrBooleanResponse(sendPostRequest(EDIT_MESSAGE_LIVE_LOCATION_ENDPOINT, parameters), format);
    }

    /**
     * Request to stop updating a live location message before live_period expires
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stopmessagelivelocation">
     * stopMessageLiveLocation</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "stopMessageLiveLocation")
    public <T> T stopMessageLiveLocation(Params parameters) throws IOException {
        return stopMessageLiveLocation(parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to stop updating a live location message before live_period expires
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stopmessagelivelocation">
     * stopMessageLiveLocation</a>
     */
    @RequestPath(method = POST, path = "stopMessageLiveLocation")
    public <T> T stopMessageLiveLocation(Params parameters, ReturnFormat format) throws IOException {
        return getMessageOrBooleanResponse(sendPostRequest(STOP_MESSAGE_LIVE_LOCATION_ENDPOINT, parameters), format);
    }

    /**
     * Request to edit only the reply markup of messages
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagereplymarkup">
     * editMessageReplyMarkup</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "editMessageReplyMarkup")
    public <T> T editMessageReplyMarkup(Params parameters) throws IOException {
        return editMessageReplyMarkup(parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to edit only the reply markup of messages
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "chat_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Unique identifier for the target chat or username of the target channel
     *                               (in the format @channelusername) - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "message_id"} -> <b>required if inline_message_id is not specified.</b>
     *                               Identifier of the message to edit - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "inline_message_id"} -> <b>required if chat_id and message_id are not specified.</b>
     *                               Identifier of the inline message - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "reply_markup"} -> additional interface options - [{@link InlineKeyboardMarkup},
     *                               {@link ReplyKeyboardMarkup}, {@link ReplyKeyboardRemove}, {@link ForceReply}]
     *                          </li>
     *                    </ul>
     * @param format:     return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editmessagereplymarkup">
     * editMessageReplyMarkup</a>
     */
    @RequestPath(method = POST, path = "editMessageReplyMarkup")
    public <T> T editMessageReplyMarkup(Params parameters, ReturnFormat format) throws IOException {
        return getMessageOrBooleanResponse(sendPostRequest(EDIT_MESSAGE_REPLY_MARKUP_ENDPOINT, parameters), format);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param message: the original message with the poll
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(Message message) throws IOException {
        return (T) stopPoll(mChatId, message.getMessageId(), LIBRARY_OBJECT);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param message: the original message with the poll
     * @param format:  return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(Message message, ReturnFormat format) throws IOException {
        return (T) stopPoll(mChatId, message.getMessageId(), format);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param messageId: the original message with the poll
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(long messageId) throws IOException {
        return (T) stopPoll(mChatId, messageId, LIBRARY_OBJECT);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param messageId: the original message with the poll
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(long messageId, ReturnFormat format) throws IOException {
        return (T) stopPoll(mChatId, messageId, format);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param chatId:  unique identifier for the target chat or username of the target channel
     * @param message: the original message with the poll
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(T chatId, Message message) throws IOException {
        return stopPoll(chatId, message.getMessageId(), LIBRARY_OBJECT);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param chatId:  unique identifier for the target chat or username of the target channel
     * @param message: the original message with the poll
     * @param format:  return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(T chatId, Message message, ReturnFormat format) throws IOException {
        return stopPoll(chatId, message.getMessageId(), format);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param messageId: the original message with the poll
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(T chatId, long messageId) throws IOException {
        return stopPoll(chatId, messageId, LIBRARY_OBJECT);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param messageId: the original message with the poll
     * @param format:    return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(T chatId, long messageId, ReturnFormat format) throws IOException {
        return stopPoll(chatId, messageId, null, format);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param message:     the original message with the poll
     * @param replyMarkup: object for a new message inline keyboard
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(Message message, InlineKeyboardMarkup replyMarkup) throws IOException {
        return stopPoll(mChatId, message.getMessageId(), replyMarkup, LIBRARY_OBJECT);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param message:     the original message with the poll
     * @param replyMarkup: object for a new message inline keyboard
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(Message message, InlineKeyboardMarkup replyMarkup, ReturnFormat format) throws IOException {
        return stopPoll(mChatId, message.getMessageId(), replyMarkup, format);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param messageId:   the original message with the poll
     * @param replyMarkup: object for a new message inline keyboard
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(long messageId, InlineKeyboardMarkup replyMarkup) throws IOException {
        return stopPoll(mChatId, messageId, replyMarkup, LIBRARY_OBJECT);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param messageId:   the original message with the poll
     * @param replyMarkup: object for a new message inline keyboard
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(long messageId, InlineKeyboardMarkup replyMarkup, ReturnFormat format) throws IOException {
        return stopPoll(mChatId, messageId, replyMarkup, format);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param message:     the original message with the poll
     * @param replyMarkup: object for a new message inline keyboard
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(T chatId, Message message, InlineKeyboardMarkup replyMarkup) throws IOException {
        return stopPoll(chatId, message.getMessageId(), replyMarkup, LIBRARY_OBJECT);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param message:     the original message with the poll
     * @param replyMarkup: object for a new message inline keyboard
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "stopPoll")
    public <T, L> T stopPoll(L chatId, Message message, InlineKeyboardMarkup replyMarkup,
                             ReturnFormat format) throws IOException {
        return stopPoll(chatId, message.getMessageId(), replyMarkup, format);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param messageId:   the original message with the poll
     * @param replyMarkup: object for a new message inline keyboard
     * @return message as {@link Message} custom object or if the edited message is not an inline message {@code "true"} boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "stopPoll")
    public <T> T stopPoll(T chatId, long messageId, InlineKeyboardMarkup replyMarkup) throws IOException {
        return stopPoll(chatId, messageId, replyMarkup, LIBRARY_OBJECT);
    }

    /**
     * Request to stop a poll which was sent by the bot
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param messageId:   the original message with the poll
     * @param replyMarkup: object for a new message inline keyboard
     * @param format:      return type formatter -> {@link ReturnFormat}
     * @return the response as {@link Message} or boolean result as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stoppoll">
     * stopPoll</a>
     */
    @RequestPath(method = POST, path = "stopPoll")
    public <T, L> T stopPoll(L chatId, long messageId, InlineKeyboardMarkup replyMarkup,
                             ReturnFormat format) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("message_id", messageId);
        if (replyMarkup != null)
            payload.addParam("reply_markup", replyMarkup);
        return getMessageOrBooleanResponse(sendPostRequest(STOP_POLL_ENDPOINT, payload), format);
    }

    /**
     * Method to delete a message, including service messages, with the following limitations:
     * <ul>
     *     <li>
     *         A message can only be deleted if it was sent less than 48 hours ago
     *     </li>
     *     <li>
     *         Service messages about a supergroup, channel, or forum topic creation can't be deleted
     *     </li>
     *     <li>
     *         A dice message in a private chat can only be deleted if it was sent more than 24 hours ago
     *     </li>
     *     <li>
     *         Bots can delete outgoing messages in private chats, groups, and supergroups
     *     </li>
     *     <li>
     *         Bots can delete incoming messages in private chats
     *     </li>
     *     <li>
     *         Bots granted can_post_messages permissions can delete outgoing messages in channels
     *     </li>
     *     <li>
     *         If the bot is an administrator of a group, it can delete any message there
     *     </li>
     *     <li>
     *         If the bot has can_delete_messages permission in a supergroup or a channel, it can delete any message there
     *     </li>
     * </ul>
     *
     * @param message: the message to delete
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletemessage">
     * deleteMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "deleteMessage")
    public boolean deleteMessage(Message message) throws Exception {
        return deleteMessage(mChatId, message.getMessageId());
    }

    /**
     * Method to delete a message, including service messages, with the following limitations:
     * <ul>
     *     <li>
     *         A message can only be deleted if it was sent less than 48 hours ago
     *     </li>
     *     <li>
     *         Service messages about a supergroup, channel, or forum topic creation can't be deleted
     *     </li>
     *     <li>
     *         A dice message in a private chat can only be deleted if it was sent more than 24 hours ago
     *     </li>
     *     <li>
     *         Bots can delete outgoing messages in private chats, groups, and supergroups
     *     </li>
     *     <li>
     *         Bots can delete incoming messages in private chats
     *     </li>
     *     <li>
     *         Bots granted can_post_messages permissions can delete outgoing messages in channels
     *     </li>
     *     <li>
     *         If the bot is an administrator of a group, it can delete any message there
     *     </li>
     *     <li>
     *         If the bot has can_delete_messages permission in a supergroup or a channel, it can delete any message there
     *     </li>
     * </ul>
     *
     * @param messageId: identifier of the message to delete
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletemessage">
     * deleteMessage</a>
     */
    @RequestPath(method = POST, path = "deleteMessage")
    public boolean deleteMessage(long messageId) throws Exception {
        return deleteMessage(mChatId, messageId);
    }

    /**
     * Method to delete a message, including service messages, with the following limitations:
     * <ul>
     *     <li>
     *         A message can only be deleted if it was sent less than 48 hours ago
     *     </li>
     *     <li>
     *         Service messages about a supergroup, channel, or forum topic creation can't be deleted
     *     </li>
     *     <li>
     *         A dice message in a private chat can only be deleted if it was sent more than 24 hours ago
     *     </li>
     *     <li>
     *         Bots can delete outgoing messages in private chats, groups, and supergroups
     *     </li>
     *     <li>
     *         Bots can delete incoming messages in private chats
     *     </li>
     *     <li>
     *         Bots granted can_post_messages permissions can delete outgoing messages in channels
     *     </li>
     *     <li>
     *         If the bot is an administrator of a group, it can delete any message there
     *     </li>
     *     <li>
     *         If the bot has can_delete_messages permission in a supergroup or a channel, it can delete any message there
     *     </li>
     * </ul>
     *
     * @param chatId:  unique identifier for the target chat or username of the target channel
     * @param message: the message to delete
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletemessage">
     * deleteMessage</a>
     */
    @RequestPath(method = POST, path = "deleteMessage")
    public <T> boolean deleteMessage(T chatId, Message message) throws Exception {
        return deleteMessage(chatId, message.getMessageId());
    }

    /**
     * Method to delete a message, including service messages, with the following limitations:
     * <ul>
     *     <li>
     *         A message can only be deleted if it was sent less than 48 hours ago
     *     </li>
     *     <li>
     *         Service messages about a supergroup, channel, or forum topic creation can't be deleted
     *     </li>
     *     <li>
     *         A dice message in a private chat can only be deleted if it was sent more than 24 hours ago
     *     </li>
     *     <li>
     *         Bots can delete outgoing messages in private chats, groups, and supergroups
     *     </li>
     *     <li>
     *         Bots can delete incoming messages in private chats
     *     </li>
     *     <li>
     *         Bots granted can_post_messages permissions can delete outgoing messages in channels
     *     </li>
     *     <li>
     *         If the bot is an administrator of a group, it can delete any message there
     *     </li>
     *     <li>
     *         If the bot has can_delete_messages permission in a supergroup or a channel, it can delete any message there
     *     </li>
     * </ul>
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param messageId: identifier of the message to delete
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletemessage">
     * deleteMessage</a>
     */
    @RequestPath(method = POST, path = "deleteMessage")
    public <T> boolean deleteMessage(T chatId, long messageId) throws Exception {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("message_id", messageId);
        return getBooleanResponse(sendPostRequest(DELETE_MESSAGE_ENDPOINT, payload));
    }

}
