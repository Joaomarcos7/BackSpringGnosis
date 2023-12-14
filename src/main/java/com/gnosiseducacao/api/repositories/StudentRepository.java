package com.gnosiseducacao.api.repositories;

import com.gnosiseducacao.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  StudentRepository extends JpaRepository<Student,Long> {

    // Consulta personalizada usando JPQL
    @Query("SELECT s FROM Student s WHERE s.email = :email")
    List<Student> findStudentsByEmail(@Param("email") String email);
}
