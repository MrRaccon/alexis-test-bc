package com.bettercloud.alexis.code_interview.model.service;

import java.util.List;

import com.bettercloud.alexis.code_interview.dto.DrawDto;

public interface DrawService {
	
	/**
	 * Method executedDraw which does a draw.
	 * @param clientId
	 */
	List<DrawDto> executeDraw(int clientId);

}
