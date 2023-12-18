package com.gnosiseducacao.api.model;

public record TeacherDTO(Long id, String nome, String subject,String email,String password,String instituicao, String idade, String telefone) {
    public TeacherDTO(Teacher teacher){
        this(teacher.getId(), teacher.getnome(), teacher.getSubject().getName(),teacher.getEmail(), teacher.getPassword(), teacher.getInstituicao(), teacher.getIdade(),teacher.getTelefone());
    }
}
