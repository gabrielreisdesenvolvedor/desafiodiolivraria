package com.biblioteca.livraria;

import com.biblioteca.livraria.service.CategoryService;
import com.biblioteca.livraria.service.ClientService;
import com.biblioteca.livraria.service.BookService;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication{

        @Autowired
        CategoryService categoryService;
    
        @Autowired
        BookService bookService;
        
        @Autowired
        ClientService clientService;
    
	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
      
       
	}
}
