package com.gnosiseducacao.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private double valor;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch=FetchType.LAZY)
    private Student student;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch=FetchType.LAZY)
    private Subject subject;

    public long getid(){
        return this.id;
    }

    public void setid(long id){
        this.id=id;
    }

    public double getvalor(){
        return this.valor;
    }

    public void setvalor(double valor){
        this.valor=valor;
    }

    public Subject getsubject(){
        return this.subject;
    }

    public void setsubject(Subject subject){
        this.subject=subject;
    }

    public Student getstudent(){
        return this.student;
    }

    public void setStudent(Student student){
        this.student=student;
    }

}
