package com.gnosiseducacao.api.repositories;

import com.gnosiseducacao.api.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
