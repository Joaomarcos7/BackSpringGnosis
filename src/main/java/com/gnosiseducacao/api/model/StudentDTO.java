package com.gnosiseducacao.api.model;

import java.util.Collections;
import java.util.List;

public record StudentDTO(Long id, String nome, List<String> subjects, String email, String password, String instituicao, String idade, String telefone, List<String> notas) {

    public StudentDTO(Student student){
        this(student.getId(), student.getNome(), !student.getSubjects().isEmpty() ? student.getonlyname(student.getSubjects()) : Collections.emptyList(),student.getEmail(),student.getPassword(), student.getInstituicao(), student.getIdade(), student.getTelefone(), student.getonlyvalues(student.getGrades()));
    }
}
