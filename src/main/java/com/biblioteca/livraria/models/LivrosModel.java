/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;

/**
 *
 * @author gabriel
 */
@Entity
@Table(name = "tb_livros")
public class LivrosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String autor;
    private String descricao;
    @ManyToOne
    private CategoriasModel categoria;
    @ManyToOne
    private ClienteModel cliente;
    
    public LivrosModel(){}

    public LivrosModel(String nome, String autor, String descricao, CategoriasModel categoria) {
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.categoria = categoria;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriasModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasModel categoria) {
        this.categoria = categoria;
    }
    
    
}
