package com.tecknobit.telegrammanager.botapi.updates.records;

import com.tecknobit.telegrammanager.botapi.records.basetypes.CallbackQuery;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.Poll;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.Poll.PollAnswer;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members.actions.ChatJoinRequest;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.members.actions.ChatMemberUpdated;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.ChosenInlineResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.InlineQuery;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.Message;
import com.tecknobit.telegrammanager.botapi.records.basetypes.payments.PreCheckoutQuery;
import com.tecknobit.telegrammanager.botapi.records.basetypes.payments.ShippingQuery;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

/**
 * The {@code Update} class is useful to format a {@code Telegram}'s update
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#update">
 * Update</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class Update extends TelegramType {

    /**
     * {@code updateId} the update's unique identifier. Update identifiers start from a certain positive number and
     * increase sequentially. This ID becomes especially handy if you're using webhooks, since it allows you to ignore
     * repeated updates or to restore the correct update sequence, should they get out of order. If there are no new
     * updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially
     */
    private final long updateId;

    /**
     * {@code message} new incoming message of any kind - text, photo, sticker, etc
     */
    private final Message message;

    /**
     * {@code editedMessage} new version of a message that is known to the bot and was edited
     */
    private final Message editedMessage;

    /**
     * {@code channelPost} new incoming channel post of any kind - text, photo, sticker, etc
     */
    private final Message channelPost;

    /**
     * {@code editeChannelPost} new version of a channel post that is known to the bot and was edited
     */
    private final Message editeChannelPost;

    /**
     * {@code inlineQuery} new incoming inline query
     */
    private final InlineQuery inlineQuery;

    /**
     * {@code chosenInlineResult} the result of an inline query that was chosen by a user and sent to their chat partner
     */
    private final ChosenInlineResult chosenInlineResult;

    /**
     * {@code callbackQuery} new incoming callback query
     */
    private final CallbackQuery callbackQuery;

    /**
     * {@code shippingQuery} new incoming shipping query. Only for invoices with flexible price
     */
    private final ShippingQuery shippingQuery;

    /**
     * {@code preCheckoutQuery} new incoming pre-checkout query. Contains full information about checkout
     */
    private final PreCheckoutQuery preCheckoutQuery;

    /**
     * {@code poll} new poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
     */
    private final Poll poll;

    /**
     * {@code pollAnswer} a user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that
     * were sent by the bot itself
     */
    private final PollAnswer pollAnswer;

    /**
     * {@code myChatMember} the bot's chat member status was updated in a chat. For private chats, this update is received
     * only when the bot is blocked or unblocked by the user
     */
    private final ChatMemberUpdated myChatMember;

    /**
     * {@code chatMember} a chat member's status was updated in a chat. The bot must be an administrator in the chat and
     * must explicitly specify {@code "chat_member"} in the list of allowed_updates to receive these updates
     */
    private final ChatMemberUpdated chatMember;

    /**
     * {@code chatJoinRequest} request to join the chat has been sent. The bot must have the {@code "can_invite_users"}
     * administrator right in the chat to receive these updates
     */
    private final ChatJoinRequest chatJoinRequest;

    /**
     * Constructor to init a {@link Update} object
     * @param updateId: the update's unique identifier. Update identifiers start from a certain positive number and
     *       increase sequentially. This ID becomes especially handy if you're using webhooks, since it allows you to ignore
     *       repeated updates or to restore the correct update sequence, should they get out of order. If there are no new
     *       updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially
     @param message: new incoming message of any kind - text, photo, sticker, etc
     @param editedMessage: new version of a message that is known to the bot and was edited
     @param channelPost: new incoming channel post of any kind - text, photo, sticker, etc
     @param editeChannelPost: new version of a channel post that is known to the bot and was edited
     @param inlineQuery: new incoming inline query
     @param chosenInlineResult: the result of an inline query that was chosen by a user and sent to their chat partner
     @param callbackQuery: new incoming callback query
     @param shippingQuery: new incoming shipping query. Only for invoices with flexible price
     @param preCheckoutQuery: new incoming pre-checkout query. Contains full information about checkout
     @param poll: new poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
     @param pollAnswer: a user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that
     were sent by the bot itself
     @param myChatMember: the bot's chat member status was updated in a chat. For private chats, this update is received
     only when the bot is blocked or unblocked by the user
     @param chatMember: a chat member's status was updated in a chat. The bot must be an administrator in the chat and
     must explicitly specify {@code "chat_member"} in the list of allowed_updates to receive these updates
     @param chatJoinRequest: request to join the chat has been sent. The bot must have the {@code "can_invite_users"}
     administrator right in the chat to receive these updates

     */
    public Update(long updateId, Message message, Message editedMessage, Message channelPost, Message editeChannelPost,
                  InlineQuery inlineQuery, ChosenInlineResult chosenInlineResult, CallbackQuery callbackQuery,
                  ShippingQuery shippingQuery, PreCheckoutQuery preCheckoutQuery, Poll poll, PollAnswer pollAnswer,
                  ChatMemberUpdated myChatMember, ChatMemberUpdated chatMember, ChatJoinRequest chatJoinRequest) {
        super(null);
        this.updateId = updateId;
        this.message = message;
        this.editedMessage = editedMessage;
        this.channelPost = channelPost;
        this.editeChannelPost = editeChannelPost;
        this.inlineQuery = inlineQuery;
        this.chosenInlineResult = chosenInlineResult;
        this.callbackQuery = callbackQuery;
        this.shippingQuery = shippingQuery;
        this.preCheckoutQuery = preCheckoutQuery;
        this.poll = poll;
        this.pollAnswer = pollAnswer;
        this.myChatMember = myChatMember;
        this.chatMember = chatMember;
        this.chatJoinRequest = chatJoinRequest;
    }

    /**
     * Constructor to init a {@link Update} object
     *
     * @param jUpdate: update details as {@link JSONObject}
     */
    public Update(JSONObject jUpdate) {
        super(jUpdate);
        updateId = hTelegram.getLong("update_id");
        message = Message.getInstance(hTelegram.getJSONObject("message"));
        editedMessage = Message.getInstance(hTelegram.getJSONObject("edited_message"));
        channelPost = Message.getInstance(hTelegram.getJSONObject("channel_post"));
        editeChannelPost = Message.getInstance(hTelegram.getJSONObject("edited_channel_post"));
        inlineQuery = InlineQuery.getInstance(hTelegram.getJSONObject("inline_query"));
        chosenInlineResult = ChosenInlineResult.getInstance(hTelegram.getJSONObject("chosen_inline_result"));
        callbackQuery = CallbackQuery.getInstance(hTelegram.getJSONObject("callback_query"));
        shippingQuery = ShippingQuery.getInstance(hTelegram.getJSONObject("shipping_query"));
        preCheckoutQuery = PreCheckoutQuery.getInstance(hTelegram.getJSONObject("pre_checkout_query"));
        poll = Poll.getInstance(hTelegram.getJSONObject("poll"));
        pollAnswer = PollAnswer.getInstance(hTelegram.getJSONObject("poll_answer"));
        myChatMember = ChatMemberUpdated.getInstance(hTelegram.getJSONObject("my_chat_member"));
        chatMember = ChatMemberUpdated.getInstance(hTelegram.getJSONObject("chat_member"));
        chatJoinRequest = ChatJoinRequest.getInstance(hTelegram.getJSONObject("chat_join_request"));
    }

    /**
     * Method to get {@link #updateId} instance <br>
     * No-any params required
     *
     * @return {@link #updateId} instance as long
     */
    public long getUpdateId() {
        return updateId;
    }

    /**
     * Method to get {@link #message} instance <br>
     * No-any params required
     *
     * @return {@link #message} instance as {@link Message}
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Method to get {@link #editedMessage} instance <br>
     * No-any params required
     *
     * @return {@link #editedMessage} instance as {@link Message}
     */
    public Message getEditedMessage() {
        return editedMessage;
    }

    /**
     * Method to get {@link #channelPost} instance <br>
     * No-any params required
     *
     * @return {@link #channelPost} instance as {@link Message}
     */
    public Message getChannelPost() {
        return channelPost;
    }

    /**
     * Method to get {@link #editeChannelPost} instance <br>
     * No-any params required
     *
     * @return {@link #editeChannelPost} instance as {@link Message}
     */
    public Message getEditeChannelPost() {
        return editeChannelPost;
    }

    /**
     * Method to get {@link #inlineQuery} instance <br>
     * No-any params required
     *
     * @return {@link #inlineQuery} instance as {@link InlineQuery}
     */
    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }

    /**
     * Method to get {@link #chosenInlineResult} instance <br>
     * No-any params required
     *
     * @return {@link #chosenInlineResult} instance as {@link ChosenInlineResult}
     */
    public ChosenInlineResult getChosenInlineResult() {
        return chosenInlineResult;
    }

    /**
     * Method to get {@link #callbackQuery} instance <br>
     * No-any params required
     *
     * @return {@link #callbackQuery} instance as {@link CallbackQuery}
     */
    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    /**
     * Method to get {@link #shippingQuery} instance <br>
     * No-any params required
     *
     * @return {@link #shippingQuery} instance as {@link ShippingQuery}
     */
    public ShippingQuery getShippingQuery() {
        return shippingQuery;
    }

    /**
     * Method to get {@link #preCheckoutQuery} instance <br>
     * No-any params required
     *
     * @return {@link #preCheckoutQuery} instance as {@link PreCheckoutQuery}
     */
    public PreCheckoutQuery getPreCheckoutQuery() {
        return preCheckoutQuery;
    }

    /**
     * Method to get {@link #poll} instance <br>
     * No-any params required
     *
     * @return {@link #poll} instance as {@link Poll}
     */
    public Poll getPoll() {
        return poll;
    }

    /**
     * Method to get {@link #pollAnswer} instance <br>
     * No-any params required
     *
     * @return {@link #pollAnswer} instance as {@link PollAnswer}
     */
    public PollAnswer getPollAnswer() {
        return pollAnswer;
    }

    /**
     * Method to get {@link #myChatMember} instance <br>
     * No-any params required
     *
     * @return {@link #myChatMember} instance as {@link ChatMemberUpdated}
     */
    public ChatMemberUpdated getMyChatMember() {
        return myChatMember;
    }

    /**
     * Method to get {@link #chatMember} instance <br>
     * No-any params required
     *
     * @return {@link #chatMember} instance as {@link ChatMemberUpdated}
     */
    public ChatMemberUpdated getChatMember() {
        return chatMember;
    }

    /**
     * Method to get {@link #chatJoinRequest} instance <br>
     * No-any params required
     *
     * @return {@link #chatJoinRequest} instance as {@link ChatJoinRequest}
     */
    public ChatJoinRequest getChatJoinRequest() {
        return chatJoinRequest;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Update}
     */
    public static Update getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Update(jItem);
    }

}
