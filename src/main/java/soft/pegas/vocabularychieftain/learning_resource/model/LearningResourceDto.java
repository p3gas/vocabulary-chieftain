package soft.pegas.vocabularychieftain.learning_resource.model;

import java.util.UUID;

public record LearningResourceDto(
        UUID id,
        String name,
        String linkToAudio,
        String fileName,
        boolean availableForPublic) {
}
