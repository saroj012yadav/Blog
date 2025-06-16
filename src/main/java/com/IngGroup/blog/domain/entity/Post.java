package com.IngGroup.blog.domain.entity;

import com.IngGroup.blog.domain.PostStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="title" ,nullable = false)
    private String title;
    @Column(name="content",nullable = false,columnDefinition = "text")
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id",referencedColumnName = "id",nullable = false)
    private User author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id",referencedColumnName = "id",nullable = false)
    private Category category;
    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    private Set<Tag> tag;
    @Enumerated(EnumType.STRING)
    private Enum<PostStatus> status;

    @Column(name="read_time",nullable = false)
    private Integer readTime;
    @Column(name="created_At",nullable = false)
    private LocalDateTime createdAt;
    @Column(name="update_At",nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(createdAt, post.createdAt) && Objects.equals(updatedAt, post.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createdAt, updatedAt);
    }
    @PrePersist
    protected void onCreate()
    {
        LocalDateTime now=LocalDateTime.now();
        this.createdAt=now;
        this.updatedAt=now;
    }
    @PreUpdate
    protected void onUpdate()
    {
        this.updatedAt=LocalDateTime.now();
    }
}
