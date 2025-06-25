package com.IngGroup.blog.domain.entity.dto;

import lombok.Builder;
import lombok.Data;


@Builder
public record CreateCategoryDto(String name) {
}
