package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class UpdateService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

//		
//		String title = request.getParameter("bTitle");
//		String content = request.getParameter("bContent");
//		int bId = Integer.parseInt(request.getParameter("bId"));

		BoardDAO.getInstance().updateBoard(
					request.getParameter("bTitle"),
					request.getParameter("bContent"), 
					Integer.parseInt(request.getParameter("bId"))
				);
	}

}
