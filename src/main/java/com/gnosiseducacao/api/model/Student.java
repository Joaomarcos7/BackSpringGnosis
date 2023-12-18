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

    public List<String> getonlyname(List<Subject> subjects){

       ArrayList<String> names = new ArrayList<>();
        if(!subjects.isEmpty()) {
            for (Subject subject : subjects) {
                names.add(subject.getName());
            }
            return names;
        }
        return names;
    }

    public List<String> getonlyvalues(List<Grade> grades){
        ArrayList<String> names =new ArrayList<>();
        if(!grades.isEmpty()) {
            for (Grade grade: grades) {
                names.add(Double.toString(grade.getvalor()));
            }
            return names;
        }
        return names;
    }


}
