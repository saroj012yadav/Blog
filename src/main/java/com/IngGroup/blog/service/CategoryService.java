package com.IngGroup.blog.service;

import com.IngGroup.blog.domain.entity.Category;
import com.IngGroup.blog.domain.entity.dto.CategoryDto;
import com.IngGroup.blog.domain.entity.dto.CreateCategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDto> getAllCategory();
    public CategoryDto saveCategory(CreateCategoryDto createCategoryDto);
}
