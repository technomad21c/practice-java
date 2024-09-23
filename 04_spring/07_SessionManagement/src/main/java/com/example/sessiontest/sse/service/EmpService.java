package com.example.sessiontest.sse.service;

import com.example.sessiontest.sse.model.Emp;
import com.example.sessiontest.sse.repo.EmpRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmpService {
    @Autowired
    private EmpRepo repository;

    // Save a new employee into the database.
    public void save(final Emp employee) {
        repository.save(employee);
    }

    // Get the total count of employees from the database.
    public long getTotalEmployees() {
        log.info("Finding the total count of employees from the database.");
        return repository.count();
    }

    // Get all employees from the database.
    public List<Emp> findAll() {
        log.info("Fetching all employees from the database.");
        return repository.findAll();
    }
}
