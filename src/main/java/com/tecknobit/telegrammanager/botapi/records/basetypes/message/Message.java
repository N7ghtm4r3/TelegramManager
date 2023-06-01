package com.tecknobit.telegrammanager.botapi.records.basetypes.message;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.basetypes.ItemShared;
import com.tecknobit.telegrammanager.botapi.records.basetypes.WriteAccessAllowed;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.Chat;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.MessageAutoDeleteTimerChanged;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.Dice;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.Poll;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.ProximityAlertTriggered;
import com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.games.Game;
import com.tecknobit.telegrammanager.botapi.records.basetypes.forum.*;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.*;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.stickers.Sticker;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.videochatstates.VideoChatEnded;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.videochatstates.VideoChatParticipantsInvited;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.videochatstates.VideoChatScheduled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.media.videochatstates.VideoChatStarted;
import com.tecknobit.telegrammanager.botapi.records.basetypes.payments.Invoice;
import com.tecknobit.telegrammanager.botapi.records.basetypes.payments.SuccessfulPayment;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.Contact;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.Location;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.Venue;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.passport.PassportData;
import com.tecknobit.telegrammanager.botapi.records.basetypes.webapp.WebAppData;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import static com.tecknobit.telegrammanager.botapi.managers.TelegramBotManager.ReturnFormat;
import static com.tecknobit.telegrammanager.botapi.managers.TelegramBotManager.getResultFromList;

