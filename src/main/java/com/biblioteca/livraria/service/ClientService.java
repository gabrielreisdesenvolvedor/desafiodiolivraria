/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.service;

import com.biblioteca.livraria.dtos.BookDto;
import com.biblioteca.livraria.dtos.ClientDto;
import com.biblioteca.livraria.models.BookModel;
import com.biblioteca.livraria.models.ClientModel;
import com.biblioteca.livraria.repositories.ClientRepository;
import java.util.Scanner;
import java.util.UUID;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class ClientService {
    
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    EmailService emailService;
    
    Scanner scanner = new Scanner(System.in);
    
    @Transactional
    public ClientDto create(ClientDto clientDto){

        ClientModel model = new ClientModel(clientDto);
        var modelCreate = this.clientRepository.save(model);

        emailService.sendSimpleEmail(
        clientDto.getEmail(),
        "Bem vindo a nossa livraria",
        "Você agora faz parte da nossa livraria."
        );

        return new ClientDto(modelCreate);
    }

    @Transactional
    public Page<ClientDto> findAll(int page, int size, String sort ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).ascending());
        Page<ClientModel> clientModel = this.clientRepository.findAll(pageable);
        return clientModel.map(ClientDto::new);
    }

    @Transactional
    public ClientDto findById(UUID id){
       ClientModel clientModel = this.clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client Not Found."));
       return new ClientDto(clientModel);
    }

    @Transactional
    public String updateClient(UUID id, ClientDto clientDto){
        ClientModel clientModel = this.clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client Not Found."));
        clientModel.setName(clientDto.getName());
        clientModel.setEmail(clientDto.getEmail());
        clientModel.setAddress(clientDto.getAddress());
        clientModel.setAccountBalance(clientDto.getAccountBalance());

        this.clientRepository.save(clientModel);

        return "Client update with success";
    }

    @Transactional
    public String deleteClient(UUID id){
        ClientModel clientModel = this.clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client Not Found."));
        this.clientRepository.deleteById(clientModel.getId());
        return "Client delete with success.";
    }

    @Transactional
    public String deleteClient(String name){
        ClientModel clientModel = this.clientRepository.findByName(name).orElseThrow(() -> new RuntimeException("Client Not Found."));
        this.clientRepository.deleteById(clientModel.getId());
        return "Client delete with success.";
    }
}
