package com.myweb.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class ChangePwService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		/*
	    1. 폼 데이터 처리 (기존 비번, 변경 비번)
	    2. dao주소값을 받아오시고, userCheck()를 활용하여
	     기존 비번과 아이디 정보를 바탕으로 해당 비밀번호가 일치하는지를 검사.
	     (id는 세션에서 구해옵니다.)
	    
	    3. 기존 비밀번호가 일치한다면 비밀번호 변경 메서드 changePassword() 호출.
	    4. "비밀번호가 정상적으로 변경되었습니다." 경고창 출력 후 mypage 이동.
	    5. 현재 비밀번호가 불일치 -> "현재 비밀번호가 다릅니다." 경고창 출력 후 뒤로가기.
	    */
		
		response.setContentType("text/html; charset=UTF-8");
		String old_pw = request.getParameter("old_pw");
		String new_pw = request.getParameter("new_pw");
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		//getAttribute의 return 타입이 object라서 UserVO로 형변환
		String id = vo.getUserId();
		
//		String id = ((UserVO)request.getSession()
//									.getAttribute("user"))
//									.getUserId();		
		
		String htmlCode;
		UserDAO dao = UserDAO.getInstance();
		//getInstance 주소값 받아오기
		int result = dao.userCheck(id, old_pw);
		PrintWriter out = null;
//		PrintWriter out = response.getWriter(); 한번에
		try {
			out = response.getWriter();
			if(result == 1) {
				System.out.println("#################################");
				
				dao.changePassword(id, new_pw);
				htmlCode = "<script>\r\n"
						+ "alert('비밀번호 변경 완료');\r\n"
						+ "location.href='/MyWeb/myPage.user';\r\n"
						+ "</script>";
				out.print(htmlCode);
				out.flush();
				
			} else {
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				htmlCode = "<script>\r\n"
                        + "alert('비밀번호 불일치');\r\n"
                        + "history.back();\r\n"
                        //뒤로 가기
                        + "</script>";
				out.print(htmlCode);
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			out.close();
			
		}
	}

}
