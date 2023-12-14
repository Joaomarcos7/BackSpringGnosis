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

    public Student getstudentbyid(long id){
        return this.repository.findById(id).orElse(null);
    }

    @Transactional
    public Student inserirouatualizar(Student student){
        Student aluno= this.repository.save(student);
        if(Integer.parseInt(aluno.getidade())<18){
            throw new RuntimeException("Idade não permitida!");
        }
        return aluno;
    }

    public void apagar(long id){
        this.repository.deleteById(id);
    }



}
