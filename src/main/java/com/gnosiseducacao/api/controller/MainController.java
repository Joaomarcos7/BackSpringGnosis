package com.gnosiseducacao.api.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTMLDocument;

@RestController
@RequestMapping("")
public class MainController {

    @GetMapping
    public String mainpage(){
        return "Seja bem vindo a nossa API GNosis";
    }
}
