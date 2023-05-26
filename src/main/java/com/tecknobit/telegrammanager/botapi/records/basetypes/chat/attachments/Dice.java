package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments;

import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

public class Dice extends TelegramType {

    private final String emoji;

    private final int value;

    public Dice(String emoji, int value) {
        super(null);
        this.emoji = emoji;
        this.value = value;
    }

    public Dice(JSONObject jDice) {
        super(jDice);
        emoji = hTelegram.getString("emoji");
        value = hTelegram.getInt("value");
    }

    public String getEmoji() {
        return emoji;
    }

    public int getValue() {
        return value;
    }

    public static Dice getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Dice(jItem);
    }

}
