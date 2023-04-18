package com.university.studmanager.rest;

import com.university.studmanager.DTOs.AuthenticationDTO;
import com.university.studmanager.DTOs.ResponseRegisterDTO;
import com.university.studmanager.DTOs.RegistrationDTO;
import com.university.studmanager.exceptions.UserAlreadyExistsException;
import com.university.studmanager.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseRegisterDTO> register(@RequestBody RegistrationDTO credentials) throws UserAlreadyExistsException {
        return ResponseEntity.ok(authenticationService.register(credentials));
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseRegisterDTO> authenticate(@RequestBody AuthenticationDTO credentials) {
        return ResponseEntity.ok(authenticationService.authenticate(credentials));
    }
}
