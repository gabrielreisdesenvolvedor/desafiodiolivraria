/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.controllers;

import com.biblioteca.livraria.dtos.CategoryDto;
import com.biblioteca.livraria.service.CategoryService;
import com.biblioteca.livraria.models.CategoryModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    CategoryService service;

    @GetMapping
    public ResponseEntity<Page<CategoryDto>> findAll(
          @RequestParam(defaultValue = "0") @Min(0) int page,
          @RequestParam(defaultValue = "1") @Min(1) int size,
          @RequestParam(defaultValue = "name") String sort){

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        Page<CategoryDto> categoryDto = this.service.findAll(page, size, sort);

        return ResponseEntity.ok(categoryDto);
    }
    
    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@RequestBody @Valid CategoryDto category){
        CategoryDto categoryDto = this.service.addCategory(category);
        URI locale = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoryDto.getId()).toUri();
        return ResponseEntity.created(locale).body(categoryDto);
    }
}
