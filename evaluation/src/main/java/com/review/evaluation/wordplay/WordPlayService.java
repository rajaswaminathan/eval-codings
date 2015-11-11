package com.review.evaluation.wordplay;

/**
 * Created by Raja on 11/10/2015.
 */
public interface WordPlayService {

    boolean isPalindrome(final String wordToEvaluate);

    boolean isAnagram(final String firstWord, final String nextWord);
}
