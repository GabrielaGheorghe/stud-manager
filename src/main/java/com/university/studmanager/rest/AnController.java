package com.university.studmanager.rest;

import com.university.studmanager.DTOs.AnDTO;
import com.university.studmanager.DTOs.DepartamentDTO;
import com.university.studmanager.domain.An;
import com.university.studmanager.domain.Departament;
import com.university.studmanager.exceptions.AnAlreadyExistsException;
import com.university.studmanager.exceptions.DepartmentAlreadyExistsException;
import com.university.studmanager.service.AnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/an")
public class AnController {

    private final AnService anService;

    @Autowired
    public AnController(AnService anService) {
        this.anService = anService;
    }

    @GetMapping()
    public List<An> getAllAni() {
        return this.anService.getAllAni();
    }

    @GetMapping("/get")
    public An getAnById(@RequestParam(name = "id") Long id) {
        return anService.getAnById(id);
    }

    @PostMapping("/add")
    public An addAn(@RequestBody AnDTO anDTO) throws AnAlreadyExistsException {
        return anService.addAn(anDTO);
    }

    @DeleteMapping("/delete")
    public void deleteAnById(@RequestParam(name = "id") Long id) {
        anService.deleteAnById(id);
    }
}
