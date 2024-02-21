package soft.pegas.vocabularychieftain.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import soft.pegas.vocabularychieftain.misc.model.BaseModel;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseModel {

    private String firstName;

    private String lastName;

    private String email;
}
