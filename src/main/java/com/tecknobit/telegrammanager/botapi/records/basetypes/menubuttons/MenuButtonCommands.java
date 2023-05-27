package com.tecknobit.telegrammanager.botapi.records.basetypes.menubuttons;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.menubuttons.MenuButtonDefault.MenuButtonType.commands;

/**
 * The {@code MenuButtonCommands} class is useful to format a {@code Telegram}'s menu button commands
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#menubuttoncommands">
 * MenuButtonCommands</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see MenuButtonDefault
 */
public class MenuButtonCommands extends MenuButtonDefault {

    /**
     * Constructor to init a {@link MenuButtonCommands} object <br>
     * No-any params required
     */
    public MenuButtonCommands() {
        super(commands);
    }

    /**
     * Constructor to init a {@link MenuButtonCommands} object
     *
     * @param jMenuButtonCommands: menu button commands details as {@link JSONObject}
     */
    public MenuButtonCommands(JSONObject jMenuButtonCommands) {
        super(jMenuButtonCommands);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link MenuButtonCommands}
     */
    public static MenuButtonCommands getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new MenuButtonCommands(jItem);
    }

}
