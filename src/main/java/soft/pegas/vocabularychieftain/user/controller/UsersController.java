package soft.pegas.vocabularychieftain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.pegas.vocabularychieftain.misc.url.UrlConst;
import soft.pegas.vocabularychieftain.user.model.User;
import soft.pegas.vocabularychieftain.user.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(UrlConst.USER)
@RequiredArgsConstructor
public class UsersController {

    private final UserRepository userRepository;

    @GetMapping("/all")
    List<User> getUsers() {
        return userRepository.findAll();
    }
}
