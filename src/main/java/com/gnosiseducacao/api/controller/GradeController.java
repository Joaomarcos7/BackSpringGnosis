package com.gnosiseducacao.api.controller;

import com.gnosiseducacao.api.model.Grade;
import com.gnosiseducacao.api.service.GradeService;
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

    @GetMapping
    public List<Grade> getallgrades() {
        return this.service.getallgrades();
    }

    @GetMapping("/{id}")
    public Grade getgradebyid(@RequestParam("id") Long id) {
        return this.service.getgradebyid(id);
    }

    @PostMapping
    public Grade inserirgrade(@RequestBody Grade grade) {
        return this.service.inserirouatualizar(grade);
    }


    @PutMapping("/{id}")
    public Grade atualizargrade(@PathVariable("id") Long id, @RequestBody Grade grade) {
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
    public List<Grade> getgradefromstudent(@PathVariable("id") Long id){
        return this.service.getgradesfromstudent(id);
    }



}
