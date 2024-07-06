package soft.pegas.vocabularychieftain.learning_resource.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import soft.pegas.vocabularychieftain.common.model.BaseModel;
import soft.pegas.vocabularychieftain.user.model.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "words")
@Getter
@Setter
public class Word extends BaseModel {

    private String content;

    @ManyToMany(mappedBy = "words")
    private List<User> users = new ArrayList<>();
}
