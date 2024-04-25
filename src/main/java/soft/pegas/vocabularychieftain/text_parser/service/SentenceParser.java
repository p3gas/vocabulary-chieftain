package soft.pegas.vocabularychieftain.text_parser.service;

import java.util.List;
import java.util.Set;

public interface SentenceParser {
    Set<String> extractWords(List<String> sentences);
}
