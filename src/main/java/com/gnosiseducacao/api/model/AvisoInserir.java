package com.gnosiseducacao.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvisoInserir {

    private String text;
    private String header;
    private Long teacher;
    private String hora;

}
