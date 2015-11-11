package com.tdsecurities.evaluation.wordplay.evaluator;

import com.tdsecurities.evaluation.wordplay.request.PalindromeEvaluationRequest;
import com.tdsecurities.evaluation.wordplay.response.PalindromeEvaluationResponse;

/**
 * Created by Raja on 11/10/2015.
 */
public class PalindromeEvaluator implements WordPlayEvaluator<PalindromeEvaluationRequest, PalindromeEvaluationResponse>{

    public PalindromeEvaluationResponse evaluate(final PalindromeEvaluationRequest palindromeEvaluationRequest) {

        final char[] charactersInEvaluationWord =
                palindromeEvaluationRequest
                .getWordToEvaluate()
                .toLowerCase()
                .toCharArray();
        final int numberOfChars  = charactersInEvaluationWord.length;
        final int halfTheNumberOfChars = charactersInEvaluationWord.length/2;
        for(int i =0; i < halfTheNumberOfChars ;i++){
            if(charactersInEvaluationWord[i] != charactersInEvaluationWord[numberOfChars - i -1]){

                return new PalindromeEvaluationResponse(false);
            }
        }

        return new PalindromeEvaluationResponse(true);
    }
}
