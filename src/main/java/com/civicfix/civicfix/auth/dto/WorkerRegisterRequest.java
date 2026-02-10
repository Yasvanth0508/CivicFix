package com.civicfix.civicfix.auth.dto;

import lombok.Data;

@Data
public class WorkerRegisterRequest {

    private String name;
    private String email;
    private String password;
    private Long categoryId;
}
