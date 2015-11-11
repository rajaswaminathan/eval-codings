package com.review.evaluation.wordplay;

import com.review.evaluation.wordplay.config.AppContextFactory;

/**
 * Created by Raja on 11/10/2015.
 */
public class WordPlayRunner {

    public static void main(String args[]){
        final WordPlayService wordPlayService = AppContextFactory.getWordPlayService();
        System.out.println("is deleveled a palindrome "+ wordPlayService.isPalindrome("deleveled"));
        System.out.println("Is Debit card and Bad credit anagram "+
                wordPlayService.isAnagram("Bad credit", "Debit card"));
    }
}
