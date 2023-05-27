package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.basetypes.userdata.User;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.Poll.PollOption.returnPollOptions;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity.returnMessageEntities;

/**
 * The {@code Poll} class is useful to format a {@code Telegram}'s poll
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#poll">
 * Poll</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 */
public class Poll extends TelegramType {

    /**
     * {@code PollType} list of available poll types
     */
    public enum PollType {

        /**
         * {@code regular} poll type
         */
        regular,

        /**
         * {@code quiz} poll type
         */
        quiz

    }

    /**
     * {@code id} unique poll identifier
     */
    private final String id;

    /**
     * {@code question} poll question, 1-300 characters
     */
    private final String question;

    /**
     * {@code pollOptions} list of poll options
     */
    private final ArrayList<PollOption> pollOptions;

    /**
     * {@code totalVoterCount} total number of users that voted in the poll
     */
    private final int totalVoterCount;

    /**
     * {@code isClosed} if the poll is closed
     */
    private final boolean isClosed;

    /**
     * {@code isAnonymous} if the poll is anonymous
     */
    private final boolean isAnonymous;

    /**
     * {@code type} of the poll
     */
    private final PollType type;

    /**
     * {@code allowsMultipleAnswers} if the poll allows multiple answers
     */
    private final boolean allowsMultipleAnswers;

    /**
     * {@code correctOptionId} 0-based identifier of the correct answer option. Available only for polls in the quiz
     * mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot
     */
    private final long correctOptionId;

    /**
     * {@code explanation} text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a
     * quiz-style poll, 0-200 characters
     */
    private final String explanation;

    /**
     * {@code explanationEntities} special entities like usernames, URLs, bot commands, etc. that appear in the explanation
     */
    private final ArrayList<MessageEntity> explanationEntities;

    /**
     * {@code openPeriod} amount of time in seconds the poll will be active after creation
     */
    private final long openPeriod;

    /**
     * {@code closeDate} point in time (Unix timestamp) when the poll will be automatically closed
     */
    private final long closeDate;

    /**
     * Constructor to init a {@link Poll} object
     *
     * @param id:                    unique poll identifier
     * @param question:              poll question, 1-300 characters
     * @param pollOptions:           list of poll options
     * @param totalVoterCount:       total number of users that voted in the poll
     * @param isClosed:              if the poll is closed
     * @param isAnonymous:           if the poll is anonymous
     * @param type:                  poll type
     * @param allowsMultipleAnswers: if the poll allows multiple answers
     * @param correctOptionId:       0-based identifier of the correct answer option. Available only for polls in the quiz mode,
     *                               which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot
     * @param explanation:           text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a
     *                               quiz-style poll, 0-200 characters
     * @param explanationEntities:   special entities like usernames, URLs, bot commands, etc. that appear in the explanation
     * @param openPeriod:            amount of time in seconds the poll will be active after creation
     * @param closeDate:             point in time (Unix timestamp) when the poll will be automatically closed
     */
    public Poll(String id, String question, ArrayList<PollOption> pollOptions, int totalVoterCount, boolean isClosed,
                boolean isAnonymous, PollType type, boolean allowsMultipleAnswers, long correctOptionId,
                String explanation, ArrayList<MessageEntity> explanationEntities, long openPeriod, long closeDate) {
        super(null);
        this.id = id;
        this.question = question;
        this.pollOptions = pollOptions;
        this.totalVoterCount = totalVoterCount;
        this.isClosed = isClosed;
        this.isAnonymous = isAnonymous;
        this.type = type;
        this.allowsMultipleAnswers = allowsMultipleAnswers;
        this.correctOptionId = correctOptionId;
        this.explanation = explanation;
        this.explanationEntities = explanationEntities;
        this.openPeriod = openPeriod;
        this.closeDate = closeDate;
    }

