package com.civicfix.civicfix.Endity;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEndity category;
	private String status;
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEndity user;
    
}