package com.university.studmanager.service;

import com.university.studmanager.DTOs.PlanInvatamantDTO;
import com.university.studmanager.domain.An;
import com.university.studmanager.domain.PlanInvatamant;
import com.university.studmanager.repository.AnRepository;
import com.university.studmanager.repository.PlanInvatamantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanInvatamantService {
    private final AnRepository anRepository;
    private final PlanInvatamantRepository planInvatamantRepository;

    public PlanInvatamantService(AnRepository anRepository, PlanInvatamantRepository planInvatamantRepository) {
        this.anRepository = anRepository;
        this.planInvatamantRepository = planInvatamantRepository;
    }

    public PlanInvatamant addPlanInvatamant(PlanInvatamantDTO planInvatamantDTO) {
        Optional<An> anToAdd = anRepository.findById(planInvatamantDTO.getIdAn());
        PlanInvatamant planInvatamant = PlanInvatamant.builder()
                .an(anToAdd.get())
                .build();
        PlanInvatamant addedPlanInvatamant = planInvatamantRepository.save(planInvatamant);
        return addedPlanInvatamant;
    }
}
