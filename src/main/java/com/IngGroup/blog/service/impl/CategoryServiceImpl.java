package com.IngGroup.blog.service.impl;

import com.IngGroup.blog.domain.entity.Category;
import com.IngGroup.blog.domain.entity.dto.CategoryDto;
import com.IngGroup.blog.domain.entity.dto.CreateCategoryDto;
import com.IngGroup.blog.domain.mapper.CategoryMapper;
import com.IngGroup.blog.domain.repository.CategoryRepository;
import com.IngGroup.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
       List<Category> list= this.categoryRepository.findAll();
       return categoryMapper.categoryListToDtoList(list);


    }

    @Override
    public CategoryDto saveCategory(CreateCategoryDto createCategoryDto) {

        Category category=categoryMapper.createCategoryDtoToCategory(createCategoryDto);

        Category saveCategory =Category.builder()
                .name(category.getName())

                .build();
        Category savedCategory=categoryRepository.save(saveCategory);
        return categoryMapper.categoryToDto(savedCategory);

    }
}
