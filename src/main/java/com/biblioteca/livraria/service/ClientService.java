/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.service;

import com.biblioteca.livraria.dtos.ClientDto;
import com.biblioteca.livraria.models.ClientModel;
import com.biblioteca.livraria.repositories.ClientRepository;
import java.util.Scanner;

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
    public ClientDto addClient(ClientDto clientDto){

        ClientModel model = new ClientModel(clientDto);
        var modelCreate = this.clientRepository.save(model);

        emailService.sendSimpleEmail(
        clientDto.getEmail(),
        "Bem vindo a nossa livraria",
        "Você agora faz parte da nossa livraria."
        );

        return new ClientDto(modelCreate);
    }
    
    public Page<ClientDto> findAll(int page, int size, String sort ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).ascending());
        Page<ClientModel> clientModel = this.clientRepository.findAll(pageable);
        return clientModel.map(ClientDto::new);
    }
}
