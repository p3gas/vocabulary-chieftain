package soft.pegas.vocabularychieftain.learning_resource.service;

import soft.pegas.vocabularychieftain.learning_resource.model.LearningResourceDto;

import java.util.List;

public interface LearningResourcesService {

    List<LearningResourceDto> getAll();
    LearningResourceDto create(byte[] file, String originalFileName, String name, String linkToAudio);
    LearningResourceDto update(LearningResourceDto learningResourceDto);
}
