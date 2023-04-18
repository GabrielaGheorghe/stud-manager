package com.university.studmanager.rest;

import com.university.studmanager.domain.Catalog;
import com.university.studmanager.domain.Student;
import com.university.studmanager.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/add")
    public Catalog addNota(@RequestBody Catalog nota) {
        return catalogService.addNota(nota);
    }

    @GetMapping("get")
    public List<Catalog> getNoteByStudentId(@RequestBody Student student) {
        return catalogService.getNoteByStudent(student);
    }
}
