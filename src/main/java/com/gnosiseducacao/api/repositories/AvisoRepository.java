package com.gnosiseducacao.api.repositories;

import com.gnosiseducacao.api.model.Aviso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvisoRepository extends JpaRepository<Aviso,Long> {

    @Query("SELECT a FROM Aviso a WHERE a.teacher.id=:id")
    public List<Aviso> getavisosbyteacher(@Param("id") Long id);

    @Query("Select a from Aviso a where a.teacher.id IN :ids")
    public List<Aviso> getavisosbyteachers(@Param("ids") List<Long> ids);

}
