package com.civicfix.civicfix.controller;

import com.civicfix.civicfix.auth.dto.WorkerRegisterRequest;
import com.civicfix.civicfix.auth.service.AuthService;
import com.civicfix.civicfix.entity.WorkerEndity;
import com.civicfix.civicfix.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @Autowired
    private AuthService authService;

    @PostMapping("/worker/register")
    public String registerWorker(@RequestBody WorkerRegisterRequest req) {

        WorkerEndity worker = workerService.createWorker(
                req.getName(),
                req.getEmail(),
                req.getCategoryId());

        authService.createWorkerAuth(
                req.getEmail(),
                req.getPassword(),
                worker.getId());

        return "Worker registered successfully";
    }

}
