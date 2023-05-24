package com.tecknobit.telegrammanager.botapi.records.basetypes.message;

import com.tecknobit.telegrammanager.botapi.records.basetypes.*;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONObject;

import java.util.ArrayList;

public class Message extends TelegramType {

    private final long messageId;

    private final long messageThreadId;

    private final User from;

    private final Chat senderChat;

    private final long date;

    private final Chat chat;

    private final User forwardFrom;

    private final Chat forwardFromChat;

    private final long forwardFromMessageId;

    private final String forwardSignature;

    private final String forwardSenderName;

    private final long forwardDate;

    private final boolean isTopicMessage;

    private final boolean isAutomaticForward;

    private final Message replyToMessage;

    private final User viaBot;

    private final long editDate;

    private final boolean hasProtectedContent;

    private final String mediaGroupId;

    private final String authorSignature;

    private final String text;

    private final ArrayList<MessageEntity> entities;

    private final Animation animation;

    private final Audio audio;

    private final TelegramDocument document;

    private final ArrayList<PhotoSize> photo;

    private final Sticker sticker;

    private final Video video;

    private final VideoNote videoNote;

    private final Voice voice;

    private final String caption;

    private final ArrayList<MessageEntity> captionEntities;

    private final boolean hasMediaSpoiler;

    private final Contact contact;

    private final Dice dice;

    private final Game game;

    private final Poll poll;

    private final Venue venue;

    private final Location location;

    private final ArrayList<User> newChatMembers;

    private final User leftChatMember;

    private final String newChatTitle;

    private final ArrayList<PhotoSize> newChatPhoto;

    private final boolean deleteChatPhoto;

    private final boolean groupChatCreated;

    private final boolean channelChatCreated;

    private final MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged;

    private final long migrateToChatId;

    private final long migrateFromChatId;

    private final Message pinnedMessage;

    private final Invoice invoice;

    private final SuccesfulPayment successfulPayment;

    private final UserShared userShared;

    private final ChatShared chatShared;

    private final String connectedWebsite;

    private final WriteAccessAllowed writeAccessAllowed;

    private final PassportData passportData;

    private final ProximityAlertTriggered proximityAlertTriggered;

    private final ForumTopicCreated forumTopicCreated;

    private final ForumTopicEdited forumTopicEdited;

    private final ForumTopicClosed forumTopicClosed;

    private final ForumTopicReopened forumTopicReopened;

    private final GeneralForumTopicHidden generalForumTopicHidden;

    private final GeneralForumTopicUnhidden generalForumTopicUnhidden;

    private final VideoChatScheduled videoChatScheduled;

    private final VideoChatStarted videoChatStarted;

    private final VideoChatEnded videoChatEnded;

    private final VideoChatParticipantsInvited videoChatParticipantsInvited;

    private final WebAppData webAppData;

    private final InlineKeyboardMarkup replyMarkup;

