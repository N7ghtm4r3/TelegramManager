package com.tecknobit.telegrammanager.botapi.managers.identifiers.stickers.records;

import com.tecknobit.telegrammanager.botapi.managers.identifiers.content.records.PhotoSize;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code StickerSet} class is useful to format a {@code Telegram}'s sticker set
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#stickerset">
 * StickerSet</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class StickerSet extends TelegramType {

    /**
     * {@code name} sticker set name
     */
    private final String name;

    /**
     * {@code title} sticker set title
     */
    private final String title;

    /**
     * {@code stickerType} type of stickers in the set
     */
    private final Sticker.StickerType stickerType;

    /**
     * {@code isAnimated} if the sticker set contains animated stickers
     */
    private final boolean isAnimated;

    /**
     * {@code isVideo} if the sticker set contains video stickers
     */
    private final boolean isVideo;

    /**
     * {@code stickers} list of all set stickers
     */
    private final ArrayList<Sticker> stickers;

    /**
     * {@code thumbnail} sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
     */
    private final PhotoSize thumbnail;

    /**
     * Constructor to init a {@link StickerSet} object
     *
     * @param name:        sticker set name
     * @param title:       sticker set title
     * @param stickerType: type of stickers in the set
     * @param isAnimated:  if the sticker set contains animated stickers
     * @param isVideo:     if the sticker set contains video stickers
     * @param stickers:    list of all set stickers
     * @param thumbnail:   sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
     */
    public StickerSet(String name, String title, Sticker.StickerType stickerType, boolean isAnimated, boolean isVideo,
                      ArrayList<Sticker> stickers, PhotoSize thumbnail) {
        super(null);
        this.name = name;
        this.title = title;
        this.stickerType = stickerType;
        this.isAnimated = isAnimated;
        this.isVideo = isVideo;
        this.stickers = stickers;
        this.thumbnail = thumbnail;
    }

    /**
     * Constructor to init a {@link StickerSet} object
     *
     * @param jStickerSet: sticker set details as {@link JSONObject}
     */
    public StickerSet(JSONObject jStickerSet) {
        super(jStickerSet);
        name = hTelegram.getString("name");
        title = hTelegram.getString("title");
        stickerType = Sticker.StickerType.valueOf(hTelegram.getString("sticker_type"));
        isAnimated = hTelegram.getBoolean("is_animated");
        isVideo = hTelegram.getBoolean("is_video");
        stickers = new ArrayList<>();
        for (Object jSticker : hTelegram.fetchList("stickers", new ArrayList<>()))
            stickers.add(new Sticker((JSONObject) jSticker));
        thumbnail = PhotoSize.getInstance(hTelegram.getJSONObject("thumbnail"));
    }

    /**
     * Method to get {@link #name} instance <br>
     * No-any params required
     *
     * @return {@link #name} instance as {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get {@link #title} instance <br>
     * No-any params required
     *
     * @return {@link #title} instance as {@link String}
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to get {@link #stickerType} instance <br>
     * No-any params required
     *
     * @return {@link #stickerType} instance as {@link Sticker.StickerType}
     */
    public Sticker.StickerType getStickerType() {
        return stickerType;
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
     * Method to get {@link #stickers} instance <br>
     * No-any params required
     *
     * @return {@link #stickers} instance as {@link ArrayList} of {@link Sticker}
     */
    public ArrayList<Sticker> getStickers() {
        return stickers;
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
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link StickerSet}
     */
    public static StickerSet getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new StickerSet(jItem);
    }

}
