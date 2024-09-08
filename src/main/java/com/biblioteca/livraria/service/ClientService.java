/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.service;

import com.biblioteca.livraria.dtos.ClientDto;
import com.biblioteca.livraria.models.ClientModel;
import com.biblioteca.livraria.repositories.ClientRepository;
import java.util.Scanner;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class ClientService {
    
    @Autowired
    ClientRepository clientRepository;
    
    Scanner scanner = new Scanner(System.in);
    
    
    public ClientDto addClient(ClientDto clientDto){

        ClientModel model = new ClientModel(clientDto);
        var modelCreate = this.clientRepository.save(model);
        
        return new ClientDto(modelCreate);
    }
    
    public Page<ClientDto> findAll(Pageable pageable){
        Page<ClientModel> clientModel = this.clientRepository.findAll(pageable);
        return clientModel.map(ClientDto::new);
    }
}
