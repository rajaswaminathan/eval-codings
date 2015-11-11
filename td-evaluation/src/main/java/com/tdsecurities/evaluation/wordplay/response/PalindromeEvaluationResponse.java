package com.tdsecurities.evaluation.wordplay.response;

import java.util.Objects;

/**
 * Created by Raja on 11/10/2015.
 */
public final class PalindromeEvaluationResponse {

    private final boolean isPalindrome;

    public PalindromeEvaluationResponse(final boolean isPalindrome){
        this.isPalindrome = isPalindrome;
    }

    public boolean isPalindrome() {
        return isPalindrome;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj == null){
            return false;
        }

        if (!(obj instanceof AnagramEvaluationResponse)){
            return false;
        }

        PalindromeEvaluationResponse rhs = (PalindromeEvaluationResponse) obj;

        return Objects.equals(isPalindrome, rhs.isPalindrome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPalindrome);
    }
}
