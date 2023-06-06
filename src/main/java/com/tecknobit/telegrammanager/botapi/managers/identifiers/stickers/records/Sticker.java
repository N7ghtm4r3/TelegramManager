package com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers.records;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.MediaStructure;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.PhotoSize;
import com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.TelegramFile;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.getResultFromList;

/**
 * The {@code Sticker} class is useful to format a {@code Telegram}'s sticker
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#sticker">
 * Sticker</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MediaStructure
 * @see PhotoSize
 */
public class Sticker extends PhotoSize {

    /**
     * {@code StickerType} list of available sticker types
     */
    public enum StickerType {

        /**
         * {@code regular} sticker type
         */
        regular,

        /**
         * {@code mask} sticker type
         */
        mask,

        /**
         * {@code custom_emoji} sticker type
         */
        custom_emoji

    }

    /**
     * {@code StickerFormat} list of available sticker formats
     */
    public enum StickerFormat {

        /**
         * {@code regular} sticker format
         */
        fStatic("static"),

        /**
         * {@code mask} sticker format
         */
        animated("animated"),

        /**
         * {@code custom_emoji} sticker format
         */
        video("video");

        /**
         * {@code format} value
         */
        private final String format;

        /**
         * Constructor to init a {@link StickerFormat} object
         *
         * @param format: format value
         */
        StickerFormat(String format) {
            this.format = format;
        }

        /**
         * Returns a string representation of the object <br>
         * No-any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return format;
        }

    }

    /**
     * {@code type} of the sticker
     */
    private final StickerType type;

    /**
     * {@code isAnimated} if the sticker is animated
     */
    private final boolean isAnimated;

    /**
     * {@code isVideo} if the sticker is a video sticker
     */
    private final boolean isVideo;

    /**
     * {@code thumbnail} sticker thumbnail in the .WEBP or .JPG format
     */
    private final PhotoSize thumbnail;

    /**
     * {@code emoji} emoji associated with the sticker
     */
    private final String emoji;

    /**
     * {@code setName} name of the sticker set to which the sticker belongs
     */
    private final String setName;

    /**
     * {@code premiumAnimation} for premium regular stickers, premium animation for the sticker
     */
    private final TelegramFile premiumAnimation;

    /**
     * {@code maskPosition} for mask stickers, the position where the mask should be placed
     */
    private final MaskPosition maskPosition;

    /**
     * {@code customEmojiId} for custom emoji stickers, unique identifier of the custom emoji
     */
    private final String customEmojiId;

    /**
     * {@code needsRepainting} if the sticker must be repainted to a text color in messages, the color of the Telegram
     * Premium badge in emoji status, white color on chat photos, or another appropriate color in other places
     */
    private final boolean needsRepainting;

    /**
     * Constructor to init a {@link Sticker} object
     *
     * @param fileId:           identifier for this file
     * @param fileUniqueId:     unique identifier for this file
     * @param width:            sticker width
     * @param height:           sticker height
     * @param fileSize:         file size in bytes
     * @param type:             if the sticker is animated
     * @param isAnimated:       {@code isAnimated} of the
     * @param isVideo:          if the sticker is a video sticker
     * @param thumbnail:        sticker thumbnail in the .WEBP or .JPG format
     * @param emoji:            emoji associated with the sticker
     * @param setName:          name of the sticker set to which the sticker belongs
     * @param premiumAnimation: for premium regular stickers, premium animation for the sticker
     * @param maskPosition:     for mask stickers, the position where the mask should be placed
     * @param customEmojiId:    for custom emoji stickers, unique identifier of the custom emoji
     * @param needsRepainting:  if the sticker must be repainted to a text color in messages, the color of the Telegram
     *                          Premium badge in emoji status, white color on chat photos, or another appropriate color in other places
     */
    public Sticker(String fileId, String fileUniqueId, double width, double height, int fileSize, StickerType type,
                   boolean isAnimated, boolean isVideo, PhotoSize thumbnail, String emoji, String setName,
                   TelegramFile premiumAnimation, MaskPosition maskPosition, String customEmojiId,
                   boolean needsRepainting) {
        super(fileId, fileUniqueId, fileSize, width, height);
        this.type = type;
        this.isAnimated = isAnimated;
        this.isVideo = isVideo;
        this.thumbnail = thumbnail;
        this.emoji = emoji;
        this.setName = setName;
        this.premiumAnimation = premiumAnimation;
        this.maskPosition = maskPosition;
        this.customEmojiId = customEmojiId;
        this.needsRepainting = needsRepainting;
    }

