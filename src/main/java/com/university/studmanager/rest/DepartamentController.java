package com.university.studmanager.rest;

import com.university.studmanager.DTOs.DepartamentDTO;
import com.university.studmanager.domain.Departament;
import com.university.studmanager.exceptions.DepartmentAlreadyExistsException;
import com.university.studmanager.service.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departament")
public class DepartamentController {

    private final DepartamentService departamentService;

    @Autowired
    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @PostMapping("/add")
    public Departament addDepartament(@RequestBody DepartamentDTO departamentDTO) throws DepartmentAlreadyExistsException {
        return departamentService.addDepartament(departamentDTO);
    }

    @GetMapping
    public List<Departament> getAllDepartamente() {
        return this.departamentService.getAllDepartamente();
    }

    @GetMapping("/get")
    public Departament getDepartamentById(@RequestParam(name = "id") Long id) {
        return departamentService.getDepartamentById(id);
    }
}
