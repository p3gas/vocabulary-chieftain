package soft.pegas.vocabularychieftain.learning_resource.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import soft.pegas.vocabularychieftain.learning_resource.dto.LearningResourceDTO;
import soft.pegas.vocabularychieftain.common.model.BaseModel;
import soft.pegas.vocabularychieftain.user.model.User;

@Entity
@Table(name = "learning_resources")
@Getter
@Setter
public class LearningResource extends BaseModel {

    private String name;

    private String linkToAudio;

    private String fileName;

    private boolean availableForPublic;

    @ManyToOne()
    @JoinColumn(name = "creator_id")
    private User creator;

    public LearningResourceDTO toDTO() {
        return new LearningResourceDTO(id, name, linkToAudio, fileName);
    }
}
