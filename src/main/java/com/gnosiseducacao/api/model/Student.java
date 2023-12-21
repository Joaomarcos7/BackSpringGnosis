package com.gnosiseducacao.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name="tb_student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String password;
    private String endereco;

    private String instituicao;
    private String idade;
    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
    @JoinTable(
            name = "student_subject"
    )
    private List<Subject> subjects;
    @OneToMany(mappedBy = "student",cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
    private List<Grade> grades;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNome(){
        return this.nome;
    }

    public void addSubject(Subject subject){
        this.getSubjects().add(subject);
        subject.getStudents().add(this);
    }

    public List<Long> getonlyname(List<Subject> subjects){

       ArrayList<Long> names = new ArrayList<>();
            for (Subject subject : subjects) {
                names.add(subject.getId());
            }
            return names;
    }

    public List<Long> getonlyvalues(List<Grade> grades){
        ArrayList<Long> names =new ArrayList<>();
        if(!grades.isEmpty()) {
            for (Grade grade: grades) {
                names.add(grade.getid());
            }
            return names;
        }
        return names;
    }

    public void adicionarnota(Grade grade){
        this.getGrades().add(grade);
    }

}
