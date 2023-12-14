package com.gnosiseducacao.api.service;

import com.gnosiseducacao.api.model.Student;
import com.gnosiseducacao.api.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getstudents(){
        return this.repository.findAll();
    }


    public Student getstudentbyid(Long id){
        return this.repository.findById(id).orElse(null);
    }

    @Transactional
    public Student inserirouatualizar(Student student){
        Student aluno= this.repository.save(student);
        return aluno;
    }

    public void apagar(long id){
        this.repository.deleteById(id);
    }

    public List<Student> getstudentbyemail(String email){
        return this.repository.findStudentsByEmail(email);
    }



}
