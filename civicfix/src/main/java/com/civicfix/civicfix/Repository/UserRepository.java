package com.civicfix.civicfix.repository;

import com.civicfix.civicfix.entity.UserEndity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEndity, Long>
{
	
}
