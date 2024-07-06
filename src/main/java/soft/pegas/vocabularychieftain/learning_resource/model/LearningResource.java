package soft.pegas.vocabularychieftain.learning_resource.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import soft.pegas.vocabularychieftain.common.model.BaseModel;
import soft.pegas.vocabularychieftain.text_parser.model.FileType;
import soft.pegas.vocabularychieftain.user.model.User;

import java.util.List;

@Entity
@Table(name = "learning_resources")
@Getter
@Setter
public class LearningResource extends BaseModel {

    private String name;

    @Enumerated(EnumType.STRING)
    private FileType extension;

    private String linkToAudio;

    private String fileName;

    private boolean availableForPublic;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "creator_id")
    private User creator;

    @OneToMany(mappedBy = "learning_resource_id")
    private List<Sentence> sentences;

    public LearningResourceDto toDto() {
        return new LearningResourceDto(id, name, linkToAudio, fileName, availableForPublic);
    }
}
