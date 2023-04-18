package com.university.studmanager.repository;

import com.university.studmanager.domain.Facultate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultateRepository extends JpaRepository<Facultate, Long> {

    Optional<Facultate> findFacultateByDenumire(String denumireFacultate);

}
