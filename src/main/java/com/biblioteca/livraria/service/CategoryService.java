/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.livraria.service;

import com.biblioteca.livraria.dtos.CategoryDto;
import com.biblioteca.livraria.models.CategoryModel;
import com.biblioteca.livraria.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gabriel
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public CategoryDto addCategory(CategoryDto categoryDto){
        CategoryModel categoryModel = new CategoryModel(categoryDto);
        CategoryModel categorySave = this.categoryRepository.save(categoryModel);
        return new CategoryDto(categorySave);
    }

    @Transactional
    public Page<CategoryDto> findAll(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).ascending());
        Page<CategoryModel> categoryModel = this.categoryRepository.findAll(pageable);
        return categoryModel.map(CategoryDto::new);
    }
}
