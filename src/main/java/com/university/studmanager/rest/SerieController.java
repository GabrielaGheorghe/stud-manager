package com.university.studmanager.rest;

import com.university.studmanager.DTOs.SerieDTO;
import com.university.studmanager.domain.Serie;
import com.university.studmanager.exceptions.DepartmentAlreadyExistsException;
import com.university.studmanager.exceptions.SerieAlreadyExistsException;
import com.university.studmanager.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/serie")
public class SerieController {

    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping(value = "/add")
    public Serie addSerie(@RequestBody SerieDTO serieDTO) throws SerieAlreadyExistsException {
        return this.serieService.addSerie(serieDTO);
    }

    @GetMapping()
    public List<Serie> getAllSerii() {
        return this.serieService.getAllSerii();
    }

    @GetMapping("/get")
    public Serie getSerieById(@RequestParam(name = "id") Long id) {
        return serieService.getSerieById(id);
    }
}
