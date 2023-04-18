package com.university.studmanager.service;

import com.university.studmanager.DTOs.DepartamentDTO;
import com.university.studmanager.domain.An;
import com.university.studmanager.domain.Departament;
import com.university.studmanager.domain.Facultate;
import com.university.studmanager.exceptions.DepartmentAlreadyExistsException;
import com.university.studmanager.exceptions.ErrorCodes;
import com.university.studmanager.repository.AnRepository;
import com.university.studmanager.repository.DepartamentRepository;
import com.university.studmanager.repository.FacultateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DepartamentService {

    private final DepartamentRepository departamentRepository;
    private final AnRepository anRepository;

    private final FacultateRepository facultateRepository;

    @Autowired
    public DepartamentService(DepartamentRepository departamentRepository, AnRepository anRepository, FacultateRepository facultateRepository) {
        this.departamentRepository = departamentRepository;
        this.anRepository = anRepository;
        this.facultateRepository = facultateRepository;
    }

    @Transactional
    public Departament addDepartament(DepartamentDTO departamentDTO) throws DepartmentAlreadyExistsException {
        Optional<Facultate> facultateOptional = facultateRepository.findById(departamentDTO.getIdFacultate());
        Optional<Departament> departamentToAdd = departamentRepository.findByDenumireAndFacultate(departamentDTO.getDenumire(), facultateOptional.get());
        if (departamentToAdd.isEmpty()) {
            Departament departament = Departament.builder()
                    .denumire(departamentDTO.getDenumire())
                    .facultate(facultateOptional.get())
                    .build();
            Departament addedDepartament = departamentRepository.save(departament);
            for (long i = 1; i <= 4; i++) {
                anRepository.save(An.builder()
                        .nrAn(i)
                        .departament(addedDepartament)
                        .build());
            }
            return addedDepartament;
        } else {
            throw new DepartmentAlreadyExistsException("Un departament cu aceasta denumire exista deja in aceasta facultate!", ErrorCodes.DEPARTMENT_ALREADY_EXISTS);
        }
    }

    public List<Departament> getAllDepartamente() {
        return this.departamentRepository.findAll();
    }

    public Departament getDepartamentById(Long id) {
        return departamentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
