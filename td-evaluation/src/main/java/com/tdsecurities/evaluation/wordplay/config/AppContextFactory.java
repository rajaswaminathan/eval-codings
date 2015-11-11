package com.tdsecurities.evaluation.wordplay.config;

import com.tdsecurities.evaluation.wordplay.WordPlayService;
import com.tdsecurities.evaluation.wordplay.WordPlayServiceImpl;
import com.tdsecurities.evaluation.wordplay.evaluator.AnagramEvaluator;
import com.tdsecurities.evaluation.wordplay.evaluator.PalindromeEvaluator;

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