    /**
     * Constructor to init a {@link Poll} object
     *
     * @param jPoll: poll details as {@link JSONObject}
     */
    public Poll(JSONObject jPoll) {
        super(jPoll);
        id = hTelegram.getString("id");
        question = hTelegram.getString("question");
        pollOptions = returnPollOptions(hTelegram.getJSONArray("options"));
        totalVoterCount = hTelegram.getInt("total_voter_count");
        isClosed = hTelegram.getBoolean("is_closed");
        isAnonymous = hTelegram.getBoolean("is_anonymous");
        type = PollType.valueOf(hTelegram.getString("type"));
        allowsMultipleAnswers = hTelegram.getBoolean("allows_multiple_answers");
        correctOptionId = hTelegram.getLong("correct_option_id");
        explanation = hTelegram.getString("explanation");
        explanationEntities = returnMessageEntities(hTelegram.getJSONArray("explanation_entities"));
        openPeriod = hTelegram.getLong("open_period");
        closeDate = hTelegram.getLong("close_date");
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     */
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #question} instance <br>
     * No-any params required
     *
     * @return {@link #question} instance as {@link String}
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Method to get {@link #pollOptions} instance <br>
     * No-any params required
     *
     * @return {@link #pollOptions} instance as {@link ArrayList} of {@link PollOption}
     */
    public ArrayList<PollOption> getPollOptions() {
        return pollOptions;
    }

    /**
     * Method to get {@link #totalVoterCount} instance <br>
     * No-any params required
     *
     * @return {@link #totalVoterCount} instance as int
     */
    public int getTotalVoterCount() {
        return totalVoterCount;
    }

    /**
     * Method to get {@link #isClosed} instance <br>
     * No-any params required
     *
     * @return {@link #isClosed} instance as boolean
     */
    public boolean isClosed() {
        return isClosed;
    }

    /**
     * Method to get {@link #isAnonymous} instance <br>
     * No-any params required
     *
     * @return {@link #isAnonymous} instance as boolean
     */
    public boolean isAnonymous() {
        return isAnonymous;
    }

    /**
     * Method to get {@link #type} instance <br>
     * No-any params required
     *
     * @return {@link #type} instance as {@link PollType}
     */
    public PollType getType() {
        return type;
    }

    public boolean allowsMultipleAnswers() {
        return allowsMultipleAnswers;
    }

    /**
     * Method to get {@link #correctOptionId} instance <br>
     * No-any params required
     *
     * @return {@link #correctOptionId} instance as long
     */
    public long getCorrectOptionId() {
        return correctOptionId;
    }

    /**
     * Method to get {@link #explanation} instance <br>
     * No-any params required
     *
     * @return {@link #explanation} instance as {@link String}
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * Method to get {@link #explanationEntities} instance <br>
     * No-any params required
     *
     * @return {@link #explanationEntities} instance as {@link ArrayList} of {@link MessageEntity}
     */
    public ArrayList<MessageEntity> getExplanationEntities() {
        return explanationEntities;
    }

    /**
     * Method to get {@link #openPeriod} instance <br>
     * No-any params required
     *
     * @return {@link #openPeriod} instance as long
     */
    public long getOpenPeriod() {
        return openPeriod;
    }

    /**
     * Method to get {@link #closeDate} instance <br>
     * No-any params required
     *
     * @return {@link #closeDate} instance as long
     */
    public long getCloseDateTimestamp() {
        return closeDate;
    }

    /**
     * Method to get {@link #closeDate} instance <br>
     * No-any params required
     *
     * @return {@link #closeDate} instance as {@link Date}
     */
    public Date getCloseDate() {
        return new Date(closeDate);
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link Poll}
     */
    public static Poll getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Poll(jItem);
    }

    /**
     * The {@code PollOption} class is useful to format a {@code Telegram}'s poll option
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#polloption">
     * PollOption</a>
     * @see TelegramTypeStructure
     * @see TelegramType
     */
    public static class PollOption extends TelegramType {

        /**
         * {@code text} option text, 1-100 characters
         */
        private final String text;

        /**
         * {@code voterCount} number of users that voted for this option
         */
        private final int voterCount;

        /**
         * Constructor to init a {@link PollOption} object
         *
         * @param text:       option text, 1-100 characters
         * @param voterCount: number of users that voted for this option
         */
        public PollOption(String text, int voterCount) {
            super(null);
            this.text = text;
            this.voterCount = voterCount;
        }

        /**
         * Constructor to init a {@link PollOption} object
         *
         * @param jPollOption: poll option details as {@link JSONObject}
         */
        public PollOption(JSONObject jPollOption) {
            super(jPollOption);
            text = hTelegram.getString("text");
            voterCount = hTelegram.getInt("voter_count");
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
         * Method to get {@link #voterCount} instance <br>
         * No-any params required
         *
         * @return {@link #voterCount} instance as int
         */
        public int getVoterCount() {
            return voterCount;
        }

        /**
         * Method to return a {@link PollOption} list
         *
         * @param jPollOptions: JSON source from fetch the list
         * @return poll options list as {@link ArrayList} of {@link PollOption}
         */
        @Returner
        public static ArrayList<PollOption> returnPollOptions(JSONArray jPollOptions) {
            ArrayList<PollOption> pollOptions = new ArrayList<>();
            if (jPollOptions != null)
                for (int j = 0; j < jPollOptions.length(); j++)
                    pollOptions.add(new PollOption(jPollOptions.getJSONObject(j)));
            return pollOptions;
        }

        /**
         * Method to get an instance of this Telegram's type
         *
         * @param jItem: item details as {@link JSONObject}
         * @return instance as {@link PollOption}
         */
        public static PollOption getInstance(JSONObject jItem) {
            if (jItem == null)
                return null;
            else
                return new PollOption(jItem);
        }

    }

    /**
     * The {@code PollAnswer} class is useful to format a {@code Telegram}'s poll answer
     *
     * @author N7ghtm4r3 - Tecknobit
     * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#pollanswer">
     * PollAnswer</a>
     * @see TelegramTypeStructure
     * @see TelegramType
     */
    public static class PollAnswer extends TelegramType {

        /**
         * {@code pollId} unique poll identifier
         */
        private final long pollId;

        /**
         * {@code user} the user, who changed the answer to the poll
         */
        private final User user;

        /**
         * {@code optionIds} 0-based identifiers of answer options, chosen by the user. May be empty if the user
         * retracted their vote
         */
        private final ArrayList<Integer> optionIds;

        /**
         * Constructor to init a {@link PollAnswer} object
         *
         * @param pollId:    unique poll identifier
         * @param user:      the user, who changed the answer to the poll
         * @param optionIds: 0-based identifiers of answer options, chosen by the user. May be empty if the user retracted
         *                   their vote
         */
        public PollAnswer(long pollId, User user, ArrayList<Integer> optionIds) {
            super(null);
            this.pollId = pollId;
            this.user = user;
            this.optionIds = optionIds;
        }

        /**
         * Constructor to init a {@link PollAnswer} object
         *
         * @param jPollAnswer: poll answer details as {@link JSONObject}
         */
        public PollAnswer(JSONObject jPollAnswer) {
            super(jPollAnswer);
            pollId = hTelegram.getLong("poll_id");
            user = User.getInstance(hTelegram.getJSONObject("user"));
            optionIds = hTelegram.fetchVList("option_ids");
        }

        /**
         * Method to get {@link #pollId} instance <br>
         * No-any params required
         *
         * @return {@link #pollId} instance as long
         */
        public long getPollId() {
            return pollId;
        }

        /**
         * Method to get {@link #user} instance <br>
         * No-any params required
         *
         * @return {@link #user} instance as {@link User}
         */
        public User getUser() {
            return user;
        }

        /**
         * Method to get {@link #optionIds} instance <br>
         * No-any params required
         *
         * @return {@link #optionIds} instance as {@link ArrayList} of {@link Integer}
         */
        public ArrayList<Integer> getOptionIds() {
            return optionIds;
        }

        /**
         * Method to get an instance of this Telegram's type
         *
         * @param jItem: item details as {@link JSONObject}
         * @return instance as {@link PollAnswer}
         */
        public static PollAnswer getInstance(JSONObject jItem) {
            if (jItem == null)
                return null;
            else
                return new PollAnswer(jItem);
        }

    }

}
