package com.gnosiseducacao.api.service;

import com.gnosiseducacao.api.model.Aviso;
import com.gnosiseducacao.api.model.AvisoDTO;
import com.gnosiseducacao.api.repositories.AvisoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;

@Service
public class AvisoService {

    @Autowired
    private AvisoRepository repository;

    public List<AvisoDTO> getavisos(){
        return this.repository.findAll().stream().map(AvisoDTO::new).toList();
    }

    public AvisoDTO getavisoDTO(Long id){
        return  new AvisoDTO(this.repository.findById(id).orElse(null));
    }
    public Aviso getaviso(Long id){
        return  this.repository.findById(id).orElse(null);
    }

    @Transactional
    public AvisoDTO inserirouatualizaraviso(Aviso aviso){
        return new AvisoDTO(this.repository.save(aviso));
    }

    public void deleteaviso(Long id){
        this.repository.deleteById(id);
    }

    public List<AvisoDTO> getavisosbyteacher(Long id){
        return this.repository.getavisosbyteacher(id).stream().map(AvisoDTO::new).toList();
    }

    public List<AvisoDTO> getavisosbyteachers(List<Long> ids){
        return this.repository.getavisosbyteachers(ids).stream().map(AvisoDTO::new).toList();
    }

}
