package com.gnosiseducacao.api.model;

import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
@Table(name="tb_subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch=FetchType.LAZY)
    private ArrayList<Student> students=new ArrayList<>();
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
    private Teacher teacher;

}
