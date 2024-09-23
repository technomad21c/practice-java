package com.example.sessiontest.sse.repo;

import com.example.sessiontest.sse.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Long> {
}
