package com.tecknobit.telegrammanager.botapi.managers.identifiers;

import com.tecknobit.apimanager.annotations.RequestPath;
import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.apimanager.annotations.WrappedRequest;
import com.tecknobit.apimanager.annotations.Wrapper;
import com.tecknobit.telegrammanager.botapi.managers.TelegramManager;
import com.tecknobit.telegrammanager.botapi.records.basetypes.forum.ForumTopic;
import com.tecknobit.telegrammanager.botapi.records.basetypes.forum.ForumTopicCreated.TopicIconColor;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers.Sticker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.GET;
import static com.tecknobit.apimanager.apis.APIRequest.RequestMethod.POST;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramManager.ReturnFormat.LIBRARY_OBJECT;

/**
 * The {@code ForumTopicManager} class is useful to create a {@code Telegram}'s bot forum topic manager
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#available-methods">
 * Available methods</a>
 * @see TelegramManager
 * @see TelegramIdentifierManager
 */
public class ForumTopicManager extends TelegramIdentifierManager {

    /**
     * {@code GET_FORUM_TOPIC_ICON_STICKERS_ENDPOINT} is constant for GET_FORUM_TOPIC_ICON_STICKERS_ENDPOINT's endpoint
     */
    public static final String GET_FORUM_TOPIC_ICON_STICKERS_ENDPOINT = "getForumTopicIconStickers";

    /**
     * {@code CREATE_FORUM_TOPIC_ENDPOINT} is constant for CREATE_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String CREATE_FORUM_TOPIC_ENDPOINT = "createForumTopic";

    /**
     * {@code EDIT_FORUM_TOPIC_ENDPOINT} is constant for EDIT_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String EDIT_FORUM_TOPIC_ENDPOINT = "editForumTopic";

    /**
     * {@code CLOSE_FORUM_TOPIC_ENDPOINT} is constant for CLOSE_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String CLOSE_FORUM_TOPIC_ENDPOINT = "closeForumTopic";

    /**
     * {@code REOPEN_FORUM_TOPIC_ENDPOINT} is constant for REOPEN_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String REOPEN_FORUM_TOPIC_ENDPOINT = "reopenForumTopic";

    /**
     * {@code DELETE_FORUM_TOPIC_ENDPOINT} is constant for DELETE_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String DELETE_FORUM_TOPIC_ENDPOINT = "deleteForumTopic";

    /**
     * {@code UNPIN_ALL_FORUM_TOPIC_MESSAGES_ENDPOINT} is constant for UNPIN_ALL_FORUM_TOPIC_MESSAGES_ENDPOINT's endpoint
     */
    public static final String UNPIN_ALL_FORUM_TOPIC_MESSAGES_ENDPOINT = "unpinAllForumTopicMessages";

    /**
     * {@code EDIT_GENERAL_FORUM_TOPIC_ENDPOINT} is constant for EDIT_GENERAL_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String EDIT_GENERAL_FORUM_TOPIC_ENDPOINT = "editGeneralForumTopic";

    /**
     * {@code CLOSE_GENERAL_FORUM_TOPIC_ENDPOINT} is constant for CLOSE_GENERAL_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String CLOSE_GENERAL_FORUM_TOPIC_ENDPOINT = "closeGeneralForumTopic";

    /**
     * {@code REOPEN_GENERAL_FORUM_TOPIC_ENDPOINT} is constant for REOPEN_GENERAL_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String REOPEN_GENERAL_FORUM_TOPIC_ENDPOINT = "reopenGeneralForumTopic";

    /**
     * {@code HIDE_GENERAL_FORUM_TOPIC_ENDPOINT} is constant for HIDE_GENERAL_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String HIDE_GENERAL_FORUM_TOPIC_ENDPOINT = "hideGeneralForumTopic";

    /**
     * {@code UNHIDE_GENERAL_FORUM_TOPIC_ENDPOINT} is constant for UNHIDE_GENERAL_FORUM_TOPIC_ENDPOINT's endpoint
     */
    public static final String UNHIDE_GENERAL_FORUM_TOPIC_ENDPOINT = "unhideGeneralForumTopic";

    /**
     * Constructor to init {@link ForumTopicManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     */
    public ForumTopicManager(String token, String defaultErrorMessage) {
        super(token, defaultErrorMessage);
    }

