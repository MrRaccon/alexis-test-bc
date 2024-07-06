package com.bettercloud.alexis.code_interview.serviceimpl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.bettercloud.alexis.code_interview.dto.DrawDto;
import com.bettercloud.alexis.code_interview.model.serviceimpl.DrawServiceImpl;

@SpringBootTest
@ActiveProfiles("test")

class DrawServiceImplTest {

	@Autowired
	DrawServiceImpl drawService;
	
	/**
	 * Test with all members get a draw 
	 */
	@Test
	void test7membersOk() {
		List<DrawDto> response =	drawService.executeDraw(1);
		Assertions.assertEquals(7,response.size());
	}
	
	/**
	 * Test when it is not possible get a draw because some of them could not get
	 * a secret santa
	 */
	@Test
	void test0membersOk() {
		List<DrawDto> response =	drawService.executeDraw(2);
		Assertions.assertEquals(0,response.size());
	}
	@Test
	void test0members2Ok() {
		List<DrawDto> response =	drawService.executeDraw(3);
		Assertions.assertEquals(0,response.size());
	}
}
