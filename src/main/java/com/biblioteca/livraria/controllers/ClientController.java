/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.controllers;

import com.biblioteca.livraria.dtos.BookDto;
import com.biblioteca.livraria.dtos.ClientDto;
import com.biblioteca.livraria.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Substitua pelo URL do seu frontend
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> create(@Valid @RequestBody ClientDto clientDto) {
        ClientDto clientCreate = this.clientService.create(clientDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(clientCreate);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDto>> findAll(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) int size,
            @RequestParam(defaultValue = "name") String sort) {

        Page<ClientDto> clients = this.clientService.findAll(page, size, sort);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(UUID id){
        ClientDto clientDto = this.clientService.findById(id);
        return ResponseEntity.ok(clientDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient (@PathVariable("id") UUID id, @RequestBody @Valid ClientDto clientDto){
        String update = this.clientService.updateClient(id, clientDto);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") UUID id){
        String delete = this.clientService.deleteClient(id);
        return ResponseEntity.ok(delete);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteBook(@PathVariable("name") String name){
        String delete = this.clientService.deleteClient(name);
        return ResponseEntity.ok(delete);
    }
}
