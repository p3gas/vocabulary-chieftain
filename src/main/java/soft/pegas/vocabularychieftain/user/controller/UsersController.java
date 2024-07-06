package soft.pegas.vocabularychieftain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.pegas.vocabularychieftain.common.url.UrlConst;
import soft.pegas.vocabularychieftain.user.model.UserDto;
import soft.pegas.vocabularychieftain.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping(UrlConst.USER)
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("/all")
    List<UserDto> getUsers() {
        return userService.getAll();
    }
}
