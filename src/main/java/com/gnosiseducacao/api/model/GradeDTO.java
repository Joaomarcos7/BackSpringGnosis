package com.gnosiseducacao.api.model;

public record GradeDTO(Long id, String valor , Long student, Long subject) {
    public GradeDTO(Grade grade){
        this(grade.getid(), Double.toString(grade.getvalor()),grade.getstudent()!=null?grade.getstudent().getId():0,grade.getsubject()!=null ? grade.getsubject().getId(): 0);
    }
}
