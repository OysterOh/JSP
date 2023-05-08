package com.myweb.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList = dao.listBoard();
		/*왜 session을 사용하지 않고 request를 사용하는가?
		  데이터 베이스로부터 받아온 글 목록은 일시적인 데이터이다.
		  글 목록은 언제든 변할 수 있다. 
		  그런 데이터를 굳이 session에 담아서 유지할 필요는 없다.
		  응답이 나가고 나서 자동으로 소멸할 수 있도록 request에 담아서
		  화면으로 전달한다.
		  request < session < application
		    요청	  <	브라우저	<	서버
		  */
		request.setAttribute("boardList", boardList);
	}

}