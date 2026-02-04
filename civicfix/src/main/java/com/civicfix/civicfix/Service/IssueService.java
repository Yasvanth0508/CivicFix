package com.civicfix.civicfix.Service;

import com.civicfix.civicfix.Endity.IssueEndity;
import com.civicfix.civicfix.Repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class IssueService
{
	@Autowired
	private IssueRepository issueRepository;
	
	public IssueEndity createIssue(IssueEndity issue)
	{
		return issueRepository.save(issue);
	}
	
	public List<IssueEndity> readAllIssues()
	{
		return issueRepository.findAll();
	}
	
	public IssueEndity readIssueById(Long id)
	{
		return issueRepository.findById(id).orElse(null);
	}
	
	public IssueEndity updateIssue(Long id, IssueEndity newIssue)
	{
		IssueEndity existingIssue = issueRepository.findById(id).orElse(null);
		if(existingIssue != null)
		{
			existingIssue.setTitle(newIssue.getTitle());
			existingIssue.setDescription(newIssue.getDescription());
			existingIssue.setCategory(newIssue.getCategory());
			existingIssue.setStatus(newIssue.getStatus());
			return issueRepository.save(existingIssue);
		}
		return null;
	}
	
	public void deleteIssue(Long id)
	{
		issueRepository.deleteById(id);
	}

	public IssueEndity updateIssueStatus(Long id, String status)
	{
		IssueEndity existingIssue = issueRepository.findById(id).orElse(null);
		if(existingIssue != null)
		{
			existingIssue.setStatus(status);
			return issueRepository.save(existingIssue);
		}
		return null;
	}

	public java.util.List<IssueEndity> getIssuesByStatus(String status)
	{
		java.util.List<IssueEndity> all = issueRepository.findAll();
		java.util.List<IssueEndity> filtered = new java.util.ArrayList<>();
		for(IssueEndity i : all)
		{
			if(i != null && status != null && status.equals(i.getStatus()))
			{
				filtered.add(i);
			}
		}
		return filtered;
	}


}
