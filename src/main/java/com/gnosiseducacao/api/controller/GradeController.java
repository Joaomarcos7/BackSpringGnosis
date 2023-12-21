package com.gnosiseducacao.api.controller;

import com.gnosiseducacao.api.model.Grade;
import com.gnosiseducacao.api.model.GradeDTO;
import com.gnosiseducacao.api.model.GradeInserir;
import com.gnosiseducacao.api.service.GradeService;
import com.gnosiseducacao.api.service.StudentService;
import com.gnosiseducacao.api.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService service;
    @Autowired
    private SubjectService subjectservice;
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<GradeDTO> getallgrades() {
        return this.service.getallgrades();
    }

    @GetMapping("/{id}")
    public GradeDTO getgradebyid(@PathVariable("id") Long id) {
        return this.service.getgradeDTObyid(id);
    }

    @PostMapping
    public GradeDTO inserirgrade(@RequestBody GradeInserir notainserir) {
        Grade grade= new Grade();
        grade.setvalor(notainserir.getValor());
        grade.setsubject(this.subjectservice.getsubjectbyid(notainserir.getSubject()));
        grade.setStudent(this.studentService.getstudentbyid(notainserir.getStudent()));
        return this.service.inserirouatualizar(grade);
    }


    @PutMapping("/{id}")
    public GradeDTO atualizargrade(@PathVariable("id") Long id, @RequestBody Grade grade) {
        Grade nota = this.service.getgradebyid(id);
        BeanUtils.copyProperties(grade, nota, getNullPropertyNames(grade));
        return this.service.inserirouatualizar(nota);
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
    @DeleteMapping("/{id}")
    public void deletegrade(@PathVariable("id") Long id) {
        this.service.apagargrade(id);
    }

    @GetMapping("/student/{id}")
    public List<GradeDTO> getgradefromstudent(@PathVariable("id") Long id){
        return this.service.getgradesfromstudent(id);
    }

    @GetMapping("/getbysubject/{id}")
    public List<GradeDTO> getgradebysubject(@PathVariable("id") Long id){
        return this.service.getgradesbysubject(id);
    }



}
