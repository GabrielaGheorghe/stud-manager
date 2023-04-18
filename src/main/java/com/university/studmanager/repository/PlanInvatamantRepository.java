package com.university.studmanager.repository;

import com.university.studmanager.domain.PlanInvatamant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanInvatamantRepository extends JpaRepository<PlanInvatamant, Long> {
}
