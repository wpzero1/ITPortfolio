package step02.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cont2")
public class LoginCheckController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		if(id!=null & id.equals("admin")) { //코난
			//새로운 세션 객체 생성 - 이 user에게 부여한 id값으로 비교해서 세션 객체 없었다?라면 생성.
			HttpSession session = request.getSession();
			//세션에 이름 저장
			session.setAttribute("name", "코난");
			request.setAttribute("newData", "요청에 새로운 데이터 저장");
			request.getRequestDispatcher("succ2").forward(request, response); 
		} else {
			response.sendRedirect("fail2"); 
		}
	}

}

/* id가 유효하다면 id값이랑 pw를 client 시스템에 저장 
*/