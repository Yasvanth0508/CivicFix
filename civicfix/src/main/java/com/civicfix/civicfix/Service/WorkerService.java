package com.civicfix.civicfix.Service;

import com.civicfix.civicfix.Endity.WorkerEndity;
import com.civicfix.civicfix.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkerService
{
    @Autowired
    private WorkerRepository workerRepository;

    public WorkerEndity createWorker(WorkerEndity worker)
    {
        return workerRepository.save(worker);
    }

    public List<WorkerEndity> readAllWorkers()
    {
        return workerRepository.findAll();
    }

    public WorkerEndity readWorkerById(Long id)
    {
        return workerRepository.findById(id).orElse(null);
    }

    public WorkerEndity updateWorker(Long id, WorkerEndity newWorker)
    {
        WorkerEndity existing = workerRepository.findById(id).orElse(null);
        if(existing != null)
        {
            existing.setName(newWorker.getName());
            existing.setDepartment(newWorker.getDepartment());
            return workerRepository.save(existing);
        }
        return null;
    }

    public void deleteWorker(Long id)
    {
        workerRepository.deleteById(id);
    }
}
