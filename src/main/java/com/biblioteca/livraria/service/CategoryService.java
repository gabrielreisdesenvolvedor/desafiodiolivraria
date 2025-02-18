package com.biblioteca.livraria.service;

import com.biblioteca.livraria.dtos.CategoryDto;
import com.biblioteca.livraria.models.CategoryModel;
import com.biblioteca.livraria.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

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

    @Transactional
    public CategoryDto findById(UUID id){
        CategoryModel categoryModel = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found."));
        return new CategoryDto(categoryModel);
    }

    @Transactional
    public String updateCategory(UUID id, CategoryDto categoryDto){
        CategoryModel categoryModel = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found."));
        categoryModel.setName(categoryDto.getName());
        this.categoryRepository.save(categoryModel);
        return "Category update with success.";
    }

    @Transactional
    public String deleteCategory(UUID id){
        CategoryModel categoryModel = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found."));
         this.categoryRepository.deleteById(categoryModel.getId());
        return "Category delete with success.";
    }

    @Transactional
    public String deleteCategory(String name){
        CategoryModel categoryModel = this.categoryRepository.findByName(name).orElseThrow(() -> new RuntimeException("Category Not Found."));
        this.categoryRepository.deleteById(categoryModel.getId());
        return "Category delete with success.";
    }
}
