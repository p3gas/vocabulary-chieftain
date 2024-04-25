package soft.pegas.vocabularychieftain.text_parser.service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import soft.pegas.vocabularychieftain.text_parser.model.FileType;

public class SrtTextParser implements TextParser {

    @Override
    public List<FileType> getSupportedFileTypes() {
        return List.of(FileType.SRT);
    }

    @Override
    public List<String> extractSentences(byte[] textFile) {
        var originalCharacters = new String(textFile, StandardCharsets.UTF_8);
        String[] originalLines = originalCharacters.split("\n");
        var originalText = new StringBuilder();
        var currentTextIndex = 1;
        for (int i = 0; i < originalLines.length; i++) {
            if (originalLines[i].equals(Integer.toString(currentTextIndex))) {
                i++;
                currentTextIndex++;
                
                continue;
            }

            if (!originalLines[i].equals("")) {
                originalText.append(" " + originalLines[i]);
            }
        }

        return Arrays.stream(originalText.toString().split("(?<=((?<![0-9])\\.(?![0-9])))|\\n")).map(String::trim)
                .filter(x -> !x.isEmpty()).toList();
    }
}
