package soft.pegas.vocabularychieftain.learning_resource.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "learning_resources")
@Getter
@Setter
public class LearningResource {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String linkToAudio;

    private String fileName;
}
