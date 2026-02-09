package com.civicfix.civicfix.Service;

import com.civicfix.civicfix.Endity.CategoryEndity;
import com.civicfix.civicfix.Endity.IssueEndity;
import com.civicfix.civicfix.Endity.UserEndity;
import com.civicfix.civicfix.Repository.CategoryRepository;
import com.civicfix.civicfix.Repository.IssueRepository;
import com.civicfix.civicfix.Repository.UserRepository;

import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IssueService {
	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;

	public IssueEndity createIssue(@NonNull IssueEndity issue) {
		if (issue.getCategory() != null && issue.getCategory().getId() != null) {
			CategoryEndity category = categoryRepository.findById(issue.getCategory().getId())
					.orElse(null);

			issue.setCategory(category);
		}

		if (issue.getUser() != null && issue.getUser().getId() != null) {
			UserEndity user = userRepository.findById(issue.getUser().getId())
					.orElse(null);

			issue.setUser(user);
		}

		return issueRepository.save(issue);
	}

	public java.util.List<IssueEndity> getIssuesByCategoryId(Long categoryId) {
		java.util.List<IssueEndity> all = issueRepository.findAll();
		java.util.List<IssueEndity> filtered = new java.util.ArrayList<>();

		for (IssueEndity i : all) {
			if (i != null
					&& i.getCategory() != null
					&& i.getCategory().getId() != null
					&& i.getCategory().getId().equals(categoryId)) {
				filtered.add(i);
			}
		}

		return filtered;
	}

	public List<IssueEndity> readAllIssues() {
		return issueRepository.findAll();
	}

	public IssueEndity readIssueById(@lombok.NonNull Long id) {
		return issueRepository.findById(id).orElse(null);
	}

	public IssueEndity updateIssue(@lombok.NonNull Long id, IssueEndity newIssue) {
		IssueEndity existingIssue = issueRepository.findById(id).orElse(null);
		if (existingIssue != null) {
			existingIssue.setTitle(newIssue.getTitle());
			existingIssue.setDescription(newIssue.getDescription());
			existingIssue.setCategory(newIssue.getCategory());
			existingIssue.setStatus(newIssue.getStatus());
			return issueRepository.save(existingIssue);
		}
		return null;
	}

	public void deleteIssue(@lombok.NonNull Long id) {
		issueRepository.deleteById(id);
	}

	public IssueEndity updateIssueStatus(@lombok.NonNull Long id, String status) {
		IssueEndity existingIssue = issueRepository.findById(id).orElse(null);
		if (existingIssue != null) {
			existingIssue.setStatus(status);
			return issueRepository.save(existingIssue);
		}
		return null;
	}

	public java.util.List<IssueEndity> getIssuesByStatus(String status) {
		java.util.List<IssueEndity> all = issueRepository.findAll();
		java.util.List<IssueEndity> filtered = new java.util.ArrayList<>();
		for (IssueEndity i : all) {
			if (i != null && status != null && status.equals(i.getStatus())) {
				filtered.add(i);
			}
		}
		return filtered;
	}

	public java.util.List<IssueEndity> getIssuesByUserId(Long userId) {
		return issueRepository.findByUser_Id(userId);
	}

}
