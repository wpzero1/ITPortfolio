package step01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cont")
public class LoginCheckController extends HttpServlet {
	
	//get or post 모든 방식을 처리하는 메소드, service. 재정의임.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client가 입력한 데이터 획득
		String id = request.getParameter("id");
		System.out.println(request.getRemoteAddr()); //ip추적
		System.out.println(request.getRemoteHost()); //ip추적
		
		//검증
		/* 유효한 경우
		 * 	- succ url과 매핑된 servlet으로 이동
		 * - forward
		 * 
		 * 무효한 경우
		 * 	 - fail url과 매핑된 servlet으로 이동
		 * 	 - redirect로 이동
		 */
		if(id.equals("admin")) {
			request.setAttribute("newData", "요청에 새로운 데이터 저장");
			//cont와 succ는 다른 servlet이긴 하나, 하나의 servlet으로 간주
			//요청, 응답 객체가 공유
			
			request.getRequestDispatcher("succ").forward(request, response);
			//request를 던진다 라는 느낌. 근데 이거를 forward로 넘어가게끔 하는데, 서버로 부터 받았던 request와 response를 받아서... 공유.
			
		} else {
			request.setAttribute("newData", "요청에 새로운 데이터 저장");
			//응답 완료, 응답시 새로 요청한 fail url 정보를 client 브라우저에 전송
			//fail로 새로운 요청을 브라우저가 자동 실행
			//fail에서는 새로운 요청 따라서 새로운 request, response를 새로 생성
			response.sendRedirect("fail");
		}
	}

}
