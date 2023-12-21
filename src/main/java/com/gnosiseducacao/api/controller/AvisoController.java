package com.gnosiseducacao.api.controller;

import com.gnosiseducacao.api.model.Aviso;
import com.gnosiseducacao.api.model.AvisoDTO;
import com.gnosiseducacao.api.model.AvisoInserir;
import com.gnosiseducacao.api.repositories.AvisoRepository;
import com.gnosiseducacao.api.service.AvisoService;
import com.gnosiseducacao.api.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/avisos")
public class AvisoController {

    @Autowired
    private AvisoService service;
    @Autowired
    private TeacherService teacherservice;
    @GetMapping
    public List<AvisoDTO> getavisos(){
        return this.service.getavisos();
    }

    @GetMapping("/{id}")
    public AvisoDTO getaviso(@PathVariable("id") Long id){
        return this.service.getavisoDTO(id);
    }

    @PostMapping
    public AvisoDTO inseriraviso(@RequestBody AvisoInserir avisoinserir){
        Aviso aviso = new Aviso();
        aviso.setHeader(avisoinserir.getHeader());
        aviso.setText(avisoinserir.getText());
        aviso.setHora(avisoinserir.getHora());
        aviso.setTeacher(this.teacherservice.getTeacherbyid(avisoinserir.getTeacher()));

        return   this.service.inserirouatualizaraviso(aviso);
    }

    @PutMapping("/{id}")
    public AvisoDTO atualizaraviso(@PathVariable("id") Long id, @RequestBody Aviso avisoinserir){
       Aviso aviso = this.service.getaviso(id);
        BeanUtils.copyProperties(avisoinserir, aviso, getNullPropertyNames(avisoinserir));
       return this.service.inserirouatualizaraviso(aviso);
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
    public void apagaraviso(@PathVariable("id") Long id){
        this.service.deleteaviso(id);
    }

    @GetMapping("/teacher/{id}")
    public List<AvisoDTO> getavisosbyteacher(@PathVariable("id") Long id){
        return this.service.getavisosbyteacher(id);
    }

    @GetMapping("/teachers")
    public List<AvisoDTO> getavisosbyteachers(@RequestParam(value = "ids",required = false) List<Long> ids){
        return this.service.getavisosbyteachers(ids);
    }

}
