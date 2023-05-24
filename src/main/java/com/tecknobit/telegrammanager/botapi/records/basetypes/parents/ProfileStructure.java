package com.tecknobit.telegrammanager.botapi.records.basetypes.parents;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ProfileStructure} class is useful to format a {@code Telegram}'s profile structure
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at:
 * <ul>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#user">User</a>
 *     </li>
 *     <li>
 *         <a href="https://core.telegram.org/bots/api#chat">Chat</a>
 *     </li>
 * </ul>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
@Structure
public abstract class ProfileStructure extends TelegramType {

    /**
     * {@code id} of the profile
     */
    protected final long id;

    /**
     * {@code firstName} first name of the profile
     */
    protected final String firstName;

    /**
     * {@code lastName} last name of the profile
     */
    protected final String lastName;

    /**
     * {@code username} of the profile
     */
    protected final String username;

    /**
     * Constructor to init a {@link ProfileStructure} object
     *
     * @param id:        id of the profile
     * @param firstName: first name of the profile
     * @param lastName:  last name of the profile
     * @param username:  username of the profile
     */
    public ProfileStructure(long id, String firstName, String lastName, String username) {
        super(null);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    /**
     * Constructor to init a {@link ProfileStructure} object
     *
     * @param jProfileStructure: profile structure details as {@link JSONObject}
     */
    public ProfileStructure(JSONObject jProfileStructure) {
        super(jProfileStructure);
        id = hTelegram.getLong("id");
        firstName = hTelegram.getString("first_name");
        lastName = hTelegram.getString("last_name");
        username = hTelegram.getString("username");
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as long
     */
    public long getId() {
        return id;
    }

    /**
     * Method to get {@link #firstName} instance <br>
     * No-any params required
     *
     * @return {@link #firstName} instance as {@link String}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to get {@link #lastName} instance <br>
     * No-any params required
     *
     * @return {@link #lastName} instance as {@link String}
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method to get {@link #username} instance <br>
     * No-any params required
     *
     * @return {@link #username} instance as {@link String}
     */
    public String getUsername() {
        return username;
    }

}
