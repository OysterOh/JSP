package com.myweb.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.commons.PageCreator;
import com.myweb.board.commons.PageVO;
import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		PageVO paging = new PageVO();
		BoardDAO dao = BoardDAO.getInstance();
		
		//사용자가 처음 게시판 들어올 때 페이지 선택 하지 않는다
		//생성자가 기본값을 지정한다.(1페이지)
		//페이지 정보가 파라미터 값으로 넘어올 경우에만 getParameter
		if(request.getParameter("page") != null) {
			paging.setPage(Integer.parseInt(request.getParameter("page")));
			paging.setCpp(Integer.parseInt(request.getParameter("cpp")));
		}
		System.out.println(paging);
		
		List<BoardVO> boardList = dao.listBoard(paging);
		
		//페이지 버튼 배치를 위해 객체를 생성
		PageCreator pc = new PageCreator();
		
		//페이징 버튼 알고리즘을 위해 PageVO 객체와 총 게시물 수를 setter로 전달
		pc.setPaging(paging);
		pc.setArticleTotalCount(dao.countArticles());
		
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
		
		//jsp 파일에서 버튼 배치를 위해, 모든 정보가 완성된 PageCreator 객체를
		//request 객체에 담아서 forwarding 하겠다
		request.setAttribute("pc", pc);
		
		
	}

}
