package com.university.studmanager.repository;

import com.university.studmanager.domain.An;
import com.university.studmanager.domain.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    Optional<Serie> findByDenumireAndAn(String denumire, An an);

}
