package com.tecknobit.telegrammanager.botapi.managers;

import com.tecknobit.apimanager.annotations.Returner;
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

import static com.tecknobit.telegrammanager.botapi.managers.TelegramBotManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code ChatManager} class is useful to create a {@code Telegram}'s bot chat manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#available-methods">
 * Available methods</a>
 */
public class ChatManager extends TelegramBotManager {

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
    public ChatManager() throws Exception {
        super();
    }

    public UserProfilePhotos getUserProfilePhotos(User user) throws IOException {
        return getUserProfilePhotos(user.getId(), LIBRARY_OBJECT);
    }

    public <T> T getUserProfilePhotos(User user, ReturnFormat format) throws IOException {
        return getUserProfilePhotos(user.getId(), format);
    }

    public UserProfilePhotos getUserProfilePhotos(long userId) throws IOException {
        return getUserProfilePhotos(userId, LIBRARY_OBJECT);
    }

    public <T> T getUserProfilePhotos(long userId, ReturnFormat format) throws IOException {
        return getUserProfilePhotos(userId, null, format);
    }

    public UserProfilePhotos getUserProfilePhotos(User user, Params parameters) throws IOException {
        return getUserProfilePhotos(user.getId(), parameters, LIBRARY_OBJECT);
    }

    public <T> T getUserProfilePhotos(User user, Params parameters, ReturnFormat format) throws IOException {
        return getUserProfilePhotos(user.getId(), parameters, format);
    }

    public UserProfilePhotos getUserProfilePhotos(long userId, Params parameters) throws IOException {
        return getUserProfilePhotos(userId, parameters, LIBRARY_OBJECT);
    }

    public <T> T getUserProfilePhotos(long userId, Params parameters, ReturnFormat format) throws IOException {
        String profileResponse = sendGetRequest(GET_USER_PROFILE_PHOTOS_ENDPOINT, createUserPayload(null, userId,
                parameters));
        return switch (format) {
            case JSON -> (T) new JSONObject(profileResponse);
            case LIBRARY_OBJECT -> (T) new UserProfilePhotos(new JSONObject(profileResponse));
            default -> (T) profileResponse;
        };
    }

    public TelegramFile getFile(String fileId) throws IOException {
        return getFile(fileId, LIBRARY_OBJECT);
    }

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

    public <T> boolean banChatMember(T chatId, User user) throws IOException {
        return banChatMember(chatId, user.getId());
    }

    public <T> boolean banChatMember(T chatId, long userId) throws IOException {
        return banChatMember(chatId, userId, null);
    }

    public <T> boolean banChatMember(T chatId, User user, Params parameters) throws IOException {
        return banChatMember(chatId, user.getId(), null);
    }

    public <T> boolean banChatMember(T chatId, long userId, Params parameters) throws IOException {
        return getBooleanResponse(sendPostRequest(BAN_CHAT_MEMBER_ENDPOINT, createUserPayload(chatId, userId,
                parameters)));
    }

    public <T> boolean unbanChatMember(T chatId, User user, boolean onlyIfBanned) throws IOException {
        return unbanChatMember(chatId, user.getId(), onlyIfBanned);
    }

    public <T> boolean unbanChatMember(T chatId, long userId, boolean onlyIfBanned) throws IOException {
        Params payload = createUserPayload(chatId, userId, null);
        payload.addParam("only_if_banned", onlyIfBanned);
        return getBooleanResponse(sendPostRequest(UNBAN_CHAT_MEMBER_ENDPOINT, createUserPayload(chatId, userId,
                payload)));
    }

    public <T> boolean restrictChatMember(T chatId, User user, ChatPermissions chatPermissions) throws IOException {
        return restrictChatMember(chatId, user.getId(), chatPermissions);
    }

    public <T> boolean restrictChatMember(T chatId, long userId, ChatPermissions chatPermissions) throws IOException {
        return restrictChatMember(chatId, userId, chatPermissions, null);
    }

    public <T> boolean restrictChatMember(T chatId, User user, ChatPermissions chatPermissions,
                                          Params parameters) throws IOException {
        return restrictChatMember(chatId, user.getId(), chatPermissions, parameters);
    }

    public <T> boolean restrictChatMember(T chatId, long userId, ChatPermissions chatPermissions,
                                          Params parameters) throws IOException {
        parameters = createUserPayload(chatId, userId, parameters);
        parameters.addParam("permissions", chatPermissions);
        return getBooleanResponse(sendPostRequest(RESTRICT_CHAT_MEMBER_ENDPOINT, createUserPayload(chatId, userId,
                parameters)));
    }

    public <T> boolean promoteChatMember(T chatId, User user, Params parameters) throws IOException {
        return promoteChatMember(chatId, user.getId(), parameters);
    }

    public <T> boolean promoteChatMember(T chatId, long userId, Params parameters) throws IOException {
        return getBooleanResponse(sendPostRequest(PROMOTE_CHAT_MEMBER_ENDPOINT, createUserPayload(chatId, userId,
                parameters)));
    }

