package com.gnosiseducacao.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

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



    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id=id;
    }

    public String getnome(){
        return this.nome;
    }

    public void setnome(String nome){
        this.nome=nome;
    }

    public String getinstituicao(){
        return this.instituicao;
    }

    public void setInstituicao(String instituicao){
        this.instituicao=instituicao;
    }

    public String gettelefone(){
        return this.telefone;
    }

    public void settelefone(String telefone){
        this.telefone=telefone;
    }

    public String getendereco(){
        return this.endereco;
    }

    public void setendereco(String endereco){
        this.endereco=endereco;
    }


    public String getemail(){
        return this.email;
    }

    public void setemail(String email){
        this.email=email;
    }


    public String getpassword(){
        return this.password;
    }

    public void setpassword(String password){
        this.password=password;
    }

    public String getidade(){
        return this.idade;
    }

    public void setidade(String idade){
        this.idade=idade;
    }

    public Subject getsubject(){
        return this.subject;
    }

    public void setsubject(Subject subject){
        this.subject=subject;
    }

}
