package com.biblioteca.livraria.controllers;

import com.biblioteca.livraria.dtos.BookDto;
import com.biblioteca.livraria.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> create (@RequestBody @Valid BookDto book) {
        BookDto bookDto = this.bookService.save(book);
        URI locate = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(bookDto.getId()).toUri();
        return ResponseEntity.created(locate).body(bookDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<BookDto>> findAll (@RequestParam(defaultValue = "0") @Min(0) int page,
                                                  @RequestParam(defaultValue = "10") @Min(1) int size,
                                                  @RequestParam(defaultValue = "name") String sort){
        Page<BookDto> books = this.bookService.findAll(page, size, sort);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findById (@PathVariable("id") UUID id){
       BookDto bookDto = this.bookService.findById(id);
       return ResponseEntity.ok(bookDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook (@PathVariable("id") UUID id, @RequestBody @Valid BookDto bookDto){
       String update = this.bookService.updateBook(id, bookDto);
       return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") UUID id){
        String delete = this.bookService.deleteCategory(id);
        return ResponseEntity.ok(delete);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteBook(@PathVariable("name") String name){
        String delete = this.bookService.deleteCategory(name);
        return ResponseEntity.ok(delete);
    }
}
