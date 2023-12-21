package com.gnosiseducacao.api.controller;

import com.gnosiseducacao.api.model.Student;
import com.gnosiseducacao.api.model.StudentDTO;
import com.gnosiseducacao.api.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentDTO> getStudents(){
        return this.service.getstudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getstudentbyid(@PathVariable("id") Long id){
        return this.service.getstudentDTObyid(id);
    }

    @PostMapping
    public StudentDTO inserirstudent(@RequestBody Student student){
        return this.service.inserirouatualizar(student);
    }

    @PutMapping("/{id}")
    public StudentDTO atualizarstudent(@PathVariable("id") Long id ,@RequestBody Student student){
        Student aluno = this.service.getstudentbyid(id);
        BeanUtils.copyProperties(student, aluno, getNullPropertyNames(student));
        return this.service.inserirouatualizar(aluno);
    }

    @DeleteMapping("/{id}")
    public void apagarstudent(@PathVariable long id){
        this.service.apagar(id);
    }

    @GetMapping("/byemail")
    public List<StudentDTO> getstudentbyemail(@RequestParam String email){
      return  this.service.getstudentbyemail(email);
    }


    @PutMapping("/addsubject")
    public void addsubjectinstudent(@RequestParam("idstudent") Long idstudent, @RequestParam("idsubject") Long idsubject){

        this.service.adicionarDisciplinaParaAluno(idstudent,idsubject);

    }


    @GetMapping("/studentsbysubject/{id}")
    public List<StudentDTO> getstudentsbysubject(@PathVariable Long id ){
        return this.service.getstudentsbysubject(id);
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
