package com.tecknobit.telegrammanager.botapi.records.basetypes.chat;

import com.tecknobit.telegrammanager.botapi.records.basetypes.Location;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code ChatLocation} class is useful to format a {@code Telegram}'s chat location
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#chatlocation">
 * ChatLocation</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class ChatLocation extends TelegramType {

    /**
     * {@code location} the location to which the supergroup is connected. Can't be a live location
     */
    private final Location location;

    /**
     * {@code address} location address; 1-64 characters, as defined by the chat owner
     */
    private final String address;

    /**
     * Constructor to init a {@link ChatLocation} object
     *
     * @param location: the location to which the supergroup is connected. Can't be a live location
     * @param address:  location address; 1-64 characters, as defined by the chat owner
     */
    public ChatLocation(Location location, String address) {
        super(null);
        this.location = location;
        this.address = address;
    }

    /**
     * Constructor to init a {@link ChatLocation} object
     *
     * @param jChatLocation: chat location details as {@link JSONObject}
     */
    public ChatLocation(JSONObject jChatLocation) {
        super(jChatLocation);
        location = new Location(hTelegram.getJSONObject("location"));
        address = hTelegram.getString("address");
    }

    /**
     * Method to get {@link #location} instance <br>
     * No-any params required
     *
     * @return {@link #location} instance as {@link Location}
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Method to get {@link #address} instance <br>
     * No-any params required
     *
     * @return {@link #address} instance as {@link String}
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link ChatLocation}
     */
    public static ChatLocation getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new ChatLocation(jItem);
    }

}
