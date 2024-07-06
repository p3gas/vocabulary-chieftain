package soft.pegas.vocabularychieftain.learning_resource.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import soft.pegas.vocabularychieftain.learning_resource.model.LearningResourceDto;
import soft.pegas.vocabularychieftain.learning_resource.service.LearningResourcesService;
import soft.pegas.vocabularychieftain.common.url.UrlConst;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(UrlConst.LEARNING_RESOURCE)
@RequiredArgsConstructor
public class LearningResourcesController {

    private final LearningResourcesService learningResourcesService;

    @GetMapping("/all")
    public List<LearningResourceDto> getAll() {
        return learningResourcesService.getAll();
    }

    @PostMapping
    public LearningResourceDto create(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
                                      @RequestParam("linkToAudio") String linkToAudio) throws IOException {
        return learningResourcesService.create(file.getBytes(), file.getOriginalFilename(), name, linkToAudio);
    }

    @PutMapping
    public LearningResourceDto update(@RequestBody LearningResourceDto learningResourceDto) {
        return learningResourcesService.update(learningResourceDto);
    }
}
