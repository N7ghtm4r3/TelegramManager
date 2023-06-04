package com.tecknobit.telegrammanager.botapi.records.basetypes.forum;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ForumTopicCreated} class is useful to format a {@code Telegram}'s forum topic created
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#forumtopiccreated">
 * ForumTopicCreated</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ForumTopicEdited
 */
public class ForumTopicCreated extends ForumTopicEdited {

    /**
     * {@code TopicIconColor} list of available topic icon colors
     */
    public enum TopicIconColor {

        /**
         * {@code blue} topic icon color
         */
        blue(0x6FB9F0),

        /**
         * {@code orange} topic icon color
         */
        orange(0xFFD67E),

        /**
         * {@code purple} topic icon color
         */
        purple(0xCB86DB),

        /**
         * {@code green} topic icon color
         */
        green(0x8EEE98),

        /**
         * {@code pink} topic icon color
         */
        pink(0xFF93B2),

        /**
         * {@code red} topic icon color
         */
        red(0xFB6F5F);

        /**
         * {@code color} topic icon color value
         */
        private final int color;

        /**
         * Constructor to init a {@link TopicIconColor} object
         *
         * @param color: topic icon color value
         */
        TopicIconColor(int color) {
            this.color = color;
        }

        /**
         * Returns a string representation of the object <br>
         * No-any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return "" + color;
        }

    }

    /**
     * {@code iconColor} color of the topic icon in RGB format
     */
    protected final int iconColor;

    /**
     * Constructor to init a {@link ForumTopicCreated} object
     *
     * @param name:              color of the topic icon in RGB format
     * @param iconCustomEmojiId: new identifier of the custom emoji shown as the topic icon, if it was edited; an empty
     *                           string if the icon was removed
     * @param iconColor:         color of the topic icon in RGB format
     */
    public ForumTopicCreated(String name, String iconCustomEmojiId, int iconColor) {
        super(name, iconCustomEmojiId);
        this.iconColor = iconColor;
    }

    /**
     * Constructor to init a {@link ForumTopicCreated} object
     *
     * @param jForumTopicCreated: forum topic created details as {@link JSONObject}
     */
    public ForumTopicCreated(JSONObject jForumTopicCreated) {
        super(jForumTopicCreated);
        iconColor = hTelegram.getInt("icon_color");
    }

    /**
     * Method to get {@link #iconColor} instance <br>
     * No-any params required
     *
     * @return {@link #iconColor} instance as int
     */
    public int getIconColor() {
        return iconColor;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ForumTopicCreated}
     */
    public static ForumTopicCreated getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ForumTopicCreated(jItem);
    }

}
