package com.gnosiseducacao.api.service;

import com.gnosiseducacao.api.model.Subject;
import com.gnosiseducacao.api.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository repository;

    public List<Subject> getsubjects(){
        return this.repository.findAll();
    }

    public Subject getsubjectbyid(Long id){
        return this.repository.findById(id).orElse(null);
    }

    public Subject inserirouatualizar(Subject subject){
        return this.repository.save(subject);
    }

    public void deletesubject(Long id){
        this.repository.deleteById(id);
    }

}
