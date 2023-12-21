package com.gnosiseducacao.api.controller;

import com.gnosiseducacao.api.model.Subject;
import com.gnosiseducacao.api.model.SubjectDTO;
import com.gnosiseducacao.api.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService service;

    @GetMapping
    public List<SubjectDTO> getsubjects(){
        return this.service.getsubjects();
    }

    @GetMapping("/{id}")
    public SubjectDTO getsubjectbyid(@PathVariable("id") Long id ){
        return this.service.getsubjectDTObyid(id);
    }


    @PostMapping
    public SubjectDTO inserir(@RequestBody Subject subject){
        return new SubjectDTO(this.service.inserirouatualizar(subject));
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id){
        this.service.deletesubject(id);
    }


    @PutMapping("/{id}")
    public SubjectDTO edit(@PathVariable("id") Long id,@RequestBody Subject subject){
        Subject materia= this.service.getsubjectbyid(id);
        BeanUtils.copyProperties(subject, materia, getNullPropertyNames(subject));
        return new SubjectDTO(this.service.inserirouatualizar(materia));
    }

    @GetMapping("/student/{id}")
    public List<SubjectDTO> getsubjectbystudent(@PathVariable("id") Long id){
        return this.service.getsubjectbystudent(id);
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
}
