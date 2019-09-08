package com.vishwas.springbootexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import com.vishwas.springbootexample.service.TopicService;
import com.vishwas.springbootexample.model.Topic;

import javax.validation.Valid;

@RestController
public class TopicsController {
	
	@Autowired
	private TopicService topicService ; 
	
	@RequestMapping ("/getTopics")
	public List<Topic> getTopics()
	{
		return topicService.getTopicList();
	}

	@GetMapping("/topics/{id}")
	public Resource <Topic> getTopicById(@PathVariable String id){
		Topic topic = topicService.getTopicById(id);
		Resource resource = new Resource<Topic>(topic);
		ControllerLinkBuilder linkTo =ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getTopics());
		resource.add(linkTo.withRel("all-topics"));
		return  resource;
	}
	
	@RequestMapping (method=RequestMethod.POST,value="/addTopic")
	public String addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
		
	}
	
	@RequestMapping (method=RequestMethod.PUT,value="/updateTopic/{id}")
	public String updateTopic(@Valid @RequestBody Topic topic , @PathVariable String id) {
		return topicService.updateTopic(topic, id);
		
	}

	@RequestMapping (method=RequestMethod.DELETE, value="/deleteTopic/{id}")
	public String deleteTopic(@PathVariable String id){
		return topicService.deleteTopic(id);
	}
	

}
