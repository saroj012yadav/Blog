package com.IngGroup.blog.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="users")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
   private  UUID id;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="password",nullable = false)
    private String password;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Post> post;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, password, createdAt);
    }

    @PrePersist
    protected void onCreate()
    {
        this.createdAt=LocalDateTime.now();

    }
}