    public Message(long messageId, long messageThreadId, User from, Chat senderChat, long date, Chat chat,
                   User forwardFrom, Chat forwardFromChat, long forwardFromMessageId, String forwardSignature,
                   String forwardSenderName, long forwardDate, boolean isTopicMessage, boolean isAutomaticForward,
                   Message replyToMessage, User viaBot, long editDate, boolean hasProtectedContent, String mediaGroupId,
                   String authorSignature, String text, ArrayList<MessageEntity> entities, Animation animation,
                   Audio audio, TelegramDocument document, ArrayList<PhotoSize> photo, Sticker sticker, Video video,
                   VideoNote videoNote, Voice voice, String caption, ArrayList<MessageEntity> captionEntities,
                   boolean hasMediaSpoiler, Contact contact, Dice dice, Game game, Poll poll, Venue venue,
                   Location location, ArrayList<User> newChatMembers, User leftChatMember, String newChatTitle,
                   ArrayList<PhotoSize> newChatPhoto, boolean deleteChatPhoto, boolean groupChatCreated,
                   boolean channelChatCreated, MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged,
                   long migrateToChatId, long migrateFromChatId, Message pinnedMessage, Invoice invoice,
                   SuccesfulPayment successfulPayment, UserShared userShared, ChatShared chatShared, String connectedWebsite,
                   WriteAccessAllowed writeAccessAllowed, PassportData passportData,
                   ProximityAlertTriggered proximityAlertTriggered, ForumTopicCreated forumTopicCreated,
                   ForumTopicEdited forumTopicEdited, ForumTopicClosed forumTopicClosed,
                   ForumTopicReopened forumTopicReopened, GeneralForumTopicHidden generalForumTopicHidden,
                   GeneralForumTopicUnhidden generalForumTopicUnhidden, VideoChatScheduled videoChatScheduled,
                   VideoChatStarted videoChatStarted, VideoChatEnded videoChatEnded,
                   VideoChatParticipantsInvited videoChatParticipantsInvited, WebAppData webAppData,
                   InlineKeyboardMarkup replyMarkup) {
        super(null);
        this.messageId = messageId;
        this.messageThreadId = messageThreadId;
        this.from = from;
        this.senderChat = senderChat;
        this.date = date;
        this.chat = chat;
        this.forwardFrom = forwardFrom;
        this.forwardFromChat = forwardFromChat;
        this.forwardFromMessageId = forwardFromMessageId;
        this.forwardSignature = forwardSignature;
        this.forwardSenderName = forwardSenderName;
        this.forwardDate = forwardDate;
        this.isTopicMessage = isTopicMessage;
        this.isAutomaticForward = isAutomaticForward;
        this.replyToMessage = replyToMessage;
        this.viaBot = viaBot;
        this.editDate = editDate;
        this.hasProtectedContent = hasProtectedContent;
        this.mediaGroupId = mediaGroupId;
        this.authorSignature = authorSignature;
        this.text = text;
        this.entities = entities;
        this.animation = animation;
        this.audio = audio;
        this.document = document;
        this.photo = photo;
        this.sticker = sticker;
        this.video = video;
        this.videoNote = videoNote;
        this.voice = voice;
        this.caption = caption;
        this.captionEntities = captionEntities;
        this.hasMediaSpoiler = hasMediaSpoiler;
        this.contact = contact;
        this.dice = dice;
        this.game = game;
        this.poll = poll;
        this.venue = venue;
        this.location = location;
        this.newChatMembers = newChatMembers;
        this.leftChatMember = leftChatMember;
        this.newChatTitle = newChatTitle;
        this.newChatPhoto = newChatPhoto;
        this.deleteChatPhoto = deleteChatPhoto;
        this.groupChatCreated = groupChatCreated;
        this.channelChatCreated = channelChatCreated;
        this.messageAutoDeleteTimerChanged = messageAutoDeleteTimerChanged;
        this.migrateToChatId = migrateToChatId;
        this.migrateFromChatId = migrateFromChatId;
        this.pinnedMessage = pinnedMessage;
        this.invoice = invoice;
        this.successfulPayment = successfulPayment;
        this.userShared = userShared;
        this.chatShared = chatShared;
        this.connectedWebsite = connectedWebsite;
        this.writeAccessAllowed = writeAccessAllowed;
        this.passportData = passportData;
        this.proximityAlertTriggered = proximityAlertTriggered;
        this.forumTopicCreated = forumTopicCreated;
        this.forumTopicEdited = forumTopicEdited;
        this.forumTopicClosed = forumTopicClosed;
        this.forumTopicReopened = forumTopicReopened;
        this.generalForumTopicHidden = generalForumTopicHidden;
        this.generalForumTopicUnhidden = generalForumTopicUnhidden;
        this.videoChatScheduled = videoChatScheduled;
        this.videoChatStarted = videoChatStarted;
        this.videoChatEnded = videoChatEnded;
        this.videoChatParticipantsInvited = videoChatParticipantsInvited;
        this.webAppData = webAppData;
        this.replyMarkup = replyMarkup;
    }