    /**
     * Constructor to init {@link ForumTopicManager}
     *
     * @param token          :          the bot unique authentication token
     * @param requestTimeout : timeout for the requests
     */
    public ForumTopicManager(String token, int requestTimeout) {
        super(token, requestTimeout);
    }

    /**
     * Constructor to init {@link ForumTopicManager}
     *
     * @param token : the bot unique authentication token
     */
    public ForumTopicManager(String token) {
        super(token);
    }

    /**
     * Constructor to init {@link ForumTopicManager}
     *
     * @param token               :               the bot unique authentication token
     * @param defaultErrorMessage : error message to return if is not request error
     * @param requestTimeout      :      timeout for the requests
     */
    public ForumTopicManager(String token, String defaultErrorMessage, int requestTimeout) {
        super(token, defaultErrorMessage, requestTimeout);
    }

    /**
     * Constructor to init {@link ForumTopicManager} object <br>
     * No-any params required
     *
     * @throws IllegalArgumentException when a parameterized constructor has not been called before this constructor
     * @apiNote this constructor is useful to instantiate a new {@link ForumTopicManager}'s manager without re-insert
     * the credentials and is useful in those cases if you need to use different manager at the same time:
     * <pre>
     *     {@code
     *        //You need to insert all credentials requested
     *        TelegramManager firstManager = new TelegramManager("token", "defaultErrorMessage", timeout);
     *        //You don't need to insert all credentials to make manager work
     *        TelegramManager secondManager = new TelegramManager(); //same credentials used
     *     }
     * </pre>
     */
    public ForumTopicManager() throws Exception {
        super();
    }

    /**
     * Request to get custom emoji stickers, which can be used as a forum topic icon by any user <br>
     * No-any params required
     *
     * @return custom emoji stickers as {@link ArrayList} of {@link Sticker} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getforumtopiciconstickers">
     * getForumTopicIconStickers</a>
     */
    @Wrapper
    @RequestPath(method = GET, path = "getForumTopicIconStickers")
    public ArrayList<Sticker> getForumTopicIconStickers() throws IOException {
        return getForumTopicIconStickers(LIBRARY_OBJECT);
    }

    /**
     * Request to get custom emoji stickers, which can be used as a forum topic icon by any user
     *
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return custom emoji stickers as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#getforumtopiciconstickers">
     * getForumTopicIconStickers</a>
     */
    @Returner
    @RequestPath(method = GET, path = "getForumTopicIconStickers")
    public <T> T getForumTopicIconStickers(ReturnFormat format) throws IOException {
        JSONArray result = getResultFromList(sendGetRequest(GET_FORUM_TOPIC_ICON_STICKERS_ENDPOINT));
        return switch (format) {
            case JSON -> (T) result;
            case LIBRARY_OBJECT -> {
                ArrayList<Sticker> stickers = new ArrayList<>();
                for (int j = 0; j < result.length(); j++)
                    stickers.add(new Sticker(result.getJSONObject(j)));
                yield (T) stickers;
            }
            default -> (T) result.toString();
        };
    }

    /**
     * Request to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the can_manage_topics administrator rights
     *
     * @param name: topic name, 1-128 characters
     * @return forum topic as {@link ForumTopic} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createforumtopic">
     * createForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "createForumTopic")
    public ForumTopic createForumTopic(String name) throws IOException {
        return createForumTopic(mChatId, name, LIBRARY_OBJECT);
    }

    /**
     * Request to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the can_manage_topics administrator rights
     *
     * @param name:  topic name, 1-128 characters
     * @param format :       return type formatter -> {@link ReturnFormat}
     * @return forum topic as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createforumtopic">
     * createForumTopic</a>
     */
    @RequestPath(method = POST, path = "createForumTopic")
    public <T> T createForumTopic(String name, ReturnFormat format) throws IOException {
        return createForumTopic(mChatId, name, format);
    }

    /**
     * Request to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the can_manage_topics administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param name:   topic name, 1-128 characters
     * @return forum topic as {@link ForumTopic} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createforumtopic">
     * createForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "createForumTopic")
    public <T> ForumTopic createForumTopic(T chatId, String name) throws IOException {
        return createForumTopic(chatId, name, LIBRARY_OBJECT);
    }

    /**
     * Request to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the can_manage_topics administrator rights
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param name:   topic name, 1-128 characters
     * @param format  :       return type formatter -> {@link ReturnFormat}
     * @return forum topic as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createforumtopic">
     * createForumTopic</a>
     */
    @RequestPath(method = POST, path = "createForumTopic")
    public <T, L> T createForumTopic(L chatId, String name, ReturnFormat format) throws IOException {
        return createForumTopic(chatId, name, null, format);
    }

