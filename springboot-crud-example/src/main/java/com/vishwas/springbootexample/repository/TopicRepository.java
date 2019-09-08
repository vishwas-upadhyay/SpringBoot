package com.vishwas.springbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import com.vishwas.springbootexample.model.Topic;

public interface TopicRepository extends CrudRepository<Topic,String>  {

	
}
