package com.gnosiseducacao.api.controller;

import com.gnosiseducacao.api.model.Student;
import com.gnosiseducacao.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.service.getstudents();
    }

    @GetMapping("/students/{id}")
    public Student getstudentbyid(@PathVariable("id") Long id){
        return this.service.getstudentbyid(id);
    }

    @PostMapping("/students")
    public Student inserirstudent(@RequestBody Student student){
        return this.service.inserirouatualizar(student);
    }

    @PutMapping("/students/{id}")
    public Student atualizarstudent(@RequestBody Student student){
        return this.service.inserirouatualizar(student);
    }

    @DeleteMapping("/students/{id}")
    public void apagarstudent(@PathVariable long id){
        this.service.apagar(id);
    }

}
