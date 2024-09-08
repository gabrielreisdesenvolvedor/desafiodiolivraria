package com.biblioteca.livraria.dtos;

import com.biblioteca.livraria.models.CategoryModel;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class CategoryDto {

    private UUID id;

    @NotBlank
    private String name;

    public CategoryDto(){};

    public CategoryDto(CategoryModel categoryModel){
        id = categoryModel.getId();
        name = categoryModel.getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }
}
