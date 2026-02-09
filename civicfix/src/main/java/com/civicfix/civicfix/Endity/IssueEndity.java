package com.civicfix.civicfix.Endity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NonNull;


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
	@NonNull
	private CategoryEndity category;
	private String status;
	@ManyToOne
	@Nonnull
    @JoinColumn(name = "user_id", nullable = false)
    private UserEndity user;
    
}