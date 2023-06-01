package com.tecknobit.telegrammanager.botapi.managers;

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

}
