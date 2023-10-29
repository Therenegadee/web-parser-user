package parser.userService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import parser.userService.services.interfaces.UserService;
import user.openapi.api.UserApiDelegate;
import user.openapi.model.JwtResponseOpenApi;
import user.openapi.model.UserOpenApi;

@RestController
@RequestMapping("/api/user")
@FeignClient("user-service")
@RequiredArgsConstructor
public class UserController implements UserApiDelegate {
    private final UserService userService;
    @Override
    public ResponseEntity<UserOpenApi> showUserInfo(Long id) {
        return UserApiDelegate.super.showUserInfo(id);
    }

    @Override
    @GetMapping("/validateToken")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<JwtResponseOpenApi> validateToken(@RequestParam String jwtToken) {
        return userService.validateJwtToken(jwtToken);
    }
}
