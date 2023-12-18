package com.gnosiseducacao.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nome;
    private String email;
    private String password;
    private String instituicao;

    private String idade;

    private String endereco;

    private String telefone;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
    @JoinColumn(name = "teachersubject_id")
    private Subject subject;
    @OneToMany(mappedBy = "teacher",cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
    private List<Aviso> avisos;



    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id=id;
    }

    public String getnome(){
        return this.nome;
    }

    public List<String> getonlyname(List<Student> students){
        List<String> names= Collections.emptyList();
        for(Student student : students){
            names.add(student.getNome());
        }
        return names;
    }
}
