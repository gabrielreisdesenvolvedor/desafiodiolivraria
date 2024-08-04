/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.controllers;

import com.biblioteca.livraria.service.CategoriasService;
import com.biblioteca.livraria.models.CategoriasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/controller")
public class CategoriasController {
    
    @Autowired
    CategoriasService service;
    
    @PostMapping
    public ResponseEntity<CategoriasModel> adicionarCategoria(){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.adicionarCategoria());
    }
}
