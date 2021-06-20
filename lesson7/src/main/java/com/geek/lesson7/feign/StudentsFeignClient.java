package com.geek.lesson7.feign;

import com.geek.lesson7.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Students", url = "http://localhost:8189/api/students")
public interface StudentsFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Student> findAll();

    @PostMapping
    public void save(@RequestBody Student student);

    @PutMapping
    public Student update(@RequestBody Student student);

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id);
}
