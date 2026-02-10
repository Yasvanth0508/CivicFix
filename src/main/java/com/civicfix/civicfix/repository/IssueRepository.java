package com.civicfix.civicfix.repository;

import com.civicfix.civicfix.entity.IssueEndity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<IssueEndity, Long>
{
	java.util.List<IssueEndity> findByUser_Id(Long userId);
}
