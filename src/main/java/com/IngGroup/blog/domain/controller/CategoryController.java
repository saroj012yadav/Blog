package com.IngGroup.blog.domain.controller;

import com.IngGroup.blog.configuration.route.AppRoute;
import com.IngGroup.blog.domain.entity.Category;
import com.IngGroup.blog.domain.entity.dto.CategoryDto;
import com.IngGroup.blog.domain.entity.dto.CreateCategoryDto;
import com.IngGroup.blog.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppRoute.CategoryRoute)
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(AppRoute.LIST_ALL)
    public ResponseEntity<List<CategoryDto>> getAll()
    {
       return ResponseEntity.ok( categoryService.getAllCategory());
    }

    @PostMapping(AppRoute.CREATE)
    public ResponseEntity<CategoryDto> create(@RequestBody CreateCategoryDto createCategoryDto)
    {

       return ResponseEntity.ok(categoryService.saveCategory(createCategoryDto));
    }
}
