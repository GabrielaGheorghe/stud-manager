package com.university.studmanager.repository;

import com.university.studmanager.domain.An;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnRepository extends JpaRepository<An, Long> {
}
