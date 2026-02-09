package com.civicfix.civicfix.Service;

import com.civicfix.civicfix.Endity.WorkerEndity;
import com.civicfix.civicfix.Repository.WorkerRepository;

import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkerService
{
    @Autowired
    private WorkerRepository workerRepository;

    public WorkerEndity createWorker(@NonNull WorkerEndity worker)
    {
        return workerRepository.save(worker);
    }

    public List<WorkerEndity> readAllWorkers()
    {
        return workerRepository.findAll();
    }

    public WorkerEndity readWorkerById(@NonNull Long id)
    {
        return workerRepository.findById(id).orElse(null);
    }

    public WorkerEndity updateWorker(@NonNull Long id, WorkerEndity newWorker)
    {
        WorkerEndity existing = workerRepository.findById(id).orElse(null);
        if(existing != null)
        {
            existing.setName(newWorker.getName());
            existing.setEmail(newWorker.getEmail());
            existing.setCategory(newWorker.getCategory());
            return workerRepository.save(existing);
        }
        return null;
    }

    public void deleteWorker(@NonNull Long id)
    {
        workerRepository.deleteById(id);
    }
}
