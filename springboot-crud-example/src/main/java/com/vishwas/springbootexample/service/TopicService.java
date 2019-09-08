package com.vishwas.springbootexample.service;

import java.util.*;

import com.vishwas.springbootexample.exception.TopicNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishwas.springbootexample.repository.TopicRepository;
import com.vishwas.springbootexample.model.Topic;

@Service
public class TopicService {
	/*private List<Topic> topicList = Arrays.asList(new Topic ("1","Java","Java learning"),new Topic("2","Spring Boot","Spring Boot learning"));
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public List<Topic> getTopics(){
		
		return this.topicList;
		
		
	}*/
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getTopicList() {
		List <Topic> list= new ArrayList <Topic>();
		topicRepository.findAll().forEach(list::add);
		return list;
	}

	public String addTopic(Topic topic) {
		topicRepository.save(topic);
		return "Topic added";
	}

	public String deleteTopic(String id) {

		Optional <Topic> topic = topicRepository.findById(id);
		//TODO:try to use ifPresent
		/*
		topic.ifPresent( topicObj -> {
			topicRepository.delete(topicObj);
		});*/

		if(topic.isPresent()){
			topicRepository.delete(topic.get());
			return "Deleted";
		}
		else{
			throw new RuntimeException();
		}
	}

	public String updateTopic(Topic topicInfo, String id) {

		Optional <Topic> topicOptional = topicRepository.findById(id);
		if (topicOptional.isPresent()){
			Topic topic = topicOptional.get();
			topic.setDesc("Vishwas is doing something "+ (topicInfo.getDesc()!=null ? topicInfo.getDesc() :""));
			topic.setName("I am updated here ::  "+ (topicInfo.getName()!=null ? topicInfo.getName().toUpperCase() : ""));
			topicRepository.save(topic);
			return "Topic saved";
		}
		else{
			throw new TopicNotFoundException();
		}

	}


	public Topic getTopicById(String id) {
		Optional <Topic> topicOptional = topicRepository.findById(id);
		if(topicOptional.isPresent()){
			return topicOptional.get();
		}
		else{
			throw new TopicNotFoundException();
		}
	}
}
