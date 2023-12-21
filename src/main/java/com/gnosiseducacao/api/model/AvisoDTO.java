package com.gnosiseducacao.api.model;

public record AvisoDTO(Long id, String text, String header, String hora , Long teacher) {
    public AvisoDTO(Aviso aviso){
        this(aviso.getId(), aviso.getText(),aviso.getHeader(),aviso.getHora(),aviso.getTeacher().getId());
    }
}
