package com.gnosiseducacao.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Array;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name="tb_subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "subjects",cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
    private List<Student> students;
    @OneToOne(mappedBy = "subject",cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
    private Teacher teacher;
    @OneToMany(mappedBy = "subject",cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.LAZY)
    private List<Grade> grades;

    public List<Long> getonlyid(List<Student> students){

            ArrayList<Long> ids = new ArrayList<>();
            if(!students.isEmpty()) {
                for (Student student : students) {
                    ids.add(student.getId());
                }
                return ids;
            }
            return ids;
    }

    public void addstudent(Student student){
        this.getStudents().add(student);
        student.getSubjects().add(this);
    }

}
