package com.codeup.neptunespringblog.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findById(long id);

    Post deleteById(long id);
}
