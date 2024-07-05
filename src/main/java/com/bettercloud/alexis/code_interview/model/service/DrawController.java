package com.bettercloud.alexis.code_interview.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bettercloud.alexis.code_interview.dto.DrawDto;

@RestController
@RequestMapping("/draw")
public class DrawController {
	
	
	@Autowired
	private DrawService drawService;
	
	
    @GetMapping("/{clientId}")
    public List<DrawDto> getDrawSelections(@PathVariable int clientId) {
    	return drawService.executeDraw(clientId);
    	
         
    }

}
