package soft.pegas.vocabularychieftain.text_parser.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;
import soft.pegas.vocabularychieftain.common.utils.StringUtils;

@Component
public class DefaultSentenceParser implements SentenceParser {

    private final static String STOP_CHARACTERS = "[ ,.;\\?!\\$%\\*\\(\\)\\-\"]";
    private final Set<String> stopWords;

    public DefaultSentenceParser() {
        stopWords = new HashSet<>();

        try {
            Scanner scanner = new Scanner(new File("/stop_words/en_stop_words.txt")); // TODO: this should be configured
            while (scanner.hasNext()) {
                stopWords.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("[WARNING] Could not read file with stop words"); // TODO: replace with logger
        }
    }

    @Override
    public Set<String> extractWords(List<String> sentences) {
        var wordsWithOccurrences = new HashMap<String, AtomicInteger>();
        for (var sentence : sentences) {
            Set<String> extractedWords = extractWords(sentence);
            for (var word : extractedWords) {
                wordsWithOccurrences.putIfAbsent(word, new AtomicInteger(0));
                wordsWithOccurrences.get(word).incrementAndGet();
            }
        }

        return wordsWithOccurrences.keySet();
    }

    private Set<String> extractWords(String sentence) {
        Set<String> words = new HashSet<>();
        String[] sentenceSplit = sentence.split(STOP_CHARACTERS);
        sentenceSplit[0] = sentenceSplit[0].toLowerCase();

        for (var sentenceElement : sentenceSplit) {
            if (sentenceElement.isEmpty()) {
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
