package com.civicfix.civicfix.Repository;

import com.civicfix.civicfix.Endity.UserEndity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEndity, Long>
{
	
}
