package com.blog.app.servicesInerfaces;

import java.util.List;
import com.blog.app.entites.Post;

public interface PostService {
    List<Post> findAll();
    Post findById(Long id);
    void deleteById(Long id);
    public Post save(Post post);
}