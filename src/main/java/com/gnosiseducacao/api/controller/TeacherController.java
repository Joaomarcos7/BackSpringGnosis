package com.gnosiseducacao.api.controller;
import com.gnosiseducacao.api.model.Teacher;
import com.gnosiseducacao.api.model.TeacherDTO;
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
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService servico;

    @GetMapping
    public List<TeacherDTO> getTeachers(){
        return this.servico.getTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDTO getstudentbyid(@PathVariable("id") Long id){
        return this.servico.getTeacherDTObyid(id);
    }

   @PostMapping
   public TeacherDTO inserirouatualizar(@RequestBody Teacher teacher){
        return new TeacherDTO( this.servico.inserirouatualizar(teacher));
   }

   @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id){
        this.servico.apagar(id);
   }

   @PutMapping("/{id}")
    public TeacherDTO editteacher(@PathVariable("id") Long id,@RequestBody Teacher teacher){
       Teacher professor = this.servico.getTeacherbyid(id);
       BeanUtils.copyProperties(teacher, professor, getNullPropertyNames(teacher));
       return new TeacherDTO(this.servico.inserirouatualizar(professor));
   }

   @GetMapping("/byemail")
   public List<TeacherDTO> getbyemail(@RequestParam("email") String email){
        return this.servico.findbyemail(email);
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

    @GetMapping("/subjects")
    public List<TeacherDTO> getbysubjects(@RequestParam(value = "ids" , required = false) List<Long> ids){
        return this.servico.findbysubjects(ids);
    }

}
