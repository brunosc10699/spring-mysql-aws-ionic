package com.bruno.ordering.services;

import com.bruno.ordering.dto.CategoryDTO;
import com.bruno.ordering.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO findById(Long id){
        return new CategoryDTO(categoryRepository.getById(id));
    }
}
