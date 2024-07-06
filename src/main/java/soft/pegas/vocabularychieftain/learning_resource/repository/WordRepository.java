package soft.pegas.vocabularychieftain.learning_resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.pegas.vocabularychieftain.learning_resource.model.Word;

import java.util.UUID;

public interface WordRepository extends JpaRepository<Word, UUID> {
}
