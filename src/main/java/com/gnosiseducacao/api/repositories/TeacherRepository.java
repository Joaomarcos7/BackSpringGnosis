package com.gnosiseducacao.api.repositories;

import com.gnosiseducacao.api.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Query("SELECT t from Teacher t where t.email=:email")
    public List<Teacher> getsteacherbyemail(@Param("email") String email);


    @Query("SELECT t from Teacher t where t.subject.id in :ids")
    public List<Teacher> getteachersbysubjects(@Param("ids") List<Long> ids);
}
