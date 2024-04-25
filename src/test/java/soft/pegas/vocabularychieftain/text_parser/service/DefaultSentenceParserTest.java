package soft.pegas.vocabularychieftain.text_parser.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefaultSentenceParserTest {

    DefaultSentenceParser defaultSentenceParser = new DefaultSentenceParser();

    @Test
    @DisplayName("should extract words from a sentence")
    void testExtractWords() {
        var given = List.of(
                "With (the release) of Spring Boot 2, Actuator \"has been redesigned? and new exciting-endpoints were added.");
        var expected = new HashSet<String>(
                List.of("with", "the", "release", "of", "has", "been", "redesigned", "and", "new",
                        "exciting", "endpoints", "were", "added"));
        Set<String> received = defaultSentenceParser.extractWords(given);
        Assertions.assertEquals(expected, received);
    }
}
