package soft.pegas.vocabularychieftain.learning_resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.pegas.vocabularychieftain.learning_resource.model.LearningResource;

import java.util.UUID;

public interface LearningResourcesRepository extends JpaRepository<LearningResource, UUID> {
}
