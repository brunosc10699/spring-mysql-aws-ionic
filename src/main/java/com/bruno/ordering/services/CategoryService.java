package com.bruno.ordering.services;

import com.bruno.ordering.dto.CategoryDTO;
import com.bruno.ordering.entities.Category;
import com.bruno.ordering.repositories.CategoryRepository;
import com.bruno.ordering.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO findById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new CategoryDTO(category);
    }
}
