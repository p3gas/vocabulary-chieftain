package soft.pegas.vocabularychieftain.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.pegas.vocabularychieftain.user.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