    public Message(JSONObject jMessage) {
        super(jMessage);
        messageId = hTelegram.getLong("", 0);
        messageThreadId = hTelegram.getLong("", 0);
        from = User.getInstance(hTelegram.getJSONObject(""));
        senderChat = Chat.getInstance(hTelegram.getJSONObject(""));
        date = hTelegram.getLong("", -1);
        chat = Chat.getInstance(hTelegram.getJSONObject(""));
        forwardFrom = User.getInstance(hTelegram.getJSONObject(""));
        forwardFromChat = Chat.getInstance(hTelegram.getJSONObject(""));
        forwardFromMessageId = hTelegram.getLong("", 0);
        forwardSignature = hTelegram.getString("");
        forwardSenderName = hTelegram.getString("");
        forwardDate = hTelegram.getLong("", 0);
        isTopicMessage = hTelegram.getBoolean("");
        isAutomaticForward = hTelegram.getBoolean("");
        replyToMessage = Message.getInstance(hTelegram.getJSONObject(""));
        viaBot = User.getInstance(hTelegram.getJSONObject(""));
        editDate = hTelegram.getLong("", 0);
        hasProtectedContent = hTelegram.getBoolean("");
        mediaGroupId = hTelegram.getString("");
        authorSignature = hTelegram.getString("");
        text = hTelegram.getString("");
        entities = entities;
        animation = Animation.getInstance(hTelegram.getJSONObject(""));
        audio = Audio.getInstance(hTelegram.getJSONObject(""));
        document = TelegramDocument.getInstance(hTelegram.getJSONObject(""));
        photo = photo;
        sticker = Sticker.getInstance(hTelegram.getJSONObject(""));
        video = Video.getInstance(hTelegram.getJSONObject(""));
        videoNote = VideoNote.getInstance(hTelegram.getJSONObject(""));
        voice = Voice.getInstance(hTelegram.getJSONObject(""));
        caption = hTelegram.getString("");
        captionEntities = captionEntities;
        hasMediaSpoiler = hTelegram.getBoolean("");
        contact = Contact.getInstance(hTelegram.getJSONObject(""));
        dice = Dice.getInstance(hTelegram.getJSONObject(""));
        game = Game.getInstance(hTelegram.getJSONObject(""));
        poll = Poll.getInstance(hTelegram.getJSONObject(""));
        venue = Venue.getInstance(hTelegram.getJSONObject(""));
        location = Location.getInstance(hTelegram.getJSONObject(""));
        newChatMembers = newChatMembers;
        leftChatMember = User.getInstance(hTelegram.getJSONObject(""));
        newChatTitle = hTelegram.getString("");
        newChatPhoto = newChatPhoto;
        deleteChatPhoto = hTelegram.getBoolean("");
        groupChatCreated = hTelegram.getBoolean("");
        channelChatCreated = hTelegram.getBoolean("");
        messageAutoDeleteTimerChanged = MessageAutoDeleteTimerChanged.getInstance(hTelegram.getJSONObject(""));
        migrateToChatId = hTelegram.getLong("", 0);
        migrateFromChatId = hTelegram.getLong("", 0);
        pinnedMessage = Message.getInstance(hTelegram.getJSONObject(""));
        invoice = Invoice.getInstance(hTelegram.getJSONObject(""));
        successfulPayment = SuccesfulPayment.getInstance(hTelegram.getJSONObject(""));
        userShared = UserShared.getInstance(hTelegram.getJSONObject(""));
        chatShared = ChatShared.getInstance(hTelegram.getJSONObject(""));
        connectedWebsite = hTelegram.getString("");
        writeAccessAllowed = WriteAccessAllowed.getInstance(hTelegram.getJSONObject(""));
        passportData = PassportData.getInstance(hTelegram.getJSONObject(""));
        proximityAlertTriggered = ProximityAlertTriggered.getInstance(hTelegram.getJSONObject(""));
        forumTopicCreated = ForumTopicCreated.getInstance(hTelegram.getJSONObject(""));
        forumTopicEdited = ForumTopicEdited.getInstance(hTelegram.getJSONObject(""));
        forumTopicClosed = ForumTopicClosed.getInstance(hTelegram.getJSONObject(""));
        forumTopicReopened = ForumTopicReopened.getInstance(hTelegram.getJSONObject(""));
        generalForumTopicHidden = GeneralForumTopicHidden.getInstance(hTelegram.getJSONObject(""));
        generalForumTopicUnhidden = GeneralForumTopicUnhidden.getInstance(hTelegram.getJSONObject(""));
        videoChatScheduled = VideoChatScheduled.getInstance(hTelegram.getJSONObject(""));
        videoChatStarted = VideoChatStarted.getInstance(hTelegram.getJSONObject(""));
        videoChatEnded = VideoChatEnded.getInstance(hTelegram.getJSONObject(""));
        videoChatParticipantsInvited = VideoChatParticipantsInvited.getInstance(hTelegram.getJSONObject(""));
        webAppData = WebAppData.getInstance(hTelegram.getJSONObject(""));
        replyMarkup = InlineKeyboardMarkup.getInstance(hTelegram.getJSONObject(""));
    }

    public long getMessageId() {
        return messageId;
    }

    public long getMessageThreadId() {
        return messageThreadId;
    }

    public User getFrom() {
        return from;
    }

    public Chat getSenderChat() {
        return senderChat;
    }

    public long getDate() {
        return date;
    }

    public Chat getChat() {
        return chat;
    }

    public User getForwardFrom() {
        return forwardFrom;
    }

