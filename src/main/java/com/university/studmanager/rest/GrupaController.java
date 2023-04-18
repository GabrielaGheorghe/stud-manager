package com.university.studmanager.rest;

import com.university.studmanager.DTOs.GrupaDTO;
import com.university.studmanager.domain.Grupa;
import com.university.studmanager.exceptions.GrupaAlreadyExistsException;
import com.university.studmanager.service.GrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/grupa")
public class GrupaController {

    private final GrupaService grupaService;

    @Autowired
    public GrupaController(GrupaService grupaService) {
        this.grupaService = grupaService;
    }

    @PostMapping("/add")
    public Grupa addGrupa(@RequestBody GrupaDTO grupaDTO) throws GrupaAlreadyExistsException {
        return this.grupaService.addGrupa(grupaDTO);
    }

    @GetMapping()
    public List<Grupa> getAllGrupe() {
        return grupaService.getAllGrupe();
    }

    @GetMapping("/get")
    public Grupa getGrupaById(@RequestParam(name = "id") Long id) {
        return grupaService.getGrupaById(id);
    }
}
