package com.bruno.ordering.resources;

import com.bruno.ordering.dto.CategoryDTO;
import com.bruno.ordering.entities.Category;
import com.bruno.ordering.services.CategoryService;
import com.bruno.ordering.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CategoryResourceTest {

    private static final String URL = "/api/v1/categories";

    private Category category = new Category(1L, "Home Appliances");
    private CategoryDTO categoryDTO = new CategoryDTO(category);
    private Long validId = 1L;
    private Long invalidId = 2L;

    private MockMvc mockMvc;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryResource categoryResource;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(categoryResource)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    @DisplayName("Must return status code 200 Ok when calling findById method")
    void whenGetIsCalledToFindACategoryByIdThenReturnOkStatus() throws Exception {
        when(categoryService.findById(validId)).thenReturn(categoryDTO);
        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/" + validId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(categoryDTO.getId().intValue())))
                .andExpect(jsonPath("$.name", is(categoryDTO.getName())));
    }

    @Test
    @DisplayName("Must return status code 404 Not Found when id is invalid")
    void whenGetIsCalledToFindACategoryWithAnInvalidIdThenReturnNotFoundStatus() throws Exception {
        when(categoryService.findById(invalidId)).thenThrow(ResourceNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/" + invalidId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
