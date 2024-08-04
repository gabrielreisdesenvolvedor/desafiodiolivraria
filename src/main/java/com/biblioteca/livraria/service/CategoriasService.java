/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.service;

import com.biblioteca.livraria.models.CategoriasModel;
import com.biblioteca.livraria.repositories.CategoriasRepository;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class CategoriasService {
    Scanner scanner = new Scanner(System.in);
    
    
    @Autowired
    CategoriasRepository categoriasRepository;
    
    public CategoriasModel adicionarCategoria(){
        System.out.println("Digite o nome da categoria: ");
        String nomeCategoria = scanner.nextLine();
        CategoriasModel categoriasModel = new CategoriasModel();
        categoriasModel.setNome(nomeCategoria);
        return this.categoriasRepository.save(categoriasModel);
    }
}
