/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.controllers;

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

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/client")
@Tag(name = "Client")
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente com os detalhes fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Entrada inválida.")
    })
    @PostMapping
    public ResponseEntity<ClientDto> create(@Valid @RequestBody ClientDto clientDto) {
        ClientDto clientCreate = this.clientService.addClient(clientDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(clientCreate);
    }

    @Operation(summary = "Obter todos os clientes", description = "Obtém uma lista paginada de todos os clientes com ordenação opcional.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes obtida com sucesso.")
    })
    @GetMapping
    public ResponseEntity<Page<ClientDto>> findAll(
            @RequestParam(defaultValue = "0") @Parameter(description = "Número da página a ser obtida") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Parameter(description = "Número de itens por página") @Min(1) int size,
            @RequestParam(defaultValue = "name") @Parameter(description = "Campo para ordenar a lista") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<ClientDto> clients = this.clientService.findAll(pageable);
        return ResponseEntity.ok(clients);
    }
}
