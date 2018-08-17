package step02.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/succ2")
public class SuccessView extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			//이미 존재하는 HttpSession 객체를 받아옴
			//컨테이너(서버. 우리는 탐캣)로부터 id를 비교, 존재하면 반환, 없으면 새로 생성
			HttpSession session = request.getSession();
			
			//세션에 저장된 이름을 화면에 출력
			out.print(session.getAttribute("name") + "<br>");
			session.invalidate(); //세션 초기화. 세션 값이 없어짐 이걸 안하면 서버가 맛이 갈 수 있다.
			session = null;
			
			out.println("유효~~~<br>");
			out.println(request.getAttribute("newData"));
	
	}

}
