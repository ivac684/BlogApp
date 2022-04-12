package com.blog.app.repositories;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blog.app.entites.Post;
import com.blog.app.entites.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	Optional<Post> findById(Long id);
	public User findByAuthor(User author);
	
}
