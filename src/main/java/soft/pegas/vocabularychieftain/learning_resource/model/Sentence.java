package soft.pegas.vocabularychieftain.learning_resource.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import soft.pegas.vocabularychieftain.common.model.BaseModel;

@Entity
@Table(name = "sentences")
@Getter
@Setter
public class Sentence extends BaseModel {

    private String content;

    private int order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "learning_resource_id")
    private LearningResource learningResource;
}
