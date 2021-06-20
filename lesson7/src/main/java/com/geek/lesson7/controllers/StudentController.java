package com.geek.lesson7.controllers;

import com.geek.lesson7.models.Student;
import com.geek.lesson7.repos.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentRepository.save(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        studentRepository.deleteById(id);
    }



}
