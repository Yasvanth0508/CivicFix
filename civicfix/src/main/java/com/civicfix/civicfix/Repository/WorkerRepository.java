package com.civicfix.civicfix.repository;

import com.civicfix.civicfix.entity.WorkerEndity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEndity, Long>
{
    boolean existsByEmail(String email);
}
