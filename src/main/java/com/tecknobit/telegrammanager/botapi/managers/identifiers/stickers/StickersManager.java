package com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.TelegramIdentifierManager;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.TelegramFile;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers.records.InputSticker;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers.records.MaskPosition;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers.records.Sticker;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers.records.Sticker.StickerFormat;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers.records.Sticker.StickerType;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers.records.StickerSet;
import com.tecknobit.telegrammanager.botapi.managers.profile.records.User;
import com.tecknobit.telegrammanager.botapi.records.basetypes.ForceReply;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.ReplyKeyboardRemove;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.TelegramFile.returnFile;
import static com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers.records.Sticker.returnStickersList;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message.returnMessage;

/**
 * The {@code StickersManager} class is useful to create a {@code Telegram}'s bot stickers manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stickers">
 * Stickers</a>
 * @see TelegramManager
 * @see TelegramIdentifierManager
 */
public class StickersManager extends TelegramIdentifierManager {

    /**
     * {@code SEND_STICKER_ENDPOINT} is constant for SEND_STICKER_ENDPOINT's endpoint
     */
    public static final String SEND_STICKER_ENDPOINT = "sendSticker";

    /**
     * {@code GET_STICKER_SET_ENDPOINT} is constant for GET_STICKER_SET_ENDPOINT's endpoint
     */
    public static final String GET_STICKER_SET_ENDPOINT = "getStickerSet";

    /**
     * {@code GET_CUSTOM_EMOJI_STICKERS} is constant for GET_CUSTOM_EMOJI_STICKERS's endpoint
     */
    public static final String GET_CUSTOM_EMOJI_STICKERS = "getCustomEmojiStickers";

    /**
     * {@code UPLOAD_STICKER_FILE_ENDPOINT} is constant for UPLOAD_STICKER_FILE_ENDPOINT's endpoint
     */
    public static final String UPLOAD_STICKER_FILE_ENDPOINT = "uploadStickerFile";

    /**
     * {@code CREATE_NEW_STICKER_SET_ENDPOINT} is constant for CREATE_NEW_STICKER_SET_ENDPOINT's endpoint
     */
    public static final String CREATE_NEW_STICKER_SET_ENDPOINT = "createNewStickerSet";

    /**
     * {@code ADD_STICKER_TO_SET_ENDPOINT} is constant for ADD_STICKER_TO_SET_ENDPOINT's endpoint
     */
    public static final String ADD_STICKER_TO_SET_ENDPOINT = "addStickerToSet";

    /**
     * {@code SET_STICKER_POSITION_IN_SET_ENDPOINT} is constant for SET_STICKER_POSITION_IN_SET_ENDPOINT's endpoint
     */
    public static final String SET_STICKER_POSITION_IN_SET_ENDPOINT = "setStickerPositionInSet";

    /**
     * {@code DELETE_STICKER_FROM_SET_ENDPOINT} is constant for DELETE_STICKER_FROM_SET_ENDPOINT's endpoint
     */
    public static final String DELETE_STICKER_FROM_SET_ENDPOINT = "deleteStickerFromSet";

    /**
     * {@code SET_STICKER_EMOJI_LIST_ENDPOINT} is constant for SET_STICKER_EMOJI_LIST_ENDPOINT's endpoint
     */
    public static final String SET_STICKER_EMOJI_LIST_ENDPOINT = "setStickerEmojiList";

    /**
     * {@code SET_STICKER_KEYWORDS_ENDPOINT} is constant for SET_STICKER_KEYWORDS_ENDPOINT's endpoint
     */
    public static final String SET_STICKER_KEYWORDS_ENDPOINT = "setStickerKeywords";

    /**
     * {@code SET_STICKER_MASK_POSITION_ENDPOINT} is constant for SET_STICKER_MASK_POSITION_ENDPOINT's endpoint
     */
    public static final String SET_STICKER_MASK_POSITION_ENDPOINT = "setStickerMaskPosition";

    /**
     * {@code SET_STICKER_SET_TITLE_ENDPOINT} is constant for SET_STICKER_SET_TITLE_ENDPOINT's endpoint
     */
    public static final String SET_STICKER_SET_TITLE_ENDPOINT = "setStickerSetTitle";

    /**
     * {@code SET_STICKER_SET_THUMBNAIL_ENDPOINT} is constant for SET_STICKER_SET_THUMBNAIL_ENDPOINT's endpoint
     */
    public static final String SET_STICKER_SET_THUMBNAIL_ENDPOINT = "setStickerSetThumbnail";

