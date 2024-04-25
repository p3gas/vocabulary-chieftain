package soft.pegas.vocabularychieftain.text_parser.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import soft.pegas.vocabularychieftain.common.utils.StringUtils;

public class DefaultSentenceParser implements SentenceParser {

    private final static String STOP_CHARACTERS = "[ ,.;\\?!\\$%\\*\\(\\)\\-\"]";

    @Override
    public Set<String> extractWords(List<String> sentences) {
        var wordsWithOccurences = new HashMap<String, AtomicInteger>();
        for (var sentence : sentences) {
            Set<String> extractedWords = extractWords(sentence);
            for (var word : extractedWords) {
                wordsWithOccurences.putIfAbsent(word, new AtomicInteger(0));
                wordsWithOccurences.get(word).incrementAndGet();
            }
        }

        return wordsWithOccurences.keySet();
    }

    private Set<String> extractWords(String sentence) {
        Set<String> words = new HashSet<String>();
        String[] sentenceSplit = sentence.split(STOP_CHARACTERS);
        sentenceSplit[0] = sentenceSplit[0].toLowerCase();

        for (var sentenceElement : sentenceSplit) {
            if (sentenceElement.length() == 0) {
                continue;
            }
            if (Character.isUpperCase(sentenceElement.charAt(0))) {
                continue;
            }
            if (StringUtils.isNumeric(sentenceElement)) {
                continue;
            }            

            words.add(sentenceElement);
        }
        
        return words;
    }
}
