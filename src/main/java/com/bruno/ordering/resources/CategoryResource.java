package com.bruno.ordering.resources;

import com.bruno.ordering.dto.CategoryDTO;
import com.bruno.ordering.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryResource {

    private final CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@Valid @PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }
}
