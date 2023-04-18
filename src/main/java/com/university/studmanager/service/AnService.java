package com.university.studmanager.service;

import com.university.studmanager.DTOs.AnDTO;
import com.university.studmanager.domain.An;
import com.university.studmanager.domain.Departament;
import com.university.studmanager.domain.Facultate;
import com.university.studmanager.exceptions.AnAlreadyExistsException;
import com.university.studmanager.exceptions.ErrorCodes;
import com.university.studmanager.repository.AnRepository;
import com.university.studmanager.repository.DepartamentRepository;
import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AnService {

    private final AnRepository anRepository;
    private final DepartamentRepository departamentRepository;

    @Autowired
    public AnService(AnRepository anRepository,
                     DepartamentRepository departamentRepository) {
        this.anRepository = anRepository;
        this.departamentRepository = departamentRepository;
    }

    public List<An> getAllAni() {
        return anRepository.findAll();
    }

    public An getAnById(Long id) {
        return anRepository.findById(id).orElseThrow(NoSuchElementException:: new);
    }
    public An addAn(AnDTO anDTO) throws AnAlreadyExistsException {
        Optional<Departament> departamentOptional = departamentRepository.findById(anDTO.getIdAn());
        Optional<An> anToAdd = anRepository.findById(anDTO.getIdAn());
        if (anToAdd.isEmpty()) {
            An an = An.builder()
                    .idAn(anDTO.getIdAn())
                    .nrAn(anDTO.getNrAn())
                    .departament(departamentOptional.get())
                    .build();

            An addedAn = anRepository.save(an);
            return addedAn;
        } else {
            throw new AnAlreadyExistsException("Acest an de studiu exista deja!", ErrorCodes.AN_ALREADY_EXISTS);
        }


    }

    public void deleteAnById(Long idAn) {
        anRepository.deleteById(idAn);
    }
}
