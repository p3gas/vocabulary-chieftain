package soft.pegas.vocabularychieftain.user.model;

import lombok.*;

@Builder
public record UserDto(String firstName, String lastName, String email) {

}
