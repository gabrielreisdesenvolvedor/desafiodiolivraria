/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.models;

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
public class ClienteModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String email;
    private String endereco;
    private Double saldoNaLivraria;
    @OneToMany(mappedBy = "cliente")
    private List<LivrosModel> livros;
    
    public ClienteModel(){}

    public ClienteModel(String nome, String email, String endereco, Double saldoNaLivraria) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.saldoNaLivraria = saldoNaLivraria;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getSaldoNaLivraria() {
        return saldoNaLivraria;
    }

    public void setSaldoNaLivraria(Double saldoNaLivraria) {
        this.saldoNaLivraria = saldoNaLivraria;
    }

    public List<LivrosModel> getLivros() {
        return livros;
    }

    public void setLivros(List<LivrosModel> livros) {
        this.livros = livros;
    }
    
    
}
