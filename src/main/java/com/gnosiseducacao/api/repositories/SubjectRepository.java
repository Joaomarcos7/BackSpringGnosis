package com.gnosiseducacao.api.repositories;

import com.gnosiseducacao.api.model.Subject;
import com.gnosiseducacao.api.model.SubjectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

    @Query("Select s from Subject s LEFT JOIN FETCH s.students stu where stu.id=:id")
    public List<Subject> getsubjectsbystudent(@Param("id") Long id);
}
