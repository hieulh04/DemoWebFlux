package com.example.demoWebflux.repo;

import com.example.demoWebflux.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenRepository extends R2dbcRepository<Student,Integer> {

}
