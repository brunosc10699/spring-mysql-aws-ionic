package com.bruno.ordering.dto;

import com.bruno.ordering.entities.Category;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Long id;

    @Size(min = 3, max = 20, message = "Category must have a name!")
    private String name;

    public CategoryDTO(Category category){
        id = category.getId();
        name = category.getName();
    }
}
