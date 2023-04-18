package com.university.studmanager.repository;

import com.university.studmanager.domain.Catalog;
import com.university.studmanager.domain.Materie;
import com.university.studmanager.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

//    Catalog findByMaterieAndIdStudent(Long idMaterie, Long idStudent);

    Catalog findCatalogByMaterieAndStudent(Materie materie, Student student);
    List<Catalog> getAllByStudent(Student student);
}
