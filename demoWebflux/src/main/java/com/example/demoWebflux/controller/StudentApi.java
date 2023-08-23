package com.example.demoWebflux.controller;

import com.example.demoWebflux.model.Student;
import com.example.demoWebflux.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class StudentApi {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public Flux<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/add")
    public Mono<Student> add(@RequestBody Student student){
        return studentService.add(student);
    }

    @PutMapping("/update/{id}")
    public Mono<Student> update(@PathVariable Integer id,@RequestBody Student student){
        return studentService.update2(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable Integer id){
        return studentService.deleteById(id);
    }

}
