package com.gnosiseducacao.api.model;

import java.util.Collections;
import java.util.List;

public record StudentDTO(Long id, String nome, List<Long> subjects, String email, String password, String instituicao, String idade, String telefone, List<Long> notas) {

    public StudentDTO(Student student){
        this(student.getId(), student.getNome(), student.getSubjects() !=null ? student.getonlyname(student.getSubjects()) : Collections.emptyList(),student.getEmail(),student.getPassword(), student.getInstituicao(), student.getIdade(), student.getTelefone(), student.getGrades()!=null ? student.getonlyvalues(student.getGrades()) : Collections.emptyList());
    }
}
