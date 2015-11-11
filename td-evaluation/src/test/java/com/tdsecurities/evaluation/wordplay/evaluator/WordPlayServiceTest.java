package com.tdsecurities.evaluation.wordplay.evaluator;

import com.tdsecurities.evaluation.wordplay.WordPlayService;
import static org.easymock.EasyMock.*;

import com.tdsecurities.evaluation.wordplay.WordPlayServiceImpl;
import com.tdsecurities.evaluation.wordplay.request.AnagramEvaluationRequest;
import com.tdsecurities.evaluation.wordplay.request.PalindromeEvaluationRequest;
import com.tdsecurities.evaluation.wordplay.response.AnagramEvaluationResponse;
import com.tdsecurities.evaluation.wordplay.response.PalindromeEvaluationResponse;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Raja on 11/10/2015.
 */
public class WordPlayServiceTest {

    private WordPlayService wordPlayService;

    private PalindromeEvaluator mockPalindromeEvaluator;

    private AnagramEvaluator mockAnagramEvaluator;

    private Object[] mocks;

    @Before
    public void setUp(){

        mockPalindromeEvaluator = createMock(PalindromeEvaluator.class);
        mockAnagramEvaluator = createMock(AnagramEvaluator.class);
        wordPlayService = new WordPlayServiceImpl(mockPalindromeEvaluator, mockAnagramEvaluator);
        mocks = new Object[]{mockPalindromeEvaluator, mockAnagramEvaluator};
    }

    @Test
    public void testIsPalindrome(){

        final String wordToEvaluate = "deleveled";
        expect(mockPalindromeEvaluator.evaluate(new PalindromeEvaluationRequest(wordToEvaluate)))
                .andReturn(new PalindromeEvaluationResponse(true));
        replay(mocks);
        Assert.assertThat("Word must be a palindrome",
                wordPlayService.isPalindrome(wordToEvaluate), CoreMatchers.is(true));
    }

    @Test
    public void testIsAnagram(){

        final String firstWord = "debitcard";
        final String nextWord = "badcredit";

        expect(mockAnagramEvaluator.evaluate(new AnagramEvaluationRequest(firstWord, nextWord)))
                .andReturn(new AnagramEvaluationResponse(true));
        replay(mocks);

        Assert.assertThat("Words must be anagram",
                wordPlayService.isAnagram(firstWord, nextWord),
                CoreMatchers.is(true));
    }
}
