package com.review.evaluation.wordplay.evaluator

import com.review.evaluation.wordplay.WordPlayService
import com.review.evaluation.wordplay.WordPlayServiceImpl
import com.review.evaluation.wordplay.request.PalindromeEvaluationRequest
import com.review.evaluation.wordplay.response.PalindromeEvaluationResponse
import org.easymock.Mock
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test
import spock.lang.Specification
import spock.lang.Unroll

import static org.easymock.EasyMock.createMock
import static org.easymock.EasyMock.createMock
import static org.easymock.EasyMock.expect

/**
 * Created by kumara on 11/22/2015.
 */
@Unroll
class WordPlayServiceSpockTest extends Specification {

    private WordPlayService wordPlayService;

    private PalindromeEvaluator mockPalindromeEvaluator;

    private AnagramEvaluator mockAnagramEvaluator;

    def setup(){

        mockPalindromeEvaluator = Mock();
        mockAnagramEvaluator = Mock();
        wordPlayService = new WordPlayServiceImpl(mockPalindromeEvaluator, mockAnagramEvaluator);
    }

    def "deleveled must be a palindrome"(){

        given:" the word to validate for palindrome is 'deleveled'"
        final String  wordToEvaluate = "deleveled";
        when: " you invoke isPalindrome() method it must return false"
        boolean isPalindrome = wordPlayService.isPalindrome(wordToEvaluate);
        then:
        1*mockPalindromeEvaluator.evaluate(
                new PalindromeEvaluationRequest(wordToEvaluate)) >> new PalindromeEvaluationResponse(true);
        expect: "The word must be a palindrome"
        isPalindrome CoreMatchers.is(true);
    }
}
