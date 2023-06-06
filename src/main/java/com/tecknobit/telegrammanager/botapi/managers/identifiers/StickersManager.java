package com.tecknobit.telegrammanager.botapi.managers.identifiers;

import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.TelegramFile;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers.InputSticker;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers.MaskPosition;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers.Sticker;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers.Sticker.StickerFormat;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers.StickerSet;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.media.TelegramFile.returnFile;
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

    public Message sendSticker(String sticker) throws IOException {
        return sendSticker(mChatId, sticker, LIBRARY_OBJECT);
    }

    public <T> T sendSticker(String sticker, ReturnFormat format) throws IOException {
        return sendSticker(mChatId, sticker, format);
    }

    public <T> Message sendSticker(T chatId, String sticker) throws IOException {
        return sendSticker(chatId, sticker, LIBRARY_OBJECT);
    }

    public <T, L> T sendSticker(L chatId, String sticker, ReturnFormat format) throws IOException {
        return sendSticker(chatId, sticker, null, format);
    }

    public Message sendSticker(String sticker, Params parameters) throws IOException {
        return sendSticker(mChatId, sticker, parameters, LIBRARY_OBJECT);
    }

    public <T> T sendSticker(String sticker, Params parameters, ReturnFormat format) throws IOException {
        return sendSticker(mChatId, sticker, parameters, format);
    }

    public <T> Message sendSticker(T chatId, String sticker, Params parameters) throws IOException {
        return sendSticker(chatId, sticker, parameters, LIBRARY_OBJECT);
    }

    public <T, L> T sendSticker(L chatId, String sticker, Params parameters, ReturnFormat format) throws IOException {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("sticker", sticker);
        return returnMessage(sendPostRequest(SEND_STICKER_ENDPOINT, parameters), format);
    }

    public StickerSet getStickerSet(String name) throws IOException {
        return getStickerSet(name, LIBRARY_OBJECT);
    }

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

    public ArrayList<Sticker> getCustomEmojiStickers(String... customEmojiIds) throws IOException {
        return getCustomEmojiStickers(LIBRARY_OBJECT, customEmojiIds);
    }

    public <T> T getCustomEmojiStickers(ReturnFormat format, String... customEmojiIds) throws IOException {
        Params query = new Params();
        query.addParam("custom_emoji_ids", new JSONArray(customEmojiIds));
        return Sticker.returnStickersList(sendGetRequest(GET_CUSTOM_EMOJI_STICKERS, query), format);
    }

    public TelegramFile uploadStickerFile(User user, String sticker, StickerFormat stickerFormat) throws IOException {
        return uploadStickerFile(user.getId(), sticker, stickerFormat, LIBRARY_OBJECT);
    }

    public <T> T uploadStickerFile(User user, String sticker, StickerFormat stickerFormat,
                                   ReturnFormat format) throws IOException {
        return uploadStickerFile(user.getId(), sticker, stickerFormat, LIBRARY_OBJECT);
    }

    public TelegramFile uploadStickerFile(long userId, String sticker, StickerFormat stickerFormat) throws IOException {
        return uploadStickerFile(userId, sticker, stickerFormat, LIBRARY_OBJECT);
    }

    public <T> T uploadStickerFile(long userId, String sticker, StickerFormat stickerFormat,
                                   ReturnFormat format) throws IOException {
        Params payload = new Params();
        payload.addParam("user_id", userId);
        payload.addParam("sticker_format", stickerFormat);
        return returnFile(uploadMedia(UPLOAD_STICKER_FILE_ENDPOINT, null, "sticker", sticker, payload),
                format);
    }

    public boolean createNewStickerSet(User user, String name, String title, StickerFormat stickerFormat,
                                       InputSticker... stickers) throws IOException {
        return createNewStickerSet(user.getId(), name, title, stickerFormat, stickers);
    }

    public boolean createNewStickerSet(long userId, String name, String title, StickerFormat stickerFormat,
                                       InputSticker... stickers) throws IOException {
        return createNewStickerSet(userId, name, title, stickerFormat, null, stickers);
    }

    public boolean createNewStickerSet(User user, String name, String title, StickerFormat stickerFormat,
                                       Params parameters, InputSticker... stickers) throws IOException {
        return createNewStickerSet(user.getId(), name, title, stickerFormat, parameters, stickers);
    }

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

    public boolean addStickerToSet(User user, String name, InputSticker sticker) throws IOException {
        return addStickerToSet(user.getId(), name, sticker);
    }

    public boolean addStickerToSet(long userId, String name, InputSticker sticker) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("user_id", userId);
        payload.addParam("name", name);
        return getBooleanResponse(sendPostRequest(ADD_STICKER_TO_SET_ENDPOINT, payload));
    }

    public boolean setStickerPositionInSet(Sticker sticker, int position) throws IOException {
        return setStickerPositionInSet(sticker.getFileId(), position);
    }

    public boolean setStickerPositionInSet(String sticker, int position) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("position", position);
        return getBooleanResponse(sendPostRequest(SET_STICKER_POSITION_IN_SET_ENDPOINT, payload));
    }

    public boolean deleteStickerFromSet(Sticker sticker) throws IOException {
        return deleteStickerFromSet(sticker.getFileId());
    }

    public boolean deleteStickerFromSet(String sticker) throws IOException {
        return getBooleanResponse(sendPostRequest(DELETE_STICKER_FROM_SET_ENDPOINT, createStickerPayload(sticker)));
    }

    public boolean setStickerEmojiList(Sticker sticker, String... emojis) throws IOException {
        return setStickerEmojiList(sticker.getFileId(), emojis);
    }

    public boolean setStickerEmojiList(String sticker, String... emojis) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("emoji_list", new JSONArray(emojis));
        return getBooleanResponse(sendPostRequest(SET_STICKER_EMOJI_LIST_ENDPOINT, payload));
    }

    public boolean setStickerKeywords(Sticker sticker, String... keywords) throws IOException {
        return setStickerKeywords(sticker.getFileId(), keywords);
    }

    public boolean setStickerKeywords(String sticker, String... keywords) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("keywords", new JSONArray(keywords));
        return getBooleanResponse(sendPostRequest(SET_STICKER_KEYWORDS_ENDPOINT, payload));
    }

    public boolean setStickerMaskPosition(Sticker sticker, MaskPosition maskPosition) throws IOException {
        return setStickerMaskPosition(sticker.getFileId(), maskPosition);
    }

    public boolean setStickerMaskPosition(String sticker, MaskPosition maskPosition) throws IOException {
        Params payload = createStickerPayload(sticker);
        payload.addParam("mask_position", maskPosition);
        return getBooleanResponse(sendPostRequest(SET_STICKER_MASK_POSITION_ENDPOINT, payload));
    }

    public boolean setStickerSetTitle(StickerSet stickerSet, String title) throws IOException {
        return setStickerSetTitle(stickerSet.getName(), title);
    }

    public boolean setStickerSetTitle(String name, String title) throws IOException {
        Params payload = new Params();
        payload.addParam("name", name);
        payload.addParam("title", title);
        return getBooleanResponse(sendPostRequest(SET_STICKER_SET_TITLE_ENDPOINT, payload));
    }

    public boolean setStickerSetThumbnail(User user, StickerSet stickerSet) throws IOException {
        return setStickerSetThumbnail(user.getId(), stickerSet.getName());
    }

    public boolean setStickerSetThumbnail(User user, String name) throws IOException {
        return setStickerSetThumbnail(user.getId(), name);
    }

    public boolean setStickerSetThumbnail(long userId, StickerSet stickerSet) throws IOException {
        return setStickerSetThumbnail(userId, stickerSet.getName());
    }

    public boolean setStickerSetThumbnail(long userId, String name) throws IOException {
        return setStickerSetThumbnail(userId, name, null);
    }

    public boolean setStickerSetThumbnail(User user, StickerSet stickerSet, String thumbnail) throws IOException {
        return setStickerSetThumbnail(user.getId(), stickerSet.getName(), thumbnail);
    }

    public boolean setStickerSetThumbnail(User user, String name, String thumbnail) throws IOException {
        return setStickerSetThumbnail(user.getId(), name, thumbnail);
    }

    public boolean setStickerSetThumbnail(long userId, StickerSet stickerSet, String thumbnail) throws IOException {
        return setStickerSetThumbnail(userId, stickerSet.getName(), thumbnail);
    }

    public boolean setStickerSetThumbnail(long userId, String name, String thumbnail) throws IOException {
        Params payload = new Params();
        payload.addParam("user_id", userId);
        payload.addParam("name", name);
        if (thumbnail != null)
            payload.addParam("thumbnail", thumbnail);
        return getBooleanResponse(sendPostRequest(SET_STICKER_SET_THUMBNAIL_ENDPOINT, payload));
    }

    public boolean setCustomEmojiStickerSetThumbnail(StickerSet stickerSet) throws IOException {
        return setCustomEmojiStickerSetThumbnail(stickerSet.getName());
    }

    public boolean setCustomEmojiStickerSetThumbnail(String name) throws IOException {
        return setCustomEmojiStickerSetThumbnail(name, null);
    }

    public boolean setCustomEmojiStickerSetThumbnail(StickerSet stickerSet, String customEmojiId) throws IOException {
        return setCustomEmojiStickerSetThumbnail(stickerSet.getName(), customEmojiId);
    }

    public boolean setCustomEmojiStickerSetThumbnail(String name, String customEmojiId) throws IOException {
        Params payload = new Params();
        payload.addParam("name", name);
        if (customEmojiId != null)
            payload.addParam("custom_emoji_id", customEmojiId);
        return getBooleanResponse(sendPostRequest(SET_CUSTOM_EMOJI_STICKER_SET_THUMBNAIL_ENDPOINT, payload));
    }

    public boolean deleteStickerSet(StickerSet stickerSet) throws IOException {
        return deleteStickerSet(stickerSet.getName());
    }

    public boolean deleteStickerSet(String name) throws IOException {
        Params payload = new Params();
        payload.addParam("name", name);
        return getBooleanResponse(sendPostRequest(DELETE_STICKER_SET_ENDPOINT, payload));
    }

    private <T> Params createStickerPayload(T sticker) {
        Params payload = new Params();
        payload.addParam("sticker", sticker);
        return payload;
    }

}
