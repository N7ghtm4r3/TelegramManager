package com.tecknobit.telegrammanager.botapi.records.basetypes.message;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.basetypes.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code MessageEntity} class is useful to format a {@code Telegram}'s message entity
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#messageentity">
 * MessageEntity</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class MessageEntity extends TelegramType {

    /**
     * {@code MessageEntityType} list of available message entity types
     */
    public enum MessageEntityType {

        /**
         * {@code mention} message entity type
         */
        mention,

        /**
         * {@code hashtag} message entity type
         */
        hashtag,

        /**
         * {@code cashtag} message entity type
         */
        cashtag,

        /**
         * {@code bot_command} message entity type
         */
        bot_command,

        /**
         * {@code url} message entity type
         */
        url,

        /**
         * {@code email} message entity type
         */
        email,

        /**
         * {@code phone_number} message entity type
         */
        phone_number,

        /**
         * {@code bold} message entity type
         */
        bold,

        /**
         * {@code italic} message entity type
         */
        italic,

        /**
         * {@code underline} message entity type
         */
        underline,

        /**
         * {@code strikethrough} message entity type
         */
        strikethrough,

        /**
         * {@code spoiler} message entity type
         */
        spoiler,

        /**
         * {@code code} message entity type
         */
        code,

        /**
         * {@code pre} message entity type
         */
        pre,

        /**
         * {@code text_link} message entity type
         */
        text_link,

        /**
         * {@code text_mention} message entity type
         */
        text_mention,

        /**
         * {@code custom_emoji} message entity type
         */
        custom_emoji

    }

    /**
     * {@code type} of the entity
     */
    private final MessageEntityType type;

    /**
     * {@code offset} in UTF-16 code units to the start of the entity
     */
    private final int offset;

    /**
     * {@code length} of the entity in UTF-16 code units
     */
    private final int length;

    /**
     * {@code url} for {@code "text_link"} only, URL that will be opened after user taps on the text
     */
    private final String url;

    /**
     * {@code user} for {@code "text_mention"} only, the mentioned user
     */
    private final User user;

    /**
     * {@code language} for {@code "pre"} only, the programming language of the entity text
     */
    private final String language;

    /**
     * {@code customEmojiId} for {@code "custom_emoji"} only, unique identifier of the custom emoji
     */
    private final String customEmojiId;

    /**
     * Constructor to init a {@link MessageEntity} object
     *
     * @param type:          type of the entity
     * @param offset:        offset in UTF-16 code units to the start of the entity
     * @param length:        length of the entity in UTF-16 code units
     * @param url:           url for {@code "text_link"} only, URL that will be opened after user taps on the text
     * @param user:          user for {@code "text_mention"} only, the mentioned user
     * @param language:      for {@code "pre"} only, the programming language of the entity text
     * @param customEmojiId: for {@code "custom_emoji"} only, unique identifier of the custom emoji
     */
    public MessageEntity(MessageEntityType type, int offset, int length, String url, User user, String language,
                         String customEmojiId) {
        super(null);
        this.type = type;
        this.offset = offset;
        this.length = length;
        this.url = url;
        this.user = user;
        this.language = language;
        this.customEmojiId = customEmojiId;
    }

    /**
     * Constructor to init a {@link MessageEntity} object
     *
     * @param jMessageEntity: message entity details as {@link JSONObject}
     */
    public MessageEntity(JSONObject jMessageEntity) {
        super(jMessageEntity);
        type = MessageEntityType.valueOf(hTelegram.getString("type"));
        offset = hTelegram.getInt("offset");
        length = hTelegram.getInt("length");
        url = hTelegram.getString("url");
        user = User.getInstance(hTelegram.getJSONObject("user"));
        language = hTelegram.getString("language");
        customEmojiId = hTelegram.getString("custom_emoji_id");
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link MessageEntityType}
     */
    public MessageEntityType getType() {
        return type;
    }

    /**
     * Method to get {@link #offset} instance <br>
     * No-any params required
     *
     * @return {@link #offset} instance as int
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Method to get {@link #length} instance <br>
     * No-any params required
     *
     * @return {@link #length} instance as int
     */
    public int getLength() {
        return length;
    }

    /**
     * Method to get {@link #url} instance <br>
     * No-any params required
     *
     * @return {@link #url} instance as {@link String}
     */
    public String getUrl() {
        return url;
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
     * Method to get {@link #language} instance <br>
     * No-any params required
     *
     * @return {@link #language} instance as {@link String}
     */
    public String getLanguage() {
        return language;
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
     * Method to return a {@link MessageEntity} list
     *
     * @param jMessageEntities: JSON source from fetch the list
     * @return message entities list as {@link ArrayList} of {@link MessageEntity}
     */
    @Returner
    public static ArrayList<MessageEntity> returnMessageEntities(JSONArray jMessageEntities) {
        ArrayList<MessageEntity> messageEntities = new ArrayList<>();
        if (jMessageEntities != null)
            for (int j = 0; j < jMessageEntities.length(); j++)
                messageEntities.add(new MessageEntity(jMessageEntities.getJSONObject(j)));
        return messageEntities;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link MessageEntity}
     */
    public static MessageEntity getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new MessageEntity(jItem);
    }

}
