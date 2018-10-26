package com.wingify.news.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.wingify.news.input.Input;
import com.wingify.news.input.PostObject;
import com.wingify.news.output.Output;
import com.wingify.news.services.UserService;

//Controller to give response to the user based on what he/she have asked.
@RestController
public class UserController {
	
	
	@Autowired
	private UserService userservice;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.POST, value="/news")
	public Output postNews(@RequestBody PostObject postobject) throws Exception {
		
		Input input = userservice.getInputObject(postobject);
		
		Output output = userservice.getOutput(input,postobject);
		
		return output;
		
		
	}
	
	
	

}
