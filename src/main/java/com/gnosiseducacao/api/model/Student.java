package com.gnosiseducacao.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id")
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

    public void setNome(String nome){
        this.nome=nome;
    }


    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone=telefone;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco=endereco;
    }


    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email=email;
    }


    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getInstituicao(){
        return this.instituicao;
    }

    public void setInstituicao(String instituicao){
        this.instituicao=instituicao;
    }

    public String getIdade(){
        return this.idade;
    }

    public void setIdade(String idade){
        this.idade=idade;
    }

    public List<Grade> getGrades(){return this.grades;}

    public void setGrades(List<Grade> grades){this.grades=grades;}

}
