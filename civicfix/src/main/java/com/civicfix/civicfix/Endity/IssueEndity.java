package com.civicfix.civicfix.Endity;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class IssueEndity
{
	@Autowired
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String title;
	private String description;
	private String category;
	private String status;

	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEndity user;
    
    @ManyToOne
    @JoinColumn(name = "worker_id", nullable = false)
    private WorkerEndity worker;
    
    
	
    
	
}
