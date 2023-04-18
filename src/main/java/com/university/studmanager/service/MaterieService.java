package com.university.studmanager.service;

import com.university.studmanager.DTOs.MaterieDTO;
import com.university.studmanager.domain.An;
import com.university.studmanager.domain.Materie;
import com.university.studmanager.domain.PlanInvatamant;
import com.university.studmanager.exceptions.ErrorCodes;
import com.university.studmanager.exceptions.MaterieAlreadyExistsException;
import com.university.studmanager.repository.AnRepository;
import com.university.studmanager.repository.MaterieRepository;
import com.university.studmanager.repository.PlanInvatamantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterieService {

    private final MaterieRepository materieRepository;
    private final AnRepository anRepository;
    private final PlanInvatamantRepository planInvatamantRepository;

    @Autowired
    public MaterieService(MaterieRepository materieRepository,
                          AnRepository anRepository,
                          PlanInvatamantRepository planInvatamantRepository) {
        this.materieRepository = materieRepository;
        this.anRepository = anRepository;
        this.planInvatamantRepository = planInvatamantRepository;
    }

    public List<Materie> getAllByAn(Long idAn) {
        Optional<An> anOptional = anRepository.findById(idAn);
        return materieRepository.getAllByAn(anOptional.get());
    }

    public Materie addMaterie(MaterieDTO materieDTO) throws MaterieAlreadyExistsException {
        Optional<An> anOptional = anRepository.findById(materieDTO.getIdAn());
        Optional<PlanInvatamant> planInvatamantOptional = planInvatamantRepository.findById(materieDTO.getIdPlanInvatamant());
        Optional<Materie> materieToAdd = materieRepository.findByDenumireAndAn(materieDTO.getDenumire(), anOptional.get());
        if (materieToAdd.isEmpty()) {
            Materie materie = Materie.builder()
                    .denumire(materieDTO.getDenumire())
                    .nrOre(materieDTO.getNrOre())
                    .semestru(materieDTO.getSemestru())
                    .an(anOptional.get())
                    .planInvatamant(planInvatamantOptional.get())
                    .build();
            Materie addedMaterie = materieRepository.save(materie);
            return addedMaterie;
        } else {
            throw new MaterieAlreadyExistsException("Aceasta materia a fost deja adaugata!", ErrorCodes.GRUPA_ALREADY_EXISTS);
        }
    }

    public List<Materie> getAll() {
        return materieRepository.findAll();
    }
}
