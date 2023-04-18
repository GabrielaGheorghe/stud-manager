package com.university.studmanager.service;

import com.university.studmanager.DTOs.AuthenticationDTO;
import com.university.studmanager.DTOs.ResponseRegisterDTO;
import com.university.studmanager.DTOs.RegistrationDTO;
import com.university.studmanager.domain.Administrator;
import com.university.studmanager.domain.Role;
import com.university.studmanager.domain.Users;
import com.university.studmanager.exceptions.ErrorCodes;
import com.university.studmanager.exceptions.UserAlreadyExistsException;
import com.university.studmanager.repository.AdministratorRepository;
import com.university.studmanager.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final AdministratorRepository administratorRepository;

    public ResponseRegisterDTO register(RegistrationDTO request) throws UserAlreadyExistsException {
        var registerUser = usersRepository.findByEmail(request.getEmail());
        String domain = request.getEmail().split("@")[1];
        String user_role = domain.split("[.]")[0];
        Users user = null;
        if (registerUser.isEmpty()) {
            if (user_role.equals("admin")) {
                user = Users.builder()
                        .firstName(request.getFirstname())
                        .lastName(request.getLastname())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.ADMIN)
                        .build();
                usersRepository.save(user);
                var administrator = Administrator.builder()
                        .user(user)
                        .build();
                administratorRepository.save(administrator);
            } else if (user_role.equals("secretar")) {
                user = Users.builder()
                        .firstName(request.getFirstname())
                        .lastName(request.getLastname())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.SECRETAR)
                        .build();
                usersRepository.save(user);

            } else {
                user = Users.builder()
                        .firstName(request.getFirstname())
                        .lastName(request.getLastname())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.USER)
                        .build();
                usersRepository.save(user);
            }
        } else {
            throw new UserAlreadyExistsException("An user with this username already exists in database!", ErrorCodes.USER_ALREADY_EXISTS);
        }
        var jwtToken = jwtService.generateToken(new HashMap<>(), user);
        return ResponseRegisterDTO.builder()
                .token(jwtToken)
                .build();
    }

    public ResponseRegisterDTO authenticate(AuthenticationDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = usersRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(new HashMap<>(), user);
        return ResponseRegisterDTO.builder()
                .token(jwtToken)
                .build();
    }
}
