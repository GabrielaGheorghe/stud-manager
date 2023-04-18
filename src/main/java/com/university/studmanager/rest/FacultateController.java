package com.university.studmanager.rest;

import com.university.studmanager.DTOs.FacultateDTO;
import com.university.studmanager.domain.Facultate;
import com.university.studmanager.exceptions.FacultyAlreadyExistsException;
import com.university.studmanager.service.FacultateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultate")
@Slf4j
public class FacultateController {

    private final FacultateService facultateService;

    @Autowired
    public FacultateController(FacultateService facultateService) {
        this.facultateService = facultateService;
    }

    @PostMapping("/add")
    public ResponseEntity<Facultate> addFacultate(@RequestBody FacultateDTO facultateDTO) throws FacultyAlreadyExistsException {
        return ResponseEntity.ok(this.facultateService.addFacultate(facultateDTO));
    }

    @GetMapping
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public List<Facultate> getFacultati() {
        return this.facultateService.getFacultati();
    }

    @GetMapping("/get")
    public Facultate getFacultateById(@RequestParam(name = "id") Long id) {
        return facultateService.getFacultateById(id);
    }
}
