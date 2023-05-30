package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.TelegramBotManager.ReturnFormat;
import com.tecknobit.telegrammanager.botapi.records.basetypes.parents.ProfileStructure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code User} class is useful to format a {@code Telegram}'s user
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#user">User</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see ProfileStructure
 */
public class User extends ProfileStructure {

    /**
     * {@code isBot} if this user is a bot
     */
    private final boolean isBot;

    /**
     * {@code languageCode} IETF language tag of the user's language
     */
    private final String languageCode;

    /**
     * {@code isPremium} if this user is a Telegram Premium user
     */
    private final boolean isPremium;

    /**
     * {@code addedToAttachmentMenu} if this user added the bot to the attachment menu
     */
    private final boolean addedToAttachmentMenu;

    /**
     * {@code canJoinGroups} if the bot can be invited to groups
     */
    private final boolean canJoinGroups;

    /**
     * {@code canReadAllGroupMessages} if privacy mode is disabled for the bot
     */
    private final boolean canReadAllGroupMessages;

    /**
     * {@code supportsInlineQueries} if the bot supports inline queries
     */
    private final boolean supportsInlineQueries;

    /**
     * Constructor to init a {@link User} object
     *
     * @param id:                      unique identifier for this user or bot
     * @param firstName:               user's or bot's first name
     * @param lastName:                user's or bot's last name
     * @param username:                user's or bot's username
     * @param isBot:                   if this user is a bot
     * @param languageCode:            IETF language tag of the user's language
     * @param isPremium:               if this user is a Telegram Premium user
     * @param addedToAttachmentMenu:   if this user added the bot to the attachment menu
     * @param canJoinGroups:           if the bot can be invited to groups
     * @param canReadAllGroupMessages: if the bot supports inline queries
     * @param supportsInlineQueries:   if the bot supports inline queries
     */
    public User(long id, String firstName, String lastName, String username, boolean isBot, String languageCode,
                boolean isPremium, boolean addedToAttachmentMenu, boolean canJoinGroups, boolean canReadAllGroupMessages,
                boolean supportsInlineQueries) {
        super(id, firstName, lastName, username);
        this.isBot = isBot;
        this.languageCode = languageCode;
        this.isPremium = isPremium;
        this.addedToAttachmentMenu = addedToAttachmentMenu;
        this.canJoinGroups = canJoinGroups;
        this.canReadAllGroupMessages = canReadAllGroupMessages;
        this.supportsInlineQueries = supportsInlineQueries;
    }

    /**
     * Constructor to init a {@link User} object
     *
     * @param jUser: user details as {@link JSONObject}
     */
    public User(JSONObject jUser) {
        super(jUser);
        isBot = hTelegram.getBoolean("is_bot");
        languageCode = hTelegram.getString("language_code");
        isPremium = hTelegram.getBoolean("is_premium");
        addedToAttachmentMenu = hTelegram.getBoolean("added_to_attachment_menu");
        canJoinGroups = hTelegram.getBoolean("can_join_groups");
        canReadAllGroupMessages = hTelegram.getBoolean("can_read_all_group_messages");
        supportsInlineQueries = hTelegram.getBoolean("supports_inline_queries");
    }

    /**
     * Method to get {@link #isBot} instance <br>
     * No-any params required
     *
     * @return {@link #isBot} instance as boolean
     */
    public boolean isBot() {
        return isBot;
    }

    /**
     * Method to get {@link #languageCode} instance <br>
     * No-any params required
     *
     * @return {@link #languageCode} instance as {@link String}
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Method to get {@link #isPremium} instance <br>
     * No-any params required
     *
     * @return {@link #isPremium} instance as boolean
     */
    public boolean isPremium() {
        return isPremium;
    }

    /**
     * Method to get {@link #addedToAttachmentMenu} instance <br>
     * No-any params required
     *
     * @return {@link #addedToAttachmentMenu} instance as boolean
     */
    public boolean isAddedToAttachmentMenu() {
        return addedToAttachmentMenu;
    }

    /**
     * Method to get {@link #canJoinGroups} instance <br>
     * No-any params required
     *
     * @return {@link #canJoinGroups} instance as boolean
     */
    public boolean canJoinGroups() {
        return canJoinGroups;
    }

    /**
     * Method to get {@link #canReadAllGroupMessages} instance <br>
     * No-any params required
     *
     * @return {@link #canReadAllGroupMessages} instance as boolean
     */
    public boolean canReadAllGroupMessages() {
        return canReadAllGroupMessages;
    }

    /**
     * Method to get {@link #supportsInlineQueries} instance <br>
     * No-any params required
     *
     * @return {@link #supportsInlineQueries} instance as boolean
     */
    public boolean canSupportsInlineQueries() {
        return supportsInlineQueries;
    }

    /**
     * Method to create a user
     *
     * @param userResponse: obtained from Telegram's response
     * @param format:       return type formatter -> {@link ReturnFormat}
     * @return user as {@code "format"} defines
     **/
    @Returner
    public static <T> T returnUser(String userResponse, ReturnFormat format) {
        return switch (format) {
            case JSON -> (T) new JSONObject(userResponse);
            case LIBRARY_OBJECT -> (T) new User(new JSONObject(userResponse));
            default -> (T) userResponse;
        };
    }

    /**
     * Method to return a {@link User} list
     *
     * @param jUsers: JSON source from fetch the list
     * @return users list as {@link ArrayList} of {@link User}
     */
    @Returner
    public static ArrayList<User> returnUsers(JSONArray jUsers) {
        ArrayList<User> users = new ArrayList<>();
        if (jUsers != null)
            for (int j = 0; j < jUsers.length(); j++)
                users.add(new User(jUsers.getJSONObject(j)));
        return users;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link User}
     */
    public static User getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new User(jItem);
    }

}
