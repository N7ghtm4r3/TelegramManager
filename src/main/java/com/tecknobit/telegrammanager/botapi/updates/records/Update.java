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
import org.json.JSONObject;

public class Update extends TelegramType {

    private final long updateId;

    private final Message message;

    private final Message editedMessage;

    private final Message channelPost;

    private final Message editeChannelPost;

    private final InlineQuery inlineQuery;

    private final ChosenInlineResult chosenInlineResult;

    private final CallbackQuery callbackQuery;

    private final ShippingQuery shippingQuery;

    private final PreCheckoutQuery preCheckoutQuery;

    private final Poll poll;

    private final PollAnswer pollAnswer;

    private final ChatMemberUpdated myChatMember;

    private final ChatMemberUpdated chatMember;

    private final ChatJoinRequest chatJoinRequest;

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

    public long getUpdateId() {
        return updateId;
    }

    public Message getMessage() {
        return message;
    }

    public Message getEditedMessage() {
        return editedMessage;
    }

    public Message getChannelPost() {
        return channelPost;
    }

    public Message getEditeChannelPost() {
        return editeChannelPost;
    }

    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }

    public ChosenInlineResult getChosenInlineResult() {
        return chosenInlineResult;
    }

    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    public ShippingQuery getShippingQuery() {
        return shippingQuery;
    }

    public PreCheckoutQuery getPreCheckoutQuery() {
        return preCheckoutQuery;
    }

    public Poll getPoll() {
        return poll;
    }

    public PollAnswer getPollAnswer() {
        return pollAnswer;
    }

    public ChatMemberUpdated getMyChatMember() {
        return myChatMember;
    }

    public ChatMemberUpdated getChatMember() {
        return chatMember;
    }

    public ChatJoinRequest getChatJoinRequest() {
        return chatJoinRequest;
    }

    public static Update getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Update(jItem);
    }

}