    /**
     * Request to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the can_manage_topics administrator rights
     *
     * @param name:       topic name, 1-128 characters
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "icon_color"} -> color of the topic icon in RGB format - [{@link TopicIconColor}]
     *                          </li>
     *                          <li>
     *                               {@code "icon_custom_emoji_id"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [String]
     *                          </li>
     *                    </ul>
     * @return forum topic as {@link ForumTopic} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createforumtopic">
     * createForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "createForumTopic")
    public ForumTopic createForumTopic(String name, Params parameters) throws IOException {
        return createForumTopic(mChatId, name, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the can_manage_topics administrator rights
     *
     * @param name:       topic name, 1-128 characters
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "icon_color"} -> color of the topic icon in RGB format - [{@link TopicIconColor}]
     *                          </li>
     *                          <li>
     *                               {@code "icon_custom_emoji_id"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [String]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return forum topic as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createforumtopic">
     * createForumTopic</a>
     */
    @RequestPath(method = POST, path = "createForumTopic")
    public <T> T createForumTopic(String name, Params parameters, ReturnFormat format) throws IOException {
        return createForumTopic(mChatId, name, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the can_manage_topics administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param name:       topic name, 1-128 characters
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "icon_color"} -> color of the topic icon in RGB format - [{@link TopicIconColor}]
     *                          </li>
     *                          <li>
     *                               {@code "icon_custom_emoji_id"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [String]
     *                          </li>
     *                    </ul>
     * @return forum topic as {@link ForumTopic} custom object
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createforumtopic">
     * createForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "createForumTopic")
    public <T> ForumTopic createForumTopic(T chatId, String name, Params parameters) throws IOException {
        return createForumTopic(chatId, name, parameters, LIBRARY_OBJECT);
    }

    /**
     * Request to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the can_manage_topics administrator rights
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param name:       topic name, 1-128 characters
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "icon_color"} -> color of the topic icon in RGB format - [{@link TopicIconColor}]
     *                          </li>
     *                          <li>
     *                               {@code "icon_custom_emoji_id"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [String]
     *                          </li>
     *                    </ul>
     * @param format      :       return type formatter -> {@link ReturnFormat}
     * @return forum topic as {@code "format"} defines
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#createforumtopic">
     * createForumTopic</a>
     */
    @Returner
    @RequestPath(method = POST, path = "createForumTopic")
    public <T, L> T createForumTopic(L chatId, String name, Params parameters, ReturnFormat format) throws IOException {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("name", name);
        JSONObject forumTopicResponse = new JSONObject(sendPostRequest(CREATE_FORUM_TOPIC_ENDPOINT, parameters));
        return switch (format) {
            case JSON -> (T) forumTopicResponse;
            case LIBRARY_OBJECT -> (T) new ForumTopic(forumTopicResponse);
            default -> (T) forumTopicResponse.toString();
        };
    }

    /**
     * Method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat
     * for this to work and must have can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param topic:      the topic to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> new topic name, 0-128 characters. If not specified or empty,
     *                               the current name of the topic will be kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "icon_custom_emoji_id"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [String]
     *                          </li>
     *                    </ul>
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editforumtopic">
     * editForumTopic</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "editForumTopic")
    public boolean editForumTopic(ForumTopic topic, Params parameters) throws IOException {
        return editForumTopic(mChatId, topic.getMessageThreadId(), parameters);
    }

    /**
     * Method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat
     * for this to work and must have can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @param parameters:      additional params of the request, keys accepted are:
     *                         <ul>
     *                               <li>
     *                                    {@code "name"} -> new topic name, 0-128 characters. If not specified or empty,
     *                                    the current name of the topic will be kept - [String]
     *                               </li>
     *                               <li>
     *                                    {@code "icon_custom_emoji_id"} -> date when the user will be unbanned, unix time. If user is
     *                                    banned for more than 366 days or less than 30 seconds from the current time they
     *                                    are considered to be banned forever. Applied for supergroups
     *                                    and channels only - [String]
     *                               </li>
     *                         </ul>
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editforumtopic">
     * editForumTopic</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "editForumTopic")
    public boolean editForumTopic(long messageThreadId, Params parameters) throws IOException {
        return editForumTopic(mChatId, messageThreadId, parameters);
    }

    /**
     * Method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat
     * for this to work and must have can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param chatId:     unique identifier for the target chat or username of the target channel
     * @param topic:      the topic to edit
     * @param parameters: additional params of the request, keys accepted are:
     *                    <ul>
     *                          <li>
     *                               {@code "name"} -> new topic name, 0-128 characters. If not specified or empty,
     *                               the current name of the topic will be kept - [String]
     *                          </li>
     *                          <li>
     *                               {@code "icon_custom_emoji_id"} -> date when the user will be unbanned, unix time. If user is
     *                               banned for more than 366 days or less than 30 seconds from the current time they
     *                               are considered to be banned forever. Applied for supergroups
     *                               and channels only - [String]
     *                          </li>
     *                    </ul>
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editforumtopic">
     * editForumTopic</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "editForumTopic")
    public <T> boolean editForumTopic(T chatId, ForumTopic topic, Params parameters) throws IOException {
        return editForumTopic(chatId, topic.getMessageThreadId(), parameters);
    }

    /**
     * Method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat
     * for this to work and must have can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @param parameters:      additional params of the request, keys accepted are:
     *                         <ul>
     *                               <li>
     *                                    {@code "name"} -> new topic name, 0-128 characters. If not specified or empty,
     *                                    the current name of the topic will be kept - [String]
     *                               </li>
     *                               <li>
     *                                    {@code "icon_custom_emoji_id"} -> date when the user will be unbanned, unix time. If user is
     *                                    banned for more than 366 days or less than 30 seconds from the current time they
     *                                    are considered to be banned forever. Applied for supergroups
     *                                    and channels only - [String]
     *                               </li>
     *                         </ul>
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editforumtopic">
     * editForumTopic</a>
     */
    @RequestPath(method = POST, path = "editForumTopic")
    public <T> boolean editForumTopic(T chatId, long messageThreadId, Params parameters) throws IOException {
        return getBooleanResponse(sendPostRequest(EDIT_FORUM_TOPIC_ENDPOINT, createForumTopicPayload(chatId,
                messageThreadId, parameters)));
    }

    /**
     * Method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this
     * to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param topic: the topic to close
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#closeforumtopic">
     * closeForumTopic</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "closeForumTopic")
    public boolean closeForumTopic(ForumTopic topic) throws IOException {
        return closeForumTopic(mChatId, topic.getMessageThreadId());
    }

    /**
     * Method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this
     * to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#closeforumtopic">
     * closeForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "closeForumTopic")
    public boolean closeForumTopic(long messageThreadId) throws IOException {
        return closeForumTopic(mChatId, messageThreadId);
    }

    /**
     * Method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this
     * to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param topic:  the topic to close
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#closeforumtopic">
     * closeForumTopic</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "closeForumTopic")
    public <T> boolean closeForumTopic(T chatId, ForumTopic topic) throws IOException {
        return closeForumTopic(chatId, topic.getMessageThreadId());
    }

    /**
     * Method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this
     * to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#closeforumtopic">
     * closeForumTopic</a>
     */
    @RequestPath(method = POST, path = "closeForumTopic")
    public <T> boolean closeForumTopic(T chatId, long messageThreadId) throws IOException {
        return getBooleanResponse(sendPostRequest(CLOSE_FORUM_TOPIC_ENDPOINT, createForumTopicPayload(chatId,
                messageThreadId, null)));
    }

    /**
     * Method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this
     * to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param topic: the topic to reopen
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#reopenforumtopic">
     * reopenForumTopic</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "reopenForumTopic")
    public boolean reopenForumTopic(ForumTopic topic) throws IOException {
        return reopenForumTopic(mChatId, topic.getMessageThreadId());
    }

    /**
     * Method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this
     * to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#reopenforumtopic">
     * reopenForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "reopenForumTopic")
    public boolean reopenForumTopic(long messageThreadId) throws IOException {
        return reopenForumTopic(mChatId, messageThreadId);
    }

    /**
     * Method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this
     * to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param topic:  the topic to reopen
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#reopenforumtopic">
     * reopenForumTopic</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "reopenForumTopic")
    public <T> boolean reopenForumTopic(T chatId, ForumTopic topic) throws IOException {
        return reopenForumTopic(chatId, topic.getMessageThreadId());
    }

    /**
     * Method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this
     * to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#reopenforumtopic">
     * reopenForumTopic</a>
     */
    @RequestPath(method = POST, path = "reopenForumTopic")
    public <T> boolean reopenForumTopic(T chatId, long messageThreadId) throws IOException {
        return getBooleanResponse(sendPostRequest(REOPEN_FORUM_TOPIC_ENDPOINT, createForumTopicPayload(chatId,
                messageThreadId, null)));
    }

    /**
     * Method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an
     * administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is
     * the creator of the topic
     *
     * @param topic: the topic to delete
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deleteforumtopic">
     * deleteForumTopic</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "deleteForumTopic")
    public boolean deleteForumTopic(ForumTopic topic) throws IOException {
        return deleteForumTopic(mChatId, topic.getMessageThreadId());
    }

    /**
     * Method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an
     * administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is
     * the creator of the topic
     *
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deleteforumtopic">
     * deleteForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "deleteForumTopic")
    public boolean deleteForumTopic(long messageThreadId) throws IOException {
        return deleteForumTopic(mChatId, messageThreadId);
    }

    /**
     * Method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an
     * administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is
     * the creator of the topic
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param topic:  the topic to delete
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deleteforumtopic">
     * deleteForumTopic</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "deleteForumTopic")
    public <T> boolean deleteForumTopic(T chatId, ForumTopic topic) throws IOException {
        return deleteForumTopic(chatId, topic.getMessageThreadId());
    }

    /**
     * Method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an
     * administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is
     * the creator of the topic
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#deleteforumtopic">
     * deleteForumTopic</a>
     */
    @RequestPath(method = POST, path = "deleteForumTopic")
    public <T> boolean deleteForumTopic(T chatId, long messageThreadId) throws IOException {
        return getBooleanResponse(sendPostRequest(DELETE_FORUM_TOPIC_ENDPOINT, createForumTopicPayload(chatId,
                messageThreadId, null)));
    }

    /**
     * Method to clear the list of pinned messages in a forum topic. The bot must be an
     * administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is
     * the creator of the topic
     *
     * @param topic: the topic where clear the list of pinned messages
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinallforumtopicmessages">
     * unpinAllForumTopicMessages</a>
     */
    @Wrapper
    @WrappedRequest
    @RequestPath(method = POST, path = "unpinAllForumTopicMessages")
    public boolean unpinAllForumTopicMessages(ForumTopic topic) throws IOException {
        return unpinAllForumTopicMessages(mChatId, topic.getMessageThreadId());
    }

    /**
     * Method to clear the list of pinned messages in a forum topic. The bot must be an
     * administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is
     * the creator of the topic
     *
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinallforumtopicmessages">
     * unpinAllForumTopicMessages</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "unpinAllForumTopicMessages")
    public boolean unpinAllForumTopicMessages(long messageThreadId) throws IOException {
        return unpinAllForumTopicMessages(mChatId, messageThreadId);
    }

    /**
     * Method to clear the list of pinned messages in a forum topic. The bot must be an
     * administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is
     * the creator of the topic
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param topic:  the topic where clear the list of pinned messages
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinallforumtopicmessages">
     * unpinAllForumTopicMessages</a>
     */
    @WrappedRequest
    @RequestPath(method = POST, path = "unpinAllForumTopicMessages")
    public <T> boolean unpinAllForumTopicMessages(T chatId, ForumTopic topic) throws IOException {
        return unpinAllForumTopicMessages(chatId, topic.getMessageThreadId());
    }

    /**
     * Method to clear the list of pinned messages in a forum topic. The bot must be an
     * administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is
     * the creator of the topic
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unpinallforumtopicmessages">
     * unpinAllForumTopicMessages</a>
     */
    @RequestPath(method = POST, path = "unpinAllForumTopicMessages")
    public <T> boolean unpinAllForumTopicMessages(T chatId, long messageThreadId) throws IOException {
        return getBooleanResponse(sendPostRequest(UNPIN_ALL_FORUM_TOPIC_MESSAGES_ENDPOINT, createForumTopicPayload(chatId,
                messageThreadId, null)));
    }

    /**
     * Method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic
     *
     * @param name: new topic name, 1-128 characters
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editgeneralforumtopic">
     * editGeneralForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "editGeneralForumTopic")
    public boolean editGeneralForumTopic(String name) throws IOException {
        return editGeneralForumTopic(mChatId, name);
    }

    /**
     * Method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @param name:   new topic name, 1-128 characters
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#editgeneralforumtopic">
     * editGeneralForumTopic</a>
     */
    @RequestPath(method = POST, path = "editGeneralForumTopic")
    public <T> boolean editGeneralForumTopic(T chatId, String name) throws IOException {
        Params payload = createChatIdPayload(chatId, null);
        payload.addParam("name", name);
        return getBooleanResponse(sendPostRequest(EDIT_GENERAL_FORUM_TOPIC_ENDPOINT, payload));
    }

    /**
     * Method to close an open 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic <br>
     * No-any params required
     *
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#closegeneralforumtopic">
     * closeGeneralForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "closeGeneralForumTopic")
    public boolean closeGeneralForumTopic() throws IOException {
        return closeGeneralForumTopic(mChatId);
    }

    /**
     * Method to close an open 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#closegeneralforumtopic">
     * closeGeneralForumTopic</a>
     */
    @RequestPath(method = POST, path = "closeGeneralForumTopic")
    public <T> boolean closeGeneralForumTopic(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(CLOSE_GENERAL_FORUM_TOPIC_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    /**
     * Method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic <br>
     * No-any params required
     *
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#reopenGeneralForumTopic">
     * reopenGeneralForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "reopenGeneralForumTopic")
    public boolean reopenGeneralForumTopic() throws IOException {
        return reopenGeneralForumTopic(mChatId);
    }

    /**
     * Method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#reopenGeneralForumTopic">
     * reopenGeneralForumTopic</a>
     */
    @RequestPath(method = POST, path = "reopenGeneralForumTopic")
    public <T> boolean reopenGeneralForumTopic(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(REOPEN_GENERAL_FORUM_TOPIC_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    /**
     * Method to hide the 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic <br>
     * No-any params required
     *
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#hidegeneralforumtopic">
     * hideGeneralForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "hideGeneralForumTopic")
    public boolean hideGeneralForumTopic() throws IOException {
        return hideGeneralForumTopic(mChatId);
    }

    /**
     * Method to hide the 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#hidegeneralforumtopic">
     * hideGeneralForumTopic</a>
     */
    @RequestPath(method = POST, path = "hideGeneralForumTopic")
    public <T> boolean hideGeneralForumTopic(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(HIDE_GENERAL_FORUM_TOPIC_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    /**
     * Method to unhide the 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic <br>
     * No-any params required
     *
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unhidegeneralforumtopic">
     * unhideGeneralForumTopic</a>
     */
    @Wrapper
    @RequestPath(method = POST, path = "unhideGeneralForumTopic")
    public boolean unhideGeneralForumTopic() throws IOException {
        return unhideGeneralForumTopic(mChatId);
    }

    /**
     * Method to unhide the 'General' topic in a forum supergroup chat. The bot must be an administrator in
     * the chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the
     * topic
     *
     * @param chatId: unique identifier for the target chat or username of the target channel
     * @return result of the operation -> {@code "true"} is successful, {@code "false"} if not successful
     * @throws IOException when request has been go wrong -> you can use these methods to get more details about error:
     *                     <ul>
     *                         <li>
     *                             {@link #getErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #getJSONErrorResponse()}
     *                         </li>
     *                         <li>
     *                             {@link #printErrorResponse()}
     *                         </li>
     *                     </ul> using a {@code "try and catch statement"} during runtime, see how to do in {@code "README"} file
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#unhidegeneralforumtopic">
     * unhideGeneralForumTopic</a>
     */
    @RequestPath(method = POST, path = "unhideGeneralForumTopic")
    public <T> boolean unhideGeneralForumTopic(T chatId) throws IOException {
        return getBooleanResponse(sendPostRequest(UNHIDE_GENERAL_FORUM_TOPIC_ENDPOINT, createChatIdPayload(chatId, null)));
    }

    /**
     * Method to create a forum topic payload
     *
     * @param chatId:          unique identifier for the target chat or username of the target channel
     * @param messageThreadId: unique identifier for the target message thread of the forum topic
     * @param parameters:      other request parameters
     * @return payload as {@link Params}
     */
    private <T> Params createForumTopicPayload(T chatId, long messageThreadId, Params parameters) {
        parameters = createChatIdPayload(chatId, parameters);
        parameters.addParam("message_thread_id", messageThreadId);
        return parameters;
    }

}
