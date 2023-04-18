package com.university.studmanager.repository;

import com.university.studmanager.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByNrMatricolAndCnp(String nrMatricol, String cnp);

    Student findByIdStudent(Long studentId);
}
