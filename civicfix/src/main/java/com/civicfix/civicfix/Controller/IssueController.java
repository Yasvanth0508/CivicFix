package com.civicfix.civicfix.Controller;

import com.civicfix.civicfix.Endity.IssueEndity;
import com.civicfix.civicfix.Service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/civicfix")
public class IssueController
{
	@Autowired
	private IssueService issueService;
	
	@PostMapping("/issue/create")
	public IssueEndity create(@RequestBody IssueEndity issue)
	{
		return issueService.createIssue(issue);
	}
	
	@GetMapping("/issue/readall")
	public List<IssueEndity> readAll()
	{
		return issueService.readAllIssues();
	}
	
	@GetMapping("/issue/readbyid/{id}")
	public IssueEndity readById(@PathVariable Long id)
	{
		return issueService.readIssueById(id);
	}
	
	@PutMapping("/issue/update/{id}")
	public IssueEndity update(@PathVariable Long id, @RequestBody IssueEndity issue)
	{
		return issueService.updateIssue(id, issue);
	}
	
	@DeleteMapping("/issue/delete/{id}")
	public void delete(@PathVariable Long id)
	{
		issueService.deleteIssue(id);
	}
}
