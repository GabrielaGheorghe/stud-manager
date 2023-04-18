package com.university.studmanager.repository;

import com.university.studmanager.domain.Departament;
import com.university.studmanager.domain.Facultate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {

    Optional<Departament> findByDenumireAndFacultate(String denumire, Facultate facultate);

}
