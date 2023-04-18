package com.university.studmanager.service;

import com.university.studmanager.DTOs.GrupaDTO;
import com.university.studmanager.domain.Grupa;
import com.university.studmanager.domain.Serie;
import com.university.studmanager.exceptions.ErrorCodes;
import com.university.studmanager.exceptions.GrupaAlreadyExistsException;
import com.university.studmanager.repository.GrupaRepository;
import com.university.studmanager.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GrupaService {

    private final GrupaRepository grupaRepository;
    private final SerieRepository serieRepository;

    @Autowired
    public GrupaService(GrupaRepository grupaRepository,
                        SerieRepository serieRepository) {
        this.grupaRepository = grupaRepository;
        this.serieRepository = serieRepository;
    }

    public Grupa addGrupa(GrupaDTO grupaDTO) throws GrupaAlreadyExistsException {
        Optional<Serie> serieOptional = serieRepository.findById(grupaDTO.getIdSerie());
        Optional<Grupa> grupaToAdd = grupaRepository.findGrupaByDenumireAndSerie(grupaDTO.getDenumire(), serieOptional.get());
        if (grupaToAdd.isEmpty()) {
            Grupa grupa = Grupa.builder()
                    .denumire(grupaDTO.getDenumire())
                    .serie(serieOptional.get())
                    .build();
            Grupa addedGrupa = grupaRepository.save(grupa);
            return addedGrupa;
        } else {
            throw new GrupaAlreadyExistsException("O grupa cu aceasta denumire exista deja in caadrul acestei serii!", ErrorCodes.GRUPA_ALREADY_EXISTS);
        }
    }

    public List<Grupa> getAllGrupe() {
        return grupaRepository.findAll();
    }

    public Grupa getGrupaById(Long id) {
        return grupaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
