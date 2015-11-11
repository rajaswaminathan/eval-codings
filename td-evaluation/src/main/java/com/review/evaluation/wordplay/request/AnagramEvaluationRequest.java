package com.review.evaluation.wordplay.request;

import com.review.evaluation.wordplay.utils.ValidationUtil;

import java.util.Objects;

/**
 * Created by Raja on 11/10/2015.
 */
public final class AnagramEvaluationRequest {

    private final String firstWord;

    private final String nextWord;

    public AnagramEvaluationRequest(final String firstWord, final String nextWord){

        ValidationUtil.illegalArgumentIfNull("firstWord", firstWord);
        ValidationUtil.illegalArgumentIfNull("nextWord", nextWord);
        this.firstWord = firstWord;
        this.nextWord = nextWord;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public String getNextWord() {
        return nextWord;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null){
            return false;
        }

        if (!(obj instanceof AnagramEvaluationRequest)){
            return false;
        }

        AnagramEvaluationRequest rhs = (AnagramEvaluationRequest) obj;

        return Objects.equals(firstWord, rhs.getFirstWord())
                && Objects.equals(nextWord, rhs.getNextWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstWord, nextWord);
    }
}
