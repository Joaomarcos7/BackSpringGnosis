package com.gnosiseducacao.api.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public record SubjectDTO(Long id, List<Long> students, String nome, Long teacher) {
    public SubjectDTO(Subject subject){
       this(subject.getId(),!subject.getStudents().isEmpty() ? subject.getonlyid(subject.getStudents()): Collections.emptyList(),subject.getName(),subject.getTeacher()!=null ? subject.getTeacher().getId() : 0);
    }


}
