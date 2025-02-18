package com.biblioteca.livraria.dtos;

import com.biblioteca.livraria.models.BookModel;
import com.biblioteca.livraria.models.CategoryModel;
import com.biblioteca.livraria.models.ClientModel;

import java.util.UUID;

public class BookDto {

    private UUID id;

    private String name;

    private String author;

    private String description;

    private CategoryModel category;

    private ClientModel client;

    public BookDto() {}

    public BookDto(String name, String author, String description){
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public BookDto(BookModel bookModel){
        this.id = bookModel.getId();
        this.name = bookModel.getName();
        this.author = bookModel.getAuthor();
        this.description = bookModel.getDescription();
        this.category = bookModel.getCategory();
        this.client = bookModel.getClient();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
}
