package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments;

import com.tecknobit.telegrammanager.botapi.records.basetypes.media.PhotoSize;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.Video;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.media.PhotoSize.returnPhotoSizes;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity.returnMessageEntities;

/**
 * The {@code Game} class is useful to format a {@code Telegram}'s game
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#game">
 * Game</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class Game extends TelegramType {

    /**
     * {@code title} of the game
     */
    private final String title;

    /**
     * {@code photo} photo that will be displayed in the game message in chats
     */
    private final ArrayList<PhotoSize> photo;

    /**
     * {@code text} brief description of the game or high scores included in the game message
     */
    private final String text;

    /**
     * {@code textEntities} special entities that appear in text, such as usernames, URLs, bot commands, etc
     */
    private final ArrayList<MessageEntity> textEntities;

    /**
     * {@code animation} animation that will be displayed in the game message in chats
     */
    private final Video animation;

    /**
     * Constructor to init a {@link Game} object
     *
     * @param title:        title of the game
     * @param photo:        photo that will be displayed in the game message in chats
     * @param text:         brief description of the game or high scores included in the game message
     * @param textEntities: special entities that appear in text, such as usernames, URLs, bot commands, etc
     * @param animation:    animation that will be displayed in the game message in chats
     */
    public Game(String title, ArrayList<PhotoSize> photo, String text, ArrayList<MessageEntity> textEntities,
                Video animation) {
        super(null);
        this.title = title;
        this.photo = photo;
        this.text = text;
        this.textEntities = textEntities;
        this.animation = animation;
    }

    /**
     * Constructor to init a {@link Game} object
     *
     * @param jGame: game details as {@link JSONObject}
     */
    public Game(JSONObject jGame) {
        super(jGame);
        title = hTelegram.getString("title");
        photo = returnPhotoSizes(hTelegram.getJSONArray("photo"));
        text = hTelegram.getString("text");
        textEntities = returnMessageEntities(hTelegram.getJSONArray("text_entities"));
        animation = Video.getInstance(hTelegram.getJSONObject("animation"));
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
     * Method to get {@link #photo} instance <br>
     * No-any params required
     *
     * @return {@link #photo} instance as {@link ArrayList} of {@link PhotoSize}
     */
    public ArrayList<PhotoSize> getPhoto() {
        return photo;
    }

    /**
     * Method to get {@link #text} instance <br>
     * No-any params required
     *
     * @return {@link #text} instance as {@link String}
     */
    public String getText() {
        return text;
    }

    /**
     * Method to get {@link #textEntities} instance <br>
     * No-any params required
     *
     * @return {@link #textEntities} instance as {@link ArrayList} of {@link MessageEntity}
     */
    public ArrayList<MessageEntity> getTextEntities() {
        return textEntities;
    }

    /**
     * Method to get {@link #animation} instance <br>
     * No-any params required
     *
     * @return {@link #animation} instance as {@link Video}
     */
    public Video getAnimation() {
        return animation;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Game}
     */
    public static Game getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Game(jItem);
    }

}
