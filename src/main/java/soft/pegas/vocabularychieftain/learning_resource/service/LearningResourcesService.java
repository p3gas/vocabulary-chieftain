package soft.pegas.vocabularychieftain.learning_resource.service;

import soft.pegas.vocabularychieftain.learning_resource.dto.LearningResourceDTO;

import java.util.List;

public interface LearningResourcesService {

    List<LearningResourceDTO> getAll();

    LearningResourceDTO create(byte[] file, String name, String linkToAudio);
}
