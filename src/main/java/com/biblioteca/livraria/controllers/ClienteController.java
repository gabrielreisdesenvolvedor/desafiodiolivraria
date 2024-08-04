/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.controllers;

import com.biblioteca.livraria.models.ClienteModel;
import com.biblioteca.livraria.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    
   // @PostMapping
   // public ResponseEntity<Object> salvarCliente(@RequestBody ClienteModel model){
   //      return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.adicionarCliente(model));
   // }
    
    @GetMapping
    public ResponseEntity<Page<ClienteModel>> buscarTodos(@RequestParam(defaultValue = "0") int pagina,@RequestParam(defaultValue = "10")  int quantidade){
       return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.buscarTodos(pagina,quantidade));
        
         
    }
    
}
