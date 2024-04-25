package soft.pegas.vocabularychieftain.text_parser.service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SrtTextParserTest {

    SrtTextParser srtTextParser = new SrtTextParser();

    @Test
    @DisplayName("should parse sub rip text")
    void testExtractSentences() {
        var given = """
                1
                00:05:00,400 --> 00:05:15,300
                This is an example of
                a subtitle.

                2
                00:05:16,400 --> 00:05:25,300
                This is an example of
                a subtitle - 2nd subtitle.

                3
                00:05:16,400 --> 00:05:25,300
                - Nice one.
                - Thanks.
                    """.getBytes(StandardCharsets.UTF_8);
        var received = srtTextParser.extractSentences(given);
        var expected = List.of(
                "This is an example of a subtitle.",
                "This is an example of a subtitle - 2nd subtitle.",
                "- Nice one.",
                "- Thanks.");
        
        Assertions.assertLinesMatch(expected, received);
    }
}
