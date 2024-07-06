package soft.pegas.vocabularychieftain.learning_resource.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.pegas.vocabularychieftain.common.exception.BusinessException;
import soft.pegas.vocabularychieftain.learning_resource.model.LearningResource;
import soft.pegas.vocabularychieftain.learning_resource.model.LearningResourceDto;
import soft.pegas.vocabularychieftain.learning_resource.repository.LearningResourcesRepository;
import soft.pegas.vocabularychieftain.learning_resource.repository.WordRepository;
import soft.pegas.vocabularychieftain.storage.service.StorageService;
import soft.pegas.vocabularychieftain.text_parser.model.FileType;
import soft.pegas.vocabularychieftain.text_parser.service.SentenceParser;
import soft.pegas.vocabularychieftain.text_parser.service.TextParser;
import soft.pegas.vocabularychieftain.user.model.User;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultLearningResourcesService implements LearningResourcesService {

    private final LearningResourcesRepository learningResourcesRepository;
    private final StorageService storageService;
    private final List<TextParser> textParsers;
    private final SentenceService sentenceService;
    private final SentenceParser sentenceParser;
    private final WordService wordService;

    @Override
    public List<LearningResourceDto> getAll() {
        return learningResourcesRepository.findAll().stream().map(LearningResource::toDto).toList();
    }

    @Override
    @Transactional
    public LearningResourceDto create(byte[] file, String originalFileName, String name, String linkToAudio) {
        String filename;
        try {
            filename = storageService.saveFile(file);
        } catch (IOException e) {
            throw new IllegalArgumentException("can't save file");
        }

        var learningResource = new LearningResource();
        learningResource.setName(name);
        learningResource.setLinkToAudio(linkToAudio);
        learningResource.setFileName(filename);
        learningResource.setExtension(extractExtension(originalFileName));
        LearningResource saved = learningResourcesRepository.save(learningResource);

        saveSentences(file, learningResource);

        return saved.toDto();
    }

    private FileType extractExtension(String fileName) {
        String raw = fileName.substring(fileName.lastIndexOf('.') + 1);
        return FileType.ofString(raw);
    }

    private void saveSentences(byte[] file, LearningResource learningResource) {
        TextParser textParser = getTextParser(learningResource.getExtension());
        List<String> extractedSentences = textParser.extractSentences(file);
        sentenceService.saveAll(extractedSentences, learningResource);
        wordService.saveAll(sentenceParser.extractWords(extractedSentences), new User());
    }

    private TextParser getTextParser(FileType extension) {
        TextParser t = null;
        for (var textParser : textParsers) {
            if (textParser.getSupportedFileTypes().contains(extension)) {
                t = textParser;
                break;
            }
        }

        if (t == null) {
            throw new RuntimeException("Unsupported file extension");
        }

        return t;
    }

    @Override
    public LearningResourceDto update(LearningResourceDto learningResourceDto) {
        LearningResource learningResource = learningResourcesRepository.findById(learningResourceDto.id()).orElseThrow(
                () -> new BusinessException("Learning resource does not exist")
        );

        learningResource.setName(learningResourceDto.name());
        learningResource.setAvailableForPublic(learningResourceDto.availableForPublic());
        learningResource.setLinkToAudio(learningResourceDto.linkToAudio());
        var updated = learningResourcesRepository.save(learningResource);

        return updated.toDto();
    }
}
