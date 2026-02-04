package com.civicfix.civicfix.Controller;

import com.civicfix.civicfix.Endity.WorkerEndity;
import com.civicfix.civicfix.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/civicfix")
public class WorkerController
{
    @Autowired
    private WorkerService workerService;

    @PostMapping("/worker/create")
    public WorkerEndity create(@RequestBody WorkerEndity w)
    {
        return workerService.createWorker(w);
    }

    @GetMapping("/worker/readall")
    public List<WorkerEndity> readAll()
    {
        return workerService.readAllWorkers();
    }

    @GetMapping("/worker/readbyid/{id}")
    public WorkerEndity readById(@PathVariable Long id)
    {
        return workerService.readWorkerById(id);
    }

    @PutMapping("/worker/update/{id}")
    public WorkerEndity update(@PathVariable Long id, @RequestBody WorkerEndity w)
    {
        return workerService.updateWorker(id, w);
    }

    @DeleteMapping("/worker/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        workerService.deleteWorker(id);
    }
}
