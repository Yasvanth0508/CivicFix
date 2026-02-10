package com.civicfix.civicfix.controller;

import com.civicfix.civicfix.entity.IssueEndity;
import com.civicfix.civicfix.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("issue")
public class IssueController {
	@Autowired
	private IssueService issueService;

	@PostMapping("/user/create")
	public IssueEndity create(@RequestBody IssueEndity issue) {
		return issueService.createIssue(issue);
	}

	@GetMapping("/worker/readall")
	public List<IssueEndity> readAll() {
		return issueService.readAllIssues();
	}

	@GetMapping("/worker/readbyid/{id}")
	public IssueEndity readById(@PathVariable Long id) {
		return issueService.readIssueById(id);
	}

	@GetMapping("/worker/readbycategory/{categoryId}")
	public java.util.List<IssueEndity> readByCategory(@PathVariable Long categoryId) {
		return issueService.getIssuesByCategoryId(categoryId);
	}

	@GetMapping("/user/readbyuser/{userId}")
	public java.util.List<IssueEndity> readByUser(@PathVariable Long userId) {
		return issueService.getIssuesByUserId(userId);
	}

	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable Long id) {
		issueService.deleteIssue(id);
	}
}
