package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.games;

import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code GameHighScore} class is useful to format a {@code Telegram}'s game highs-core
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#gamehighscore">
 * GameHighScore</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class GameHighScore extends TelegramType {

    /**
     * {@code position} in high score table for the game
     */
    private final int position;

    /**
     * {@code user} value
     */
    private final User user;

    /**
     * {@code score} value
     */
    private final int score;

    /**
     * Constructor to init a {@link GameHighScore} object
     *
     * @param position: position in high score table for the game
     * @param user:     user value
     * @param score:    score value
     */
    public GameHighScore(int position, User user, int score) {
        super(null);
        this.position = position;
        this.user = user;
        this.score = score;
    }

    /**
     * Constructor to init a {@link GameHighScore} object
     *
     * @param jGameHighScore: game highs-core details as {@link JSONObject}
     */
    public GameHighScore(JSONObject jGameHighScore) {
        super(jGameHighScore);
        position = hTelegram.getInt("position");
        user = new User(hTelegram.getJSONObject("user"));
        score = hTelegram.getInt("score");
    }

    /**
     * Method to get {@link #position} instance <br>
     * No-any params required
     *
     * @return {@link #position} instance as int
     */
    public int getPosition() {
        return position;
    }

    /**
     * Method to get {@link #user} instance <br>
     * No-any params required
     *
     * @return {@link #user} instance as {@link User}
     */
    public User getUser() {
        return user;
    }

    /**
     * Method to get {@link #score} instance <br>
     * No-any params required
     *
     * @return {@link #score} instance as int
     */
    public int getScore() {
        return score;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link GameHighScore}
     */
    public static GameHighScore getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new GameHighScore(jItem);
    }

}
