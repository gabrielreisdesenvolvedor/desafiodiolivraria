/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.service;

import com.biblioteca.livraria.dtos.BookDto;
import com.biblioteca.livraria.models.CategoryModel;
import com.biblioteca.livraria.models.BookModel;
import com.biblioteca.livraria.repositories.CategoryRepository;
import com.biblioteca.livraria.repositories.BookRepository;
import java.util.Scanner;
import java.util.UUID;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;

    @Transactional
    public BookDto save(BookDto bookDto){
       BookModel book = new BookModel(bookDto);
       var bookModel = this.bookRepository.save(book);
       return new BookDto(bookModel);
    }

    @Transactional
    public Page<BookDto> findAll(int page, int size, String sort){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).ascending());
        Page<BookModel> books = this.bookRepository.findAll(pageable);
        return books.map(BookDto::new);
    }

    @Transactional
    public BookDto findById(UUID id){
       BookModel bookModel = this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found."));
       return new BookDto(bookModel);
    }

    @Transactional
    public String updateBook(UUID id, BookDto bookDto){
       BookModel bookModel = this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found."));
       bookModel.setName(bookDto.getName());
       bookModel.setAuthor(bookDto.getAuthor());
       bookModel.setDescription(bookDto.getDescription());
       bookModel.setCategory(bookDto.getCategory());
       bookModel.setClient(bookDto.getClient());

       this.bookRepository.save(bookModel);

       return "Book update with success";
    }

    @Transactional
    public String deleteCategory(UUID id){
        BookModel bookModel = this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found."));
        this.bookRepository.deleteById(bookModel.getId());
        return "Book delete with success.";
    }

    @Transactional
    public String deleteCategory(String name){
        BookModel bookModel = this.bookRepository.findByName(name).orElseThrow(() -> new RuntimeException("Category Not Found."));
        this.bookRepository.deleteById(bookModel.getId());
        return "Book delete with success.";
    }
}
