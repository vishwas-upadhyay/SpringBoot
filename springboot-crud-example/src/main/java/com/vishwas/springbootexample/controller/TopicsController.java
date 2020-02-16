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

	/* Http header Content-Type mapped to consumes
	*  Http header Accept mapped to produce if consumes property not configured else it will be mapped to Content-Type header
	* for versioning, we have multiple option like
	* 1. URL vesion e.g. V1/getTopic
	* 2. Custom header versioning e.g. add your header X-VERSION
	* 3. Request Param versioning e.g. send getTopic/version=v1
	* 4. Http header versionning e.g. use of produce or consume
	*
	* Http has no concept for versioning hence every company is using the way they want it each approach has some cons
	* Http Header versioning is not good for response caching also request can't hit by browser
	* Request Param and URI versioning contributes in URI pollution etc
	* Custom header makes vague understanding of API request call.
	* */

	@GetMapping (value = "/getTopics",  produces = "application/vishwas+json")
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
	
	@PostMapping ("/addTopic")
	public String addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
		
	}
	
	@PutMapping ("/updateTopic/{id}")
	public String updateTopic(@Valid @RequestBody Topic topic , @PathVariable String id) {
		return topicService.updateTopic(topic, id);
		
	}

	@DeleteMapping ("/deleteTopic/{id}")
	public String deleteTopic(@PathVariable String id){
		return topicService.deleteTopic(id);
	}
	

}
