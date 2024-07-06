package soft.pegas.vocabularychieftain.learning_resource.service;

import soft.pegas.vocabularychieftain.learning_resource.model.LearningResource;

import java.util.List;

public interface SentenceService {

    void saveAll(List<String> sentencesStrings, LearningResource learningResource);
}
