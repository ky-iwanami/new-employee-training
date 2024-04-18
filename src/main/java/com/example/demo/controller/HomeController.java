package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.TestEntity;
import com.example.demo.model.User;
import com.example.demo.repository.TestRepository;

@Controller
public class HomeController {
	
	@Autowired
	TestRepository repository;

    @GetMapping("/form")
    private String readForm(@ModelAttribute User user) {
    	
    	TestEntity entity = repository.findOne();
    	if(entity != null) {
    		user.setBeforeName(entity.getItem1());
    		user.setBeforeEmail(entity.getItem2());
    		user.setBeforeAge(entity.getItem3());}
    	
        return "form";
    }
    
    @PostMapping("/form")
    private String confirm(@ModelAttribute User user) {
    	
    	TestEntity entity = new TestEntity();
    	entity.setItem1(user.getName());
    	entity.setItem2(user.getEmail());
    	entity.setItem3(user.getAge());
    	repository.save(entity);
    	
        return "confirm";
    }
}
