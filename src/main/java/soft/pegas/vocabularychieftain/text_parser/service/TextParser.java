package soft.pegas.vocabularychieftain.text_parser.service;

import soft.pegas.vocabularychieftain.text_parser.model.FileType;

import java.util.List;

public interface TextParser {

    List<FileType> getSupportedFileTypes();
    List<String> extractSentences(byte[] textFile);
}
