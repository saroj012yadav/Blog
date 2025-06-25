package com.IngGroup.blog.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Builder
public record CategoryDto(
        UUID id,String name,Long postCount){

}

