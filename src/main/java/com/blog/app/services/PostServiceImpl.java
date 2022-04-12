package com.blog.app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.app.entites.Post;
import com.blog.app.repositories.PostRepository;
import com.blog.app.servicesInerfaces.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	@SuppressWarnings("unused")
	@Autowired
	private static List<Post> postList = new ArrayList<Post>();
	
    @Override
    public Post save(Post post) {
    	System.out.print(post);
        return postRepository.save(post);
    }
    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
   
    @Override
    public Post findById(Long id) {
    	return postRepository.findById(id).orElse(null);	
    }

    @Override
    public void deleteById(Long id) {
    	
    	postRepository.deleteById(id);
    }
}