    /**
     * {@code SET_CUSTOM_EMOJI_STICKER_SET_THUMBNAIL_ENDPOINT} is constant for SET_CUSTOM_EMOJI_STICKER_SET_THUMBNAIL_ENDPOINT's endpoint
     */
    public static final String SET_CUSTOM_EMOJI_STICKER_SET_THUMBNAIL_ENDPOINT = "setCustomEmojiStickerSetThumbnail";

    /**
     * {@code DELETE_STICKER_SET_ENDPOINT} is constant for DELETE_STICKER_SET_ENDPOINT's endpoint
     */
    public static final String DELETE_STICKER_SET_ENDPOINT = "deleteStickerSet";

    /**
     * Constructor to init {@link StickersManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public StickersManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link StickersManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public StickersManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link StickersManager}
     *
     * @param token : the bot unique authentication token
     */
    public StickersManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link StickersManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public StickersManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link StickersManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link StickersManager}'s manager without re-insert
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
    public StickersManager() throws Exception {
        super();
    }

    /**
     * Request to send static .WEBP, animated .TGS, or video .WEBM stickers
     *
     * @param sticker: sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                 (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet,
     *                 or upload a new .WEBP or .TGS sticker using multipart/form-data
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendsticker">
     * sendSticker</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendSticker")
    public Message sendSticker(String sticker) throws IOException {
        return sendSticker(mChatId, sticker, LIBRARY_OBJECT);
    }

    /**
     * Request to send static .WEBP, animated .TGS, or video .WEBM stickers
     *
     * @param sticker: sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                 (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet,
     *                 or upload a new .WEBP or .TGS sticker using multipart/form-data
     * @param format   :       return type formatter -> {@link ReturnFormat}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendsticker">
     * sendSticker</a>
     */
    @RequestPath(method = POST, path = "sendSticker")
    public <T> T sendSticker(String sticker, ReturnFormat format) throws IOException {
        return sendSticker(mChatId, sticker, format);
    }

    /**
     * Request to send static .WEBP, animated .TGS, or video .WEBM stickers
     *
     * @param chatId:  unique identifier for the target chat or username of the target channel
     * @param sticker: sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                 (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet,
     *                 or upload a new .WEBP or .TGS sticker using multipart/form-data
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendsticker">
     * sendSticker</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendSticker")
    public <T> Message sendSticker(T chatId, String sticker) throws IOException {
        return sendSticker(chatId, sticker, LIBRARY_OBJECT);
    }

    /**
     * Request to send static .WEBP, animated .TGS, or video .WEBM stickers
     *
     * @param chatId:  unique identifier for the target chat or username of the target channel
     * @param sticker: sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                 (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet,
     *                 or upload a new .WEBP or .TGS sticker using multipart/form-data
     * @param format   :       return type formatter -> {@link ReturnFormat}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendsticker">
     * sendSticker</a>
     */
    @RequestPath(method = POST, path = "sendSticker")
    public <T, L> T sendSticker(L chatId, String sticker, ReturnFormat format) throws IOException {
        return sendSticker(chatId, sticker, null, format);
    }

    /**
     * Request to send static .WEBP, animated .TGS, or video .WEBM stickers
     *
     * @param sticker:    sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet,
     *                    or upload a new .WEBP or .TGS sticker using multipart/form-data
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendsticker">
     * sendSticker</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendSticker")
    public Message sendSticker(String sticker, Params parameters) throws IOException {
        return sendSticker(mChatId, sticker, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send static .WEBP, animated .TGS, or video .WEBM stickers
     *
     * @param sticker:    sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet,
     *                    or upload a new .WEBP or .TGS sticker using multipart/form-data
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendsticker">
     * sendSticker</a>
     */
    @RequestPath(method = POST, path = "sendSticker")
    public <T> T sendSticker(String sticker, Params parameters, ReturnFormat format) throws IOException {
        return sendSticker(mChatId, sticker, parameters, format);
    }

    /**
     * Request to send static .WEBP, animated .TGS, or video .WEBM stickers
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param sticker:    sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet,
     *                    or upload a new .WEBP or .TGS sticker using multipart/form-data
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendsticker">
     * sendSticker</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "sendSticker")
    public <T> Message sendSticker(T chatId, String sticker, Params parameters) throws IOException {
        return sendSticker(chatId, sticker, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to send static .WEBP, animated .TGS, or video .WEBM stickers
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param sticker:    sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers
     *                    (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet,
     *                    or upload a new .WEBP or .TGS sticker using multipart/form-data
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sendsticker">
     * sendSticker</a>
     */
    @RequestPath(method = POST, path = "sendSticker")
    public <T, L> T sendSticker(L chatId, String sticker, Params parameters, ReturnFormat format) throws IOException {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("sticker", sticker);
        return returnMessage(sendPostRequest(SEND_STICKER_ENDPOINT, parameters), format);
    }

    /**
     * Request to get a sticker set
     *
     * @param name: name of the sticker set
     * @return sticker set as {@link StickerSet} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getstickerset">
     * getStickerSet</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getStickerSet")
    public StickerSet getStickerSet(String name) throws IOException {
        return getStickerSet(name, LIBRARY_OBJECT);
    }

    /**
     * Request to get a sticker set
     *
     * @param name:  name of the sticker set
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return sticker set as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getstickerset">
     * getStickerSet</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getStickerSet")
    public <T> T getStickerSet(String name, ReturnFormat format) throws IOException {
        Params query = new Params();
        query.addParam("name", name);
        String messageResponse = sendGetRequest(GET_STICKER_SET_ENDPOINT, query);
        return switch (format) {
            case JSON -> (T) new JSONObject(messageResponse);
            case LIBRARY_OBJECT -> (T) new StickerSet(new JSONObject(messageResponse));
            default -> (T) messageResponse;
        };
    }

    /**
     * Request to get information about custom emoji stickers by their identifiers
     *
     * @param customEmojiIds: list of custom emoji identifiers. At most 200 custom emoji identifiers can be specified
     * @return stickers list as {@link ArrayList} of {@link Sticker} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getcustomemojistickers">
     * getCustomEmojiStickers</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getCustomEmojiStickers")
    public ArrayList<Sticker> getCustomEmojiStickers(String... customEmojiIds) throws IOException {
        return getCustomEmojiStickers(LIBRARY_OBJECT, customEmojiIds);
    }

    /**
     * Request to get information about custom emoji stickers by their identifiers
     *
     * @param format          :       return type formatter -> {@link ReturnFormat}
     * @param customEmojiIds: list of custom emoji identifiers. At most 200 custom emoji identifiers can be specified
     * @return stickers list as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getcustomemojistickers">
     * getCustomEmojiStickers</a>
     */
    @RequestPath(method = GET, path = "getCustomEmojiStickers")
    public <T> T getCustomEmojiStickers(ReturnFormat format, String... customEmojiIds) throws IOException {
        Params query = new Params();
        query.addParam("custom_emoji_ids", new JSONArray(customEmojiIds));
        return returnStickersList(sendGetRequest(GET_CUSTOM_EMOJI_STICKERS, query), format);
    }

    /**
     * Request to upload a file with a sticker for later use in the {@link #createNewStickerSet} and {@link #addStickerToSet}
     * methods (the file can be used multiple times)
     *
     * @param user:          sticker file owner
     * @param sticker:       a file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format
     * @param stickerFormat: format of the sticker
     * @return uploaded as {@link TelegramFile} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#uploadstickerfile">
     * uploadStickerFile</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "uploadStickerFile")
    public TelegramFile uploadStickerFile(User user, String sticker, StickerFormat stickerFormat) throws IOException {
        return uploadStickerFile(user.getId(), sticker, stickerFormat, LIBRARY_OBJECT);
    }

    /**
     * Request to upload a file with a sticker for later use in the {@link #createNewStickerSet} and {@link #addStickerToSet}
     * methods (the file can be used multiple times)
     *
     * @param user:          sticker file owner
     * @param sticker:       a file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format
     * @param stickerFormat: format of the sticker
     * @param format         :       return type formatter -> {@link ReturnFormat}
     * @return file as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#uploadstickerfile">
     * uploadStickerFile</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "uploadStickerFile")
    public <T> T uploadStickerFile(User user, String sticker, StickerFormat stickerFormat,
                                   ReturnFormat format) throws IOException {
        return uploadStickerFile(user.getId(), sticker, stickerFormat, LIBRARY_OBJECT);
    }

    /**
     * Request to upload a file with a sticker for later use in the {@link #createNewStickerSet} and {@link #addStickerToSet}
     * methods (the file can be used multiple times)
     *
     * @param userId:        user identifier of sticker file owner
     * @param sticker:       a file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format
     * @param stickerFormat: format of the sticker
     * @return uploaded as {@link TelegramFile} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#uploadstickerfile">
     * uploadStickerFile</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "uploadStickerFile")
    public TelegramFile uploadStickerFile(long userId, String sticker, StickerFormat stickerFormat) throws IOException {
        return uploadStickerFile(userId, sticker, stickerFormat, LIBRARY_OBJECT);
    }

    /**
     * Request to upload a file with a sticker for later use in the {@link #createNewStickerSet} and {@link #addStickerToSet}
     * methods (the file can be used multiple times)
     *
     * @param userId:        user identifier of sticker file owner
     * @param sticker:       a file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format
     * @param stickerFormat: format of the sticker
     * @param format         :       return type formatter -> {@link ReturnFormat}
     * @return file as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#uploadstickerfile">
     * uploadStickerFile</a>
     */
    @RequestPath(method = POST, path = "uploadStickerFile")
    public <T> T uploadStickerFile(long userId, String sticker, StickerFormat stickerFormat,
                                   ReturnFormat format) throws IOException {
        Params payload = new Params();
        payload.addParam("user_id", userId);
        payload.addParam("sticker_format", stickerFormat);
        return returnFile(uploadMedia(UPLOAD_STICKER_FILE_ENDPOINT, null, "sticker", sticker, payload),
                format);
    }

    /**
     * Method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created
     *
     * @param user:          created sticker set owner
     * @param name:          short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only
     *                       English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores
     *                       and must end in {@code "_by_<bot_username>"}. <br>
     *                       {@code "<bot_username>"} is case-insensitive. 1-64 characters
     * @param title:         sticker set title, 1-64 characters
     * @param stickerFormat: format of stickers in the set
     * @param stickers:      list of 1-50 initial stickers to be added to the sticker set
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createnewstickerset">
     * createNewStickerSet</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "createNewStickerSet")
    public boolean createNewStickerSet(User user, String name, String title, StickerFormat stickerFormat,
                                       InputSticker... stickers) throws IOException {
        return createNewStickerSet(user.getId(), name, title, stickerFormat, stickers);
    }

    /**
     * Method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created
     *
     * @param userId:        user identifier created sticker set owner
     * @param name:          short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only
     *                       English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores
     *                       and must end in {@code "_by_<bot_username>"}. <br>
     *                       {@code "<bot_username>"} is case-insensitive. 1-64 characters
     * @param title:         sticker set title, 1-64 characters
     * @param stickerFormat: format of stickers in the set
     * @param stickers:      list of 1-50 initial stickers to be added to the sticker set
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createnewstickerset">
     * createNewStickerSet</a>
     */
    @RequestPath(method = POST, path = "createNewStickerSet")
    public boolean createNewStickerSet(long userId, String name, String title, StickerFormat stickerFormat,
                                       InputSticker... stickers) throws IOException {
        return createNewStickerSet(userId, name, title, stickerFormat, null, stickers);
    }

    /**
     * Method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created
     *
     * @param user:          created sticker set owner
     * @param name:          short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only
     *                       English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores
     *                       and must end in {@code "_by_<bot_username>"}. <br>
     *                       {@code "<bot_username>"} is case-insensitive. 1-64 characters
     * @param title:         sticker set title, 1-64 characters
     * @param stickerFormat: format of stickers in the set
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "sticker_type"} -> type of stickers in the set - [{@link StickerType},
     *                                  default {@link StickerType#regular}]
     *                             </li>
     *                             <li>
     *                                  {@code "needs_repainting"} -> pass True if stickers in the sticker set must be
     *                                  repainted to the color of text when used in messages, the accent color if used
     *                                  as emoji status, white on chat photos, or another appropriate color based on
     *                                  context; for custom emoji sticker sets only- [Boolean]
     *                             </li>
     *                       </ul>
     * @param stickers:      list of 1-50 initial stickers to be added to the sticker set
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createnewstickerset">
     * createNewStickerSet</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "createNewStickerSet")
    public boolean createNewStickerSet(User user, String name, String title, StickerFormat stickerFormat,
                                       Params parameters, InputSticker... stickers) throws IOException {
        return createNewStickerSet(user.getId(), name, title, stickerFormat, parameters, stickers);
    }

    /**
     * Method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created
     *
     * @param userId:        user identifier created sticker set owner
     * @param name:          short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only
     *                       English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores
     *                       and must end in {@code "_by_<bot_username>"}. <br>
     *                       {@code "<bot_username>"} is case-insensitive. 1-64 characters
     * @param title:         sticker set title, 1-64 characters
     * @param stickerFormat: format of stickers in the set
     * @param parameters:    additional params of the request, keys accepted are:
     *                       <ul>
     *                             <li>
     *                                  {@code "sticker_type"} -> type of stickers in the set - [{@link StickerType},
     *                                  default {@link StickerType#regular}]
     *                             </li>
     *                             <li>
     *                                  {@code "needs_repainting"} -> pass True if stickers in the sticker set must be
     *                                  repainted to the color of text when used in messages, the accent color if used
     *                                  as emoji status, white on chat photos, or another appropriate color based on
     *                                  context; for custom emoji sticker sets only- [Boolean]
     *                             </li>
     *                       </ul>
     * @param stickers:      list of 1-50 initial stickers to be added to the sticker set
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createnewstickerset">
     * createNewStickerSet</a>
     */
    @RequestPath(method = POST, path = "createNewStickerSet")
    public boolean createNewStickerSet(long userId, String name, String title, StickerFormat stickerFormat,
                                       Params parameters, InputSticker... stickers) throws IOException {
        if (parameters == null)
            parameters = new Params();
        parameters.addParam("user_id", userId);
        parameters.addParam("name", name);
        parameters.addParam("title", title);
        parameters.addParam("sticker_format", stickerFormat);
        parameters.addParam("stickers", Arrays.toString(stickers));
        return getBooleanResponse(sendPostRequest(CREATE_NEW_STICKER_SET_ENDPOINT, parameters));
    }

    /**
     * Method to add a new sticker to a set created by the bot. The format of the added sticker must match the format of
     * the other stickers in the set. Emoji sticker sets can have up to 200 stickers. Animated and video sticker sets can
     * have up to 50 stickers. Static sticker sets can have up to 120 stickers
     *
     * @param user:    sticker set owner
     * @param name:    sticker set name
     * @param sticker: object with information about the added sticker. If exactly the same sticker had already been
     *                 added to the set, then the set isn't changed
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#addstickertoset">
     * addStickerToSet</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "addStickerToSet")
    public boolean addStickerToSet(User user, String name, InputSticker sticker) throws IOException {
        return addStickerToSet(user.getId(), name, sticker);
    }

    /**
     * Method to add a new sticker to a set created by the bot. The format of the added sticker must match the format of
     * the other stickers in the set. Emoji sticker sets can have up to 200 stickers. Animated and video sticker sets can
     * have up to 50 stickers. Static sticker sets can have up to 120 stickers
     *
     * @param userId:  user identifier sticker set owner
     * @param name:    sticker set name
     * @param sticker: object with information about the added sticker. If exactly the same sticker had already been
     *                 added to the set, then the set isn't changed
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#addstickertoset">
     * addStickerToSet</a>
     */
    @RequestPath(method = POST, path = "addStickerToSet")
    public boolean addStickerToSet(long userId, String name, InputSticker sticker) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("user_id", userId);
        payload.addParam("name", name);
        return getBooleanResponse(sendPostRequest(ADD_STICKER_TO_SET_ENDPOINT, payload));
    }

    /**
     * Method to move a sticker in a set created by the bot to a specific position
     *
     * @param sticker:  the sticker to set
     * @param position: new sticker position in the set, zero-based
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickerpositioninset">
     * setStickerPositionInSet</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerPositionInSet")
    public boolean setStickerPositionInSet(Sticker sticker, int position) throws IOException {
        return setStickerPositionInSet(sticker.getFileId(), position);
    }

    /**
     * Method to move a sticker in a set created by the bot to a specific position
     *
     * @param sticker:  file identifier of the sticker
     * @param position: new sticker position in the set, zero-based
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickerpositioninset">
     * setStickerPositionInSet</a>
     */
    @RequestPath(method = POST, path = "setStickerPositionInSet")
    public boolean setStickerPositionInSet(String sticker, int position) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("position", position);
        return getBooleanResponse(sendPostRequest(SET_STICKER_POSITION_IN_SET_ENDPOINT, payload));
    }

    /**
     * Method to delete a sticker from a set created by the bot
     *
     * @param sticker: the sticker to delete
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletestickerfromset">
     * deleteStickerFromSet</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "deleteStickerFromSet")
    public boolean deleteStickerFromSet(Sticker sticker) throws IOException {
        return deleteStickerFromSet(sticker.getFileId());
    }

    /**
     * Method to delete a sticker from a set created by the bot
     *
     * @param sticker: file identifier of the sticker
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletestickerfromset">
     * deleteStickerFromSet</a>
     */
    @RequestPath(method = POST, path = "deleteStickerFromSet")
    public boolean deleteStickerFromSet(String sticker) throws IOException {
        return getBooleanResponse(sendPostRequest(DELETE_STICKER_FROM_SET_ENDPOINT, createStickerPayload(sticker)));
    }

    /**
     * Method to change the list of emoji assigned to a regular or custom emoji sticker. The sticker must belong to a
     * sticker set created by the bot
     *
     * @param sticker: the sticker where add the emojis
     * @param emojis:  list of 1-20 emoji associated with the sticker
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickeremojilist">
     * setStickerEmojiList</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerEmojiList")
    public boolean setStickerEmojiList(Sticker sticker, String... emojis) throws IOException {
        return setStickerEmojiList(sticker.getFileId(), emojis);
    }

    /**
     * Method to change the list of emoji assigned to a regular or custom emoji sticker. The sticker must belong to a
     * sticker set created by the bot
     *
     * @param sticker: file identifier of the sticker
     * @param emojis:  list of 1-20 emoji associated with the sticker
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickeremojilist">
     * setStickerEmojiList</a>
     */
    @RequestPath(method = POST, path = "setStickerEmojiList")
    public boolean setStickerEmojiList(String sticker, String... emojis) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("emoji_list", new JSONArray(emojis));
        return getBooleanResponse(sendPostRequest(SET_STICKER_EMOJI_LIST_ENDPOINT, payload));
    }

    /**
     * Method to change search keywords assigned to a regular or custom emoji sticker. The sticker must belong to a
     * sticker set created by the bot
     *
     * @param sticker:  the sticker where add the keywords
     * @param keywords: list of 0-20 search keywords for the sticker with total length of up to 64 characters
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickerkeywords">
     * setStickerKeywords</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerKeywords")
    public boolean setStickerKeywords(Sticker sticker, String... keywords) throws IOException {
        return setStickerKeywords(sticker.getFileId(), keywords);
    }

    /**
     * Method to change search keywords assigned to a regular or custom emoji sticker. The sticker must belong to a
     * sticker set created by the bot
     *
     * @param sticker:  file identifier of the sticker
     * @param keywords: list of 0-20 search keywords for the sticker with total length of up to 64 characters
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickerkeywords">
     * setStickerKeywords</a>
     */
    @RequestPath(method = POST, path = "setStickerKeywords")
    public boolean setStickerKeywords(String sticker, String... keywords) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("keywords", new JSONArray(keywords));
        return getBooleanResponse(sendPostRequest(SET_STICKER_KEYWORDS_ENDPOINT, payload));
    }

    /**
     * Method to change the mask position of a mask sticker. The sticker must belong to a sticker set that was created
     * by the bot
     *
     * @param sticker:      the sticker where add the mask position
     * @param maskPosition: object with the position where the mask should be placed on faces. Omit the parameter to
     *                      remove the mask position
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickermaskposition">
     * setStickerMaskPosition</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerMaskPosition")
    public boolean setStickerMaskPosition(Sticker sticker, MaskPosition maskPosition) throws IOException {
        return setStickerMaskPosition(sticker.getFileId(), maskPosition);
    }

    /**
     * Method to change the mask position of a mask sticker. The sticker must belong to a sticker set that was created
     * by the bot
     *
     * @param sticker:      file identifier of the sticker
     * @param maskPosition: object with the position where the mask should be placed on faces. Omit the parameter to
     *                      remove the mask position
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickermaskposition">
     * setStickerMaskPosition</a>
     */
    @RequestPath(method = POST, path = "setStickerMaskPosition")
    public boolean setStickerMaskPosition(String sticker, MaskPosition maskPosition) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("mask_position", maskPosition);
        return getBooleanResponse(sendPostRequest(SET_STICKER_MASK_POSITION_ENDPOINT, payload));
    }

    /**
     * Method to set the title of a created sticker set
     *
     * @param stickerSet: the sticker set to change its title
     * @param title:      sticker set title, 1-64 characters
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersettitle">
     * setStickerSetTitle</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerSetTitle")
    public boolean setStickerSetTitle(StickerSet stickerSet, String title) throws IOException {
        return setStickerSetTitle(stickerSet.getName(), title);
    }

    /**
     * Method to set the title of a created sticker set
     *
     * @param name:  the sticker set name
     * @param title: sticker set title, 1-64 characters
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersettitle">
     * setStickerSetTitle</a>
     */
    @RequestPath(method = POST, path = "setStickerSetTitle")
    public boolean setStickerSetTitle(String name, String title) throws IOException {
        Params payload = new Params();
        payload.addParam("name", name);
        payload.addParam("title", title);
        return getBooleanResponse(sendPostRequest(SET_STICKER_SET_TITLE_ENDPOINT, payload));
    }

    /**
     * Method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the
     * format of the stickers in the set
     *
     * @param user:       sticker set owner
     * @param stickerSet: the sticker where set the thumbnail
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">
     * setStickerSetThumbnail</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerSetThumbnail")
    public boolean setStickerSetThumbnail(User user, StickerSet stickerSet) throws IOException {
        return setStickerSetThumbnail(user.getId(), stickerSet.getName());
    }

    /**
     * Method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the
     * format of the stickers in the set
     *
     * @param user: sticker set owner
     * @param name: the sticker set name
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">
     * setStickerSetThumbnail</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerSetThumbnail")
    public boolean setStickerSetThumbnail(User user, String name) throws IOException {
        return setStickerSetThumbnail(user.getId(), name);
    }

    /**
     * Method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the
     * format of the stickers in the set
     *
     * @param userId:     user identifier sticker set owner
     * @param stickerSet: the sticker where set the thumbnail
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">
     * setStickerSetThumbnail</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerSetThumbnail")
    public boolean setStickerSetThumbnail(long userId, StickerSet stickerSet) throws IOException {
        return setStickerSetThumbnail(userId, stickerSet.getName());
    }

    /**
     * Method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the
     * format of the stickers in the set
     *
     * @param userId: user identifier sticker set owner
     * @param name:   the sticker set name
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">
     * setStickerSetThumbnail</a>
     */
    @RequestPath(method = POST, path = "setStickerSetThumbnail")
    public boolean setStickerSetThumbnail(long userId, String name) throws IOException {
        return setStickerSetThumbnail(userId, name, null);
    }

    /**
     * Method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the
     * format of the stickers in the set
     *
     * @param user:       sticker set owner
     * @param stickerSet: the sticker where set the thumbnail
     * @param thumbnail:  a .WEBP or .PNG image with the thumbnail, must be up to 128 kilobytes in size and have a width
     *                    and height of exactly 100px, or a .TGS animation with a thumbnail up to 32 kilobytes in size
     *                    (see <a href="https://core.telegram.org/stickers#animated-sticker-requirements">here</a> for animated sticker technical requirements),
     *                    or a WEBM video with the thumbnail up to 32 kilobytes in size;
     *                    see <a href="https://core.telegram.org/stickers#video-sticker-requirements">here</a> for video
     *                    sticker technical
     *                    requirements. Pass a file_id as a String to send a file that already exists on the Telegram servers,
     *                    pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                    using multipart/form-data. More information on Sending Files ». Animated and video sticker set
     *                    thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first
     *                    sticker is used as the thumbnail
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">
     * setStickerSetThumbnail</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerSetThumbnail")
    public boolean setStickerSetThumbnail(User user, StickerSet stickerSet, String thumbnail) throws IOException {
        return setStickerSetThumbnail(user.getId(), stickerSet.getName(), thumbnail);
    }

    /**
     * Method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the
     * format of the stickers in the set
     *
     * @param user:      sticker set owner
     * @param name:      the sticker set name
     * @param thumbnail: a .WEBP or .PNG image with the thumbnail, must be up to 128 kilobytes in size and have a width
     *                   and height of exactly 100px, or a .TGS animation with a thumbnail up to 32 kilobytes in size
     *                   (see <a href="https://core.telegram.org/stickers#animated-sticker-requirements">here</a> for animated sticker technical requirements),
     *                   or a WEBM video with the thumbnail up to 32 kilobytes in size;
     *                   see <a href="https://core.telegram.org/stickers#video-sticker-requirements">here</a> for video
     *                   sticker technical
     *                   requirements. Pass a file_id as a String to send a file that already exists on the Telegram servers,
     *                   pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                   using multipart/form-data. More information on Sending Files ». Animated and video sticker set
     *                   thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first
     *                   sticker is used as the thumbnail
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">
     * setStickerSetThumbnail</a>
     */
    @RequestPath(method = POST, path = "setStickerSetThumbnail")
    public boolean setStickerSetThumbnail(User user, String name, String thumbnail) throws IOException {
        return setStickerSetThumbnail(user.getId(), name, thumbnail);
    }

    /**
     * Method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the
     * format of the stickers in the set
     *
     * @param userId:     user identifier sticker set owner
     * @param stickerSet: the sticker where set the thumbnail
     * @param thumbnail:  a .WEBP or .PNG image with the thumbnail, must be up to 128 kilobytes in size and have a width
     *                    and height of exactly 100px, or a .TGS animation with a thumbnail up to 32 kilobytes in size
     *                    (see <a href="https://core.telegram.org/stickers#animated-sticker-requirements">here</a> for animated sticker technical requirements),
     *                    or a WEBM video with the thumbnail up to 32 kilobytes in size;
     *                    see <a href="https://core.telegram.org/stickers#video-sticker-requirements">here</a> for video
     *                    sticker technical
     *                    requirements. Pass a file_id as a String to send a file that already exists on the Telegram servers,
     *                    pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                    using multipart/form-data. More information on Sending Files ». Animated and video sticker set
     *                    thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first
     *                    sticker is used as the thumbnail
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">
     * setStickerSetThumbnail</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setStickerSetThumbnail")
    public boolean setStickerSetThumbnail(long userId, StickerSet stickerSet, String thumbnail) throws IOException {
        return setStickerSetThumbnail(userId, stickerSet.getName(), thumbnail);
    }

    /**
     * Method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the
     * format of the stickers in the set
     *
     * @param userId:    user identifier sticker set owner
     * @param name:      the sticker set name
     * @param thumbnail: a .WEBP or .PNG image with the thumbnail, must be up to 128 kilobytes in size and have a width
     *                   and height of exactly 100px, or a .TGS animation with a thumbnail up to 32 kilobytes in size
     *                   (see <a href="https://core.telegram.org/stickers#animated-sticker-requirements">here</a> for animated sticker technical requirements),
     *                   or a WEBM video with the thumbnail up to 32 kilobytes in size;
     *                   see <a href="https://core.telegram.org/stickers#video-sticker-requirements">here</a> for video
     *                   sticker technical
     *                   requirements. Pass a file_id as a String to send a file that already exists on the Telegram servers,
     *                   pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one
     *                   using multipart/form-data. More information on Sending Files ». Animated and video sticker set
     *                   thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first
     *                   sticker is used as the thumbnail
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">
     * setStickerSetThumbnail</a>
     */
    @RequestPath(method = POST, path = "setStickerSetThumbnail")
    public boolean setStickerSetThumbnail(long userId, String name, String thumbnail) throws IOException {
        Params payload = new Params();
        payload.addParam("user_id", userId);
        payload.addParam("name", name);
        if (thumbnail != null)
            payload.addParam("thumbnail", thumbnail);
        return getBooleanResponse(sendPostRequest(SET_STICKER_SET_THUMBNAIL_ENDPOINT, payload));
    }

    /**
     * Method to set the thumbnail of a custom emoji sticker set
     *
     * @param stickerSet: the sticker set where set the thumbnail of a custom emoji sticker set
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setcustomemojistickersetthumbnail">
     * setCustomEmojiStickerSetThumbnail</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setCustomEmojiStickerSetThumbnail")
    public boolean setCustomEmojiStickerSetThumbnail(StickerSet stickerSet) throws IOException {
        return setCustomEmojiStickerSetThumbnail(stickerSet.getName());
    }

    /**
     * Method to set the thumbnail of a custom emoji sticker set
     *
     * @param name: the sticker set name
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setcustomemojistickersetthumbnail">
     * setCustomEmojiStickerSetThumbnail</a>
     */
    @RequestPath(method = POST, path = "setCustomEmojiStickerSetThumbnail")
    public boolean setCustomEmojiStickerSetThumbnail(String name) throws IOException {
        return setCustomEmojiStickerSetThumbnail(name, null);
    }

    /**
     * Method to set the thumbnail of a custom emoji sticker set
     *
     * @param stickerSet:    the sticker set where set the thumbnail of a custom emoji sticker set
     * @param customEmojiId: custom emoji identifier of a sticker from the sticker set; pass an empty string to drop the
     *                       thumbnail and use the first sticker as the thumbnail
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setcustomemojistickersetthumbnail">
     * setCustomEmojiStickerSetThumbnail</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setCustomEmojiStickerSetThumbnail")
    public boolean setCustomEmojiStickerSetThumbnail(StickerSet stickerSet, String customEmojiId) throws IOException {
        return setCustomEmojiStickerSetThumbnail(stickerSet.getName(), customEmojiId);
    }

    /**
     * Method to set the thumbnail of a custom emoji sticker set
     *
     * @param name:          the sticker set name
     * @param customEmojiId: custom emoji identifier of a sticker from the sticker set; pass an empty string to drop the
     *                       thumbnail and use the first sticker as the thumbnail
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setcustomemojistickersetthumbnail">
     * setCustomEmojiStickerSetThumbnail</a>
     */
    @RequestPath(method = POST, path = "setCustomEmojiStickerSetThumbnail")
    public boolean setCustomEmojiStickerSetThumbnail(String name, String customEmojiId) throws IOException {
        Params payload = new Params();
        payload.addParam("name", name);
        if (customEmojiId != null)
            payload.addParam("custom_emoji_id", customEmojiId);
        return getBooleanResponse(sendPostRequest(SET_CUSTOM_EMOJI_STICKER_SET_THUMBNAIL_ENDPOINT, payload));
    }

    /**
     * Method to delete a sticker set that was created by the bot
     *
     * @param stickerSet: the sticker set to delete
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletestickerset">
     * deleteStickerSet</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "deleteStickerSet")
    public boolean deleteStickerSet(StickerSet stickerSet) throws IOException {
        return deleteStickerSet(stickerSet.getName());
    }

    /**
     * Method to delete a sticker set that was created by the bot
     *
     * @param name: the sticker set name
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletestickerset">
     * deleteStickerSet</a>
     */
    @RequestPath(method = POST, path = "deleteStickerSet")
    public boolean deleteStickerSet(String name) throws IOException {
        Params payload = new Params();
        payload.addParam("name", name);
        return getBooleanResponse(sendPostRequest(DELETE_STICKER_SET_ENDPOINT, payload));
    }

    /**
     * Method to create a sticker payload
     *
     * @param sticker: sticker item from fetch its details
     * @return sticker payload as {@link Params}
     */
    private <T> Params createStickerPayload(T sticker) {
        Params payload = new Params();
        payload.addParam("sticker", sticker);
        return payload;
    }

}
