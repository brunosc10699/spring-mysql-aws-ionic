package com.bruno.ordering.services;

import com.bruno.ordering.dto.CategoryDTO;
import com.bruno.ordering.entities.Category;
import com.bruno.ordering.repositories.CategoryRepository;
import com.bruno.ordering.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    private Long validId = 1L;
    private Long invalidId = 2L;
    private Category category = new Category(1L, "Home Appliances");
    private CategoryDTO categoryDTO = new CategoryDTO(category);

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    @DisplayName("Must return a category searched by id")
    void whenFindByIdIsCalledWithAValidIdThenReturnTheCategory(){
        when(categoryRepository.findById(validId)).thenReturn(Optional.of(category));
        categoryDTO = categoryService.findById(validId);
        assertThat(categoryDTO.getId(), is(equalTo(category.getId())));
        assertThat(categoryDTO.getName(), is(equalTo(category.getName())));
    }

    @Test
    @DisplayName("Must throw an exception when a category is not found by id")
    void whenFindByIdIsCalledWithAnInvalidIdThenThrowAnException(){
        when(categoryRepository.findById(invalidId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> categoryService.findById(invalidId));
    }
}
