package soft.pegas.vocabularychieftain.learning_resource.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.pegas.vocabularychieftain.learning_resource.model.Word;
import soft.pegas.vocabularychieftain.learning_resource.repository.WordRepository;
import soft.pegas.vocabularychieftain.user.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DefaultWordService implements WordService {

    private final WordRepository wordRepository;

    @Override
    public List<Word> saveAll(Set<String> wordsStrings, User user) {
        List<Word> words = new ArrayList<>();
        List<String> userWords = user.getWords().stream().map(Word::getContent).toList();
        for (var wordString : wordsStrings) {
            if (userWords.contains(wordString)) {
                continue;
            }

            var word = new Word();
            word.setContent(wordString);
            Word saved = wordRepository.save(word);
            user.addWord(saved);
            words.add(saved);
        }

        return words;
    }
}
