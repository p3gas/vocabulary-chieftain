package soft.pegas.vocabularychieftain.text_parser.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

class PlainTextParserTest {

    PlainTextParser plainTextParser = new PlainTextParser();

    @Test
    @DisplayName("should parse plain text")
    void testExtractSentences() {
        var given = """
                2.1.1. Meta-Annotations and Composed Annotations
                JUnit Jupiter annotations can be used as meta-annotations. That means that you can define your own composed annotation that will automatically inherit the semantics of its meta-annotations.
                """
                .getBytes(StandardCharsets.UTF_8);
        List<String> received = plainTextParser.extractSentences(given);
        var expected = List.of(
                "2.1.1. Meta-Annotations and Composed Annotations",
                "JUnit Jupiter annotations can be used as meta-annotations.",
                "That means that you can define your own composed annotation that will automatically inherit the semantics of its meta-annotations.");

        Assertions.assertLinesMatch(expected, received);
    }
}