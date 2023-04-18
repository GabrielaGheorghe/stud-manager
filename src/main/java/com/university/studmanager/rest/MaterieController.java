package com.university.studmanager.rest;

import com.university.studmanager.DTOs.MaterieDTO;
import com.university.studmanager.domain.An;
import com.university.studmanager.domain.Materie;
import com.university.studmanager.exceptions.MaterieAlreadyExistsException;
import com.university.studmanager.service.MaterieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/materie")
public class MaterieController {

    private final MaterieService materieService;

    @Autowired
    public MaterieController(MaterieService materieService) {
        this.materieService = materieService;
    }

    @GetMapping("/get")
    public List<Materie> getMateriiByAn(@RequestParam(name = "id") Long idAn) {
        return materieService.getAllByAn(idAn);
    }

    @PostMapping("/add")
    public Materie addMaterie(@RequestBody MaterieDTO materieDTO) throws MaterieAlreadyExistsException {
        return materieService.addMaterie(materieDTO);
    }

    @GetMapping("/get-all")
    public List<Materie> getAllMaterii() {
        return materieService.getAll();
    }
}
