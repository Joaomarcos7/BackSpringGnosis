package com.gnosiseducacao.api.service;

import com.gnosiseducacao.api.model.Teacher;
import com.gnosiseducacao.api.model.TeacherDTO;
import com.gnosiseducacao.api.repositories.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public List<TeacherDTO> getTeachers(){
        return this.repository.findAll().stream().map(TeacherDTO::new).toList();
    }

    public TeacherDTO getTeacherDTObyid(Long id){
        return new TeacherDTO(this.repository.findById(id).orElse(null));
    }

    public Teacher getTeacherbyid(Long id){
        return this.repository.findById(id).orElse(null);
    }


    @Transactional
    public Teacher inserirouatualizar(Teacher teacher){
        return this.repository.save(teacher);
    }

    public void apagar(Long id){
        this.repository.deleteById(id);
    }

    public List<TeacherDTO> findbyemail(String email){
        return this.repository.getsteacherbyemail(email).stream().map(TeacherDTO::new).toList();
    }

}
