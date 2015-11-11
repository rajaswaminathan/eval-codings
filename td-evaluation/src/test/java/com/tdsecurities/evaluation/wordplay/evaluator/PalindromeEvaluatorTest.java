package com.tdsecurities.evaluation.wordplay.evaluator;

import com.tdsecurities.evaluation.wordplay.request.PalindromeEvaluationRequest;
import com.tdsecurities.evaluation.wordplay.response.PalindromeEvaluationResponse;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Raja on 11/10/2015.
 */
public class PalindromeEvaluatorTest {

    WordPlayEvaluator<PalindromeEvaluationRequest, PalindromeEvaluationResponse> palindromeEvaluator;

    @Before
    public void setUp(){
        palindromeEvaluator = new PalindromeEvaluator();
    }

    @Test
    public void testPalindromeForEvenLength(){

        Assert.assertThat(
                "Palindrome evaluation must return true",
                palindromeEvaluator.evaluate(new PalindromeEvaluationRequest("abccba")).isPalindrome(),
                CoreMatchers.is(true));
    }

    @Test
    public void testPalindromeForOddLength(){
        Assert.assertThat(
                "Palindrome evaluation must return true",
                palindromeEvaluator.evaluate(new PalindromeEvaluationRequest("abcba")).isPalindrome(),
                CoreMatchers.is(true));
    }

    @Test
    public void testInvalidPalindrome(){
        Assert.assertThat(
                "Palindrome evaluation must return false",
                palindromeEvaluator.evaluate(new PalindromeEvaluationRequest("abbbccd")).isPalindrome(),
                CoreMatchers.is(false));
    }

    @Test
    public void testPalindromeWithMixedCases(){
        Assert.assertThat(
                "Palindrome evaluation must return true",
                palindromeEvaluator.evaluate(new PalindromeEvaluationRequest("abcBA")).isPalindrome(),
                CoreMatchers.is(true));

    }
}