    public <T> boolean setChatAdministratorCustomTitle(T chatId, User user, String customTitle) throws IOException {
        return setChatAdministratorCustomTitle(chatId, user.getId(), customTitle);
    }

    public <T> boolean setChatAdministratorCustomTitle(T chatId, long userId, String customTitle) throws IOException {
        Params payload = createUserPayload(chatId, userId, null);
        payload.addParam("custom_title", customTitle);
        return getBooleanResponse(sendPostRequest(SET_CHAT_ADMINISTRATOR_CUSTOM_TITLE_ENDPOINT, createUserPayload(chatId,
                userId, payload)));
    }

    public <T> boolean banChatSenderChat(T chatId, long senderChatId) throws IOException {
        return workOnSenderChat(chatId, senderChatId, BAN_CHAT_SENDER_CHAT_ENDPOINT);
    }

    public <T> boolean unbanChatSenderChat(T chatId, long senderChatId) throws IOException {
        return workOnSenderChat(chatId, senderChatId, UNBAN_CHAT_SENDER_CHAT_ENDPOINT);
    }

    private <T> boolean workOnSenderChat(T chatId, long senderChatId, String endpoint) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("sender_chat_id", senderChatId);
        return getBooleanResponse(sendPostRequest(endpoint, payload));
    }

    public <T> boolean setChatPermissions(T chatId, User user, ChatPermissions chatPermissions,
                                          boolean useIndependentChatPermissions) throws IOException {
        return setChatPermissions(chatId, user.getId(), chatPermissions, useIndependentChatPermissions);
    }

    public <T> boolean setChatPermissions(T chatId, long userId, ChatPermissions chatPermissions,
                                          boolean useIndependentChatPermissions) throws IOException {
        Params payload = createUserPayload(chatId, userId, null);
        payload.addParam("permissions", chatPermissions);
        payload.addParam("use_independent_chat_permissions", useIndependentChatPermissions);
        return getBooleanResponse(sendPostRequest(SET_CHAT_PERMISSIONS_ENDPOINT, createUserPayload(chatId, userId,
                payload)));
    }

    public <T> String exportChatInviteLink(T chatId) throws IOException {
        return exportChatInviteLink(chatId, LIBRARY_OBJECT);
    }

    public <T, L> T exportChatInviteLink(L chatId, ReturnFormat format) throws IOException {
        JSONObject exportResponse = new JSONObject(sendPostRequest(EXPORT_CHAT_INVITE_LINK_ENDPOINT,
                createChatIdPayload(chatId, null)));
        return switch (format) {
            case JSON -> (T) exportResponse;
            case LIBRARY_OBJECT -> (T) exportResponse.getString("result");
            default -> (T) exportResponse.toString();
        };
    }

    public <T> ChatInviteLink createChatInviteLink(T chatId) throws IOException {
        return createChatInviteLink(chatId, LIBRARY_OBJECT);
    }

    public <T, L> T createChatInviteLink(L chatId, ReturnFormat format) throws IOException {
        return createChatInviteLink(chatId, null, format);
    }

    public <T> ChatInviteLink createChatInviteLink(T chatId, Params parameters) throws IOException {
        return createChatInviteLink(chatId, parameters, LIBRARY_OBJECT);
    }

    public <T, L> T createChatInviteLink(L chatId, Params parameters, ReturnFormat format) throws IOException {
        return returnChatInviteLink(sendPostRequest(CREATE_CHAT_INVITE_LINK_ENDPOINT, createChatIdPayload(chatId,
                parameters)), format);
    }

    public <T> ChatInviteLink editChatInviteLink(T chatId, ChatInviteLink inviteLink, Params parameters) throws IOException {
        return editChatInviteLink(chatId, inviteLink.getInviteLink(), parameters, LIBRARY_OBJECT);
    }

    public <T> T editChatInviteLink(T chatId, ChatInviteLink inviteLink, Params parameters,
                                    ReturnFormat format) throws IOException {
        return editChatInviteLink(chatId, inviteLink.getInviteLink(), parameters, format);
    }

    public <T> ChatInviteLink editChatInviteLink(T chatId, String inviteLink, Params parameters) throws IOException {
        return editChatInviteLink(chatId, inviteLink, parameters, LIBRARY_OBJECT);
    }

    public <T, L> T editChatInviteLink(L chatId, String inviteLink, Params parameters,
                                       ReturnFormat format) throws IOException {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("invite_link", inviteLink);
        return returnChatInviteLink(sendPostRequest(EDIT_CHAT_INVITE_LINK_ENDPOINT, parameters), format);
    }

    public <T> ChatInviteLink revokeChatInviteLink(T chatId, ChatInviteLink inviteLink) throws IOException {
        return revokeChatInviteLink(chatId, inviteLink.getInviteLink(), LIBRARY_OBJECT);
    }

    public <T, L> T revokeChatInviteLink(L chatId, ChatInviteLink inviteLink, ReturnFormat format) throws IOException {
        return revokeChatInviteLink(chatId, inviteLink.getInviteLink(), format);
    }

    public <T> ChatInviteLink revokeChatInviteLink(T chatId, String inviteLink) throws IOException {
        return revokeChatInviteLink(chatId, inviteLink, LIBRARY_OBJECT);
    }

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

    public <T> boolean approveChatJoinRequest(T chatId, User user) throws IOException {
        return approveChatJoinRequest(chatId, user.getId());
    }

    public <T> boolean approveChatJoinRequest(T chatId, long userId) throws IOException {
        return getBooleanResponse(sendPostRequest(APPROVE_CHAT_JOIN_REQUEST_ENDPOINT, createUserPayload(chatId, userId,
                null)));
    }

    public <T> boolean declineChatJoinRequest(T chatId, User user) throws IOException {
        return declineChatJoinRequest(chatId, user.getId());
    }

    public <T> boolean declineChatJoinRequest(T chatId, long userId) throws IOException {
        return getBooleanResponse(sendPostRequest(DECLINE_CHAT_JOIN_REQUEST_ENDPOINT, createUserPayload(chatId, userId,
                null)));
    }

    // TODO: 02/06/2023 TO REVIEW
    public <T> boolean setChatPhoto(T chatId, String photo) throws IOException {
        return getBooleanResponse(uploadMedia(SET_CHAT_PHOTO_ENDPOINT, chatId, InputMediaType.photo, photo, null));
    }

    public <T> boolean deleteChatPhoto(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(DELETE_CHAT_PHOTO_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    public <T> boolean setChatTitle(T chatId, String title) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("title", title);
        return getBooleanResponse(sendPostRequest(SET_CHAT_TITLE_ENDPOINT, payload));
    }

    public <T> boolean setChatDescription(T chatId) throws IOException {
        return setChatDescription(chatId, "");
    }

    public <T> boolean setChatDescription(T chatId, String description) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        if (!description.isBlank())
            payload.addParam("description", description);
        return getBooleanResponse(sendPostRequest(SET_CHAT_DESCRIPTION_ENDPOINT, payload));
    }

    public <T> boolean pinChatMessage(T chatId, Message message, boolean disableNotification) throws IOException {
        return pinChatMessage(chatId, message.getMessageId(), disableNotification);
    }

    public <T> boolean pinChatMessage(T chatId, long messageId, boolean disableNotification) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("message_id", messageId);
        payload.addParam("disable_notification", disableNotification);
        return getBooleanResponse(sendPostRequest(PIN_CHAT_MESSAGE_ENDPOINT, payload));
    }

    public <T> boolean unpinChatMessage(T chatId) throws IOException {
        return unpinChatMessage(chatId, -1);
    }

    public <T> boolean unpinChatMessage(T chatId, Message message) throws IOException {
        return unpinChatMessage(chatId, message.getMessageId());
    }

    public <T> boolean unpinChatMessage(T chatId, long messageId) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        if (messageId != -1)
            payload.addParam("message_id", messageId);
        return getBooleanResponse(sendPostRequest(UNPIN_CHAT_MESSAGE_ENDPOINT, payload));
    }

    public <T> boolean unpinAllChatMessages(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(UNPIN_ALL_CHAT_MESSAGES_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    public <T> boolean leaveChat(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(LEAVE_CHAT_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    public <T> Chat getChat(T chatId) throws IOException {
        return getChat(chatId, LIBRARY_OBJECT);
    }

    public <T, L> T getChat(L chatId, ReturnFormat format) throws IOException {
        String chatResponse = sendGetRequest(GET_CHAT_ENDPOINT, createChatIdPayload(chatId, null));
        return switch (format) {
            case JSON -> (T) new JSONObject(chatResponse);
            case LIBRARY_OBJECT -> (T) new Chat(new JSONObject(chatResponse));
            default -> (T) chatResponse;
        };
    }

    /**
     * Method to create a chat member
     *
     * @param chatMemberResponse : obtained from Telegram's response
     * @param format             :       return type formatter -> {@link ReturnFormat}
     * @return chat member as {@code "format"} defines
     */
    @Returner
    private <T> T returnChatMember(String chatMemberResponse, ReturnFormat format) {
        return switch (format) {
            case JSON -> (T) new JSONObject(chatMemberResponse);
            case LIBRARY_OBJECT -> (T) new ChatMember(new JSONObject(chatMemberResponse));
            default -> (T) chatMemberResponse;
        };
    }

    /**
     * Method to create a chat members list
     *
     * @param chatMembersResponse : obtained from Telegram's response
     * @param format              :       return type formatter -> {@link ReturnFormat}
     * @return chat members list as {@code "format"} defines
     */
    @Returner
    private <T> T returnChatMembers(String chatMembersResponse, ReturnFormat format) {
        JSONArray result = getResultFromList(chatMembersResponse);
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

    private <T> Params createUserPayload(T chatId, long userId, Params parameters) {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("user_id", userId);
        return parameters;
    }

}
