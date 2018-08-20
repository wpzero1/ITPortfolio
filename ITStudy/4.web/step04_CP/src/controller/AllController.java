/* 학습내용
 * 1. command pattern 반영한 controller
 * 2. 여러개의 요청을 하나의 controller가 받아서 구분 후
 * 		각 요청별 로직 처리
 * 3. 필요 로직
 * 		1) 요청 구분을 분기분(if와 같은 조건문장)
 * 		2) 각 로직 처리하는 별도의 사용자 정의 메소드를 구현
 * 		3) 요청별 사용자 정의 메소드 호출
 * 4. 실제 처리 로직 관점
 * 		1) 로그인 개발 단계
 * 			1] 로그인 요청인지 구분
 * 			2] id/pw 값 획득
 * 			3] 획득한 값의 존재 여부 체크
 * 				- null 여부, null이 아닐 경우 DAO의 로그인 로직 처리 메소드 호출
 * 			4] 실행 결과값(경우의 수)
 * 			  정상실행
 * 				1 존재한다 - name 값 반환
 * 					- 세션 생성
 * 					- 세션 이름값 저장
 * 					- SuccessView로 이름값 출력 위임(리다이렉트)
 * 
 * 				2 미존재한다 - null 값 반환
 * 			  비정상 실행
 * 				  예외 발생
 * 		2) 이름 변경
 */

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import model.domain.CustomerDTO;

public class AllController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		//login or rename or logout
	 //그리고 분기에 관련된 부분만 남기고, request response로 넘기게 구성함
		String command = request.getParameter("command");
		if(command.equals("login")) {		
			login(request, response);
		}else if(command.equals("rename")) {
			rename(request, response);
		}else if(command.equals("logout")) {
			logout(request, response);
		}else if(command.equals("all")){
			all(request, response);
		}else {
				response.sendRedirect("login.html");
		
		}
	}
	
	/*모든 검색 결과인 ArrayList를 획득 -> request에 저장 -> forward 방식으로 화면 이동
	 -> 단 로그인 안한 경우, 결과보기는 불가
	 로그인 전 - login.html로 화면 이동
	 로그인 후 - 모든 검색
	 로그인 여부 확인 - session에 name 존재 여부 확인
	 	검증은 controller? 모든 검색 결과 출력은 view?
	 	- getSession()
	 		1. blank or true인 경우 - 없으면 세션 생성, 있으면 유지
	 		2. false인 경우 - 없어도 생성 불가, 있어야만 받아옴
	 	HttpSession session = request.getSession(false);
	*/
	protected void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		if(session != null) { //이미 로그인 되어있음을 의미
			
		try {
			ArrayList<CustomerDTO> all = CustomerDAO.allsearch();
			if(all.size() ==0) {
				request.setAttribute("msg", "정보가 없습니다");
				request.getRequestDispatcher("msgView.jsp").forward(request, response);
			}else {
				session.setAttribute("allData", all);
				response.sendRedirect("allView.jsp");
			}
		} catch(Exception e) {
			request.setAttribute("msg", "검색 실패. 재시도하세요.");
			request.getRequestDispatcher("errorView.jsp").forward(request, response);
		}
			
		}else {//로그인 로직 skip
			response.sendRedirect("login.html");
		}
	}
	
	//로그인 처리 메소드도 만들자 (역시 위쪽에 service 메소드에 존재하던 login 관련 내용만 그대로 떼다가 가져왔다)
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			if(id != null && pw != null) {
				try {
					String name = CustomerDAO.loginCheck(id, pw);
					if(name != null) { //회원인 경우
						HttpSession session = request.getSession();
						session.setAttribute("name", name);
						
						response.sendRedirect("loginSucc.jsp");//jsp 파일로 바꿈
						
					}else { //미존재하는 경우
						//요청 객체에 "당신은 회원이 아닙니다"
						request.setAttribute("msg", "당신은 회원이 아닙니다"); //여기선 데이터를 굳이 세션에 저장할 필요가 없다. 그리고 request에 저장했으면, forward로 보낼 수 밖에 없음
						request.getRequestDispatcher("msgView.jsp").forward(request, response); //화면 전환(이동). request는 그대로 유지됨
						//jsp가 훨씬 유용,빠르다. 확장자 꼭 들어가야함
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login.html");
			}
	}
	
	protected void rename(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String newName = request.getParameter("newName");
		System.out.println(newName);
		
		if(id != null && newName !=null) {
			try {
				//result 값 선언
				boolean result = CustomerDAO.update(id, newName);
				
				//회원일 경우
				if(result == true) {
					HttpSession session = request.getSession();
					session.setAttribute("newName", newName);
					
					response.sendRedirect("renameview");
				}
				//비회원일 경우
				else {
					request.setAttribute("msg", "당신은 회원이 아닙니다");
					request.getRequestDispatcher("msgView.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//로그아웃 메소드
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이미 존재할 경우 반환 (위쪽에 있던 else if 로그아웃 이관했고, 위에서 그대로 받아옴. 리팩토링, 클린코드라고 부름.)
		//메소드를 이렇게 늘리는게 더 효과적이다.
		HttpSession session = request.getSession(); 
		session.invalidate();
		session = null;
		response.sendRedirect("byView.jsp");
	}
}
/*
 * url 변천사
http://ip:port/project명/login.html
http://ip:port/project명
http://ip:port/project명/cont
http://ip:port/project명/byView.jsp
http://ip:port/project명/msgView.jsp
 */
