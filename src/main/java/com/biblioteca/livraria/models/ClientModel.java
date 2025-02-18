/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.models;

import com.biblioteca.livraria.dtos.ClientDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author gabriel
 */
@Entity
@Table(name = "tb_clientes")
public class ClientModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String email;

    private String address;

    private Double accountBalance;

    @OneToMany(mappedBy = "client")
    private List<BookModel> books;
    
    public ClientModel(){}

    public ClientModel(ClientDto clientDto){
        name = clientDto.getName();
        email = clientDto.getEmail();
        address = clientDto.getAddress();
        accountBalance = clientDto.getAccountBalance();
    }

    public ClientModel(String name, String email, String address, Double accountBalance) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.accountBalance = accountBalance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
    
    
}
