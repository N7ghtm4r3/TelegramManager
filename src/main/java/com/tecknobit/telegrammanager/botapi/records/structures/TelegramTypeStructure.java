package com.tecknobit.telegrammanager.botapi.records.structures;

import com.tecknobit.apimanager.annotations.Structure;
import com.tecknobit.apimanager.formatters.JsonHelper;
import com.tecknobit.apimanager.formatters.TimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

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
     * {@code useSnakeNotation} whether use the snake-case annotation
     *
     * @apiNote this instance will set on {@code "true"} only when you instantiate any {@link TelegramTypeStructure}
     * with no-JSON constructor but with the normal parameters' constructor, so with the library's workflow will be ever
     * set on {@code "false"}
     */
    protected final boolean useSnakeNotation;

    /**
     * Constructor to init a {@link TelegramTypeStructure} object
     *
     * @param jTelegramTypeStructure: Telegram type structure details as {@link JSONObject}
     */
    public TelegramTypeStructure(JSONObject jTelegramTypeStructure) {
        if (jTelegramTypeStructure == null) {
            jTelegramTypeStructure = new JSONObject();
            useSnakeNotation = true;
        } else
            useSnakeNotation = false;
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
     * Method to fetch a {@link Integer}' list
     *
     * @param jList: JSON source from fetch the list
     * @return integers list as {@link ArrayList} of {@link Integer}
     */
    protected ArrayList<Integer> fetchIntegersList(JSONArray jList) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (jList != null)
            for (int j = 0; j < jList.length(); j++)
                integers.add(jList.getInt(j));
        return integers;
    }

    /**
     * Method to fetch a {@link String}' list
     *
     * @param dateTimestamp: timestamp of the date to get
     * @return date value as {@link Date}
     */
    protected Date getDateValue(long dateTimestamp) {
        dateTimestamp *= 1000;
        if (dateTimestamp > 0)
            return TimeFormatter.getDate(dateTimestamp);
        else
            return null;
    }

    /**
     * Returns a string representation of the object <br>
     * No-any params required
     *
     * @return a string representation of the object as {@link String}
     * @apiNote see the {@link #useSnakeNotation} instance to see how this method works
     */
    @Override
    public String toString() {
        JSONObject details;
        if (useSnakeNotation) {
            details = new JSONObject();
            Class<?> cClass = this.getClass();
            for (Method method : this.getClass().getDeclaredMethods()) {
                if (!method.getAnnotatedReturnType().getType().getTypeName().equals("void")) {
                    try {
                        Field wField = null;
                        String lowerMethodName = method.getName().toLowerCase();
                        for (Field field : this.getClass().getDeclaredFields())
                            if (lowerMethodName.contains(field.getName().toLowerCase()))
                                wField = field;
                        if (wField != null) {
                            wField.setAccessible(true);
                            String fName = wField.getName().replaceAll("([a-z])([A-Z]+)", "$1_$2")
                                    .toLowerCase();
                            if (fName.contains("webpage")) {
                                String[] names = fName.split("web");
                                fName = names[0] + "web_" + names[1];
                            }
                            Object fieldValue = wField.get(this);
                            if (fieldValue instanceof ArrayList<?>)
                                fieldValue = new JSONArray(fieldValue.toString());
                            details.put(fName, fieldValue);
                        }
                    } catch (Exception ignored) {
                    }
                }
            }
        } else
            details = new JSONObject(this);
        return details.toString();
    }

}
