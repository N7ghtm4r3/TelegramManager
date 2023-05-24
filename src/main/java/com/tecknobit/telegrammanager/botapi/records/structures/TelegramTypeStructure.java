package com.tecknobit.telegrammanager.botapi.records.structures;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.apimanager.formatters.JsonHelper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code TelegramTypeStructure} class is useful to format a {@code Telegram}'s type structure
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#available-types">
 * Available types</a>
 */
@Structure
public abstract class TelegramTypeStructure {

    /**
     * {@code hTelegram} helper to manage the JSON responses
     */
    protected final JsonHelper hTelegram;

    /**
     * Constructor to init a {@link TelegramTypeStructure} object
     *
     * @param jTelegramTypeStructure: Telegram type structure details as {@link JSONObject}
     */
    public TelegramTypeStructure(JSONObject jTelegramTypeStructure) {
        if (jTelegramTypeStructure == null)
            hTelegram = null;
        else
            hTelegram = new JsonHelper(jTelegramTypeStructure);
    }

    /**
     * Method to fetch a {@link String}' list
     *
     * @param jList: JSON source from fetch the list
     * @return strings list as {@link ArrayList} of {@link String}
     */
    protected ArrayList<String> fetchStringsList(JSONArray jList) {
        ArrayList<String> strings = new ArrayList<>();
        if (jList != null)
            for (int j = 0; j < jList.length(); j++)
                strings.add(jList.getString(j));
        return strings;
    }

    /**
     * Returns a string representation of the object <br>
     * No-any params required
     *
     * @return a string representation of the object as {@link String}
     */
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

}
