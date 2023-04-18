package com.university.studmanager.service;

import com.university.studmanager.DTOs.SerieDTO;
import com.university.studmanager.domain.An;
import com.university.studmanager.domain.Serie;
import com.university.studmanager.exceptions.DepartmentAlreadyExistsException;
import com.university.studmanager.exceptions.ErrorCodes;
import com.university.studmanager.exceptions.SerieAlreadyExistsException;
import com.university.studmanager.repository.AnRepository;
import com.university.studmanager.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SerieService {

    private final SerieRepository serieRepository;
    private final AnRepository anRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository, AnRepository anRepository) {
        this.serieRepository = serieRepository;
        this.anRepository = anRepository;
    }

    public Serie addSerie(SerieDTO serieDTO) throws SerieAlreadyExistsException {
        Optional<An> anOptional = anRepository.findById(serieDTO.getIdAn());
        Optional<Serie> serieToAdd = serieRepository.findByDenumireAndAn(serieDTO.getDenumire(), anOptional.get());
        if (serieToAdd.isEmpty()) {
            Serie serie = Serie.builder()
                    .denumire(serieDTO.getDenumire())
                    .an(anOptional.get())
                    .build();
            Serie addedSerie = this.serieRepository.save(serie);
            return addedSerie;
        } else {
            throw new SerieAlreadyExistsException("O serie cu aceasta denumire exista deja in cadrul departamentului si anului selectate!", ErrorCodes.SERIE_ALREADY_EXISTS);
        }
    }

    public List<Serie> getAllSerii() {
        return serieRepository.findAll();
    }

    public Serie getSerieById(Long id) {
        return serieRepository.findById(id).orElseThrow(NoSuchElementException:: new);
    }
}
