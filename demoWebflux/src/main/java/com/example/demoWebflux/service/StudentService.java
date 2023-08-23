package com.example.demoWebflux.service;

import com.example.demoWebflux.model.Student;
import com.example.demoWebflux.repo.StudenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class StudentService {
    @Autowired
    private StudenRepository studenRepository;

    public Flux<Student> getAll() {
        return studenRepository.findAll();
    }

    public Mono<Student> add(Student student) {
        return studenRepository.save(student);
    }

    public Mono<Student> update(Integer id, Student student) {
        return studenRepository.findById(id)
                .flatMap(existingStudent -> {
                    existingStudent.setName(student.getName());
                    return studenRepository.save(existingStudent).then(Mono.just(existingStudent));
                });
    }


    public Mono<Student> update2(Integer id, Student student) {
        return this.studenRepository.findById(id)
                .map(p -> {
                    p.setName(student.getName());
                    return p;
                })
                .flatMap(p -> this.studenRepository.save(p));
    }

    public Mono<Void> deleteById(Integer id) {
        return studenRepository.deleteById(id);
    }
}
