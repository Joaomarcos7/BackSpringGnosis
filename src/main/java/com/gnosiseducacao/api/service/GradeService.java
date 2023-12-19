package com.gnosiseducacao.api.service;

import com.gnosiseducacao.api.model.Grade;
import com.gnosiseducacao.api.model.GradeDTO;
import com.gnosiseducacao.api.repositories.GradeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository repository;

    public List<GradeDTO> getallgrades(){
        return this.repository.findAll().stream().map(GradeDTO::new).toList();
    }

    public Grade getgradebyid(Long id){
        return this.repository.findById(id).orElse(null);
    }

    public GradeDTO getgradeDTObyid(Long id){
        return  new GradeDTO(this.repository.findById(id).orElse(null));
    }

    public void apagargrade(Long id){
        this.repository.deleteById(id);
    }
@Transactional
    public GradeDTO inserirouatualizar(Grade grade){
        return new GradeDTO(this.repository.save(grade));
    }

    public List<GradeDTO> getgradesfromstudent(Long id){
        return this.repository.gradesfromstudent(id).stream().map(GradeDTO::new).toList();
    }

    public List<GradeDTO> getgradesbysubject(Long id){
        return this.repository.gradesfromsubject(id).stream().map(GradeDTO::new).toList();
    }


}
