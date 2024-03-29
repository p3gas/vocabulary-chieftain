package soft.pegas.vocabularychieftain.text_parser.model;

import soft.pegas.vocabularychieftain.text_parser.service.TextParser;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class PlainTextParser implements TextParser {

    @Override
    public List<FileType> getSupportedFileTypes() {
        return List.of(FileType.TEXT);
    }

    @Override
    public List<String> extractSentences(byte[] textFile) {
        var originalText = new String(textFile, StandardCharsets.UTF_8);

        return Arrays.stream(originalText.split("(?<=((?<![0-9])\\.(?![0-9])))|\\n")).map(String::trim)
                .filter(x -> !x.isEmpty()).toList();
    }
}
