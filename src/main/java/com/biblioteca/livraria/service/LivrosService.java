/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.service;

import com.biblioteca.livraria.models.CategoriasModel;
import com.biblioteca.livraria.models.LivrosModel;
import com.biblioteca.livraria.repositories.CategoriasRepository;
import com.biblioteca.livraria.repositories.LivrosRepository;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class LivrosService {
    
    @Autowired
    LivrosRepository livrosRepository;
    
    @Autowired
    CategoriasRepository categoriasRepository;
    
    Scanner scanner = new Scanner(System.in);
    
    public boolean adicionarLivro(){
        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();
        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scanner.nextLine();
        System.out.print("Digite a descriçao: ");
        String descricao = scanner.nextLine();
        System.out.println("Categorias: ");
        System.out.println("1-Terror");
        System.out.println("2-Comédia");
        System.out.println("3-Ação");
        System.out.print("Qual nome da categoria a ser adicionada: ");
        int escolhaCategoria = scanner.nextInt();
        scanner.nextLine();
        
        CategoriasModel categoria = null;
        
        switch(escolhaCategoria){
            case 1: 
                categoria = this.categoriasRepository.findByNome("Terror");
                break;
            case 2: 
                categoria = this.categoriasRepository.findByNome("Comedia");
                break;
           case 3:
                categoria = this.categoriasRepository.findByNome("Acao");
                break;
           default:
               System.out.println("Digite o nome da categoria nova: ");
               String nomeCategoriaNova = scanner.nextLine();
               categoria = new CategoriasModel(nomeCategoriaNova);
               this.categoriasRepository.save(categoria);
               break;
    }
        
        LivrosModel livro = new LivrosModel(nomeLivro, nomeAutor, descricao, categoria);
        this.livrosRepository.save(livro);
        
        return true;
}
    
    
}
