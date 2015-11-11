package com.tdsecurities.evaluation.wordplay.evaluator;

import com.tdsecurities.evaluation.wordplay.request.AnagramEvaluationRequest;
import com.tdsecurities.evaluation.wordplay.response.AnagramEvaluationResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Raja on 11/10/2015.
 */
public class AnagramEvaluator implements WordPlayEvaluator<AnagramEvaluationRequest, AnagramEvaluationResponse> {

    public AnagramEvaluationResponse evaluate(AnagramEvaluationRequest anagramEvaluationRequest) {

        final String preProcessedFirstWord = anagramEvaluationRequest.getFirstWord().toLowerCase().replaceAll(" ", "");
        final String preProcessedSecondWord =
                anagramEvaluationRequest.getNextWord().toLowerCase().replaceAll(" ", "");
        if (preProcessedFirstWord.length() != preProcessedSecondWord.length()){

            return new AnagramEvaluationResponse(false);
        }
        return new AnagramEvaluationResponse(
                getCharactersCountMap(preProcessedFirstWord)
                        .equals(getCharactersCountMap(preProcessedSecondWord)));
    }

    private Map<Character, Integer> getCharactersCountMap(final String wordToCount){

        final char[] charactersInWord = wordToCount.toCharArray();
        Map<Character, Integer> charsToCountMap = new HashMap<Character, Integer>();
        for(final char characterInWord : charactersInWord){
            final Character convertedValue = Character.valueOf(characterInWord);

            if(charsToCountMap.containsKey(convertedValue)){
                int currentCount = charsToCountMap.get(convertedValue);
                charsToCountMap.put(convertedValue, currentCount++);
            } else {
                charsToCountMap.put(Character.valueOf(characterInWord), Integer.valueOf(1));
            }
        }

        return charsToCountMap;
    }
}
