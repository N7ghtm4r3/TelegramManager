package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import java.util.List;

/**
 * The {@code KeyboardManager} interface is useful to manage a {@code Telegram}'s keyboard
 *
 * @param <T> button item of the keyboard
 * @author N7ghtm4r3 - Tecknobit
 */
@SuppressWarnings("ALL")
public interface KeyboardManager<T> {

    /**
     * Method to add a row of {@link T} to the current keyboard
     *
     * @param rowItems: row items to add
     */
    void addKeyboardRow(T... rowItems);

    /**
     * Method to remove a row of {@link T} from the current keyboard
     *
     * @param rowToRemove: row of {@link T} to remove
     */
    void removeKeyboardRow(List<T> rowToRemove);

    /**
     * Method to remove a row of {@link T} from the current keyboard
     *
     * @param indexRowToRemove: index of the row of {@link T} to remove
     */
    void removeKeyboardRow(int indexRowToRemove);

}
