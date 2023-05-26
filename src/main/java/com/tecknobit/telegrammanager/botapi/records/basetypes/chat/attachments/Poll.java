package com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments;

import com.tecknobit.apimanager.annotations.Returner;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.chat.attachments.Poll.PollOption.returnPollOptions;
import static com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity.returnMessageEntities;

public class Poll extends TelegramType {

    public enum PollType {

        regular,

        quiz

    }

    private final String id;
    private final String question;
    private final ArrayList<PollOption> pollOptions;
    private final int totalVoterCount;
    private final boolean isClosed;
    private final boolean isAnonymous;
    private final PollType type;
    private final boolean allowsMultipleAnswers;
    private final long correctOptionId;
    private final String explanation;
    private final ArrayList<MessageEntity> explanationEntities;
    private final long openPeriod;
    private final long closeDate;

    public Poll(String id, String question, ArrayList<PollOption> pollOptions, int totalVoterCount, boolean isClosed, boolean isAnonymous, PollType type, boolean allowsMultipleAnswers, long correctOptionId, String explanation, ArrayList<MessageEntity> explanationEntities, long openPeriod, long closeDate) {
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

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<PollOption> getPollOptions() {
        return pollOptions;
    }

    public int getTotalVoterCount() {
        return totalVoterCount;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public PollType getType() {
        return type;
    }

    public boolean allowsMultipleAnswers() {
        return allowsMultipleAnswers;
    }

    public long getCorrectOptionId() {
        return correctOptionId;
    }

    public String getExplanation() {
        return explanation;
    }

    public ArrayList<MessageEntity> getExplanationEntities() {
        return explanationEntities;
    }

    public long getOpenPeriod() {
        return openPeriod;
    }

    public long getCloseDate() {
        return closeDate;
    }

    public static Poll getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new Poll(jItem);
    }

    public static class PollOption extends TelegramType {

        private final String text;

        private final int voterCount;

        public PollOption(String text, int voterCount) {
            super(null);
            this.text = text;
            this.voterCount = voterCount;
        }

        public PollOption(JSONObject jPollOption) {
            super(jPollOption);
            text = hTelegram.getString("text");
            voterCount = hTelegram.getInt("voter_count");
        }

        public String getText() {
            return text;
        }

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

    }

}
