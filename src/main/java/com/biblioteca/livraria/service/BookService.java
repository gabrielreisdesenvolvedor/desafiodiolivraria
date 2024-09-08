/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.service;

import com.biblioteca.livraria.models.CategoryModel;
import com.biblioteca.livraria.models.BookModel;
import com.biblioteca.livraria.repositories.CategoryRepository;
import com.biblioteca.livraria.repositories.BookRepository;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    CategoryRepository categoryRepository;
    
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
        
        CategoryModel categoria = null;
        
        switch(escolhaCategoria){
            case 1: 
                categoria = this.categoryRepository.findByName("Terror");
                break;
            case 2: 
                categoria = this.categoryRepository.findByName("Comedia");
                break;
           case 3:
                categoria = this.categoryRepository.findByName("Acao");
                break;
           default:
               System.out.println("Digite o nome da categoria nova: ");
               String nomeCategoriaNova = scanner.nextLine();
               categoria = new CategoryModel(nomeCategoriaNova);
               this.categoryRepository.save(categoria);
               break;
    }
        
        BookModel livro = new BookModel(nomeLivro, nomeAutor, descricao, categoria);
        this.bookRepository.save(livro);
        
        return true;
}
    
    
}
