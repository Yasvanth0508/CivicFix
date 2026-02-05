package com.civicfix.civicfix.Repository;

import com.civicfix.civicfix.Endity.CategoryEndity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEndity, Long> {

}
