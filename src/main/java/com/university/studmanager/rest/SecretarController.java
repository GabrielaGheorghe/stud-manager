package com.university.studmanager.rest;

import com.university.studmanager.DTOs.SecretarDTO;
import com.university.studmanager.DTOs.StudentDTO;
import com.university.studmanager.domain.Secretar;
import com.university.studmanager.domain.Student;
import com.university.studmanager.exceptions.SecretarAlreadyExistsException;
import com.university.studmanager.exceptions.StudentAlreadyExistsException;
import com.university.studmanager.service.SecretarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/secretar")
public class SecretarController {

    private final SecretarService secretarService;

    public SecretarController(SecretarService secretarService) {
        this.secretarService = secretarService;
    }

    @PostMapping("/add")
    public Secretar addSecretar(@RequestBody SecretarDTO secretarDTO) throws SecretarAlreadyExistsException {
        return this.secretarService.addSecretar(secretarDTO);
    }
}
