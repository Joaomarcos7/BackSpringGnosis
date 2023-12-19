package com.gnosiseducacao.api.model;

import jakarta.validation.constraints.Null;

public record TeacherDTO(Long id, String nome, Long subject, String email, String password, String instituicao, String idade, String telefone) {
    public TeacherDTO(Teacher teacher){
        this(teacher.getId(), teacher.getnome(),teacher.getSubject()!=null ? teacher.getSubject().getId(): null,teacher.getEmail(), teacher.getPassword(), teacher.getInstituicao(), teacher.getIdade(),teacher.getTelefone());
    }
}
