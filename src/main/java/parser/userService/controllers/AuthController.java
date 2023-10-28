package parser.userService.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import parser.userService.openapi.api.AuthorizationApiDelegate;
import parser.userService.services.interfaces.AuthService;
import parser.userService.openapi.model.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@FeignClient("auth-service")
@RequiredArgsConstructor
@Log4j
public class AuthController implements AuthorizationApiDelegate {
    private final AuthService authService;

    @Override
    @PostMapping("/signin")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<JwtResponseOpenApi> authenticateUser(@Valid @RequestBody LoginRequestOpenApi loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @Override
    @PostMapping("/signup")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody SignupRequestOpenApi signUpRequest) {
        return authService.registerUser(signUpRequest);
    }

    @Override
    @PatchMapping("/activation")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<Void> activateUser(@RequestParam("activationToken") String activationToken) {
        return authService.activateUser(activationToken);
    }
}