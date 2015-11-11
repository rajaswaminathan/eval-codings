package com.tdsecurities.evaluation.wordplay.request;

import com.tdsecurities.evaluation.wordplay.utils.ValidationUtil;

import java.util.Objects;

/**
 * Created by Raja on 11/10/2015.
 */
public final class PalindromeEvaluationRequest {

    private final String wordToEvaluate;

    public PalindromeEvaluationRequest(final String wordToEvaluate){
        ValidationUtil.illegalArgumentIfNull("wordToEvaluate", wordToEvaluate);
        this.wordToEvaluate = wordToEvaluate;
    }

    public String getWordToEvaluate() {
        return wordToEvaluate;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null){
            return false;
        }

        if (!(obj instanceof PalindromeEvaluationRequest)){
            return false;
        }

        PalindromeEvaluationRequest rhs = (PalindromeEvaluationRequest) obj;

        return Objects.equals(wordToEvaluate, rhs.getWordToEvaluate());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(wordToEvaluate);
    }
}