/**
 * The {@code Message} class is useful to format a {@code Telegram}'s message
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#message">
 * Message</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class Message extends TelegramType {

    /**
     * {@code messageId} unique message identifier inside this chat
     */
    private final long messageId;

    /**
     * {@code messageThreadId} unique identifier of a message thread to which the message belongs; for supergroups only
     */
    private final long messageThreadId;

    /**
     * {@code from} sender of the message; empty for messages sent to channels. For backward compatibility, the field
     * contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat
     */
    private final User from;

    /**
     * {@code senderChat} sender of the message, sent on behalf of a chat. For example, the channel itself for channel
     * posts, the supergroup itself for messages from anonymous group administrators, the linked channel for messages
     * automatically forwarded to the discussion group. For backward compatibility, the field from contains a fake
     * sender user in non-channel chats, if the message was sent on behalf of a chat
     */
    private final Chat senderChat;

    /**
     * {@code date} date the message was sent in Unix time
     */
    private final long date;

    /**
     * {@code chat} conversation the message belongs to
     */
    private final Chat chat;

    /**
     * {@code forwardFrom} for forwarded messages, sender of the original message
     */
    private final User forwardFrom;

    /**
     * {@code forwardFromChat} for messages forwarded from channels or from anonymous administrators, information about
     * the original sender chat
     */
    private final Chat forwardFromChat;

    /**
     * {@code forwardFromMessageId} for messages forwarded from channels, identifier of the original message in the channel
     */
    private final long forwardFromMessageId;

    /**
     * {@code forwardSignature} for forwarded messages that were originally sent in channels or by an anonymous chat
     * administrator, signature of the message sender if present
     */
    private final String forwardSignature;

    /**
     * {@code forwardSenderName} sender's name for messages forwarded from users who disallow adding a link to their
     * account in forwarded messages
     */
    private final String forwardSenderName;

    /**
     * {@code forwardDate} for forwarded messages, date the original message was sent in Unix time
     */
    private final long forwardDate;

    /**
     * {@code isTopicMessage} if the message is sent to a forum topic
     */
    private final boolean isTopicMessage;

    /**
     * {@code isAutomaticForward} if the message is a channel post that was automatically forwarded to the connected
     * discussion group
     */
    private final boolean isAutomaticForward;

    /**
     * {@code replyToMessage} for replies, the original message. Note that the Message object in this field will not
     * contain further reply_to_message fields even if it itself is a reply.
     */
    private final Message replyToMessage;

    /**
     * {@code viaBot} bot through which the message was sent
     */
    private final User viaBot;

    /**
     * {@code editDate} date the message was last edited in Unix time
     */
    private final long editDate;

    /**
     * {@code hasProtectedContent} if the message can't be forwarded
     */
    private final boolean hasProtectedContent;

    /**
     * {@code mediaGroupId} the unique identifier of a media message group this message belongs to
     */
    private final String mediaGroupId;

    /**
     * {@code authorSignature} signature of the post author for messages in channels, or the custom title of an anonymous
     * group administrator
     */
    private final String authorSignature;

    /**
     * {@code text} for text messages, the actual UTF-8 text of the message
     */
    private final String text;

    /**
     * {@code entities} for text messages, special entities like usernames, URLs, bot commands, etc. that appear in the
     * text
     */
    private final ArrayList<MessageEntity> entities;

    /**
     * {@code animation} message is an animation, information about the animation. For backward compatibility, when this
     * field is set, the document field will also be set
     */
    private final Video animation;

    /**
     * {@code audio} message is an audio file, information about the file
     */
    private final Audio audio;

    /**
     * {@code document} message is a general file, information about the file
     */
    private final TelegramDocument document;

    /**
     * {@code photo} message is a photo, available sizes of the photo
     */
    private final ArrayList<PhotoSize> photo;

    /**
     * {@code sticker} message is a sticker, information about the sticker
     */
    private final Sticker sticker;

    /**
     * {@code video} message is a video, information about the video
     */
    private final Video video;

    /**
     * {@code videoNote} message is a video note, information about the video message
     */
    private final VideoNote videoNote;

    /**
     * {@code voice} message is a voice message, information about the file
     */
    private final Voice voice;

    /**
     * {@code caption} caption for the animation, audio, document, photo, video or voice
     */
    private final String caption;

    /**
     * {@code captionEntities} for messages with a caption, special entities like usernames, URLs, bot commands, etc.
     * that appear in the caption
     */
    private final ArrayList<MessageEntity> captionEntities;

    /**
     * {@code hasMediaSpoiler} if the message media is covered by a spoiler animation
     */
    private final boolean hasMediaSpoiler;

    /**
     * {@code contact} message is a shared contact, information about the contact
     */
    private final Contact contact;

    /**
     * {@code dice} message is a dice with random value
     */
    private final Dice dice;

    /**
     * {@code game} message is a game, information about the game
     */
    private final Game game;

    /**
     * {@code poll} message is a native poll, information about the poll
     */
    private final Poll poll;

    /**
     * {@code venue} message is a venue, information about the venue. For backward compatibility, when this field is set,
     * the location field will also be set
     */
    private final Venue venue;

    /**
     * {@code location} message is a shared location, information about the location
     */
    private final Location location;

    /**
     * {@code newChatMembers} new members that were added to the group or supergroup and information about them
     * (the bot itself may be one of these members)
     */
    private final ArrayList<User> newChatMembers;

    /**
     * {@code leftChatMember} a member was removed from the group, information about them (this member may be the bot itself)
     */
    private final User leftChatMember;

    /**
     * {@code newChatTitle} a chat title was changed to this value
     */
    private final String newChatTitle;

    /**
     * {@code newChatPhoto} a chat photo was change to this value
     */
    private final ArrayList<PhotoSize> newChatPhoto;

    /**
     * {@code deleteChatPhoto} service message: the chat photo was deleted
     */
    private final boolean deleteChatPhoto;

    /**
     * {@code groupChatCreated} service message: the group has been created
     */
    private final boolean groupChatCreated;

    /**
     * {@code supergroupChatCreated} service message: the supergroup has been created. This field can't be received in
     * a message coming through updates, because bot can't be a member of a supergroup when it is created. It can only
     * be found in reply_to_message if someone replies to a very first message in a directly created supergroup
     */
    private final boolean supergroupChatCreated;

    /**
     * {@code channelChatCreated} service message: the channel has been created. This field can't be received in a
     * message coming through updates, because bot can't be a member of a channel when it is created. It can only be
     * found in reply_to_message if someone replies to a very first message in a channel
     */
    private final boolean channelChatCreated;

    /**
     * {@code messageAutoDeleteTimerChanged} service message: auto-delete timer settings changed in the chat
     */
    private final MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged;

    /**
     * {@code migrateToChatId} the group has been migrated to a supergroup with the specified identifier. This number
     * may have more than 32 significant bits and some programming languages may have difficulty/silent defects in
     * interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float
     * type are safe for storing this identifier
     */
    private final long migrateToChatId;

    /**
     * {@code migrateFromChatId} the supergroup has been migrated from a group with the specified identifier. This number
     * may have more than 32 significant bits and some programming languages may have difficulty/silent defects in
     * interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type
     * are safe for storing this identifier
     */
    private final long migrateFromChatId;

    /**
     * {@code pinnedMessage} specified message was pinned. Note that the Message object in this field will not contain
     * further reply_to_message fields even if it is itself a reply
     */
    private final Message pinnedMessage;

    /**
     * {@code invoice} message is an invoice for a payment, information about the invoice
     */
    private final Invoice invoice;

    /**
     * {@code successfulPayment} message is a service message about a successful payment, information about the payment
     */
    private final SuccessfulPayment successfulPayment;

    /**
     * {@code userShared} service message: a user was shared with the bot
     */
    private final ItemShared userShared;

    /**
     * {@code chatShared} service message: a chat was shared with the bot
     */
    private final ItemShared chatShared;

    /**
     * {@code connectedWebsite} the domain name of the website on which the user has logged in
     */
    private final String connectedWebsite;

    /**
     * {@code writeAccessAllowed} service message: the user allowed the bot added to the attachment menu to write messages
     */
    private final WriteAccessAllowed writeAccessAllowed;

    /**
     * {@code passportData} Telegram Passport data
     */
    private final PassportData passportData;

    /**
     * {@code proximityAlertTriggered} service message. A user in the chat triggered another user's proximity alert while
     * sharing Live Location
     */
    private final ProximityAlertTriggered proximityAlertTriggered;

    /**
     * {@code forumTopicCreated} service message: forum topic created
     */
    private final ForumTopicCreated forumTopicCreated;

    /**
     * {@code forumTopicEdited} service message: forum topic edited
     */
    private final ForumTopicEdited forumTopicEdited;

    /**
     * {@code forumTopicClosed} service message: forum topic closed
     */
    private final ForumTopicClosed forumTopicClosed;

    /**
     * {@code forumTopicReopened} service message: forum topic reopened
     */
    private final ForumTopicReopened forumTopicReopened;

    /**
     * {@code generalForumTopicHidden} service message: the 'General' forum topic hidden
     */
    private final GeneralForumTopicHidden generalForumTopicHidden;

    /**
     * {@code generalForumTopicUnhidden} service message: the 'General' forum topic unhidden
     */
    private final GeneralForumTopicUnhidden generalForumTopicUnhidden;

    /**
     * {@code videoChatScheduled} service message: video chat scheduled
     */
    private final VideoChatScheduled videoChatScheduled;

    /**
     * {@code videoChatStarted} service message: video chat started
     */
    private final VideoChatStarted videoChatStarted;

    /**
     * {@code videoChatEnded} service message: video chat ended
     */
    private final VideoChatEnded videoChatEnded;

    /**
     * {@code videoChatParticipantsInvited} service message: new participants invited to a video chat
     */
    private final VideoChatParticipantsInvited videoChatParticipantsInvited;

    /**
     * {@code webAppData} service message: data sent by a Web App
     */
    private final WebAppData webAppData;

    /**
     * {@code replyMarkup} inline keyboard attached to the message. login_url buttons are represented as ordinary
     * url buttons
     */
    private final InlineKeyboardMarkup replyMarkup;

    /**
     * Constructor to init a {@link Message} object
     *
     * @param messageId:                     unique message identifier inside this chat
     * @param messageThreadId:               unique identifier of a message thread to which the message belongs; for supergroups only
     * @param from:                          sender of the message; empty for messages sent to channels. For backward compatibility, the field
     *                                       contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat
     * @param senderChat:                    sender of the message, sent on behalf of a chat. For example, the channel itself for channel
     *                                       posts, the supergroup itself for messages from anonymous group administrators, the linked channel
     *                                       for messages automatically forwarded to the discussion group. For backward compatibility, the
     *                                       field from contains a fake sender user in non-channel chats, if the message was sent on behalf of a cha
     * @param date:                          date the message was sent in Unix time
     * @param chat:                          conversation the message belongs to
     * @param forwardFrom:                   for forwarded messages, sender of the original message
     * @param forwardFromChat:               for messages forwarded from channels or from anonymous administrators, information about
     *                                       the original sender chat
     * @param forwardFromMessageId:          for messages forwarded from channels, identifier of the original message in the channel
     * @param forwardSignature:              for forwarded messages that were originally sent in channels or by an anonymous chat
     *                                       administrator, signature of the message sender if present
     * @param forwardSenderName:             sender's name for messages forwarded from users who disallow adding a link to their
     *                                       account in forwarded messages
     * @param forwardDate:                   for forwarded messages, date the original message was sent in Unix time
     * @param isTopicMessage:                if the message is sent to a forum topic
     * @param isAutomaticForward:            if the message is a channel post that was automatically forwarded to the connected
     *                                       discussion group
     * @param replyToMessage:                for replies, the original message. Note that the Message object in this field will not
     *                                       contain further reply_to_message fields even if it itself is a reply
     * @param viaBot:bot                     through which the message was sent
     * @param editDate:date                  the message was last edited in Unix time
     * @param hasProtectedContent:           if the message can't be forwarded
     * @param mediaGroupId:                  the unique identifier of a media message group this message belongs to
     * @param authorSignature:               signature of the post author for messages in channels, or the custom title of an anonymous
     *                                       group administrator
     * @param text:                          for text messages, the actual UTF-8 text of the message
     * @param entities:                      for text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
     * @param animation:                     message is an animation, information about the animation. For backward compatibility, when this
     *                                       field is set, the document field will also be set
     * @param audio:                         message is an audio file, information about the file
     * @param document:message               is a general file, information about the file
     * @param photo:                         message is a photo, available sizes of the photo
     * @param sticker:                       message is a sticker, information about the sticker
     * @param video:                         message is a video, information about the video
     * @param videoNote:                     message is a video note, information about the video message
     * @param voice:                         message is a voice message, information about the file
     * @param caption:                       caption for the animation, audio, document, photo, video or voice
     * @param captionEntities:               for messages with a caption, special entities like usernames, URLs, bot commands, etc.
     *                                       that appear in the caption
     * @param hasMediaSpoiler:               if the message media is covered by a spoiler animation
     * @param contact:                       message is a shared contact, information about the contact
     * @param dice:                          message is a dice with random value
     * @param game:                          message is a game, information about the game
     * @param poll:                          message is a native poll, information about the poll
     * @param venue:                         message is a venue, information about the venue. For backward compatibility, when this field is set,
     *                                       the location field will also be set
     * @param location:                      message is a shared location, information about the location
     * @param newChatMembers:                new members that were added to the group or supergroup and information about them (the bot
     *                                       itself may be one of these members)
     * @param leftChatMember:                member was removed from the group, information about them (this member may be the bot itself)
     * @param newChatTitle:                  chat title was changed to this value
     * @param newChatPhoto:                  chat photo was change to this value
     * @param deleteChatPhoto:               service message: the chat photo was deleted
     * @param groupChatCreated:              service message: the group has been created
     * @param supergroupChatCreated:         service message: the supergroup has been created. This field can't be received in a
     *                                       message coming through updates, because bot can't be a member of a supergroup when it
     *                                       is created. It can only be found in reply_to_message if someone replies to a very first
     *                                       message in a directly created supergroup
     * @param channelChatCreated:            service message: the channel has been created. This field can't be received in a
     *                                       message coming through updates, because bot can't be a member of a channel when it is
     *                                       created. It can only be found in reply_to_message if someone replies to a very first
     *                                       message in a channel
     * @param messageAutoDeleteTimerChanged: service message: auto-delete timer settings changed in the chat
     * @param migrateToChatId:               the group has been migrated to a supergroup with the specified identifier. This number
     *                                       may have more than 32 significant bits and some programming languages may have
     *                                       difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
     *                                       signed 64-bit integer or double-precision float type are safe for storing this identifier
     * @param migrateFromChatId:             the supergroup has been migrated from a group with the specified identifier. This number
     *                                       may have more than 32 significant bits and some programming languages may have
     *                                       difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so
     *                                       a signed 64-bit integer or double-precision float type are safe for storing this identifier
     * @param pinnedMessage:                 specified message was pinned. Note that the Message object in this field will not contain
     *                                       further reply_to_message fields even if it is itself a reply
     * @param invoice:                       message is an invoice for a payment, information about the invoice
     * @param successfulPayment:             message is a service message about a successful payment, information about the payment
     * @param userShared:                    service message: a user was shared with the bot
     * @param chatShared:                    service message: a chat was shared with the bot
     * @param connectedWebsite:              the domain name of the website on which the user has logged in
     * @param writeAccessAllowed:            service message: the user allowed the bot added to the attachment menu to write messages
     * @param passportData:                  Telegram Passport data
     * @param proximityAlertTriggered:       service message. A user in the chat triggered another user's proximity alert
     *                                       while sharing Live Location
     * @param forumTopicCreated:             service message: forum topic created
     * @param forumTopicEdited:              service message: forum topic edited
     * @param forumTopicClosed:              service message: forum topic closed
     * @param forumTopicReopened:            service message: forum topic reopened
     * @param generalForumTopicHidden:       service message: the 'General' forum topic hidden
     * @param generalForumTopicUnhidden:     service message: the 'General' forum topic unhidden
     * @param videoChatScheduled:            service message: video chat scheduled
     * @param videoChatStarted:              service message: video chat started
     * @param videoChatEnded:                service message: video chat ended
     * @param videoChatParticipantsInvited:  service message: new participants invited to a video chat
     * @param webAppData:                    service message: data sent by a Web App
     * @param replyMarkup:                   inline keyboard attached to the message. login_url buttons are represented as ordinary url buttons
     */
    public Message(long messageId, long messageThreadId, User from, Chat senderChat, long date, Chat chat,
                   User forwardFrom, Chat forwardFromChat, long forwardFromMessageId, String forwardSignature,
                   String forwardSenderName, long forwardDate, boolean isTopicMessage, boolean isAutomaticForward,
                   Message replyToMessage, User viaBot, long editDate, boolean hasProtectedContent, String mediaGroupId,
                   String authorSignature, String text, ArrayList<MessageEntity> entities, Video animation,
                   Audio audio, TelegramDocument document, ArrayList<PhotoSize> photo, Sticker sticker, Video video,
                   VideoNote videoNote, Voice voice, String caption, ArrayList<MessageEntity> captionEntities,
                   boolean hasMediaSpoiler, Contact contact, Dice dice, Game game, Poll poll, Venue venue,
                   Location location, ArrayList<User> newChatMembers, User leftChatMember, String newChatTitle,
                   ArrayList<PhotoSize> newChatPhoto, boolean deleteChatPhoto, boolean groupChatCreated,
                   boolean supergroupChatCreated, boolean channelChatCreated, MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged,
                   long migrateToChatId, long migrateFromChatId, Message pinnedMessage, Invoice invoice,
                   SuccessfulPayment successfulPayment, ItemShared userShared, ItemShared chatShared, String connectedWebsite,
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
        this.supergroupChatCreated = supergroupChatCreated;
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

    /**
     * Constructor to init a {@link Message} object
     *
     * @param jMessage: message details as {@link JSONObject}
     */
    public Message(JSONObject jMessage) {
        super(jMessage);
        messageId = hTelegram.getLong("message_id", 0);
        messageThreadId = hTelegram.getLong("message_thread_id", 0);
        from = User.getInstance(hTelegram.getJSONObject("from"));
        senderChat = Chat.getInstance(hTelegram.getJSONObject("sender_chat"));
        date = hTelegram.getLong("date", -1);
        chat = Chat.getInstance(hTelegram.getJSONObject("chat"));
        forwardFrom = User.getInstance(hTelegram.getJSONObject("forward_from"));
        forwardFromChat = Chat.getInstance(hTelegram.getJSONObject("forward_from_chat"));
        forwardFromMessageId = hTelegram.getLong("forward_from_message_id", 0);
        forwardSignature = hTelegram.getString("forward_signature");
        forwardSenderName = hTelegram.getString("forward_sender_name");
        forwardDate = hTelegram.getLong("forward_date", 0);
        isTopicMessage = hTelegram.getBoolean("is_topic_message");
        isAutomaticForward = hTelegram.getBoolean("is_automatic_forward");
        replyToMessage = Message.getInstance(hTelegram.getJSONObject("reply_to_message"));
        viaBot = User.getInstance(hTelegram.getJSONObject("via_bot"));
        editDate = hTelegram.getLong("edit_date", 0);
        hasProtectedContent = hTelegram.getBoolean("has_protected_content");
        mediaGroupId = hTelegram.getString("media_group_id");
        authorSignature = hTelegram.getString("author_signature");
        text = hTelegram.getString("text");
        entities = MessageEntity.returnMessageEntities(hTelegram.getJSONArray("entities"));
        animation = Video.getInstance(hTelegram.getJSONObject("animation"));
        audio = Audio.getInstance(hTelegram.getJSONObject("audio"));
        document = TelegramDocument.getInstance(hTelegram.getJSONObject("document"));
        photo = PhotoSize.returnPhotoSizes(hTelegram.getJSONArray("photo"));
        sticker = Sticker.getInstance(hTelegram.getJSONObject("sticker"));
        video = Video.getInstance(hTelegram.getJSONObject("video"));
        videoNote = VideoNote.getInstance(hTelegram.getJSONObject("video_note"));
        voice = Voice.getInstance(hTelegram.getJSONObject("voice"));
        caption = hTelegram.getString("caption");
        captionEntities = MessageEntity.returnMessageEntities(hTelegram.getJSONArray("caption_entities"));
        hasMediaSpoiler = hTelegram.getBoolean("has_media_spoiler");
        contact = Contact.getInstance(hTelegram.getJSONObject("contact"));
        dice = Dice.getInstance(hTelegram.getJSONObject("dice"));
        game = Game.getInstance(hTelegram.getJSONObject("game"));
        poll = Poll.getInstance(hTelegram.getJSONObject("poll"));
        venue = Venue.getInstance(hTelegram.getJSONObject("venue"));
        location = Location.getInstance(hTelegram.getJSONObject("location"));
        newChatMembers = User.returnUsers(hTelegram.getJSONArray("new_chat_members"));
        leftChatMember = User.getInstance(hTelegram.getJSONObject("left_chat_member"));
        newChatTitle = hTelegram.getString("new_chat_title");
        newChatPhoto = PhotoSize.returnPhotoSizes(hTelegram.getJSONArray("new_chat_photo"));
        deleteChatPhoto = hTelegram.getBoolean("delete_chat_photo");
        groupChatCreated = hTelegram.getBoolean("group_chat_created");
        supergroupChatCreated = hTelegram.getBoolean("supergroup_chat_created");
        channelChatCreated = hTelegram.getBoolean("channel_chat_created");
        messageAutoDeleteTimerChanged = MessageAutoDeleteTimerChanged
                .getInstance(hTelegram.getJSONObject("message_auto_delete_timer_changed"));
        migrateToChatId = hTelegram.getLong("migrate_to_chat_id", 0);
        migrateFromChatId = hTelegram.getLong("migrate_from_chat_id", 0);
        pinnedMessage = Message.getInstance(hTelegram.getJSONObject("pinned_message"));
        invoice = Invoice.getInstance(hTelegram.getJSONObject("invoice"));
        successfulPayment = SuccessfulPayment.getInstance(hTelegram.getJSONObject("successful_payment"));
        userShared = ItemShared.getInstance(hTelegram.getJSONObject("user_shared"));
        chatShared = ItemShared.getInstance(hTelegram.getJSONObject("chat_shared"));
        connectedWebsite = hTelegram.getString("connected_website");
        writeAccessAllowed = WriteAccessAllowed.getInstance(hTelegram.getJSONObject("write_access_allowed"));
        passportData = PassportData.getInstance(hTelegram.getJSONObject("passport_data"));
        proximityAlertTriggered = ProximityAlertTriggered
                .getInstance(hTelegram.getJSONObject("proximity_alert_triggered"));
        forumTopicCreated = ForumTopicCreated.getInstance(hTelegram.getJSONObject("forum_topic_created"));
        forumTopicEdited = ForumTopicEdited.getInstance(hTelegram.getJSONObject("forum_topic_edited"));
        forumTopicClosed = ForumTopicClosed.getInstance(hTelegram.getJSONObject("forum_topic_closed"));
        forumTopicReopened = ForumTopicReopened.getInstance(hTelegram.getJSONObject("forum_topic_reopened"));
        generalForumTopicHidden = GeneralForumTopicHidden
                .getInstance(hTelegram.getJSONObject("general_forum_topic_hidden"));
        generalForumTopicUnhidden = GeneralForumTopicUnhidden
                .getInstance(hTelegram.getJSONObject("general_forum_topic_unhidden"));
        videoChatScheduled = VideoChatScheduled.getInstance(hTelegram.getJSONObject("video_chat_scheduled"));
        videoChatStarted = VideoChatStarted.getInstance(hTelegram.getJSONObject("video_chat_started"));
        videoChatEnded = VideoChatEnded.getInstance(hTelegram.getJSONObject("video_chat_ended"));
        videoChatParticipantsInvited = VideoChatParticipantsInvited
                .getInstance(hTelegram.getJSONObject("video_chat_participants_invited"));
        webAppData = WebAppData.getInstance(hTelegram.getJSONObject("web_app_data"));
        replyMarkup = InlineKeyboardMarkup.getInstance(hTelegram.getJSONObject("reply_markup"));
    }

    /**
     * Method to get {@link #messageId} instance <br>
     * No-any params required
     *
     * @return {@link #messageId} instance as long
     */
    public long getMessageId() {
        return messageId;
    }

    /**
     * Method to get {@link #messageThreadId} instance <br>
     * No-any params required
     *
     * @return {@link #messageThreadId} instance as long
     */
    public long getMessageThreadId() {
        return messageThreadId;
    }

    /**
     * Method to get {@link #from} instance <br>
     * No-any params required
     *
     * @return {@link #from} instance as {@link User}
     */
    public User getFrom() {
        return from;
    }

    /**
     * Method to get {@link #senderChat} instance <br>
     * No-any params required
     *
     * @return {@link #senderChat} instance as {@link Chat}
     */
    public Chat getSenderChat() {
        return senderChat;
    }

    /**
     * Method to get {@link #date} instance <br>
     * No-any params required
     *
     * @return {@link #date} instance as long
     */
    public long getDateTimestamp() {
        return date;
    }

    /**
     * Method to get {@link #date} instance <br>
     * No-any params required
     *
     * @return {@link #date} instance as {@link Date}
     */
    public Date getDate() {
        return getDateValue(date);
    }

    /**
     * Method to get {@link #chat} instance <br>
     * No-any params required
     *
     * @return {@link #chat} instance as {@link Chat}
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * Method to get {@link #forwardFrom} instance <br>
     * No-any params required
     *
     * @return {@link #forwardFrom} instance as {@link User}
     */
    public User getForwardFrom() {
        return forwardFrom;
    }

    /**
     * Method to get {@link #forwardFromChat} instance <br>
     * No-any params required
     *
     * @return {@link #forwardFromChat} instance as {@link Chat}
     */
    public Chat getForwardFromChat() {
        return forwardFromChat;
    }

    /**
     * Method to get {@link #forwardFromMessageId} instance <br>
     * No-any params required
     *
     * @return {@link #forwardFromMessageId} instance as long
     */
    public long getForwardFromMessageId() {
        return forwardFromMessageId;
    }

    /**
     * Method to get {@link #forwardSignature} instance <br>
     * No-any params required
     *
     * @return {@link #forwardSignature} instance as {@link String}
     */
    public String getForwardSignature() {
        return forwardSignature;
    }

    /**
     * Method to get {@link #forwardSenderName} instance <br>
     * No-any params required
     *
     * @return {@link #forwardSenderName} instance as {@link String}
     */
    public String getForwardSenderName() {
        return forwardSenderName;
    }

    /**
     * Method to get {@link #forwardDate} instance <br>
     * No-any params required
     *
     * @return {@link #forwardDate} instance as long
     */
    public long getForwardDateTimestamp() {
        return forwardDate;
    }

    /**
     * Method to get {@link #forwardDate} instance <br>
     * No-any params required
     *
     * @return {@link #forwardDate} instance as {@link Date}
     */
    public Date getForwardDate() {
        return getDateValue(forwardDate);
    }

    /**
     * Method to get {@link #isTopicMessage} instance <br>
     * No-any params required
     *
     * @return {@link #isTopicMessage} instance as boolean
     */
    public boolean isTopicMessage() {
        return isTopicMessage;
    }

    /**
     * Method to get {@link #isAutomaticForward} instance <br>
     * No-any params required
     *
     * @return {@link #isAutomaticForward} instance as boolean
     */
    public boolean isAutomaticForward() {
        return isAutomaticForward;
    }

    /**
     * Method to get {@link #replyToMessage} instance <br>
     * No-any params required
     *
     * @return {@link #replyToMessage} instance as {@link Message}
     */
    public Message getReplyToMessage() {
        return replyToMessage;
    }

    /**
     * Method to get {@link #viaBot} instance <br>
     * No-any params required
     *
     * @return {@link #viaBot} instance as {@link User}
     */
    public User getViaBot() {
        return viaBot;
    }

    /**
     * Method to get {@link #editDate} instance <br>
     * No-any params required
     *
     * @return {@link #editDate} instance as long
     */
    public long getEditDateTimestamp() {
        return editDate;
    }

    /**
     * Method to get {@link #editDate} instance <br>
     * No-any params required
     *
     * @return {@link #editDate} instance as {@link Date}
     */
    public Date getEditDate() {
        return getDateValue(editDate);
    }

    /**
     * Method to get {@link #hasProtectedContent} instance <br>
     * No-any params required
     *
     * @return {@link #hasProtectedContent} instance as boolean
     */
    public boolean hasProtectedContent() {
        return hasProtectedContent;
    }

    /**
     * Method to get {@link #mediaGroupId} instance <br>
     * No-any params required
     *
     * @return {@link #mediaGroupId} instance as {@link String}
     */
    public String getMediaGroupId() {
        return mediaGroupId;
    }

    /**
     * Method to get {@link #authorSignature} instance <br>
     * No-any params required
     *
     * @return {@link #authorSignature} instance as {@link String}
     */
    public String getAuthorSignature() {
        return authorSignature;
    }

    /**
     * Method to get {@link #text} instance <br>
     * No-any params required
     *
     * @return {@link #text} instance as {@link String}
     */
    public String getText() {
        return text;
    }

    /**
     * Method to get {@link #entities} instance <br>
     * No-any params required
     *
     * @return {@link #entities} instance as {@link ArrayList} of {@link MessageEntity}
     */
    public ArrayList<MessageEntity> getEntities() {
        return entities;
    }

    /**
     * Method to get {@link #animation} instance <br>
     * No-any params required
     *
     * @return {@link #animation} instance as {@link Video}
     */
    public Video getAnimation() {
        return animation;
    }

    /**
     * Method to get {@link #audio} instance <br>
     * No-any params required
     *
     * @return {@link #audio} instance as {@link Audio}
     */
    public Audio getAudio() {
        return audio;
    }

    /**
     * Method to get {@link #document} instance <br>
     * No-any params required
     *
     * @return {@link #document} instance as {@link TelegramDocument}
     */
    public TelegramDocument getDocument() {
        return document;
    }

    /**
     * Method to get {@link #photo} instance <br>
     * No-any params required
     *
     * @return {@link #photo} instance as {@link ArrayList} of {@link PhotoSize}
     */
    public ArrayList<PhotoSize> getPhoto() {
        return photo;
    }

    /**
     * Method to get {@link #sticker} instance <br>
     * No-any params required
     *
     * @return {@link #sticker} instance as {@link Sticker}
     */
    public Sticker getSticker() {
        return sticker;
    }

    /**
     * Method to get {@link #video} instance <br>
     * No-any params required
     *
     * @return {@link #video} instance as {@link Video}
     */
    public Video getVideo() {
        return video;
    }

    /**
     * Method to get {@link #videoNote} instance <br>
     * No-any params required
     *
     * @return {@link #videoNote} instance as {@link VideoNote}
     */
    public VideoNote getVideoNote() {
        return videoNote;
    }

    /**
     * Method to get {@link #voice} instance <br>
     * No-any params required
     *
     * @return {@link #voice} instance as {@link Voice}
     */
    public Voice getVoice() {
        return voice;
    }

    /**
     * Method to get {@link #caption} instance <br>
     * No-any params required
     *
     * @return {@link #caption} instance as {@link String}
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Method to get {@link #captionEntities} instance <br>
     * No-any params required
     *
     * @return {@link #captionEntities} instance as {@link ArrayList} of {@link MessageEntity}
     */
    public ArrayList<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    /**
     * Method to get {@link #hasMediaSpoiler} instance <br>
     * No-any params required
     *
     * @return {@link #hasMediaSpoiler} instance as boolean
     */
    public boolean hasMediaSpoiler() {
        return hasMediaSpoiler;
    }

    /**
     * Method to get {@link #contact} instance <br>
     * No-any params required
     *
     * @return {@link #contact} instance as {@link Contact}
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Method to get {@link #dice} instance <br>
     * No-any params required
     *
     * @return {@link #dice} instance as {@link Dice}
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * Method to get {@link #game} instance <br>
     * No-any params required
     *
     * @return {@link #game} instance as {@link Game}
     */
    public Game getGame() {
        return game;
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
     * Method to get {@link #venue} instance <br>
     * No-any params required
     *
     * @return {@link #venue} instance as {@link Venue}
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * Method to get {@link #location} instance <br>
     * No-any params required
     *
     * @return {@link #location} instance as {@link Location}
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Method to get {@link #newChatMembers} instance <br>
     * No-any params required
     *
     * @return {@link #newChatMembers} instance as {@link ArrayList} of {@link User}
     */
    public ArrayList<User> getNewChatMembers() {
        return newChatMembers;
    }

    /**
     * Method to get {@link #leftChatMember} instance <br>
     * No-any params required
     *
     * @return {@link #leftChatMember} instance as {@link User}
     */
    public User getLeftChatMember() {
        return leftChatMember;
    }

    /**
     * Method to get {@link #newChatTitle} instance <br>
     * No-any params required
     *
     * @return {@link #newChatTitle} instance as {@link String}
     */
    public String getNewChatTitle() {
        return newChatTitle;
    }

    /**
     * Method to get {@link #newChatPhoto} instance <br>
     * No-any params required
     *
     * @return {@link #newChatPhoto} instance as {@link ArrayList} of {@link PhotoSize}
     */
    public ArrayList<PhotoSize> getNewChatPhoto() {
        return newChatPhoto;
    }

    /**
     * Method to get {@link #deleteChatPhoto} instance <br>
     * No-any params required
     *
     * @return {@link #deleteChatPhoto} instance as boolean
     */
    public boolean isDeletedChatPhoto() {
        return deleteChatPhoto;
    }

    /**
     * Method to get {@link #groupChatCreated} instance <br>
     * No-any params required
     *
     * @return {@link #groupChatCreated} instance as boolean
     */
    public boolean isGroupChatCreated() {
        return groupChatCreated;
    }

    /**
     * Method to get {@link #channelChatCreated} instance <br>
     * No-any params required
     *
     * @return {@link #channelChatCreated} instance as boolean
     */
    public boolean isChannelChatCreated() {
        return channelChatCreated;
    }

    /**
     * Method to get {@link #messageAutoDeleteTimerChanged} instance <br>
     * No-any params required
     *
     * @return {@link #messageAutoDeleteTimerChanged} instance as {@link MessageAutoDeleteTimerChanged}
     */
    public MessageAutoDeleteTimerChanged getMessageAutoDeleteTimerChanged() {
        return messageAutoDeleteTimerChanged;
    }

    /**
     * Method to get {@link #migrateToChatId} instance <br>
     * No-any params required
     *
     * @return {@link #migrateToChatId} instance as long
     */
    public long getMigrateToChatId() {
        return migrateToChatId;
    }

    /**
     * Method to get {@link #migrateFromChatId} instance <br>
     * No-any params required
     *
     * @return {@link #migrateFromChatId} instance as long
     */
    public long getMigrateFromChatId() {
        return migrateFromChatId;
    }

    /**
     * Method to get {@link #pinnedMessage} instance <br>
     * No-any params required
     *
     * @return {@link #pinnedMessage} instance as {@link Message}
     */
    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    /**
     * Method to get {@link #invoice} instance <br>
     * No-any params required
     *
     * @return {@link #invoice} instance as {@link Invoice}
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Method to get {@link #successfulPayment} instance <br>
     * No-any params required
     *
     * @return {@link #successfulPayment} instance as {@link SuccessfulPayment}
     */
    public SuccessfulPayment getSuccessfulPayment() {
        return successfulPayment;
    }

    /**
     * Method to get {@link #userShared} instance <br>
     * No-any params required
     *
     * @return {@link #userShared} instance as {@link ItemShared}
     */
    public ItemShared getUserShared() {
        return userShared;
    }

    /**
     * Method to get {@link #chatShared} instance <br>
     * No-any params required
     *
     * @return {@link #chatShared} instance as {@link ItemShared}
     */
    public ItemShared getChatShared() {
        return chatShared;
    }

    /**
     * Method to get {@link #connectedWebsite} instance <br>
     * No-any params required
     *
     * @return {@link #connectedWebsite} instance as {@link String}
     */
    public String getConnectedWebsite() {
        return connectedWebsite;
    }

    /**
     * Method to get {@link #writeAccessAllowed} instance <br>
     * No-any params required
     *
     * @return {@link #writeAccessAllowed} instance as {@link WriteAccessAllowed}
     */
    public WriteAccessAllowed getWriteAccessAllowed() {
        return writeAccessAllowed;
    }

    /**
     * Method to get {@link #passportData} instance <br>
     * No-any params required
     *
     * @return {@link #passportData} instance as {@link PassportData}
     */
    public PassportData getPassportData() {
        return passportData;
    }

    /**
     * Method to get {@link #proximityAlertTriggered} instance <br>
     * No-any params required
     *
     * @return {@link #proximityAlertTriggered} instance as {@link ProximityAlertTriggered}
     */
    public ProximityAlertTriggered getProximityAlertTriggered() {
        return proximityAlertTriggered;
    }

    /**
     * Method to get {@link #forumTopicCreated} instance <br>
     * No-any params required
     *
     * @return {@link #forumTopicCreated} instance as {@link ForumTopicCreated}
     */
    public ForumTopicCreated getForumTopicCreated() {
        return forumTopicCreated;
    }

    /**
     * Method to get {@link #forumTopicEdited} instance <br>
     * No-any params required
     *
     * @return {@link #forumTopicEdited} instance as {@link ForumTopicEdited}
     */
    public ForumTopicEdited getForumTopicEdited() {
        return forumTopicEdited;
    }

    /**
     * Method to get {@link #forumTopicClosed} instance <br>
     * No-any params required
     *
     * @return {@link #forumTopicClosed} instance as {@link ForumTopicClosed}
     */
    public ForumTopicClosed getForumTopicClosed() {
        return forumTopicClosed;
    }

    /**
     * Method to get {@link #forumTopicReopened} instance <br>
     * No-any params required
     *
     * @return {@link #forumTopicReopened} instance as {@link ForumTopicReopened}
     */
    public ForumTopicReopened getForumTopicReopened() {
        return forumTopicReopened;
    }

    /**
     * Method to get {@link #generalForumTopicHidden} instance <br>
     * No-any params required
     *
     * @return {@link #generalForumTopicHidden} instance as {@link GeneralForumTopicHidden}
     */
    public GeneralForumTopicHidden getGeneralForumTopicHidden() {
        return generalForumTopicHidden;
    }

    /**
     * Method to get {@link #generalForumTopicUnhidden} instance <br>
     * No-any params required
     *
     * @return {@link #generalForumTopicUnhidden} instance as {@link GeneralForumTopicUnhidden}
     */
    public GeneralForumTopicUnhidden getGeneralForumTopicUnhidden() {
        return generalForumTopicUnhidden;
    }

    /**
     * Method to get {@link #videoChatScheduled} instance <br>
     * No-any params required
     *
     * @return {@link #videoChatScheduled} instance as {@link VideoChatScheduled}
     */
    public VideoChatScheduled getVideoChatScheduled() {
        return videoChatScheduled;
    }

    /**
     * Method to get {@link #videoChatStarted} instance <br>
     * No-any params required
     *
     * @return {@link #videoChatStarted} instance as {@link VideoChatStarted}
     */
    public VideoChatStarted getVideoChatStarted() {
        return videoChatStarted;
    }

    /**
     * Method to get {@link #videoChatEnded} instance <br>
     * No-any params required
     *
     * @return {@link #videoChatEnded} instance as {@link VideoChatEnded}
     */
    public VideoChatEnded getVideoChatEnded() {
        return videoChatEnded;
    }

    /**
     * Method to get {@link #videoChatParticipantsInvited} instance <br>
     * No-any params required
     *
     * @return {@link #videoChatParticipantsInvited} instance as {@link VideoChatParticipantsInvited}
     */
    public VideoChatParticipantsInvited getVideoChatParticipantsInvited() {
        return videoChatParticipantsInvited;
    }

    /**
     * Method to get {@link #webAppData} instance <br>
     * No-any params required
     *
     * @return {@link #webAppData} instance as {@link WebAppData}
     */
    public WebAppData getWebAppData() {
        return webAppData;
    }

    /**
     * Method to get {@link #replyMarkup} instance <br>
     * No-any params required
     *
     * @return {@link #replyMarkup} instance as {@link InlineKeyboardMarkup}
     */
    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    /**
     * Method to create a message
     *
     * @param messageResponse : obtained from Telegram's response
     * @param format          :       return type formatter -> {@link ReturnFormat}
     * @return message as {@code "format"} defines
     */
    @Returner
    public static <T> T returnMessage(String messageResponse, ReturnFormat format) {
        return switch (format) {
            case JSON -> (T) new JSONObject(messageResponse);
            case LIBRARY_OBJECT -> (T) new Message(new JSONObject(messageResponse));
            default -> (T) messageResponse;
        };
    }

    /**
     * Method to create a messages list
     *
     * @param messagesResponse : obtained from Telegram's response
     * @param format           :       return type formatter -> {@link ReturnFormat}
     * @return messages list as {@code "format"} defines
     */
    @Returner
    public static <T> T returnMessages(String messagesResponse, ReturnFormat format) {
        JSONArray result = getResultFromList(messagesResponse);
        return switch (format) {
            case JSON -> (T) result;
            case LIBRARY_OBJECT -> {
                ArrayList<Message> messages = new ArrayList<>();
                for (int j = 0; j < result.length(); j++)
                    messages.add(new Message(result.getJSONObject(j)));
                yield (T) messages;
            }
            default -> (T) result.toString();
        };
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Message}
     */
    public static Message getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Message(jItem);
    }

}
