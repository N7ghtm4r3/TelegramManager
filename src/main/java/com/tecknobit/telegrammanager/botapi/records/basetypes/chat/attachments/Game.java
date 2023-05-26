package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments;

import com.tecknobit.telegrammanager.botapi.records.basetypes.media.PhotoSize;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.Video;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.media.PhotoSize.returnPhotoSizes;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity.returnMessageEntities;

public class Game extends TelegramType {

    private final String title;

    private final ArrayList<PhotoSize> photo;

    private final String text;

    private final ArrayList<MessageEntity> textEntities;

    private final Video animation;

    public Game(String title, ArrayList<PhotoSize> photo, String text, ArrayList<MessageEntity> textEntities,
                Video animation) {
        super(null);
        this.title = title;
        this.photo = photo;
        this.text = text;
        this.textEntities = textEntities;
        this.animation = animation;
    }

    public Game(JSONObject jGame) {
        super(jGame);
        title = hTelegram.getString("title");
        photo = returnPhotoSizes(hTelegram.getJSONArray("photo"));
        text = hTelegram.getString("text");
        textEntities = returnMessageEntities(hTelegram.getJSONArray("text_entities"));
        animation = Video.getInstance(hTelegram.getJSONObject("animation"));
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<PhotoSize> getPhoto() {
        return photo;
    }

    public String getText() {
        return text;
    }

    public ArrayList<MessageEntity> getTextEntities() {
        return textEntities;
    }

    public Video getAnimation() {
        return animation;
    }

    public static Game getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Game(jItem);
    }

}
