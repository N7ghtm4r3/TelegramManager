package com.tecknobit.telegrammanager.botapi.records.basetypes.menubuttons;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.menubuttons.MenuButtonDefault.MenuButtonType.vDefault;

/**
 * The {@code MenuButtonDefault} class is useful to format a {@code Telegram}'s menu button default
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#menubuttondefault">
 * MenuButtonDefault</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class MenuButtonDefault extends TelegramType {

    /**
     * {@code MenuButtonType} list of available button types
     */
    public enum MenuButtonType {

        /**
         * {@code vDefault} button type
         */
        vDefault("default"),

        /**
         * {@code web_app} button type
         */
        web_app("web_app"),

        /**
         * {@code commands} button type
         */
        commands("commands");

        /**
         * {@code type} value
         */
        private final String type;

        /**
         * Constructor to init a {@link MenuButtonType} object
         *
         * @param type: type value
         */
        MenuButtonType(String type) {
            this.type = type;
        }

        /**
         * Returns a string representation of the object <br>
         * No-any params required
         *
         * @return a string representation of the object as {@link String}
         */
        @Override
        public String toString() {
            return type;
        }

    }

    /**
     * {@code type} of the button
     */
    protected final MenuButtonType type;

    /**
     * Constructor to init a {@link MenuButtonDefault} object
     */
    public MenuButtonDefault() {
        this(vDefault);
    }

    /**
     * Constructor to init a {@link MenuButtonDefault} object
     *
     * @param type: type of the button
     */
    public MenuButtonDefault(MenuButtonType type) {
        super(null);
        this.type = type;
    }

    /**
     * Constructor to init a {@link MenuButtonDefault} object
     *
     * @param jMenuButtonDefault: menu button default details as {@link JSONObject}
     */
    public MenuButtonDefault(JSONObject jMenuButtonDefault) {
        super(jMenuButtonDefault);
        type = MenuButtonType.valueOf(hTelegram.getString("type"));
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link MenuButtonType}
     */
    public MenuButtonType getType() {
        return type;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link MenuButtonDefault}
     */
    public static MenuButtonDefault getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new MenuButtonDefault(jItem);
    }

}
