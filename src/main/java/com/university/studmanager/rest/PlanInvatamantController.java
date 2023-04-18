package com.university.studmanager.rest;

import com.university.studmanager.DTOs.MaterieDTO;
import com.university.studmanager.DTOs.PlanInvatamantDTO;
import com.university.studmanager.domain.Materie;
import com.university.studmanager.domain.PlanInvatamant;
import com.university.studmanager.exceptions.MaterieAlreadyExistsException;
import com.university.studmanager.service.PlanInvatamantService;
import com.university.studmanager.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/plan-invatamant")
public class PlanInvatamantController {

    private final PlanInvatamantService planInvatamantService;

    @Autowired
    public PlanInvatamantController(PlanInvatamantService planInvatamantService) {
        this.planInvatamantService = planInvatamantService;
    }

    @PostMapping("/add")
    public PlanInvatamant addPlanInvatamant(@RequestBody PlanInvatamantDTO planInvatamantDTO) {
        return planInvatamantService.addPlanInvatamant(planInvatamantDTO);
    }
}
