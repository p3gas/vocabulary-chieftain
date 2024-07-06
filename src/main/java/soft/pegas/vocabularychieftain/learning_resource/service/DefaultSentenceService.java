package soft.pegas.vocabularychieftain.learning_resource.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.pegas.vocabularychieftain.learning_resource.model.LearningResource;
import soft.pegas.vocabularychieftain.learning_resource.model.Sentence;
import soft.pegas.vocabularychieftain.learning_resource.repository.SentenceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultSentenceService implements SentenceService {

    private final SentenceRepository sentenceRepository;

    @Override
    public void saveAll(List<String> sentencesStrings, LearningResource learningResource) {
        List<Sentence> sentences = new ArrayList<>();
        int order = 0;
        for (var sentenceString : sentencesStrings) {
            var sentence = new Sentence();
            sentence.setContent(sentenceString);
            sentence.setOrder(order++);
            sentence.setLearningResource(learningResource);

            sentences.add(sentence);
        }
        sentenceRepository.saveAll(sentences);
    }
}
