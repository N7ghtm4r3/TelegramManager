package com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

import java.util.ArrayList;

public class InlineKeyboardMarkup extends TelegramType {

    private final ArrayList<ArrayList<InlineKeyboardButton>> inlineKeyboard;

    public InlineKeyboardMarkup(ArrayList<ArrayList<InlineKeyboardButton>> inlineKeyboard) {
        super(null);
        this.inlineKeyboard = inlineKeyboard;
    }

    public InlineKeyboardMarkup(JSONObject jInlineKeyboardMarkup) {
        super(jInlineKeyboardMarkup);
        inlineKeyboard = new ArrayList<>();
        inlineKeyboard.add(InlineKeyboardButton.returnInlineKeyboardButtons(hTelegram.getJSONArray("inline_keyboard")));
    }

    public ArrayList<ArrayList<InlineKeyboardButton>> getInlineKeyboard() {
        return inlineKeyboard;
    }

    public static InlineKeyboardMarkup getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineKeyboardMarkup(jItem);
    }

}
