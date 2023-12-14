package com.gnosiseducacao.api.repositories;

import com.gnosiseducacao.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  StudentRepository extends JpaRepository<Student,Long> {
}
