package step01.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cont")
public class LoginCheckController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		/*학습 내용
		 * 1. 쿠키 데이터 사용 시점에 대한 test
		 * 2. request 객체가 생성되는 시점에 브라우저에 Cookie 정보 존재 여부 확인 필수
		 * 3. 논리적으로 쿠키 생성 코드는 응답 완료되는 화면 이동 방식 사용
		 * 		(link, button 클릭, redirect)
		 * 
		 */
		
		
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemoteHost());
		if(id.equals("admin")) {
			/*
			// 데이터로 쿠키 객체 생성 -> 이부분에서 쿠키 저장이 안되서, else 문으로 넘겨야한다.
			
			Cookie c1 = new Cookie("data1", id); //data1이란 별칭으로 id값 저장하기. (cookie 임포트함)
			Cookie c2 = new Cookie("data2", request.getParameter("pw"));
			
			//life time 설정
			c1.setMaxAge(60*60*24*365); //초단위 설정. 
			c2.setMaxAge(60*60*24);
			
			//client 시스템에 전송해서 저장
			response.addCookie(c1); //몰래몰래 저장
			response.addCookie(c2);
			*/
			
			request.setAttribute("newData", "요청에 새로운 데이터 저장");
			request.getRequestDispatcher("succ").forward(request, response); //문제는 forward 하면 쿠키정보가 넘어가질 않음.
			
		} else {
			// 데이터로 쿠키 객체 생성. else 상에서 쿠키 관련 문법이 나와야함
			
						Cookie c1 = new Cookie("data1", id); //data1이란 별칭으로 id값 저장하기. (cookie 임포트함)
						Cookie c2 = new Cookie("data2", request.getParameter("pw"));
						
						//life time 설정
						c1.setMaxAge(60*60*24*365); //초단위 설정. 
						c2.setMaxAge(60*60*24);
						
						//client 시스템에 전송해서 저장
						response.addCookie(c1); //몰래몰래 저장
						response.addCookie(c2);
			
			response.sendRedirect("fail"); //새로운 respond 객체를 만드는 요청.
		}
	}

}

/* id가 유효하다면 id값이랑 pw를 client 시스템에 저장 
*/