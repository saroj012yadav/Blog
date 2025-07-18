package com.IngGroup.blog.domain.repository;

import com.IngGroup.blog.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
}
