package com.review.evaluation.wordplay.response;

import java.util.Objects;

/**
 * Created by Raja on 11/10/2015.
 */
public class AnagramEvaluationResponse {

    private final boolean isAnagram;

    public AnagramEvaluationResponse(final boolean isAnagram){

        this.isAnagram = isAnagram;
    }

    public boolean isAnagram() {
        return isAnagram;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null){
            return false;
        }

        if (!(obj instanceof AnagramEvaluationResponse)){
            return false;
        }

        AnagramEvaluationResponse rhs = (AnagramEvaluationResponse) obj;

        return Objects.equals(isAnagram, rhs.isAnagram());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAnagram);
    }

}
