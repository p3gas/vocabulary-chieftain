package soft.pegas.vocabularychieftain.learning_resource.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.pegas.vocabularychieftain.learning_resource.dto.LearningResourceDTO;
import soft.pegas.vocabularychieftain.learning_resource.model.LearningResource;
import soft.pegas.vocabularychieftain.learning_resource.repository.LearningResourcesRepository;
import soft.pegas.vocabularychieftain.storage.service.StorageService;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultLearningResourcesService implements LearningResourcesService {

    private final LearningResourcesRepository learningResourcesRepository;
    private final StorageService storageService;

    @Override
    public List<LearningResourceDTO> getAll() {
        return learningResourcesRepository.findAll().stream().map(LearningResource::toDTO).toList();
    }

    @Override
    public LearningResourceDTO create(byte[] file, String name, String linkToAudio) {
        String filename;
        try{
            filename = storageService.saveFile(file);
        } catch (IOException e) {
            throw new IllegalArgumentException("can't save file");
        }
        
        var learningResource = new LearningResource();
        learningResource.setName(name);
        learningResource.setLinkToAudio(linkToAudio);
        learningResource.setFileName(filename);

        LearningResource saved = learningResourcesRepository.save(learningResource);

        return saved.toDTO();
    }
}
