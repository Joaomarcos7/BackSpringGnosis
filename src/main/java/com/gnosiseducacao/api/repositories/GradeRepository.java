package com.gnosiseducacao.api.repositories;

import com.gnosiseducacao.api.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade,Long> {
@Query("Select g FROM Grade g where g.student.id=:id")
    public List<Grade> gradesfromstudent(@Param("id") Long id);

}
