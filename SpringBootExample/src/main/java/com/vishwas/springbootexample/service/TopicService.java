package com.vishwas.springbootexample.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishwas.springbootexample.repository.TopicRepository;
import com.vishwas.springbootexample.model.Topic;
import java.util.Optional;

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
		return "Given Topic not found. Please provide valid topic id";
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
		return "Given topic id is not found";
	}

	

}
