package com.vishwas.springbootexample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
public class Post {


    @Id
    @GeneratedValue
    private Integer id;
    private String  description;

    @ManyToOne (fetch = FetchType.LAZY)
    //Static filtering of model field
    // If we are not putting jsonignore here then we recursive loop will happen topic call post -- post call topic like wise
    @JsonIgnore
    private Topic topic;

    public Post() {
    }

    public Post(Integer id, String description, Topic topic) {
        this.id = id;
        this.description = description;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
