package com.civicfix.civicfix.Repository;

import com.civicfix.civicfix.Endity.IssueEndity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<IssueEndity, Long>
{
	
}
