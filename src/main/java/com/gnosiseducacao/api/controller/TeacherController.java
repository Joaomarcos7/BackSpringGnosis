package com.gnosiseducacao.api.controller;
import com.gnosiseducacao.api.model.Student;
import com.gnosiseducacao.api.model.Teacher;
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
    public List<Teacher> getTeachers(){
        return this.servico.getTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getstudentbyid(@PathVariable("id") Long id){
        return this.servico.getTeacherbyid(id);
    }

   @PostMapping
   public Teacher inserirouatualizar(@RequestBody Teacher teacher){
        return this.servico.inserirouatualizar(teacher);
   }

   @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id){
        this.servico.apagar(id);
   }

   @PutMapping("/{id}")
    public Teacher editteacher(@PathVariable("id") Long id,@RequestBody Teacher teacher){
       Teacher professor = this.servico.getTeacherbyid(id);
       BeanUtils.copyProperties(teacher, professor, getNullPropertyNames(teacher));
       return this.servico.inserirouatualizar(professor);
   }

   @GetMapping("/byemail")
   public List<Teacher> getbyemail(@RequestParam("email") String email){
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

}
