package com.uniloftsky.springframework.springmvcrest.api.v1.mapper;

import com.uniloftsky.springframework.springmvcrest.api.v1.model.CategoryDTO;
import com.uniloftsky.springframework.springmvcrest.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

}
