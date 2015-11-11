package com.review.evaluation.wordplay.config;

import com.review.evaluation.wordplay.WordPlayService;
import com.review.evaluation.wordplay.WordPlayServiceImpl;
import com.review.evaluation.wordplay.evaluator.AnagramEvaluator;
import com.review.evaluation.wordplay.evaluator.PalindromeEvaluator;

/**
 * Created by Raja on 11/10/2015.
 *
 * We dont use spring here. This factory will take care of the dependency injection to adhere to the single responsibility
 * design principles
 */
public final class AppContextFactory {

    public static final WordPlayService getWordPlayService(){

        return new WordPlayServiceImpl(new PalindromeEvaluator(), new AnagramEvaluator());
    }
}
