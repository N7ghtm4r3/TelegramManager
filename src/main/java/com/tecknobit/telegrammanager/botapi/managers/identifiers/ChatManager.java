package com.tecknobit.telegrammanager.botapi.managers.identifiers;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.ChatInviteLink;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.ChatPermissions;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members.ChatMember;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inputmedia.InputMedia.InputMediaType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.TelegramFile;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.UserProfilePhotos;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code ChatManager} class is useful to create a {@code Telegram}'s bot chat manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#available-methods">
 * Available methods</a>
 * @see TelegramManager
 * @see TelegramIdentifierManager
 */
public class ChatManager extends TelegramIdentifierManager {

    /**
     * {@code GET_USER_PROFILE_PHOTOS_ENDPOINT} is constant for GET_USER_PROFILE_PHOTOS_ENDPOINT's endpoint
     */
    public static final String GET_USER_PROFILE_PHOTOS_ENDPOINT = "getUserProfilePhotos";

    /**
     * {@code GET_FILE_ENDPOINT} is constant for GET_FILE_ENDPOINT's endpoint
     */
    public static final String GET_FILE_ENDPOINT = "getFile";

    /**
     * {@code BAN_CHAT_MEMBER_ENDPOINT} is constant for BAN_CHAT_MEMBER_ENDPOINT's endpoint
     */
    public static final String BAN_CHAT_MEMBER_ENDPOINT = "banChatMember";

    /**
     * {@code UNBAN_CHAT_MEMBER_ENDPOINT} is constant for UNBAN_CHAT_MEMBER_ENDPOINT's endpoint
     */
    public static final String UNBAN_CHAT_MEMBER_ENDPOINT = "unbanChatMember";

    /**
     * {@code RESTRICT_CHAT_MEMBER_ENDPOINT} is constant for RESTRICT_CHAT_MEMBER_ENDPOINT's endpoint
     */
    public static final String RESTRICT_CHAT_MEMBER_ENDPOINT = "restrictChatMember";

    /**
     * {@code PROMOTE_CHAT_MEMBER_ENDPOINT} is constant for PROMOTE_CHAT_MEMBER_ENDPOINT's endpoint
     */
    public static final String PROMOTE_CHAT_MEMBER_ENDPOINT = "promoteChatMember";

    /**
     * {@code SET_CHAT_ADMINISTRATOR_CUSTOM_TITLE_ENDPOINT} is constant for SET_CHAT_ADMINISTRATOR_CUSTOM_TITLE_ENDPOINT's endpoint
     */
    public static final String SET_CHAT_ADMINISTRATOR_CUSTOM_TITLE_ENDPOINT = "setChatAdministratorCustomTitle";

    /**
     * {@code BAN_CHAT_SENDER_CHAT_ENDPOINT} is constant for BAN_CHAT_SENDER_CHAT_ENDPOINT's endpoint
     */
    public static final String BAN_CHAT_SENDER_CHAT_ENDPOINT = "banChatSenderChat";

    /**
     * {@code UNBAN_CHAT_SENDER_CHAT_ENDPOINT} is constant for UNBAN_CHAT_SENDER_CHAT_ENDPOINT's endpoint
     */
    public static final String UNBAN_CHAT_SENDER_CHAT_ENDPOINT = "unbanChatSenderChat";

    /**
     * {@code SET_CHAT_PERMISSIONS_ENDPOINT} is constant for SET_CHAT_PERMISSIONS_ENDPOINT's endpoint
     */
    public static final String SET_CHAT_PERMISSIONS_ENDPOINT = "setChatPermissions";

    /**
     * {@code EXPORT_CHAT_INVITE_LINK_ENDPOINT} is constant for EXPORT_CHAT_INVITE_LINK_ENDPOINT's endpoint
     */
    public static final String EXPORT_CHAT_INVITE_LINK_ENDPOINT = "exportChatInviteLink";

    /**
     * {@code CREATE_CHAT_INVITE_LINK_ENDPOINT} is constant for CREATE_CHAT_INVITE_LINK_ENDPOINT's endpoint
     */
    public static final String CREATE_CHAT_INVITE_LINK_ENDPOINT = "createChatInviteLink";

    /**
     * {@code EDIT_CHAT_INVITE_LINK_ENDPOINT} is constant for EDIT_CHAT_INVITE_LINK_ENDPOINT's endpoint
     */
    public static final String EDIT_CHAT_INVITE_LINK_ENDPOINT = "editChatInviteLink";

    /**
     * {@code REVOKE_CHAT_INVITE_LINK_ENDPOINT} is constant for REVOKE_CHAT_INVITE_LINK_ENDPOINT's endpoint
     */
    public static final String REVOKE_CHAT_INVITE_LINK_ENDPOINT = "revokeChatInviteLink";

    /**
     * {@code APPROVE_CHAT_JOIN_REQUEST_ENDPOINT} is constant for APPROVE_CHAT_JOIN_REQUEST_ENDPOINT's endpoint
     */
    public static final String APPROVE_CHAT_JOIN_REQUEST_ENDPOINT = "approveChatJoinRequest";

    /**
     * {@code DECLINE_CHAT_JOIN_REQUEST_ENDPOINT} is constant for DECLINE_CHAT_JOIN_REQUEST_ENDPOINT's endpoint
     */
    public static final String DECLINE_CHAT_JOIN_REQUEST_ENDPOINT = "declineChatJoinRequest";

    /**
     * {@code SET_CHAT_PHOTO_ENDPOINT} is constant for SET_CHAT_PHOTO_ENDPOINT's endpoint
     */
    public static final String SET_CHAT_PHOTO_ENDPOINT = "setChatPhoto";

    /**
     * {@code DELETE_CHAT_PHOTO_ENDPOINT} is constant for DELETE_CHAT_PHOTO_ENDPOINT's endpoint
     */
    public static final String DELETE_CHAT_PHOTO_ENDPOINT = "deleteChatPhoto";

    /**
     * {@code SET_CHAT_TITLE_ENDPOINT} is constant for SET_CHAT_TITLE_ENDPOINT's endpoint
     */
    public static final String SET_CHAT_TITLE_ENDPOINT = "setChatTitle";

    /**
     * {@code SET_CHAT_DESCRIPTION_ENDPOINT} is constant for SET_CHAT_DESCRIPTION_ENDPOINT's endpoint
     */
    public static final String SET_CHAT_DESCRIPTION_ENDPOINT = "setChatDescription";

    /**
     * {@code PIN_CHAT_MESSAGE_ENDPOINT} is constant for PIN_CHAT_MESSAGE_ENDPOINT's endpoint
     */
    public static final String PIN_CHAT_MESSAGE_ENDPOINT = "pinChatMessage";

    /**
     * {@code UNPIN_CHAT_MESSAGE_ENDPOINT} is constant for UNPIN_CHAT_MESSAGE_ENDPOINT's endpoint
     */
    public static final String UNPIN_CHAT_MESSAGE_ENDPOINT = "unpinChatMessage";

    /**
     * {@code UNPIN_ALL_CHAT_MESSAGES_ENDPOINT} is constant for UNPIN_ALL_CHAT_MESSAGES_ENDPOINT's endpoint
     */
    public static final String UNPIN_ALL_CHAT_MESSAGES_ENDPOINT = "unpinAllChatMessages";

    /**
     * {@code LEAVE_CHAT_ENDPOINT} is constant for LEAVE_CHAT_ENDPOINT's endpoint
     */
    public static final String LEAVE_CHAT_ENDPOINT = "leaveChat";

    /**
     * {@code GET_CHAT_ENDPOINT} is constant for GET_CHAT_ENDPOINT's endpoint
     */
    public static final String GET_CHAT_ENDPOINT = "getChat";

    /**
     * {@code GET_CHAT_ADMINISTRATORS_ENDPOINT} is constant for GET_CHAT_ADMINISTRATORS_ENDPOINT's endpoint
     */
    public static final String GET_CHAT_ADMINISTRATORS_ENDPOINT = "getChatAdministrators";

    /**
     * {@code GET_CHAT_MEMBER_COUNT_ENDPOINT} is constant for GET_CHAT_MEMBER_COUNT_ENDPOINT's endpoint
     */
    public static final String GET_CHAT_MEMBER_COUNT_ENDPOINT = "getChatMemberCount";

    /**
     * {@code GET_CHAT_MEMBER_ENDPOINT} is constant for GET_CHAT_MEMBER_ENDPOINT's endpoint
     */
    public static final String GET_CHAT_MEMBER_ENDPOINT = "getChatMember";

    /**
     * {@code SET_CHAT_STICKER_SET_ENDPOINT} is constant for SET_CHAT_STICKER_SET_ENDPOINT's endpoint
     */
    public static final String SET_CHAT_STICKER_SET_ENDPOINT = "setChatStickerSet";

    /**
     * {@code DELETE_CHAT_STICKER_SET_ENDPOINT} is constant for DELETE_CHAT_STICKER_SET_ENDPOINT's endpoint
     */
    public static final String DELETE_CHAT_STICKER_SET_ENDPOINT = "deleteChatStickerSet";

