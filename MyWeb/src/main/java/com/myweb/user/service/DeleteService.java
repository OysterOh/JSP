package com.myweb.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class DeleteService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		/*
		 1. form에서 넘어오는 데이터(파라미터)들 가져오기
		 2. 데이터를 UserVO로 포장하기
		 3. dao의 updateUser()를 호출해서 회원정보 수정 진행하기
		 4. 수정된 정보로 세션 데이터를 교환(덮어 씌우기)
		 5. alert()을 이용해서 사용자에게 응답 주고 마이페이지로 이동
		 */
		response.setContentType("text/html; charset=UTF-8");
		String id = ((UserVO)request.getSession().getAttribute("user")).getUserId();
//		String id = ((UserVO)request.getSession()
//		.getAttribute("user"))
//		.getUserId();
		String pw = request.getParameter("check_pw");
		UserDAO dao = UserDAO.getInstance();
				
//		dao.deleteUser(id, pw);
		String htmlCode;
		PrintWriter out = null;
		System.out.println("1111111111111111111111111111111111111111111111");
		try {
			out = response.getWriter();
			if(dao.userCheck(id, pw) == 0) {
				htmlCode = "<script>\r\n"
	                    + "alert('비밀번호가 틀렸습니다.');\r\n"
	                    + "location.href='/MyWeb/myPage';\r\n"
	                    + "</script>";
					
			} else {
				dao.deleteUser(id);
				request.getSession().invalidate();
				htmlCode = "<script>\r\n"
						+ "alert('회원 정보 삭제 완료');\r\n"
						+ "location.href='/MyWeb';\r\n"
						+ "</script>";
				System.out.println("222222222222222222222222222222222222222222222");
				
			}
				
			out.print(htmlCode);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();			
		}
	}

}
