package com.vishwas.springbootexample.repository;

import com.vishwas.springbootexample.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository <Post , Integer> {

}
