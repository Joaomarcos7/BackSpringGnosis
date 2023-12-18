package com.gnosiseducacao.api.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public record SubjectDTO(Long id, List<String> students, String nome, String teacher) {
    public SubjectDTO(Subject subject){
       this(subject.getId(),subject.getonlyname(subject.getStudents()),subject.getName(),subject.getTeacher()!=null ? subject.getTeacher().getnome() : "");
    }


}
