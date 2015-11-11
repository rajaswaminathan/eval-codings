package com.tdsecurities.evaluation.wordplay.evaluator;

import com.tdsecurities.evaluation.wordplay.request.AnagramEvaluationRequest;
import com.tdsecurities.evaluation.wordplay.response.AnagramEvaluationResponse;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Raja on 11/10/2015.
 */
public class AnagramEvaluatorTest {

    private WordPlayEvaluator<AnagramEvaluationRequest, AnagramEvaluationResponse> anagramEvaluator;

    @Before
    public void setUp(){
        anagramEvaluator = new AnagramEvaluator();
    }

    public void testAnagramForMismatchLength(){

        Assert.assertThat("Words must evaluate to false for anagram test",
                anagramEvaluator.evaluate(new AnagramEvaluationRequest("Moon star", "Astronomer")).isAnagram(),
                CoreMatchers.is(false));
    }

    @Test
    public void testAnagramForTrue(){
        Assert.assertThat("Words must evaluate to be an anagram",
                anagramEvaluator.evaluate(new AnagramEvaluationRequest("debitcard", "badcredit")).isAnagram(),
                CoreMatchers.is(true));
        Assert.assertThat("Words must evaluate to be an anagram",
                anagramEvaluator.evaluate(new AnagramEvaluationRequest("Punishment", "Nine Thumps")).isAnagram(),
                CoreMatchers.is(true));

        Assert.assertThat("Words must evaluate to be an anagram",
                anagramEvaluator.evaluate(new AnagramEvaluationRequest("Dormitory", "Dirty room")).isAnagram(),
                CoreMatchers.is(true));

    }

    @Test
    public void testAnagramWhenOneWordHasASpace(){
        Assert.assertThat("Words must evaluate to be an anagram",
                anagramEvaluator.evaluate(new AnagramEvaluationRequest("debitcard", "bad credit")).isAnagram(),
                CoreMatchers.is(true));
    }

    @Test
    public void testAnagramForMixedCases(){
        Assert.assertThat("Words must evaluate to be an anagram",
                anagramEvaluator.evaluate(new AnagramEvaluationRequest("Debit Card", "Bad Credit")).isAnagram(),
                CoreMatchers.is(true));
    }

    @Test
    public void testAnagramForFalse(){

        Assert.assertThat("Words must not evaluate to be an anagram",
                anagramEvaluator.evaluate(new AnagramEvaluationRequest("Punishment", "bunishmend")).isAnagram(),
                CoreMatchers.is(false));

    }
}
