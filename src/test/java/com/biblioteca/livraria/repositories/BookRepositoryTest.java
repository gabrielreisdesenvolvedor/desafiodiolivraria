package com.biblioteca.livraria.repositories;

import com.biblioteca.livraria.models.BookModel;
import com.biblioteca.livraria.models.CategoryModel;
import com.biblioteca.livraria.models.ClientModel;
import com.biblioteca.livraria.service.BookService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    CategoryModel categoryTest = new CategoryModel();

    BookModel bookTest = new BookModel("Gabriel", "Reis", "Testando", categoryTest);

    @BeforeEach
    void setUp() {
       CategoryModel category = categoryRepository.save(categoryTest);
       BookModel ebook = bookRepository.save(bookTest);
    }

    @Test
    void findByName() {
       var name = this.bookRepository.findByName("Gabriel");
       assertEquals("Gabriel", name.getName());
    }
}