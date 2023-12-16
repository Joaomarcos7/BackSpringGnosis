package com.gnosiseducacao.api.service;

import com.gnosiseducacao.api.model.Grade;
import com.gnosiseducacao.api.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository repository;

    public List<Grade> getallgrades(){
        return this.repository.findAll();
    }

    public Grade getgradebyid(Long id){
        return this.repository.findById(id).orElse(null);
    }

    public void apagargrade(Long id){
        this.repository.deleteById(id);
    }

    public Grade inserirouatualizar(Grade grade){
        return this.repository.save(grade);
    }


}
