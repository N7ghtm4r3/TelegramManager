package com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers;

import com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers.Sticker.StickerType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code InputSticker} class is useful to format a {@code Telegram}'s input sticker
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inputsticker">
 * InputSticker</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class InputSticker extends TelegramType {

    /**
     * {@code sticker} the added sticker
     */
    private final String sticker;

    /**
     * {@code emojiList} list of 1-20 emoji associated with the sticker
     */
    private final ArrayList<String> emojiList;

    /**
     * {@code maskPosition} position where the mask should be placed on faces. For {@link StickerType#mask} stickers only
     */
    private final MaskPosition maskPosition;

    /**
     * {@code keywords} list of 0-20 search keywords for the sticker with total length of up to 64 characters.
     * For {@link StickerType#regular} and {@link StickerType#custom_emoji} stickers only
     */
    private final ArrayList<String> keywords;

    /**
     * Constructor to init a {@link InputSticker} object
     *
     * @param sticker:the added sticker
     * @param emojiList:  list of 1-20 emoji associated with the sticker
     * @apiNote this constructor is useful when you need to pass this class as parameter for the requests
     */
    public InputSticker(String sticker, ArrayList<String> emojiList) {
        this(sticker, emojiList, null, null);
    }

    /**
     * Constructor to init a {@link InputSticker} object
     *
     * @param sticker:the   added sticker
     * @param emojiList:    list of 1-20 emoji associated with the sticker
     * @param maskPosition: position where the mask should be placed on faces. For {@link StickerType#mask} stickers only
     * @apiNote this constructor is useful when you need to pass this class as parameter for the requests
     */
    public InputSticker(String sticker, ArrayList<String> emojiList, MaskPosition maskPosition) {
        this(sticker, emojiList, maskPosition, null);
    }

    /**
     * Constructor to init a {@link InputSticker} object
     *
     * @param sticker:the added sticker
     * @param emojiList:  list of 1-20 emoji associated with the sticker
     * @param keywords:   list of 0-20 search keywords for the sticker with total length of up to 64 characters.
     *                    For {@link StickerType#regular} and {@link StickerType#custom_emoji} stickers only
     * @apiNote this constructor is useful when you need to pass this class as parameter for the requests
     */
    public InputSticker(String sticker, ArrayList<String> emojiList, ArrayList<String> keywords) {
        this(sticker, emojiList, null, keywords);
    }

    /**
     * Constructor to init a {@link InputSticker} object
     *
     * @param sticker:the   added sticker
     * @param emojiList:    list of 1-20 emoji associated with the sticker
     * @param maskPosition: position where the mask should be placed on faces. For {@link StickerType#mask} stickers only
     * @param keywords:     list of 0-20 search keywords for the sticker with total length of up to 64 characters.
     *                      For {@link StickerType#regular} and {@link StickerType#custom_emoji} stickers only
     */
    public InputSticker(String sticker, ArrayList<String> emojiList, MaskPosition maskPosition,
                        ArrayList<String> keywords) {
        super(null);
        this.sticker = sticker;
        this.emojiList = emojiList;
        this.maskPosition = maskPosition;
        this.keywords = keywords;
    }

    /**
     * Constructor to init a {@link InputSticker} object
     *
     * @param jInputSticker: input sticker details as {@link JSONObject}
     */
    public InputSticker(JSONObject jInputSticker) {
        super(jInputSticker);
        sticker = hTelegram.getString("sticker");
        emojiList = fetchStringsList(hTelegram.getJSONArray("emoji_list"));
        maskPosition = MaskPosition.getInstance(hTelegram.getJSONObject("mask_position"));
        keywords = fetchStringsList(hTelegram.getJSONArray("keywords"));
    }

    /**
     * Method to get {@link #sticker} instance <br>
     * No-any params required
     *
     * @return {@link #sticker} instance as {@link String}
     */
    public String getSticker() {
        return sticker;
    }

    /**
     * Method to get {@link #emojiList} instance <br>
     * No-any params required
     *
     * @return {@link #emojiList} instance as {@link ArrayList} of {@link String}
     */
    public ArrayList<String> getEmojiList() {
        return emojiList;
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
     * Method to get {@link #keywords} instance <br>
     * No-any params required
     *
     * @return {@link #keywords} instance as {@link ArrayList} of {@link String}
     */
    public ArrayList<String> getKeywords() {
        return keywords;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InputSticker}
     */
    public static InputSticker getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InputSticker(jItem);
    }

}
