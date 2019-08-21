package com.vishwas.springbootdatarest.repository;

import com.vishwas.springbootdatarest.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource (path = "topics")
/* This is magic! we can have crud operation without having controller
    We just need to give url path here and then we can use all standard Hateos methods here.

    HATEOAS is a concept of application architecture. It defines the way in which application clients interact with the server,
     by navigating hypermedia links they find inside resource models returned by the server.

    To implement HATEOAS you need some standard way of representing resources,
    that will contain hypermedia information (links to related resources), for example, something like this:
 */

public interface TopicRepo extends JpaRepository <Topic,String>{
   /* springboot will generate class internally who implement inter */

}
