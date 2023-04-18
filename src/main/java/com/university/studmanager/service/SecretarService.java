package com.university.studmanager.service;

import com.university.studmanager.DTOs.SecretarDTO;
import com.university.studmanager.domain.Departament;
import com.university.studmanager.domain.Role;
import com.university.studmanager.domain.Secretar;
import com.university.studmanager.domain.Users;
import com.university.studmanager.exceptions.ErrorCodes;
import com.university.studmanager.exceptions.SecretarAlreadyExistsException;
import com.university.studmanager.repository.DepartamentRepository;
import com.university.studmanager.repository.SecretarRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecretarService {

    private final SecretarRepository secretarRepository;

    private final PasswordEncoder passwordEncoder;

    private final UsersService usersService;

    private final DepartamentRepository departamentRepository;

    public SecretarService(SecretarRepository secretarRepository, PasswordEncoder passwordEncoder, UsersService usersService, DepartamentRepository departamentRepository) {
        this.secretarRepository = secretarRepository;
        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
        this.departamentRepository = departamentRepository;
    }

    public Secretar addSecretar(SecretarDTO secretarDTO) throws SecretarAlreadyExistsException {

        Optional<Departament> departamentOptional = departamentRepository.findById(secretarDTO.getIdDepartament());

            String email = secretarDTO.getNume() + "." + secretarDTO.getPrenume() + "@secretar.upb.ro";

            Users user = Users.builder()
                    .firstName(secretarDTO.getPrenume())
                    .lastName(secretarDTO.getNume())
                    .email(email)
                    .password(passwordEncoder.encode(secretarDTO.getNume()))
                    .role(Role.SECRETAR)
                    .build();

            usersService.addUser(user);

            Secretar secretar = Secretar.builder()
                    .nume(secretarDTO.getNume())
                    .prenume(secretarDTO.getPrenume())
                    .departament(departamentOptional.get())
                    .user(user)
                    .build();
            Secretar addedSecretar = secretarRepository.save(secretar);
            return addedSecretar;

    }
}
