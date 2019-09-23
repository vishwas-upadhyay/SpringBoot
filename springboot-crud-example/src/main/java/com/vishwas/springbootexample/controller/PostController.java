package com.vishwas.springbootexample.controller;


import com.vishwas.springbootexample.model.Post;
import com.vishwas.springbootexample.model.Topic;
import com.vishwas.springbootexample.repository.PostRepository;
import com.vishwas.springbootexample.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    TopicService topicService;

    @GetMapping ("getPosts")
    public List<Post> getPost(){
       List <Post> list = new ArrayList<Post>();
        postRepository.findAll().forEach(list::add);
        return  list;
    }

    @PostMapping("addPost/topic-id")
    public ResponseEntity addPost(@RequestParam String id ,@RequestBody Post post){
       Topic topic= topicService.getTopicById(id);
        post.setTopic(topic);
        postRepository.save(post);
        return ResponseEntity.ok().body("success");
    }

    @DeleteMapping("deletePost")
    public ResponseEntity<Post> deletePost (@RequestParam Integer id){
        postRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
