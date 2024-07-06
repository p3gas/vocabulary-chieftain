package soft.pegas.vocabularychieftain.learning_resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.pegas.vocabularychieftain.learning_resource.model.Sentence;

import java.util.UUID;

public interface SentenceRepository extends JpaRepository<Sentence, UUID> {
}
