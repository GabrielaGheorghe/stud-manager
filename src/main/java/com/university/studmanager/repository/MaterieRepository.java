package com.university.studmanager.repository;

import com.university.studmanager.domain.An;
import com.university.studmanager.domain.Materie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterieRepository extends JpaRepository<Materie, Long> {

    List<Materie> getAllByAn(An an);

    Optional<Materie> findByDenumireAndAn(String denumire, An an);
}
