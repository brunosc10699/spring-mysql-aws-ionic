package com.bruno.ordering.services;

import com.bruno.ordering.dto.CategoryDTO;
import com.bruno.ordering.entities.Category;
import com.bruno.ordering.repositories.CategoryRepository;
import com.bruno.ordering.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryDTO findById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new CategoryDTO(category);
    }
}
