package soft.pegas.vocabularychieftain.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import soft.pegas.vocabularychieftain.common.model.BaseModel;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseModel {

    private String firstName;

    private String lastName;

    private String email;
}
