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
@Table(name = "tb_categorias")
public class CategoriasModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    @OneToMany(mappedBy = "categoria")
    private List<LivrosModel> livros;
    
    public CategoriasModel(){}

    public CategoriasModel(String nome) {
        this.nome = nome;
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

    public List<LivrosModel> getLivros() {
        return livros;
    }

    public void setLivros(List<LivrosModel> livros) {
        this.livros = livros;
    }
    
    
}
