package soft.pegas.vocabularychieftain.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import soft.pegas.vocabularychieftain.common.model.BaseModel;
import soft.pegas.vocabularychieftain.learning_resource.model.Word;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseModel {

    private String firstName;

    private String lastName;

    private String email;

    @ManyToMany
    @JoinTable(
            name = "user_word",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "word_id")
    )
    private List<Word> words = new ArrayList<>();

    public void addWord(Word word) {
        words.add(word);
        word.getUsers().add(this);
    }

    public UserDto toUserDto() {
        return UserDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
    }
}