    /**
     * Constructor to init {@link ChatManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public ChatManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link ChatManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public ChatManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link ChatManager}
     *
     * @param token : the bot unique authentication token
     */
    public ChatManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link ChatManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public ChatManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link ChatManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link TelegramManager}'s manager without re-insert
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
    public ChatManager() throws Exception {
        super();
    }

    /**
     * Request to get a list of profile pictures for a user
     *
     * @param user: the user from fetch the photos
     * @return profile pictures as {@link UserProfilePhotos} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getUserProfilePhotos">
     * getUserProfilePhotos</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = GET, path = "getUserProfilePhotos")
    public UserProfilePhotos getUserProfilePhotos(User user) throws IOException {
        return getUserProfilePhotos(user.getId(), LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of profile pictures for a user
     *
     * @param user:  the user from fetch the photos
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return profile pictures as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getUserProfilePhotos">
     * getUserProfilePhotos</a>
     */
    @WrappedRequest
    @RequestPath(method = GET, path = "getUserProfilePhotos")
    public <T> T getUserProfilePhotos(User user, ReturnFormat format) throws IOException {
        return getUserProfilePhotos(user.getId(), format);
    }

    /**
     * Request to get a list of profile pictures for a user
     *
     * @param userId: unique identifier of the target user
     * @return profile pictures as {@link UserProfilePhotos} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getUserProfilePhotos">
     * getUserProfilePhotos</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getUserProfilePhotos")
    public UserProfilePhotos getUserProfilePhotos(long userId) throws IOException {
        return getUserProfilePhotos(userId, LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of profile pictures for a user
     *
     * @param userId: unique identifier of the target user
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return profile pictures as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getUserProfilePhotos">
     * getUserProfilePhotos</a>
     */
    @RequestPath(method = GET, path = "getUserProfilePhotos")
    public <T> T getUserProfilePhotos(long userId, ReturnFormat format) throws IOException {
        return getUserProfilePhotos(userId, null, format);
    }

    /**
     * Request to get a list of profile pictures for a user
     *
     * @param user:       the user from fetch the photos
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "offset"} -> sequential number of the first photo to be returned - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "limit"} -> limits the number of updates to be retrieved. Values between
     *                               1-100 are accepted - [Integer, default 100]
     *                          </li>
     *                    </ul>
     * @return profile pictures as {@link UserProfilePhotos} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getUserProfilePhotos">
     * getUserProfilePhotos</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = GET, path = "getUserProfilePhotos")
    public UserProfilePhotos getUserProfilePhotos(User user, Params parameters) throws IOException {
        return getUserProfilePhotos(user.getId(), parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of profile pictures for a user
     *
     * @param user:       the user from fetch the photos
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "offset"} -> sequential number of the first photo to be returned - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "limit"} -> limits the number of updates to be retrieved. Values between
     *                               1-100 are accepted - [Integer, default 100]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return profile pictures as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getUserProfilePhotos">
     * getUserProfilePhotos</a>
     */
    @WrappedRequest
    @RequestPath(method = GET, path = "getUserProfilePhotos")
    public <T> T getUserProfilePhotos(User user, Params parameters, ReturnFormat format) throws IOException {
        return getUserProfilePhotos(user.getId(), parameters, format);
    }

    /**
     * Request to get a list of profile pictures for a user
     *
     * @param userId:     unique identifier of the target user
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "offset"} -> sequential number of the first photo to be returned - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "limit"} -> limits the number of updates to be retrieved. Values between
     *                               1-100 are accepted - [Integer, default 100]
     *                          </li>
     *                    </ul>
     * @return profile pictures as {@link UserProfilePhotos} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getUserProfilePhotos">
     * getUserProfilePhotos</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getUserProfilePhotos")
    public UserProfilePhotos getUserProfilePhotos(long userId, Params parameters) throws IOException {
        return getUserProfilePhotos(userId, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of profile pictures for a user
     *
     * @param userId:     unique identifier of the target user
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "offset"} -> sequential number of the first photo to be returned - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "limit"} -> limits the number of updates to be retrieved. Values between
     *                               1-100 are accepted - [Integer, default 100]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return profile pictures as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getUserProfilePhotos">
     * getUserProfilePhotos</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getUserProfilePhotos")
    public <T> T getUserProfilePhotos(long userId, Params parameters, ReturnFormat format) throws IOException {
        String profileResponse = sendGetRequest(GET_USER_PROFILE_PHOTOS_ENDPOINT, createUserPayload(null, userId,
                parameters));
        return switch (format) {
            case JSON -> (T) new JSONObject(profileResponse);
            case LIBRARY_OBJECT -> (T) new UserProfilePhotos(new JSONObject(profileResponse));
            default -> (T) profileResponse;
        };
    }

    /**
     * Request to get basic information about a file and prepare it for downloading. For the moment, bots can download
     * files of up to 20MB in size. <br>
     * he file can then be downloaded via the link {@code "https://api.telegram.org/file/bot<token>/<file_path>"}, where
     * {@code "<file_path>"} is taken from the response. It is guaranteed that the link will be valid for at least 1 hour.
     * When the link expires, a new one can be requested by calling getFile again
     *
     * @param fileId: file identifier to get information about
     * @return file as {@link TelegramFile} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getfile">
     * getfile</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getfile")
    public TelegramFile getFile(String fileId) throws IOException {
        return getFile(fileId, LIBRARY_OBJECT);
    }

    /**
     * Request to get basic information about a file and prepare it for downloading. For the moment, bots can download
     * files of up to 20MB in size. <br>
     * he file can then be downloaded via the link {@code "https://api.telegram.org/file/bot<token>/<file_path>"}, where
     * {@code "<file_path>"} is taken from the response. It is guaranteed that the link will be valid for at least 1 hour.
     * When the link expires, a new one can be requested by calling getFile again
     *
     * @param fileId: file identifier to get information about
     * @param format  :       return type formatter -> {@link ReturnFormat}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getfile">
     * getfile</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getfile")
    public <T> T getFile(String fileId, ReturnFormat format) throws IOException {
        Params query = new Params();
        query.addParam("file_id", fileId);
        String fileResponse = sendGetRequest(GET_FILE_ENDPOINT, query);
        return switch (format) {
            case JSON -> (T) new JSONObject(fileResponse);
            case LIBRARY_OBJECT -> (T) new TelegramFile(new JSONObject(fileResponse));
            default -> (T) fileResponse;
        };
    }

    /**
     * Method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user
     * will not be able to return to the chat on their own using invite links, etc., unless unbanned first.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param user: the user to ban
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatmember">
     * banChatMember</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "banChatMember")
    public boolean banChatMember(User user) throws IOException {
        return banChatMember(mChatId, user.getId());
    }

    /**
     * Method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user
     * will not be able to return to the chat on their own using invite links, etc., unless unbanned first.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param userId: unique identifier of the target user
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatmember">
     * banChatMember</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "banChatMember")
    public boolean banChatMember(long userId) throws IOException {
        return banChatMember(mChatId, userId);
    }

    /**
     * Method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user
     * will not be able to return to the chat on their own using invite links, etc., unless unbanned first.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param user:   the user to ban
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatmember">
     * banChatMember</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "banChatMember")
    public <T> boolean banChatMember(T chatId, User user) throws IOException {
        return banChatMember(chatId, user.getId());
    }

    /**
     * Method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user
     * will not be able to return to the chat on their own using invite links, etc., unless unbanned first.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param userId: unique identifier of the target user
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatmember">
     * banChatMember</a>
     */
    @RequestPath(method = POST, path = "banChatMember")
    public <T> boolean banChatMember(T chatId, long userId) throws IOException {
        return banChatMember(chatId, userId, null);
    }

    /**
     * Method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user
     * will not be able to return to the chat on their own using invite links, etc., unless unbanned first.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param user:       the user to ban
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "until_date"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "revoke_messages"} -> pass True to delete all messages from the chat for the
     *                               user that is being removed. If False, the user will be able to see messages in the
     *                               group that were sent before the user was removed - [Boolean]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatmember">
     * banChatMember</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "banChatMember")
    public boolean banChatMember(User user, Params parameters) throws IOException {
        return banChatMember(mChatId, user.getId(), parameters);
    }

    /**
     * Method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user
     * will not be able to return to the chat on their own using invite links, etc., unless unbanned first.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param userId:     unique identifier of the target user
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "until_date"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "revoke_messages"} -> pass True to delete all messages from the chat for the
     *                               user that is being removed. If False, the user will be able to see messages in the
     *                               group that were sent before the user was removed - [Boolean]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatmember">
     * banChatMember</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "banChatMember")
    public boolean banChatMember(long userId, Params parameters) throws IOException {
        return banChatMember(mChatId, userId, parameters);
    }

    /**
     * Method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user
     * will not be able to return to the chat on their own using invite links, etc., unless unbanned first.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param user:       the user to ban
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "until_date"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "revoke_messages"} -> pass True to delete all messages from the chat for the
     *                               user that is being removed. If False, the user will be able to see messages in the
     *                               group that were sent before the user was removed - [Boolean]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatmember">
     * banChatMember</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "banChatMember")
    public <T> boolean banChatMember(T chatId, User user, Params parameters) throws IOException {
        return banChatMember(chatId, user.getId(), parameters);
    }

    /**
     * Method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user
     * will not be able to return to the chat on their own using invite links, etc., unless unbanned first.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param userId:     unique identifier of the target user
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "until_date"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "revoke_messages"} -> pass True to delete all messages from the chat for the
     *                               user that is being removed. If False, the user will be able to see messages in the
     *                               group that were sent before the user was removed - [Boolean]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatmember">
     * banChatMember</a>
     */
    @RequestPath(method = POST, path = "banChatMember")
    public <T> boolean banChatMember(T chatId, long userId, Params parameters) throws IOException {
        return getBooleanResponse(sendPostRequest(BAN_CHAT_MEMBER_ENDPOINT, createUserPayload(chatId, userId,
                parameters)));
    }

    /**
     * Method to unban a previously banned user in a supergroup or channel. The user will not return to the group or
     * channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work.
     * By default, this method guarantees that after the call the user is not a member of the chat, but will be able to
     * join it. So if the user is a member of the chat they will also be removed from the chat. If you don't want this,
     * use the parameter only_if_banned
     *
     * @param user:         the user to unban
     * @param onlyIfBanned: do nothing if the user is not banned
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unbanchatmember">
     * unbanChatMember</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "unbanChatMember")
    public boolean unbanChatMember(User user, boolean onlyIfBanned) throws IOException {
        return unbanChatMember(mChatId, user.getId(), onlyIfBanned);
    }

    /**
     * Method to unban a previously banned user in a supergroup or channel. The user will not return to the group or
     * channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work.
     * By default, this method guarantees that after the call the user is not a member of the chat, but will be able to
     * join it. So if the user is a member of the chat they will also be removed from the chat. If you don't want this,
     * use the parameter only_if_banned
     *
     * @param userId:       unique identifier of the target user
     * @param onlyIfBanned: do nothing if the user is not banned
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unbanchatmember">
     * unbanChatMember</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "unbanChatMember")
    public boolean unbanChatMember(long userId, boolean onlyIfBanned) throws IOException {
        return unbanChatMember(mChatId, userId, onlyIfBanned);
    }

    /**
     * Method to unban a previously banned user in a supergroup or channel. The user will not return to the group or
     * channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work.
     * By default, this method guarantees that after the call the user is not a member of the chat, but will be able to
     * join it. So if the user is a member of the chat they will also be removed from the chat. If you don't want this,
     * use the parameter only_if_banned
     *
     * @param chatId:       unique identifier for the target chat or username of the target channel
     * @param user:         the user to unban
     * @param onlyIfBanned: do nothing if the user is not banned
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unbanchatmember">
     * unbanChatMember</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "unbanChatMember")
    public <T> boolean unbanChatMember(T chatId, User user, boolean onlyIfBanned) throws IOException {
        return unbanChatMember(chatId, user.getId(), onlyIfBanned);
    }

    /**
     * Method to unban a previously banned user in a supergroup or channel. The user will not return to the group or
     * channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work.
     * By default, this method guarantees that after the call the user is not a member of the chat, but will be able to
     * join it. So if the user is a member of the chat they will also be removed from the chat. If you don't want this,
     * use the parameter only_if_banned
     *
     * @param chatId:       unique identifier for the target chat or username of the target channel
     * @param userId:       unique identifier of the target user
     * @param onlyIfBanned: do nothing if the user is not banned
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unbanchatmember">
     * unbanChatMember</a>
     */
    @RequestPath(method = POST, path = "unbanChatMember")
    public <T> boolean unbanChatMember(T chatId, long userId, boolean onlyIfBanned) throws IOException {
        Params payload = createUserPayload(chatId, userId, null);
        payload.addParam("only_if_banned", onlyIfBanned);
        return getBooleanResponse(sendPostRequest(UNBAN_CHAT_MEMBER_ENDPOINT, createUserPayload(chatId, userId,
                payload)));
    }

    /**
     * Method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work
     * and must have the appropriate administrator rights, pass True for all permissions to lift restrictions from a user
     *
     * @param user:            the user to unban
     * @param chatPermissions: new user permissions
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#restrictchatmember">
     * restrictChatMember</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "restrictChatMember")
    public boolean restrictChatMember(User user, ChatPermissions chatPermissions) throws IOException {
        return restrictChatMember(mChatId, user.getId(), chatPermissions);
    }

    /**
     * Method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work
     * and must have the appropriate administrator rights, pass True for all permissions to lift restrictions from a user
     *
     * @param userId:          unique identifier of the target user
     * @param chatPermissions: new user permissions
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#restrictchatmember">
     * restrictChatMember</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "restrictChatMember")
    public boolean restrictChatMember(long userId, ChatPermissions chatPermissions) throws IOException {
        return restrictChatMember(mChatId, userId, chatPermissions);
    }

    /**
     * Method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work
     * and must have the appropriate administrator rights, pass True for all permissions to lift restrictions from a user
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param user:            the user to unban
     * @param chatPermissions: new user permissions
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#restrictchatmember">
     * restrictChatMember</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "restrictChatMember")
    public <T> boolean restrictChatMember(T chatId, User user, ChatPermissions chatPermissions) throws IOException {
        return restrictChatMember(chatId, user.getId(), chatPermissions);
    }

    /**
     * Method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work
     * and must have the appropriate administrator rights, pass True for all permissions to lift restrictions from a user
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param userId:          unique identifier of the target user
     * @param chatPermissions: new user permissions
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#restrictchatmember">
     * restrictChatMember</a>
     */
    @RequestPath(method = POST, path = "restrictChatMember")
    public <T> boolean restrictChatMember(T chatId, long userId, ChatPermissions chatPermissions) throws IOException {
        return restrictChatMember(chatId, userId, chatPermissions, null);
    }

    /**
     * Method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work
     * and must have the appropriate administrator rights, pass True for all permissions to lift restrictions from a user
     *
     * @param user:            the user to unban
     * @param chatPermissions: new user permissions
     * @param parameters:      additional params of the request, keys accepted are:
     *                         <ul>
     *                               <li>
     *                                    {@code "use_independent_chat_permissions"} -> pass True if chat permissions are
     *                                    set independently. Otherwise, the can_send_other_messages and can_add_web_page_previews
     *                                    permissions will imply the can_send_messages, can_send_audios, can_send_documents,
     *                                    can_send_photos, can_send_videos, can_send_video_notes, and can_send_voice_notes
     *                                    permissions; the can_send_polls permission will imply the can_send_messages
     *                                    permission - [Boolean]
     *                               </li>
     *                               <li>
     *                                    {@code "until_date"} -> date when the user will be unbanned, unix time. If user is
     *                                    banned for more than 366 days or less than 30 seconds from the current time they
     *                                    are considered to be banned forever. Applied for supergroups
     *                                    and channels only - [Integer]
     *                               </li>
     *                         </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#restrictchatmember">
     * restrictChatMember</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "restrictChatMember")
    public boolean restrictChatMember(User user, ChatPermissions chatPermissions, Params parameters) throws IOException {
        return restrictChatMember(mChatId, user.getId(), chatPermissions, parameters);
    }

    /**
     * Method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work
     * and must have the appropriate administrator rights, pass True for all permissions to lift restrictions from a user
     *
     * @param userId:          unique identifier of the target user
     * @param chatPermissions: new user permissions
     * @param parameters:      additional params of the request, keys accepted are:
     *                         <ul>
     *                               <li>
     *                                    {@code "use_independent_chat_permissions"} -> pass True if chat permissions are
     *                                    set independently. Otherwise, the can_send_other_messages and can_add_web_page_previews
     *                                    permissions will imply the can_send_messages, can_send_audios, can_send_documents,
     *                                    can_send_photos, can_send_videos, can_send_video_notes, and can_send_voice_notes
     *                                    permissions; the can_send_polls permission will imply the can_send_messages
     *                                    permission - [Boolean]
     *                               </li>
     *                               <li>
     *                                    {@code "until_date"} -> date when the user will be unbanned, unix time. If user is
     *                                    banned for more than 366 days or less than 30 seconds from the current time they
     *                                    are considered to be banned forever. Applied for supergroups
     *                                    and channels only - [Integer]
     *                               </li>
     *                         </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#restrictchatmember">
     * restrictChatMember</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "restrictChatMember")
    public boolean restrictChatMember(long userId, ChatPermissions chatPermissions, Params parameters) throws IOException {
        return restrictChatMember(mChatId, userId, chatPermissions, parameters);
    }

    /**
     * Method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work
     * and must have the appropriate administrator rights, pass True for all permissions to lift restrictions from a user
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param user:            the user to unban
     * @param chatPermissions: new user permissions
     * @param parameters:      additional params of the request, keys accepted are:
     *                         <ul>
     *                               <li>
     *                                    {@code "use_independent_chat_permissions"} -> pass True if chat permissions are
     *                                    set independently. Otherwise, the can_send_other_messages and can_add_web_page_previews
     *                                    permissions will imply the can_send_messages, can_send_audios, can_send_documents,
     *                                    can_send_photos, can_send_videos, can_send_video_notes, and can_send_voice_notes
     *                                    permissions; the can_send_polls permission will imply the can_send_messages
     *                                    permission - [Boolean]
     *                               </li>
     *                               <li>
     *                                    {@code "until_date"} -> date when the user will be unbanned, unix time. If user is
     *                                    banned for more than 366 days or less than 30 seconds from the current time they
     *                                    are considered to be banned forever. Applied for supergroups
     *                                    and channels only - [Integer]
     *                               </li>
     *                         </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#restrictchatmember">
     * restrictChatMember</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "restrictChatMember")
    public <T> boolean restrictChatMember(T chatId, User user, ChatPermissions chatPermissions,
                                          Params parameters) throws IOException {
        return restrictChatMember(chatId, user.getId(), chatPermissions, parameters);
    }

    /**
     * Method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work
     * and must have the appropriate administrator rights, pass True for all permissions to lift restrictions from a user
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param userId:          unique identifier of the target user
     * @param chatPermissions: new user permissions
     * @param parameters:      additional params of the request, keys accepted are:
     *                         <ul>
     *                               <li>
     *                                    {@code "use_independent_chat_permissions"} -> pass True if chat permissions are
     *                                    set independently. Otherwise, the can_send_other_messages and can_add_web_page_previews
     *                                    permissions will imply the can_send_messages, can_send_audios, can_send_documents,
     *                                    can_send_photos, can_send_videos, can_send_video_notes, and can_send_voice_notes
     *                                    permissions; the can_send_polls permission will imply the can_send_messages
     *                                    permission - [Boolean]
     *                               </li>
     *                               <li>
     *                                    {@code "until_date"} -> date when the user will be unbanned, unix time. If user is
     *                                    banned for more than 366 days or less than 30 seconds from the current time they
     *                                    are considered to be banned forever. Applied for supergroups
     *                                    and channels only - [Integer]
     *                               </li>
     *                         </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#restrictchatmember">
     * restrictChatMember</a>
     */
    @RequestPath(method = POST, path = "restrictChatMember")
    public <T> boolean restrictChatMember(T chatId, long userId, ChatPermissions chatPermissions,
                                          Params parameters) throws IOException {
        parameters = createUserPayload(chatId, userId, parameters);
        parameters.addParam("permissions", chatPermissions);
        return getBooleanResponse(sendPostRequest(RESTRICT_CHAT_MEMBER_ENDPOINT, createUserPayload(chatId, userId,
                parameters)));
    }

    /**
     * Method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights, pass False for all boolean parameters to demote
     * a user
     *
     * @param user:       the user to promote
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "is_anonymous"} -> pass True if the administrator's presence in the chat
     *                               is hidden - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_chat"} -> pass True if the administrator can access the chat
     *                               event log, chat statistics, message statistics in channels, see channel members,
     *                               see anonymous administrators in supergroups and ignore slow mode. Implied by any
     *                               other administrator privilege - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_post_messages"} -> pass True if the administrator can create channel
     *                               posts, channels only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_edit_messages"} -> pass True if the administrator can edit messages of
     *                               other users and can pin messages, channels only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_delete_messages"} -> pass True if the administrator can delete messages
     *                               of other users - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_video_chats"} -> pass True if the administrator can manage
     *                               video chats - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_restrict_members"} -> pass True if the administrator can restrict, ban
     *                               or unban chat members - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_promote_members"} -> pass True if the administrator can add new
     *                               administrators with a subset of their own privileges or demote administrators that
     *                               they have promoted, directly or indirectly (promoted by administrators that were
     *                               appointed by him) - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_change_info"} -> pass True if the administrator can change chat title,
     *                               photo and other settings - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_invite_users"} -> pass True if the administrator can invite new users
     *                               to the chat - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_pin_messages"} -> pass True if the administrator can pin messages,
     *                               supergroups only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_topics"} -> pass True if the user is allowed to create, rename,
     *                               close, and reopen forum topics, supergroups only - [Boolean]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#promotechatmember">
     * promoteChatMember</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "promoteChatMember")
    public boolean promoteChatMember(User user, Params parameters) throws IOException {
        return promoteChatMember(mChatId, user.getId(), parameters);
    }

    /**
     * Method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights, pass False for all boolean parameters to demote
     * a user
     *
     * @param userId:     unique identifier of the target user
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "is_anonymous"} -> pass True if the administrator's presence in the chat
     *                               is hidden - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_chat"} -> pass True if the administrator can access the chat
     *                               event log, chat statistics, message statistics in channels, see channel members,
     *                               see anonymous administrators in supergroups and ignore slow mode. Implied by any
     *                               other administrator privilege - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_post_messages"} -> pass True if the administrator can create channel
     *                               posts, channels only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_edit_messages"} -> pass True if the administrator can edit messages of
     *                               other users and can pin messages, channels only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_delete_messages"} -> pass True if the administrator can delete messages
     *                               of other users - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_video_chats"} -> pass True if the administrator can manage
     *                               video chats - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_restrict_members"} -> pass True if the administrator can restrict, ban
     *                               or unban chat members - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_promote_members"} -> pass True if the administrator can add new
     *                               administrators with a subset of their own privileges or demote administrators that
     *                               they have promoted, directly or indirectly (promoted by administrators that were
     *                               appointed by him) - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_change_info"} -> pass True if the administrator can change chat title,
     *                               photo and other settings - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_invite_users"} -> pass True if the administrator can invite new users
     *                               to the chat - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_pin_messages"} -> pass True if the administrator can pin messages,
     *                               supergroups only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_topics"} -> pass True if the user is allowed to create, rename,
     *                               close, and reopen forum topics, supergroups only - [Boolean]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#promotechatmember">
     * promoteChatMember</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "promoteChatMember")
    public boolean promoteChatMember(long userId, Params parameters) throws IOException {
        return promoteChatMember(mChatId, userId, parameters);
    }

    /**
     * Method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights, pass False for all boolean parameters to demote
     * a user
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param user:       the user to promote
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "is_anonymous"} -> pass True if the administrator's presence in the chat
     *                               is hidden - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_chat"} -> pass True if the administrator can access the chat
     *                               event log, chat statistics, message statistics in channels, see channel members,
     *                               see anonymous administrators in supergroups and ignore slow mode. Implied by any
     *                               other administrator privilege - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_post_messages"} -> pass True if the administrator can create channel
     *                               posts, channels only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_edit_messages"} -> pass True if the administrator can edit messages of
     *                               other users and can pin messages, channels only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_delete_messages"} -> pass True if the administrator can delete messages
     *                               of other users - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_video_chats"} -> pass True if the administrator can manage
     *                               video chats - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_restrict_members"} -> pass True if the administrator can restrict, ban
     *                               or unban chat members - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_promote_members"} -> pass True if the administrator can add new
     *                               administrators with a subset of their own privileges or demote administrators that
     *                               they have promoted, directly or indirectly (promoted by administrators that were
     *                               appointed by him) - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_change_info"} -> pass True if the administrator can change chat title,
     *                               photo and other settings - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_invite_users"} -> pass True if the administrator can invite new users
     *                               to the chat - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_pin_messages"} -> pass True if the administrator can pin messages,
     *                               supergroups only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_topics"} -> pass True if the user is allowed to create, rename,
     *                               close, and reopen forum topics, supergroups only - [Boolean]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#promotechatmember">
     * promoteChatMember</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "promoteChatMember")
    public <T> boolean promoteChatMember(T chatId, User user, Params parameters) throws IOException {
        return promoteChatMember(chatId, user.getId(), parameters);
    }

    /**
     * Method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights, pass False for all boolean parameters to demote
     * a user
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param userId:     unique identifier of the target user
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "is_anonymous"} -> pass True if the administrator's presence in the chat
     *                               is hidden - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_chat"} -> pass True if the administrator can access the chat
     *                               event log, chat statistics, message statistics in channels, see channel members,
     *                               see anonymous administrators in supergroups and ignore slow mode. Implied by any
     *                               other administrator privilege - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_post_messages"} -> pass True if the administrator can create channel
     *                               posts, channels only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_edit_messages"} -> pass True if the administrator can edit messages of
     *                               other users and can pin messages, channels only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_delete_messages"} -> pass True if the administrator can delete messages
     *                               of other users - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_video_chats"} -> pass True if the administrator can manage
     *                               video chats - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_restrict_members"} -> pass True if the administrator can restrict, ban
     *                               or unban chat members - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_promote_members"} -> pass True if the administrator can add new
     *                               administrators with a subset of their own privileges or demote administrators that
     *                               they have promoted, directly or indirectly (promoted by administrators that were
     *                               appointed by him) - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_change_info"} -> pass True if the administrator can change chat title,
     *                               photo and other settings - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_invite_users"} -> pass True if the administrator can invite new users
     *                               to the chat - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_pin_messages"} -> pass True if the administrator can pin messages,
     *                               supergroups only - [Boolean]
     *                          </li>
     *                          <li>
     *                               {@code "can_manage_topics"} -> pass True if the user is allowed to create, rename,
     *                               close, and reopen forum topics, supergroups only - [Boolean]
     *                          </li>
     *                    </ul>
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#promotechatmember">
     * promoteChatMember</a>
     */
    @RequestPath(method = POST, path = "promoteChatMember")
    public <T> boolean promoteChatMember(T chatId, long userId, Params parameters) throws IOException {
        return getBooleanResponse(sendPostRequest(PROMOTE_CHAT_MEMBER_ENDPOINT, createUserPayload(chatId, userId,
                parameters)));
    }

    /**
     * Method to set a custom title for an administrator in a supergroup promoted by the bot
     *
     * @param user:        the target user
     * @param customTitle: new custom title for the administrator; 0-16 characters, emoji are not allowed
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatadministratorcustomtitle">
     * setChatAdministratorCustomTitle</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "setChatAdministratorCustomTitle")
    public boolean setChatAdministratorCustomTitle(User user, String customTitle) throws IOException {
        return setChatAdministratorCustomTitle(mChatId, user.getId(), customTitle);
    }

    /**
     * Method to set a custom title for an administrator in a supergroup promoted by the bot
     *
     * @param userId:      unique identifier of the target user
     * @param customTitle: new custom title for the administrator; 0-16 characters, emoji are not allowed
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatadministratorcustomtitle">
     * setChatAdministratorCustomTitle</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setChatAdministratorCustomTitle")
    public boolean setChatAdministratorCustomTitle(long userId, String customTitle) throws IOException {
        return setChatAdministratorCustomTitle(mChatId, userId, customTitle);
    }

    /**
     * Method to set a custom title for an administrator in a supergroup promoted by the bot
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param user:        the target user
     * @param customTitle: new custom title for the administrator; 0-16 characters, emoji are not allowed
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatadministratorcustomtitle">
     * setChatAdministratorCustomTitle</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "setChatAdministratorCustomTitle")
    public <T> boolean setChatAdministratorCustomTitle(T chatId, User user, String customTitle) throws IOException {
        return setChatAdministratorCustomTitle(chatId, user.getId(), customTitle);
    }

    /**
     * Method to set a custom title for an administrator in a supergroup promoted by the bot
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param userId:      unique identifier of the target user
     * @param customTitle: new custom title for the administrator; 0-16 characters, emoji are not allowed
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatadministratorcustomtitle">
     * setChatAdministratorCustomTitle</a>
     */
    @RequestPath(method = POST, path = "setChatAdministratorCustomTitle")
    public <T> boolean setChatAdministratorCustomTitle(T chatId, long userId, String customTitle) throws IOException {
        Params payload = createUserPayload(chatId, userId, null);
        payload.addParam("custom_title", customTitle);
        return getBooleanResponse(sendPostRequest(SET_CHAT_ADMINISTRATOR_CUSTOM_TITLE_ENDPOINT, createUserPayload(chatId,
                userId, payload)));
    }

    /**
     * Method to ban a channel chat in a supergroup or a channel. Until the chat is unbanned, the owner of the banned
     * chat won't be able to send messages on behalf of their channels. The bot must be an administrator in the
     * supergroup or channel for this to work and must have the appropriate administrator rights
     *
     * @param senderChatId: unique identifier of the target sender chat
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatsenderchat">
     * banChatSenderChat</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "banChatSenderChat")
    public boolean banChatSenderChat(long senderChatId) throws IOException {
        return banChatSenderChat(mChatId, senderChatId);
    }

    /**
     * Method to ban a channel chat in a supergroup or a channel. Until the chat is unbanned, the owner of the banned
     * chat won't be able to send messages on behalf of their channels. The bot must be an administrator in the
     * supergroup or channel for this to work and must have the appropriate administrator rights
     *
     * @param chatId:       unique identifier for the target chat or username of the target channel
     * @param senderChatId: unique identifier of the target sender chat
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#banchatsenderchat">
     * banChatSenderChat</a>
     */
    @RequestPath(method = POST, path = "banChatSenderChat")
    public <T> boolean banChatSenderChat(T chatId, long senderChatId) throws IOException {
        return workOnSenderChat(chatId, senderChatId, BAN_CHAT_SENDER_CHAT_ENDPOINT);
    }

    /**
     * Method to unban a previously banned channel chat in a supergroup or channel. The bot must be an administrator for
     * this to work and must have the appropriate administrator rights
     *
     * @param senderChatId: unique identifier of the target sender chat
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unbanchatsenderchat">
     * unbanChatSenderChat</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "unbanChatSenderChat")
    public boolean unbanChatSenderChat(long senderChatId) throws IOException {
        return unbanChatSenderChat(mChatId, senderChatId);
    }

    /**
     * Method to unban a previously banned channel chat in a supergroup or channel. The bot must be an administrator for
     * this to work and must have the appropriate administrator rights
     *
     * @param chatId:       unique identifier for the target chat or username of the target channel
     * @param senderChatId: unique identifier of the target sender chat
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unbanchatsenderchat">
     * unbanChatSenderChat</a>
     */
    @RequestPath(method = POST, path = "unbanChatSenderChat")
    public <T> boolean unbanChatSenderChat(T chatId, long senderChatId) throws IOException {
        return workOnSenderChat(chatId, senderChatId, UNBAN_CHAT_SENDER_CHAT_ENDPOINT);
    }

    /**
     * Method to work on a sender chat
     *
     * @param chatId:       unique identifier for the target chat or username of the target channel
     * @param senderChatId: unique identifier of the target sender chat
     * @param endpoint:     the endpoint to make the request
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
     */
    @RequestPath(method = POST, path = "unbanChatSenderChat")
    private <T> boolean workOnSenderChat(T chatId, long senderChatId, String endpoint) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("sender_chat_id", senderChatId);
        return getBooleanResponse(sendPostRequest(endpoint, payload));
    }

    /**
     * Method to set default chat permissions for all members. The bot must be an administrator in the group or a
     * supergroup for this to work and must have the can_restrict_members administrator rights
     *
     * @param chatPermissions:               new default chat permissions
     * @param useIndependentChatPermissions: pass True if chat permissions are set independently. Otherwise,
     *                                       the can_send_other_messages and can_add_web_page_previews permissions will imply
     *                                       the can_send_messages, can_send_audios, can_send_documents, can_send_photos,
     *                                       can_send_videos, can_send_video_notes, and can_send_voice_notes permissions;
     *                                       the can_send_polls permission will imply the can_send_messages permission
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatpermissions">
     * setChatPermissions</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setChatPermissions")
    public boolean setChatPermissions(ChatPermissions chatPermissions,
                                      boolean useIndependentChatPermissions) throws IOException {
        return setChatPermissions(mChatId, chatPermissions, useIndependentChatPermissions);
    }

    /**
     * Method to set default chat permissions for all members. The bot must be an administrator in the group or a
     * supergroup for this to work and must have the can_restrict_members administrator rights
     *
     * @param chatId:                        unique identifier for the target chat or username of the target channel
     * @param chatPermissions:               new default chat permissions
     * @param useIndependentChatPermissions: pass True if chat permissions are set independently. Otherwise,
     *                                       the can_send_other_messages and can_add_web_page_previews permissions will imply
     *                                       the can_send_messages, can_send_audios, can_send_documents, can_send_photos,
     *                                       can_send_videos, can_send_video_notes, and can_send_voice_notes permissions;
     *                                       the can_send_polls permission will imply the can_send_messages permission
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatpermissions">
     * setChatPermissions</a>
     */
    @RequestPath(method = POST, path = "setChatPermissions")
    public <T> boolean setChatPermissions(T chatId, ChatPermissions chatPermissions,
                                          boolean useIndependentChatPermissions) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("permissions", chatPermissions);
        payload.addParam("use_independent_chat_permissions", useIndependentChatPermissions);
        return getBooleanResponse(sendPostRequest(SET_CHAT_PERMISSIONS_ENDPOINT, payload));
    }

    /**
     * Request to generate a new primary invite link for a chat; any previously generated primary link is revoked.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights <br>
     * No-any params required
     *
     * @return new invite link as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#exportchatinvitelink">
     * exportChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "exportChatInviteLink")
    public <T> String exportChatInviteLink() throws IOException {
        return exportChatInviteLink(mChatId, LIBRARY_OBJECT);
    }

    /**
     * Request to generate a new primary invite link for a chat; any previously generated primary link is revoked.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return new invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#exportchatinvitelink">
     * exportChatInviteLink</a>
     */
    @RequestPath(method = POST, path = "exportChatInviteLink")
    public <T> T exportChatInviteLink(ReturnFormat format) throws IOException {
        return exportChatInviteLink(mChatId, format);
    }

    /**
     * Request to generate a new primary invite link for a chat; any previously generated primary link is revoked.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return new invite link as {@link String}
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#exportchatinvitelink">
     * exportChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "exportChatInviteLink")
    public <T> String exportChatInviteLink(T chatId) throws IOException {
        return exportChatInviteLink(chatId, LIBRARY_OBJECT);
    }

    /**
     * Request to generate a new primary invite link for a chat; any previously generated primary link is revoked.
     * The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return new invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#exportchatinvitelink">
     * exportChatInviteLink</a>
     */
    @Returner
    @RequestPath(method = POST, path = "exportChatInviteLink")
    public <T, L> T exportChatInviteLink(L chatId, ReturnFormat format) throws IOException {
        JSONObject exportResponse = new JSONObject(sendPostRequest(EXPORT_CHAT_INVITE_LINK_ENDPOINT,
                createChatIdPayload(chatId, null)));
        return switch (format) {
            case JSON -> (T) exportResponse;
            case LIBRARY_OBJECT -> (T) exportResponse.getString("result");
            default -> (T) exportResponse.toString();
        };
    }

    /**
     * Request to create an additional invite link for a chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights <br>
     * No-any params required
     *
     * @return new invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createchatinvitelink">
     * createChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "createChatInviteLink")
    public ChatInviteLink createChatInviteLink() throws IOException {
        return createChatInviteLink(mChatId, LIBRARY_OBJECT);
    }

    /**
     * Request to create an additional invite link for a chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createchatinvitelink">
     * createChatInviteLink</a>
     */
    @RequestPath(method = POST, path = "createChatInviteLink")
    public <T> T createChatInviteLink(ReturnFormat format) throws IOException {
        return createChatInviteLink(mChatId, format);
    }

    /**
     * Request to create an additional invite link for a chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return new invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createchatinvitelink">
     * createChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "createChatInviteLink")
    public <T> ChatInviteLink createChatInviteLink(T chatId) throws IOException {
        return createChatInviteLink(chatId, LIBRARY_OBJECT);
    }

    /**
     * Request to create an additional invite link for a chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createchatinvitelink">
     * createChatInviteLink</a>
     */
    @RequestPath(method = POST, path = "createChatInviteLink")
    public <T, L> T createChatInviteLink(L chatId, ReturnFormat format) throws IOException {
        return createChatInviteLink(chatId, null, format);
    }

    /**
     * Request to create an additional invite link for a chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @return new invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createchatinvitelink">
     * createChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "createChatInviteLink")
    public ChatInviteLink createChatInviteLink(Params parameters) throws IOException {
        return createChatInviteLink(mChatId, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to create an additional invite link for a chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights
     *
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createchatinvitelink">
     * createChatInviteLink</a>
     */
    @RequestPath(method = POST, path = "createChatInviteLink")
    public <T> T createChatInviteLink(Params parameters, ReturnFormat format) throws IOException {
        return createChatInviteLink(mChatId, parameters, format);
    }

    /**
     * Request to create an additional invite link for a chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @return new invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createchatinvitelink">
     * createChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "createChatInviteLink")
    public <T> ChatInviteLink createChatInviteLink(T chatId, Params parameters) throws IOException {
        return createChatInviteLink(chatId, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to create an additional invite link for a chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createchatinvitelink">
     * createChatInviteLink</a>
     */
    @RequestPath(method = POST, path = "createChatInviteLink")
    public <T, L> T createChatInviteLink(L chatId, Params parameters, ReturnFormat format) throws IOException {
        return returnChatInviteLink(sendPostRequest(CREATE_CHAT_INVITE_LINK_ENDPOINT, createChatIdPayload(chatId,
                parameters)), format);
    }

    /**
     * Request to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights
     *
     * @param inviteLink: the invite link to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @return edited invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editchatinvitelink">
     * editChatInviteLink</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "editChatInviteLink")
    public ChatInviteLink editChatInviteLink(ChatInviteLink inviteLink, Params parameters) throws IOException {
        return editChatInviteLink(mChatId, inviteLink.getInviteLink(), parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights
     *
     * @param inviteLink: the invite link to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editchatinvitelink">
     * editChatInviteLink</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "editChatInviteLink")
    public <T> T editChatInviteLink(ChatInviteLink inviteLink, Params parameters, ReturnFormat format) throws IOException {
        return editChatInviteLink(mChatId, inviteLink.getInviteLink(), parameters, format);
    }

    /**
     * Request to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param inviteLink: the invite link to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @return edited invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editchatinvitelink">
     * editChatInviteLink</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "editChatInviteLink")
    public <T> ChatInviteLink editChatInviteLink(T chatId, ChatInviteLink inviteLink, Params parameters) throws IOException {
        return editChatInviteLink(chatId, inviteLink.getInviteLink(), parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param inviteLink: the invite link to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editchatinvitelink">
     * editChatInviteLink</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "editChatInviteLink")
    public <T> T editChatInviteLink(T chatId, ChatInviteLink inviteLink, Params parameters,
                                    ReturnFormat format) throws IOException {
        return editChatInviteLink(chatId, inviteLink.getInviteLink(), parameters, format);
    }

    /**
     * Request to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights
     *
     * @param inviteLink: the invite link to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @return edited invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editchatinvitelink">
     * editChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "editChatInviteLink")
    public ChatInviteLink editChatInviteLink(String inviteLink, Params parameters) throws IOException {
        return editChatInviteLink(mChatId, inviteLink, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights
     *
     * @param inviteLink: the invite link to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editchatinvitelink">
     * editChatInviteLink</a>
     */
    @RequestPath(method = POST, path = "editChatInviteLink")
    public <T> T editChatInviteLink(String inviteLink, Params parameters, ReturnFormat format) throws IOException {
        return editChatInviteLink(mChatId, inviteLink, parameters, format);
    }

    /**
     * Request to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param inviteLink: the invite link to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @return edited invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editchatinvitelink">
     * editChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "editChatInviteLink")
    public <T> ChatInviteLink editChatInviteLink(T chatId, String inviteLink, Params parameters) throws IOException {
        return editChatInviteLink(chatId, inviteLink, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for
     * this to work and must have the appropriate administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param inviteLink: the invite link to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> invite link name; 0-32 characters - [String]
     *                          </li>
     *                          <li>
     *                               {@code "expire_date"} -> point in time (Unix timestamp) when the link will
     *                               expire - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "member_limit"} -> the maximum number of users that can be members of the
     *                               chat simultaneously after joining the chat via this invite link; 1-99999 - [Integer]
     *                          </li>
     *                          <li>
     *                               {@code "creates_join_request"} -> if users joining the chat via the link need to be
     *                               approved by chat administrators - [Boolean]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editchatinvitelink">
     * editChatInviteLink</a>
     */
    @RequestPath(method = POST, path = "editChatInviteLink")
    public <T, L> T editChatInviteLink(L chatId, String inviteLink, Params parameters,
                                       ReturnFormat format) throws IOException {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("invite_link", inviteLink);
        return returnChatInviteLink(sendPostRequest(EDIT_CHAT_INVITE_LINK_ENDPOINT, parameters), format);
    }

    /**
     * Request to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically
     * generated. The bot must be an administrator in the chat for this to work and must have the appropriate
     * administrator rights
     *
     * @param inviteLink: the invite link to revoke
     * @return revoked invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#revokechatinvitelink">
     * revokeChatInviteLink</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "revokeChatInviteLink")
    public ChatInviteLink revokeChatInviteLink(ChatInviteLink inviteLink) throws IOException {
        return revokeChatInviteLink(mChatId, inviteLink.getInviteLink(), LIBRARY_OBJECT);
    }

    /**
     * Request to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically
     * generated. The bot must be an administrator in the chat for this to work and must have the appropriate
     * administrator rights
     *
     * @param inviteLink: the invite link to revoke
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#revokechatinvitelink">
     * revokeChatInviteLink</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "revokeChatInviteLink")
    public <T> T revokeChatInviteLink(ChatInviteLink inviteLink, ReturnFormat format) throws IOException {
        return revokeChatInviteLink(mChatId, inviteLink.getInviteLink(), format);
    }

    /**
     * Request to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically
     * generated. The bot must be an administrator in the chat for this to work and must have the appropriate
     * administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param inviteLink: the invite link to revoke
     * @return revoked invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#revokechatinvitelink">
     * revokeChatInviteLink</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "revokeChatInviteLink")
    public <T> ChatInviteLink revokeChatInviteLink(T chatId, ChatInviteLink inviteLink) throws IOException {
        return revokeChatInviteLink(chatId, inviteLink.getInviteLink(), LIBRARY_OBJECT);
    }

    /**
     * Request to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically
     * generated. The bot must be an administrator in the chat for this to work and must have the appropriate
     * administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param inviteLink: the invite link to revoke
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#revokechatinvitelink">
     * revokeChatInviteLink</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "revokeChatInviteLink")
    public <T, L> T revokeChatInviteLink(L chatId, ChatInviteLink inviteLink, ReturnFormat format) throws IOException {
        return revokeChatInviteLink(chatId, inviteLink.getInviteLink(), format);
    }

    /**
     * Request to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically
     * generated. The bot must be an administrator in the chat for this to work and must have the appropriate
     * administrator rights
     *
     * @param inviteLink: the invite link to revoke
     * @return revoked invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#revokechatinvitelink">
     * revokeChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "revokeChatInviteLink")
    public <T> ChatInviteLink revokeChatInviteLink(String inviteLink) throws IOException {
        return revokeChatInviteLink(mChatId, inviteLink, LIBRARY_OBJECT);
    }

    /**
     * Request to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically
     * generated. The bot must be an administrator in the chat for this to work and must have the appropriate
     * administrator rights
     *
     * @param inviteLink: the invite link to revoke
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#revokechatinvitelink">
     * revokeChatInviteLink</a>
     */
    @RequestPath(method = POST, path = "revokeChatInviteLink")
    public <T> T revokeChatInviteLink(String inviteLink, ReturnFormat format) throws IOException {
        return revokeChatInviteLink(mChatId, inviteLink, format);
    }

    /**
     * Request to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically
     * generated. The bot must be an administrator in the chat for this to work and must have the appropriate
     * administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param inviteLink: the invite link to revoke
     * @return revoked invite link as {@link ChatInviteLink} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#revokechatinvitelink">
     * revokeChatInviteLink</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "revokeChatInviteLink")
    public <T> ChatInviteLink revokeChatInviteLink(T chatId, String inviteLink) throws IOException {
        return revokeChatInviteLink(chatId, inviteLink, LIBRARY_OBJECT);
    }

    /**
     * Request to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically
     * generated. The bot must be an administrator in the chat for this to work and must have the appropriate
     * administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param inviteLink: the invite link to revoke
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#revokechatinvitelink">
     * revokeChatInviteLink</a>
     */
    @RequestPath(method = POST, path = "revokeChatInviteLink")
    public <T, L> T revokeChatInviteLink(L chatId, String inviteLink, ReturnFormat format) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("invite_link", inviteLink);
        return returnChatInviteLink(sendPostRequest(REVOKE_CHAT_INVITE_LINK_ENDPOINT, payload), format);
    }

    /**
     * Method to create a chat invite link
     *
     * @param chatInviteLinkResponse : obtained from Telegram's response
     * @param format                 :       return type formatter -> {@link ReturnFormat}
     * @return chat invite link as {@code "format"} defines
     */
    @Returner
    private <T> T returnChatInviteLink(String chatInviteLinkResponse, ReturnFormat format) {
        return switch (format) {
            case JSON -> (T) new JSONObject(chatInviteLinkResponse);
            case LIBRARY_OBJECT -> (T) new ChatInviteLink(new JSONObject(chatInviteLinkResponse));
            default -> (T) chatInviteLinkResponse;
        };
    }

    /**
     * Method to approve a chat join request. The bot must be an administrator in the chat for this to work and must
     * have the can_invite_users administrator right
     *
     * @param user: the user to approve
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#approvechatjoinrequest">
     * approveChatJoinRequest</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "approveChatJoinRequest")
    public boolean approveChatJoinRequest(User user) throws IOException {
        return approveChatJoinRequest(mChatId, user.getId());
    }

    /**
     * Method to approve a chat join request. The bot must be an administrator in the chat for this to work and must
     * have the can_invite_users administrator right
     *
     * @param userId: unique identifier of the target user
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#approvechatjoinrequest">
     * approveChatJoinRequest</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "approveChatJoinRequest")
    public <T> boolean approveChatJoinRequest(long userId) throws IOException {
        return approveChatJoinRequest(mChatId, userId);
    }

    /**
     * Method to approve a chat join request. The bot must be an administrator in the chat for this to work and must
     * have the can_invite_users administrator right
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param user:   the user to approve
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#approvechatjoinrequest">
     * approveChatJoinRequest</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "approveChatJoinRequest")
    public <T> boolean approveChatJoinRequest(T chatId, User user) throws IOException {
        return approveChatJoinRequest(chatId, user.getId());
    }

    /**
     * Method to approve a chat join request. The bot must be an administrator in the chat for this to work and must
     * have the can_invite_users administrator right
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param userId: unique identifier of the target user
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#approvechatjoinrequest">
     * approveChatJoinRequest</a>
     */
    @RequestPath(method = POST, path = "approveChatJoinRequest")
    public <T> boolean approveChatJoinRequest(T chatId, long userId) throws IOException {
        return getBooleanResponse(sendPostRequest(APPROVE_CHAT_JOIN_REQUEST_ENDPOINT, createUserPayload(chatId, userId,
                null)));
    }

    /**
     * Method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have
     * the can_invite_users administrator right
     *
     * @param user: the user to decline
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#declinechatjoinrequest">
     * declineChatJoinRequest</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "declineChatJoinRequest")
    public boolean declineChatJoinRequest(User user) throws IOException {
        return declineChatJoinRequest(mChatId, user.getId());
    }

    /**
     * Method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have
     * the can_invite_users administrator right
     *
     * @param userId: unique identifier of the target user
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#declinechatjoinrequest">
     * declineChatJoinRequest</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "declineChatJoinRequest")
    public boolean declineChatJoinRequest(long userId) throws IOException {
        return declineChatJoinRequest(mChatId, userId);
    }

    /**
     * Method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have
     * the can_invite_users administrator right
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param user:   the user to decline
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#declinechatjoinrequest">
     * declineChatJoinRequest</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "declineChatJoinRequest")
    public <T> boolean declineChatJoinRequest(T chatId, User user) throws IOException {
        return declineChatJoinRequest(chatId, user.getId());
    }

    /**
     * Method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have
     * the can_invite_users administrator right
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param userId: unique identifier of the target user
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#declinechatjoinrequest">
     * declineChatJoinRequest</a>
     */
    @RequestPath(method = POST, path = "declineChatJoinRequest")
    public <T> boolean declineChatJoinRequest(T chatId, long userId) throws IOException {
        return getBooleanResponse(sendPostRequest(DECLINE_CHAT_JOIN_REQUEST_ENDPOINT, createUserPayload(chatId, userId,
                null)));
    }

    /**
     * Method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an
     * administrator in the chat for this to work and must have the appropriate administrator rights <br>
     *
     * @param photo: new chat photo, uploaded using multipart/form-data
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatphoto">
     * setChatPhoto</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setChatPhoto")
    public boolean setChatPhoto(String photo) throws IOException {
        return setChatPhoto(mChatId, photo);
    }

    /**
     * Method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an
     * administrator in the chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param photo:  new chat photo, uploaded using multipart/form-data
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatphoto">
     * setChatPhoto</a>
     */
    @RequestPath(method = POST, path = "setChatPhoto")
    public <T> boolean setChatPhoto(T chatId, String photo) throws IOException {
        return getBooleanResponse(uploadMedia(SET_CHAT_PHOTO_ENDPOINT, chatId, InputMediaType.photo, photo, null));
    }

    /**
     * Method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in
     * the chat for this to work and must have the appropriate administrator rights <br>
     * No-any params required
     *
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletechatphoto">
     * deleteChatPhoto</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "deleteChatPhoto")
    public boolean deleteChatPhoto() throws IOException {
        return deleteChatPhoto(mChatId);
    }

    /**
     * Method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in
     * the chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletechatphoto">
     * deleteChatPhoto</a>
     */
    @RequestPath(method = POST, path = "deleteChatPhoto")
    public <T> boolean deleteChatPhoto(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(DELETE_CHAT_PHOTO_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    /**
     * Method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator
     * in the chat for this to work and must have the appropriate administrator rights
     *
     * @param title: new chat title, 1-128 characters
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchattitle">
     * setChatTitle</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setChatTitle")
    public <T> boolean setChatTitle(String title) throws IOException {
        return setChatTitle(mChatId, title);
    }

    /**
     * Method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator
     * in the chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param title:  new chat title, 1-128 characters
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchattitle">
     * setChatTitle</a>
     */
    @RequestPath(method = POST, path = "setChatTitle")
    public <T> boolean setChatTitle(T chatId, String title) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("title", title);
        return getBooleanResponse(sendPostRequest(SET_CHAT_TITLE_ENDPOINT, payload));
    }

    /**
     * Method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the
     * chat for this to work and must have the appropriate administrator rights <br>
     * No-any params required
     *
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatdescription">
     * setChatDescription</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setChatDescription")
    public boolean setChatDescription() throws IOException {
        return setChatDescription(mChatId, "");
    }

    /**
     * Method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the
     * chat for this to work and must have the appropriate administrator rights
     *
     * @param description: new chat description, 0-255 characters
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatdescription">
     * setChatDescription</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setChatDescription")
    public boolean setChatDescription(String description) throws IOException {
        return setChatDescription(mChatId, description);
    }

    /**
     * Method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the
     * chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatdescription">
     * setChatDescription</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setChatDescription")
    public <T> boolean setChatDescription(T chatId) throws IOException {
        return setChatDescription(chatId, "");
    }

    /**
     * Method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the
     * chat for this to work and must have the appropriate administrator rights
     *
     * @param chatId:      unique identifier for the target chat or username of the target channel
     * @param description: new chat description, 0-255 characters
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatdescription">
     * setChatDescription</a>
     */
    @RequestPath(method = POST, path = "setChatDescription")
    public <T> boolean setChatDescription(T chatId, String description) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        if (!description.isBlank())
            payload.addParam("description", description);
        return getBooleanResponse(sendPostRequest(SET_CHAT_DESCRIPTION_ENDPOINT, payload));
    }

    /**
     * Method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must
     * be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a
     * supergroup or 'can_edit_messages' administrator right in a channel
     *
     * @param message:             the message to pin
     * @param disableNotification: pass True if it is not necessary to send a notification to all chat members about the
     *                             new pinned message. Notifications are always disabled in channels and private chats
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#pinchatmessage">
     * pinChatMessage</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "pinChatMessage")
    public boolean pinChatMessage(Message message, boolean disableNotification) throws IOException {
        return pinChatMessage(mChatId, message.getMessageId(), disableNotification);
    }

    /**
     * Method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must
     * be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a
     * supergroup or 'can_edit_messages' administrator right in a channel
     *
     * @param messageId:           identifier of a message to pin
     * @param disableNotification: pass True if it is not necessary to send a notification to all chat members about the
     *                             new pinned message. Notifications are always disabled in channels and private chats
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#pinchatmessage">
     * pinChatMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "pinChatMessage")
    public boolean pinChatMessage(long messageId, boolean disableNotification) throws IOException {
        return pinChatMessage(mChatId, messageId, disableNotification);
    }

    /**
     * Method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must
     * be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a
     * supergroup or 'can_edit_messages' administrator right in a channel
     *
     * @param chatId:              unique identifier for the target chat or username of the target channel
     * @param message:             the message to pin
     * @param disableNotification: pass True if it is not necessary to send a notification to all chat members about the
     *                             new pinned message. Notifications are always disabled in channels and private chats
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#pinchatmessage">
     * pinChatMessage</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "pinChatMessage")
    public <T> boolean pinChatMessage(T chatId, Message message, boolean disableNotification) throws IOException {
        return pinChatMessage(chatId, message.getMessageId(), disableNotification);
    }

    /**
     * Method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must
     * be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a
     * supergroup or 'can_edit_messages' administrator right in a channel
     *
     * @param chatId:              unique identifier for the target chat or username of the target channel
     * @param messageId:           identifier of a message to pin
     * @param disableNotification: pass True if it is not necessary to send a notification to all chat members about the
     *                             new pinned message. Notifications are always disabled in channels and private chats
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#pinchatmessage">
     * pinChatMessage</a>
     */
    @RequestPath(method = POST, path = "pinChatMessage")
    public <T> boolean pinChatMessage(T chatId, long messageId, boolean disableNotification) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("message_id", messageId);
        payload.addParam("disable_notification", disableNotification);
        return getBooleanResponse(sendPostRequest(PIN_CHAT_MESSAGE_ENDPOINT, payload));
    }

    /**
     * Method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot
     * must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right
     * in a supergroup or 'can_edit_messages' administrator right in a channel <br>
     * No-any params required
     *
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinchatmessage">
     * unpinChatMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "unpinChatMessage")
    public boolean unpinChatMessage() throws IOException {
        return unpinChatMessage(mChatId, -1);
    }

    /**
     * Method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot
     * must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right
     * in a supergroup or 'can_edit_messages' administrator right in a channel
     *
     * @param message: the message to unpin
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinchatmessage">
     * unpinChatMessage</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "unpinChatMessage")
    public boolean unpinChatMessage(Message message) throws IOException {
        return unpinChatMessage(mChatId, message.getMessageId());
    }

    /**
     * Method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot
     * must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right
     * in a supergroup or 'can_edit_messages' administrator right in a channel
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinchatmessage">
     * unpinChatMessage</a>
     */
    @RequestPath(method = POST, path = "unpinChatMessage")
    public <T> boolean unpinChatMessage(T chatId) throws IOException {
        return unpinChatMessage(chatId, -1);
    }

    /**
     * Method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot
     * must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right
     * in a supergroup or 'can_edit_messages' administrator right in a channel
     *
     * @param chatId:  unique identifier for the target chat or username of the target channel
     * @param message: the message to unpin
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinchatmessage">
     * unpinChatMessage</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "unpinChatMessage")
    public <T> boolean unpinChatMessage(T chatId, Message message) throws IOException {
        return unpinChatMessage(chatId, message.getMessageId());
    }

    /**
     * Method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot
     * must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right
     * in a supergroup or 'can_edit_messages' administrator right in a channel
     *
     * @param messageId: identifier of a message to unpin
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinchatmessage">
     * unpinChatMessage</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "unpinChatMessage")
    public boolean unpinChatMessage(long messageId) throws IOException {
        return unpinChatMessage(mChatId, messageId);
    }

    /**
     * Method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot
     * must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right
     * in a supergroup or 'can_edit_messages' administrator right in a channel
     *
     * @param chatId:    unique identifier for the target chat or username of the target channel
     * @param messageId: identifier of a message to unpin
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinchatmessage">
     * unpinChatMessage</a>
     */
    @RequestPath(method = POST, path = "unpinChatMessage")
    public <T> boolean unpinChatMessage(T chatId, long messageId) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        if (messageId != -1)
            payload.addParam("message_id", messageId);
        return getBooleanResponse(sendPostRequest(UNPIN_CHAT_MESSAGE_ENDPOINT, payload));
    }

    /**
     * Method to clear the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an
     * administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup
     * or 'can_edit_messages' administrator right in a channel <br>
     * No-any params required
     *
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinallchatmessages">
     * unpinAllChatMessages</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "unpinAllChatMessages")
    public boolean unpinAllChatMessages() throws IOException {
        return unpinAllChatMessages(mChatId);
    }

    /**
     * Method to clear the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an
     * administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup
     * or 'can_edit_messages' administrator right in a channel
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinallchatmessages">
     * unpinAllChatMessages</a>
     */
    @RequestPath(method = POST, path = "unpinAllChatMessages")
    public <T> boolean unpinAllChatMessages(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(UNPIN_ALL_CHAT_MESSAGES_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    /**
     * Method to leave a group, supergroup or channel <br>
     * No-any params required
     *
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#leavechat">
     * leaveChat</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "leaveChat")
    public boolean leaveChat() throws IOException {
        return leaveChat(mChatId);
    }

    /**
     * Method to leave a group, supergroup or channel
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#leavechat">
     * leaveChat</a>
     */
    @RequestPath(method = POST, path = "leaveChat")
    public <T> boolean leaveChat(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(LEAVE_CHAT_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    /**
     * Request to get up-to-date information about the chat (current name of the user for one-on-one conversations,
     * current username of a user, group or channel, etc.) <br>
     * No-any params required
     *
     * @return chat as {@link Chat} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchat">
     * getChat</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChat")
    public Chat getChat() throws IOException {
        return getChat(mChatId, LIBRARY_OBJECT);
    }

    /**
     * Request to get up-to-date information about the chat (current name of the user for one-on-one conversations,
     * current username of a user, group or channel, etc.)
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return chat as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchat">
     * getChat</a>
     */
    @RequestPath(method = GET, path = "getChat")
    public <T> T getChat(ReturnFormat format) throws IOException {
        return getChat(mChatId, format);
    }

    /**
     * Request to get up-to-date information about the chat (current name of the user for one-on-one conversations,
     * current username of a user, group or channel, etc.)
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return chat as {@link Chat} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchat">
     * getChat</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChat")
    public <T> Chat getChat(T chatId) throws IOException {
        return getChat(chatId, LIBRARY_OBJECT);
    }

    /**
     * Request to get up-to-date information about the chat (current name of the user for one-on-one conversations,
     * current username of a user, group or channel, etc.)
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return chat as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchat">
     * getChat</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getChat")
    public <T, L> T getChat(L chatId, ReturnFormat format) throws IOException {
        String chatResponse = sendGetRequest(GET_CHAT_ENDPOINT, createChatIdPayload(chatId, null));
        return switch (format) {
            case JSON -> (T) new JSONObject(chatResponse);
            case LIBRARY_OBJECT -> (T) new Chat(new JSONObject(chatResponse));
            default -> (T) chatResponse;
        };
    }

    /**
     * Request to get a list of administrators in a chat, which aren't bots <br>
     * No-any params required
     *
     * @return chat administrators as {@link ArrayList} of {@link ChatMember} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatadministrators">
     * getChatAdministrators</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChatAdministrators")
    public ArrayList<ChatMember> getChatAdministrators() throws IOException {
        return getChatAdministrators(mChatId, LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of administrators in a chat, which aren't bots
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return chat administrators as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatadministrators">
     * getChatAdministrators</a>
     */
    @RequestPath(method = GET, path = "getChatAdministrators")
    public <T> T getChatAdministrators(ReturnFormat format) throws IOException {
        return getChatAdministrators(mChatId, format);
    }

    /**
     * Request to get a list of administrators in a chat, which aren't bots
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return chat administrators as {@link ArrayList} of {@link ChatMember} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatadministrators">
     * getChatAdministrators</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChatAdministrators")
    public <T> ArrayList<ChatMember> getChatAdministrators(T chatId) throws IOException {
        return getChatAdministrators(chatId, LIBRARY_OBJECT);
    }

    /**
     * Request to get a list of administrators in a chat, which aren't bots
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return chat administrators as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatadministrators">
     * getChatAdministrators</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getChatAdministrators")
    public <T, L> T getChatAdministrators(L chatId, ReturnFormat format) throws IOException {
        JSONArray result = getResultFromList(sendGetRequest(GET_CHAT_ADMINISTRATORS_ENDPOINT, createChatIdPayload(chatId,
                null)));
        return switch (format) {
            case JSON -> (T) result;
            case LIBRARY_OBJECT -> {
                ArrayList<ChatMember> chatMembers = new ArrayList<>();
                for (int j = 0; j < result.length(); j++)
                    chatMembers.add(new ChatMember(result.getJSONObject(j)));
                yield (T) chatMembers;
            }
            default -> (T) result.toString();
        };
    }

    /**
     * Request to get the number of members in a chat <br>
     * No-any params required
     *
     * @return number of members as int
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmembercount">
     * getChatMemberCount</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChatMemberCount")
    public <T> int getChatMemberCount() throws IOException {
        return Integer.parseInt(getChatMemberCount(mChatId, LIBRARY_OBJECT));
    }

    /**
     * Request to get the number of members in a chat
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return number of members as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmembercount">
     * getChatMemberCount</a>
     */
    @RequestPath(method = GET, path = "getChatMemberCount")
    public <T> T getChatMemberCount(ReturnFormat format) throws IOException {
        return getChatMemberCount(mChatId, format);
    }

    /**
     * Request to get the number of members in a chat
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return number of members as int
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmembercount">
     * getChatMemberCount</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChatMemberCount")
    public <T, L> int getChatMemberCount(T chatId) throws IOException {
        return Integer.parseInt(getChatMemberCount(chatId, LIBRARY_OBJECT));
    }

    /**
     * Request to get the number of members in a chat
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return number of members as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmembercount">
     * getChatMemberCount</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getChatMemberCount")
    public <T, L> T getChatMemberCount(L chatId, ReturnFormat format) throws IOException {
        JSONObject responseMemberCount = new JSONObject(sendGetRequest(GET_CHAT_MEMBER_COUNT_ENDPOINT,
                createChatIdPayload(chatId, null)));
        return switch (format) {
            case JSON -> (T) responseMemberCount;
            case LIBRARY_OBJECT -> (T) ("" + responseMemberCount.getInt("result"));
            default -> (T) responseMemberCount.toString();
        };
    }

    /**
     * Request to get information about a member of a chat. The method is only guaranteed to work for other users if the
     * bot is an administrator in the chat
     *
     * @param userId: unique identifier of the target user
     * @return chat member as {@link ChatMember} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmember">
     * getChatMember</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChatMember")
    public ChatMember getChatMember(long userId) throws IOException {
        return getChatMember(mChatId, userId, LIBRARY_OBJECT);
    }

    /**
     * Request to get information about a member of a chat. The method is only guaranteed to work for other users if the
     * bot is an administrator in the chat
     *
     * @param userId: unique identifier of the target user
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return chat member as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmember">
     * getChatMember</a>
     */
    @RequestPath(method = GET, path = "getChatMember")
    public <T> T getChatMember(long userId, ReturnFormat format) throws IOException {
        return getChatMember(mChatId, userId, format);
    }

    /**
     * Request to get information about a member of a chat. The method is only guaranteed to work for other users if the
     * bot is an administrator in the chat
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param userId: unique identifier of the target user
     * @return chat member as {@link ChatMember} custom object
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmember">
     * getChatMember</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getChatMember")
    public <T> ChatMember getChatMember(T chatId, long userId) throws IOException {
        return getChatMember(chatId, userId, LIBRARY_OBJECT);
    }

    /**
     * Request to get information about a member of a chat. The method is only guaranteed to work for other users if the
     * bot is an administrator in the chat
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param userId: unique identifier of the target user
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return chat member as {@code "format"} defines
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getchatmember">
     * getChatMember</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getChatMember")
    public <T, L> T getChatMember(L chatId, long userId, ReturnFormat format) throws IOException {
        String chatMemberResponse = sendGetRequest(GET_CHAT_MEMBER_ENDPOINT, createChatIdPayload(chatId, null));
        return switch (format) {
            case JSON -> (T) new JSONObject(chatMemberResponse);
            case LIBRARY_OBJECT -> (T) new ChatMember(new JSONObject(chatMemberResponse));
            default -> (T) chatMemberResponse;
        };
    }

    /**
     * Method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights. Use the field can_set_sticker_set optionally returned
     * in {@link #getChat} requests to check if the bot can use this method
     *
     * @param stickerSetName: name of the sticker set to be set as the group sticker set
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatstickerset">
     * setChatStickerSet</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "setChatStickerSet")
    public boolean setChatStickerSet(String stickerSetName) throws IOException {
        return setChatStickerSet(mChatId, stickerSetName);
    }

    /**
     * Method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights. Use the field can_set_sticker_set optionally returned
     * in {@link #getChat} requests to check if the bot can use this method
     *
     * @param chatId:         unique identifier for the target chat or username of the target channel
     * @param stickerSetName: name of the sticker set to be set as the group sticker set
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#setchatstickerset">
     * setChatStickerSet</a>
     */
    @RequestPath(method = POST, path = "setChatStickerSet")
    public <T> boolean setChatStickerSet(T chatId, String stickerSetName) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("sticker_set_name", stickerSetName);
        return getBooleanResponse(sendPostRequest(SET_CHAT_STICKER_SET_ENDPOINT, payload));
    }

    /**
     * Method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights. Use the field can_set_sticker_set optionally returned
     * in {@link #getChat} requests to check if the bot can use this method <br>
     * No-any params required
     *
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletechatstickerset">
     * deleteChatStickerSet</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "deleteChatStickerSet")
    public boolean deleteChatStickerSet() throws IOException {
        return deleteChatStickerSet(mChatId);
    }

    /**
     * Method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to
     * work and must have the appropriate administrator rights. Use the field can_set_sticker_set optionally returned
     * in {@link #getChat} requests to check if the bot can use this method
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
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
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deletechatstickerset">
     * deleteChatStickerSet</a>
     */
    @RequestPath(method = POST, path = "deleteChatStickerSet")
    public <T> boolean deleteChatStickerSet(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(DELETE_CHAT_STICKER_SET_ENDPOINT, createChatIdPayload(chatId,
                null)));
    }

    /**
     * Method to create a user identifier payload
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param userId: unique identifier of the target user
     * @param parameters: other request parameters
     * @return payload as {@link Params}
     */
    private <T> Params createUserPayload(T chatId, long userId, Params parameters) {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("user_id", userId);
        return parameters;
    }

}
