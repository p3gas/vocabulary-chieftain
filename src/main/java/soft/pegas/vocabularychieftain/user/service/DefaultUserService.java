package soft.pegas.vocabularychieftain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.pegas.vocabularychieftain.user.model.User;
import soft.pegas.vocabularychieftain.user.model.UserDto;
import soft.pegas.vocabularychieftain.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(User::toUserDto).toList();
    }
}
