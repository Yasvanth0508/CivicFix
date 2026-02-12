package com.civicfix.civicfix.service;

import com.civicfix.civicfix.entity.CategoryEndity;
import com.civicfix.civicfix.entity.WorkerEndity;
import com.civicfix.civicfix.repository.WorkerRepository;
import com.civicfix.civicfix.repository.CategoryRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService
{
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private CategoryRepository CategoryRepository;

    public WorkerEndity createWorker(
            String name,
            String email,
            Long categoryId
    ) {
        CategoryEndity category = CategoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        WorkerEndity worker = new WorkerEndity();
        worker.setName(name);
        worker.setEmail(email);
        worker.setCategory(category);

        return workerRepository.save(worker);
    }


    
}
