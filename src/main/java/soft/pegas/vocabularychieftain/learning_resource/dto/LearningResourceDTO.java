package soft.pegas.vocabularychieftain.learning_resource.dto;

import java.util.UUID;

public record LearningResourceDTO(
        UUID id,
        String name,
        String linkToAudio,
        String fileName) {
}
