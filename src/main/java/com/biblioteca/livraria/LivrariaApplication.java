package com.biblioteca.livraria;

import com.biblioteca.livraria.service.CategoriasService;
import com.biblioteca.livraria.service.CategoriasService;
import com.biblioteca.livraria.service.ClienteService;
import com.biblioteca.livraria.service.LivrosService;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner{

        @Autowired  
        CategoriasService categoriasService;
    
        @Autowired
        LivrosService livrosService;    
        
        @Autowired
        ClienteService clienteService;
    
	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
      
       
	}

    @Override
    public void run(String... args) throws Exception {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      System.out.println("Hello World!");
      
      Scanner scanner = new Scanner(System.in);
      
      while(true){
      System.out.println("Seja bem vindo a Livraria Cultura");
      System.out.println("1-Adicionar Categoria");
      System.out.println("2-Adicionar Livro");
      System.out.println("3-Adicionar Cliente");
      System.out.print("Qual sua escolha: ");
      int escolha = scanner.nextInt();
      
      switch(escolha){
          case 1: this.categoriasService.adicionarCategoria();
          break;
          case 2: this.livrosService.adicionarLivro();
          break;
          case 3: this.clienteService.adicionarCliente();
          default:
              System.out.println("Opção não encontrada!");
      }
      }
    }

}
