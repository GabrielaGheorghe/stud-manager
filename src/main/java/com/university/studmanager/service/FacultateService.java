package com.university.studmanager.service;

import com.university.studmanager.DTOs.FacultateDTO;
import com.university.studmanager.domain.Facultate;
import com.university.studmanager.exceptions.ErrorCodes;
import com.university.studmanager.exceptions.FacultyAlreadyExistsException;
import com.university.studmanager.repository.FacultateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FacultateService {

    private final FacultateRepository facultateRepository;

    @Autowired
    public FacultateService(FacultateRepository facultateRepository) {
        this.facultateRepository = facultateRepository;
    }

    public Facultate addFacultate(FacultateDTO facultateDTO) throws FacultyAlreadyExistsException {
        Optional<Facultate> facultate = facultateRepository.findFacultateByDenumire(facultateDTO.getDenumire());
        if (facultate.isEmpty()) {
            Facultate facultateToAdd = Facultate.builder().denumire(facultateDTO.getDenumire()).build();
            return facultateRepository.save(facultateToAdd);
        }
        else {
            throw new FacultyAlreadyExistsException("O facultate cu aceeasi denumire exista deja!", ErrorCodes.FACULTY_ALREADY_EXISTS);
        }
    }

    public List<Facultate> getFacultati() {
        return this.facultateRepository.findAll(Sort.by(Sort.Order.asc("denumire").ignoreCase()));
    }

    public Facultate getFacultateById(Long id) {
        return facultateRepository.findById(id).orElseThrow(NoSuchElementException:: new);
    }
}
