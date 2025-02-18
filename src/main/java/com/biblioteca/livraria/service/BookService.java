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

}
