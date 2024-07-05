package com.bettercloud.alexis.code_interview.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/draw")
public class DrawController {
	
	
	@Autowired
	private DrawService drawService;
	
	
    @GetMapping("/{clientId}")
    public String getDrawSelections(@PathVariable int clientId) {
    	drawService.executeDraw(clientId);
    	
    	
    	return "";
        
    }

}
