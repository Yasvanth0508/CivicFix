package com.civicfix.civicfix.repository;

import com.civicfix.civicfix.entity.CategoryEndity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEndity, Long> {

}
