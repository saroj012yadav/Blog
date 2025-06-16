package com.IngGroup.blog.domain;

import lombok.Getter;

@Getter
public enum PostStatus {

    DRAFT("draft"),PUBLISHED("published");
    private final String message;
    private PostStatus(String message)
    {
        this.message=message;
    }
}
