package com.tdsecurities.evaluation.wordplay;

import com.tdsecurities.evaluation.wordplay.evaluator.AnagramEvaluator;
import com.tdsecurities.evaluation.wordplay.evaluator.PalindromeEvaluator;
import com.tdsecurities.evaluation.wordplay.evaluator.WordPlayEvaluator;
import com.tdsecurities.evaluation.wordplay.request.AnagramEvaluationRequest;
import com.tdsecurities.evaluation.wordplay.request.PalindromeEvaluationRequest;
import com.tdsecurities.evaluation.wordplay.response.AnagramEvaluationResponse;
import com.tdsecurities.evaluation.wordplay.response.PalindromeEvaluationResponse;

/**
 * Created by Raja on 11/10/2015.
 */
public class WordPlayServiceImpl implements WordPlayService {

    private final WordPlayEvaluator<PalindromeEvaluationRequest, PalindromeEvaluationResponse> palindromwEvaluator;

    private final WordPlayEvaluator<AnagramEvaluationRequest, AnagramEvaluationResponse> anagramEvaluator;

    public WordPlayServiceImpl(final PalindromeEvaluator palindromeEvaluator, final AnagramEvaluator anagramEvaluator){
        this.palindromwEvaluator = palindromeEvaluator;
        this.anagramEvaluator = anagramEvaluator;
    }

    public boolean isPalindrome(final String wordToEvaluate){

        return palindromwEvaluator.evaluate(new PalindromeEvaluationRequest(wordToEvaluate)).isPalindrome();
    }

    public boolean isAnagram(final String firstWord, final String nextWord){

        return anagramEvaluator.evaluate(new AnagramEvaluationRequest(firstWord, nextWord)).isAnagram();
    }
}
