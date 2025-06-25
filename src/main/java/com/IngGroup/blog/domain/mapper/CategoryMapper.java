package com.IngGroup.blog.domain.mapper;

import com.IngGroup.blog.domain.entity.Category;
import com.IngGroup.blog.domain.entity.dto.CategoryDto;
import com.IngGroup.blog.domain.entity.dto.CreateCategoryDto;
import com.IngGroup.blog.domain.entity.dto.UpdateCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(
            target = "postCount",
            expression = "java(category.getPost() == null ? Long.valueOf(0): Long.valueOf(category.getPost().size()))"
    )
    CategoryDto categoryToDto(Category category);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "post",ignore = true)
    Category createCategoryDtoToCategory(CreateCategoryDto createCategoryDto);
    @Mapping(target = "post",ignore = true)
    Category updateCategoryDtoToCategory(UpdateCategoryDto updateCategoryDto);

    List<CategoryDto> categoryListToDtoList(List<Category> list);
}
