package com.tecknobit.telegrammanager.botapi.records.basetypes.userdata;

import com.tecknobit.telegrammanager.botapi.records.basetypes.media.PhotoSize;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The {@code UserProfilePhotos} class is useful to format a {@code Telegram}'s user profile photos
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#userprofilephotos">
 * UserProfilePhotos</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class UserProfilePhotos extends TelegramType {

    /**
     * {@code totalCount} total number of profile pictures the target user has
     */
    private final int totalCount;

    /**
     * {@code photos} requested profile pictures (in up to 4 sizes each)
     */
    private final ArrayList<ArrayList<PhotoSize>> photos;

    /**
     * Constructor to init a {@link UserProfilePhotos} object
     *
     * @param totalCount: total number of profile pictures the target user has
     * @param photos:     requested profile pictures (in up to 4 sizes each)
     */
    public UserProfilePhotos(int totalCount, ArrayList<ArrayList<PhotoSize>> photos) {
        super(null);
        this.totalCount = totalCount;
        this.photos = photos;
    }

    /**
     * Constructor to init a {@link UserProfilePhotos} object
     *
     * @param jUserProfilePhotos: user profile photos details as {@link JSONObject}
     */
    public UserProfilePhotos(JSONObject jUserProfilePhotos) {
        super(jUserProfilePhotos);
        totalCount = hTelegram.getInt("total_count");
        photos = new ArrayList<>();
        photos.add(PhotoSize.returnPhotoSizes(hTelegram.getJSONArray("photos")));
    }

    /**
     * Method to get {@link #totalCount} instance <br>
     * No-any params required
     *
     * @return {@link #totalCount} instance as int
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Method to get {@link #photos} instance <br>
     * No-any params required
     *
     * @return {@link #photos} instance as {@link ArrayList} of {@link ArrayList} of {@link PhotoSize}
     */
    public ArrayList<ArrayList<PhotoSize>> getPhotos() {
        return photos;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link UserProfilePhotos}
     */
    public static UserProfilePhotos getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new UserProfilePhotos(jItem);
    }

}
