package com.university.studmanager.repository;

import com.university.studmanager.domain.Grupa;
import com.university.studmanager.domain.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Long> {

    Optional<Grupa> findGrupaByDenumireAndSerie(String denumireGrupa, Serie serie);

}
