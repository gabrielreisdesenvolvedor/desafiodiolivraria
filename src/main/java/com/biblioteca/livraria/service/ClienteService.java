/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.service;

import com.biblioteca.livraria.models.ClienteModel;
import com.biblioteca.livraria.repositories.ClienteRepository;
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
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    Scanner scanner = new Scanner(System.in);
    
    
    public String adicionarCliente(){
          System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o email: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Digite o endereço: ");
        String enderecoCliente = scanner.nextLine();
        System.out.println("Digite o saldo inicial: ");
        Double saldoInicial = scanner.nextDouble();
        
        ClienteModel model = new ClienteModel(nomeCliente, emailCliente, enderecoCliente, saldoInicial);
        
        this.clienteRepository.save(model);
        
        return "Cliente adicionado com sucesso!";
    }
    
    public Page<ClienteModel> buscarTodos(int pagina, int quantidade){
        Pageable pageable = PageRequest.of(pagina, quantidade);
        return this.clienteRepository.findAll(pageable);
    }
}
