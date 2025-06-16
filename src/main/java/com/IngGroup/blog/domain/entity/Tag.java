package com.IngGroup.blog.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="tag")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="name",nullable = false,unique = true)
    private String name;
    @ManyToMany(mappedBy = "tag")
    private List<Post> post;
}
