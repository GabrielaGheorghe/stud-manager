package com.university.studmanager.repository;

import com.university.studmanager.domain.Secretar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretarRepository extends JpaRepository<Secretar, Long> {
}
