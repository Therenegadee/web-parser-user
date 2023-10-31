package parser.userService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parser.userService.services.interfaces.UserService;
import user.openapi.api.UserApiDelegate;
import user.openapi.model.UserOpenApi;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController implements UserApiDelegate {
    private final UserService userService;

    @Override
    public ResponseEntity<UserOpenApi> showUserInfoById(Long id) {
        return userService.showUserInfo(id);
    }

    @Override
    public ResponseEntity<UserOpenApi> showUserInfoByUsername(String username) {
        return userService.showUserInfo(username);
    }
}
