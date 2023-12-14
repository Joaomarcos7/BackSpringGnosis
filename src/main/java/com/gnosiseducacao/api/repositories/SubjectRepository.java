package com.gnosiseducacao.api.repositories;

import com.gnosiseducacao.api.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
