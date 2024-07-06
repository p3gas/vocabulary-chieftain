package soft.pegas.vocabularychieftain.learning_resource.service;

import soft.pegas.vocabularychieftain.learning_resource.model.Word;
import soft.pegas.vocabularychieftain.user.model.User;

import java.util.List;
import java.util.Set;

public interface WordService {
    List<Word> saveAll(Set<String> wordsStrings, User user);
}