    /**
     * Constructor to init a {@link Sticker} object
     *
     * @param jSticker: sticker details as {@link JSONObject}
     */
    public Sticker(JSONObject jSticker) {
        super(jSticker);
        type = StickerType.valueOf(hTelegram.getString("type"));
        isAnimated = hTelegram.getBoolean("is_animated");
        isVideo = hTelegram.getBoolean("is_video");
        thumbnail = PhotoSize.getInstance(hTelegram.getJSONObject("thumbnail"));
        emoji = hTelegram.getString("emoji");
        setName = hTelegram.getString("set_name");
        premiumAnimation = TelegramFile.getInstance(hTelegram.getJSONObject("premium_animation"));
        maskPosition = MaskPosition.getInstance(hTelegram.getJSONObject("mask_position"));
        customEmojiId = hTelegram.getString("custom_emoji_id");
        needsRepainting = hTelegram.getBoolean("needs_repainting");
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link StickerType}
     */
    public StickerType getType() {
        return type;
    }

    /**
     * Method to get {@link #isAnimated} instance <br>
     * No-any params required
     *
     * @return {@link #isAnimated} instance as boolean
     */
    public boolean isAnimated() {
        return isAnimated;
    }

    /**
     * Method to get {@link #isVideo} instance <br>
     * No-any params required
     *
     * @return {@link #isVideo} instance as boolean
     */
    public boolean isVideo() {
        return isVideo;
    }

    /**
     * Method to get {@link #thumbnail} instance <br>
     * No-any params required
     *
     * @return {@link #thumbnail} instance as {@link PhotoSize}
     */
    public PhotoSize getThumbnail() {
        return thumbnail;
    }

    /**
     * Method to get {@link #emoji} instance <br>
     * No-any params required
     *
     * @return {@link #emoji} instance as {@link String}
     */
    public String getEmoji() {
        return emoji;
    }

    /**
     * Method to get {@link #setName} instance <br>
     * No-any params required
     *
     * @return {@link #setName} instance as {@link String}
     */
    public String getSetName() {
        return setName;
    }

    /**
     * Method to get {@link #premiumAnimation} instance <br>
     * No-any params required
     *
     * @return {@link #premiumAnimation} instance as {@link TelegramFile}
     */
    public TelegramFile getPremiumAnimation() {
        return premiumAnimation;
    }

    /**
     * Method to get {@link #maskPosition} instance <br>
     * No-any params required
     *
     * @return {@link #maskPosition} instance as {@link MaskPosition}
     */
    public MaskPosition getMaskPosition() {
        return maskPosition;
    }

    /**
     * Method to get {@link #customEmojiId} instance <br>
     * No-any params required
     *
     * @return {@link #customEmojiId} instance as {@link String}
     */
    public String getCustomEmojiId() {
        return customEmojiId;
    }

    /**
     * Method to get {@link #needsRepainting} instance <br>
     * No-any params required
     *
     * @return {@link #needsRepainting} instance as boolean
     */
    public boolean isNeedsRepainting() {
        return needsRepainting;
    }

    /**
     * Method to create a stickers list
     *
     * @param messageResponse : obtained from Telegram's response
     * @param format          :       return type formatter -> {@link ReturnFormat}
     * @return stickers list as {@code "format"} defines
     */
    @Returner
    public static <T> T returnStickersList(String messageResponse, ReturnFormat format) {
        JSONArray result = getResultFromList(messageResponse);
        return switch (format) {
            case JSON -> (T) result;
            case LIBRARY_OBJECT -> {
                ArrayList<Sticker> stickers = new ArrayList<>();
                for (int j = 0; j < result.length(); j++)
                    stickers.add(new Sticker(result.getJSONObject(j)));
                yield (T) stickers;
            }
            default -> (T) result.toString();
        };
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Sticker}
     */
    public static Sticker getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Sticker(jItem);
    }

}