    public Chat getForwardFromChat() {
        return forwardFromChat;
    }

    public long getForwardFromMessageId() {
        return forwardFromMessageId;
    }

    public String getForwardSignature() {
        return forwardSignature;
    }

    public String getForwardSenderName() {
        return forwardSenderName;
    }

    public long getForwardDate() {
        return forwardDate;
    }

    public boolean isTopicMessage() {
        return isTopicMessage;
    }

    public boolean isAutomaticForward() {
        return isAutomaticForward;
    }

    public Message getReplyToMessage() {
        return replyToMessage;
    }

    public User getViaBot() {
        return viaBot;
    }

    public long getEditDate() {
        return editDate;
    }

    public boolean hasProtectedContent() {
        return hasProtectedContent;
    }

    public String getMediaGroupId() {
        return mediaGroupId;
    }

    public String getAuthorSignature() {
        return authorSignature;
    }

    public String getText() {
        return text;
    }

    public ArrayList<MessageEntity> getEntities() {
        return entities;
    }

    public Animation getAnimation() {
        return animation;
    }

    public Audio getAudio() {
        return audio;
    }

    public TelegramDocument getDocument() {
        return document;
    }

    public ArrayList<PhotoSize> getPhoto() {
        return photo;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public Video getVideo() {
        return video;
    }

    public VideoNote getVideoNote() {
        return videoNote;
    }

    public Voice getVoice() {
        return voice;
    }

    public String getCaption() {
        return caption;
    }

    public ArrayList<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    public boolean hasMediaSpoiler() {
        return hasMediaSpoiler;
    }

    public Contact getContact() {
        return contact;
    }

    public Dice getDice() {
        return dice;
    }

    public Game getGame() {
        return game;
    }

    public Poll getPoll() {
        return poll;
    }

    public Venue getVenue() {
        return venue;
    }

    public Location getLocation() {
        return location;
    }

    public ArrayList<User> getNewChatMembers() {
        return newChatMembers;
    }

    public User getLeftChatMember() {
        return leftChatMember;
    }

    public String getNewChatTitle() {
        return newChatTitle;
    }

    public ArrayList<PhotoSize> getNewChatPhoto() {
        return newChatPhoto;
    }

    public boolean isDeletedChatPhoto() {
        return deleteChatPhoto;
    }

    public boolean isGroupChatCreated() {
        return groupChatCreated;
    }

    public boolean isChannelChatCreated() {
        return channelChatCreated;
    }

    public MessageAutoDeleteTimerChanged getMessageAutoDeleteTimerChanged() {
        return messageAutoDeleteTimerChanged;
    }

    public long getMigrateToChatId() {
        return migrateToChatId;
    }

    public long getMigrateFromChatId() {
        return migrateFromChatId;
    }

    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public SuccesfulPayment getSuccessfulPayment() {
        return successfulPayment;
    }

    public UserShared getUserShared() {
        return userShared;
    }

    public ChatShared getChatShared() {
        return chatShared;
    }

    public String getConnectedWebsite() {
        return connectedWebsite;
    }

    public WriteAccessAllowed getWriteAccessAllowed() {
        return writeAccessAllowed;
    }

    public PassportData getPassportData() {
        return passportData;
    }

    public ProximityAlertTriggered getProximityAlertTriggered() {
        return proximityAlertTriggered;
    }

    public ForumTopicCreated getForumTopicCreated() {
        return forumTopicCreated;
    }

    public ForumTopicEdited getForumTopicEdited() {
        return forumTopicEdited;
    }

    public ForumTopicClosed getForumTopicClosed() {
        return forumTopicClosed;
    }

    public ForumTopicReopened getForumTopicReopened() {
        return forumTopicReopened;
    }

    public GeneralForumTopicHidden getGeneralForumTopicHidden() {
        return generalForumTopicHidden;
    }

    public GeneralForumTopicUnhidden getGeneralForumTopicUnhidden() {
        return generalForumTopicUnhidden;
    }

    public VideoChatScheduled getVideoChatScheduled() {
        return videoChatScheduled;
    }

    public VideoChatStarted getVideoChatStarted() {
        return videoChatStarted;
    }

    public VideoChatEnded getVideoChatEnded() {
        return videoChatEnded;
    }

    public VideoChatParticipantsInvited getVideoChatParticipantsInvited() {
        return videoChatParticipantsInvited;
    }

    public WebAppData getWebAppData() {
        return webAppData;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public static Message getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Message(jItem);
    }

}
