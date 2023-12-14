package com.gnosiseducacao.api.repositories;

import com.gnosiseducacao.api.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Long> {
}
